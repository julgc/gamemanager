package com.gm.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/admin")
	public @ResponseBody String adminpage() {
		return "ADMIN ACCESS";
	}

	@GetMapping("/user")
	public @ResponseBody String userpage() {
		return "USER ACCESS";
	}

	@GetMapping("/")
	public String home() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> userRoles = auth.getAuthorities();
		
		for(GrantedAuthority role : userRoles) {
			if(role.getAuthority().equals("USER"))
				return "/user";
			else if(role.getAuthority().equals("ADMIN"))
				return "/admin";
		}
		
		return "redirect:/login";
	}
}
