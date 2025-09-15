package com.user.external.services;

import com.user.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@FeignClient(name = "ratingservice")
public interface RatingService {

    /*Get users*/
    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUser(@PathVariable("userId") String userId);

    /*POST method*/
    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    /*PUT method*/
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);
}
