package com.beilie.test.seleniums.core.sealed;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIElement;
import com.beilie.test.seleniums.core.Vendor;
import org.openqa.selenium.*;

import java.util.List;
import java.util.stream.Collectors;

public abstract class WebAbstractVendor implements Vendor {

    protected Object engine;

    public void setEngine(Object engine) {
        this.engine = engine;
    }

    public void setDriver(SearchContext driver) {
        this.driver = driver;
    }

    protected SearchContext driver;

    @Override
    public Element findByLinkText(String text) {
        WebElement element = this.driver.findElement(By.linkText(text));
        return new UIElement().setVendor(newVendor(element));
    }

    @Override
    public Boolean hasClassName(String className) {
        return this.driver.findElements(By.className(className)).size() > 0;
    }

    @Override
    public Boolean hasLinkText(String text) {
        return this.driver.findElements(By.linkText(text)).size() > 0;
    }


    @Override
    public List<Element> findListByTagName(String tagName) {
        List<WebElement> elements = this.driver.findElements(By.tagName(tagName));
        return getElements(elements);
    }

    private List<Element> getElements(List<WebElement> elements) {
        return elements.stream().map(el -> {
            Vendor newElement = newVendor(el);
            return new UIElement().setVendor(newElement);
        }).collect(Collectors.toList());
    }


    @Override
    public Element findByTagName(String tagName) {
        WebElement element = this.driver.findElement(By.tagName(tagName));
        return new UIElement().setVendor(newVendor(element));
    }

    @Override
    public Element findById(String id) {
        WebElement element = this.driver.findElement(By.id(id));
        return new UIElement().setVendor(newVendor(element));
    }

    //ifrema
   /* @Override
    public Element findById(String id) {
        WebElement element = this.driver.findElement(By.id(id));
        return new UIElement().setVendor(newVendor(element));
    }*/

    @Override
    public Element findByClassName(String className) {
        WebElement element = driver.findElement(By.className(className));
        return new UIElement().setVendor(newVendor(element));
    }

    @Override
    public Element findByCssSelector(String selector) {
        WebElement element = this.driver.findElement(By.cssSelector(selector));
        return new UIElement().setVendor(newVendor(element));
    }

    /*
    * xpath*/
    @Override
    public Element findByXPath(String xpathExpression) {
        WebElement element = this.driver.findElement(By.xpath(xpathExpression));
        return new UIElement().setVendor(newVendor(element));
    }
    /**
     *ListXPath
     */
    @Override
    public List<Element> findListByXPath(String xpathExpression) {
        List<WebElement> elements = this.driver.findElements(By.xpath(xpathExpression));
        return getElements(elements);
    }


    private Vendor newVendor(WebElement element) {
        WebElementVendor elementVendor = new WebElementVendor();
        elementVendor.setDriver(element);
        elementVendor.setEngine(this.engine);
        return elementVendor;
    }

    @Override
    public List<Element> findListByClassName(String className) {
        List<WebElement> elements = this.driver.findElements(By.className(className));
        return getElements(elements);
    }

    @Override
    public List<Element> findListById(String id) {
        List<WebElement> elements = this.driver.findElements(By.id(id));
        return getElements(elements);
    }

    @Override
    public List<Element> findListByCssSelector(String selector) {
        List<WebElement> elements = this.driver.findElements(By.cssSelector(selector));
        return getElements(elements);
    }


}
