package model;

public class Student {
	private int sid;
	private String sname;
	private String spwd;
	private String banji;
	private String home; // 籍贯
	private int phone; // 联系方式
	private String email; //邮箱

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getBanji() {
		return banji;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, String spwd, String banji,
			String home, int phone, String email) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spwd = spwd;
		this.banji = banji;
		this.home = home;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", spwd=" + spwd
				+ ", banji=" + banji + ", home=" + home + ", phone=" + phone
				+ ", email=" + email + "]";
	}


}
