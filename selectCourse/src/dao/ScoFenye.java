package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Score;

public class ScoFenye {
 int  pageSize=2;   //ÿҳ������
 int pageCount;  //�ܹ���ҳ��
 int pageNow;     //��ǰҳ
 int count;      //�ܹ�������
 DbJdbc dt=new DbJdbc();  //�������ݿ����
 List<Score> list=new ArrayList<Score>();
 Score sco=null;
 Connection con=null;
 Statement st=null;
 ResultSet rst=null;  //�������ݿ�
 
 
 public int pageNum(){          //����ҳ���ķ���
	 String sql="select * from score";
	 try {
		
		  rst=dt.selectSql(sql);
		  
		 rst.last();   //�������һ������
		 count=rst.getRow();  //���������
		 pageCount=(count+(pageSize-1))/pageSize;
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return pageCount;
 }
	
 
 public  List<Score> fenye1(int pageNow){
	 int start=(pageNow-1)*pageSize;     //ÿһҳ�ĵ�һ������
	//limit��start�Ǵ�start+1��ʼ����start+1+pageSize����
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
