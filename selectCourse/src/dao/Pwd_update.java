package dao;

public class Pwd_update {
//�޸Ĺ���Ա����
	public void pwdUp(int id, String pwd){
		String sql="update manager set password='"+pwd+"' where id="+id;
		DbJdbc dao=new DbJdbc();
		dao.ConnData(sql);
	}
	
	//�޸Ľ�ʦ����
	public void tpwdUp(int id, String pwd){
		String sql="update teacher set password='"+pwd+"' where id="+id;
		DbJdbc dao=new DbJdbc();
		dao.ConnData(sql);
	}
	
	//�޸�ѧ������
	public void spwdUp(int id, String pwd){
		String sql="update student set password='"+pwd+"' where id="+id;
		DbJdbc dao=new DbJdbc();
		dao.ConnData(sql);
	}
}
