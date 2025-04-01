package org.example.ProtoypeDaniel;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/vluchten")
public class VluchtController {
    private final VluchtService vluchtService;

    @Autowired
    public VluchtController(VluchtService vluchtService) {
        this.vluchtService = vluchtService;
    }

    @GetMapping("/zoek")
    public List<Vlucht> zoekVluchten(@RequestParam String vertrek,
                                     @RequestParam String bestemming) {
        LocalDate datum = LocalDate.of(2025, 3, 31); // Hardcoded date (YYYY, MM, DD)
        return vluchtService.zoekVluchten(vertrek, bestemming, datum);
    }

    @PostMapping("/boek")
    public void boekVlucht(@RequestParam Vlucht vlucht,
                           @RequestParam String username) {
        vluchtService.boekVlucht(vlucht, username);
    }

    @GetMapping("/ophalen")
    public List<Vlucht> haalVluchtenOp(@RequestParam String username) {
        return vluchtService.haalVluchtenOp(username);
    }
}
