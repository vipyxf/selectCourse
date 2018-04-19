package model;

public class Course {
   private String cid;
   private String cname;
   private String type;
   private int credit;
   private int tid;
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getCredit() {
	return credit;
}
public void setCredit(int credit) {
	this.credit = credit;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public Course() {
	super();
	// TODO Auto-generated constructor stub
}
public Course(String cid, String cname, String type, int credit, int tid) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.type = type;
	this.credit = credit;
	this.tid = tid;
}
   
}
