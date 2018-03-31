package com.hzit.proxy.menu;

import com.hzit.proxy.WXBaseProxy;
import com.hzit.util.WXNetUtil;

public class WXProxyMenu extends WXBaseProxy {

	private static String MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + ACCESS_TOKEN;

	/**
	 * 
	 * @param menuJson
	 *            生成菜单的参数
	 * @return
	 */
	public static String menuManage(String menuJson) {
		String post = WXNetUtil.post(MENU_URL, menuJson);
		return post;
	}

}
