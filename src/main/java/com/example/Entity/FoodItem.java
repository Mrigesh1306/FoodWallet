package com.example.Entity;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter @Setter @NoArgsConstructor
public class FoodItem {
	
	private String foodId;
	private String name;
	private String description;
	private String itemType;
	private String itemRating;

}
