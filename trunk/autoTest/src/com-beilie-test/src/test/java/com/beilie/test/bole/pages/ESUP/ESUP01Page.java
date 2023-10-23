package com.beilie.test.bole.pages.ESUP;

import com.beilie.test.bole.pages.GC.GC14Page;
import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.testng.Assert;

public class ESUP01Page extends Public<ESUP01Page> {
    //编辑员工信息
    public ESUP01Page editInform() throws InterruptedException{
        inputPlaceholder_send("esup01_nameInp","海棠朵朵")
        .spanClick("esup01_search").sleepForSeconds(3)//点击【搜索】

        .findListByClassName("member-operation-menu")//点击操作
        .get(2)
        .findByTagName("button").click();

        divsClass_click("esup01_edit_class",2,"li",0)//点击编辑信息
        .sleepForSeconds(1)
        ;

        //Element element=findByXPath("//div[text()=\"编辑员工信息\"]/parent::div/parent::div");

        //element;
        this.scrollBar();
//element.scrollTo();


        return this;
    }

    //点击操作
    public ESUP01Page operation_click() throws InterruptedException{
        this.findByXPath("//div[@class=\"member-operation-menu ivu-dropdown\"]//span[text()=\"搜索\"]").click();
        /*findListByClassName("member-operation-menu")//点击操作
                .get(2)
                .findByTagName("button").click();*/
        ////*[@id="EFPage"]/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr[1]/td[39]/div/div/div
        return this;
    }

    //点击编辑信息
    public ESUP01Page edit_click() throws InterruptedException{
        divsClass_click("esup01_edit_class",2,"li",0);//点击编辑信息
        return this;
    }
}
