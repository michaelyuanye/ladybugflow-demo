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
package io.github.nobuglady.network.demo.custom;

import io.github.nobuglady.network.fw.constant.NodeStatusDetail;
import io.github.nobuglady.network.fw.executor.INodeExecutor;
import io.github.nobuglady.network.fw.queue.ready.ReadyNodeResult;
import io.github.nobuglady.network.fw.starter.FlowStarter;

/**
 * 
 * @author NoBugLady
 *
 */
public class NodeExecutor implements INodeExecutor {

	public void onNodeReady(ReadyNodeResult readyNodeResult) {
		
		System.out.println("run:" + readyNodeResult.getNodeId());
		
		FlowStarter.completeQueue.putCompleteNode(readyNodeResult.getFlowId(), readyNodeResult.getHistoryId(),
				readyNodeResult.getNodeId(), NodeStatusDetail.COMPLETE_SUCCESS, "0");

	}

	public void shutdown() {
		// TODO Auto-generated method stub

	}

}
