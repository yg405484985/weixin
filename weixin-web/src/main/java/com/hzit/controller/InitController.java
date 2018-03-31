package com.hzit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzit.entity.replymsg.ReplyTextMsg;
import com.hzit.util.SecurityKit;
import com.thoughtworks.xstream.XStream;

@EnableAutoConfiguration
@Controller
public class InitController {

	// 和access_token不一样，需要配置界面的token内容一样
	private String token = "weixin123";

	/**
	 * 配置服务器路径 用来验证服务器
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@RequestMapping(value = "wxInit", method = RequestMethod.GET)
	public Object wxInit(String signature, String timestamp, String nonce, String echostr) {

		// 1）将token、timestamp、nonce三个参数进行字典序排序
		String array[] = { token, timestamp, nonce };
		Arrays.sort(array);// 排序

		// 2）将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer stringBuffer = new StringBuffer();
		for (String string : array) {
			stringBuffer.append(string);
		}
		// sha1加密
		String sha1 = SecurityKit.sha1(stringBuffer.toString());

		// 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if (sha1.equals(signature)) {
			// 4）对比成功，返回echostr
			return echostr;
		}
		return null;
	}

	/**
	 * 由于配置给wxInit get方法，所有该路径的post用来介绍微信服务器发送过来的信息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "wxInit", method = RequestMethod.POST)
	public void wxInitPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

		InputStream inputStream = request.getInputStream();

		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer sb = new StringBuffer();
		String temp = null;
		while ((temp = bufferedReader.readLine()) != null) {
			System.out.println(temp);
			sb.append(temp);
		}

		// 接收内容

		// 判断是否是文本内容
		// if (sb.toString().contains("<MsgType><![CDATA[text]]></MsgType>")) {

		XStream xStream = new XStream();
		xStream.aliasType("xml", ReplyTextMsg.class);

		// 接收到的消息
		ReplyTextMsg reply = (ReplyTextMsg) xStream.fromXML(sb.toString());

		ReplyTextMsg sendMsgToUser = sendMsgToUser(reply);

		xStream.alias("xml", ReplyTextMsg.class);
		String xml = xStream.toXML(sendMsgToUser);
		System.out.println(xml + "-----");

		PrintWriter writer = response.getWriter();
		writer.println(xml);
		writer.flush();
		writer.close();
		// return xml;

		// } else {
		// return null;
		// }

	}

	/**
	 * 
	 * 给粉丝自动回复消息
	 * 
	 * @param reply
	 *            接收的内容
	 * 
	 * @return ReplyTextMsg 封装好给粉丝的内容
	 */
	public ReplyTextMsg sendMsgToUser(ReplyTextMsg reply) {

		ReplyTextMsg sendTextMsg = new ReplyTextMsg();
		sendTextMsg.setToUserName(reply.getFromUserName());
		sendTextMsg.setFromUserName(reply.getToUserName());
		sendTextMsg.setCreateTime(System.currentTimeMillis());
		sendTextMsg.setMsgType(reply.getMsgType());
		// sendTextMsg.setMsgId(reply.getMsgId());

		String context = null;
		String replyContext = reply.getContent();
		if ("12345".equals(replyContext)) {
			context = "上山打老虎";
		} else if ("你好".equals(replyContext)) {
			context = "我吃饱了...";
		} else if ("sb".equals(replyContext)) {
			context = "你才是傻逼";
		} else {
			context = "暂不识别.....";
		}

		sendTextMsg.setContent(context);

		return sendTextMsg;

	}

}
