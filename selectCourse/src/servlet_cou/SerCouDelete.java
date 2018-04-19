package servlet_cou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;

import dao.Couinfo;

public class SerCouDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Couinfo dao=new Couinfo();
		String id=req.getParameter("id");
		dao.couDelete(id);
		
		List<Course> cou=dao.getAllCourse();
		req.setAttribute("c", cou);
		req.getRequestDispatcher("managers/manager-course/courseAll.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req,resp);
	}

}
