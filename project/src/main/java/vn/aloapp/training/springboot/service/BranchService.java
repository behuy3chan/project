package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Branch;

public interface BranchService {
	
	Branch create(Branch entity);
	
	void update(Branch entity);
    
	Branch findById(int id);
	
	List<Branch> findAll();

}
