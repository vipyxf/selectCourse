package model;

import java.sql.Connection;

public class Fenye {
	private Connection conn;   //�����ݿ��ж�ȡ����
	private int totalCount;    //������
	private int pageNo;       //��ǰҳ��
	private int pageCount;   //ÿҳ����
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
	
	
	//��ҳ��
	public int getTotalPage(){
		if(totalCount%pageCount==0){
			return totalCount/pageCount;
		}
		else{
			return  totalCount/pageCount+1;
		}
		
		//return (totalCount+pageCount-1)/pageCount;   ����ҳ��
	}
	
	
	//�ж���һҳ
	public  boolean isNext(){
		return pageNo<getTotalPage();
	}
	
	
	//�ж���һҳ
	public boolean isPrevious(){
		return pageNo>1;
	}
	
	

}
