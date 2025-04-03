package org.example.PrototypeKhaled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BouwsteenFabriek {

    private final Map<String, BouwsteenCreator> creators = new HashMap<>();

    @Autowired
    public BouwsteenFabriek(List<BouwsteenCreator> creatorList) {
        for (BouwsteenCreator creator : creatorList) {
            creators.put(creator.getType().toLowerCase(), creator);
        }
    }

    public Bouwsteen createBouwsteen(String type, Long id, String naam) {
        BouwsteenCreator creator = creators.get(type.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Onbekend bouwsteen type: " + type);
        }
        return creator.create(id, naam);
    }
}
