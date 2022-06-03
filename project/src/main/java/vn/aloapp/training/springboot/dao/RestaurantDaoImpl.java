/**
 * 
 */
package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.springboot.entity.Restaurant;


/**
 * @author Long Nguyen
 *
 */
@Repository("restaurantDao")
@SuppressWarnings("unchecked")
public class RestaurantDaoImpl extends AbstractDao<Integer, Restaurant> implements RestaurantDao {

	@Override
	public Restaurant findOne(int id) {
		return (Restaurant) this.getSession()
				.createCriteria(Restaurant.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
	}

	@Override
	public Restaurant findByRestaurantName(String restaurantName) {
		// TODO Auto-generated method stub
		return (Restaurant) this.getSession()
				.createCriteria(Restaurant.class)
				.add(Restrictions.isNotNull("oauthClientDetail"))
                .add(Restrictions.eq("restaurantName", restaurantName))
                .uniqueResult();
	}

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		CriteriaQuery<Restaurant> criteria = this.getBuilder()
				.createQuery(Restaurant.class);
		
		Root<Restaurant> root = criteria.from(Restaurant.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}
	
}
