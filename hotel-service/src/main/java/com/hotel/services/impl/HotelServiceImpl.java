package com.hotel.services.impl;

import com.hotel.entities.Hotels;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repositories.HotelRepository;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotels create(Hotels hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotels> get() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotels getHotels(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id " + hotelId + " not found on server !!"));
    }
}
