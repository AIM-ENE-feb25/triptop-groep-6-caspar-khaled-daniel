package org.example.PrototypeKhaled;

import org.springframework.stereotype.Component;


@Component
public class ActiviteitCreator implements BouwsteenCreator {
    @Override
    public String getType() {
        return "activiteit";
    }

    @Override
    public Bouwsteen create(Long id, String naam) {
        return new Activiteit(id, naam, BouwStatus.GEPLAND);
    }
}