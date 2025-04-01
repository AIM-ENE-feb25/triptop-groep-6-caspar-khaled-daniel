package org.example.PrototypeKhaled;

public class BoekingData {
    private Long itemId;
    private String klantNaam;
    private int aantalPersonen;

    public BoekingData(Long itemId, String klantNaam, int aantalPersonen) {
        this.itemId = itemId;
        this.klantNaam = klantNaam;
        this.aantalPersonen = aantalPersonen;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getKlantNaam() {
        return klantNaam;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }
}