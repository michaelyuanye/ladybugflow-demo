package io.github.nobuglady.network.demo.microservice3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoController {

	@RequestMapping(method = RequestMethod.GET, value = "/getUser")
	@ResponseBody
	public String getUserInfo(@RequestParam("user_id") int userId) {
		return "USER:"+userId;
	}
}
