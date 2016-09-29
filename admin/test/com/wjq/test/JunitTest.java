package com.wjq.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wjq.bean.AdminStat;
import com.wjq.bean.Comment;
import com.wjq.bean.Content;
import com.wjq.bean.User;
import com.wjq.bean.WjqParams;
import com.wjq.dao.adminStat.IAdminStatDao;
import com.wjq.service.adminStat.IAdminStatService;
import com.wjq.service.comment.ICommentService;
import com.wjq.service.content.IContentService;
import com.wjq.service.user.IUserService;
import com.wjq.util.TmStringUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class JunitTest {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private IContentService contentService;
	
	@Autowired
	private IAdminStatDao adminStatDao;
	
	@Autowired
	private IAdminStatService adminStatService;
	
	
	@Test
	public void handle(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		/*DruidDataSource dataSource = context.getBean(DruidDataSource.class);
		System.out.println(dataSource);*/
		//IUserDao  userDao = context.getBean(IUserDao.class);	
		//System.out.println(userService);
		WjqParams params = new WjqParams();
		/*数据库字段，bean对象属性，param参数属性，的类型要求一致，  数据类型转换应该作用在流程的哪里？*/
		params.setId("11");
		params.setPassword("11");
		User users =userService.getLogin(params);
		System.out.println(users.getPassword()+"==="+users.getUsername());
	}
	@Test
	public void handle3(){
		/*Comment comment = new Comment();
		comment.setContentId(1);
		comment.setContent("我是通过java后台mybatis插入的,可是报错了，却么有返回值");
		comment.setUserId(1);
		int save = commentService.saveComment(comment);
		System.out.println(save);*/

		WjqParams params = new WjqParams();
		params.setPageSize(3);
		params.setPageNum(1);
		params.setKeyword("2");
		int pages = params.getPageSize()*(params.getPageNum()-1);
		params.setPageAll(pages);
		List<Content> contents = contentService.searchContents(params);
		for(Content content : contents){
			String time = new SimpleDateFormat("yyyy年MM月dd日").format(content.getCreateTime());
			System.out.println(time);
		}
	
	} 

	@Test
	public void handle2(){
		
		System.out.println(TmStringUtils.md5Base64("11"));
	}
	
	@Test
	public void handle5(){
		Content content = new Content();
		content.setId(3);
		content.setIsDelete(1);
		content.setIsTop(1);
		int status = contentService.update(content);
		System.out.println("111"+status);
	}
	
	@Test
	public void handle6(){
		/*long time = 1;
		AdminStat adminstat = new AdminStat();
		adminstat.setIp("120.1.0.0");
		adminstat.setIpAddress("120.3.1.0");
		adminstat.setMethod("findContent");
		adminstat.setModel("model");
		adminstat.setTime(time);
		adminstat.setUserId(1);
		adminstat.setDescription("description");
		int a = adminStatDao.save(adminstat);
		System.out.println(a);*/
		long time = 1;
		AdminStat adminstat = new AdminStat();
		adminstat.setResultType("resultType");
		adminstat.setClassName("className");
		adminstat.setIp("request.getRemoteAddr()");
		adminstat.setIpAddress("request.getRemoteHost()");
		adminstat.setMethod("MethodName");
		adminstat.setModel("model");
		adminstat.setTime(time);
		adminstat.setUserId(1);
		adminstat.setDescription("description"); 
		adminStatService.save(adminstat); 
	}
}


