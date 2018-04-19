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
 	// 项目结束时就已经进行销毁
 	public void destroy() {
 		//System.out.println("这是destroy()销毁方法中的打印语句:end do the encoding filter!");
 		params=null;
 		encoding=null;
 	}
 	public void doFilter(ServletRequest req, ServletResponse resp,
 			FilterChain chain) throws IOException, ServletException {
 		//UtilTimerStack.push("EncodingFilter_doFilter:");
 		//System.out.println("这是在doFilter()方法中：before encoding " + encoding + " filter！");
 		req.setCharacterEncoding(encoding);
 		
 	   resp.setContentType("text/html;charset="+encoding);
 		chain.doFilter(req, resp);	//过滤链
 		//System.out.println("这是在doFilter()方法中输入的打印语句：after encoding " + encoding + " filter！");
 		//UtilTimerStack.pop("EncodingFilter_doFilter:");
 	} 
 	// 项目启动时就已经进行读取
 	public void init(FilterConfig config) throws ServletException {
 		//System.out.println("这是初始化中的语句：begin do the encoding filter!");
 		encoding = config.getInitParameter("encoding");
 		for (Enumeration e = config.getInitParameterNames(); e.hasMoreElements();) {
 			String name = (String) e.nextElement();
 			String value = config.getInitParameter(name);
 			params.put(name, value);
 		}
 	}
 }
