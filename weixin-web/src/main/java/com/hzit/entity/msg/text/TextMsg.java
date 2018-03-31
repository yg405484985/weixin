package com.hzit.entity.msg.text;

import com.hzit.entity.msg.BaseMsg;

/**
 * 文本消息
 * 
 * @author THINK
 *
 */
public class TextMsg extends BaseMsg {

	//文本消息内容
	private TextMsgItem text;

	public TextMsgItem getText() {
		return text;
	}

	public void setText(TextMsgItem text) {
		this.text = text;
	}

}
