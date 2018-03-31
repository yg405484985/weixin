package com.hzit.proxy.message;

import com.hzit.proxy.WXBaseProxy;

public class WXProxyMessage extends WXBaseProxy {

	// 发送客户消息URL路径
	private static String SEND_KF_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="
			+ ACCESS_TOKEN;

	/**
	 * 发送客服消息
	 * 
	 * @param msgStr,需要发送消息的内容
	 * @return
	 */
	public static String sendMsg(String msgStr) {
		// 调用WXBaseProxy父类中搞的post方法发送消息
		String post = post(SEND_KF_MSG_URL, msgStr);
		return post;

	}

}
