package org.example.PrototypeKhaled.Accommodatie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/accommodaties")
public class AccommodatieController {
    private final AccommodatieService accommodatieService;

    @Autowired
    public AccommodatieController(AccommodatieService accommodatieService) {
        this.accommodatieService = accommodatieService;
    }

    @GetMapping("getAccommodaties")
    public String getAccommodaties() {

        return "List of accommodations";
    }

    @GetMapping("boekAccommodaties")
    public String boekAccommodaties() {

        return "Boek accommodaties";
    }
}
