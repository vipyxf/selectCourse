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
	    //�õ�Ҫ���ص��ļ���
		String fileName=req.getParameter("filename");  
		fileName=new String(fileName.getBytes("iso8859-1"),"utf-8");
		//�ϴ����ļ����Ǳ�����/WEB-INF/uploadĿ¼�µ���Ŀ¼����
		String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
        //ͨ���ļ����ҳ��ļ�������Ŀ¼
        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
        //�õ�Ҫ���ص��ļ�
        File file = new File(path + "\\" + fileName);
        if(!file.exists()){
        	req.setAttribute("message","��Ҫ���ص���Դ�ѱ�ɾ��");
        	req.getRequestDispatcher("students/message.jsp").forward(req, resp);
        	return ;
        }
        //�����ļ���
        String realname=fileName.substring(fileName.indexOf("_")+1);
        
        //�ж������
        if("FF".equals(getBrowser(req))){
        	//��Ի���������realname����
        	realname=new String(realname.getBytes("utf-8"),"iso-8859-1");
        }
        else{
        	realname=URLEncoder.encode(realname, "utf-8");
        }
        
        //������Ӧͷ��������������ظ��ļ�
       //resp.setHeader("content-disposition", "attachment;filename=
        //"+URLEncoder.encode(realname,"utf-8"))  ;
        resp.setHeader("content-disposition", "attachment;filename="+realname)  ;
        
        //��ȡҪ���ص��ļ������浽�ļ�������
        FileInputStream in=new FileInputStream(path+"\\"+fileName);
        //���������
        OutputStream out=resp.getOutputStream();
        //����������
        byte buffer[]=new byte[1024];
        int len=0;
        //ѭ�����������еĶ�ȡ������������
            while((len=in.read(buffer))>0){
            //����������е����ݵ��������ʵ���ļ�����
            	out.write(buffer, 0, len);
        }
            //�ر��ļ������
            out.close();
            //�ر��ļ�������
            in.close();
	     
	}
      /*ͨ���ļ����ʹ洢�ϴ��ļ���Ŀ¼�ҳ�Ҫ���ص��ļ�������·��
       * filenameҪ���ص��ļ���
       * FileSaveRootPath�ϴ��ļ�����ĸ�Ŀ¼��Ҳ����WEB-INF/uploadĿ¼
       * return Ҫ�����ļ��Ĵ洢Ŀ¼
       * */
	private String findFileSavePathByFileName(String fileName,
			String fileSaveRootPath) {
		 int hashcode=fileName.hashCode();
		 int dir1=hashcode&0xf;  //0-15
		 int dir2=(hashcode&0xf)>>4; //0-15
		 String dir=fileSaveRootPath+"\\"+dir1+"\\"+dir2;  //upload\2\3  upload\3\5
		 File file=new File(dir);
		 if(!file.exists()){
			 //����Ŀ¼
			 file.mkdirs();
		 }

		return dir;
	}

	
	//���������жϿͻ�����������͵ķ���
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
