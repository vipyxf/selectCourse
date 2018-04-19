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
  
  //连接数据库
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
  
  
  
	//获取用于向数据库发送SQL语句，并获取结果集
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
  
  //查询结果
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
  
  

  //连接数据库
  public void ConnData(String sql){
	  try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,pwd);
		st=conn.createStatement();
		st.executeUpdate(sql);   //执行增删改查SQL请求语句
		//rs=st.executeQuery(sql); //返回结果集，执行查询功能，进行元素的遍历
	} catch (Exception e) {
		close();
		e.printStackTrace();
	}
	 
  }
  
  
  //关闭对象
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
  
  
//4、增删改
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
