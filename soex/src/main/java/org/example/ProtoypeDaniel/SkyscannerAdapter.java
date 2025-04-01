package org.example.ProtoypeDaniel;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class SkyscannerAdapter implements IExternVluchtAdapter {

    // Define your API key here
    private static final String RAPIDAPI_KEY = "YOUR_RAPIDAPI_KEY"; // Replace with your RapidAPI key
    private static final String RAPIDAPI_HOST = "skyscanner89.p.rapidapi.com";

    @Override
    public List<Vlucht> zoekVluchten(String vertrek, String bestemming, LocalDate datum) {
        // Convert the Date object to the required format (yyyy-MM-dd)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(datum);

        // Build the URL dynamically using the parameters
        String url = String.format(
                "https://%s/flights/one-way/list?origin=%s&originId=27537542&destination=%s&destinationId=95673827&date=%s",
                RAPIDAPI_HOST, vertrek, bestemming, formattedDate
        );

        try {
            // Send the GET request to the Skyscanner API using Unirest
            HttpResponse<JsonNode> response = Unirest.get(url)
                    .header("x-rapidapi-key", RAPIDAPI_KEY)
                    .header("x-rapidapi-host", RAPIDAPI_HOST)
                    .asJson();

            // Check if the response status is OK (200)
            if (response.getStatus() == 200) {
                // Print the body of the response to the console
                System.out.println("Response Body: " + response.getBody().toString());
            } else {
                // Handle error (non-200 response)
                System.out.println("Error: " + response.getStatus());
            }
        } catch (Exception e) {
            // Handle exceptions (e.g., network issues)
            e.printStackTrace();
        }

        return null; // You can return the flight list if needed later
    }

    @Override
    public void boekVlucht(Vlucht vlucht) {
        System.out.println("test");
    }
}
