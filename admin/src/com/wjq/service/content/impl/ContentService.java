package com.wjq.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjq.bean.Content;
import com.wjq.bean.WjqParams;
import com.wjq.dao.content.IContentDao;
import com.wjq.service.content.IContentService;

@Service
public class ContentService implements IContentService{
	
	@Autowired
	IContentDao contentDao;
	
	@Override
	public List<Content> findContents(WjqParams params) {
		return contentDao.findContents(params);
	}

	@Override
	public int ContentsAccount(WjqParams params) {
		// TODO Auto-generated method stub
		return contentDao.ContentsAccount(params);
	}

	@Override
	public List<Content> searchContents(WjqParams params){
		return contentDao.searchContents(params);
	}

	@Override
	public int searchAccount(WjqParams params) {
		// TODO Auto-generated method stub
		return contentDao.searchAccount(params);
	}

	@Override
	public int update(Content content) {
		return contentDao.update(content);
	}

}
