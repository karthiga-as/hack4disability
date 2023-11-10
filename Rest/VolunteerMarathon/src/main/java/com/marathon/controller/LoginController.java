package com.marathon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathonService")
public class LoginController {

	@RequestMapping("/print")
	public String printHello() {
		return "Welocome to SpringBoot-Rest Service";
	}

}
