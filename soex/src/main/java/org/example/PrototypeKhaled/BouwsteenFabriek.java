package org.example.PrototypeKhaled;

import org.example.PrototypeKhaled.Accommodatie.Accommodatie;
import org.example.PrototypeKhaled.Activiteit.Activiteit;

public class BouwsteenFabriek {

    public static Bouwsteen createBouwsteen(String type, Long id, String naam) {
        switch (type.toLowerCase()) {
            case "accommodatie":
                return new Accommodatie(id, naam, BouwStatus.GEPLAND);
            case "activiteit":
                return new Activiteit(id, naam, BouwStatus.GEPLAND);
            default:
                throw new IllegalArgumentException("Onbekend bouwsteen type: " + type);
        }
    }
}
