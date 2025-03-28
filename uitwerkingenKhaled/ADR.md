**Date:** 21-03-2025

# Status
 Undecided
# Context

Voor Triptop willen we reizigers de mogelijkheid bieden om een accommodatie te boeken. Hiervoor zoeken we een bron waarbij de reiziger zijn overnachting(en) kan samenstellen op basis van zijn behoefte(s).

# Considered Options

| Forces                          | Airbnb | Booking          |
|---------------------------------|------------|-----------------------|
| Beschikbaarheid                 | ++         | ++                    |
| Filter                          | ++         | +                     |
Dekkingsgraad (aantal steden/regio's) | +                          | ++  
| Flexibele data (voorzieningen, foto's, reviews) | ++         | ++                     |


**Keuze mogelijkheden**  
Airbnb en Booking.com zijn bekende namen in de reisbranche.

**Keuze criteria**  
- **MustHave** – Real-time beschikbaarheid van accommodaties  
- **MustHave** – Mogelijkheid tot filteren op prijs en voorzieningen  
- **ShouldHave** – Mogelijkheid om bijna overal op de wereld een overnachting te boeken


## Decisions

Twee mogelijke routes:

**Optie 1:**  
**Airbnb**  
**Voordelen:**  
- Veel reizigers geven de voorkeur aan een verblijf in een woonhuis of appartement i.p.v. een hotel.  
- Airbnb biedt meer accommodaties voor grote groepen.
- Airbnb is hierin de marktleider en biedt veel unieke accommodaties.  


**Nadelen:**  
- Minder conventionele hotels beschikbaar.  
- Minder geschikt voor zakelijke reizigers die hotels prefereren.

---

**Optie 2:**  
**Booking.com**  
**Voordelen:**  
- Booking.com is de nummer 1 site voor het boeken van hotels.  
- Biedt ook aanvullende diensten zoals vluchten en huurauto’s.  
- Als we Booking ook voor de andere onderdelen gebruiken (vlucht, auto), is het handig om alles via één API te integreren.  

**Nadelen:**  
- Minder unieke accommodaties zoals huizen of appartementen.  

**Optie 3:**
**Booking.com & Airbnb**
**Voordelen:** 
- Gebruiker kan zelf kiezen bij welke provider die een accommodatie wil zoeken.
- Grotere Dekking
- Meer types accommodaties

**Nadelen:**  
-Twee verschillende API's betekent dubbele integratie
- Verschillende datastructuren (bijv. filters, reviews, prijsformaten) moeten worden gestandaardiseerd
- Verschillende gebruikerservaringen binnen dezelfde flow kunnen verwarrend zijn voor de gebruiker.

 # Decision
We kiezen voor **Airbnb API** als primaire bron voor het aanbieden van accommodaties.

**Waarom Airbnb?**  
Airbnb biedt uitgebreide filtermogelijkheden waarmee gebruikers hun verblijf nauwkeurig kunnen afstemmen op hun wensen. Zo kunnen ze eenvoudig accommodaties zoeken met specifieke voorzieningen zoals een keuken, zwembad of wasmachine. Daarnaast maakt het platform direct contact met de host mogelijk, waardoor reizigers extra informatie kunnen opvragen of specifieke vragen kunnen stellen over het verblijf.


Booking.com blijft eventueel een optie voor toekomstig gebruik, bijvoorbeeld voor het combineren van andere diensten zoals vluchten en huurauto’s via één platform.

# Consequences

- Beperkt aanbod aan conventionele hotels.
- Afwijkende annuleringsvoorwaarden per accommodatie, wat verwarrend kan zijn voor gebruikers.
- Minder geschikt voor last-minute boekingen, waar hotels (zoals via Booking.com) doorgaans meer beschikbaarheid hebben.
- Prijsvergelijking wordt moeilijker, omdat Airbnb meestal geen hotels aanbiedt en gebruikers geen directe vergelijking kunnen maken tussen hotel en woningaccommodaties.



