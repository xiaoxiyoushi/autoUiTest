package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

public class EBLK03Page extends Public<EBLK03Page> {
    public EBLK03Page clickDepartm(){
        this.findByXPath("//input[@placeholder=\"请选择部门名称\"]").click();
        return this;
    }

    public EBLK03Page searchDepartm(){
        this.findByXPath("//input[@placeholder=\"项目组编号\"]").sendKeys("CG");
        clickBtn1(1);//点击搜索
        clickBtn2(1);//勾选项目组
        clickBtn3(1);//点击确定

        return this;
    }

    public EBLK03Page clickDeleteBtn(){
        this.findByXPath("//span[text()=\"删除\"]").click();//点击删除按钮
        return this;
    }

    public EBLK03Page clickOK(){
        this.findByClassName("ivu-btn-primary").click();//点击【确定】按钮
        return this;
    }

    //给部门编号输入内容
    public EBLK03Page inputDepartmNumb(String numb){
        this.findByXPath("//input[@placeholder=\"部门编号\"]").sendKeys(numb);
        return this;
    }

    //按钮类型1
    public EBLK03Page clickBtn1(int i){
        this.findListByClassName("ef-btn-search").get(i).click();
        return this;
    }

    //按钮类型2
    public EBLK03Page clickBtn2(int i){
        this.findListByClassName("ivu-table-body").get(i).findByTagName("input").click();
        return this;
    }

    //按钮类型3
    public EBLK03Page clickBtn3(int i){
        this.findListByClassName("ef-btn-add").get(i).click();
        return this;
    }

    public EBLK03Page inputLockNumb(String str){
        this.findByXPath("//input[@placeholder=\"请输入锁名额\"]").sendKeys(str);
        this.findByXPath("//div[text()=\"部门名称:\"]/following-sibling::div//input").click();

        return this;
    }

    public EBLK03Page clickAdd(){
        this.findByXPath("//a[text()=\"添加\"]").click();
        return this;
    }

    public EBLK03Page clickAddOk(){
        this.findByClassName("ef-btn-ok").click();
        return this;
    }

    //获取table下子tr元素个数
    public int getTrSize(){
        int numb=this.findListByClassName("ivu-table-body").get(0).findListByTagName("td").size();
        return numb;
    }

    //校对新增的部门名称
    public EBLK03Page checkDepartm(){
        String department=this.findListByClassName("ivu-table-body").get(0)
                        .findByClassName("ivu-table-column-left")
                        .findByTagName("span").getText();

        Assert.assertEquals(department,"项目四部");
        return this;
    }

    //校对新增的锁名额
    public EBLK03Page checkLockNumb(String lockNumbStr){
        String department=this.findListByClassName("ivu-table-body").get(0)
                .findByTagName("a").getText();

        Assert.assertEquals(department,lockNumbStr);
        return this;
    }

}
