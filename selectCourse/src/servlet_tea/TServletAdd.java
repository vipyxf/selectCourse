package servlet_tea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;

import dao.Teainfo;

public class TServletAdd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);  集成父类的doGet方法会出现405错误（方法不被允许），后台会出现IllegalStateException（非法状态异常）
		Teainfo dao=new Teainfo();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String title=req.getParameter("title");
		String dep=req.getParameter("department");
		dao.teaAdd(id, name, pwd, title, dep);
		
		//添加成功后跳转到查询页面
		List<Teacher> tea=dao.getAllTeacher();
		req.setAttribute("tea", tea);
		 req.getRequestDispatcher("managers/into-tea/tea-select.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);不去掉，会出现异常
		doGet(req,resp);
	}

}
