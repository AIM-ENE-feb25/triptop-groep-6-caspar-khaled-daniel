## 🗺️ Mapping Domeinmodel naar APIs

| Class::Attribuut             | Is input voor API + Endpoint     | Wordt gevuld door API + Endpoint | Wordt geleverd door eindgebruiker | Moet worden opgeslagen in de applicatie |
|------------------------------|----------------------------------|-----------------------------------|------------------------------------|------------------------------------------|
| **Trip::startDatum**         | Airbnb `/search (POST)`          |                                   | ✅                                  | ✅                                        |
| **Trip::eindDatum**          | Airbnb `/search (POST)`          |                                   | ✅                                  | ✅                                        |
| **Trip::locatie**            | Airbnb `/search (POST)`                 |                                   | ✅                                  | ✅                                        |
| **Trip::prijs**              |                                  | Airbnb `/listingDetails (GET)`          |                                    | ✅                                        |
| **Reiziger::naam**           |                                  |                                   | ✅                                  | ✅                                        |
| **Reiziger::telefoonNummer**  |                                  |                                   | ✅                                  | ✅                                        |
| **Reiziger::email**          |                                  |                                   | ✅                                  | ✅                                        |
| **Betaling::bedrag**         |                                  |                                   | ✅                                  | ✅                                        |
| **Betaling::status**         |                                  | PayPal `/paymentStatus`           |                                    | ✅                                        |
| 