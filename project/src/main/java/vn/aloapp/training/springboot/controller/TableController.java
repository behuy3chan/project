package vn.aloapp.training.springboot.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.techres.demo.api.model.request.CRUDTableRequest;
import vn.aloapp.training.springboot.entity.Table;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.TableResponse;
import vn.aloapp.training.springboot.service.TableService;

@RestController
@RequestMapping("/api/tables")
public class TableController extends BaseController {

    @Autowired
    private TableService tableService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BaseResponse> index(HttpServletRequest request) {
        BaseResponse response = new BaseResponse();
        try {

            List<Table> tables =  tableService.findAll();

            List<TableResponse> data = new TableResponse().mapToListResponse(tables);

            response.setData(data);

        } catch(Exception ex) {
            ex.printStackTrace();
            response.setStatus(ResponseStatusEnum.FAIL);
            response.setMessageError(ex.getMessage());
        }
        return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BaseResponse> create(
            HttpServletRequest request,
            @Valid @RequestBody CRUDTableRequest wrapper) {
        BaseResponse response = new BaseResponse();
        try {
            Table tables = new Table();
            tables.setName(wrapper.getName());
            tableService.update(tables);
            response.setData(new TableResponse(tables));
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setStatus(ResponseStatusEnum.FAIL);
            response.setMessageError(ex.getMessage());
        }
        return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<BaseResponse> update(
            HttpServletRequest request,
            @PathVariable("id") int id,
            @Valid @RequestBody CRUDTableRequest wrapper) {
        BaseResponse response = new BaseResponse();
        try {
            Table table = tableService.findOne(id);
            if(table == null) {
                response.setStatus(ResponseStatusEnum.DATA_INVALID);
                response.setMessage(ResponseStatusEnum.DATA_INVALID);
            } else {
                table.setName(wrapper.getName());
                tableService.update(table);
                response.setData(new TableResponse(table));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setStatus(ResponseStatusEnum.FAIL);
            response.setMessageError(ex.getMessage());
        }
        return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }
}


