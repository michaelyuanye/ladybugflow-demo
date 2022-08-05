package io.github.nobuglady.network.demo.microservice1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nobuglady.network.demo.microservice1.flow.BookHotelFlow;

@Service
public class BookHotelService {

	@Autowired
	private BookHotelFlow bookHotelFlow;
	
	public void bookHotel() {
		bookHotelFlow.startFlow(false);
	}

}
