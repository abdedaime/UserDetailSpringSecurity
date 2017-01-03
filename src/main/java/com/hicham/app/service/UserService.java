package com.hicham.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hicham.app.dao.IUserDao;
import com.hicham.app.models.User;
/***
 * 
 * @author hicham-abdedaime
 *
 */
@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private IUserDao dao;

	@Override
	public User getUserByUsermail(String userMail) {
		// TODO Auto-generated method stub
		return dao.getUserByUsermail(userMail);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		dao.saveUser(user);
	}

}
