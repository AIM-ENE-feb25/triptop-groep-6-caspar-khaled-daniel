package org.example.ProtoypeDaniel;

import java.time.LocalDateTime;

public class Vlucht {
    private String api;
    private String vluchtNummer;
    private String maatschappij;
    private String vertrekLocatie;
    private String bestemming;
    private double prijs;
    private LocalDateTime vertrekDatumTijd;
    private LocalDateTime aankomstDatumTijd;

    public Vlucht(String api, String vluchtNummer, String maatschappij, String vertrekLocatie, String bestemming, double prijs, LocalDateTime vertrekDatumTijd, LocalDateTime aankomstDatumTijd) {
        this.api = api;
        this.vluchtNummer = vluchtNummer;
        this.maatschappij = maatschappij;
        this.vertrekLocatie = vertrekLocatie;
        this.bestemming = bestemming;
        this.prijs = prijs;
        this.vertrekDatumTijd = vertrekDatumTijd;
        this.aankomstDatumTijd = aankomstDatumTijd;
    }

    // Getters and Setters
    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getVluchtNummer() {
        return vluchtNummer;
    }

    public void setVluchtNummer(String vluchtNummer) {
        this.vluchtNummer = vluchtNummer;
    }

    public String getMaatschappij() {
        return maatschappij;
    }

    public void setMaatschappij(String maatschappij) {
        this.maatschappij = maatschappij;
    }

    public String getVertrekLocatie() {
        return vertrekLocatie;
    }

    public void setVertrekLocatie(String vertrekLocatie) {
        this.vertrekLocatie = vertrekLocatie;
    }

    public String getBestemming() {
        return bestemming;
    }

    public void setBestemming(String bestemming) {
        this.bestemming = bestemming;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public LocalDateTime getVertrekDatumTijd() {
        return vertrekDatumTijd;
    }

    public void setVertrekDatumTijd(LocalDateTime vertrekDatumTijd) {
        this.vertrekDatumTijd = vertrekDatumTijd;
    }

    public LocalDateTime getAankomstDatumTijd() {
        return aankomstDatumTijd;
    }

    public void setAankomstDatumTijd(LocalDateTime aankomstDatumTijd) {
        this.aankomstDatumTijd = aankomstDatumTijd;
    }
}
