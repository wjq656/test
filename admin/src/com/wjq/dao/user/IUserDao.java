package com.wjq.dao.user;

import com.wjq.bean.User;
import com.wjq.bean.WjqParams;

public interface IUserDao {
	
	public User getLogin(WjqParams params);
}
