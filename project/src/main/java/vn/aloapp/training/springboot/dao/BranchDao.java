package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Branch;

public interface BranchDao {
	
	Branch create(Branch entity);
	
	void update(Branch entity);
	
	Branch findById(int id);
	
	List<Branch> findAll();


}
