package com.hzit.token.jedis;

import com.alibaba.fastjson.JSONObject;
import com.hzit.token.util.RedisPoolUtil;
import com.hzit.util.WXNetUtil;

import redis.clients.jedis.Jedis;

/**
 * 获取token
 * 
 * 1.有效时间2个小时 2.有次数限制 3.临界点，新老token都可以使用
 * 
 * 
 *
 * 
 * 
 * @author THINK
 *
 */
public class WXTokenUtil {

	// 指定微信账号
	private static final String APPID = "wx405f68216288b619";
	private static final String APPSECRET = "8d88a36a031b1f6b83b9cb29399221e7";

	/**
	 * 获取token
	 * 
	 * @return
	 */
	public static String getToken() {

		// 传到redis里面
		Jedis jedis = RedisPoolUtil.getJedis();

		// 先从redis里面获取
		String token = jedis.get("token");

		// redis服务器里面没有token的值 要不第一次进来，要不就失效了，重新调用服务器的方法
		if (token == null || token == "") {
			token = remote();// 调用微信服务器
			jedis.set("token", token); // 存放到redis服务器
			jedis.expire("token", 7000); // 设置有效时间7000秒
		}

		// {"access_token":"ACCESS_TOKEN","expires_in":7200}

		return token;

	}

	/**
	 * 远程调用微信的服务器获取token值
	 * 
	 * @return
	 */
	private static String remote() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret="
				+ APPSECRET;

		// 调用weixin-net___get()
		String content = WXNetUtil.get(url);

		// 将String转为json对象
		JSONObject parseObject = JSONObject.parseObject(content);

		String token = null;

		// 判断是否成功
		// 因为微信规定成功之后返回的内容：{"access_token":"ACCESS_TOKEN","expires_in":7200}
		if (parseObject.containsKey("access_token")) {

			// 通过key获取指定的内容
			token = parseObject.getString("access_token");
			System.out.println("...远程访问了一次");
		}

		return token;
	}

	public static void main(String[] args) {
		String token = getToken();
		System.out.println(token);
	}

}
