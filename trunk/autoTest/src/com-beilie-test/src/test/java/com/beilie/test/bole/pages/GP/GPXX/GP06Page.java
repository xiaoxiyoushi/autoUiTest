package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

//GP06设置启投时间
public class GP06Page extends Public<GP06Page> {

    public GP06Page checkInform(){
        //String str1=this.findByXPath("//span[text()=\"GP06\"]").getText();
        //String str2=this.findByXPath("//h3[text()=\"设置启投时间\"]").getText();

        //Assert.assertEquals(str1,"GP06");
        //Assert.assertEquals(str2,"设置启投时间");
        String str1=this.findByXPath("//h3[text()=\"设置启投时间\"]").getText();
        return this;
    }

    public GP06Page selectTime() throws InterruptedException{
        this.findByXPath("//input[@placeholder=\"请选择时间\"]").click();//点击请选择时间框
        this.findByClassName("ivu-date-picker-cells-cell-today").click();//选择当天
        this.sleepForSeconds(1);

        this.findByXPath("//span[text()=\"\n" +
                "        选择时间\n" +
                "    \"]").click();//点击【选择时间】按钮
        this.sleepForSeconds(1);

        this.findByClassName("ivu-time-picker-cells-list")
                .findListByTagName("li").get(8).click();
        this.sleepForSeconds(1);
        this.findByClassName("ivu-time-picker-cells-list")
                .findListByTagName("li").get(16).click();
        this.sleepForSeconds(1);
        this.findByClassName("ivu-time-picker-cells-list")
                .findListByTagName("li").get(23).click();

        this.findByXPath("//span[text()=\"\n" +
                "        确定\n" +
                "    \"]").click();//点击【确定】按钮
        return this;
    }

    public GP06Page clickSubmit() throws InterruptedException{
        this.findByXPath("//span[text()=\"确定\"]").click();//点击【确定】按钮
        return this;
    }
}
