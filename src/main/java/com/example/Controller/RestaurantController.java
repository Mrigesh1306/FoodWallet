package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Restaurant;
import com.example.Service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantService restService;

	//Get Restaurant
	@GetMapping(value = "/restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Restaurant>> getRestaurantList() {

		List<Restaurant> restList = restService.getRestListService();
		if (restList == null || restList.size() == 0) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(restList);
	}

	//Get Restaurant by ID
	@GetMapping(path = "/restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> getRestaurantbyId(@PathVariable("id") int id) throws Throwable {

		Restaurant rest = restService.getRestByIdService(id);
		if (rest == null) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(rest);
	}

	//Create Restaurant
	@PostMapping(path = "/restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createNewrestaurant(@RequestBody Restaurant restaurant) throws Throwable {

		restService.creatRestService(restaurant);

		return new ResponseEntity<>("New Restaurant Created", HttpStatus.CREATED);
	}

	//Update restaurant
	@PutMapping(value = "/restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Restaurant updateRestaurant(@PathVariable("id") String id) {

		return restService.updateRestService(id);
	}

	//Delete restaurant
	@DeleteMapping(value = "/restaurant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteRestaurant(@PathVariable("id") int id) throws Throwable {

		restService.deleteRestService(id);
		
		return new ResponseEntity<>("Restaurant Deleted", HttpStatus.OK);
	}

}
