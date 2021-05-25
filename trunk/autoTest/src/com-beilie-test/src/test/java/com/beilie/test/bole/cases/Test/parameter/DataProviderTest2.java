package com.beilie.test.bole.cases.Test.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
//参数测试  dataprovider参数测试
public class DataProviderTest2 {

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("111111"+name+"   "+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("222222"+name+"   "+age);
    }

    @DataProvider(name = "methodData")
    public Object[][] testDataPro(Method method){
        Object[][] result=null;

        if (method.getName().equals("test1")) {
            result=new Object[][]{
                    {"aa",10},
                    {"bb",20}
            };
        } else if (method.getName().equals("test2")) {
            result=new Object[][]{
                    {"cc",30},
                    {"dd",40}
            };
        }

        return result;
    }
}
