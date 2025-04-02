package org.example.ProtoypeDaniel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class VluchtService {

    private final ExternVluchtAdapterFactory adapterFactory;
    private final List<IExternVluchtAdapter> adapters;

    @Autowired
    public VluchtService(ExternVluchtAdapterFactory adapterFactory, List<IExternVluchtAdapter> adapters) {
        this.adapterFactory = adapterFactory;
        this.adapters = adapters;
    }

    public List<Vlucht> zoekVluchten(String vertrek, String bestemming, LocalDate datum) {
        List<Vlucht> result = new ArrayList<>();
        for (IExternVluchtAdapter adapter : adapters) {
            result.addAll(adapter.zoekVluchten(vertrek, bestemming, datum));
        }
        return result;
    }

    public String boekVlucht(Vlucht vlucht, String username) {
        String api = vlucht.getApi();

        IExternVluchtAdapter adapter = adapterFactory.getAdapter(api);
        String response = adapter.boekVlucht(vlucht);
        //sla vlucht op in DB
        return(response);
    }
}
