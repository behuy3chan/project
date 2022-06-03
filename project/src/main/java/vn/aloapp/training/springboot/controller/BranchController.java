package vn.aloapp.training.springboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.Area;
import vn.aloapp.training.springboot.entity.Branch;
import vn.aloapp.training.springboot.entity.Table;
import vn.aloapp.training.springboot.request.CRUDAreaRequest;
import vn.aloapp.training.springboot.response.BranchResponse;
import vn.aloapp.training.springboot.response.TableResponse;
import vn.aloapp.training.springboot.response.AreaResponse;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.service.AreaService;
import vn.aloapp.training.springboot.service.BranchService;
import vn.aloapp.training.springboot.service.TableService;

@RestController
@RequestMapping("/api/branches")
public class BranchController extends BaseController{
	
	@Autowired
	private BranchService branchService;
	private AreaService areaService;
	private TableService tableService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })	 
	public ResponseEntity<BaseResponse> index(
			HttpServletRequest request,
			@RequestParam(name = "name", required = false, defaultValue = "") String name,
			@RequestParam(name = "status", required = false, defaultValue = "-1") int status) {
		BaseResponse response = new BaseResponse();
		try {
			List<Branch> entitiesBrach = branchService.findAll();				
			response.setData(entitiesBrach						 //call setData in BanchResponse
					.stream()
					.map(x -> new BranchResponse(x))		 //chuyen du lieu tu Branch to BrResponse
					.collect(Collectors.toList()));
			
//			List<Area> entitiesArea = areaService.findAll();
//			response.setData(entitiesArea						 //call setData in BanchResponse
//					.stream()
//					.map(y -> new AreaResponse(y))		 //chuyen du lieu tu Branch to BrResponse
//					.collect(Collectors.toList()));				 //chuyen tu stream to List
//			
//			List<Table> entitiesTable = tableService.findAll();	
//			response.setData(entitiesTable					 //call setData in BanchResponse
//					.stream()
//					.map(z -> new TableResponse(z))		 //chuyen du lieu tu Branch to BrResponse
//					.collect(Collectors.toList()));
		} catch(Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(ex.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK); //call to Postman
 	}
}
