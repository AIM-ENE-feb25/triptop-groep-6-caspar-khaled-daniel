# Software Guidebook Triptop

## 1. Introduction
Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende: 
1. De vereisten, beperkingen en principes. 
1. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software. 
1. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
1. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd. 

## 2. Context

![ContextDiagram](../DiagramFolder/ContextDiagram.png)

> Werk zelf dit hoofdstuk uit met context diagrammen en een beschrijving van de context van de software.

Toelichting op de context van de software inclusief System Context Diagram:
* Functionaliteit
* Gebruikers
* Externe systemen

## 3. Functional Overview

Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt en een overzicht van het domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit voorbeeld.

### 3.1 User Stories

#### 3.1.1 User Story 1: Reis plannen

Als gebruiker wil ik een zelfstandig op basis van diverse variabelen (bouwstenen) een reis kunnen plannen op basis van mijn reisvoorkeuren (wel/niet duurzaam reizen, budget/prijsklasse, 's nachts reizen of overdag etc.) zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.2 User Story 2: Reis boeken

Als gebruiker wil ik een geplande reis als geheel of per variabele (bouwsteen) boeken en betalen zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.3 User Story 3: Reis cancelen

Als gebruiker wil ik een geboekte reis, of delen daarvan, kunnen annuleren zodat ik mijn geld terug kan krijgen zonder inmenging van een intermediair zoals een reisbureau.

#### 3.1.4 User Story 4: Reisstatus bewaren 

Als gebruiker wil ik mijn reisstatus kunnen bewaren zonder dat ik een extra account hoef aan te maken zodat ik mijn reis kan volgen zonder dat ik daarvoor extra handelingen moet verrichten.

#### 3.1.5 User Story 5: Bouwstenen flexibel uitbreiden

Als gebruiker wil ik de bouwstenen van mijn reis flexibel kunnen uitbreiden met een zelf te managen stap (bijv. met providers die niet standaard worden aangeboden zoals een andere reisorganisatie, hotelketen etc.) zodat ik mijn reis helemaal kan aanpassen aan mijn wensen.

### 3.2 Domain Story Reis Boeken (AS IS)

![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Story Reis Boeken (TO BE)

![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.4 Domain Model

![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

## 4. Quality Attributes

Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd als belangrijk:
* Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other products and mutually use the information that has been exchanged)
* Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of hardware or software faults)
* Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such that a change to one component has minimal impact on other components)
* Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified without introducing defects or degrading existing product quality)
* Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data are protected from unauthorized modification or deletion either by malicious action or computer error)
* Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to those authorized to have access)

## 5. Constraints

> [!IMPORTANT]
> Beschrijf zelf de beperkingen die op voorhand bekend zijn die invloed hebben op keuzes die wel of niet gemaakt kunnen of mogen worden.

## 6. Principles

> [!IMPORTANT]
> Beschrijf zelf de belangrijkste architecturele en design principes die zijn toegepast in de software.

## 7. Software Architecture

###     7.1. Containers


![ContainerDiagram](../DiagramFolder/ContainerDiagram.png)

###     7.2. Components

![componentdiagram](../DiagramFolder/componentdiagram.svg)

![SequentieHuurAutosDiagram](../DiagramFolder/SequentieDiagramRentalCars.png)
![SequentieDiagramInloggen](../DiagramFolder/SequentieDiagramInloggen.png)

###     7.3. Design & Code

![classDiagramOvernachtingen](../DiagramFolder/classDiagramOvernachtingenFallback.png)

## 8. Architectural Decision Records

> [!IMPORTANT]
> Voeg toe: 3 tot 5 ADR's die beslissingen beschrijven die zijn genomen tijdens het ontwerpen en bouwen van de software.

# 8.1. Huur Auto's
Date: 21-03-2025

# Status

Undecided

# Context

Voor Triptop willen we de reiziger de mogelijkheid bieden om een auto te huren. We hebben hierbij de geo-locatie nodig en een aanbod aan auto's.

# Considered Options

| Forces      | Tripadvisor | Wolt | Booking |
| ----------- | ----------- | ---- | ------- |
| GeoLocatie | ++ | Geen API | ++ |
| Hoeveelheid autos | -- Laat niet alle auto's zien in een bepaald gebied | Geen API | -- Laat niet alle auto's zien in een bepaald gebied |
| Prijs klasse keuze | - Op te halen maar het hangt van 8 verschillende factoren af | Geen API | ++ Makkelijk de prijs te zien |

