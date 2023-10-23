package com.beilie.test.util;

import java.io.*;
import java.util.Properties;

public class ProUtil {
    private Properties prop;
    private String filePath;

    /**
     * 构造方法
     * */
    public ProUtil(String filePath){
        this.filePath = filePath;
        this.prop = readProperties();
    }

    /**
     * 读取配置文件
     * */
    private Properties readProperties(){
        Properties properties = new Properties();
        try {
            InputStream inputStream= new FileInputStream(filePath);
            InputStreamReader inputStreamReader =new InputStreamReader(inputStream,"utf-8");
            properties.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 根据key读取关键字内容
     * */
    public String  getPro(String key){
        if(prop.containsKey(key)){
            String username = prop.getProperty(key);
            return username;
        }else{
            System.out.println("你获取key值不对");
            return "";
        }
    }

    /**
     * 写入内容
     * */
    public void writePro(String key,String value){
        Properties pro = new Properties();
        try {
            FileOutputStream file = new FileOutputStream(filePath);
            pro.setProperty(key, value);
            pro.store(file, key);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
