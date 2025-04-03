package org.example.PrototypeCaspar;

public class Overnachting {
    private String hotelName;
    private double reviewScore;
    private double latitude;
    private double longitude;
    private String cityName;

    // Constructor
    public Overnachting(String hotelName, double reviewScore, double latitude, double longitude, String cityName) {
        this.hotelName = hotelName;
        this.reviewScore = reviewScore;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityName = cityName;
    }

    // Getters and Setters
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(double reviewScore) {
        this.reviewScore = reviewScore;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
