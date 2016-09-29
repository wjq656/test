package com.wjq.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjq.bean.User;
import com.wjq.bean.WjqParams;
import com.wjq.dao.user.IUserDao;
import com.wjq.service.user.IUserService;



//第一部加注解
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDao userDao;
	
	
	@Override
	public User getLogin(WjqParams params) {
		
		return userDao.getLogin(params);
	}

}
