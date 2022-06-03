package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.RestaurantDao;
import vn.aloapp.training.springboot.entity.Restaurant;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
    RestaurantDao dao;
	
    @Override
    public Restaurant findById(int id) {
        return dao.findOne(id);
    }

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
