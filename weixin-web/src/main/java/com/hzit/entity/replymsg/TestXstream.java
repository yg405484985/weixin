package com.hzit.entity.replymsg;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

/**
 * java和xml互相转换 http://blog.csdn.net/scyatcs/article/details/12625099
 * 
 * @author THINK
 *
 */
public class TestXstream {

	/**
	 * 将java对象转为xml
	 */
	@Test
	public void toXml() {

		ReplyTextMsg replyTextMsg = new ReplyTextMsg();
		replyTextMsg.setContent("hellomoto");
		replyTextMsg.setCreateTime(123456);
		replyTextMsg.setFromUserName("aabbcc");
		replyTextMsg.setMsgId("12345");
		replyTextMsg.setMsgType("TEXT");
		replyTextMsg.setToUserName("CCBBAA");

		XStream xStream = new XStream();
		// 取别名
		xStream.alias("xml", ReplyTextMsg.class);
		String xml = xStream.toXML(replyTextMsg);

		System.out.println(xml);

	}

	@Test
	public void toJava() {

		String xml = "<xml><ToUserName>CCBBAA</ToUserName><FromUserName>aabbcc</FromUserName><CreateTime>123456</CreateTime><MsgType>TEXT</MsgType><MsgId>12345</MsgId><Content>hellomoto</Content></xml>";

		XStream xStream = new XStream();
		xStream.aliasType("xml", ReplyTextMsg.class);

		ReplyTextMsg fromXML = (ReplyTextMsg) xStream.fromXML(xml);
		System.out.println(fromXML);

	}

}
