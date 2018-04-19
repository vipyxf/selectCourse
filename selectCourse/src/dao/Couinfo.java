package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class Couinfo {
	List<Course> list=new ArrayList<Course>();
	DbJdbc dt=new DbJdbc();
	Course cou=null;
	
	
	//1.准备从数据库遍历所有课程信息
	public void  showCouAll(String sql){
		dt.dbConn();
		try {
			dt.st=dt.conn.createStatement();
			dt.rs=dt.st.executeQuery(sql);
			ResultSet rst=dt.rs;
			while(rst.next()){
				String kc=rst.getString(1);
				String name=rst.getString(2);
				String type=rst.getString(3);
				int credit=rst.getInt(4);
				int tid=rst.getInt(5);
				Course cou=new Course(kc,name,type,credit,tid);
				list.add(cou);
			}
			
		} catch (SQLException e) {
			dt.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2.查询课程信息
public List<Course> getAllCourse(){
	String sql="select * from course";
	showCouAll(sql);
	return list;
	
}

 //3.增加课程信息
public void couAdd(String id,String name,String type,int credit,int tid){
	String sql="insert into course value('"+id+"','"+name+"','"+type+"',"+credit+","+tid+")";
	dt.zsg(sql);
}
   

   //4、删除课程信息
   public void couDelete(String id){
	   String sql="delete from course where cid='"+id+"'";
	   dt.zsg(sql);
   }
   
   
   //5、修改课程信息
   public void couUpdate(String id,String name,String type,int credit,int tid){
	   String sql="update course set cname='"+name+"',type='"+type+"',credit="+credit+",tid="+tid+" where cid='"+id+"'";
	   dt.zsg(sql);
   }


//6、判断新增加的课程号是否已经添加
   public Course checkId(String id){
	   String sql="select * from course where cid='"+id+"'";
	   dt.dbConn();
	   try {
		dt.st=dt.conn.createStatement();
		dt.rs=dt.st.executeQuery(sql);
		ResultSet rst=dt.rs;
		while(rst.next()){
			String kc=rst.getString(1);
			String name=rst.getString(2);
			String type=rst.getString(3);
			int credit=rst.getInt(4);
			int tid=rst.getInt(5);
			 cou=new Course(kc,name,type,credit,tid);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cou;
	   
   }
   
}
