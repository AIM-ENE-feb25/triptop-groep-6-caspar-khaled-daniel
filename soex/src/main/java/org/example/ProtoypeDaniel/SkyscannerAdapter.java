package org.example.ProtoypeDaniel;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.format.DateTimeFormatter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

@Component("Skyscanner")
public class SkyscannerAdapter implements IExternVluchtAdapter {

    private static final String API_URL = "https://skyscanner80.p.rapidapi.com/api/v1/flights/search-one-way";
    private static final String RAPIDAPI_HOST = "skyscanner80.p.rapidapi.com";
    private static final String RAPIDAPI_KEY = "26caa2b96amsh8680e9efa9a37e6p1fbe5cjsnf86fcc6dac05";

    @Override
    public List<Vlucht> zoekVluchten(String vertrek, String bestemming, LocalDate datum) {
        try {
            String apiUrl = String.format(
                    "%s?fromId=%s&toId=%s&departDate=%s",
                    API_URL, vertrek, bestemming, datum);

            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-rapidapi-host", RAPIDAPI_HOST);
            connection.setRequestProperty("x-rapidapi-key", RAPIDAPI_KEY);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return parseVluchten(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Vlucht> parseVluchten(String jsonData) {
        List<Vlucht> vluchten = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        try {
            JsonNode rootNode = objectMapper.readTree(jsonData);

            JsonNode dataNode = rootNode.path("data");

            JsonNode itineraries = dataNode.path("itineraries");

            for (JsonNode itinerary : itineraries) {
                JsonNode priceNode = itinerary.path("price").path("raw");
                double prijs = priceNode.asDouble();

                JsonNode legs = itinerary.path("legs");
                for (JsonNode leg : legs) {
                    String vertrekLocatie = leg.path("origin").path("displayCode").asText();
                    String bestemming = leg.path("destination").path("displayCode").asText();

                    JsonNode segment = leg.path("segments").get(0);
                    String vluchtNummer = segment.path("flightNumber").asText();
                    String maatschappij = segment.path("marketingCarrier").path("name").asText();

                    LocalDateTime vertrekDatumTijd = LocalDateTime.parse(segment.path("departure").asText(), formatter);
                    LocalDateTime aankomstDatumTijd = LocalDateTime.parse(segment.path("arrival").asText(), formatter);

                    Vlucht vlucht = new Vlucht("Skyscanner", vluchtNummer, maatschappij, vertrekLocatie, bestemming, prijs, vertrekDatumTijd, aankomstDatumTijd);
                    vluchten.add(vlucht);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vluchten;
    }

    @Override
    public String boekVlucht(Vlucht vlucht) {
        return"Skyscanner";
    }

    @Override
    public String getApi() {
        return "Skyscanner";
    }
}
