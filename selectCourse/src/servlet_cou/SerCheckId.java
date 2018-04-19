package servlet_cou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import dao.*;

public class SerCheckId extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		String cid=req.getParameter("cid");
		Couinfo dao=new Couinfo();
		Course cou=dao.checkId(cid);
		 if(cou==null){
			 out.print("°Ã");
		 }
		 else{
			 out.print("∏√’À∫≈“—¥Ê‘⁄£°");
		 }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
