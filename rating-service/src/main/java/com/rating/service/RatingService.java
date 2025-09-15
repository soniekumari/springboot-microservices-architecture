package com.rating.service;

import com.rating.entities.Rating;

import java.util.List;

public interface RatingService {

//    create
    Rating create(Rating rating);

//    Get ratings
    List<Rating> getRatings();

//    Get all by userId
    List<Rating> getRatingByUserId(String userId);

//    Get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);
}
