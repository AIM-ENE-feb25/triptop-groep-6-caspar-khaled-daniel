package org.example.ProtoypeDaniel;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component("KLM")
public class KLMAdapter implements IExternVluchtAdapter {

    @Override
    public List<Vlucht> zoekVluchten(String vertrek, String bestemming, LocalDate datum) {
        List<Vlucht> vluchten = new ArrayList<>();

        //testdata wegens niet werkende api.
        Vlucht vlucht1 = new Vlucht(
                "KLM",
                "KL1001",
                "KLM",
                "Amsterdam",
                "New York",
                499.99,
                LocalDateTime.of(2025, 3, 31, 10, 0),
                LocalDateTime.of(2025, 3, 31, 14, 30)
        );

        Vlucht vlucht2 = new Vlucht(
                "KLM",
                "KL1002",
                "KLM",
                "Amsterdam",
                "Paris",
                199.99,
                LocalDateTime.of(2025, 3, 31, 12, 0),
                LocalDateTime.of(2025, 3, 31, 13, 45)
        );

        vluchten.add(vlucht1);
        vluchten.add(vlucht2);

        return vluchten;
    }

    @Override
    public String boekVlucht(Vlucht vlucht) {
        return "klm";
    }

    @Override
    public String getApi() {
        return "KLM";
    }
}
