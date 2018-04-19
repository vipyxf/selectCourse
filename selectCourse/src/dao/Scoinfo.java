package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Score;

public class Scoinfo {
	List<Score> list = new ArrayList<Score>();
	DbJdbc dt = new DbJdbc();
	Score sco=null;

	// 1.׼�������ݿ��������ѧ���ɼ���Ϣ
	public void showScoreAll(String sql) {
		dt.dbConn();
		try {
			dt.st = dt.conn.createStatement();
			dt.rs = dt.st.executeQuery(sql);
			ResultSet rst = dt.rs;
			while (rst.next()) {
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
		} catch (SQLException e) {
			dt.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 2����ѯ����ѧ���ĳɼ���Ϣ
	public List<Score> getAllScore() {
		String sql = "select * from score";
		showScoreAll(sql);

		return list;
	}

	// 3�� ��ѯ����ѧ���ĳɼ���Ϣ
	public List<Score> getOneScore(String id, String name) {
		if (id != null) {

			String sql = "select * from score where stuId like '%" + id + "%'";
			showScoreAll(sql);
		} else if (name != null) {
			String sql = "select * from score where stuname like '%" + name
					+ "%' ";
			showScoreAll(sql);
		}

		return list;
	}

	// 4��ѧ���鿴���˳ɼ�
	public List<Score> StuScore(int id) {
		String sql = "select * from score where stuid=" + id;
		showScoreAll(sql);
		return list;
	}

	// 5����ʦ�鿴ѧ���ɼ�
	public List<Score> TeaScore(int id) {
		String sql = " select * from score where cname=(SELECT cname from course where tid="
				+ id + ")";
		showScoreAll(sql);
		return list;
	}

	// 6.���ѧ���ɼ���Ϣ
	public void scoAdd(int sid, int stuId, String stuname, String banji,
			String cid, String cname, int fenshu) {
		String sql = "insert into score value(" + sid + "," + stuId + ",'"
				+ stuname + "','" + banji + "','" + cid + "','" + cname + "',"
				+ fenshu + ")";
		dt.zsg(sql);
	}

	// 7��ɾ��ѧ���ɼ���Ϣ
	public void scoDelete(int sid) {
		String sql = "delete from score where sid=" + sid;
		dt.zsg(sql);
	}

	// 8���޸�ѧ���ɼ���Ϣ
	public void scoUpdate(int sid, int stuId, String stuname, String banji,
			String cid, String cname, int fenshu) {
		String sql = "update score set stuId=" + stuId + ",stuname='" + stuname
				+ "',banji='" + banji + "',cid='" + cid + "',cname='" + cname + "',fenshu=" + fenshu
				+ " where sid="+sid;
		dt.zsg(sql);
	}
	
	
	//9���������һ���ɼ�
	public Score getOneScore(int id){
		String sql="select * from score where sid="+id;
		dt.dbConn();
		try {
			dt.st = dt.conn.createStatement();
			dt.rs = dt.st.executeQuery(sql);
			ResultSet rst = dt.rs;
			while (rst.next()) {
				int sid = rst.getInt(1);
				int stuid = rst.getInt(2);
				String name = rst.getString(3);
				String bj = rst.getString(4);
				String kc = rst.getString(5);
				String kname = rst.getString(6);
				int fen = rst.getInt(7);
				 sco = new Score(sid, stuid, name, bj, kc, kname, fen);
			}
		} catch (SQLException e) {
			dt.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sco;
	}
	
	//10������SQL������score��������int��
	
	public int  bjavg(String condition){
		DbJdbc dt=new DbJdbc();
		String sql="select avg(fenshu) from score where "+condition;
		ResultSet rs=dt.selectSql(sql);
		int avg=0;
		try {
			while(rs.next()){
				//ȥ����е�һ�еĽ��
				avg=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return avg;
	}
	

}
