package vn.aloapp.training.springboot.response;

import vn.aloapp.training.springboot.entity.Branch;

public class BranchResponse {
	
	private int id;
	
	private String name;
	
	public BranchResponse() {
		
	}

	public BranchResponse(Branch entity) {
		this.setId(entity.getId());
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
