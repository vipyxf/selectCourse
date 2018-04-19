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
		// 以fileName为文件名创建一个WorkBook
				wwb = Workbook.createWorkbook(file);
				// 创建工作表
				WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
				// 查询数据库中的所有数据
				List<Student> list = StuService.getAllData();
				// 要插入到的Excel表格的行号，默认从0开始
				Label lid = new Label(0, 0, "学号（ID）");
				Label lname = new Label(1, 0, "姓名(name)");
				Label lpwd = new Label(2, 0, "密码(pwd)");
				Label lbj = new Label(3, 0, "班级");
				Label lhome = new Label(4, 0, "籍贯");
				Label lphone = new Label(5, 0, "电话");
				Label lemail = new Label(6, 0, "邮箱");
				ws.addCell(lid);
				ws.addCell(lname);
				ws.addCell(lpwd);
				ws.addCell(lbj);
				ws.addCell(lhome);
				ws.addCell(lphone);
				ws.addCell(lemail);
				for (int i = 0; i < list.size(); i++) {
					/*Java中int转换为String型的方法
					 * 1》String.valueOf(i)
					 * 2》Integer.toString(i)
					 * 3》i+""
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
				// 写进文档
				wwb.write();
				// 关闭Excel工作簿
				wwb.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
}
