package org.example.PrototypeKhaled.Accommodatie;

import org.example.PrototypeKhaled.Accommodatie.AccommodatieRepository;
import org.example.PrototypeKhaled.Accommodatie.AirBnbAdapter;
import org.example.PrototypeKhaled.BoekingData;
import org.example.PrototypeKhaled.BoekingStrategy;

public class AirBnbBoekingStrategy implements BoekingStrategy {
    private AirBnbAdapter adapter;
    private AccommodatieRepository accommodatieRepository;

    public AirBnbBoekingStrategy(AirBnbAdapter adapter, AccommodatieRepository accommodatieRepository) {
        this.adapter = adapter;
        this.accommodatieRepository = accommodatieRepository;
    }
    @Override
    public void verwerkBoeking(BoekingData boekingData) {

    }
}
