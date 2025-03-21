Container Diagram
-Zoemt in op Database
-Zoemt in op Browser

-Aparte blokken voor elk process (aparte programma's)
-Een person moet met de juiste container interacten
-Rol van de container moet zinnig/goed zijn
-Intern systeem bouw jezelf
-Extern systeem bouw je zelf niet(configuratie kan wel)
-Er kunnen geen pijlen heen en weer gaan
-Waar als eerste communicatie begint daar begint de pijl
-Zet technologie keuzes erin
	--container zet je eronder -> node.js, MongoDb, React
	--Relaties (REST, JSON, SQL, HTTPS)


API's:
UberEATS API -> 43sec(te lang) - data van restaurants op
TripAdvisor -> Hotels, Flights, Restaurants, vacation rentals, cruisers, rental cars
Booking 
flights sky -> hotels, flights, car rental
Tourist attraction -> Museums, landmarks, Tours and guides
TrailApi -> Trails and hikes for outdoor recreational use
Mailgun, send validate receive and tracks emails
Textflow SMS API -> sending text messages and veryifying phone numbers
Microsoft authenticator

--
Gemaakte keuzes:
2 verschillende Webapplicaties voor Reiziger en ReisAgent of 1 webapplicatie voor beiden?
    - Voor nu 1webapplicatie maar indien later nodig kunnen we altijd naar 2 verschillende frontends.
Alle externe system naar de backend of sommige direct naar de frontend?
    - Extern systeem communiceert ALLEEN met de frontEnd ALS de backend NOOIT een de API call hoeft te doen
Als we in de backend een Omio hebben waarbij we eerst info willen halen en daarna met een andere call betalen
    - Geven we in een zin beide calls aan
Bij diagrammen met datastromen proberen we het woord terug te gebruiken wnr de data terug stroomt
Bij het ContainerDiagram voor inloggen nemen wij geen database op omdat die bij registreren hoort en het gedeelte daarna om de data in te laden hoort bij een andere gedeelte.

ADR criteria
-Context verwijst naar criterias in Decision and CO
-In Decision en Consequences staan geen nieuwe dingen
-Duidelijk de keuze definieëren
-Hoe ben je op de CO/criteria gekomen
-Onder de CO moeten de redenen van je criteria staan


LES 4:
ADR1
CO, prima om een ? te laten bij SQLite omdat er al genoeg +'s zijn bij JSON Java ivm de criteria.
D, Keuze is logisch als je de text leest, maar dan had je net zo goed CO over kunnen slaan want geen van de criteria's overlappen.
C, als je al weet dat PowerBI zwaar meeweegt moet je daarvanaf CO al naar kijken.

ADR2
Status???
Context, komt niet overeen met de Consequences.

ADR3

ADR4
D, er wordt geen Decision gemaakt.
C, 


