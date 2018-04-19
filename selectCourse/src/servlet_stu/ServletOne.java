package servlet_stu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

import dao.Stuinfo;

public class ServletOne extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    String conid=null;
		    String conname=null;
            String str=request.getParameter("txtin"); //从form表单中拿值
            char c=str.charAt(0);                    //取到将form表单中拿到值的第一个字符
            if(c>=48 && c<=57){                         //将第一个字符进行判断
            	conid=str;
            }
            else{
            	conname=str;
            }
           Stuinfo dao=new Stuinfo();
           List<Student> stu=dao.getOneStudent(conid, conname);
           request.setAttribute("s", stu);
           request.getRequestDispatcher("managers/into-stu/stu-select.jsp").forward(request, response);
	     
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
