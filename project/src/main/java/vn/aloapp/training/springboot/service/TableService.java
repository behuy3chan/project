package vn.aloapp.training.springboot.service;

import java.util.List;

import net.techres.demo.api.model.filter.TableFilterCriteria;
import vn.aloapp.training.springboot.entity.BaseEntity;
import vn.aloapp.training.springboot.entity.Table;

public interface TableService {

    Table findOne(int id);

    Table create(BaseEntity entity);

    void update(BaseEntity entity);

    void delete(BaseEntity entity);

    List<Table> filter(TableFilterCriteria filterCriteria);

	List<Table> findAll();
}
