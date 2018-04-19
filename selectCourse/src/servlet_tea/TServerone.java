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
         String str=request.getParameter("txtin"); //从form表单中拿值
         char c=str.charAt(0);                    //取到将form表单中拿到值的第一个字符
         if(c>=48 && c<=57){                         //将第一个字符进行判断
         	conid=String.valueOf(c);
         }
         else{
         	conname=String.valueOf(c);    //将字符装换为字符串
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
