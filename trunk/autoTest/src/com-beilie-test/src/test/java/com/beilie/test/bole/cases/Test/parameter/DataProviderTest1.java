package com.beilie.test.bole.cases.Test.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class DataProviderTest1 {
    @Test(dataProvider = "method")
    public void test1(String name,int age){
        System.out.println("111111"+name+"   "+age);
    }

    @Test(dataProvider = "method")
    public void test2(String name,int age){
        System.out.println("222222"+name+"   "+age);
    }

    @DataProvider(name = "method")
    public Object[][] testDataPro(Method method){
        Object[][] result=null;

        if (method.getName().equals("test1")){
            result=new Object[][]{
                    {"hary",10},
                    {"jack",15}
            };
        }else if (method.getName().equals("test2")){
            result=new Object[][]{
                    {"zhangsan",20},
                    {"lisi",25}
            };
        }

        return result;
    }
}
