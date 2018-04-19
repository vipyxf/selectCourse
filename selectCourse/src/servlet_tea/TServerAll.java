package servlet_tea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;

import dao.Teainfo;

public class TServerAll extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           Teainfo dao=new Teainfo();
           List<Teacher> tea=dao.getAllTeacher();
           request.setAttribute("tea", tea);
           String str=request.getParameter("id");
           if(str.equals("select")){
        	   request.getRequestDispatcher("managers/into-tea/tea-select.jsp").forward(request, response);
           }
           else if(str.equals("update")){
        	   request.getRequestDispatcher("managers/into-tea/tea-update.jsp").forward(request, response);
           }
           else if(str.equals("delete")){
        	   request.getRequestDispatcher("managers/into-tea/tea-delete.jsp").forward(request, response);
           }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
