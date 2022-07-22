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
package io.github.nobuglady.network.demo.test1;

import io.github.nobuglady.network.fw.FlowRunner;
import io.github.nobuglady.network.fw.annotation.Node;

/**
 * 
 * @author NoBugLady
 *
 */
public class TestFlow1 extends FlowRunner {

	@Node(label = "a")
	public int process_a() {
		System.out.println("processing a");
		return 1;
	}

	@Node(label = "b")
	public void process_b() {
		System.out.println("processing b");
	}

	@Node(label = "c")
	public void process_c() {
		System.out.println("processing c");
	}

	@Node(label = "d")
	public void process_d() {
		System.out.println("processing d");
	}
}
