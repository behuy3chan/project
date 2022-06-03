package vn.aloapp.training.springboot.dao;

import java.util.List;

import net.techres.demo.api.model.filter.TableFilterCriteria;
import vn.aloapp.training.springboot.entity.BaseEntity;
import vn.aloapp.training.springboot.entity.Table;

public interface TableDao {

    Table findOne(int id);

    Table create(BaseEntity entity);

    void update(BaseEntity entity);

    void delete(BaseEntity entity);

    List<Table> findAll();
    
    List<Table> filter(TableFilterCriteria filterCriteria);
}
