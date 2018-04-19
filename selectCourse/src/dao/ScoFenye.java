package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Score;

public class ScoFenye {
 int  pageSize=2;   //每页的条数
 int pageCount;  //总共的页数
 int pageNow;     //当前页
 int count;      //总共的条数
 DbJdbc dt=new DbJdbc();  //连接数据库对象
 List<Score> list=new ArrayList<Score>();
 Score sco=null;
 Connection con=null;
 Statement st=null;
 ResultSet rst=null;  //遍历数据库
 
 
 public int pageNum(){          //求总页数的方法
	 String sql="select * from score";
	 try {
		
		  rst=dt.selectSql(sql);
		  
		 rst.last();   //遍历最后一条数据
		 count=rst.getRow();  //获得总条数
		 pageCount=(count+(pageSize-1))/pageSize;
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return pageCount;
 }
	
 
 public  List<Score> fenye1(int pageNow){
	 int start=(pageNow-1)*pageSize;     //每一页的第一条数据
	//limit的start是从start+1开始，到start+1+pageSize结束
	 String sql="select * from score limit "+start+","+pageSize;  
	// con= dt.dbConn();
	 try {
		
			rst=dt.selectSql(sql);	  
			while(rst.next()){
			int id = rst.getInt(1);
			int stuid = rst.getInt(2);
			String name = rst.getString(3);
			String bj = rst.getString(4);
			String kc = rst.getString(5);
			String kname = rst.getString(6);
			int fen = rst.getInt(7);
			sco = new Score(id, stuid, name, bj, kc, kname, fen);
			list.add(sco);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return list;
 }
 
 
 
 
 
}
