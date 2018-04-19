package servlet_sco;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;

import dao.Scoinfo;

public class ScoServletDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Scoinfo dao=new Scoinfo();
		 int id=Integer.parseInt(req.getParameter("id"));
		 dao.scoDelete(id);
		 
		 
		 List<Score> sco= dao.getAllScore();
         req.setAttribute("sco", sco);
         req.getRequestDispatcher("managers/manager-score/sco-delete.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req,resp);
	}
	

}
