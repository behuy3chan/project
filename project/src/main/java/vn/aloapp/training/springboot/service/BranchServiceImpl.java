package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.BranchDao;
import vn.aloapp.training.springboot.entity.Branch;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchDao dao;

	@Override
	public Branch create(Branch entity) {
		// TODO Auto-generated method stub
		return dao.create(entity);
	}

	@Override
	public void update(Branch entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
		
	}

	@Override
	public Branch findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Branch> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	 

	

	

	

	
	
	
	
	

}
