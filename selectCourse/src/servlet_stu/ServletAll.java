package servlet_stu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

import dao.Stuinfo;

public class ServletAll extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Stuinfo  dao=new Stuinfo();
		List<Student> stu=dao.getAllStudent();
		request.setAttribute("s", stu);
		String str=request.getParameter("id");
		if(str.equals("select")){
		 
		request.getSession().setAttribute("allstu", "/managers/into-stu/stu-allselect.jsp");
		request.getRequestDispatcher("managers/into-stu/stu-select.jsp").forward(request, response);
		}
		
		else if(str.equals("update")){
		request.getRequestDispatcher("managers/into-stu/stu-update.jsp").forward(request, response);
		}
		else if(str.equals("delete")){
			request.getRequestDispatcher("managers/into-stu/stu-delete.jsp").forward(request, response);
			}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	       doGet(request,response);
	}

}
