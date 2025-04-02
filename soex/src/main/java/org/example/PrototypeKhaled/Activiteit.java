package org.example.PrototypeKhaled;

public class Activiteit implements Bouwsteen {
    private Long id;
    private String naam;
    private BouwStatus status;

    public Activiteit (Long id, String naam, BouwStatus status) {
        this.id = id;
        this.naam = naam;
        this.status = status;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public BouwStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(BouwStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Activiteit{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", status=" + status +
                '}';
    }
}