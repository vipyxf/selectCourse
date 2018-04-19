package excel_MySQL;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import model.Student;

public class DbToExcel1 {
	WritableWorkbook wwb = null;
	public void  outPage(String filename){
		try{
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
		}
		// ��fileNameΪ�ļ�������һ��WorkBook
				wwb = Workbook.createWorkbook(file);
				// ����������
				WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
				// ��ѯ���ݿ��е���������
				List<Student> list = StuService.getAllData();
				// Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
				Label lid = new Label(0, 0, "ѧ�ţ�ID��");
				Label lname = new Label(1, 0, "����(name)");
				Label lpwd = new Label(2, 0, "����(pwd)");
				Label lbj = new Label(3, 0, "�༶");
				Label lhome = new Label(4, 0, "����");
				Label lphone = new Label(5, 0, "�绰");
				Label lemail = new Label(6, 0, "����");
				ws.addCell(lid);
				ws.addCell(lname);
				ws.addCell(lpwd);
				ws.addCell(lbj);
				ws.addCell(lhome);
				ws.addCell(lphone);
				ws.addCell(lemail);
				for (int i = 0; i < list.size(); i++) {
					/*Java��intת��ΪString�͵ķ���
					 * 1��String.valueOf(i)
					 * 2��Integer.toString(i)
					 * 3��i+""
					 * 
					 * */
					
					Label lid1 = new Label(0, i + 1, list.get(i).getSid() + "");
					Label lname1 = new Label(1, i + 1, list.get(i).getSname());
					Label lpwd1 = new Label(2, i + 1, list.get(i).getSpwd());
					Label lbj1 = new Label(3, i + 1, list.get(i).getBanji());
					Label lhome1 = new Label(4, i + 1, list.get(i).getHome());
					Label lphone1 = new Label(5, i + 1, list.get(i).getPhone() + "");
					Label lemail1 = new Label(6, i + 1, list.get(i).getEmail());
					ws.addCell(lid1);
					ws.addCell(lname1);
					ws.addCell(lpwd1);
					ws.addCell(lbj1);
					ws.addCell(lhome1);
					ws.addCell(lphone1);
					ws.addCell(lemail1);
				}
				// д���ĵ�
				wwb.write();
				// �ر�Excel������
				wwb.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
}
