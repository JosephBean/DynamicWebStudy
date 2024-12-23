package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.app.dto.User;
import com.app.util.DispatcherServlet;
import com.app.util.MybatisJDBC;

@WebServlet("/data")
public class Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSession session = MybatisJDBC.getSession();
		List<User> users =  session.selectList("test.test2");
		session.close();
		List<String> list = new ArrayList<String>();
		list.add("<!DOCTYPE html>");
		list.add("<html>");
		list.add("	<head>");
		list.add("		<meta charset=\"UTF-8\">");
		list.add("		<title>DATA</title>");
		list.add("	</head>");
		list.add("	<body>");
		list.add("		<table style=\"width:100%\">");
		list.add("			<thead>");
		list.add("				<tr>");
		list.add("					<th>번호</th>");
		list.add("					<th>이메일</th>");
		list.add("					<th>비밀번호</th>");
		list.add("					<th>삭제여부</th>");
		list.add("				</tr>");
		list.add("			</thead>");
		list.add("			<tbody style=\"text-align: center\">");
		users.forEach(user -> {
			String tag = "";
			tag += "<tr>";
			tag += "<td>" + user.get번호() + "</td>";
			tag += "<td>" + user.get이메일() + "</td>";
			tag += "<td>" + user.get비밀번호() + "</td>";
			tag += "<td>" + user.is삭제여부() + "</td>";
			tag += "</tr>";
			list.add(tag);
		});
		list.add("			</tbody>");
		list.add("		</table>");
		list.add("	</body>");
		list.add("</html>");
		DispatcherServlet.viewWriter(list, req, resp);
	}
	
}
