package org.example.PrototypeKhaled;


public class Accommodatie implements Bouwsteen {
    private Long id;
    private String naam;
    private BouwStatus status;

    public Accommodatie(Long id, String naam, BouwStatus status) {
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
        return "Accommodatie{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", status=" + status +
                '}';
    }
}