*Keuze mogelijkheden*
Tripadvisor, Wolt en Booking zijn al bekend als grote spelers op de markt, vandaar dat we alleen deze twee proberen.

*Keuze criteria* 
MustHave - Geo-locatie - Te laten zien op de kaart
ShouldHave - Hoeveelheid autos beschikbaar - Groter aanbod voor de reizig
ShoudlHave - Prijs klasse keuze - Betere keuze maken voor elke reiziger per prijs klasse

## Andere optie
Booking.com heeft op de site zelf we een goed systeem voor car rental alleen hiervoor zijn nog geen goeie API's beschikbaar om de data op te halen. Wij zouden dus zelf een API hiervoor moeten bouwen.

# Decision

Er zijn twee mindere opties mogelijk nu.

Optie 1:
We bouwen zelf een API die dit doet. Nadeel hiervan is dat wij niet weten hoe dit werkt en of dit mogelijk is

Optie 2:
Zij geven Reizigers de optie om met een Reisagent te communiceren die voor hun helpt handmatig een huur auto uit te kiezen.

# Consequences

Optie 1:
We bieden geen API aan en de reisAgent zal tussen het rental car bedrijf en de reiziger staan om ze hierin te helpen.

Optie 2:
We moeten geld/tijd/werk investeren om een API hiervoor te maken of een bestaande API betalen om bepaalde requests toe te voegen. Ook weten we niet of dit kan kwa wetten en of Booking.com dit toelaat


# 8.2. ADR-002 **Date:** 21-03-2025
 

## Status
 Undecided
## Context

Voor Triptop willen we reizigers de mogelijkheid bieden om een accommodatie te boeken. Hiervoor zoeken we een bron waarbij de reiziger zijn overnachting(en) kan samenstellen op basis van zijn behoefte(s).

## Considered Options

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

 ## Decision
We kiezen voor **Airbnb API** als primaire bron voor het aanbieden van accommodaties.

**Waarom Airbnb?**  
Airbnb biedt uitgebreide filtermogelijkheden waarmee gebruikers hun verblijf nauwkeurig kunnen afstemmen op hun wensen. Zo kunnen ze eenvoudig accommodaties zoeken met specifieke voorzieningen zoals een keuken, zwembad of wasmachine. Daarnaast maakt het platform direct contact met de host mogelijk, waardoor reizigers extra informatie kunnen opvragen of specifieke vragen kunnen stellen over het verblijf.


Booking.com blijft eventueel een optie voor toekomstig gebruik, bijvoorbeeld voor het combineren van andere diensten zoals vluchten en huurauto’s via één platform.

## Consequences

- Beperkt aanbod aan conventionele hotels.
- Afwijkende annuleringsvoorwaarden per accommodatie, wat verwarrend kan zijn voor gebruikers.
- Minder geschikt voor last-minute boekingen, waar hotels (zoals via Booking.com) doorgaans meer beschikbaarheid hebben.
- Prijsvergelijking wordt moeilijker, omdat Airbnb meestal geen hotels aanbiedt en gebruikers geen directe vergelijking kunnen maken tussen hotel en woningaccommodaties.





# 8.3. Externe service toevoegen

28-03-2025


## Context

Voor triptop moeten er makkelijk nieuwe api's kunnen worden toegevoegd aan bestaande bouwstenen. Dit betekend dat op basis van de bestaande code, een nieuwe api aangesloten kan worden op deze code en direct werkt zonder de rest van de code aan te passen.

## Considered Options

Voor dit probleem is er één oplossing bedacht. Deze oplossing is ontworpen via de adapter en factory patterns en is uitgewerkt in het klassediagram hieronder.

![ClassDiagram](../DiagramFolder/classdiagramDaniel.svg)

In dit diagram is te zien dat alle adapters gebruik maken van een adapter interface, gemaakt volgens het adapter pattern. Deze interface geeft alle methodes die door een adapter moeten worden geimplementeerd. Verder maakt de service klasse gebruik van een adapterfactory om zo nodig één van de adapters te kiezen voor een api-verzoek. Dit gaat volgens het factory pattern. Door gebruik te maken van deze twee patterns hoeft een nieuwe api alleen een adapter te maken die de adapter interface implementeerd. Hierdoor wordt deze nieuwe adapter automatisch gebruikt door de serviceklasse en kan de adapterfactory ook deze adapter kiezen voor gebruik.

