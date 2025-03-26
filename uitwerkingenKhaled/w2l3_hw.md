## Ontwerpvraag
Hoe maak je de applicatie uitbreidbaar met nieuwe bouwstenen?

## Stap 1

- Frontend: moet flexibel ontworpen zijn zodat nieuwe UI componenten makkelijk toegevoegd kunnen worden
- Backend: een modulaire architectuur (services) waarmee je makkelijk nieuwe logicakunt toevoegen
- Database: moet uitbreidbaar zijn voor nieuwe gegevens die met nieuwe bouwstenen meekomen (tabellen)

## Stap 2



### Component: `TravelUI` (Frontend)

**Verantwoordelijkheid:**  
Biedt een uitbreidbare gebruikersinterface voor reiziger en reisagent. Nieuwe UI-componenten kunnen 'makkelijk' worden toegevoegd.

- **Encapsulate What Varies:** De UI per functionaliteit (bijvoorbeeld: nieuwe typen reizen of extra zoekfilters).
- **Single Responsibility:** Alleen verantwoordelijk voor weergave en gebruikersinteractie.
- **Cohesion:** Alle UI-gerelateerde taken zijn gegroepeerd.
- **Separation of Concerns:** Geen logica of data-opslag, enkel presentatie.

---

### Component: `TravelCore` (Backend)

**Verantwoordelijkheid:**  
Verwerkt bedrijfslogica en coördineert interactie met externe systemen en de database via services. Ontworpen op een manier om 'makkelijk' nieuwe functionaliteiten toe te voegen.

- ***Encapsulate What Varies:** Verschillende soorten logica (bijv. boeking, validatie, prijsberekening).
- **Single Responsibility:** Alleen verantwoordelijk voor verwerking van logica en data.
- **Cohesion:** Bevat enkel bedrijfslogica en service-coördinatie.
- **Separation of Concerns:** Alleen verwerking van data
---

### Component: `TravelStore` (Database)

**Verantwoordelijkheid:**  
Beheert en slaat alle gegevens met betrekking tot reizen, gebruikers en boekingen op. Ontworpen met uitbreidbaarheid in gedachten, zodat tabellen voor nieuwe bouwstenen 'makkelijk' toegevoegd kunnen worden.

- ***Encapsulate What Varies:** Verschillende datamodellen (zoals reizen, pakketten, betalingen).
- **Single Responsibility:** Alleen verantwoordelijk voor persistente opslag van data.
- **Cohesion:** Beperkt tot opslag en ophalen van gegevens.
- **Separation of Concerns:** Alleen opslaan van data.

## Stap 3


### Component: `TravelUI`

**Interface:** `TravelUIComponent`

#### Methoden:
- `render(data): component`: toont de component met meegegeven data.

---

### Component: `TravelCore`

**Interface:** `TravelService`

#### Methoden:
- `execute(request): response`: voert logica uit (bijv. boeken, prijs berekenen, etc.).
- `getType(): string`: geeft het type service terug.

---

### Component: `TravelStore`

**Interface:** `TravelRepository`

#### Methoden:
- `save(entity)`: slaat een entiteit op.
- `findById(id): entity`: haalt een entiteit op via ID.
- `findAll(): lijst`: geeft alle entiteiten terug van een bepaald type.

## Stap 4: Samenwerking tussen Componenten (Coupling)

Doel: Beschrijven in welke volgorde componenten met elkaar communiceren om een taak uit te voeren.  
Voorbeeldscenario: Reiziger boekt een reis.

---

### Volgorde van aanroepen (reis boeken)

1. `TravelUI` toont het boekingsformulier aan de gebruiker.
2. Gebruiker vult gegevens in en klikt op "Boek reis".
3. `TravelUI` stuurt de gegevens naar `TravelCore`.
4. `TravelCore` bepaalt welke services nodig zijn (bijv. `BookingService`, `PaymentService`).
5. `TravelCore` voert logica uit via  `TravelService` implementaties.
6. Services gebruiken `TravelStore` om data op te slaan of op te halen.
7. `TravelCore` stuurt resultaat (bevestiging, foutmelding) terug naar `TravelUI`.
8. `TravelUI` toont de uitkomst aan de gebruiker.

---

