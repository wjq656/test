package com.wjq.web.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjq.bean.Content;
import com.wjq.service.content.impl.ContentService;


@Controller
@RequestMapping("/admin/content")
public class ContentController {
	
	@Autowired
	ContentService contentService;
	
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Content content){ 
		contentService.update(content);
		//用了@ResponseBody  springmvc不会对返回进行拼接  而是在ajax的success的字符串参数返回 
		return "success";
	}
}
