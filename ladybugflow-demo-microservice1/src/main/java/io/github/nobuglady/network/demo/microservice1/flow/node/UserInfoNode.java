package io.github.nobuglady.network.demo.microservice1.flow.node;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userInfo", url = "localhost:8083")
public interface UserInfoNode {
	
	@RequestMapping(method = RequestMethod.GET, value = "/getUser")
	public String getUser(@RequestParam("user_id") int userId);
}
