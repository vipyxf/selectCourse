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

public class ServletStuAdd extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            Stuinfo dao=new Stuinfo();
            int id=Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("name");
            String pwd=request.getParameter("pwd");
            String bj=request.getParameter("banji");
            String home=request.getParameter("home");
            int phone=Integer.parseInt(request.getParameter("phone"));
            String email=request.getParameter("email");
            dao.addStu(id, name, pwd, bj, home, phone, email);
            
            //添加成功后，跳转到查询页面
            List<Student> stu=dao.getAllStudent();
    		request.setAttribute("s", stu);
    		request.getRequestDispatcher("managers/into-stu/stu-select.jsp").forward(request, response);
            
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
