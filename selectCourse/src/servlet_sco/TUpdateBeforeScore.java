package servlet_sco;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;

import dao.Scoinfo;

public class TUpdateBeforeScore extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sid=Integer.parseInt(req.getParameter("id"));
		int stuid=Integer.parseInt(req.getParameter("stuid"));
		String name=req.getParameter("name");
		String banji=req.getParameter("banji");
		String cid=req.getParameter("cid");
		String cname=req.getParameter("cname");
		int fenshu=Integer.parseInt(req.getParameter("fenshu"));
		Scoinfo dao=new Scoinfo();
		dao.scoUpdate(sid, stuid, name, banji, cid, cname, fenshu);
		
		
		int tid=(Integer)req.getSession().getAttribute("mid");
		List<Score> sco=dao.TeaScore(tid);
		req.setAttribute("sco", sco);
		req.getRequestDispatcher("teachers/Tstusco.jsp").forward(req, resp);
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req,resp);
	}

}
