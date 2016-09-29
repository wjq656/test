package com.wjq.bean;

import java.util.Date;

public class User implements java.io.Serializable{
	
	//主键ID
	private  Integer id;
	//账户名
	private String username;
	//密码
	private String password;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//登陆状态  1表示禁止  0表示允许
	private Integer forbiden;
	//是否删除  1表示已删除  0表示未删除
	private Integer isDelete;
	//年龄
	private Integer age;
	//性别   0表示男  1表示女
	private Integer male;
	//生日
	private Date birthday;
	//住址
	private String address;
	//邮箱
	private String email;
	//联系方式 手机
	private String  telephnoe;
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Integer getForbiden() {
		return forbiden;
	}
	public void setForbiden(Integer forbiden) {
		this.forbiden = forbiden;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getMale() {
		return male;
	}
	public void setMale(Integer male) {
		this.male = male;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephnoe() {
		return telephnoe;
	}
	public void setTelephnoe(String telephnoe) {
		this.telephnoe = telephnoe;
	}
	
	
	
}
