package model;

import java.sql.Connection;

public class Fenye {
	private Connection conn;   //从数据库中读取数据
	private int totalCount;    //总条数
	private int pageNo;       //当前页数
	private int pageCount;   //每页条数
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public int getTotalCount() {
		
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Fenye() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fenye(Connection conn, int totalCount, int pageNo, int pageCount) {
		super();
		this.conn = conn;
		this.totalCount = totalCount;
		this.pageNo = pageNo;
		this.pageCount = pageCount;
	}
	
	
	//总页数
	public int getTotalPage(){
		if(totalCount%pageCount==0){
			return totalCount/pageCount;
		}
		else{
			return  totalCount/pageCount+1;
		}
		
		//return (totalCount+pageCount-1)/pageCount;   求总页数
	}
	
	
	//判断下一页
	public  boolean isNext(){
		return pageNo<getTotalPage();
	}
	
	
	//判断上一页
	public boolean isPrevious(){
		return pageNo>1;
	}
	
	

}
