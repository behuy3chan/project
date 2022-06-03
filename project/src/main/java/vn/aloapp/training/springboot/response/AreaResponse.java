package vn.aloapp.training.springboot.response;

import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.Area;

public class AreaResponse{

	private int id;

	private String name;
	
	public AreaResponse() {
		
	}

	public AreaResponse(Area entity) {
		this.setId(entity.getId());
		this.setName(entity.getName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


}
