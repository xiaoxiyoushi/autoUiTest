package com.beilie.test.open.hunters.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class HomePage extends UIPage<HomePage> {
    public HomePage clickHeader(String text) throws IllegalAccessException, InstantiationException {
        /*this.waitFor(10, d -> {
            this.findByClassName("headerName").findByLinkText(text).click();
            return Boolean.TRUE;
        });*/
        return this;
    }

    public HomePage assertLoginSuccess() {
        Assert.assertTrue("登录失败，没有找到页面上有我的人才字样", this.hasLinkText("我的首页"));
        return this;
    }

    public HomePage hoverHeader(String headerName) {
        /*this.waitFor(10, d -> {
            try {
                this.findByLinkText(headerName).hover();
                return Boolean.TRUE;
            } catch (Exception e) {
                return Boolean.FALSE;
            }
        });*/
        return this;
    }

    public HomePage clickMenuItem(String headerName, String menuName) throws InterruptedException {
        String className = null;
        if (StringUtils.equals(headerName, "职位管理"))
            className = "positionLi";
        Element linkText = this.findByClassName(className);
        linkText.hover();
        this.sleepForSeconds(2);
        linkText.findListByTagName("a").parallelStream().filter(a -> StringUtils.equals(a.getText(), menuName))
                .findFirst().get().click();
        return this;
    }

    public HomePage clickQuit() throws InterruptedException {
        Element ulli = this.findById("ulli");
        ulli.hover();
        /*this.waitFor(10, d -> {
            try {
                ulli.findListByCssSelector("dd.cursor").get(1).click();
                return Boolean.TRUE;
            } catch (Exception e) {
                return Boolean.FALSE;
            }
        });*/
        return this;
    }

    public HomePage clickPersonalMenu(String itemName) throws InterruptedException {
        Element ulli = this.findById("ulli");
        ulli.hover();
        /*this.waitFor(10, d -> {
            try {
                ulli.findByLinkText(itemName).click();
                return Boolean.TRUE;
            } catch (Exception e) {
                return Boolean.FALSE;
            }
        });*/
        return this;
    }
}
