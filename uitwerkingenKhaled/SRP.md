# Single Responsibility Principle

- eerste principle in de SOLID principles

- SOLID principles zijn richtlijnen voor het ontwikkelen van object oriented software.
- een klasse maar één taak moet hebben en éé reden om de klasse aan te passen.
- een klasse moet moet met maar entiteit. 

## Voorbeelden

### Slecht voorbeeld:

```
public class Report {
    public String reportContent;

    public void generateReport() {
       
    }

    public void printReport() {
    
    }

    public void saveToFile(String filename) {
       
    }
}
```

Wat is hier mis?
De Report-klasse heeft meerdere verantwoordelijkheden:

❌ Het genereren van een rapport

❌ Het printen van een rapport

❌ Het opslaan van een rapport


### Goed voorbeeld:
```
public class Report {
    public String reportContent;

    public void generateReport() {
        
    }
}

public class ReportPrinter {
    public void print(Report report) {
    
    }
}

public class ReportSaver {
    public void saveToFile(Report report, String filename) {
      
    }
}
```

Waarom is dit beter?

✅ Report is alleen verantwoordelijk voor rapportgegevens en genereren

✅ ReportPrinter is verantwoordelijk voor printen

✅ ReportSaver is verantwoordelijk voor opslaan



## Consequenties 

### Design Properties
#### Cohesion
één klasse, één verantwoordelijkheid.
Cohesion is hoe single minded een klasse is.

#### Seperations of Concerns
elke klasse focust op één 'concern'.


### Voordelen
- Betere leesbaarheid
- Makkelijker onderhoud
- Betere testbaarheid
- Hogere hergebruikbaarheid
- Minder kans op bugs

### Nadelen
- Meer classes
- Complex
- Meer afhandelijkheden
- Boilerplate vode
