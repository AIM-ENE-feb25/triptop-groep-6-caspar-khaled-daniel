package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App
{
    public static void main( String[] args ) throws UnirestException {
        // Get current date and the date 3 days from now (for example)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String arrivalDate = dateFormat.format(new Date()); // today's date for arrival
        String departureDate = dateFormat.format(new Date(System.currentTimeMillis() + 86400000L * 3)); // 3 days from today for departure

        // Build the URL with the dates included
        String url = "https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels?" +
                "dest_id=-2092174&search_type=CITY&adults=1&children_age=0%2C17&room_qty=1&page_number=1&" +
                "units=metric&temperature_unit=c&languagecode=en-us&currency_code=AED&" +
                "arrival_date=" + arrivalDate + "&departure_date=" + departureDate;

        // Make the API call
        HttpResponse<String> response = Unirest.get(url)
                .header("x-rapidapi-key", "26caa2b96amsh8680e9efa9a37e6p1fbe5cjsnf86fcc6dac05")
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .asString();

        // Print the response body (this should include hotel information)
        System.out.println(response.getBody());
    }
}
