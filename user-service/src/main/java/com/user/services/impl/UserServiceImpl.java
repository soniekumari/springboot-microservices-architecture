package com.user.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entities.Hotel;
import com.user.entities.Rating;
import com.user.exception.ResourceNotFoundException;
import com.user.external.services.HotelService;
import com.user.external.services.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entities.User;
import com.user.repository.UserRepository;
import com.user.services.UserService;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	/*@Autowired
	private RestTemplate restTemplate;*/

	@Autowired
	private HotelService hotelService;

	@Autowired
	private RatingService ratingService;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		/*get user from database with the help of user repository*/
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! "+ userId));

		// 2. Get ratings of this user from Rating Service using RestTemplate
		/*Rating[] ratingsOfUser = restTemplate.getForObject(
				"http://ratingservice/ratings/user/" + userId,
				Rating[].class
		);

		List<Rating> ratings = Arrays.asList(ratingsOfUser);*/


		// 3. For each rating, fetch hotel details from Hotel Service using RestTemplate
		/*ratings.forEach(rating -> {
			Hotel hotel = restTemplate.getForObject(
					"http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
					Hotel.class
			);*/

			/*Using feign client*/

		List<Rating> ratings = ratingService.getRatingsByUser(userId);

		ratings.forEach(rating -> {
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel); // attach hotel to rating

		});
		user.setRating(ratings);

		// JSON log
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(user);
			logger.info("Final User Response in JSON:\n{}", json);
		} catch (JsonProcessingException e) {
			logger.error("Error serializing user to JSON", e);
		}

		return user;

	}

}
