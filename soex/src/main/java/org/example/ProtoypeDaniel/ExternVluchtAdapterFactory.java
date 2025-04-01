package org.example.ProtoypeDaniel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class ExternVluchtAdapterFactory {

    private final Map<String, IExternVluchtAdapter> adapterMap;

    @Autowired
    public ExternVluchtAdapterFactory(List<IExternVluchtAdapter> adapters) {
        adapterMap = new HashMap<>();
        for (IExternVluchtAdapter adapter : adapters) {
            adapterMap.put(adapter.getApi(), adapter);
        }
    }

    public IExternVluchtAdapter getAdapter(String api) {
        IExternVluchtAdapter adapter = adapterMap.get(api);

        if (adapter == null) {
            throw new IllegalArgumentException("No adapter found for API: " + api);
        }

        return adapter;
    }
}
