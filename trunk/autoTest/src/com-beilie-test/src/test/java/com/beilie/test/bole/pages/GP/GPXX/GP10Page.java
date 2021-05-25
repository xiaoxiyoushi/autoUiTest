package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;
import java.util.List;
//GP10项目详情页面
public class GP10Page extends Public<GP10Page> {
    public GP10Page checkParagraph(String value_1,String value_2,String value_3){
        List<Element> elements=this.findByClassName("ivu-col-span-23").findListByTagName("p");
        String firstParag=elements.get(0).getText();
        String secondParag=elements.get(1).getText();
        String thirdParag=elements.get(2).getText();

        Assert.assertEquals(value_1,firstParag);
        Assert.assertEquals(value_2,secondParag);
        Assert.assertEquals(value_3,thirdParag);
        return this;
    }

    //输入姓名
    public GP10Page sendName(){
        this.findByClassName("mr18")
                .findByTagName("input").sendKeys("王大陆");
        return this;
    }

    public GP10Page a(int i,int j,String value){
        this.findListByClassName("formdataModel").get(1)
            .findByTagName("form")
            .findListByClassName("ivu-row").get(i)
            .findListByTagName("input").get(j).sendKeys(value);
        return this;
    }

    //点击联系人下拉框
    public GP10Page clickContactInput(){
        this.findByClassName("ivu-select-visible").findByClassName("ivu-select-dropdown-list")
                .findByTagName("li").click();
        return this;
    }

    //定位div元素 获取父元素div元素，再根据父元素div元素 获取其兄弟元素div元素，获取下一级p标签
    public GP10Page checkInforma(String str,String numb_str,String mailbox_str){
        String numb_str_1=this.findByXPath("//div[text()=\""+str+"\"]/parent::div/following-sibling::div")
                .findListByTagName("p").get(0).getText();
        String mailbox_str_1=this.findByXPath("//div[text()=\""+str+"\"]/parent::div/following-sibling::div")
                .findListByTagName("p").get(1).getText();

        Assert.assertEquals(numb_str,numb_str_1);
        Assert.assertEquals(mailbox_str,mailbox_str_1);
        return this;
    }

    public GP10Page clickName(){
        this.findByClassName("ivu-table-tbody")
                .findByTagName("a").click();
        return this;
    }

    //人选进程 排序箭头
    public GP10Page clickSort(){
        this.findByClassName("ivu-icon-arrow-up-b").click();
        return this;
    }

    //项目进程
    public GP10Page clickProcess(String str,int i){
        this.findByClassName("statustyle")
                .findListByTagName("li").get(i).click();

        return this;
    }
}
