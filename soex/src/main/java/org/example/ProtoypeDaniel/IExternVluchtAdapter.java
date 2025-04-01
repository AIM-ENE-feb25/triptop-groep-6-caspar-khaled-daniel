package org.example.ProtoypeDaniel;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IExternVluchtAdapter {
    List<Vlucht> zoekVluchten(String vertrek, String bestemming, LocalDate datum);
    void boekVlucht(Vlucht vlucht);
}
