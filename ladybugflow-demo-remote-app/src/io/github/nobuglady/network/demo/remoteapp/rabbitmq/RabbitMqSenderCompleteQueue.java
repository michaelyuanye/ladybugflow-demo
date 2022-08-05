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
package io.github.nobuglady.network.demo.remoteapp.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 
 * @author NoBugLady
 *
 */
public class RabbitMqSenderCompleteQueue {

	private static final String QUEUE = "QUEUE_COMPLETE";

	private static final String EXCHANGE_NAME = "EXCHANGE_NAME";
	private static final String QUEUE_NAME = "QUEUE_NAME_COMPLETE";
	private static final String ROUTING_KEY = "ROUTING_KEY";

	public static void send(String message) throws Exception {

		Connection connection = ConnectionUtils.getConnection();

		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
		channel.queueDeclare(QUEUE, false, false, false, null);
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
		channel.basicPublish("", QUEUE, null, message.getBytes("UTF-8"));

		System.out.println("Send:" + message);

		channel.close();
		connection.close();
	}
}
