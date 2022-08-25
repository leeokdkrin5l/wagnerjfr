/*
 * Copyright 2013-2019 Xia Jun(3979434@qq.com).
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
package com.farsunset.cim.handler;


import com.farsunset.cim.constant.ChannelAttr;
import io.netty.channel.*;

@ChannelHandler.Sharable
public class ThreadNamingHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.channelRegistered(ctx);
		Thread.currentThread().setName(name);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.channelUnregistered(ctx);
		Thread.currentThread().setName(name);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.channelActive(ctx);
		Thread.currentThread().setName(name);

	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.channelInactive(ctx);
		Thread.currentThread().setName(name);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.channelRead(ctx,msg);
		Thread.currentThread().setName(name);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.channelReadComplete(ctx);
		Thread.currentThread().setName(name);
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.userEventTriggered(ctx,evt);
		Thread.currentThread().setName(name);
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.channelWritabilityChanged(ctx);
		Thread.currentThread().setName(name);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		String name = Thread.currentThread().getName();
		setThreadName(ctx);
		super.exceptionCaught(ctx,cause);
		Thread.currentThread().setName(name);
	}


	private void setThreadName(ChannelHandlerContext context){
		String uid = context.channel().attr(ChannelAttr.UID).get();
		if (uid != null){
			Thread.currentThread().setName("nio-uid-" + uid);
		}
	}
}
