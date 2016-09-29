package com.wjq.dao.content;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wjq.bean.Content;
import com.wjq.bean.WjqParams;

@Component
public interface IContentDao {
	
	public List<Content> findContents(WjqParams params);
	public int ContentsAccount(WjqParams params);
	public List<Content> searchContents(WjqParams params);
	public int searchAccount(WjqParams params);
	public int update(Content content);
}
