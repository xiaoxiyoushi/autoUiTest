package com.beilie.test.bole.core;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.UIPage;

public class Common<T extends Common> extends Public<T> {
    //关闭页面，点击叉号icon
    public T i_class_click() {
        this.findByXPath("//i[@class=\"icon-btn ivu-icon bole icon-close2\"]").click();
        return (T) this;
    }

}
