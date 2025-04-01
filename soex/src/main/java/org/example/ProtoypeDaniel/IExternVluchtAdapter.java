package org.example.ProtoypeDaniel;

import java.time.LocalDate;
import java.util.List;

public interface IExternVluchtAdapter {
    List<Vlucht> zoekVluchten(String vertrek, String bestemming, LocalDate datum);

    String boekVlucht(Vlucht vlucht);

    String getApi();

}
