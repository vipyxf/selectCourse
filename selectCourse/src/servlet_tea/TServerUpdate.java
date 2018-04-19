package servlet_tea;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;

import dao.LoginJdbc;

public class TServerUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginJdbc dao=new LoginJdbc();
		int id=Integer.parseInt(req.getParameter("id"));
		 Teacher tea= dao.tealogin(id);
		 req.setAttribute("t", tea);
		 req.getRequestDispatcher("managers/into-tea/tupdate.jsp").forward(req, resp);
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req,resp);
	}

}
