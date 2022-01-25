package com.example.Entity;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter @Setter @NoArgsConstructor
public class Address {
	
	private String addressId;
	private String street;
	private String city;
	private String state;

}
