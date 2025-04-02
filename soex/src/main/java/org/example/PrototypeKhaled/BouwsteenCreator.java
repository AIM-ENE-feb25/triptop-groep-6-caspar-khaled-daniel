package org.example.PrototypeKhaled;

public interface BouwsteenCreator {
    String getType();
    Bouwsteen create(Long id, String naam);
}
