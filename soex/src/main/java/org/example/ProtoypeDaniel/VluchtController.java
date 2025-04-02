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
                                     @RequestParam String bestemming,
                                     @RequestParam String datum) {
        datum = datum.trim();

        LocalDate parsedDatum = LocalDate.parse(datum);
        return vluchtService.zoekVluchten(vertrek, bestemming, parsedDatum);
    }

    @PostMapping("/boek")
    public String boekVlucht(@RequestBody BoekVluchtDTO boekVluchtDTO) {
        return vluchtService.boekVlucht(boekVluchtDTO.getVlucht(), boekVluchtDTO.getUsername());
    }
}
