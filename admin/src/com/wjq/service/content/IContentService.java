package com.wjq.service.content;

import java.util.List;

import com.wjq.bean.Content;
import com.wjq.bean.WjqParams;

public interface IContentService {
	
	//获取文章信息
	public List<Content> findContents(WjqParams params);
	//获取文章数目
	public int ContentsAccount(WjqParams params);
	//获取查询的文章
	public List<Content> searchContents(WjqParams params);
	//查询文章的数量
	public int searchAccount(WjqParams params);
	//更改是否评论，制订，删除
	public int update(Content content);
}
