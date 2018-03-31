package com.hzit.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * 提供post和get的请求方式
 * 
 * @author THINK
 *
 */
public class WXNetUtil {

	// 创建HttpClient调用
	private static HttpClient ie = HttpClients.createDefault();

	/**
	 * @param url
	 * @return 对应url返回的内容
	 */
	public static String get(String url) {
		if (url == null || url == "") {
			return null;
		}
		// 1.创建HttpGet 根据指定url
		HttpGet httpGet = new HttpGet(url);

		try {
			// 2.执行指定的请求
			HttpResponse response = ie.execute(httpGet);

			// 3.得到响应的结果
			HttpEntity entity = response.getEntity();

			// 4.返回
			String string = EntityUtils.toString(entity, "utf-8");
			return string;
		} catch (Exception e) {
			System.out.println("weixin-net:get异常....");
			e.printStackTrace();
		} finally {
			// 释放资源
			httpGet.releaseConnection();
		}
		return null;
	}

	/**
	 * 
	 * @param url
	 * @param jsonStr
	 * @return
	 */
	public static String post(String url, String jsonStr) {

		HttpPost httpPost = new HttpPost(url);
		// 设置头部信息
		httpPost.setHeader("contentType", "application/json");

		// 获取entity(post请求体的内容)
		HttpEntity entity = new StringEntity(jsonStr, "utf-8");

		// 传给post
		httpPost.setEntity(entity);

		try {
			// 执行
			HttpResponse response = ie.execute(httpPost);

			// 获取内容
			HttpEntity entity2 = response.getEntity();

			// 将获取的内容转为String
			String content = EntityUtils.toString(entity2, "utf-8");

			// 返回
			return content;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 释放资源
			httpPost.releaseConnection();
		}
		return null;
	}

	public static void main(String[] args) {
		// System.out.println(get(
		// "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx405f68216288b619&secret=8d88a36a031b1f6b83b9cb29399221e7"));

		//

		String jsonStr = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\":"
				+ " {\"scene\": {\"scene_id\": 123}}}";
		String post = post(
				"https://api.weixin.qq.com/cgi-bin/qrcode/create?acces"
						+ "s_token=5_PnolcaWeqhF4Gw7wEq-vsOYolZx15BYzJuWGUgLEHRVvps0vu_oNFSEZrqKI7HDJXvHkO82pi4ph6G7GKkWDtDF_whtN-6m1T_IS1-S-s0OKvmM-6pXrJW_9sXgOLSyAx_hsrvJN5_ltYV6AQHLgAJAJAE",
				jsonStr);
		System.out.println(post);
	}
}
