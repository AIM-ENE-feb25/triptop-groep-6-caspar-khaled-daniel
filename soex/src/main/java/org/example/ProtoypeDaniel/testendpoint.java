package org.example.ProtoypeDaniel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//Deze klasse is geschreven om een api te testen om te gebruiken.
//na testen wat de gratis data al verbruikt.

@RestController
public class testendpoint {

    private static final String RAPIDAPI_KEY = "26caa2b96amsh8680e9efa9a37e6p1fbe5cjsnf86fcc6dac05";
    private static final String RAPIDAPI_HOST = "google-flights2.p.rapidapi.com";

    @GetMapping("/test")
    public List<Vlucht> zoekVluchten(@RequestParam String uservertrek, @RequestParam String userbestemming) {
        List<Vlucht> vluchten = new ArrayList<>();
        try {
            String url = "https://google-flights2.p.rapidapi.com/api/v1/searchFlights?" +
                    "departure_id=LAX&arrival_id=JFK&outbound_date=2025-04-03&travel_class=ECONOMY" +
                    "&adults=1&show_hidden=1&currency=USD&language_code=en-US&country_code=US";

            HttpResponse<String> response = Unirest.get(url)
                    .header("x-rapidapi-key", RAPIDAPI_KEY)
                    .header("x-rapidapi-host", RAPIDAPI_HOST)
                    .asString();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            JsonNode topFlightsNode = rootNode.path("data").path("itineraries").path("topFlights");

            for (JsonNode flightNode : topFlightsNode) {
                String vluchtNummer = flightNode.path("flights").get(0).path("flight_number").asText();
                String maatschappij = flightNode.path("flights").get(0).path("airline").asText();
                String vertrekLocatie = flightNode.path("flights").get(0).path("departure_airport").path("airport_name").asText();
                String bestemming = flightNode.path("flights").get(0).path("arrival_airport").path("airport_name").asText();
                double prijs = flightNode.path("price").asDouble();

                String vertrekDatumTijdStr = flightNode.path("departure_time").asText();
                String aankomstDatumTijdStr = flightNode.path("arrival_time").asText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
                LocalDateTime vertrekDatumTijd = LocalDateTime.parse(vertrekDatumTijdStr, formatter);
                LocalDateTime aankomstDatumTijd = LocalDateTime.parse(aankomstDatumTijdStr, formatter);

                Vlucht vlucht = new Vlucht(
                        "Google Flights API",
                        vluchtNummer,
                        maatschappij,
                        vertrekLocatie,
                        bestemming,
                        prijs,
                        vertrekDatumTijd,
                        aankomstDatumTijd
                );
                vluchten.add(vlucht);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vluchten;
    }
}
