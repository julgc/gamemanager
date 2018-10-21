package com.gm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value="/current",method=RequestMethod.GET)
	public @ResponseBody User getCurrentUser() {
		return new User("GINO", "PASSWORD",true);
	}
}
