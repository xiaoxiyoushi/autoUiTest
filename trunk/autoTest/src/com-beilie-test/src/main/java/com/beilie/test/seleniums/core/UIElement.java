package com.beilie.test.seleniums.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

public class UIElement extends SearchTemplate<UIElement> implements Element{
    @Override
    public Element click() {
        this.vendor.click();
        return this;
    }

    @Override
    public Element submit() {
        this.vendor.submit();
        return this;
    }

    @Override
    public Element sendKeys(CharSequence... var1) {
        this.vendor.sendKeys(var1);
        return this;
    }

    @Override
    public Element clear() {
        this.vendor.clear();
        return this;
    }

    /*@Override
    public Element scrollTo() {
        this.vendor.execute_script();
        return this;
    }*/

    @Override
    public String getTagName() {
        return this.vendor.getTagName();
    }

    @Override
    public String getAttribute(String var1) {
        return this.vendor.getAttribute(var1);
    }

    @Override
    public boolean isSelected() {
        return this.vendor.isSelected();
    }

    @Override
    public boolean isEnabled() {
         return this.vendor.isEnabled();
    }

    @Override
    public String getText() {
        return this.vendor.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.vendor.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.vendor.getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.vendor.getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.vendor.getRect();
    }

    @Override
    public String getCssValue(String var1) {
        return this.vendor.getCssValue(var1);
    }

    @Override
    public void hover() {
        this.vendor.hover();
    }
}
