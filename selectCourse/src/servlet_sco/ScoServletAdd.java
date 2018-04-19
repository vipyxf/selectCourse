package servlet_sco;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;

import dao.Scoinfo;

public class ScoServletAdd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		int stuid=Integer.parseInt(req.getParameter("stuid"));
		String name=req.getParameter("name");
		String banji=req.getParameter("banji");
		String cid=req.getParameter("cid");
		String cname=req.getParameter("cname");
		int fenshu=Integer.parseInt(req.getParameter("fenshu"));
		Scoinfo dao=new Scoinfo();
		dao.scoAdd(id, stuid, name, banji, cid, cname, fenshu);
		
		
		//添加成功后返回到查询页面
		List<Score>  sco=dao.getAllScore();
		req.setAttribute("sco", sco);
		 req.getRequestDispatcher("managers/manager-score/sco-select.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
