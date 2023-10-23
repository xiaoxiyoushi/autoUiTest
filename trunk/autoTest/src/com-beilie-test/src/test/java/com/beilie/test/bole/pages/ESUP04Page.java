package com.beilie.test.bole.pages;

import com.beilie.test.open.PublicClass.Public;

public class ESUP04Page extends Public<ESUP04Page> {
    public ESUP04Page reviewer(){
        this.findListByClassName("ivu-cascader-menu").get(1)
                .findByTagName("li")
                .click();
        return this;
    }

    public ESUP04Page selectReviewer(){
        this.findListByClassName(" ivu-select-dropdown-transfer").get(1)
                .findByTagName("li")
                .click();
        return this;
    }

    public ESUP04Page leaveTime(){
        this.findByXPath("//label[text()=\"请假时间：\"]/following-sibling::div")
                .click();
        label_calendar_today_queding("请假时间：");

        return this;
    }
}
