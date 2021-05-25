package com.beilie.test.seleniums.core.sealed;

import com.beilie.test.seleniums.core.Vendor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class WebElementVendor extends WebAbstractVendor implements Vendor {
    @Override
    public void waitFor(Integer timeOutInSeconds, ExpectedCondition<Boolean> condition) {
        throw new RuntimeException();
    }

    @Override
    public void refresh() {
    }

    @Override
    public void back() {
    }

    @Override
    public void execute_script() {
    }

    @Override
    public void sendKeys(CharSequence... var1) {
        this.myDriver().sendKeys(var1);
    }

    private WebElement myDriver() {
        return (WebElement) this.driver;
    }

    @Override
    public void click() {
        this.myDriver().click();
    }

    @Override
    public void submit() {
        this.myDriver().submit();
    }

    //@Override
    /*public void execute_script() {
        this.myDriver().e;
    }*/

    @Override
    public void clear() {
        this.myDriver().clear();
    }

    @Override
    public String getTagName() {
        return this.myDriver().getTagName();
    }

    @Override
    public String getAttribute(String var1) {
        return this.myDriver().getAttribute(var1);
    }

    @Override
    public boolean isSelected() {
        return this.myDriver().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.myDriver().isEnabled();
    }

    @Override
    public String getText() {
        return this.myDriver().getText();
    }

    @Override
    public String getCssValue(String var1) {
        return this.myDriver().getCssValue(var1);
    }

    @Override
    public Rectangle getRect() {
        return this.myDriver().getRect();
    }

    @Override
    public Dimension getSize() {
        return this.myDriver().getSize();
    }

    @Override
    public Point getLocation() {
        return this.myDriver().getLocation();
    }

    @Override
    public boolean isDisplayed() {
        return this.myDriver().isDisplayed();
    }

    @Override
    public void hover() {
        Actions actions = new Actions((WebDriver) this.engine);
        actions.moveToElement((WebElement) this.driver).clickAndHold().perform();
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public void switchToPage(String windowHandle) {

    }

    //ifrema
    @Override
    public void switchToIfream(String id) {}

    @Override
    public void switchToIfream(WebElement ifream){}

    @Override
    public void switchOutIfream() {}

    @Override
    public List<String> getWindowHandles() {
        return null;
    }


}
