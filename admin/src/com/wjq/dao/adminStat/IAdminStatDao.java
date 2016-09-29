package com.wjq.dao.adminStat;

import org.springframework.stereotype.Component;

import com.wjq.bean.AdminStat;

@Component
public interface IAdminStatDao {
	public int save(AdminStat adminStat);
}
