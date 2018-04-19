package servlet_stu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;

import dao.Scoinfo;

public class ServletStuSco extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = (Integer) request.getSession().getAttribute("mid");
		Scoinfo dao=new Scoinfo();
		List<Score> sco=dao.StuScore(id);
		request.setAttribute("sco", sco);
		request.getRequestDispatcher("students/stusco.jsp").forward(request, response);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  doGet(request,response);
	}

}
