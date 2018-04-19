package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class Stuinfo {
	List<Student> liststu = new ArrayList<Student>();
	DbJdbc dt = new DbJdbc();

	// 1��׼�������ݿ��������ѧ����Ϣ
	public void stuShowAll(String sql) {
		dt.dbConn();
		try {
			dt.st = dt.conn.createStatement();
			dt.rs = dt.st.executeQuery(sql);
			while (dt.rs.next()) {
				int sid = dt.rs.getInt(1);
				String name = dt.rs.getString(2);
				String pwd = dt.rs.getString(3);
				String bj = dt.rs.getString(4);
				String home = dt.rs.getString(5);
				int phone = dt.rs.getInt(6);
				String email = dt.rs.getString(7);
				Student stu = new Student(sid, name, pwd, bj, home, phone,
						email);
				liststu.add(stu);
			}

		} catch (SQLException e) {
			dt.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 2����ѯ����ѧ����Ϣ
	public List<Student> getAllStudent() {
		String sql = "select * from student";
		stuShowAll(sql);

		return liststu;
	}

	// 3��ͨ��ģ����ѯ����ѧ��
	public List<Student> getOneStudent(String id, String name) {
		if (id != null) {

			String sql = "select * from student where id like '%" + id + "%'";
			stuShowAll(sql);
		} else if (name != null) {
			String sql = "select * from student where sname like '%" + name
					+ "%' ";
			stuShowAll(sql);
		}
		return liststu;
	}

	

	// 4�����ѧ����Ϣ
	public void addStu(int id, String name, String pwd, String bj, String home,
			int phone, String em) {
		String sql = "insert into student value(" + id + ",'" + name + "','"
				+ pwd + "','" + bj + "','" + home + "'," + phone + ",'" + em
				+ "')";
		dt.zsg(sql); // ������ɾ�ĵķ���
	}

	// 5��ɾ��ѧ����Ϣ
	public void deleteStu(int id) {
		String sql = "delete from student where id=" + id;
	dt.zsg(sql);
	}

	// 6���޸�ѧ����Ϣ
	public void updateStu(int id, String name, String pwd, String bj,
			String home, int phone, String em) {
		String sql = "update student set sname='" + name + "',password='" + pwd
				+ "',banji='" + bj + "',home='" + home + "',phone=" + phone
				+ ",email='" + em + "' where id=" + id;
		dt.zsg(sql);
	}

}
