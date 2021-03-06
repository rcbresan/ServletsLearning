package br.com.bresan.servlet.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class ServletFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute(Constants.SESSION_TAG);

		String requestURI = req.getRequestURI();
		
		if (user != null) {
			System.out.println("Página acessada: " + requestURI + " pelo usuário " + user.email);
		} else {
			System.out.println("Página acessada: " + requestURI);
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
