package org.example.ProtoypeDaniel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExternVluchtAdapterFactory {
    private final Map<String, IExternVluchtAdapter> adapterMap;

    @Autowired
    public ExternVluchtAdapterFactory(List<IExternVluchtAdapter> adapters) {
        adapterMap = new HashMap<>();
        for (IExternVluchtAdapter adapter : adapters) {
            adapterMap.put(adapter.getClass().getSimpleName(), adapter);
        }
    }

    public IExternVluchtAdapter getAdapter(String api) {
        return adapterMap.get(api);
    }
}
