package com.beilie.test.open.hunters.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import java.util.List;

public class BasicInfoPage extends UIPage<BasicInfoPage>{
    /**
     * 判定是否页面上行数据加载完整
     */
    public BasicInfoPage assertHasData() {
        Element element = this.findByCssSelector("div.rankFooter").findListByTagName("div").get(1);
        List<Element> byTagNames = element.findListByTagName("em");
        if(StringUtils.isBlank(byTagNames.get(0).getText()))
            Assert.fail("未能加载姓名");
       /*String str=element.findByClassName("aem").getText();
        if(StringUtils.isBlank(str))
            Assert.fail("未能加载姓名");*/

        return this;
    }
}
