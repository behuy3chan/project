package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Area;

public interface AreaService {
	
	Area create(Area entity);
	
	void update(Area entity);
    
	Area findById(int id);
	
	List<Area> findAll();
}
