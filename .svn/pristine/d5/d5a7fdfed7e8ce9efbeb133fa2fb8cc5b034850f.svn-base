package com.beilie.test.seleniums.core;

import java.util.List;

public interface SearchElement {
    SearchTemplate setVendor(Vendor vendor);

    Element findByTagName(String tagName);

    Element findById(String id);

    Element findByClassName(String className);

    Element findByCssSelector(String selector);

    Element findByLinkText(String text);

    SearchElement sleepForSeconds(int i) throws InterruptedException;

    Boolean hasClassName(String className);

    Boolean hasLinkText(String text);

     /*
     * xpath*/
    Element findByXPath(String xpathExpression);
    /**
     *ListXPath
     */
    List<Element> findListByXPath(String xpathExpression);

    List<Element> findListByTagName(String tagName);

    List<Element> findListByClassName(String className);

    List<Element> findListById(String id);

    List<Element> findListByCssSelector(String selector);
}
