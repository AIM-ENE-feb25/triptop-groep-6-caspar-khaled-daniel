# Ontwerpvraag
**Hoe maak je de applicatie uitbreidbaar met nieuwe bouwstenen?**

---

## Stap 1 – Keuze van Componenten

- **Frontend**: moet flexibel ontworpen zijn zodat nieuwe UI-componenten makkelijk toegevoegd kunnen worden.
- **Backend**: een architectuur waarmee je makkelijk nieuwe logica kunt toevoegen.
- **Database**: moet uitbreidbaar zijn voor nieuwe gegevens die met nieuwe bouwstenen meekomen (tabellen).

---

## Stap 2 – Componenten en Verantwoordelijkheid

### Component: `Frontend`

**Verantwoordelijkheid:**  
Biedt een uitbreidbare gebruikersinterface voor reiziger en reisagent. Nieuwe UI-componenten (zoals accommodaties en activiteiten) kunnen makkelijk worden toegevoegd.

---

### Component: `Backend`

**Verantwoordelijkheid:**  
Bevat uitbreidbare services voor verschillende onderdelen, zoals `AccommodatieService` en `ActiviteitService`. Elke service is verantwoordelijk voor eigen logica en kan apart worden toegevoegd.

---

### Component: `Database`

**Verantwoordelijkheid:**  
Bevat repositories voor verschillende entiteiten zoals accommodaties en activiteiten. Elke repository is uitbreidbaar en afgeschermd via een interface.

---

## Stap 3 – Methodes


### `Service`

- `execute(request): response`  
  Verwerkt logica zoals het boeken van een activiteit of ophalen van een accommodatie.
- `getType(): string`  
  Retourneert het servicetype (bijv. `"accommodatie"`, `"activiteit"`).

---

### `Repository`

- `save(entity)`  
  Slaat een entiteit (zoals `Activiteit` of `Accommodatie`) op.
- `findById(id): entity`  
  Haalt één entiteit op.
- `findAll(): lijst`  
  Haalt een lijst van entiteiten op.

---

## Stap 4 – Samenwerking tussen Componenten (Coupling)

**Voorbeeldscenario: gebruiker boekt een activiteit**

2. Gebruiker klikt op "Boek activiteit" op de `Frontend`  .
3. Frontend stuurt data naar `ActiviteitController`.
4. Controller roept `ActiviteitService` aan.
5. `ActiviteitService` haalt activiteitdetails op via `TripAdvisorAdapter`.
6. Boeking wordt opgeslagen via `ActiviteitRepository`.
7. De status wordt teruggegeven aan de frontend.

**Voorbeeldscenario: gebruiker boekt een accommodatie**

2. Gebruiker klikt op "Boek accommodatie" op de `Frontend`.
3. Frontend stuurt data naar `AccommodatieController`.
4. Controller roept `AccommodatieService` aan.
5. `AccommodatieService` haalt accommodatiedetails op via `AirBnbAdapter`.
6. Boeking wordt opgeslagen via `AccommodatieRepository`.
7. De status wordt teruggegeven aan de frontend.

