/*
package com.beilie.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class ImagePreProcess {
    // 图片过滤器，想要什么样的图片，传进名称即可。如：png/gif/.png
    static class ImageFileFilter implements FileFilter {
        private String postfix = ".png";

        public ImageFileFilter(String postfix) {
            if(!postfix.startsWith("."))
                postfix = "." + postfix;

            this.postfix = postfix;
        }

        @Override
        public boolean accept(File pathname) {
            return pathname.getName().toLowerCase().endsWith(postfix);
        }
    }

    // 存放所有下载验证码的目录
    private static final String DOWNLOAD_DIR = "D:\\download";
    // 存放已经拆分开的单个数字图片的目录，供比对用
    private static final String TRAIN_DIR = "D:\\train";
    @Test
    public static void downloadImage() throws Exception {
        HttpClient httpClient = new DefaultHttpClient();
        String url = "http://cas.beilie.cloud/cas/Kaptcha.jpg";
        HttpGet getMethod = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(getMethod, new BasicHttpContext());
            HttpEntity entity = response.getEntity();
            InputStream instream = entity.getContent();
            OutputStream outstream = new FileOutputStream(new File(DOWNLOAD_DIR, 1 + ".png"));
            int l = -1;
            byte[] tmp = new byte[2048];
            while ((l = instream.read(tmp)) != -1) {
                outstream.write(tmp);
            }
            outstream.close();
        } finally {

        }


        System.out.println("下载验证码完毕！");
    }

    // 3.判断拆分验证码的标准：就是定义验证码中包含的各数字的x、y坐标值，及它们的宽度（width）、高度（height）。
    private static List<BufferedImage> splitImage(BufferedImage image) throws Exception {
        final int DIGIT_WIDTH = 23;
        final int DIGIT_HEIGHT = 34;

        List<BufferedImage> digitImageList = new ArrayList<BufferedImage>();
        digitImageList.add(image.getSubimage(2, 2, DIGIT_WIDTH, DIGIT_HEIGHT));
        digitImageList.add(image.getSubimage(20, 2, DIGIT_WIDTH, DIGIT_HEIGHT));
        digitImageList.add(image.getSubimage(40, 2, DIGIT_WIDTH, DIGIT_HEIGHT));
        digitImageList.add(image.getSubimage(60, 2, DIGIT_WIDTH, DIGIT_HEIGHT));

        return digitImageList;
    }

    // 4.判断字体的颜色含义：正常可以用rgb三种颜色加起来表示，字与非字应该有显示的区别，找出来。
    private static boolean isFontColor(int colorInt) {
        Color color = new Color(colorInt);

        return color.getRed() + color.getGreen() + color.getBlue() == 340;
    }

    // 5.将下载的验证码图片全部拆分到另一个目录。
    public void generateStdDigitImgage() throws Exception {
        File dir = new File(DOWNLOAD_DIR);
        File[] files = dir.listFiles(new ImageFileFilter("png"));

        int counter = 0;
        for (File file : files) {
            BufferedImage image = ImageIO.read(file);
            List<BufferedImage> digitImageList = splitImage(image);
            for (int i = 0; i < digitImageList.size(); i++) {
                BufferedImage bi = digitImageList.get(i);
                ImageIO.write(bi, "PNG", new File(TRAIN_DIR, "temp_" + counter++ + ".png"));
            }
        }
        System.out.println("生成供比对的图片完毕，请到目录中手工识别并重命名图片，并删除其它无关图片！");
    }



}

*/
