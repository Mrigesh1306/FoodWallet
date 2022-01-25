package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.Entity.Restaurant;

@Component
public class RestaurantDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DatabaseConnection conn;

	public List<Restaurant> getAllRestaurant() {

		List<Restaurant> restList = jdbcTemplate.query("Select * from Restaurant",
				BeanPropertyRowMapper.newInstance(Restaurant.class));

		return restList;
	}

	public Restaurant getRestaurantByID(int id) throws SQLException {

		Connection con = conn.connect();
		Restaurant rest = new Restaurant();
		String sql = "Select * from Restaurant where Rest_Id = ?";
		PreparedStatement pr = con.prepareStatement(sql);

		pr.setInt(1, id);

		ResultSet rs = pr.executeQuery();
		while (rs.next()) {
			rest.setRestId(rs.getInt("Rest_Id"));
			rest.setRestName(rs.getString("Rest_Name"));
			rest.setAddressId(rs.getInt("Address_id"));
			rest.setRatings(rs.getInt("Rating"));
			rest.setDateVisited(rs.getDate("Date_Visited"));
		}
		return rest;

	}

	public boolean createRestaurantDao(Restaurant rest) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = conn.connect();
		String sql = "INSERT INTO Restaurant VALUES (?,?,?,?,?)";

		PreparedStatement pr = con.prepareStatement(sql);
		pr.setInt(1, rest.getRestId());
		pr.setString(2, rest.getRestName());
		pr.setInt(3, rest.getAddressId());
		pr.setFloat(4, rest.getRatings());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		pr.setString(5, dtf.format(now));

		boolean rs = pr.execute();
		return rs;

	}

	public Restaurant updateRestDao(String restId) {
		// TODO Auto-generated method stub
		return null;

	}

	public boolean deleteRestDao(int restId) throws SQLException {

		Connection con = conn.connect();
		String sql = "DELETE FROM Restaurant where Rest_Id=?";
		PreparedStatement pr = con.prepareStatement(sql);

		pr.setInt(1, restId);

		return pr.execute();

	}

}
