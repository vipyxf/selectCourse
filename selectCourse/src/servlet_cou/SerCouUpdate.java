package servlet_cou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;

import dao.Couinfo;

public class SerCouUpdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	     Couinfo dao=new Couinfo();
	     String id=req.getParameter("id");
	     Course cou=dao.checkId(id);
	     req.setAttribute("cou", cou);
	     req.getRequestDispatcher("managers/manager-course/cupdate.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req,resp);
	}
	

}
