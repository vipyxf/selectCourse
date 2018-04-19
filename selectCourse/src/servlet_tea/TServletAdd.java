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
		//super.doGet(req, resp);  ���ɸ����doGet���������405���󣨷���������������̨�����IllegalStateException���Ƿ�״̬�쳣��
		Teainfo dao=new Teainfo();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String title=req.getParameter("title");
		String dep=req.getParameter("department");
		dao.teaAdd(id, name, pwd, title, dep);
		
		//��ӳɹ�����ת����ѯҳ��
		List<Teacher> tea=dao.getAllTeacher();
		req.setAttribute("tea", tea);
		 req.getRequestDispatcher("managers/into-tea/tea-select.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);��ȥ����������쳣
		doGet(req,resp);
	}

}
