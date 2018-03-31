package com.hzit.proxy.user;

import java.util.List;

import com.hzit.proxy.WXBaseProxy;

/**
 * 
 * @author THINK
 *
 */
public class WXProxyUsers extends WXBaseProxy {

	// 获取用户列表信息URL
	private static String USER_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + ACCESS_TOKEN;

	// 根据OpenId获取单个用户基本信息URL
	private static String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + ACCESS_TOKEN
			+ "&lang=zh_CN";

	// 根据多个OpenId获取多个用户基本信息
	private static String USER_LIST_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token="
			+ ACCESS_TOKEN;

	/**
	 * 获取用户列表
	 * 
	 * @param nextOpenId
	 * @return 用户的列表
	 */
	public static String getUserList(String nextOpenId) {
		// 判断是否存在nextOpenId，如果存在，则在修改URL
		if (nextOpenId != null) {
			USER_LIST_URL = USER_LIST_URL + "&next_openid=" + nextOpenId;
		}
		// 调用底层方法
		String string = get(USER_LIST_URL);
		return string;
	}

	/**
	 * 获取用户的基本信息
	 * 
	 * @param openId
	 * @return 指定openId用户的详情
	 */
	public static String getUserInfoByOpenId(String openId) {

		// 如果openId为空，直接返回
		if (openId == null || openId == "") {
			return "openId为空，请检查...";
		}
		// 修改URL,添加openID
		USER_INFO_URL = USER_INFO_URL + "&openid=" + openId;

		// 获取用户基本信息
		String userInfo = get(USER_INFO_URL);

		return userInfo;
		// &openid=OPENID
	}

	/**
	 * 批量获取用户的基本信息
	 * 
	 * @param josnStr
	 *            用户的openId信息
	 * @return
	 */
	public static String getUserListInfo(String josnStr) {
		String post = post(USER_LIST_INFO_URL, josnStr);
		return post;
	}

	public static void main(String[] args) {
		// System.out.println(getUserList("oJ1R0w1O7TdhxVWwKckchvBOXWz4"));
		// System.out.println(getUserInfoByOpenId("oJ1R0w1O7TdhxVWwKckchvBOXWz4"));
		String str = "{\"user_list\": [{\"openid\": \"oJ1R0w-i05YO5sLsG42fCDJ1GZN8\", \"lang\": \"zh_CN\" },"
				+ " {\"openid\": \"oJ1R0w-p_YrohzuNdpC_RXoEgaDg\",\"lang\": \"zh_CN\"}]}";

		System.out.println(getUserListInfo(str));
	}

}
