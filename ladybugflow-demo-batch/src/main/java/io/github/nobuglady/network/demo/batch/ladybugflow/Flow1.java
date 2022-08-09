/*
 * Copyright (c) 2021-present, NoBugLady Contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */
package io.github.nobuglady.network.demo.batch.ladybugflow;

import org.springframework.stereotype.Component;

import io.github.nobuglady.network.fw.FlowRunner;
import io.github.nobuglady.network.fw.annotation.Node;

/**
 * 
 * @author NoBugLady
 *
 */
@Component
public class Flow1 extends FlowRunner {

	private String result;
	
	public String getResult() {
		return result;
	}
	
	@Node(label = "start")
	public void processStart() throws InterruptedException {
		System.out.println("启动开始 （模拟业务等待3秒）");
		Thread.sleep(3000);
		System.out.println("启动结束");
	}

	@Node(label = "查询用户信息")
	public void processSearchUser() throws InterruptedException {
		System.out.println("查询用户信息开始 （模拟业务等待3秒）");
		Thread.sleep(3000);
		System.out.println("查询用户信息结束");
	}

	@Node(label = "查询酒店信息")
	public void processSearchHotel() throws InterruptedException {
		System.out.println("查询酒店信息开始 （模拟业务等待3秒）");
		Thread.sleep(3000);
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
		result = "success";
	}
}
