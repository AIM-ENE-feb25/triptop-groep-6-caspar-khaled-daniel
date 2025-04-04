package org.example.PrototypeCaspar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("overnachting")
public class OvernachtingController {
    private final OvernachtingService overnachtingService;

    @Autowired
    public OvernachtingController(OvernachtingService overnachtingService) {
        this.overnachtingService = overnachtingService;
    }

    @GetMapping("/zoek")
    public List<Overnachting> zoekOvernachtingen( @RequestParam("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrivalDate,
                                                  @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
                                                  @RequestParam("roomQty") int roomQty,
                                                  @RequestParam("guestQty") int guestQty,
                                                  @RequestParam("bbox") String bbox) {

        OvernachtingFilter overnachtingFilter = new OvernachtingFilter();
        overnachtingFilter.setFilterDetails(arrivalDate, departureDate, roomQty, guestQty, bbox);

        return overnachtingService.zoekOvernachtingen(overnachtingFilter);
    }
}

//    Kan dit geen string zijn want je wil alleen maar een confirmatie terug sturen?
//    @PostMapping("/sla_op")
//    public Overnachting slaOvernachtingOp(Overnachting overnachting) {
//    }
//
//    @GetMapping("/{id}")
//    public Overnachting haalOvernachtingOp(Overnachting overnachting) {
//    }