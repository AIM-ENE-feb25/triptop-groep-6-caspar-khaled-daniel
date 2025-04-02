package org.example.PrototypeKhaled;

import org.springframework.stereotype.Component;

@Component
public class AccommodatieCreator implements BouwsteenCreator{
    @Override
    public String getType() {
        return "accommodatie";
    }

    @Override
    public Bouwsteen create(Long id, String naam) {
        return new Accommodatie(id, naam, BouwStatus.GEPLAND);
    }
}