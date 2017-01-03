package com.hicham.app.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.hicham.app.config.HibernateConfiguration;
import com.hicham.app.models.User;
import com.hicham.app.service.IUserService;
/**
 * 
 * @author hicham-abdedaime
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { HibernateConfiguration.class })
public class TestDb {
  
	@Autowired
	private IUserService serviceUser;

	@Test
	public void test() {
		
		User user = new User();
		user.setUsername("hicham.abdedaime@gmail.com");
		user.setActived(true);
		user.setPassword("admin");
		serviceUser.saveUser(user);
		User u = serviceUser.getUserByUsermail("hicham.abdedaime@gmail.com");
		assertNotNull(u);
	}
}
