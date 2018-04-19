package servlet_sco;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;

import dao.Scoinfo;

public class ScoServletAll extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          String str=request.getParameter("id");
          Scoinfo  dao=new Scoinfo();
           List<Score> sco= dao.getAllScore();
           request.setAttribute("sco", sco);
           
           if(str.equals("select")){
        	   request.getRequestDispatcher("managers/manager-score/sco-select.jsp").forward(request, response);
           }
           else if(str.equals("update")){
        	   request.getRequestDispatcher("managers/manager-score/sco-update.jsp").forward(request, response);
           }
           else if(str.equals("delete")){
        	   request.getRequestDispatcher("managers/manager-score/sco-delete.jsp").forward(request, response);
           } 
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response)	;
	}

}
