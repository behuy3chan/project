/**
 * 
 */
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
import vn.aloapp.training.springboot.request.CRUDAreaRequest;
import vn.aloapp.training.springboot.response.AreaResponse;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.service.AreaService;


/**
 * @author kelvin
 *
 */
@RestController
@RequestMapping("/api/areas")
public class AreaController extends BaseController {
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> index(
			HttpServletRequest request,
			@RequestParam(name = "name", required = false, defaultValue = "") String name,
			@RequestParam(name = "status", required = false, defaultValue = "-1") int status) {
		BaseResponse response = new BaseResponse();
		try {
			List<Area> entities = areaService.findAll();
			response.setData(entities
					.stream()
					.map(x -> new AreaResponse(x))
					.collect(Collectors.toList()));
		} catch(Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(ex.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> test(
			HttpServletRequest request,
			@PathVariable("id") int id) {
		BaseResponse response = new BaseResponse();
		try {
			
		} catch(Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(ex.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(
			HttpServletRequest request,
			@PathVariable("id") int id,
			@Valid @RequestBody CRUDAreaRequest wrapper) {
		BaseResponse response = new BaseResponse();
		try {
			Area area = areaService.findById(id);
			if(area == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			} else {
				area.setName(wrapper.getName());
				areaService.update(area);
				response.setData(new AreaResponse(area));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(ex.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
}
