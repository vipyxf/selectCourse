package servlet_stu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

import dao.Stuinfo;

public class Servletsxupdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Stuinfo dao=new Stuinfo();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String banji=req.getParameter("banji");
		String home=req.getParameter("home");
		int phone=Integer.parseInt(req.getParameter("phone"));
		String email=req.getParameter("email");
		dao.updateStu(id, name, pwd, banji, home, phone, email);
		
		List<Student> stu=dao.getAllStudent();
		req.setAttribute("s", stu);
		req.getRequestDispatcher("managers/into-stu/stu-update.jsp").forward(req, resp);
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req,resp);
	}

}
