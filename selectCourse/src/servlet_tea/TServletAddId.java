package servlet_tea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.Teacher;

import dao.LoginJdbc;

public class TServletAddId extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int tid=Integer.parseInt(req.getParameter("tid"));
		LoginJdbc dao=new LoginJdbc();
		 Teacher tea= dao.tealogin(tid);
		 if(tea==null){
			 out.print("°Ã");
		 }
		 else{
			 out.print("∏√’À∫≈“—¥Ê‘⁄£°");
		 }
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
          doGet(req,resp);
	}

}
