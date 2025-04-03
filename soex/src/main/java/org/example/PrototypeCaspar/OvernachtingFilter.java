package org.example.PrototypeCaspar;

import java.time.LocalDate;

public class OvernachtingFilter {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private int roomQty;
    private int guestQty;
    private String bbox;

    public void setFilterDetails(LocalDate arrivalDate, LocalDate departureDate, int roomQty, int guestQty, String bbox) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomQty = roomQty;
        this.guestQty = guestQty;
        this.bbox = bbox;
    }


    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public int getRoomQty() {
        return roomQty;
    }

    public int getGuestQty() {
        return guestQty;
    }

    public String getBbox() {
        return bbox;
    }
}
