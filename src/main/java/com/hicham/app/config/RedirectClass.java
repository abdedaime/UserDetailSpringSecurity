package com.hicham.app.config;


import java.io.IOException;

import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 
 * @author hicham-Abdedaime
 *
 */
@Component
public class RedirectClass implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());

		if (roles.contains("ROLE_USER")) {
			response.sendRedirect("user");
			return;
		}
		if (roles.contains("ROLE_ADMIN")) {
			response.sendRedirect("admin_page");
			return;
		}
		if (roles.contains("ROLE_MANGER_RH")) {
			response.sendRedirect("admin_page");
			return;
		}

	}

}
