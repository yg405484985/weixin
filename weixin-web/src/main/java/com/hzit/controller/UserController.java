package com.hzit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hzit.entity.user.UserInfo;
import com.hzit.entity.user.UserInfoList;
import com.hzit.proxy.user.WXProxyUsers;

@EnableAutoConfiguration
@RestController
public class UserController {

	/**
	 * 获取用户详情列表
	 * 
	 * @return
	 */
	@RequestMapping("getUserInfoList")
	public Object getUserInfoList() {

		// 获取所有的openId
		List<String> userOpenList = getUserOpenList();

		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		UserInfo userInfo = null;
		/*
		 * 将获取到的openId循环存放到UserInfo里面,并放到List里面
		 */
		for (String openid : userOpenList) {
			userInfo = new UserInfo();
			userInfo.setOpenid(openid);
			userInfoList.add(userInfo);
		}

		// 创建对象，作為post参数
		UserInfoList userInfoList2 = new UserInfoList();
		userInfoList2.setUser_list(userInfoList);

		// 将实体类转为json格式的数据
		String jsonString = JSONObject.toJSONString(userInfoList2);

		// 根据指定参数，获取用户详情列表
		String info = WXProxyUsers.getUserListInfo(jsonString);

		System.out.println("参数:" + jsonString);
		System.out.println("返回结果:" + info);
		return info;
	}

	/**
	 * 得到所有的用户的openId
	 * 
	 * @return
	 */
	public List<String> getUserOpenList() {

		// 用来存放所有的openID
		List<String> arrayList = new ArrayList<>();

		// 后去所有的openid不指定next_openId从头开始查找
		String userList = WXProxyUsers.getUserList(null);

		// 转为json对象，方便操作
		JSONObject jsonObject = JSONObject.parseObject(userList);
		if (jsonObject.containsKey("data")) {
			// 为了得到 指定openid字符列表
			JSONArray object = jsonObject.getJSONObject("data").getJSONArray("openid");
			// 将JSONArray的字符串转为List<String>
			arrayList = JSONArray.parseArray(object.toJSONString(), String.class);
		}
		return arrayList;
	}

	public static void main(String[] args) {
		List<String> userOpenList = new UserController().getUserOpenList();
		System.out.println(userOpenList);
	}
}
