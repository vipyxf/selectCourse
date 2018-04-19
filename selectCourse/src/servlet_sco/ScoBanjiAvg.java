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
		// һ�����ƽ����
		String condition = "banji='1��' and cname='����'";
		int oneg = dao.bjavg(condition);
		req.setAttribute("oneg", oneg);
		// �������ƽ����
		String condition1 = "banji='2��' and cname='����'";
		int twog = dao.bjavg(condition1);
		req.setAttribute("twog", twog);
		// �������ƽ����
		String condition2 = "banji='3��' and cname='����'";
		int threeg = dao.bjavg(condition2);
		req.setAttribute("threeg", threeg);
		// �İ����ƽ����
		String condition3 = "banji='4��' and cname='����'";
		int fourg = dao.bjavg(condition3);
		req.setAttribute("fourg", fourg);

		// һ��java����ƽ����
		String java1 = "banji='1��' and cname='java����'";
		int j1 = dao.bjavg(java1);
		req.setAttribute("j1", j1);
		// ����java����ƽ����
		String java2 = "banji='2��' and cname='java����'";
		int j2 = dao.bjavg(java2);
		req.setAttribute("j2", j2);
		// ����java����ƽ����
		String java3 = "banji='3��' and cname='java����'";
		int j3 = dao.bjavg(java3);
		req.setAttribute("j3", j3);
		// �İ�java����ƽ����
		String java4 = "banji='4��' and cname='java����'";
		int j4 = dao.bjavg(java4);
		req.setAttribute("j4", j4);

		// һ��MySQLƽ����
		String mysql1 = "banji='1��' and cname='MySQL'";
		int m1 = dao.bjavg(mysql1);
		req.setAttribute("m1", m1);
		// ����MySQLƽ����
		String mysql2 = "banji='2��' and cname='MySQL'";
		int m2 = dao.bjavg(mysql2);
		req.setAttribute("m2", m2);
		// ����MySQLƽ����
		String mysql3 = "banji='3��' and cname='MySQL'";
		int m3 = dao.bjavg(mysql3);
		req.setAttribute("m3", m3);
		// �İ�MySQLƽ����
		String mysql4 = "banji='4��' and cname='MySQL'";
		int m4 = dao.bjavg(mysql4);
		req.setAttribute("m4", m4);

		// һ��webǰ��ƽ����
		String web1 = "banji='1��' and cname='webǰ��'";
		int w1 = dao.bjavg(web1);
		req.setAttribute("w1", w1);
		// ����webǰ��ƽ����
		String web2 = "banji='2��' and cname='webǰ��'";
		int w2 = dao.bjavg(web2);
		req.setAttribute("w2", w2);
		// ����webǰ��ƽ����
		String web3 = "banji='3��' and cname='webǰ��'";
		int w3 = dao.bjavg(web3);
		req.setAttribute("w3", w3);
		// �İ�webǰ��ƽ����
		String web4 = "banji='4��' and cname='webǰ��'";
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
