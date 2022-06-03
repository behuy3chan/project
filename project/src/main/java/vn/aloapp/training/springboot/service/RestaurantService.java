package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Restaurant;

public interface RestaurantService {
    
	Restaurant findById(int id);
	
	List<Restaurant> findAll();
}
