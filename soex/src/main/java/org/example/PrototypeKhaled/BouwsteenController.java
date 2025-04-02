package org.example.PrototypeKhaled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bouwstenen")
public class BouwsteenController {

    private final BouwsteenFabriek bouwsteenFabriek;

    @Autowired
    public BouwsteenController(BouwsteenFabriek bouwsteenFabriek) {
        this.bouwsteenFabriek = bouwsteenFabriek;
    }

    @PostMapping
    public ResponseEntity<Bouwsteen> createBouwsteen(@RequestBody BouwsteenRequest request) {
        Bouwsteen bouwsteen = bouwsteenFabriek.createBouwsteen(request.getType(), request.getId(), request.getNaam());
        return new ResponseEntity<>(bouwsteen, HttpStatus.CREATED);
    }
}
