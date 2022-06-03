/**
 * 
 */
package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Area;
import vn.aloapp.training.springboot.entity.Restaurant;

/**
 * @author Long Nguyen
 *
 */
public interface AreaDao {
	
	Area create(Area entity);
	
	void update(Area entity);
	
	Area findById(int id);
	
	List<Area> findAll();
}
