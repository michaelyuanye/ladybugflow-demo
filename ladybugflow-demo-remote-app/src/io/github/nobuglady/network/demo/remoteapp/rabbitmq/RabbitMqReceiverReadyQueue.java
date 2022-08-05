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

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import io.github.nobuglady.network.demo.remoteapp.NodeExecutor;
import io.github.nobuglady.network.fw.queue.ready.ReadyNodeResult;

/**
 * 
 * @author NoBugLady
 *
 */
public class RabbitMqReceiverReadyQueue {

	private static final String QUEUE = "QUEUE_READY";

	public static Channel channel;
	public static Connection connection;

	public static void startConsumer(final NodeExecutor nodeExecuter) throws Exception {
		
		connection = ConnectionUtils.getConnection();
		channel = connection.createChannel();
		channel.queueDeclare(QUEUE, false, false, false, null);
		
		Consumer consumer = new DefaultConsumer(channel) {
			
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				
				String message = new String(body, "UTF-8");
				System.out.println("receive msg:" + message);
				
				String flowId = message.split(",")[0];
				String historyId = message.split(",")[1];
				String nodeId = message.split(",")[2];
				
				ReadyNodeResult readyNodeResult = new ReadyNodeResult();
				readyNodeResult.setFlowId(flowId);
				readyNodeResult.setHistoryId(historyId);
				readyNodeResult.setNodeId(nodeId);
				
				nodeExecuter.onNodeReady(readyNodeResult);
			}
		};
		
		channel.basicConsume(QUEUE, true, consumer);

	}

	public static void shutdown() {

		try {
			channel.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}
}