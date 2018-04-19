package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import dao.LoginJdbc;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 int id=Integer.parseInt(request.getParameter("jid"));
		   String pwd=request.getParameter("jpwd");
		String radio=request.getParameter("identify");
		//设置session会话时间，当里面的参数为-1时，从不失效 ；当为正数时，它的寿命为该正数；默认值为1800s
		request.getSession().setMaxInactiveInterval(-1);  
		 int a =  request.getSession().getMaxInactiveInterval();
		 System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		   System.out.println("\n\n\nSession在服务器中保存的时间："+a);
		if(radio.equals("学生")){

			   LoginJdbc dao=new LoginJdbc();
			   Student stu=dao.stulogin(id);

			  /* HttpSession session=request.getSession();  //创建一个session对象   
			   session.setAttribute("session",manager);*/
	          if(stu!=null){
	        	  if(stu.getSid()==id){
	        		  if(stu.getSpwd().equals(pwd)){
	        			  request.getSession().setAttribute("shenfen", radio);
	        			  request.getSession().setAttribute("mid", stu.getSid());
	        			  request.getSession().setAttribute("name", stu.getSname());
	        			  request.getSession().setAttribute("pwd", stu.getSpwd());
	        			  request.getSession().setAttribute("bj", stu.getBanji());
	        			  request.getSession().setAttribute("home", stu.getHome());
	        			  request.getSession().setAttribute("phone", stu.getPhone());
	        			  request.getSession().setAttribute("email", stu.getEmail());
	        			  request.getRequestDispatcher("main/smain.jsp").forward(request,response);
	        		  }
	        		  else{
	        			  request.setAttribute("mima", "你输入的密码有误，请重新输入");
	        			  request.getRequestDispatcher("login.jsp").forward(request,response);
	        		  }
	        	  }
	        	  else{
	        		  request.setAttribute("zhanghao", "你输入的账号有误");
	        		  request.getRequestDispatcher("login.jsp").forward(request,response);
	        	  }
	          }
	          else{
	        	  request.setAttribute("manager", "用户不存在");
	        	  request.getRequestDispatcher("login.jsp").forward(request,response);
	          }
	            	
			
			
			
			
		}
		else if(radio.equals("教师")){

			   LoginJdbc dao=new LoginJdbc();
			   Teacher tea=dao.tealogin(id);
	          if(tea!=null){
	        	  if(tea.getTid()==id){
	        		  if(tea.getTpwd().equals(pwd)){
	        			  request.getSession().setAttribute("shenfen", radio);
	        			  request.getSession().setAttribute("mid", tea.getTid());
	        			  request.getSession().setAttribute("name", tea.getTname());
	        			  request.getSession().setAttribute("pwd",tea.getTpwd());
	        			  request.getSession().setAttribute("title", tea.getTitle());
	        			  request.getSession().setAttribute("department", tea.getDepartment());
	        			  request.getRequestDispatcher("main/tmain.jsp").forward(request,response);
	        		  }
	        		  else{
	        			  request.setAttribute("mima", "你输入的密码有误，请重新输入");
	        			  request.getRequestDispatcher("login.jsp").forward(request,response);
	        		  }
	        	  }
	        	  else{
	        		  request.setAttribute("zhanghao", "你输入的账号有误");
	        		  request.getRequestDispatcher("login.jsp").forward(request,response);
	        	  }
	          }
	          else{
	        	  request.setAttribute("manager", "用户不存在");
	        	  request.getRequestDispatcher("login.jsp").forward(request,response);
	          }
	            	
			
			
			
		}
		else if(radio.equals("管理员")){
		   LoginJdbc dao=new LoginJdbc();
		   Manager manager=dao.login(id);
          if(manager!=null){
        	  if(manager.getId()==id){
        		  if(manager.getPwd().equals(pwd)){
        			  request.getSession().setAttribute("shenfen", radio);
        			  request.getSession().setAttribute("mid", manager.getId());
        			  request.getSession().setAttribute("name", manager.getName());
        			  request.getSession().setAttribute("pwd", manager.getPwd());
        			  request.getSession().setAttribute("age", manager.getAge());
        			  request.getRequestDispatcher("main/main.jsp").forward(request,response);
        		  }
        		  else{
        			  request.setAttribute("mima", "你输入的密码有误，请重新输入");
        			  request.getRequestDispatcher("login.jsp").forward(request,response);
        		  }
        	  }
        	  else{
        		  request.setAttribute("zhanghao", "你输入的账号有误");
        		  request.getRequestDispatcher("login.jsp").forward(request,response);
        	  }
          }
          else{
        	  request.setAttribute("manager", "用户不存在");
        	  request.getRequestDispatcher("login.jsp").forward(request,response);
          }
            	
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              doGet(request,response);
	}

}
