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
		System.out.println("������ʼ ��ģ��ҵ��ȴ�3�룩");
		Thread.sleep(3000);
		System.out.println("��������");
	}

	@Node(label = "��ѯ�û���Ϣ")
	public void processSearchUser() throws InterruptedException {
		System.out.println("��ѯ�û���Ϣ��ʼ ��ģ��ҵ��ȴ�3�룩");
		userInfo = userInfoNode.getUser(456);
		System.out.println("��ѯ�û���Ϣ����");
	}

	@Node(label = "��ѯ�Ƶ���Ϣ")
	public void processSearchHotel() throws InterruptedException {
		System.out.println("��ѯ�Ƶ���Ϣ��ʼ ��ģ��ҵ��ȴ�3�룩");
		hotelInfo = hotelInfoNode.getHotel(123);
		System.out.println("��ѯ�Ƶ���Ϣ����");
	}

	@Node(label = "�µ�")
	public void processOrder() throws InterruptedException {
		System.out.println("�µ���ʼ ��ģ��ҵ��ȴ�3�룩");
		Thread.sleep(3000);
		System.out.println("�µ�����");
	}

	@Node(label = "�µ��ɹ�")
	public void processSuccess() throws InterruptedException {
		System.out.println("�µ��ɹ���ʼ ��ģ��ҵ��ȴ�3�룩");
		Thread.sleep(3000);
		System.out.println("�µ��ɹ�����");

        System.out.println("userInfo:"+userInfo);
        System.out.println("hotelInfo:"+hotelInfo);
	}
}