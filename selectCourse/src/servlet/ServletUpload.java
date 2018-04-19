package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")  // ȡ�������ע��
public class ServletUpload extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ�����ڷ�����WEB-INFĿ¼�£����������ֱ�ӷ��ʣ�
		 * ��֤�ϴ��ļ��İ�ȫ
		 * */
		String savePath=this.getServletContext().getRealPath("WEB-INF/upload");
		//�ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
		String tempPath=this.getServletContext().getRealPath("WEB-INF/temp");
		File tmpFile=new File(tempPath);
		if(!tmpFile.exists()){
			//������ʱĿ¼
			tmpFile.mkdir();
		}
		//��Ϣ��ʾ
		String message="";
		try{
			//ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			//1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//���ù����������Ĵ�С�����ϴ����ļ���С�����������Ĵ�С�ǣ��ͻ�����һ����ʱ�ļ����ڷŵ�ָ������ʱĿ¼���С�
			factory.setSizeThreshold(1024*1024*5);//���û������Ĵ�СΪ5MB�������ָ������ô�������Ĵ�СĬ����10KB
			//�����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
			factory.setRepository(tmpFile);
			//2������һ���ļ��ϴ�������
			ServletFileUpload upload=new ServletFileUpload(factory);
			//�����ļ��ϴ�����
			upload.setProgressListener(new ProgressListener() {
				public void update(long pBytesRead, long pContentLength, int arg2) {
					// TODO Auto-generated method stub
					System.out.println("�ļ���СΪ��"+pContentLength+",��ǰ�Ѵ���"+pBytesRead);
					
				}
			});
			//����ϴ��ļ�������������
			upload.setHeaderEncoding("utf-8");
			//3���ж��ύ�����������Ƿ����ϴ���������
			if(!ServletFileUpload.isMultipartContent(req)){
				//���մ�ͳ��ʽ��ȡ����
				return;
			}
			//�����ϴ������ļ��Ĵ�С�����ֵ
			upload.setFileSizeMax(1024*1024);
			//�����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ�����ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
			upload.setSizeMax(1024*1024*10);
			//4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���List<FileItem>���ϣ�ÿһ�� FIleItem��Ӧһ��Form����������    ,
			List<FileItem> list=upload.parseRequest(req);
			for(FileItem item:list){
				//���fileitem�з�װ������ͨ�����������
				if(item.isFormField()){
					String name=item.getFieldName();
					//�����ͨ����������ݵ�������������
					String value=item.getString("utf-8");
					System.out.println(name+"="+value);
				}
				else{
					//���fileitem�з�װ�����ϴ��ļ�
					//�õ��ϴ��ļ�������
					String filename=item.getName();
					System.out.println(filename);
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					//ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ�
					//�磺C��\a\b\1.txt������Щ֪ʶ�������ļ������磺1.txt
					//�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename=filename.substring(filename.lastIndexOf("\\")+1);
					//�õ��ļ��ϴ�����չ��
					String fileExtName=filename.substring(filename.lastIndexOf(".")+1);
					//�����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
					System.out.println("�ϴ����ļ�����չ���ǣ�"+fileExtName);
					//���item�е��ϴ��ļ���������
					InputStream in=item.getInputStream();
					//�õ��ļ����������
                    String saveFilename = makeFileName(filename);
                    //�õ��ļ��ı���Ŀ¼
                    String realSavePath=makePath(saveFilename,savePath);
                    //����һ���ļ������
                    FileOutputStream out=new FileOutputStream(realSavePath+"\\"+saveFilename);
                    //����һ��������
                    byte buffer[]=new byte[1024];
                    //�ж��������е������Ƿ��Ѿ�����ı�ʶ
                    int len=0;
                    //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʶin���滹������
                    while((len=in.read(buffer))>0){
                    	//ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath+"\\"+filename)����
                    	out.write(buffer,0,len);
                    }
                    //�ر�������
                    in.close();
                    //�ر������
                    out.close();
                    //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
                    //item.delete();
                    message="�ļ��ϴ��ɹ�!";
                    
				}
			}
			
			
		}catch(FileUploadBase.FileSizeLimitExceededException e){
			e.printStackTrace();
			req.setAttribute("message", "�����ļ��������ֵ!!!");
			req.getRequestDispatcher("managers/info-man/message.jsp").forward(req, resp);
	     return;	
		} catch(FileUploadBase.SizeLimitExceededException e){
			e.printStackTrace();
			req.setAttribute("message", "�ϴ��ļ����ܴ�С�������Ƶ����ֵ������");
			req.getRequestDispatcher("managers/info-man/message.jsp").forward(req, resp);
          return ;
		}catch(Exception e){
			message="�ļ��ϴ�ʧ�ܣ�";
			e.printStackTrace();
		}
		req.setAttribute("message", message);
		System.out.println("pppp"+message);
		req.getRequestDispatcher("managers/info-man/message.jsp").forward(req, resp);
	}

	private String makePath(String saveFilename, String savePath) {
		//�õ��ļ�����hashCode��ֵ���õ��ľ���saveFilename����ַ����������ڴ��еĵ�ַ
		int hashcode=saveFilename.hashCode();
		int dir1=hashcode&0xf; //0--15
		int dir2=(hashcode&0xf)>>4; //0-15
		//�����µı���Ŀ¼
		String dir=savePath+"\\"+dir1+"\\"+dir2;//upload\2\3 upload\3\5
		//File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
		File file=new File(dir);
		//���Ŀ¼������
		if(!file.exists()){
			//����Ŀ¼
			file.mkdirs();
		}
		return dir;
	}

	private String makeFileName(String filename) {
     //Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
		return UUID.randomUUID().toString()+"_"+filename; 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
         doGet(req,resp);
	}

}
