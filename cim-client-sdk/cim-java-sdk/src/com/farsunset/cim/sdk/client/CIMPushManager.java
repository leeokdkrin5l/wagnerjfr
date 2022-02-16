/**
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
package com.farsunset.cim.sdk.client;

import java.util.Properties;
import java.util.UUID;

import com.farsunset.cim.sdk.client.constant.CIMConstant;
import com.farsunset.cim.sdk.client.model.Intent;
import com.farsunset.cim.sdk.client.model.SentBody;

/**
 * CIM 功能接口
 */
public class CIMPushManager {

	static String ACTION_ACTIVATE_PUSH_SERVICE = "ACTION_ACTIVATE_PUSH_SERVICE";

	static String ACTION_CREATE_CIM_CONNECTION = "ACTION_CREATE_CIM_CONNECTION";

	static String ACTION_SEND_REQUEST_BODY = "ACTION_SEND_REQUEST_BODY";

	static String ACTION_CLOSE_CIM_CONNECTION = "ACTION_CLOSE_CIM_CONNECTION";

	static String ACTION_DESTORY = "ACTION_DESTORY";

	static String KEY_CIM_CONNECTION_STATUS = "KEY_CIM_CONNECTION_STATUS";

	// 被销毁的destroy()
	public static final int STATE_DESTROYED = 0x0000DE;
	// 被销停止的 stop()
	public static final int STATE_STOPED = 0x0000EE;

	public static final int STATE_NORMAL = 0x000000;

	/**
	 * 初始化,连接服务端，在程序启动页或者 在Application里调用
	 * 
	 * @param context
	 * @param ip
	 * @param port
	 */

	public static void connect(String ip, int port) {

		CIMCacheManager.getInstance().putBoolean(CIMCacheManager.KEY_CIM_DESTROYED, false);
		CIMCacheManager.getInstance().putBoolean(CIMCacheManager.KEY_MANUAL_STOP, false);

		CIMCacheManager.getInstance().putString(CIMCacheManager.KEY_CIM_SERVIER_HOST, ip);
		CIMCacheManager.getInstance().putInt(CIMCacheManager.KEY_CIM_SERVIER_PORT, port);

		Intent serviceIntent = new Intent();
		serviceIntent.putExtra(CIMCacheManager.KEY_CIM_SERVIER_HOST, ip);
		serviceIntent.putExtra(CIMCacheManager.KEY_CIM_SERVIER_PORT, port);
		serviceIntent.setAction(ACTION_CREATE_CIM_CONNECTION);
		startService(serviceIntent);

	}

	private static void startService(Intent intent) {
		CIMPushService.getInstance().onStartCommand(intent);
	}

	protected static void connect() {

		boolean isManualStop = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_MANUAL_STOP);
		boolean isManualDestory = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_CIM_DESTROYED);

		if (isManualStop || isManualDestory) {
			return;
		}

		String host = CIMCacheManager.getInstance().getString(CIMCacheManager.KEY_CIM_SERVIER_HOST);
		int port = CIMCacheManager.getInstance().getInt(CIMCacheManager.KEY_CIM_SERVIER_PORT);

		connect(host, port);

	}

	private static void sendBindRequest(String account) {

		CIMCacheManager.getInstance().putBoolean(CIMCacheManager.KEY_MANUAL_STOP, false);
		SentBody sent = new SentBody();
		Properties sysPro = System.getProperties();
		sent.setKey(CIMConstant.RequestKey.CLIENT_BIND);
		sent.put("account", account);
		sent.put("deviceId", getDeviceId());
		sent.put("channel", "java");
		sent.put("device", sysPro.getProperty("os.name"));
		sent.put("version", getClientVersion());
		sent.put("osVersion", sysPro.getProperty("os.version"));
		sendRequest(sent);
	}

	/**
	 * 设置一个账号登录到服务端
	 * 
	 * @param account
	 *            用户唯一ID
	 */
	public static void bindAccount(String account) {

		boolean isManualDestory = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_CIM_DESTROYED);
		if (isManualDestory || account == null || account.trim().length() == 0) {
			return;
		}
		sendBindRequest(account);

	}

	protected static boolean autoBindDeviceId() {

		String account = getAccount();

		boolean isManualDestory = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_CIM_DESTROYED);
		boolean isManualStoped = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_MANUAL_STOP);
		if (isManualStoped || account == null || account.trim().length() == 0 || isManualDestory) {
			return false;
		}

		sendBindRequest(account);

		return true;
	}

	/**
	 * 发送一个CIM请求
	 * 
	 * @param context
	 * @body
	 */
	public static void sendRequest(SentBody body) {

		boolean isManualStop = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_MANUAL_STOP);
		boolean isManualDestory = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_CIM_DESTROYED);

		if (isManualStop || isManualDestory) {
			return;
		}

		Intent serviceIntent = new Intent();
		serviceIntent.putExtra(SentBody.class.getName(), body);
		serviceIntent.setAction(ACTION_SEND_REQUEST_BODY);
		startService(serviceIntent);

	}

	/**
	 * 停止接受推送，将会退出当前账号登录，端口与服务端的连接
	 * 
	 * @param context
	 */
	public static void stop() {

		boolean isManualDestory = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_CIM_DESTROYED);
		if (isManualDestory) {
			return;
		}

		CIMCacheManager.getInstance().putBoolean(CIMCacheManager.KEY_MANUAL_STOP, true);

		startService(new Intent(ACTION_CLOSE_CIM_CONNECTION));

	}

	/**
	 * 完全销毁CIM，一般用于完全退出程序，调用resume将不能恢复
	 * 
	 * @param context
	 */
	public static void destroy() {

		CIMCacheManager.getInstance().putBoolean(CIMCacheManager.KEY_CIM_DESTROYED, true);

		Intent serviceIntent = new Intent();
		serviceIntent.setAction(ACTION_DESTORY);
		startService(serviceIntent);

	}

	/**
	 * 重新恢复接收推送，重新连接服务端，并登录当前账号如果aotuBind == true
	 * 
	 * @param context
	 * @param aotuBind
	 */
	public static void resume() {

		boolean isManualDestory = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_CIM_DESTROYED);
		if (isManualDestory) {
			return;
		}

		autoBindDeviceId();
	}

	public static boolean isConnected() {
		return CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_CIM_CONNECTION_STATE);
	}

	public static int getState() {
		boolean isManualDestory = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_CIM_DESTROYED);
		if (isManualDestory) {
			return STATE_DESTROYED;
		}

		boolean isManualStop = CIMCacheManager.getInstance().getBoolean(CIMCacheManager.KEY_MANUAL_STOP);
		if (isManualStop) {
			return STATE_STOPED;
		}

		return STATE_NORMAL;
	}


	public static String getClientVersion() {
		return System.getProperties().getProperty(CIMConstant.ConfigKey.CLIENT_VERSION);
	}

	public static String getAccount() {
		return System.getProperties().getProperty(CIMConstant.ConfigKey.CLIENT_ACCOUNT);
	}

	public static void setAccount(String account) {
		System.getProperties().put(CIMConstant.ConfigKey.CLIENT_ACCOUNT, account);
	}

	public static void setClientVersion(String version) {
		System.getProperties().put(CIMConstant.ConfigKey.CLIENT_VERSION, version);
	}
 
	private static String getDeviceId() {
		
		String deviceId = System.getProperties().getProperty(CIMConstant.ConfigKey.CLIENT_DEVICEID);
		
		if(deviceId == null) {
			deviceId = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			System.getProperties().put(CIMConstant.ConfigKey.CLIENT_DEVICEID, deviceId);
		}
		return deviceId;
	}
}
