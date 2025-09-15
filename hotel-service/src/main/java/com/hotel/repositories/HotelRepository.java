package com.hotel.repositories;

import com.hotel.entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotels, String> {
}
