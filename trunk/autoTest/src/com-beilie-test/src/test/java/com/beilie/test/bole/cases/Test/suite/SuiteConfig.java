package com.beilie.test.bole.cases.Test.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//套件测试
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite  运行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite  运行啦");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest  运行啦");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest  运行啦");
    }
}
