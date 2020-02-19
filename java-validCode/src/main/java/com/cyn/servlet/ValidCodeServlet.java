package com.cyn.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springStudy
 * @Package: com.cyn.servlet
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/8/3 14:06
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/8/3 14:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
@WebServlet("/validCode")
public class ValidCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一张图片
        //单位像素
        BufferedImage image = new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);
        ServletOutputStream outputStream = resp.getOutputStream();

        //透明的玻璃
        //设置画笔
        Graphics2D gra = image.createGraphics();
        gra.setColor(Color.WHITE);
        //按坐标画笔填充 开始坐标 x y  绘图区域 w h
        gra.fillRect(0,0,200,100);
        //随机数
        List<Integer> integerList = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            integerList.add(random.nextInt(10));
        }
        //颜色随机
        Color[] colors = new Color[]{Color.red,Color.BLUE,Color.magenta,Color.BLACK};

        //添加干扰线
        for (int i = 0; i < 15; i++) {
            gra.setColor(colors[random.nextInt(colors.length)]);
            gra.drawLine(0,random.nextInt(101),200,random.nextInt(101));
        }
        //设置字体
        for (int i = 0; i < integerList.size(); i++) {
            gra.setColor(colors[random.nextInt(colors.length)]);
            gra.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,50));
            gra.drawString(integerList.get(i)+"",i*40+(random.nextInt(21)-10),50+(random.nextInt(21)-10));

        }
        //工具类
        ImageIO.write(image,"jpg",outputStream);
    }
}
