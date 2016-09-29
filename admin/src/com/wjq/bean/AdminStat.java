package com.wjq.bean;

import java.util.Date;

public class AdminStat {
	//id
	private Integer id;
	//创建时间
	private Date createTime;
	/*adminStat.setIp(TmIpUtil.getIpAddress(request));
	adminStat.setIpAddress(TmIpUtil.ipLocation(request));*/
	//IP
	private String ip;
	//ip地址
	private String ipAddress;
	//用户id
	private Integer userId;
	//执行方法
	private String method;
	//共花时间
	private Long time;
	//类名
	private String className;
	//返回类型
	private String resultType;
	
	private String model;
	private String description;
	
	
	
	
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AdminStat [id=" + id + ", createTime=" + createTime + ", ip="
				+ ip + ", ipAddress=" + ipAddress + ", userId=" + userId
				+ ", method=" + method + ", time=" + time + ", className="
				+ className + ", resultType=" + resultType + ", model=" + model
				+ ", description=" + description + "]";
	}
	
	
}
