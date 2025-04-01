package org.example.PrototypeKhaled.Accommodatie;


import org.example.PrototypeKhaled.BoekingData;
import org.example.PrototypeKhaled.BoekingStrategy;

import java.util.List;

public class AccommodatieService {
    private final AccommodatieRepository accommodatieRepository;
    private final BoekingStrategy boekingStrategy;


    public AccommodatieService(AccommodatieRepository accommodatieRepository, BoekingStrategy boekingStrategy) {
        this.accommodatieRepository = accommodatieRepository;
        this.boekingStrategy = boekingStrategy;
    }

    public List<Accommodatie> haalAccommodatiesOp() {
        return accommodatieRepository.findAll();
    }
    public void verwerkBoeking(BoekingData boekingData) {

        boekingStrategy.verwerkBoeking(boekingData);
    }
}
