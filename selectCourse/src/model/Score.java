package model;

public class Score {
 private int sid;
 private int stuid;
 private String stuname;
 private String banji;
 private String cid;
 private String cname;
 private int fenshu;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public int getStuid() {
	return stuid;
}
public void setStuid(int stuid) {
	this.stuid = stuid;
}
public String getStuname() {
	return stuname;
}
public void setStuname(String stuname) {
	this.stuname = stuname;
}
public String getBanji() {
	return banji;
}
public void setBanji(String banji) {
	this.banji = banji;
}
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
public int getFenshu() {
	return fenshu;
}
public void setFenshu(int fenshu) {
	this.fenshu = fenshu;
}
public Score() {
	super();
	// TODO Auto-generated constructor stub
}
public Score(int sid, int stuid, String stuname, String banji, String cid,
		String cname, int fenshu) {
	super();
	this.sid = sid;
	this.stuid = stuid;
	this.stuname = stuname;
	this.banji = banji;
	this.cid = cid;
	this.cname = cname;
	this.fenshu = fenshu;
}
 
}
