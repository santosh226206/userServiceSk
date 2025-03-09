package com.layp.userService.domain;

public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int Rating;
    private  String feedback;
    private   Hotel hotel;

    public Rating() {
    }

    public Rating(String ratingId, String userId, String hotelId, int rating, String feedback, Hotel hotel) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        Rating = rating;
        this.feedback = feedback;
        this.hotel = hotel;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
