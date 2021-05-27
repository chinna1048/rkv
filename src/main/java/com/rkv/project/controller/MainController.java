package com.rkv.project.controller;



import javax.annotation.security.PermitAll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rkv.project.dto.LoginDTO;
import com.rkv.project.service.LoginService;

@RestController
public class MainController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);


	@Autowired
	LoginService service;

	@PermitAll
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public String login(@RequestBody LoginDTO loginDTO) {
		String result =  null;
		try {
			result = service.loginValidation(loginDTO);
		} catch (Exception e) {
			result="error";
		}
		return result;
	}
}
