package com.beilie.test.seleniums.core.sealed;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.Vendor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebDriverVendor extends WebAbstractVendor implements Vendor {
    /**
     * 获取cookcie
     * @return
     * *//*
    public Set<Cookie> getCookie(){
        Set<Cookie> cookies = ((WebDriver) this.driver).manage().getCookies();
        return cookies;
    }*/

    /**
     * 设置cookie
     * *//*
    public void setCookie(Cookie cookie){
        ((WebDriver) this.driver).manage().addCookie(cookie);
    }
*/
    @Override
    public void waitFor(Integer timeOutInSeconds, String str) {
        (new WebDriverWait((WebDriver) this.driver, timeOutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
        //(new WebDriverWait((WebDriver) this.driver, timeOutInSeconds)).until(condition);
    }

    /*public void waitFor(Integer timeOutInSeconds, ExpectedCondition<Boolean> condition) {
        (new WebDriverWait((WebDriver) this.driver, timeOutInSeconds)).until(condition);
    }*/

    /*@Override
    public void waitFor(Integer timeOutInSeconds, Element element) {
        (new WebDriverWait((WebDriver) driver, timeOutInSeconds)).;
    }*/

    @Override
    public void refresh() {
        ((WebDriver) this.driver).navigate().refresh();
    }

    @Override
    public void back() {
        ((WebDriver) this.driver).navigate().back();
    }

    @Override
    public void execute_script() {
        Element element=this.findByXPath("//div[text()=\"编辑员工信息\"]/parent::div/parent::div");
        String setscroll = "document.documentElement.scrollTop=" + "700";//操作垂直滚动d条，向下移动500像素
        String setscroll_1 = "document.documentElement.scrollLeft=" + "500";//水平滚动条，向右移动500像素
        ((JavascriptExecutor) this.driver).executeScript(setscroll,element);
    }

    @Override
    public void execute_script1() {
        //Element element=this.findListByClassName("ef-panel-wrap").get(0);
        /*element.click();
        element.sendKeys(Keys.PAGE_DOWN);
        element.sendKeys(Keys.END);*/
        String setscroll = "document.querySelector('.ef-page-body').scrollTop=10000";//操作垂直滚动d条，向下移动500像素
        //((JavascriptExecutor) this.driver).executeScript(setscroll);
        //String js ="window.scroll(0,1000)";
        //document.getElementsByClassName("overflow-auto")[1].scrollTop=10000
        ((JavascriptExecutor) this.driver).executeScript(setscroll);
    }
//    @Override
//    public void showWaiting() {
//        ((WebDriverWait(driver,10,0.5))).;
//    }

    @Override
    public void execute_script2(String str) {
        ((JavascriptExecutor) this.driver).executeScript(str);
    }

    @Override
    public void sendKeys(CharSequence... var1) {

    }

    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void clear() {

    }



    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String var1) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public String getCssValue(String var1) {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public void hover() {

    }

    @Override
    public String getWindowHandle() {
        return ((WebDriver) this.driver).getWindowHandle();
    }

    @Override
    public void switchToPage(String windowHandle) {
        ((WebDriver) this.driver).switchTo().window(windowHandle);
    }

    //ifrema
    @Override
    public void switchToIfream(String id) {
        ((WebDriver) this.driver).switchTo().frame(id);
    }

    @Override
    public void switchToIfream(WebElement ifream) {
        ((WebDriver) this.driver).switchTo().frame(ifream);
    }

    @Override
    public void switchOutIfream() {
        ((WebDriver) this.driver).switchTo().defaultContent();
    }

    @Override
    public List<String> getWindowHandles() {
        Set<String> handles = ((WebDriver) this.driver).getWindowHandles();
        return new ArrayList<>(handles);
    }


}
