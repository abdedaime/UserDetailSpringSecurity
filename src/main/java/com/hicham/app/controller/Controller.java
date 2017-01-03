package com.hicham.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 
 * @author hicham-abdedaime
 *
 */
@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping(value = { "/login", "/" })
	public String login() {
		return "login";
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = { "/user" })
	public String user(Model model, Authentication authentication) {
		model.addAttribute("user", getRoles(authentication));
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		System.out.println(user.toString());
		return "page_user";
	}

	@Secured(value = { "ROLE_ADMIN" })
	@RequestMapping(value = { "/admin_page" })
	public String adminPage(Model model, Authentication authentication) {
		model.addAttribute("user", getRoles(authentication));
		return "page_admin";
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_MANGER_RH" })
	@RequestMapping(value = { "/rh_page" })
	public String rhPage(Model model, Authentication authentication) {
		model.addAttribute("user", getRoles(authentication));
		return "page_rh";
	}

	@RequestMapping("/index")
	public String index(Model model, Authentication authentication) {
		model.addAttribute("user", getRoles(authentication));
		return "index";
	}

	public Map<String, Object> getRoles(Authentication auth) {

		Map<String, Object> cordonnees = new HashMap<String, Object>();
		cordonnees.put("roles",
				AuthorityUtils.authorityListToSet(auth.getAuthorities()));
		cordonnees.put("username", auth.getName());
		return cordonnees;

	}
}
