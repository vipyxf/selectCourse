package servlet_tea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import dao.Teainfo;

public class TServerone extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		 String conid=null;
		    String conname=null;
         String str=request.getParameter("txtin"); //��form������ֵ
         char c=str.charAt(0);                    //ȡ����form�����õ�ֵ�ĵ�һ���ַ�
         if(c>=48 && c<=57){                         //����һ���ַ������ж�
         	conid=String.valueOf(c);
         }
         else{
         	conname=String.valueOf(c);    //���ַ�װ��Ϊ�ַ���
         }
        Teainfo dao=new Teainfo();
        List<Teacher> tea=dao.getOneTeacher(conid, conname);
        request.setAttribute("tea", tea);
        request.getRequestDispatcher("managers/into-tea/tea-select.jsp").forward(request, response);
	     
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  doGet(request,response);
	}

}
