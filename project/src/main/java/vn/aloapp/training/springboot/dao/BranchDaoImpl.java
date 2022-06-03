package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.springboot.entity.Branch;

@Repository("branchDao")
@SuppressWarnings("unchecked")
public class BranchDaoImpl extends AbstractDao<Integer, Branch> implements BranchDao {

	@Override
	public Branch findById(int id) {
		return (Branch) this.getSession()
				.createCriteria(Branch.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
	}

	@Override
	public List<Branch> findAll() {
		CriteriaQuery<Branch> criteria = this.getBuilder()
				.createQuery(Branch.class);
		
		Root<Branch> root = criteria.from(Branch.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}

	
}
