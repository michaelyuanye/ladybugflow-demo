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
package io.github.nobuglady.network.demo.remoteapp;

import io.github.nobuglady.network.demo.remoteapp.rabbitmq.RabbitMqSenderCompleteQueue;
import io.github.nobuglady.network.fw.queue.ready.ReadyNodeResult;

/**
 * 
 * @author NoBugLady
 *
 */
public class NodeExecutor {

	public void onNodeReady(ReadyNodeResult readyNodeResult) {

		System.out.println("run:" + readyNodeResult.getNodeId());

		try {
			RabbitMqSenderCompleteQueue.send(String.join(",", readyNodeResult.getFlowId(),
					readyNodeResult.getHistoryId(), readyNodeResult.getNodeId(), "1", "0"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