## Decision

> [!TIP]
> This section describes our response to the forces/problem. It is stated in full sentences, with active voice. "We will …"

## Status

> [!TIP]
> A decision may be "proposed" if the project stakeholders haven't agreed with it yet, or "accepted" once it is agreed. If a later ADR changes or reverses a decision, it may be marked as "deprecated" or "superseded" with a reference to its replacement.

## Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

# 8.4. Hoe maak je de applicatie uitbreidbaar met nieuwe bouwstenen **Date:** 28-03-2025


## Ontwerpvraag
**Hoe maak je de applicatie uitbreidbaar met nieuwe bouwstenen?**

## Context

De applicatie moet kunnen omgaan met verschillende soorten bouwstenen. Met nadruk op aanpassingen in code te minimilasiren bij het toevoegen van een nieuwe bouwesteen.
## Consideren Option
**Strategy**
![alt text](classDiagramStrategy.svg)

## Decision

Ik heb gekozen voor de **Strategy** design pattern. Dit vanwege de volgende redenen:
- Nieuwe functionaliteit zonder bestaande code aan te passen
- Gedrag wordt geïnjecteerd (los van service) --> lange koppeling en hoge cohesion.
- Makkelijk te testen -> elke strategy heeft een aparte klasse met een specifiek verantwoordelijkheid


Nadeel van dit allemaal is dat je veel klasses krijgt.

## Consequences
- Nieuwe bouwstenen kunnen eenvoudig worden toeggevoegd.
- Elke strategy is los te testen
- Responsibility seperation: Services = workdflow. strategys = logica.
- Alleen strategy wijzigen bij wijzigingen van externa API'S 
Date: 28-03-2025
 
# Status
 
In progress
 
# Context
 
Voor de API calls willen we een manier zodat er een fallback is wanneer de request mislukt. Hierbij moet er gedacht worden aan flexibiliteit in de requests.
 
# Considered Options
 
Wanneer er API call gedaan wordt en de call faalt wil ik een fallback. Dit betekent dat ik zelf kan kiezen hoevaak de call opnieuw geprobeerd wordt en indien mijn keuze van calls falen er message/andere oplossing wordt gehanteerd.
 
## Spring Cloud Circuit Breaker
 
Deze lijst is tot stand gekomen door geeksforgeeks en medium searches. Ik ga alleen voor Hystrix even kort laten zien hoe het werkt. Ook is dit gebruikt: https://www.mymiller.name/wordpress/spring_circuit_breaker/choosing-the-right-circuit-breaker-a-comparison-of-implementations/
 
### Hystrix
Wordt niet meer geupdate maar wordt nog veel gebruikt
config file manier:
    hystrix:
    command:
        "methodname":
        circuitBreaker:
            requestVolumeThreshold: 10
 
Coding manier:
    HystrixCommandProperties.Setter()
  .withCircuitBreakerErrorThresholdPercentage(int value)\
 
Op deze manieren kan per API kiezen hoeveel request je wil doen. Ook kan je de % van fails aangeven. Ook heb je een optie voor hoelang de circuit dicht blijft
 
## Diagram
| Forces | Hystrix | Resilience4J | Sentinal |
| -----  | ----    | -----        | -----    |
| Wordt actief geupdate | - | + | + |
| Maakt gebruik van een RequestVolumeThreshold | + | + | + |
| Maakt gebruik van een FailreRateThreshold | + | + | + |
| Maakt gebruik van een waitDurationInOpenState | + | + | + |
| Maakt gebruik van een slidingWindowSize | + | + | + |
 
Hystrix valt al af omdat het niet geupdate wordt wat nu goed is maar niet handig is om mee bezig te gaan omdat dit een langdurig project is. Daarnaast hebben beide Forces de basis benodigdheden
 
Resilience is makkelijk te implementeren. Minimal dependencies. Customization and flexible. relatief nieuw.
 
Sentinel
Limited support met Java. Niet direct geimplementeerd
 
## Keuze prototype
Mijn keuze voor het prototype wordt Resilience.
 
# Decision
 
 
# Consequences

## 9. Deployment, Operation and Support

> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.