package com.hicham.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hicham.app.models.User;


/**
 * 
 * @author hicham-abdedaime
 *
 */
@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserByUsermail(String userName) {
		
		User	u	=(User) sessionFactory.getCurrentSession().createQuery("from User u where u.username='"+userName+"'").uniqueResult();
		return u;
	}

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}


}
