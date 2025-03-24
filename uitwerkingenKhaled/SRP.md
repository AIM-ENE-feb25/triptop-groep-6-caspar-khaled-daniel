# Single Responsibility Principle

- eerste principle in de SOLID principles

- een klasse maar één taak moet hebben en éé reden om de klasse aan te passen.
- een klasse moet moet met maar entiteit. 

## Voorbeelden

### Slecht voorbeeld:

```
public class Report {
    public String reportContent;

    public void generateReport() {
        // logic to generate report
    }

    public void printReport() {
        // logic to print report
    }

    public void saveToFile(String filename) {
        // logic to save report to file
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
        // logic to generate report
    }
}

public class ReportPrinter {
    public void print(Report report) {
        // logic to print report
    }
}

public class ReportSaver {
    public void saveToFile(Report report, String filename) {
        // logic to save report to file
    }
}
```

Waarom is dit beter?

✅ Report is alleen verantwoordelijk voor rapportgegevens en genereren

✅ ReportPrinter is verantwoordelijk voor printen

✅ ReportSaver is verantwoordelijk voor opslaan



## Consequenties 
SRP leidt tot kleinere klassen die gecombineerd worden om een complex systeem te creëren. Door SRP te implementeren, zorg je voor beter leesbare, onderhoudbare en beter testbare code.

Dit zorgt ook voor maximale cohesion: hoe single minded één klasse is.
