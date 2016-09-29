package com.wjq.bean;

import java.util.Date;

public class Comment implements java.io.Serializable{
	
	//评论ID
	private Integer id;
	//评论内容
	private String content;
	//创建时间
	private Date createTime;
	//评论用户的ID
	private Integer userId;
	//文章的ID
	private Integer contentId;
	//是否删除    0：未删除  1：已删除
	private Integer isDelete;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
}
