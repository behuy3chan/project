package net.techres.demo.api.model.request;

import javax.validation.constraints.NotEmpty;

import vn.aloapp.training.springboot.request.BaseRequest;

public class CRUDTableRequest extends BaseRequest{

    @NotEmpty(message = "Tên bàn không được để trống")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
