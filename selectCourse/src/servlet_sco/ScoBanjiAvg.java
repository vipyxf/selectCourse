package servlet_sco;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Scoinfo;

public class ScoBanjiAvg extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Scoinfo dao = new Scoinfo();
		// 一班高数平均分
		String condition = "banji='1班' and cname='高数'";
		int oneg = dao.bjavg(condition);
		req.setAttribute("oneg", oneg);
		// 二班高数平均分
		String condition1 = "banji='2班' and cname='高数'";
		int twog = dao.bjavg(condition1);
		req.setAttribute("twog", twog);
		// 三班高数平均分
		String condition2 = "banji='3班' and cname='高数'";
		int threeg = dao.bjavg(condition2);
		req.setAttribute("threeg", threeg);
		// 四班高数平均分
		String condition3 = "banji='4班' and cname='高数'";
		int fourg = dao.bjavg(condition3);
		req.setAttribute("fourg", fourg);

		// 一班java基础平均分
		String java1 = "banji='1班' and cname='java基础'";
		int j1 = dao.bjavg(java1);
		req.setAttribute("j1", j1);
		// 二班java基础平均分
		String java2 = "banji='2班' and cname='java基础'";
		int j2 = dao.bjavg(java2);
		req.setAttribute("j2", j2);
		// 三班java基础平均分
		String java3 = "banji='3班' and cname='java基础'";
		int j3 = dao.bjavg(java3);
		req.setAttribute("j3", j3);
		// 四班java基础平均分
		String java4 = "banji='4班' and cname='java基础'";
		int j4 = dao.bjavg(java4);
		req.setAttribute("j4", j4);

		// 一班MySQL平均分
		String mysql1 = "banji='1班' and cname='MySQL'";
		int m1 = dao.bjavg(mysql1);
		req.setAttribute("m1", m1);
		// 二班MySQL平均分
		String mysql2 = "banji='2班' and cname='MySQL'";
		int m2 = dao.bjavg(mysql2);
		req.setAttribute("m2", m2);
		// 三班MySQL平均分
		String mysql3 = "banji='3班' and cname='MySQL'";
		int m3 = dao.bjavg(mysql3);
		req.setAttribute("m3", m3);
		// 四班MySQL平均分
		String mysql4 = "banji='4班' and cname='MySQL'";
		int m4 = dao.bjavg(mysql4);
		req.setAttribute("m4", m4);

		// 一班web前端平均分
		String web1 = "banji='1班' and cname='web前端'";
		int w1 = dao.bjavg(web1);
		req.setAttribute("w1", w1);
		// 二班web前端平均分
		String web2 = "banji='2班' and cname='web前端'";
		int w2 = dao.bjavg(web2);
		req.setAttribute("w2", w2);
		// 三班web前端平均分
		String web3 = "banji='3班' and cname='web前端'";
		int w3 = dao.bjavg(web3);
		req.setAttribute("w3", w3);
		// 四班web前端平均分
		String web4 = "banji='4班' and cname='web前端'";
		int w4 = dao.bjavg(web4);
		req.setAttribute("w4", w4);
		
		req.getRequestDispatcher("managers/manager-score/chart-banji.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
