package com.beilie.test.seleniums.core;

import java.util.List;

public class SearchTemplate<T extends SearchTemplate> implements SearchElement{
    protected Vendor vendor;

    @Override
    public T setVendor(Vendor vendor){
        this.vendor = vendor;
        return (T) this;
    }

    @Override
    public Element findByTagName(String tagName) {
        return this.vendor.findByTagName(tagName);
    }

    @Override
    public Element findById(String id) {
        return this.vendor.findById(id);
    }

    @Override
    public Element findByClassName(String className) {
        return this.vendor.findByClassName(className);
    }

    @Override
    public Element findByCssSelector(String selector) {
        return this.vendor.findByCssSelector(selector);
    }

    /*
    * xpath*/
    @Override
    public Element findByXPath(String xpathExpression){
        return this.vendor.findByXPath(xpathExpression);
    }

    /**
     *ListXPath
     */
    public List<Element> findListByXPath(String xpathExpression) {
        return this.vendor.findListByXPath(xpathExpression);
    }

    @Override
    public Element findByLinkText(String text) {
        return this.vendor.findByLinkText(text);
    }

    @Override
    public T sleepForSeconds(int i) throws InterruptedException {
        Thread.sleep(i * 1000);
        return (T) this;
    }
    @Override
    public Boolean hasClassName(String className) {
        return this.vendor.hasClassName(className);
    }

    @Override
    public Boolean hasLinkText(String text) {
       return this.vendor.hasLinkText(text);
    }

    public List<Element> findListByTagName(String tagName) {
        return this.vendor.findListByTagName(tagName);
    }

    public List<Element> findListByClassName(String className) {
        return this.vendor.findListByClassName(className);
    }

    public List<Element> findListById(String id) {
        return this.vendor.findListById(id);
    }

    @Override
    public List<Element> findListByCssSelector(String selector) {
        return this.vendor.findListByCssSelector(selector);
    }
}
