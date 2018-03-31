package com.hzit.entity.msg;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.hzit.entity.msg.news.NewsMsg;
import com.hzit.entity.msg.news.NewsMsgArticles;
import com.hzit.entity.msg.news.NewsMsgArticlesItem;
import com.hzit.entity.msg.text.TextMsg;
import com.hzit.entity.msg.text.TextMsgItem;

/**
 * 测试实体类
 * 
 * @author THINK
 *
 */
public class Test {
	public static void main(String[] args) {

		TextMsg textMsg = new TextMsg();
		textMsg.setTouser("aaabbcc");

		TextMsgItem text = new TextMsgItem();
		text.setContent("helloworld");
		textMsg.setText(text);

		textMsg.setMsgtype(MsgType.TEXT_TYPE);

		String jsonString = JSONObject.toJSONString(textMsg);
		System.out.println(jsonString);

		System.out.println("------------------");

		NewsMsg newsMsg = new NewsMsg();
		newsMsg.setTouser("aaaa");
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

		String js = JSONObject.toJSONString(newsMsg);
		System.out.println(js);

		System.out.println("------------------");

	}
}
