package com.hicham.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hicham.app.dao.IUserDao;
import com.hicham.app.models.Role;
import com.hicham.app.models.User;

/**
 * 
 * @author hicham-abdedaime
 *
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserDao dao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		User u = dao.getUserByUsermail(userName);

		if (u == null) {
			throw new UsernameNotFoundException("Utilisateur n'existe pas: "
					+ userName);
		}
		if (u.getRoles().size() == 0) {

			throw new UsernameNotFoundException(
					"le roles  Utilisateur n'existe pas: " + userName);

		}

		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new org.springframework.security.core.userdetails.User(
				u.getUsername(), u.getPassword().toLowerCase(), u.isActived(),
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(u.getRoles()));

	}

	public List<String> getRolesAsList(Set<Role> roles) {
		List<String> rolesAsList = new ArrayList<String>();
		for (Role role : roles) {
			rolesAsList.add(role.getNom());
		}
		return rolesAsList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			role = "ROLE_" + role;
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRolesAsList(roles));
		return authList;
	}

}
