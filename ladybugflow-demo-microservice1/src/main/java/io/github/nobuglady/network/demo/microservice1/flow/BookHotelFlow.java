package io.github.nobuglady.network.demo.microservice1.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.nobuglady.network.demo.microservice1.flow.node.HotelInfoNode;
import io.github.nobuglady.network.demo.microservice1.flow.node.UserInfoNode;
import io.github.nobuglady.network.fw.FlowRunner;
import io.github.nobuglady.network.fw.annotation.Node;

@Component
public class BookHotelFlow extends FlowRunner{
	
	@Autowired
	private HotelInfoNode hotelInfoNode;
	
	@Autowired 
	private UserInfoNode userInfoNode;
	
	private String userInfo;
	private String hotelInfo;
	
	@Node(label = "start")
	public void processStart() throws InterruptedException {
		System.out.println("启动开始 （模拟业务等待3秒）");
		Thread.sleep(3000);
		System.out.println("启动结束");
	}

	@Node(label = "查询用户信息")
	public void processSearchUser() throws InterruptedException {
		System.out.println("查询用户信息开始 （模拟业务等待3秒）");
		userInfo = userInfoNode.getUser(456);
		System.out.println("查询用户信息结束");
	}

	@Node(label = "查询酒店信息")
	public void processSearchHotel() throws InterruptedException {
		System.out.println("查询酒店信息开始 （模拟业务等待3秒）");
		hotelInfo = hotelInfoNode.getHotel(123);
		System.out.println("查询酒店信息结束");
	}

	@Node(label = "下单")
	public void processOrder() throws InterruptedException {
		System.out.println("下单开始 （模拟业务等待3秒）");
		Thread.sleep(3000);
		System.out.println("下单结束");
	}

	@Node(label = "下单成功")
	public void processSuccess() throws InterruptedException {
		System.out.println("下单成功开始 （模拟业务等待3秒）");
		Thread.sleep(3000);
		System.out.println("下单成功结束");

        System.out.println("userInfo:"+userInfo);
        System.out.println("hotelInfo:"+hotelInfo);
	}
}