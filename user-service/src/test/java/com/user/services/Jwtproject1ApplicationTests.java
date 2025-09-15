package com.user.services;

import com.user.entities.Rating;
import com.user.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Jwtproject1ApplicationTests {

	@Autowired
	private RatingService ratingService;
	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){
		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is created for rating").build();
		Rating saveRatings = ratingService.createRating(rating);

		System.out.println("New rating created");
	}

}
