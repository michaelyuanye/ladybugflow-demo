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
package io.github.nobuglady.network.demo.test4;

import io.github.nobuglady.network.fw.starter.FlowStarter;

/**
 * 
 * @author NoBugLady
 *
 */
public class Test4 {

	public static void main(String[] args) {
		
		TestFlow4 testFlow = new TestFlow4();
		testFlow.startFlow(true);
		FlowStarter.shutdown();
		
	}
}
