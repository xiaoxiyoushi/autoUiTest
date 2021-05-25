package com.beilie.test.seleniums.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public interface Vendor {
    void setEngine(Object engine);
    Element findByTagName(String tagName);
    Element findById(String id);
    Element findByClassName(String className);
    Element findByCssSelector(String selector);
    /*
    * xpath*/
    Element findByXPath(String xpathExpression);
    void waitFor(Integer timeOutInSeconds, ExpectedCondition<Boolean> condition);
    Element findByLinkText(String text);
    Boolean hasClassName(String className);
    Boolean hasLinkText(String text);
    void refresh();
    void back();
    //void showWaiting();
    void execute_script();

    void sendKeys(CharSequence... var1);
    void click();
    void submit();

    /**
     *ListXPath
     */
    List<Element> findListByXPath(String xpathExpression);
    List<Element> findListByTagName(String tagName);
    void clear();
    String getTagName();
    String getAttribute(String var1);
    boolean isSelected();
    boolean isEnabled();
    String getText();
    String getCssValue(String var1);
    Rectangle getRect();
    Dimension getSize();
    Point getLocation();
    boolean isDisplayed();
    List<Element> findListByClassName(String className);
    List<Element> findListById(String id);
    void hover();
    List<Element> findListByCssSelector(String selector);
    String getWindowHandle();

    void switchToPage(String windowHandle);
    //ifrema
    void switchToIfream(String id);
    void switchToIfream(WebElement ifream);
    void switchOutIfream();

    List<String> getWindowHandles();

}
