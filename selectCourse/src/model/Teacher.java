package model;

public class Teacher {
  private int tid;
  private String tname;
  private String tpwd;
  private String title;       //÷∞≥∆
  private String department;  //≤ø√≈
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getTpwd() {
	return tpwd;
}
public void setTpwd(String tpwd) {
	this.tpwd = tpwd;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public Teacher() {
	super();
	// TODO Auto-generated constructor stub
}
public Teacher(int tid, String tname, String tpwd, String title,
		String department) {
	super();
	this.tid = tid;
	this.tname = tname;
	this.tpwd = tpwd;
	this.title = title;
	this.department = department;
}
  
}
