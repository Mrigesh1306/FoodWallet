package com.example.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter @Setter @NoArgsConstructor
public class Restaurant {
	
	private int restId;
	private String restName;
	private int addressId;
	private List<FoodItem> foodItem;
	private float ratings;
	private Date dateVisited;
	

	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public Date getDateVisited() {
		return dateVisited;
	}
	public void setDateVisited(Date dateVisited) {
		this.dateVisited = dateVisited;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public List<FoodItem> getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(List<FoodItem> foodItem) {
		this.foodItem = foodItem;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "Restaurant [restName=" + restName + ", addressId=" + addressId + ", foodItem=" + foodItem
				+ ", ratings=" + ratings + ", dateVisited=" + dateVisited + "]";
	}
	
	

}
