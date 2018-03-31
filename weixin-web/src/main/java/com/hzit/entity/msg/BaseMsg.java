package com.hzit.entity.msg;

/**
 * 不同类型消息 存在的相同的属性
 * 
 * @author THINK
 *
 */
public class BaseMsg {

	
	protected String touser;
	protected String msgtype;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

}
