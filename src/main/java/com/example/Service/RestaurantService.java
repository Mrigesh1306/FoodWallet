package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.RestaurantDao;
import com.example.Entity.Restaurant;

@Service
public class RestaurantService {

	@Autowired
	RestaurantDao restDao;

	public List<Restaurant> getRestListService() {

		return restDao.getAllRestaurant();
	}

	public Restaurant getRestByIdService(int restId) throws Throwable {

		return restDao.getRestaurantByID(restId);
	}

	public boolean creatRestService(Restaurant restaurant) throws Throwable {

		return restDao.createRestaurantDao(restaurant);
	}

	public Restaurant updateRestService(String restId) {

		return restDao.updateRestDao(restId);
	}

	public boolean deleteRestService(int restId) throws Throwable {

		return restDao.deleteRestDao(restId);
	}

}
