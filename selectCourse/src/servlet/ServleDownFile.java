package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServleDownFile extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    //得到要下载的文件名
		String fileName=req.getParameter("filename");  
		fileName=new String(fileName.getBytes("iso8859-1"),"utf-8");
		//上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
		String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
        //通过文件名找出文件的所在目录
        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
        //得到要下载的文件
        File file = new File(path + "\\" + fileName);
        if(!file.exists()){
        	req.setAttribute("message","你要下载的资源已被删除");
        	req.getRequestDispatcher("students/message.jsp").forward(req, resp);
        	return ;
        }
        //处理文件名
        String realname=fileName.substring(fileName.indexOf("_")+1);
        
        //判断浏览器
        if("FF".equals(getBrowser(req))){
        	//针对火狐浏览器的realname处理
        	realname=new String(realname.getBytes("utf-8"),"iso-8859-1");
        }
        else{
        	realname=URLEncoder.encode(realname, "utf-8");
        }
        
        //设置响应头，控制浏览器下载该文件
       //resp.setHeader("content-disposition", "attachment;filename=
        //"+URLEncoder.encode(realname,"utf-8"))  ;
        resp.setHeader("content-disposition", "attachment;filename="+realname)  ;
        
        //读取要下载的文件，保存到文件输入流
        FileInputStream in=new FileInputStream(path+"\\"+fileName);
        //创建输出流
        OutputStream out=resp.getOutputStream();
        //创建缓冲区
        byte buffer[]=new byte[1024];
        int len=0;
        //循环将输入流中的读取到缓冲区当中
            while((len=in.read(buffer))>0){
            //输出缓冲区中的内容到浏览器，实现文件下载
            	out.write(buffer, 0, len);
        }
            //关闭文件输出流
            out.close();
            //关闭文件输入流
            in.close();
	     
	}
      /*通过文件名和存储上传文件跟目录找出要下载的文件的所在路径
       * filename要下载的文件名
       * FileSaveRootPath上传文件保存的根目录，也就是WEB-INF/upload目录
       * return 要下载文件的存储目录
       * */
	private String findFileSavePathByFileName(String fileName,
			String fileSaveRootPath) {
		 int hashcode=fileName.hashCode();
		 int dir1=hashcode&0xf;  //0-15
		 int dir2=(hashcode&0xf)>>4; //0-15
		 String dir=fileSaveRootPath+"\\"+dir1+"\\"+dir2;  //upload\2\3  upload\3\5
		 File file=new File(dir);
		 if(!file.exists()){
			 //创建目录
			 file.mkdirs();
		 }

		return dir;
	}

	
	//服务器端判断客户端浏览器类型的方法
	private String getBrowser(HttpServletRequest req){
		String userAgent=req.getHeader("USER-AGENT").toLowerCase();
		if(userAgent!=null){
			if(userAgent.indexOf("msie")>=0)
				return "IE";
			if(userAgent.indexOf("firefox")>=0)
				return "FF";
			if(userAgent.indexOf("safari")>=0)
				return "SF";
			
		}
		return null;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 doGet(req,resp);
	}

}
