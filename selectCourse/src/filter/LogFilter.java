package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
 	FilterConfig config; 
 	public void destroy() {
 		this.config = null; 	} 
 	public void doFilter(ServletRequest req, ServletResponse res,
 			FilterChain chain) throws IOException, ServletException {
 		// ��ȡServletContext �������ڼ�¼��־
 		ServletContext context = this.config.getServletContext();
 		//long before = System.currentTimeMillis();
 		//System.out.println("before the log filter!");
 		//context.log("��ʼ����");
 		// ������ת����HttpServletRequest ����
 		HttpServletRequest hreq = (HttpServletRequest) req;
 		// ��¼��־
 		//System.out.println("Log Filter�Ѿ��ػ��û�������ĵ�ַ:"+hreq.getServletPath() );
 		//context.log("Filter�Ѿ��ػ��û�������ĵ�ַ: " + hreq.getServletPath());
 		try {// Filter ֻ����ʽ����������Ȼת����Ŀ�ĵ�ַ��
 			chain.doFilter(req, res);
 		} catch (Exception e) {	e.printStackTrace();}
 		//System.out.println("after the log filter!");
 	} 
 	public void init(FilterConfig config) throws ServletException {
 		//System.out.println("begin do the log filter!");
 		this.config = config;
 	}
  }

