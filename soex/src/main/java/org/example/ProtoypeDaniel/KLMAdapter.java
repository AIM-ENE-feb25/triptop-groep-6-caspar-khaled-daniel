package org.example.ProtoypeDaniel;

import java.time.LocalDate;
import java.util.List;

public class KLMAdapter implements IExternVluchtAdapter{

    @Override
    public List<Vlucht> zoekVluchten(String vertrek, String bestemming, LocalDate datum) {
        return null;
    }

    @Override
    public void boekVlucht(Vlucht vlucht) {

    }
}
