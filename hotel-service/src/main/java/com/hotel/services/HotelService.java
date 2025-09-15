package com.hotel.services;

import com.hotel.entities.Hotels;

import java.util.List;

public interface HotelService {

//    create
    Hotels create(Hotels hotels);

//    get all hoteles
    List<Hotels> get();

//    get single hotels
    Hotels getHotels(String hotelId);
}
