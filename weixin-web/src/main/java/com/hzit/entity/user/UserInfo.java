package com.hzit.entity.user;

/**
 * 存储用户信息
 * 
 * @author THINK
 *
 */
public class UserInfo {

	private String openid;
	private String lang = "zh_CN";// 默认中文

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "UserInfo [openid=" + openid + ", lang=" + lang + "]";
	}

}
