package org.example.PrototypeCaspar;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.springframework.stereotype.Component;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingComAdapter {
    private static final String RAPIDAPI_HOST = "apidojo-booking-v1.p.rapidapi.com";
    private static final String RAPIDAPI_KEY = "ae2db8c49cmsh9997d2923c3ee30p190014jsn0f644e2e63f3";

    @CircuitBreaker(name = "overnachtingCircuitBreaker", fallbackMethod = "fallbackMethod")
    public List<Overnachting> zoekOvernachtingen(OvernachtingFilter overnachtingFilter) {
        HttpResponse<JsonNode> response = Unirest.get("https://" + RAPIDAPI_HOST + "/properties/v2/list-by-map")
                .header("X-RapidAPI-Key", RAPIDAPI_KEY)
                .header("X-RapidAPI-Host", RAPIDAPI_HOST)
                .queryString("arrival_date", overnachtingFilter.getArrivalDate().toString())
                .queryString("departure_date", overnachtingFilter.getDepartureDate().toString())
                .queryString("room_qty", overnachtingFilter.getRoomQty())
                .queryString("guest_qty", overnachtingFilter.getGuestQty())
                .queryString("bbox", overnachtingFilter.getBbox())
                .asJson();

        if (!response.isSuccess()) {
            throw new RuntimeException("Failed to fetch data: " + response.getStatusText());
        }
        return parseResponse(response.getBody());
    }

    private List<Overnachting> parseResponse(JsonNode jsonNode) {
        List<Overnachting> overnachtingen = new ArrayList<>();
        JSONObject responseJson = jsonNode.getObject();
        System.out.println(responseJson);

        JSONArray results = responseJson.optJSONArray("result");
        System.out.println(results);
            for (int i = 0; i < results.length(); i++) {
                JSONObject obj = results.getJSONObject(i);

                // Extract values from JSON response
                String hotelName = obj.optString("hotel_name", "Unknown Hotel");
                double reviewScore = obj.optDouble("review_score", 0.0);  // Default value 0.0 if not present
                double latitude = obj.optDouble("latitude", 0.0);  // Default value 0.0 if not present
                double longitude = obj.optDouble("longitude", 0.0);  // Default value 0.0 if not present
                String cityName = obj.optString("city_name_en", "Unknown City");

                System.out.println("Extracted: Hotel = " + hotelName + ", Review Score = " + reviewScore
                        + ", Latitude = " + latitude + ", Longitude = " + longitude + ", City = " + cityName);

                // Add the extracted data to the Overnachting list
                overnachtingen.add(new Overnachting(hotelName, reviewScore, latitude, longitude, cityName));
            }

        return overnachtingen;
    }

    public List<Overnachting> fallbackMethod(OvernachtingFilter overnachtingFilter, Throwable throwable) {
        // Return a fallback response or some default values
        System.out.println("CircuitBreaker triggered. Returning fallback data.");
        return new ArrayList<>(); // Returning an empty list as a fallback
    }

}
