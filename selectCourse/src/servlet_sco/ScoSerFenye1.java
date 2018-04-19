package servlet_sco;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;

import dao.*;

public class ScoSerFenye1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ScoFenye dao=new ScoFenye();
		int maxPage=dao.pageNum();
		req.setAttribute("pp", maxPage);
		//int pageNow=Integer.parseInt(req.getParameter("pageNow"));
		String str=req.getParameter("pageNow");
		int pageNow=1;
		if(!str.equals("")){
			pageNow=Integer.parseInt(str); 
		}
		 if(pageNow<1){
			pageNow=1;
		}
		 if(pageNow>maxPage){
			pageNow=maxPage;
		}
		req.setAttribute("pageNow",pageNow);
		 List<Score> list=dao.fenye1(pageNow);
		 req.setAttribute("sco", list);
		 req.getRequestDispatcher("managers/manager-score/sco-fenye.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req,resp);
	}

}
