package vn.aloapp.training.springboot.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.techres.demo.api.model.filter.TableFilterCriteria;
import vn.aloapp.training.springboot.dao.TableDao;
import vn.aloapp.training.springboot.entity.BaseEntity;
import vn.aloapp.training.springboot.entity.Table;

@Transactional
@Service("tableService")
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDao dao;
    
    @Override
    public List<Table> filter(TableFilterCriteria filterCriteria) {
        return dao.filter(filterCriteria);
    }
    @Override
    @Transactional(readOnly = true)
    public Table findOne(int id) {
        // TODO Auto-generated method stub
        return dao.findOne(id);
    }

    @Override
    public Table create(BaseEntity entity) {
        // TODO Auto-generated method stub
        return dao.create(entity);
    }

    @Override
    public void update(BaseEntity entity) {
        // TODO Auto-generated method stub
        dao.update(entity);
    }

    @Override
    public void delete(BaseEntity entity) {
        // TODO Auto-generated method stub
        dao.delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Table> findAll() {
        // TODO Auto-generated method stub
        return dao.findAll();
        
    }
   
}