package io.github.nobuglady.network.demo.microservice2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HotelInfoController {

	@RequestMapping(method = RequestMethod.GET, value = "/getHotel")
	@ResponseBody
	public String getHotelInfo(@RequestParam("hotel_id") int hotelId) {
		return "HOTEL:"+hotelId;
	}
}
