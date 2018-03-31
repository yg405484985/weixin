package com.hzit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hzit.entity.msg.MsgType;
import com.hzit.entity.msg.news.NewsMsg;
import com.hzit.entity.msg.news.NewsMsgArticles;
import com.hzit.entity.msg.news.NewsMsgArticlesItem;
import com.hzit.entity.msg.text.TextMsg;
import com.hzit.entity.msg.text.TextMsgItem;
import com.hzit.proxy.message.WXProxyMessage;

@EnableAutoConfiguration
@RestController
public class MessageController {

	/**
	 * 发送文本消息
	 * 
	 * @param openId
	 *            粉丝ID
	 * @param context
	 *            内容
	 * @return
	 */
	@RequestMapping(value = "sendTextMsg", method = RequestMethod.POST)
	public Object sendMsg(String openId, String context) {

		/*
		 * 封装创建文本消息内容
		 */
		TextMsg textMsg = new TextMsg();
		textMsg.setTouser(openId);

		TextMsgItem text = new TextMsgItem();
		text.setContent(context);
		textMsg.setText(text);
		textMsg.setMsgtype(MsgType.TEXT_TYPE);

		// 将java对象转为json字符串
		String jsonString = JSONObject.toJSONString(textMsg);

		// 发送消息
		String sendMsg = WXProxyMessage.sendMsg(jsonString);

		return sendMsg;
	}

	/**
	 * 发送图文消息(外部链接) 发送的固定对象，没有传递参数
	 * 
	 * @param openId
	 * @param newsItem
	 * @return
	 */
	@RequestMapping(value = "sendNewsMsg", method = RequestMethod.POST)
	public Object sendNewsMsg(String openId, NewsMsgArticlesItem newsItem) {

		/*
		 * 创建图文消息对象
		 */
		NewsMsg newsMsg = new NewsMsg();
		newsMsg.setTouser(openId);
		newsMsg.setMsgtype(MsgType.NEWS_TYPE);

		NewsMsgArticles news = new NewsMsgArticles();
		List<NewsMsgArticlesItem> articles = new ArrayList<NewsMsgArticlesItem>();

		NewsMsgArticlesItem msg1 = new NewsMsgArticlesItem();
		msg1.setTitle("叫花鸡");
		msg1.setDescription("好吃.....");
		msg1.setPicurl(
				"https://fuss10.elemecdn.com/5/c3/bba7c33c73daee8ef333e6de39243jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/85");
		msg1.setUrl("https://www.ele.me/shop/319762");

		NewsMsgArticlesItem msg2 = new NewsMsgArticlesItem();
		msg2.setTitle("红烧鱼块");
		msg2.setDescription("好吃.....");
		msg2.setPicurl(
				"https://fuss10.elemecdn.com/c/2d/b20c196e611b1eba410b789476de0jpeg.jpeg?imageMogr2/thumbnail/100x100/format/webp/quality/85");
		msg2.setUrl("https://www.ele.me/shop/319762");

		articles.add(msg1);
		articles.add(msg2);
		news.setArticles(articles);
		newsMsg.setNews(news);
		String jsonStr = JSONObject.toJSONString(newsMsg);

		/*
		 * end----封装结束
		 */

		// 调用代理对象发送消息
		String sendMsg = WXProxyMessage.sendMsg(jsonStr);
		System.out.println(sendMsg);
		return sendMsg;
	}

}
