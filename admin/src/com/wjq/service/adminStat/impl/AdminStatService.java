package com.wjq.service.adminStat.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjq.bean.AdminStat;
import com.wjq.dao.adminStat.IAdminStatDao;
import com.wjq.service.adminStat.IAdminStatService;

@Service
public class AdminStatService implements IAdminStatService{
	
	@Autowired
	private IAdminStatDao adminstatDao;
	
	@Override
	public int save(AdminStat adminStat) {
		return adminstatDao.save(adminStat);
	}
	
}
