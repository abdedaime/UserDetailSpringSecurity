package com.hicham.app.service;

import com.hicham.app.models.User;
/***
 * 
 * @author hicham-abdedaime
 *
 */
public interface IUserService {
	public User getUserByUsermail(String userMail);
    public void   saveUser(User user);
}
