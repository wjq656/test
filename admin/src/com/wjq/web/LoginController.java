package com.wjq.web;

import static com.wjq.util.TzConstant.SESSION_USER;
import static com.wjq.util.TzConstant.SESSION_USER_USERNAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjq.bean.User;
import com.wjq.bean.WjqParams;
import com.wjq.core.BaseController;
import com.wjq.service.user.IUserService;
import com.wjq.util.TmStringUtils;


@Controller
public class LoginController extends BaseController{
	
	@Autowired
	IUserService userService;
	
	@RequestMapping("login")
	public String login(){
		System.out.println("login");
		return "login";
	}
	
	//这样表示不通过核心拦截器，对返回页面进行处理  直接把return的字符串传到前台跟servlet的out.println()效果相同
	@ResponseBody
	@RequestMapping(value="logined")
	public String logined(WjqParams params){
		//通过参数 让其自动注入数据 前提是名字要一样  键  跟属性名
		if(params != null){
			if(TmStringUtils.isNotEmpty(params.getEmail())&&TmStringUtils.isNotEmpty(params.getPassword())){
				//params.setPassword(TmStringUtils.md5Base64(params.getPassword()));
				User user =userService.getLogin(params);
				if(user!=null){
					if(user.getForbiden()==1){
						//该账户禁止登录
						return "forbiden";
					}else{
						session.setAttribute(SESSION_USER, user);
						session.setAttribute(SESSION_USER_USERNAME, user.getUsername());
						//登录成功，进入成功首页
						return "success";
					}
				}
				//账户名/密码错误
				return "messageError";
			}
			//账户名或密码没有填写完整，请重新填写
			return "error";
		}else{
			//账户名和密码没有填写，请重新填写
			return "error";
		}
	}
	
	//登出，删除session数据
	@RequestMapping("logout")
	public String logout(){
		session.invalidate();
		return "redirect:login";
	}
}
