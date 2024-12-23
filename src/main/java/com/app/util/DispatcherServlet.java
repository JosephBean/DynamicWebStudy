package com.app.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet {
	
	public static void viewResolver(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prefix = "/WEB-INF/jsp/";
		String suffix = ".jsp";
		String view = prefix.concat(page).concat(suffix);
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	public static void viewRedirect(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(page);
	}
	
	public static void viewWriter(List<String> list, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =  response.getWriter();
		list.forEach(item -> pw.println(item));
	}
	
}
