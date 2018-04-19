package servlet_stu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

import dao.Stuinfo;

public class ServletStuDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Stuinfo dao=new Stuinfo();
		int id=Integer.parseInt(req.getParameter("id"));
		dao.deleteStu(id);
		
		 //添加成功后，跳转到查询页面
        List<Student> stu=dao.getAllStudent();
		req.setAttribute("s", stu);
		req.getRequestDispatcher("managers/into-stu/stu-delete.jsp").forward(req, resp);
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
