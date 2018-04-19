package dao;

public class Pwd_update {
//修改管理员密码
	public void pwdUp(int id, String pwd){
		String sql="update manager set password='"+pwd+"' where id="+id;
		DbJdbc dao=new DbJdbc();
		dao.ConnData(sql);
	}
	
	//修改教师密码
	public void tpwdUp(int id, String pwd){
		String sql="update teacher set password='"+pwd+"' where id="+id;
		DbJdbc dao=new DbJdbc();
		dao.ConnData(sql);
	}
	
	//修改学生密码
	public void spwdUp(int id, String pwd){
		String sql="update student set password='"+pwd+"' where id="+id;
		DbJdbc dao=new DbJdbc();
		dao.ConnData(sql);
	}
}
