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