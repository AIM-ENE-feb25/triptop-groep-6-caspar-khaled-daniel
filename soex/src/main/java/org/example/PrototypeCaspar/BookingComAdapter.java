package org.example.PrototypeCaspar;

import io.github.resilience4j.retry.annotation.Retry;
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
    private static int apiCallCounter = 0;
    private static final String RAPIDAPI_KEY = "ae2db8c49cmsh9997d2923c3ee30p190014jsn0f644e2e63f3";
    private static final String CORRECT_RAPIDAPI_HOST = "apidojo-booking-v1.p.rapidapi.com";
    private static final String INCORRECT_RAPIDAPI_HOST = "rapidapi.com/ditgaatnietwerken";

    private String getCurrentApiHost() {
        if (apiCallCounter < 3) {
            apiCallCounter++;
            System.out.println("INCORRECT");
            return INCORRECT_RAPIDAPI_HOST;
        } else {
            System.out.println("CORRECT");
            return CORRECT_RAPIDAPI_HOST;
        }
    }

    @CircuitBreaker(name = "overnachtingCircuitBreaker", fallbackMethod = "fallbackMethod")
    @Retry(name = "overnachtingRetry")
    public List<Overnachting> zoekOvernachtingen(OvernachtingFilter overnachtingFilter) {
        System.out.println("Calling API");

        String RAPIDAPI_HOST = getCurrentApiHost();


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
            System.out.println("retry nu");
            throw new kong.unirest.UnirestException("API request failed: " + response.getStatusText());
        }

        return parseResponse(response.getBody());
    }

    private List<Overnachting> parseResponse(JsonNode jsonNode) {
        List<Overnachting> overnachtingen = new ArrayList<>();
        JSONObject responseJson = jsonNode.getObject();

        JSONArray results = responseJson.optJSONArray("result");
            for (int i = 0; i < results.length(); i++) {
                JSONObject obj = results.getJSONObject(i);

                String hotelName = obj.optString("hotel_name", "Unknown Hotel");
                double reviewScore = obj.optDouble("review_score", 0.0);
                double latitude = obj.optDouble("latitude", 0.0);
                double longitude = obj.optDouble("longitude", 0.0);
                String cityName = obj.optString("city_name_en", "Unknown City");

                overnachtingen.add(new Overnachting(hotelName, reviewScore, latitude, longitude, cityName));
            }

        return overnachtingen;
    }

    public List<Overnachting> fallbackMethod(Throwable exception) {
        System.out.println("CircuitBreaker werkt");
//        System.out.println(exception.getClass().getName());
        return new ArrayList<>();
    }

}
