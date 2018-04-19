package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Teacher;

public class Teainfo {
	List<Teacher>  listTea=new ArrayList<Teacher>();
	DbJdbc dt=new DbJdbc();
	
	
	
	//1.׼�������ݿ��������ѧ����Ϣ
	public void teaShowAll(String sql){
		dt.dbConn();
		try {
			dt.st=dt.conn.createStatement();
			dt.rs=dt.st.executeQuery(sql);
			ResultSet trs=dt.rs;
			while(trs.next()){
				int id=trs.getInt(1);
				String name=trs.getString(2);
				String pwd=trs.getString(3);
				String  title=trs.getString(4);
				String bumen=trs.getString(5);
				Teacher tea=new Teacher(id,name,pwd,title,bumen);
				listTea.add(tea);
				
			}
		} catch (SQLException e) {
			dt.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//2����ѯ���н�ʦ��Ϣ
  public List<Teacher> getAllTeacher(){
	String sql="select * from teacher";
	  teaShowAll(sql);
	  return listTea;
  }
  
  
  //3����ѯ������ʦ��Ϣ
  public List<Teacher> getOneTeacher(String id, String name){
	  if(id!=null){

      	String sql="select * from teacher where id like '%"+id+"%'";
      	teaShowAll(sql); 
  	}
  	else if (name!=null){
  		String sql="select * from teacher where tname like '%"+name+"%' ";
  		teaShowAll(sql);
  	}
  	return listTea;
  }
  
  
 //4�����ӽ�ʦ��Ϣ
  public void  teaAdd(int id,String name,String pwd,String title,String dep){
	  String sql="insert into teacher value(" + id + ",'" + name + "','"
				+ pwd + "','" + title + "','" + dep + "')";
	 new DbJdbc ().zsg(sql);   //������ɾ�ĵķ���
	 
  }
  
  
  //5���޸Ľ�ʦ��Ϣ
  
  public void updatetea(int id, String name, String pwd, String title,
			String dep) {
		String sql = "update teacher set tname='" + name + "',password='" + pwd
				+ "',title='" + title + "',department='" + dep + "'  where id=" + id;
		dt.zsg(sql);
	}
  
  
//6��ɾ����ʦ��Ϣ
	public void deleteTea(int id) {
		String sql = "delete from teacher where id=" + id;
	dt.zsg(sql);
	}
  
}
