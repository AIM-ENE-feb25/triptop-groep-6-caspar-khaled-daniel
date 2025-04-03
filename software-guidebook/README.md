# Software Guidebook Triptop

## 1. Introduction
Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende: 
1. De vereisten, beperkingen en principes. 
1. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software. 
1. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
1. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd. 

## 2. Context

![ContextDiagram](../DiagramFolder/ContextDiagram.png)

Op basis van de casus hebben wij een contextdiagram opgesteld om een eerste beeld te geven van de applicatie. Hierin is te zien met wie de applicatie allemaal praat, gebruikers en externe systemen. Ook is de functionaliteit aangegeven van de applicatie en de externe systemen. 

Allereerst zijn er 2 gebruikers aanwezig die gebruik kunnen maken van het systeem. De gebruiker wil een reis samenstellen en doet dit door gebruik te maken van het systeem. Ook is er een reisagent die twee functies heeft. Hij kan hulp bieden bij het samenstellen van een reis voor de gebruiker. Ook kan de reisagent een reispakket maken. Dit is een pakket dat de reisagent maakt als voorbeeldreis en deze kan de gebruiker dan gebruiken. Dit houdt in dat hij deze reis kan kiezen en zo nodig aanpassen naar zijn wensen. 

Verder maakt het systeem gebruik van verschillende externe systemen. Deze systemen hebben allemaal hun eigen functie voor het systeem. Zo zijn er externe systemen voor alle bouwstenen binnen de applicatie. Verder is er een identity provider om in te loggen in de applicatie. Ook is er nog een betalingssysteem om de reis te betalen.

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

###  Single Responsibility Principle (SRP)
Elke klasse in de applicatie heeft een duidelijke verantwoordelijkheid. Zo is de `VluchtService` verantwoordelijk voor de logica rond het zoeken en boeken van vluchten, terwijl de verschillende adapterklassen zich richten op communicatie met externe API’s. Hierdoor blijft de code overzichtelijk en eenvoudiger te onderhouden.
 
### Open/Closed Principle (OCP)
Het systeem is ontworpen volgens het principe dat het *open staat voor uitbreiding*, maar *gesloten is voor aanpassing*. Nieuwe bouwstenen en externe services kunnen eenvoudig worden toegevoegd, zonder dat bestaande code aangepast hoeft te worden.
 
###  Encapsulate What Varies (EWV)
De delen van het systeem die gevoelig zijn voor verandering, zijn bewust geïsoleerd in aparte klassen. Alle adapters implementeren het `IExternVluchtAdapter` interface, waardoor hun specifieke logica volledig losstaat van de rest van het systeem. Dit maakt het mogelijk om elke adapter te onderhouden of aan te passen, zonder impact op andere onderdelen van de applicatie.

 
###  Program to Interfaces, Not Implementations
Binnen de `VluchtService` wordt gewerkt met het `IExternVluchtAdapter`-interface in plaats van met implementaties zoals `KLMAdapter` of `SkyscannerAdapter`. Hierdoor blijft de serviceklasse flexibel en losgekoppeld van specifieke adapters, wat het vervangen of uitbreiden van functionaliteit vereenvoudigt.

## 7. Software Architecture

###     7.1. Containers


![ContainerDiagram](../DiagramFolder/ContainerDiagram.png)

Op basis van het contextdiagram hebben wij een container diagram gemaakt. Dit diagram laat de verschillende containers binnen het systeem zien. Zo hebben wij een frontend gemaakt in react. Deze communiceerd met de backend, geschreven in Java Springboot. De backend communiceerd vervolgens nog met de database om data op te slaan over een reis.

Verder is er ten opzichte van het context diagram een verschil te zien in hoe het systeem communiceerd met externe services. Zo zijn er zowel externe services die met de frontend praten maar ook services die met de backend praten. Wij hebben hiervoor een keuze gemaakt binnen onzen groep en deze is beschreven in "[8.3. Externe service toevoegen](#83-externe-service-toevoegen)"

Verder hebben wij de communicatie voor twee verschillende externe services toegevoegd als voorbeeld. Deze zijn hieronder te zien met de bijbehorende uitleg.

![SequentieDiagramInloggen](../DiagramFolder/SequentieDiagramInloggen.png)

Allereerst is er een sequentiediagram gemaakt als voorbeeld voor het inloggen hier is te zien hoe de gebruiker probeert in te loggen via de frontend. Vervolgens wordt dit doorgestuurd naar de backend en dan naar wiremock. Als de gegevens juist zijn wordt de gebruiker ingelogd en wordt er een token opgeslagen in de frontend.

