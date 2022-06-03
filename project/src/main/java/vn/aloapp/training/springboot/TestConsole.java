/**
 * 
 */
package vn.aloapp.training.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vn.aloapp.training.springboot.service.RestaurantService;


@Component
public class TestConsole implements CommandLineRunner {
	
	@Autowired
	RestaurantService restaurantService;
	
	@Override
    public void run(String...args) throws Exception {
	}
	
}

