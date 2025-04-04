package org.example.PrototypeCaspar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OvernachtingService {
    private final BookingComAdapter bookingComAdapter;

    @Autowired
    public OvernachtingService(BookingComAdapter bookingComAdapter) {
        this.bookingComAdapter = bookingComAdapter;
    }

    public List<Overnachting> zoekOvernachtingen(OvernachtingFilter overnachtingFilter) {
        return bookingComAdapter.zoekOvernachtingen(overnachtingFilter);
    }
}
