package com.koitt.board.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("corsFilter")
public class CORSFilter implements Filter{

	private Logger logger = LogManager.getLogger(this.getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("Filtering on");
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*"); // 모든 웹페이지에서 사용 가능
		res.setHeader("Access-Control-Allow-Credentials", "true"); // 접속할떄 뜨는 창
		res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 사용가능 메서드 
		res.setHeader("Access-Control-Max-Age",	"3600"); // 웹페이지 허용 시간
		res.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, " 
					+ "Origin, Accept, Access-Control-Request-Method," + "Access-Control-Request-Headers"); // 허용하는 헤더들
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
