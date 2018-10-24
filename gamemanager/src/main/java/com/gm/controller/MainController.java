package com.gm.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/test")
	public String test() {
		return "/views/test";
	}

	@GetMapping("/login")
	public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout,
			ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (logout != null) {
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			map.put("msg", "You've been logged out in the system...");
		}
		if (error != null) {
			map.put("msg", "Unable to login please check username and password");
		}
		return "/views/login";
	}

	@GetMapping("/")
	public String home() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> userRoles = auth.getAuthorities();

		String returnPath = "redirect:/login";

		for (GrantedAuthority role : userRoles) {
			if (role.getAuthority().equals("ROLE_USER")) {
				returnPath = "redirect:/user";
				break;
			} else if (role.getAuthority().equals("ROLE_ADMIN")) {
				returnPath = "redirect:/admin";
				break;
			}
		}

		return returnPath;
	}
}