![SequentieHuurAutosDiagram](../DiagramFolder/SequentieDiagramRentalCars.png)

Het tweede voorbeeld wat wij hebben verwerkt in een sequentie diagram is het huren van een auto. Dit is een complexer voorbeeld dan de eerste maar laat goed zien wat de algemene flow is van het communiceren met een externe service van een bouwsteen. Hierin is goed te zien dat een reiziger iets wilt huren, in dit geval een auto. Dit verzoek wordt doorgestuurd naar de backend en wordt vervolgens opgeslagen in de database voor de reisagent. Als de reisagent de webapplicatie opent, kan hij zien dat er een verzoek is van een reiziger voor een auto. De reisagent kan dan een aantal geschikte auto's uitzoeken en deze op slaan in de database voor de gebruiker. Tot slot kan de gebruiker dan een offerte uitkiezen en dit wordt dan opgeslagen in de database als de gekozen auto. 

Dit voorbeeld is een voorbeeld waarin ook de rol van de reisagent wordt beschreven. Er zijn ook situaties met andere externe systemen waarin de reisagent geen rol heeft. Hierin maakt de gebruiker zelf contact met de externe service om bijvoorbeeld vluchten te zoeken. Vervolgens krijgt de gebruiker dan ook gelijk zelf alle data terug om een vlucht uit te kiezen.

##     7.2. Components

###    7.2.1 Bouwstenen toevoegen

![componentdiagram](../DiagramFolder/componentDiagramBouwsteen.svg)

###    7.2.2 Externe services toevoegen

![componentdiagram](../DiagramFolder/componentDiagramExterneServices.svg)

###    7.2.3 Niet beschikbare services

![componentdiagram](../DiagramFolder/componentDiagramFallback.svg)

###    7.2.4 Samengevoegd component diagram

![componentdiagram](../DiagramFolder/componentdiagram.svg)

##     7.3. Design & Code

![classDiagramOvernachtingen](../DiagramFolder/classDiagramOvernachtingenFallback.png)

###    7.3.1 Bouwstenen toevoegen 

###    7.3.2 Externe services toevoegen

![classDiagramExterneServices](../DiagramFolder/classDaigramExterneServices.svg)

Dit klassediagram is gemaakt en gecorrigeerd naar aanleiding van het gemaakte prototype "[8.3. Externe service toevoegen](#83-externe-service-toevoegen)". Naar aanleidng van de 1e verie is de repository verwijderd omdat dit geen toegevoegde waarde had voor het prototype. 

Verder is dit ontwerp gemaakt op basis van het adapter pattern om te communiceren met alle api's. Elke api krijgt zijn eigen adapterklasse om de unieke manier van communiceren te gebruiken. Ook is er gebruik gemaakt van een factoryklasse. Dit houdt in dat deze factory gebruikt wordt om een specifieke api te gebruiken. Bij het boeken moet er een specifieke api gekozen worden om de vlucht te boeken en deze wordt gekozen door de frontend en gebruikt door de factory om deze aan te wijzen aan de service. Hieronder in het sequentiediagram is het volledige pad te zien voor het zoeken en boeken van een vlucht volgens dit prototype.

![sequentieDiagram](../DiagramFolder/SequentieDiagramExterneServices.svg)

In dit diagram is te zien hoe de flow van het systeem werkt. De frontend stuurt een verzoek naar de controller om vluchten te zoeken. Deze controller geeft dit door aan de vluchtservices die vervolgens ij alle adapters langsgaat om de vluchten op te zoeken. Deze adapters zoeken via een vertek, bestemming en de datum vervolgens alle beschikbare vluchten. De lijst met alle vluchten van alle adapters wordt vervolgens terug gestuurd naar de frontend.

Daarnaast kan de frontend ook een vlucht object sturen naar de backend om een vlucht te boeken. Dit object wordt naar de controller gestuurd die het doorgeeft aan de service. De service haalt de naam van de gebruikte api voor de vlucht uit het object en stuurt dit naar de factory. De factory haalt via spring dependency injection een lijst op met alle beschikbare adapters, geimplementeerd volgens de interface. Vervolgens zoekt de factory de juiste adapter volgens de meegegeven api van de service en stuurt de correcte adapter terug naar de service. Tot slot stuurt de service het vlucht object door naar de correcte adapter die een boeking plaatst bij de api. Daarna wordt er feedback terug gegeven naar uiteindelijk de frontend.

###   7.3.3 Niet beschikbare services

## 8. Architectural Decision Records

# 8.1 Waar worden de requests naar externe API's gedaan? **Date:** 03-04-2025
 
## Status
 
Accepted
 
## Context
 
