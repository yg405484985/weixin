package com.hzit.proxy;

import com.hzit.token.jedis.WXTokenUtil;
import com.hzit.util.WXNetUtil;

/**
 * 代理的基础类 完成公共部分的功能
 * 
 * @author THINK
 *
 */
public class WXBaseProxy {

	// 获取token
	protected static String ACCESS_TOKEN = "";
	static {
		// 类加载的时候从
		ACCESS_TOKEN = WXTokenUtil.getToken();
	}

	/**
	 * 调用get
	 * 
	 * @param url
	 * @return
	 */
	protected static String get(String url) {
		// net模块提供的方法
		return WXNetUtil.get(url);
	}

	/**
	 * 调用post
	 * 
	 * @param url
	 * @param jsonStr
	 * @return
	 */
	protected static String post(String url, String jsonStr) {
		// net模块提供的方法
		return WXNetUtil.post(url, jsonStr);
	}

}
