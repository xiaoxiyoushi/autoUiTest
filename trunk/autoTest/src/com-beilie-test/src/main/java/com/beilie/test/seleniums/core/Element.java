package com.beilie.test.seleniums.core;

import org.openqa.selenium.*;

import java.util.List;

public interface Element extends SearchElement{
    Element click();
    Element submit();
    Element sendKeys(CharSequence... var1);
    Element clear();
    //Element scrollTo();
    String getTagName();
    String getAttribute(String var1);
    boolean isSelected();
    boolean isEnabled();
    String getText();
    boolean isDisplayed();
    Point getLocation();
    Dimension getSize();
    Rectangle getRect();
    String getCssValue(String var1);
    void hover();
}
