package io.github.nobuglady.network.demo.microservice1.flow.node;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hotelInfo", url = "localhost:8082")
public interface HotelInfoNode {
	@RequestMapping(method = RequestMethod.GET, value = "/getHotel")
	public String getHotel(@RequestParam("hotel_id") int hotelId);

}
