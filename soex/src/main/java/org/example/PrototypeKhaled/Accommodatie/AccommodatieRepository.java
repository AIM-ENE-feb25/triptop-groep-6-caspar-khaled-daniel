package org.example.PrototypeKhaled.Accommodatie;

import java.util.ArrayList;
import java.util.List;

public class AccommodatieRepository {

    private List<Accommodatie> accommodaties = new ArrayList<>();

    public void save(Accommodatie accommodatie) {
        accommodaties.add(accommodatie);
    }

    public Accommodatie findById(Long id) {
        for (Accommodatie accommodatie : accommodaties) {
            if (accommodatie.getId().equals(id)) {
                return accommodatie;
            }
        }
        return null;
    }

    public List<Accommodatie> findAll() {
        return new ArrayList<>(accommodaties);
    }
}