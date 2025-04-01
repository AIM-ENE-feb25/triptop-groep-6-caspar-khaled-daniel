package org.example.ProtoypeDaniel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class VluchtService {
    private final VluchtRepository vluchtRepository;
    private final ExternVluchtAdapterFactory adapterFactory;
    private final List<IExternVluchtAdapter> adapters;

    @Autowired
    public VluchtService(VluchtRepository vluchtRepository, ExternVluchtAdapterFactory adapterFactory, List<IExternVluchtAdapter> adapters) {
        this.vluchtRepository = vluchtRepository;
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

    public void boekVlucht(Vlucht vlucht, String username) {
        IExternVluchtAdapter adapter = adapterFactory.getAdapter(vlucht.getApi());
        if (adapter != null) {
            adapter.boekVlucht(vlucht);
            vluchtRepository.slaVluchtOp(vlucht, username);
        }
    }

    public List<Vlucht> haalVluchtenOp(String username) {
        return vluchtRepository.findByUsername(username);
    }
}