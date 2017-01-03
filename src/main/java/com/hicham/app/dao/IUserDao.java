package com.hicham.app.dao;

import com.hicham.app.models.User;

/***
 * 
 * @author hicham-abdedaime
 *
 */
public interface IUserDao {

	User getUserByUsermail(String userName);

	void saveUser(User user);

}
