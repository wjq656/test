package com.wjq.service.adminStat;

import org.springframework.stereotype.Service;

import com.wjq.bean.AdminStat;

@Service
public interface IAdminStatService {
	public int save(AdminStat adminStat);
}
