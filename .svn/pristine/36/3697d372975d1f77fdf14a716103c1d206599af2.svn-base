package com.hzit.entity.menu;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class TestMenu {

	public static void main(String[] args) {

		// 整个的菜单栏(最多包涵三个一级菜单)
		MenuManage menuManage = new MenuManage();

		// 存放一级菜单
		List<MenuItem> buttonOne = new ArrayList<MenuItem>();

		// 创建第一个一级菜单（存放菜单[点击事件，view]）
		MenuItem item1 = new MenuItem();
		item1.setName("菜单");

		// 封装二级菜单
		List<MenuItem> sub_buttonList = new ArrayList<MenuItem>();
		// click点赞
		MenuItem item_sub_1 = new MenuItem();
		item_sub_1.setType(MenuType.CLICK);
		item_sub_1.setName("赞一个");
		item_sub_1.setKey("CLICK_ZANYIGE");

		// view
		MenuItem item_sub_2 = new MenuItem();
		item_sub_2.setType(MenuType.VIEW);
		item_sub_2.setName("公众号");
		item_sub_2.setUrl("https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432");

		// view
		MenuItem item_sub_3 = new MenuItem();
		item_sub_3.setType(MenuType.VIEW);
		item_sub_3.setName("小程序");
		item_sub_3.setUrl("https://mp.weixin.qq.com/debug/wxadoc/dev/index.html");

		// 添加到二级菜单的集合中
		sub_buttonList.add(item_sub_1);
		sub_buttonList.add(item_sub_2);
		sub_buttonList.add(item_sub_3);

		// 将集合设置到子菜单的选项中
		item1.setSub_button(sub_buttonList);

		// 创建第二个一级菜单(扫码[提示，推事件])
		MenuItem item2 = new MenuItem();
		item2.setName("扫码");

		// 子菜单list
		List<MenuItem> sub_button_list_sm = new ArrayList<MenuItem>();
		// 扫码提示
		MenuItem item_sub_sm_1 = new MenuItem();
		item_sub_sm_1.setName("扫码带提示");
		item_sub_sm_1.setType(MenuType.SCANCODE_WAITMSG);
		item_sub_sm_1.setKey("SCANCODE_MSG");
		item_sub_sm_1.setSub_button(null);

		// 扫码推送
		MenuItem item_sub_sm_2 = new MenuItem();
		item_sub_sm_2.setName("扫码推事件");
		item_sub_sm_2.setType(MenuType.SCANCODE_PUSH);
		item_sub_sm_2.setKey("SCANCODE_PUSH");
		item_sub_sm_2.setSub_button(null);

		// 添加到子菜单集合
		sub_button_list_sm.add(item_sub_sm_1);
		sub_button_list_sm.add(item_sub_sm_2);

		item2.setSub_button(sub_button_list_sm);

		// 创建第三个一级菜单(发图[系统拍照发图,拍照或者相册发图,微信相册发图])
		MenuItem item3 = new MenuItem();
		item3.setName("发图");

		// 创建子菜单容器
		List<MenuItem> sub_button_list_pic = new ArrayList<MenuItem>();

		// 创建自子菜单
		MenuItem item_sub_pic_sys = new MenuItem();
		item_sub_pic_sys.setKey("SYS_PIC");
		item_sub_pic_sys.setName("系统拍照发图");
		item_sub_pic_sys.setType(MenuType.PIC_SYSPHOTO);
		item_sub_pic_sys.setSub_button(null);

		MenuItem item_sub_pic_photo = new MenuItem();
		item_sub_pic_photo.setKey("SYS_PIC_PHONE");
		item_sub_pic_photo.setName("拍照或者相册发图");
		item_sub_pic_photo.setType(MenuType.PIC_PHOTO_OR_ALBUM);
		item_sub_pic_photo.setSub_button(null);

		MenuItem item_sub_pic_weixin = new MenuItem();
		item_sub_pic_weixin.setKey("SYS_PIC_PHONE_WEIXIN");
		item_sub_pic_weixin.setName("微信相册发图");
		item_sub_pic_weixin.setType(MenuType.PIC_WEIXIN);
		item_sub_pic_weixin.setSub_button(null);

		sub_button_list_pic.add(item_sub_pic_sys);
		sub_button_list_pic.add(item_sub_pic_photo);
		sub_button_list_pic.add(item_sub_pic_weixin);

		item3.setSub_button(sub_button_list_pic);

		// 添加一级菜单
		buttonOne.add(item1);
		buttonOne.add(item2);
		buttonOne.add(item3);

		menuManage.setButton(buttonOne);

		String jsonString = JSONObject.toJSONString(menuManage);
		System.out.println(jsonString);

	}
}
