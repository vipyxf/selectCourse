package excel_MySQL;

import java.util.List;

import model.Student;

public class ExcelToDb {

	
	public static void main(String[] args) {
		 //得到表格中所有数据
		List<Student> list=StuService.getAllByExecel("E://tt1.xls");
		DbHelper dh=new DbHelper();
		for(Student s:list){
			int id=s.getSid();
			if(!StuService.isExit(id)){
				//不存在就添加
				String sql="insert into student(sname,password,banji,home,phone,email) values(?,?,?,?,?,?)";
				String[] str=new String[]{s.getSname(),s.getSpwd(),s.getBanji(),s.getHome(),s.getPhone()+"",s.getEmail()} ;
				dh.adu(sql, str);
			}
			else{
				//存在就更新
				String sql="update student set sname=?,password=?,banji=?,home=?,phone=?,email=? where id=?";
				String[] str=new String[]{s.getSname(),s.getSpwd(),s.getBanji(),s.getHome(),s.getPhone()+"",s.getEmail(),id+""} ;
				dh.adu(sql, str);
			}
		}
        
	}

}