We gaan onderzoeken waar de API calls het beste kunnen worden uitgevoerd, is dit in de front-end, back-end of allebij. Het doel is om de producite snelheid zo hoog mogelijk te houden door de datastromen te minimaliseren. Ook letten we op dubbele communicatie met een API.
 
## Considered Options
 
Waarom kunnen de API's niet op de front-end?
- Bij betalingen moet je bepaalde gegevens verifiëren en hiervoor heb je de back-end nodig.
 
Voorbeeld Omio:
Als we eerst info op willen halen hebben we geen back-end nodig maar in een later stadium willen we wel kunnen betalen bij Omio en hiervoor is de backend nodig.
 
## Decision
 
Extern systeem communiceert alleen met de frontEnd als de backend nooit een de API call hoeft te maken met de desbetreffende externe service.
 
## Consequences
 
- Wanneer je API verzoeken hebt waarbij sommige verzoeken bestemd zijn voor de front-end en andere voor de back-end, zal je extra communicatie met de back-end nodig hebben om de informatie te krijgen.



> [!IMPORTANT]
> Voeg toe: 3 tot 5 ADR's die beslissingen beschrijven die zijn genomen tijdens het ontwerpen en bouwen van de software.

# 8.2 Huur Auto's
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


# 8.3 ADR-002 **Date:** 21-03-2025
 

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

# 8.4 Externe service toevoegen

28-03-2025


## Context

Voor triptop moeten er makkelijk nieuwe api's kunnen worden toegevoegd aan bestaande bouwstenen. Dit betekend dat op basis van de bestaande code, een nieuwe api aangesloten kan worden op deze code en direct werkt zonder de rest van de code aan te passen.

## Considered Options

Voor dit probleem is er één oplossing bedacht. Deze oplossing is ontworpen via de adapter en factory patterns en is uitgewerkt in het klassediagram hieronder.

![ClassDiagram](../DiagramFolder/classdiagramDaniel.svg)

In dit diagram is te zien dat alle adapters gebruik maken van een adapter interface, gemaakt volgens het adapter pattern. Deze interface geeft alle methodes die door een adapter moeten worden geimplementeerd. Verder maakt de service klasse gebruik van een adapterfactory om zo nodig één van de adapters te kiezen voor een api-verzoek. Dit gaat volgens het factory pattern. Door gebruik te maken van deze twee patterns hoeft een nieuwe api alleen een adapter te maken die de adapter interface implementeerd. Hierdoor wordt deze nieuwe adapter automatisch gebruikt door de serviceklasse en kan de adapterfactory ook deze adapter kiezen voor gebruik.

## Decision

Doormiddel van een prototype hebben we bewezen dat dit ontwerp volledig werkt. Dit betekend dus dat een nieuwe service kan worden toegevoegd door een klasse te maken die de interface implementeerd en contact maakt met de api. Door alleen deze klasse correct te maken kan de service automatisch gebruik maken van deze nieuwe adapter en api.

Wel is er tijdens het bouwen van het prototype nog een aantal aanpassingen gedaan in de code. Zo is er een getApi() toegevoegd om makkelijk aan de namen van de api's te komen. Hierdoor kan de factory automatisch zoeken op alle api's en de juiste api terug geven voor gebruik. 

Verder is de repository klasse niet gemaakt omdat dit niks toevoegd aan de vraagstelling.

Dus doormiddel van dit prototype is aangetoond dat dit ontwerp ook in de praktijk gebruikt kan worden.


## Status

accepted

## Consequences

> [!TIP]
> This section describes the resulting context, after applying the decision. All consequences should be listed here, not just the "positive" ones. A particular decision may have positive, negative, and neutral consequences, but all of them affect the team and project in the future.

# 8.5 Hoe maak je de applicatie uitbreidbaar met nieuwe bouwstenen **Date:** 28-03-2025


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
 
# 8.6 Hoe ga je om met aanroepen van externe services die niet beschikbaar zijn en toch verwacht wordt dat er waardevolle output gegeven wordt? **Date:** 28-03-2025

## Context
 
Voor de API calls willen we een manier zodat er een fallback is wanneer de request mislukt. Hierbij moet er gedacht worden aan flexibiliteit in de requests.
 
## Considered Options
 
Wanneer er API call gedaan wordt en de call faalt wil ik een fallback. Dit betekent dat ik zelf kan kiezen hoevaak de call opnieuw geprobeerd wordt en indien mijn keuze van calls falen er message/andere oplossing wordt gehanteerd.
 
### Spring Cloud Circuit Breaker
 
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
 
## Decision
 
 
## Consequences

# 9. Deployment, Operation and Support

> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.