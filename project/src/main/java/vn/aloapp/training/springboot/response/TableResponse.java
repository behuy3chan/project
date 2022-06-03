package vn.aloapp.training.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.Table;

public class TableResponse implements BaseModelResponse<TableResponse, Table> {

    private int id;

    private String name;

    @JsonProperty("created_at")
    private String createdAt;

    public TableResponse() {}

    public TableResponse(Table entity) {
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setCreatedAt(entity.getCreatedAtFormatVN());
    }

    @Override
    public List<TableResponse> mapToListResponse(List<Table> baseEntities) {
        List<TableResponse> list = baseEntities
                .stream()
                .map(x -> new TableResponse(x))
                .collect(Collectors.toList());
        return list;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
