package vn.aloapp.training.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.techres.demo.api.model.filter.TableFilterCriteria;
import vn.aloapp.training.springboot.entity.BaseEntity;
import vn.aloapp.training.springboot.entity.Table; 


@Repository("tableDao")
@Transactional
public class TableDaoImpl extends AbstractDao<Integer, Table> implements TableDao {

    @Override
    public Table findOne(int id) {
        CriteriaQuery<Table> criteria = this.getBuilder()
                .createQuery(Table.class);

        Root<Table> root = criteria.from(Table.class);
        criteria
            .select(root)
            .where(this.getBuilder().equal(root.get("id"), id));
        return this.getSession().createQuery(criteria).uniqueResult();
    }

    @Override
    public Table create(BaseEntity entity) {
        this.getSession().save(entity);
        return (Table) entity;
    }

    @Override
    public List<Table> findAll() {
        CriteriaQuery<Table> criteria = this.getBuilder()
                .createQuery(Table.class);

        Root<Table> root = criteria.from(Table.class);

        criteria
            .select(root)
            .orderBy(this.getBuilder().asc(root.get("id")));
        return this.getSession().createQuery(criteria).getResultList();

    }

	@Override
	public void update(BaseEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BaseEntity entity) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public List<Table> filter(TableFilterCriteria filterCriteria) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
    public List<Table> filter(TableFilterCriteria filterCriteria) {
        // TODO Auto-generated method stub
        CriteriaQuery<Table> criteria = this.getBuilder()
                .createQuery(Table.class);

        Root<Table> root = criteria.from(Table.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
//		return null;

//        if(!Strings.isNullOrEmpty(filterCriteria.getName())) {
//            predicates.add(this.getBuilder().like(root.get("name"), "%" + filterCriteria.getName() + "%"));
//        }
//
//        criteria
//            .select(root)
//            .orderBy(this.getBuilder().asc(root.get("id")));
        return this.getSession().createQuery(criteria).getResultList();
    }

}