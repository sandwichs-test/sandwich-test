package com.hwforever.business.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {

	@RequestMapping("/image/getimage")
	public void createImage(HttpServletResponse response,HttpSession session) throws Exception{
		System.out.println("进来getimage");
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		graphic.setColor(Color.YELLOW);
		graphic.fillRect(0, 0, 80, 30);
		Random ran = new Random();
		int a = ran.nextInt(30);
		int b = ran.nextInt(30);
		graphic.setColor(Color.RED);
		graphic.setFont(new Font("宋体", 1, 16));
		graphic.drawString(a+"+"+b+"=?", 10, 20);
		for(int i=1;i<5;i++){
			graphic.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
			graphic.drawLine(ran.nextInt(80), ran.nextInt(30),ran.nextInt(80), ran.nextInt(30));
		}
		session.setAttribute("result", a+b);
		ImageIO.write(image, "jpeg", response.getOutputStream());
	}
	
	@RequestMapping("/image/checkImage")
	public void checkImage(String code,HttpSession session,HttpServletResponse response) throws Exception{
		System.out.println("进来检查image");
		Object result = session.getAttribute("result");
		PrintWriter pw = response.getWriter();
		if(code != null && code.equals(result.toString())){
			pw.print("{\"ok\":true}");
		}else{
			pw.print("{\"ok\":false}");
		}
	}
}
