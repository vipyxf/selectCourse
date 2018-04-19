package excel_MySQL;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import dao.DbJdbc;

import model.Student;

public class StuService {
	static List<Student> list=new ArrayList<Student>();
	static DbHelper dh=new DbHelper();
	static ResultSet rs=null;
	static DbJdbc dt=new DbJdbc();
	
	static Student stu=null;
	
	//��ѯѧ�����е���������
	public static List<Student> getAllData(){
		 String sql="select * from student";
		 try{
		  rs=dh.Search(sql, null);
		  while(rs.next()){
			 int id=rs.getInt("id");
			 String name=rs.getString("sname");
			 String pwd=rs.getString("password");
			 String bj=rs.getString("banji");
			 String home=rs.getString("home");
			 int phone=rs.getInt("phone");
			 String email=rs.getString("email");
			 stu=new Student(id,name,pwd,bj,home,phone,email);
			 list.add(stu);
		  }
		  
		 }catch(Exception e){
			 dt.close();
			 e.printStackTrace();
		 }
		return list;
	}
	
	
	//��ѯָ��Ŀ¼�е��ӱ���е���������
	public static  List<Student> getAllByExecel(String file){
		try{
			Workbook wb=Workbook.getWorkbook(new File(file));
			Sheet st=wb.getSheet("Test Shee 1");
			int clos=st.getColumns();  //���������
			int rows=st.getRows();     //���������
			System.out.println("�У�"+clos+"\t�У�"+rows);
			for(int i=1;i<rows;i++){
				for(int j=0;j<clos;j++){
					String id=st.getCell(j++,i).getContents();//Ĭ������ߵı��Ҳ��һ�У�����j++
					System.out.println("id="+id);
					String name=st.getCell(j++,i).getContents();
					String pwd=st.getCell(j++,i).getContents();
					String bj=st.getCell(j++,i).getContents();
					String home=st.getCell(j++,i).getContents();
					String phone=st.getCell(j++,i).getContents();
					String email=st.getCell(j++,i).getContents();
					System.out.println("id:"+id+"\tname:"+name+"\tpwd"+pwd+"\tbj:"+
					bj+"\t���᣺"+home+"\t�绰��"+phone+"email:"+email);
					/* stu=new Student(Integer.parseInt(id),name,pwd,bj,home,Integer.parseInt(phone),email);
					 list.add(stu);*/
					 list.add(new Student(Integer.parseInt(id),name,pwd,bj,home,Integer.parseInt(phone),email));
				}
			}
		}catch(Exception e){
			dt.close();
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	//ͨ��Id�ж��Ƿ����
	public static boolean isExit(int id){
		try{
			String sql="select * from student where id=?";
			rs=dh.Search(sql, new String[]{id+""});
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args){
		list=getAllData();
		for(Student stu:list){
			System.out.println(stu.toString());
		}
		System.out.println(isExit(1));
	}
}
