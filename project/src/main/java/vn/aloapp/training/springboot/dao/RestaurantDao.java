/**
 * 
 */
package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Restaurant;

/**
 * @author Long Nguyen
 *
 */
public interface RestaurantDao {
	
	Restaurant findOne(int id);
	
	Restaurant findByRestaurantName(String restaurantName);
	
	List<Restaurant> findAll();
}
