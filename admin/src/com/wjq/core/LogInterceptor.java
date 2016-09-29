package com.wjq.core;

import javax.servlet.ServletContext;

import static com.wjq.util.TzConstant.*;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.wjq.bean.AdminStat;
import com.wjq.bean.User;
import com.wjq.dao.adminStat.IAdminStatDao;
import com.wjq.service.adminStat.IAdminStatService;
import com.wjq.util.TmStringUtils;

 @Aspect
@Component 
public class LogInterceptor implements ServletContextAware{
	 
	private ServletContext application;
	@Autowired
	private IAdminStatService  adminStatService;
	@Around("execution(* com.wjq.service.*.*.*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint point) throws Throwable{
		
		//获取正在执行的方法名
		String MethodName = point.getSignature().getName();
		System.out.println(MethodName);
		//当用户登录的时候  直接放行  不做记录
		if(TmStringUtils.isNotEmpty(MethodName)&&MethodName.equals("getLogin")){
			return point.proceed();
		}
		//类名为什么是？object  通过这个对象可以获取到这个类  getclass()
		Object classObj = point.getTarget();//拦截的类名 
		//获取执行前的时间
		long start = System.currentTimeMillis();
		//执行调用的方法
		Object object = point.proceed();
		//获取执行后的时间
		long end = System.currentTimeMillis();
		//总时间=开始-结束  以毫秒为单位
		long time = end -start ;
		//获取拦截的方法的参数,以对象数组的形式存在
		Object[] params = point.getArgs(); 
		StringBuilder stringbuilder = new StringBuilder("");
		if(params.length>0){
			for(int i = 0;i<params.length;i++){
				stringbuilder.append(String.valueOf(params[i]));
				if(i<params.length-1){
					stringbuilder.append(",");
				}
			} 
		}
	//	System.out.println("进来了");
		//通过classobj获取类名
		String className = classObj.getClass().getName();
		//返回值类型
		String resultType = null;
		if(object!=null){
			resultType = object.getClass().getName();
		}
		//保存日记到数据库 
		saveLog(className,MethodName,time,resultType); 
		return object;
	}
	
	public void saveLog(String className,String MethodName,long time,String resultType){
		//在登陆拦截的时候就把request放进去了 
		HttpServletRequest request= (HttpServletRequest) application.getAttribute("request_log");
		// 获得客户端的ip地址 ，电脑名称映射到网络的地址
		System.out.println("request.getRemoteAddr(): " + request.getRemoteAddr());
		//获得客户端的主机名，电脑的名称
		System.out.println("request.getRemoteHost(): " + request.getRemoteHost()); 
		User user = (User) request.getSession().getAttribute(SESSION_USER);
		System.out.println("userId"+user.getId());
		AdminStat adminstat = new AdminStat();
		adminstat.setResultType(resultType);
		adminstat.setClassName(className);
		adminstat.setIp(request.getRemoteAddr());
		adminstat.setIpAddress(request.getRemoteHost());
		adminstat.setMethod(MethodName);
		adminstat.setModel("model");
		adminstat.setTime(time);
		if(user!=null)
		adminstat.setUserId(user.getId());
		adminstat.setDescription("description"); 
		System.out.println("=====================");
		System.out.println(adminstat);
	//
		//adminStatService.save(adminstat); 
	}
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
		System.out.println("什么时候执行的");
	}
	
}
