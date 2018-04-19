package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.*;

public class LoginJdbc {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	Manager man = null;
	Teacher tea = null;
	Student stu = null;

	String driver = "com.mysql.jdbc.Driver"; // 加载驱动
	String url = "jdbc:mysql://localhost:3306/selectcourse?useUnicode=true&characterEncoding=utf8";
	String user = "root";
	String password = "root";

	// 管理员登录
	public Manager login(int id) {
		String sql = "select * from manager where id=" + id;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password); // 获取与数据库的连接
			st = conn.createStatement();// 获取用于向数据库发送SQL语句
			rs = st.executeQuery(sql); // 向数据库发送SQL语句，并获取代表结果集
			while (rs.next()) {
				int mid = rs.getInt(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				int age = rs.getInt(4);
				man = new Manager(mid, name, pwd, age);
			}

		} catch (Exception e) {
			close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return man;
	}

	// 教师登录
	public Teacher tealogin(int id) {
		String sql = "select * from teacher where id=" + id;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password); // 获取与数据库的连接
			st = conn.createStatement();// 获取用于向数据库发送SQL语句
			rs = st.executeQuery(sql); // 向数据库发送SQL语句，并获取代表结果集
			while (rs.next()) {
				int tid = rs.getInt(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				String title = rs.getString(4);
				String department = rs.getString(5);
				tea = new Teacher(tid, name, pwd, title, department);
			}

		} catch (Exception e) {
			close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tea;
	}

	// 学生登录
	public Student stulogin(int id) {
		String sql = "select * from student where id=" + id;
		try {
			Class.forName(driver);//加载驱动
			conn = DriverManager.getConnection(url, user, password); // 获取与数据库的连接
			st = conn.createStatement();// 获取用于向数据库发送SQL语句
			rs = st.executeQuery(sql); // 向数据库发送SQL语句，并获取代表结果集
			while (rs.next()) {
				int sid = rs.getInt(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				String bj = rs.getString(4);
				String home = rs.getString(5);
				int phone = rs.getInt(6);
				String email = rs.getString(7);

				stu = new Student(sid, name, pwd, bj, home, phone, email);
			}

		} catch (Exception e) {
			close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	public void close() {
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

}
