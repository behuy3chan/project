/**
 * 
 */
package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.springboot.entity.Area;


/**
 * @author Long Nguyen
 *
 */
@Repository("areaDao")
@SuppressWarnings("unchecked")
public class AreaDaoImpl extends AbstractDao<Integer, Area> implements AreaDao {

	@Override
	public Area findById(int id) {
		return (Area) this.getSession()
				.createCriteria(Area.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
	}

	@Override
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		CriteriaQuery<Area> criteria = this.getBuilder()
				.createQuery(Area.class);
		
		Root<Area> root = criteria.from(Area.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}
	
}
