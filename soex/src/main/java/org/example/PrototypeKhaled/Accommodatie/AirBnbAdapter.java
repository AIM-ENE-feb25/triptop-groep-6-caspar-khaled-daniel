package org.example.PrototypeKhaled.Accommodatie;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.example.PrototypeKhaled.BoekingData;


public class AirBnbAdapter {
    private String apiKey = "c63c8a897dmsh255bff7c1138dd5p1e6706jsncb079d013c46";
    private String endpointUrl = "airbnb19.p.rapidapi.com";

    public AirBnbAdapter(String apiKey, String endpointUrl) {
        this.apiKey = apiKey;
        this.endpointUrl = endpointUrl;
    }


    public String haalDataVanAirbnb() throws UnirestException {

        String checkinDate = "25/03/2025";
        String checkoutDate = "28/03/2025";
        String location = "london";
        int guests = 2;
        int priceMin = 50;
        int priceMax = 300;

        String url = endpointUrl + "/api/v1/searchPropertyByLocationV2?" +
                "location=" + location +
                "&checkin=" + checkinDate +
                "&checkout=" + checkoutDate +
                "&adults=" + guests +
                "&priceMin=" + priceMin +
                "&priceMax=" + priceMax;

        HttpResponse<String> response = Unirest.get(url)
                .header("x-rapidapi-key", apiKey)
                .header("x-rapidapi-host", endpointUrl)
                .asString();

        return response.getBody();
    }

    public String stuurBoeking(BoekingData boekingData) throws UnirestException {

    }
    public void verwerkBoeking(BoekingData boekingData) throws UnirestException {
        System.out.println("Ophalen van data van AirBnB...");
        String data = haalDataVanAirbnb();
        System.out.println("Ontvangen data: " + data);

        System.out.println("Versturen van boeking naar AirBnB...");
        String bookingResponse = stuurBoeking(boekingData);
        System.out.println("Response van boeking: " + bookingResponse);
    }
}