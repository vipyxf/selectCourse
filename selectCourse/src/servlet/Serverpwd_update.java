package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Pwd_update;

public class Serverpwd_update extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Pwd_update dao = new Pwd_update();
		int id = (Integer) request.getSession().getAttribute("mid");
		String pwd = request.getParameter("xpwd");
		String radio = (String) request.getSession().getAttribute("shenfen");
		if (radio.equals("管理员")) {
			dao.pwdUp(id, pwd);
			request.getSession().setAttribute("xpwd", pwd);
			request.getRequestDispatcher("managers/info-man/pwd.jsp").forward(
					request, response);
		}
		else if(radio.equals("教师")){
			dao.tpwdUp(id, pwd);
			request.getSession().setAttribute("xpwd", pwd);
			request.getRequestDispatcher("teachers/pwd.jsp").forward(
					request, response);
		}
		else if(radio.equals("学生")){
			dao.spwdUp(id, pwd);
			request.getSession().setAttribute("xpwd", pwd);
			request.getRequestDispatcher("students/pwd.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
