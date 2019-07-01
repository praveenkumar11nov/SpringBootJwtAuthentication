package com.grokonez.jwtauthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/weblogin")
public class AdminController {

	@RequestMapping(value="/")
	public String getloginPage() {
		System.out.println("inside getLoginPage......");
		return "AccessProvider";
	}
}
