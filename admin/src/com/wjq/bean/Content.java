package com.wjq.bean;

import java.util.Date;

public class Content implements java.io.Serializable{
	
	//主键ID
		private Integer id;
		//主标题
		private String title;
		//文章内容
		private String content;
		//创建时间
		private Date createTime;
		//更新时间
		private Date updateTime;
		//发布者ID
		private Integer userId;
		//发布者姓名
		private String userName;
		//标签
		private String tag;
		//是否置顶
		private Integer isTop;
		//是否删除
		private Integer isDelete;
		//状态
		private Integer status;
		//栏目ID
		private Integer channelId;
		//图片地址
		private String img;
		//是否推送
		private Integer push;
		//是否评论
		private Integer isComment;
		//点击数量
		private Integer hits;
		//喜爱数量
		private Integer loves;
		//收藏数量
		private Integer collections;
		//静态链接
		private String staticLink;
		//关键词
		private String keywords;
		//描述
		private String description;
		//子标题
		private String subTitle;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
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
		public Date getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public Integer getIsTop() {
			return isTop;
		}
		public void setIsTop(Integer isTop) {
			this.isTop = isTop;
		}
		public Integer getIsDelete() {
			return isDelete;
		}
		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public Integer getChannelId() {
			return channelId;
		}
		public void setChannelId(Integer channelId) {
			this.channelId = channelId;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public Integer getPush() {
			return push;
		}
		public void setPush(Integer push) {
			this.push = push;
		}
		public Integer getIsComment() {
			return isComment;
		}
		public void setIsComment(Integer isComment) {
			this.isComment = isComment;
		}
		public Integer getHits() {
			return hits;
		}
		public void setHits(Integer hits) {
			this.hits = hits;
		}
		public Integer getLoves() {
			return loves;
		}
		public void setLoves(Integer loves) {
			this.loves = loves;
		}
		public Integer getCollections() {
			return collections;
		}
		public void setCollections(Integer collections) {
			this.collections = collections;
		}
		public String getStaticLink() {
			return staticLink;
		}
		public void setStaticLink(String staticLink) {
			this.staticLink = staticLink;
		}
		public String getKeywords() {
			return keywords;
		}
		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getSubTitle() {
			return subTitle;
		}
		public void setSubTitle(String subTitle) {
			this.subTitle = subTitle;
		}
		
		
		
	
}
