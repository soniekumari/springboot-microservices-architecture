package com.hotel.controllers;

import com.hotel.entities.Hotels;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotels> createHotels(@RequestBody Hotels hotels){

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotels));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotels> get(@PathVariable String hotelId){
        Hotels hotel = hotelService.getHotels(hotelId);
        if(hotel == null) {
            throw new ResourceNotFoundException("Hotel with id " + hotelId + " not found");
        }
        return ResponseEntity.ok(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotels>> getAllHotels(){
        List<Hotels> getHotels = hotelService.get();
        return ResponseEntity.ok(getHotels);
    }

}
