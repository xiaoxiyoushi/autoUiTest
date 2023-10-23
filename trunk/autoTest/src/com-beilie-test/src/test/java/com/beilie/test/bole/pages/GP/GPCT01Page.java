package com.beilie.test.bole.pages.GP;

import com.beilie.test.open.PublicClass.Public;

//GPCT01任务中心
public class GPCT01Page extends Public<GPCT01Page> {

    public GPCT01Page clickCarry(){
        this.findByXPath("//div[@class=\"ivu-table-fixed-right\"]//span[text()=\"执行\"]").click();
        return this;
    }

    public String getTaskName(){
        String taskName=this.findListByClassName("ivu-table-cell-ellipsis").get(1)
                .findByTagName("span").getText();
        return taskName;
    }

    public GPCT01Page task(String str){
        /*"//div[@class=\"tashList_list\"]/div[10]//i" 预付款审核的父菜单  点击箭头 展示子菜单
        * */
        this.findByXPath(str).click();
        return this;
    }
}
