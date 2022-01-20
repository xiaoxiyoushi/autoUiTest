package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;

import java.util.List;

//GC01客户基本信息
public class GC01Page extends Public<GC01Page> {
    public Element element(int i){
        Element element=this.findById("GC01_app")
                              .findByClassName("ef-page-body")
                                .findListByClassName("ivu-row").get(i);
        return element;
    }

    //点击保护
    public GC01Page clickProtect(){
        element(1).findByClassName("ivu-switch-inner").click();
        return this;
    }

    public GC01Page clickEdit(){
        element(1).findListByTagName("button").get(0).click();
        return this;
    }


    //添加客户联系人
    public GC01Page addContact(){
        element(1).findListByTagName("button").get(1).click();
        return this;
    }

    //点击【新增合同】
    public GC01Page addNewContact(){
        element(1).findListByTagName("button").get(2).click();
        return this;
    }

    //选中选择导航栏
    public GC01Page selectNavigationBar(String navigationBar){
        this.findByClassName("ivu-menu-horizontal").findListByTagName("li").get(1).click();
        /*List<Element> elements=this.findByClassName("ivu-menu-horizontal").findListByTagName("li");
        int n=elements.size();
        for(int i=0;i<n;i++){
            String str=elements.get(i).getText();
            if (str.equals(navigationBar)){
                elements.get(i).click();
                break;
            }
        }*/
        return this;
    }

    //hover沟通按钮
    /*public GC01Page hoverCommunicationBtn(){
        this.findByClassName("ivu-dropdown-rel").hover();
        return this;
    }*/

    public GC01Page hoverCommunicationBtn(String commuOper) throws InterruptedException{
        this.findByClassName("Dropdown_a").hover();
        this.sleepForSeconds(1);
        /*this.findById("Contactors_bg").findByClassName("ivu-table-fixed-right")
                .findByClassName("ivu-dropdown-menu")
                .findByXPath("//li[text()=\""+commuOper+"\"]").click();*/

        List<Element> elements=this.findById("Contactors_bg").findByClassName("ivu-table-fixed-right")
                .findByClassName("ivu-dropdown-menu").findListByTagName("li");
        int size=elements.size();

        for(int i=0;i<size;i++){
            String commuOperat=elements.get(i).getText();
            if (commuOperat.equals(commuOper)){
                elements.get(i).click();
                break;
            }
        }
        return this;
    }


    //选择联系人的操作按钮
    public GC01Page selectOperating(String operation){
        List<Element> elements=this.findByClassName("ivu-dropdown-menu").findListByTagName("li");
        int n=elements.size();
        for(int i=0;i<n;i++){
            String str=elements.get(i).getText();
            if (str.equals(operation)){
                elements.get(i).click();
                break;
            }
        }
        return this;
    }

    //校验 没有锁的倒计时
    public GC01Page checkNoLockCutdown(){
        String str=this.findByClassName("overTime").getText();
        Assert.assertEquals("",str);
        return this;
    }

}
