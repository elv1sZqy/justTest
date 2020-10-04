package com.tsu.zqy.util;


import gui.ava.html.Html2Image;
import gui.ava.html.renderer.ImageRenderer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * @author zhuQiYun
 * @create 2020/3/17
 * @description :
 */
public class Html2PicUtils {

   public static void main(String[] args) throws InterruptedException {
         String html = "<style>\n" +
                "  #bgDom{\n" +
                "  width: 560px; height: 1000px; overflow: hidden; \n" +
                "  position:relative;\n" +
                "  z-index:1\n" +
                "  }\n" +
                "  .bgImg{\n" +
                "  position:absolute;\n" +
                "  z-index:-1;\n" +
                "  width: 100%;\n" +
                "  height: 100%;\n" +
                "  }\n" +
                "  .bgImg img{\n" +
                "  width: 100%;\n" +
                "  height: 100%;\n" +
                "  }\n" +
                "  #headImg{\n" +
                "  margin: 10% 0px 10% 35%; width: 30%; height: 20%;display:block;border-radius:50%;\n" +
                "  }\n" +
                "  #qrcode{\n" +
                "  margin: 10% 0px 10% 35%; border: 1px solid black;display:block;\n" +
                "  }\n" +
                "  #nickName{\n" +
                "  margin: 10% auto; width: 30%; text-align: center;\n" +
                "  }\n" +
                "</style>\n" +
                "<div id=\"bgDom\">\n" +
                "  <div class=\"bgImg\"><img src=\"${img}\"></div>\n" +
                "  <img id=\"headImg\" src=\"https://k8s-daily.oss-cn-beijing.aliyuncs.com/upload/12818/picture/1584670522363.png\" style=\"margin-left: 35%;\">\n" +
                "  <div style=\"height: 1px;\"></div>\n" +
                "  <div style=\"color: rgb(254, 146, 0);\" id=\"nickName\">骑着蜗牛追导弹</div>\n" +
                "  <div style=\"height: 1px;\"></div>\n" +
                "  <img id=\"qrcode\" src=\"https://k8s-daily.oss-cn-beijing.aliyuncs.com/upload/12818/picture/1584670522363.png\" style=\"margin-left: 35%; width: 30%; height: 20%;\">\n" +
                "</div>";
        String fileName = (System.currentTimeMillis()) + ".html";

        File file = new File(fileName);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.print(html);
        } catch (IOException e) {
            // ... handle IO exception
        }

        Html2Image html2Image = Html2Image.fromHtml(html);
        ImageRenderer imageRenderer = html2Image.getImageRenderer();
        imageRenderer.setWidth(576);
        imageRenderer.setHeight(1016);
       imageRenderer.setWriteCompressionQuality(100f);
        imageRenderer.saveImage(file);
    }


    /*public static void main(String[] args) throws Exception {
        JFrame window = new JFrame();
        HtmlPanel panel = new HtmlPanel();
        window.getContentPane().add(panel);
        window.setSize(600, 400);
        window.setVisible(true);
        new SimpleHtmlRendererContext(panel, new SimpleUserAgentContext())
                .navigate("http://www.hefeipet.com/client/chongwuzhishi/shenghuozatan/2012/0220/95.html");

        BufferedImage image = new BufferedImage(panel.getWidth(),
                panel.getHeight(), BufferedImage.TYPE_INT_ARGB);

        // paint the editor onto the image
        SwingUtilities.paintComponent(image.createGraphics(), panel,
                new JPanel(), 0, 0, image.getWidth(), image.getHeight());
        // save the image to file
        ImageIO.write((RenderedImage) image, "png", new File("html.png"));
    }*/



    /*public static void main(String[] args)  {
        String html = "<style>\n" +
                "  #bgDom{\n" +
                "  width: 100%; height: 100%; overflow: hidden; \n" +
                "  position:relative;\n" +
                "  z-index:1\n" +
                "  }\n" +
                "  .bgImg{\n" +
                "  position:absolute;\n" +
                "  z-index:-1;\n" +
                "  width: 100%;\n" +
                "  height: 100%;\n" +
                "  }\n" +
                "  .bgImg img{\n" +
                "  width: 100%;\n" +
                "  height: 100%;\n" +
                "  }\n" +
                "  #headImg{\n" +
                "  margin: 10% 0px 10% 35%; width: 30%; height: 20%;display:block;border-radius:50%;\n" +
                "  }\n" +
                "  #qrcode{\n" +
                "  margin: 10% 0px 10% 35%; border: 1px solid black;display:block;\n" +
                "  }\n" +
                "  #nickName{\n" +
                "  margin: '10% auto'; width: '30%'; text-align: 'center';\n" +
                "  }\n" +
                "</style>\n" +
                "<div id=\"bgDom\">\n" +
                "  <div class=\"bgImg\"><img src=\"https://k8s-daily.oss-cn-beijing.aliyuncs.com/upload/12818/picture/1584670522363.png\"></div>\n" +
                "  <img id=\"headImg\" src=\"https://k8s-daily.oss-cn-beijing.aliyuncs.com/upload/12818/picture/1584670522363.png\" style=\"margin-left: 35%;\">\n" +
                "  <div style=\"height: 1px;\"></div>\n" +
                "  <div style=\"color: rgb(254, 146, 0);\" id=\"nickName\">${nickName}</div>\n" +
                "  <div style=\"height: 1px;\"></div>\n" +
                "  <img id=\"qrcode\" src=\"https://k8s-daily.oss-cn-beijing.aliyuncs.com/upload/12818/picture/1584670522363.png\" style=\"margin-left: 35%; width: 30%; height: 20%;\">\n" +
                "</div>";

        HtmlImageGenerator generator = new HtmlImageGenerator();
        generator.loadHtml(html);
        Dimension dimension = new Dimension(300, 450);
        generator.setSize(dimension);
        generator.saveAsImage(Thread.currentThread().getId() + System.currentTimeMillis() + ".png");


      *//*  Html2Image html2Image = Html2Image.fromHtml(html);
        ImageRenderer imageRenderer = html2Image.getImageRenderer();
        imageRenderer.setHeight(1340);
        imageRenderer.setWidth(200);
        imageRenderer.saveImage(System.currentTimeMillis()+".png");
*//*
    }*/
}
