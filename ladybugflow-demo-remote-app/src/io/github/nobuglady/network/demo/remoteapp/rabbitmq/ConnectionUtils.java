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

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 
 * @author NoBugLady
 *
 */
public class ConnectionUtils {

	private static final String HOST = "localhost";
	private static final int PORT = 5672;
	private static final String USERNAME = "guest";
	private static final String PASSWORD = "guest";
	private static final String VIRTUALHOST = "/";

	public static Connection getConnection() throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();

		factory.setHost(HOST);
		factory.setPort(PORT);
		factory.setUsername(USERNAME);
		factory.setPassword(PASSWORD);
		factory.setVirtualHost(VIRTUALHOST);

		return factory.newConnection();
	}
}
