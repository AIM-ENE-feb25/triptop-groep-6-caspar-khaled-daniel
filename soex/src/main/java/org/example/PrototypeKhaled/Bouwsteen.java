package org.example.PrototypeKhaled;


public interface Bouwsteen {
    Long getId();
    String getNaam();
    BouwStatus getStatus();
    void setStatus(BouwStatus status);
}