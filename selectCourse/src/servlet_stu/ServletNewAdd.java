package servlet_stu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

import dao.*;

public class ServletNewAdd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		int sid=Integer.parseInt(req.getParameter("id"));
		LoginJdbc dao=new LoginJdbc();
		 Student stu= dao.stulogin(sid);
		 if(stu==null){
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
		super.doPost(req, resp);
		
		doGet(req,resp);
	}

}
