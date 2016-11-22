package first;
import javax.servlet.http.*;
public class servlet extends HttpServlet{
	

	public void init(){
		System.out.println("进入倒了init()方法");
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入到了 doGet方法");
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("进入倒了 doPost");
		String msg = request.getParameter("msg");
		System.out.println(msg);
	}
	public void destory(){
		System.out.println("进入到了的story方法");
	}
}
