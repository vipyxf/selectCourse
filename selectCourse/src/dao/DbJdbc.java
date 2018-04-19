package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbJdbc {
  Connection conn=null;
  Statement st=null;
  ResultSet rs=null;
  
  
  String  driver="com.mysql.jdbc.Driver";
  String url = "jdbc:mysql://localhost:3306/selectcourse?useUnicode=true&characterEncoding=utf8";
  String user="root";
  String pwd="root";
  
  //�������ݿ�
  public Connection dbConn(){
	  try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,pwd);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return conn;
  }
  
  
  
	//��ȡ���������ݿⷢ��SQL��䣬����ȡ�����
  public void SqlRequest(String sql){
	  try {
		  conn=dbConn();
		st=conn.createStatement();
		rs=st.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  //��ѯ���
  public ResultSet selectSql(String sql){
	  try {
		  
		  conn=dbConn();
		st=conn.createStatement();
		rs=st.executeQuery(sql);
	} catch (Exception e) {
		close();
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return rs;
  }
  
  

  //�������ݿ�
  public void ConnData(String sql){
	  try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,pwd);
		st=conn.createStatement();
		st.executeUpdate(sql);   //ִ����ɾ�Ĳ�SQL�������
		//rs=st.executeQuery(sql); //���ؽ������ִ�в�ѯ���ܣ�����Ԫ�صı���
	} catch (Exception e) {
		close();
		e.printStackTrace();
	}
	 
  }
  
  
  //�رն���
  public void close(){
	  try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
  }
  
  
//4����ɾ��
	public void zsg(String sql) {
		dbConn();
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

  
}
