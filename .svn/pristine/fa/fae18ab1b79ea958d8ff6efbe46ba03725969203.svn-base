package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

//EBFA06标签管理
public class EBFA06Page extends Public<EBFA06Page> {
    //点击新增按钮
    public EBFA06Page clickAddBtn(){
        this.findByXPath("//button[text()=\"新增\"]").click();
        return this;
    }

    public EBFA06Page inputLabel(String label){
        this.findByXPath("//input[@placeholder=\"请输入标签类别\"]").sendKeys(label);//输入标签类别
        this.findByXPath("//label[text()=\" 简历预览时显示该标签\"]//input").click();//勾选 简历预览时显示该标签
        return this;
    }

    public EBFA06Page clickSubmitBtn(){
        /*this.findByClassName("EBFA06_size")
                .findByXPath("//div[text()=\"确定\"]").click();*///点击【确定】按钮

        this.findListByXPath("//div[@type=\"primary\"]").get(1).click();//点击【确定】按钮
        return this;
    }

    public EBFA06Page checkLabel(String originalLabel){
        String label=this.findByClassName("ivu-table-cell-ellipsis").getText();
        Assert.assertEquals(originalLabel,label);

        return this;
    }

}
