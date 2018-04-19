package servlet_tea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;

import dao.Teainfo;

public class TServletDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teainfo dao=new Teainfo();
		int id=Integer.parseInt(req.getParameter("id"));
		dao.deleteTea(id);
		
		 List<Teacher> tea=dao.getAllTeacher();
         req.setAttribute("tea", tea);
         req.getRequestDispatcher("managers/into-tea/tea-delete.jsp").forward(req, resp);
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req,resp);
	}

}
