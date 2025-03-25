## Ontwerpvraag
Hoe bied je de gebruiker op basis van zelfgekozen bouwstenen alternatieve bouwstenen aan, bijvoorbeeld als een bepaalde overnachting niet beschikbaar is of om een keuze te geven tussen vervoer per auto, trein of bus?

### Container

Backend

### Components

```
publicinterface DataValidator {

boolean isValid();

}


public class BookingValidator implements DataValidator {

    pubic void findAlternative() {
        // zoeken met +- 1 dag
        // of vergelijkbare hotels met zelfde zoekopdracht
        // dependent aan de parameters vind die een alternatief

    }

    @Override
    public boolean isValid(bookingData data);

    return data 

    // if false findAlternative() 

}
```





