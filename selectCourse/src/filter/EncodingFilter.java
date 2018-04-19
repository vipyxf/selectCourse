package filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
 	private String encoding;
 	private Map<String, String> params = new HashMap<String, String>();
 	// ��Ŀ����ʱ���Ѿ���������
 	public void destroy() {
 		//System.out.println("����destroy()���ٷ����еĴ�ӡ���:end do the encoding filter!");
 		params=null;
 		encoding=null;
 	}
 	public void doFilter(ServletRequest req, ServletResponse resp,
 			FilterChain chain) throws IOException, ServletException {
 		//UtilTimerStack.push("EncodingFilter_doFilter:");
 		//System.out.println("������doFilter()�����У�before encoding " + encoding + " filter��");
 		req.setCharacterEncoding(encoding);
 		
 	   resp.setContentType("text/html;charset="+encoding);
 		chain.doFilter(req, resp);	//������
 		//System.out.println("������doFilter()����������Ĵ�ӡ��䣺after encoding " + encoding + " filter��");
 		//UtilTimerStack.pop("EncodingFilter_doFilter:");
 	} 
 	// ��Ŀ����ʱ���Ѿ����ж�ȡ
 	public void init(FilterConfig config) throws ServletException {
 		//System.out.println("���ǳ�ʼ���е���䣺begin do the encoding filter!");
 		encoding = config.getInitParameter("encoding");
 		for (Enumeration e = config.getInitParameterNames(); e.hasMoreElements();) {
 			String name = (String) e.nextElement();
 			String value = config.getInitParameter(name);
 			params.put(name, value);
 		}
 	}
 }
