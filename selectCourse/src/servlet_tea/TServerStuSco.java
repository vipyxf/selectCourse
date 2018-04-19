package servlet_tea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Scoinfo;

import model.Score;

public class TServerStuSco extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = (Integer) request.getSession().getAttribute("mid");
		Scoinfo dao=new Scoinfo();
		List<Score> sco=dao.TeaScore(id);
		request.setAttribute("sco", sco);
		request.getRequestDispatcher("teachers/Tstusco.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
