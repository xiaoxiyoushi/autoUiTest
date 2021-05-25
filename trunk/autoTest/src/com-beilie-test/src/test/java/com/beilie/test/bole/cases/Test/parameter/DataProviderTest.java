package com.beilie.test.bole.cases.Test.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider="methodData")
    public void test1(String name,int age){
        System.out.println("111111111  "+age+"  "+name);
    }

    @Test(dataProvider="methodData")
    public void test2(String name,int age){
        System.out.println("222222222  "+age+"  "+name);
    }

    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result=null;

        if (method.getName().equals("test1")){
            result=new Object[][]{
                    {"hary",10},
                    {"jack",15}
            };
        }else if(method.getName().equals("test2")){
            result=new Object[][]{
                    {"aa",20},
                    {"bb",25}
            };
        }

        return result;
    }


}
