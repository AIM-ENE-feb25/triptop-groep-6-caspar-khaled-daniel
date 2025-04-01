package org.example.ProtoypeDaniel;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component("Skyscanner")
public class SkyscannerAdapter implements IExternVluchtAdapter {

    @Override
    public List<Vlucht> zoekVluchten(String vertrek, String bestemming, LocalDate datum) {
        List<Vlucht> vluchten = new ArrayList<>();

        //testdata wegens niet werkende api.
        Vlucht vlucht1 = new Vlucht(
                "Skyscanner",
                "AF2001",
                "Air France",
                "Paris",
                "London",
                129.99,
                LocalDateTime.of(2025, 4, 1, 8, 30),
                LocalDateTime.of(2025, 4, 1, 9, 45)
        );

        Vlucht vlucht2 = new Vlucht(
                "Skyscanner",
                "LH3001",
                "Lufthansa",
                "Frankfurt",
                "Tokyo",
                899.99,
                LocalDateTime.of(2025, 4, 2, 22, 0),
                LocalDateTime.of(2025, 4, 3, 15, 30)
        );

        vluchten.add(vlucht1);
        vluchten.add(vlucht2);

        return vluchten;
    }

    @Override
    public String boekVlucht(Vlucht vlucht) {
        return"Skyscanner";
    }

    @Override
    public String getApi() {
        return "Skyscanner";
    }
}
