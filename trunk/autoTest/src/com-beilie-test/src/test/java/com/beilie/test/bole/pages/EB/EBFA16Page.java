package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

public class EBFA16Page extends Public<EBFA16Page> {
    public EBFA16Page click_untilNow(String str){
        this.findByXPath("//label[text()=\""+str+"\"]/span").click();
        return this;
    }

    //校对提示 简历入库成功，点击【确定】按钮 关掉页面
    public EBFA16Page checkTip(){
        String value=getSpanValue("添加到我的收藏夹成功，请前往查看。");
        Assert.assertEquals(value,"添加到我的收藏夹成功，请前往查看。");

        this.findByClassName("bigokbutton").click();//点击确定按钮
        return this;
    }

    //校对提示 添加人选到项目成功；
    public EBFA16Page checkTip_addProject(String name){
        String value=getSpanValue("添加人选["+name+"]到项目成功。");
        return this;
    }


    //点击提示的【确定】按钮
    public EBFA16Page clickConfirmBtn(){
        this.findByClassName("bigokbutton").click();
        return this;
    }


}
