package servlet_cou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;

import dao.Couinfo;

public class SerCouAdd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String type=req.getParameter("type");
		int credit=Integer.parseInt(req.getParameter("credit"));
		int tid=Integer.parseInt(req.getParameter("tid"));
		Couinfo dao=new Couinfo();
		dao.couAdd(id, name, type, credit, tid);
		
		
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
