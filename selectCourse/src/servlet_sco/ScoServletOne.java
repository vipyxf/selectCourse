package servlet_sco;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import dao.*;

public class ScoServletOne extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String conid=null;
		    String conname=null;
      String str=request.getParameter("txtin"); //��form������ֵ
      char c=str.charAt(0);                    //ȡ����form�����õ�ֵ�ĵ�һ���ַ�
      if(c>=48 && c<=57){                         //����һ���ַ������ж�
      	conid=str;
      }
      else{
      	conname=str;
      }
     Scoinfo dao=new Scoinfo();
     List<Score> sco=dao.getOneScore(conid, conname);
     request.setAttribute("sco", sco);
     request.getRequestDispatcher("managers/manager-score/sco-select.jsp").forward(request, response);
	     
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
