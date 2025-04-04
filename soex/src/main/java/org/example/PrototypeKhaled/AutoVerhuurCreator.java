package org.example.PrototypeKhaled;

import org.springframework.stereotype.Component;

@Component
public class AutoVerhuurCreator implements BouwsteenCreator{
    @Override
    public String getType() {
        return "Auto verhuur";
    }

    @Override
    public Bouwsteen create(Long id, String naam) {
        return new AutoVerhuur(id, naam, BouwStatus.GEPLAND);
    }
}
