package com.wjq.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjq.bean.Content;
import com.wjq.bean.WjqParams;
import com.wjq.core.BaseController02;
import com.wjq.service.content.IContentService;
import com.wjq.service.user.IUserService;


@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController02{
	@Autowired
	IContentService contentService;
	@Autowired
	IUserService userService;
	
	
	@RequestMapping("index")
	public String index(WjqParams params){
		int pageSize = params.getPageSize();
		int pageNum = params.getPageNum();
		//总的文章数目
		double allNum; 
		//总的分为几页
		int allPages;
		//当上一页到边界0是保持第一页
		if(pageNum<1)
			params.setPageNum(1);
		//一旦超过总的页数则为最后一页
		
		List<Content> contents=null;
		if(params.getKeyword()!=null&&params.getKeyword().length()>0){
			//总的文章数目
			allNum = contentService.searchAccount(params); 
			//总的分为几页
			allPages = (int) Math.ceil(allNum/pageSize);
			if(allPages<pageNum)
				params.setPageNum(allPages);
			params.setPageAll(params.getPageSize()*(params.getPageNum()-1));
			contents = contentService.searchContents(params);
		}
		else {
			//总的文章数目
			allNum = contentService.ContentsAccount(params); 
			//总的分为几页
			allPages = (int) Math.ceil(allNum/pageSize);
			if(allPages<pageNum)
				params.setPageNum(allPages);
			params.setPageAll(params.getPageSize()*(params.getPageNum()-1));
			System.out.println("contentaccount执行完成");
			contents = contentService.findContents(params);
			System.out.println("findcount执行完成");
		}  
		request.setAttribute("contents",contents);
		request.setAttribute("params",params);
		request.setAttribute("allPages",allPages);
		return "success";
	}
	
}
