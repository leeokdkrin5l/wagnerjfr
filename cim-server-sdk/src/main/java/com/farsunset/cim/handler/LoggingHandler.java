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


import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.logging.LogLevel;

@ChannelHandler.Sharable
public class LoggingHandler extends io.netty.handler.logging.LoggingHandler {

	public LoggingHandler() {
		super(LogLevel.INFO);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		super.channelRead(ctx,msg);
	}

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		super.channelRead(ctx,msg);
	}


	@Override
	public void channelRegistered(ChannelHandlerContext ctx) {
		ctx.fireChannelRegistered();
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) {
		ctx.fireChannelUnregistered();
	}

	@Override
	public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) {
		ctx.deregister(promise);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.fireChannelReadComplete();
	}

	@Override
	public void flush(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		logger.warn("EXCEPTION",cause);
	}
}
