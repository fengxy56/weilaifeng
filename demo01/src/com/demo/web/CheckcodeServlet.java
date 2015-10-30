package com.demo.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 一、绘图
		 */
		//step1,创建内存映像对象(画板)
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//step2,获得画笔
		Graphics g = image.getGraphics();
		//step3,给画笔设置颜色
		g.setColor(new Color(255,255,255));
		//step4,给画板设置背景颜色
		g.fillRect(0, 0, 80, 30);
		//step5,给画笔设置颜色
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//设置字体,风格,大小
		g.setFont(new Font(null,Font.ITALIC,24));
		//step6,生成一个随机数
		String number = getNumber(5);
		//将number绑订到session
		HttpSession session = 
				request.getSession();
		session.setAttribute("number", number);
		g.drawString(number, 4, 25);
		//step7,加一些干扰线
		for(int i = 0; i < 8; i ++){
			g.setColor(new Color(r.nextInt(255),
					r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30),
					r.nextInt(80), r.nextInt(30));
		}
		/*
		 * 二、压缩图片并输出
		 */
		//step1,告诉浏览器，返回的是一张图片
		response.setContentType("image/jpeg");
		//step2,获得字节输出流
		OutputStream ops = 
			response.getOutputStream();
		//step3,压缩图片并输出
		javax.imageio.ImageIO
		.write(image, "jpeg", ops);
		ops.close();
	}
	
	/*
	 * 生成一个长度为size,并且随机从"
	A~Z,0~9"中选取字符组成的验证码
	 */
	private String getNumber(int size) {
		String number = "";
		Random r = new Random();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
				"0123456789";
		for(int i = 0; i < size; i ++){
			number += chars.charAt(
					r.nextInt(chars.length()));
		}
		return number;
	}

}
