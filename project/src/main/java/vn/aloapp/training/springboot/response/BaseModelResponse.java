package vn.aloapp.training.springboot.response;

import java.util.List;

import vn.aloapp.training.springboot.entity.Table;

public interface BaseModelResponse<T1, T2> {

	List<TableResponse> mapToListResponse(List<Table> baseEntities);

}
