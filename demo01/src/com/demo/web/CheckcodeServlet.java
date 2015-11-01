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
		 * һ����ͼ
		 */
		//step1,�����ڴ�ӳ�����(����)
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//step2,��û���
		Graphics g = image.getGraphics();
		//step3,������������ɫ
		g.setColor(new Color(255,255,255));
		//step4,���������ñ�����ɫ
		g.fillRect(0, 0, 80, 30);
		//step5,������������ɫ
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//��������,���,��С
		g.setFont(new Font(null,Font.ITALIC,24));
		//step6,����һ�������
		String number = getNumber(5);
		//��number�󶩵�session
		HttpSession session = 
				request.getSession();
		session.setAttribute("number", number);
		g.drawString(number, 4, 25);
		//step7,��һЩ������
		for(int i = 0; i < 8; i ++){
			g.setColor(new Color(r.nextInt(255),
					r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30),
					r.nextInt(80), r.nextInt(30));
		}
		/*
		 * ����ѹ��ͼƬ�����
		 */
		//step1,��������������ص���һ��ͼƬ
		response.setContentType("image/jpeg");
		//step2,����ֽ������
		OutputStream ops = 
			response.getOutputStream();
		//step3,ѹ��ͼƬ�����
		javax.imageio.ImageIO
		.write(image, "jpeg", ops);
		ops.close();
	}
	
	/*
	 * ����һ������Ϊsize,���������"
	A~Z,0~9"��ѡȡ�ַ���ɵ���֤��
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
