Vraag:
Hoe ga je om met aanroepen van externe services die niet beschikbaar zijn en toch verwacht wordt dat er waardevolle output gegeven wordt?

Container: Backend
Container waaruit probleem opgelost wordt: TrailApi(als voorbeeld)


Haalt data api op in DAO -> gaat prima
Stuurt door naar Repo
Stuurt door naar Service
Service heeft een klassen die checkt of de data waardevol is
-Manier -> Geen data, Te weinig opties(maakt niet uit ingeval van TrailApi), 
Oplossing.
Seintje naar RA om het probleem aan te geven. 
--- uitwerking
RA kan handmatig keuzes/opties geven aan de reiziger. 

AANMERKINGEN:
Repo+Dao kan apart want daarin gebeurd weinig dus in beschrijving het erbij genoteerd

Components:
pseudonaam
waardevolledata interface? 
    1. check of er uberhaupt data is
    2. check of de data waardevol is
waardevolletraildata implement waardevolledata

public interface DataValidator {
    
}

public class ValidatorTrail implements DataValidator {
    @Override
    public Boolean isValid(trailData data) {
        return "goeieData"
    }
}

//validator 
    message kunnen tonen aan reiziger
    //erin moeten opties zijn om bepaalde dingen te doen

validtor