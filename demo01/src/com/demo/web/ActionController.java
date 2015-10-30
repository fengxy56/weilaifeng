package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.dao.MsgDao;
import com.demo.entity.Msg;

public class ActionController extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		PrintWriter out = response.getWriter();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/list".equals(action)){
			try {
				MsgDao dao = new MsgDao();
				List<Msg> msgs = dao.findAll();
				//依查询结果，生成表格
				request.setAttribute("msgs", msgs);
				request.getRequestDispatcher("listMsg.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if("/add".equals(action)){

			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String subject = request.getParameter("subject");
			String message = request.getParameter("message");
			//将员工数据插入到数据库
			try {
				MsgDao dao = new MsgDao();
				Msg m = new Msg();
				m.setName(name);
				m.setEmail(email);
				m.setSubject(subject);
				m.setMessage(message);
				dao.save(m);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if("/check_name".equals(action)){
			String name = request.getParameter("name");
			if(name==""){
				out.print("error");
			}else{
				out.print("ok");
			}
		}else if("/check_email".equals(action)){
			String email = request.getParameter("email");
			if(email==""){
				out.print("error");
			}else{
				out.print("ok");
			}
		}else if("/check_subject".equals(action)){
			String subject = request.getParameter("subject");
			if(subject==""){
				out.print("error");
			}else{
				out.print("ok");
			}
		}else if("/check_message".equals(action)){
			String message = request.getParameter("message");
			if(message==""){
				out.print("error");
			}else{
				out.print("ok");
			}
		}else if("/check_number".equals(action)){
			String number1 = 
				request.getParameter("number");
			System.out.println("number:" + number1);
			HttpSession session = 
				request.getSession();
			String number2 = 
				(String)session.getAttribute("number");
			if(number1.equalsIgnoreCase(number2)){
				out.print("ok");
			}else{
				out.print("error");
			}
		}
		out.close();
	}

}
