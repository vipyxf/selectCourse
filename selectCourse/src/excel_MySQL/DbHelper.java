package excel_MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DbJdbc;

public class DbHelper {
 DbJdbc dao=new DbJdbc();
 Connection con=null;
 PreparedStatement pst=null;
 ResultSet rs=null;
 
	//查询
	public ResultSet Search(String sql,String str[]){
	   con=dao.dbConn();
	   try {
		pst=con.prepareStatement(sql);
		if(str!=null){
			for(int i=0;i<str.length;i++){
				pst.setString(i+1, str[i]);
			}
		}
		rs=pst.executeQuery();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return rs;
	}
	
	//增删改操作
	public int adu(String sql,String str[]){
		int a=0;
		con=dao.dbConn();
		try {
			pst=con.prepareStatement(sql);
			if(str!=null){
				for(int i=0;i<str.length;i++){
					pst.setString(i+1, str[i]);
				}
			}
			a=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
