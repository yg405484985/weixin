package com.hzit.entity.msg.news;

import java.util.List;

/**
 * 图文消息
 * 
 * @author THINK
 *
 */
public class NewsMsgArticles {

	private List<NewsMsgArticlesItem> articles;

	public List<NewsMsgArticlesItem> getArticles() {
		return articles;
	}

	public void setArticles(List<NewsMsgArticlesItem> articles) {
		this.articles = articles;
	}

}
