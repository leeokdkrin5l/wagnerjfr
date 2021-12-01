/**
 * Copyright 2013-2023 Xia Jun(3979434@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ***************************************************************************************
 *                                                                                     *
 *                        Website : http://www.farsunset.com                           *
 *                                                                                     *
 ***************************************************************************************
 */
package com.farsunset.cim.sdk.server.model;

import java.io.UnsupportedEncodingException;
/**
 *websocket握手响应结果
 *
 */
public class WebsocketResponse{
 
	private String token;
	
	public WebsocketResponse(String token) {
		this.token = token;
	}
	
	public byte[] getBytes() {
        try {
			return toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HTTP/1.1 101 Switching Protocols");
		builder.append("\r\n");
		builder.append("Upgrade: websocket");
		builder.append("\r\n");
		builder.append("Connection: Upgrade");
		builder.append("\r\n");
		builder.append("Sec-WebSocket-Accept:").append(token);
		builder.append("\r\n");
		builder.append("\r\n");

        return builder.toString();
        
	}
}
