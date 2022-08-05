package io.github.nobuglady.network.demo.microservice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.nobuglady.network.demo.microservice1.service.BookHotelService;

@Controller
public class BookHotelController {

	@Autowired
	private BookHotelService bookHotelService;
	
	@RequestMapping(value = "/book_hotel", method = RequestMethod.GET)
	@ResponseBody
	public String bookHotel() {
		
		bookHotelService.bookHotel();
		
		return "ok";
	}
}
