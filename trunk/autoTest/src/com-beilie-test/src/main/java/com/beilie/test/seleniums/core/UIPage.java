package com.beilie.test.seleniums.core;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UIPage<T extends UIPage> extends SearchTemplate<T> {

    private String windowHandle;

    public void waitFor(Integer timeOutInSeconds, ExpectedCondition<Boolean> condition) {
        vendor.waitFor(timeOutInSeconds, condition);
    }

    public T waitForTitleLoaded(int i, String s) {
        ExpectedCondition<Boolean> condition = d -> d.getTitle().toLowerCase().endsWith(s);
        this.vendor.waitFor(i, condition);
        return (T) this;
    }

    protected UIPage createPage(Class<? extends UIPage> pageClass) throws InstantiationException, IllegalAccessException {
        UIPage page = pageClass.newInstance();
        page.setVendor(this.vendor);
        return page;
    }

    protected UIPage switchToPage(String windowHandle, Class<? extends UIPage> pageClass) throws IllegalAccessException, InstantiationException {
        if (StringUtils.isBlank(windowHandle))
            windowHandle = this.vendor.getWindowHandle();
        this.vendor.switchToPage(windowHandle);

        UIPage page = pageClass.newInstance();
        page.setVendor(this.vendor);
        return page;
    }

    public UIPage switchToIframe(String id, Class<? extends UIPage> pageClass) throws IllegalAccessException, InstantiationException {
        this.vendor.switchToIfream(id);

        UIPage page = pageClass.newInstance();
        page.setVendor(this.vendor);
        return page;
    }

    public UIPage switchOutIframe(Class<? extends UIPage> pageClass)throws IllegalAccessException, InstantiationException ,InterruptedException{
        //跳出当前Ifream
        this.vendor.switchOutIfream();
        this.sleepForSeconds(1);

        UIPage page = pageClass.newInstance();
        page.setVendor(this.vendor);
        return page;
    }


    public UIPage switchToNewIframe(int i,Class<? extends UIPage> pageClass) throws IllegalAccessException, InstantiationException ,InterruptedException{
        //跳出当前Ifream
        this.vendor.switchOutIfream();
        this.sleepForSeconds(1);

        Element ifream=this.findByCssSelector("#gaohr_windows").findListByTagName("iframe").get(i);
        String id=ifream.getAttribute("id");
        //String id1="WID"+id;
        //进入新的Ifream
        this.vendor.switchToIfream(id);

        UIPage page = pageClass.newInstance();
        page.setVendor(this.vendor);
        return page;
    }

    public UIPage switchToNewIframe1(String id,Class<? extends UIPage> pageClass) throws IllegalAccessException, InstantiationException ,InterruptedException{
        //跳出当前Ifream
        this.vendor.switchOutIfream();
        this.sleepForSeconds(1);

        this.vendor.switchToIfream(id);

        UIPage page = pageClass.newInstance();
        page.setVendor(this.vendor);
        return page;
    }

    protected T active() {
        if (StringUtils.isNotBlank(this.windowHandle))
            this.vendor.switchToPage(this.windowHandle);
        return (T) this;
    }

    public T activeSelf(){
        return this.active();
    }

    public UIPage transfer(Class<? extends UIPage> pageClass) throws IllegalAccessException, InstantiationException {
        return createPage(pageClass);
    }

    /**
     * 刷新一次页面
     */
    public void refresh() {
        this.vendor.refresh();
    }

    public void back(){
        this.vendor.back();
    }

    public void execute_script(){
        this.vendor.execute_script();
    }

    public List<String> getWindowHandles() {
        return vendor.getWindowHandles();
    }
    public String getWindowHandle(){
        return vendor.getWindowHandle();
    }

    public UIPage switchToNextPage(Class<? extends UIPage> pageClass) throws InstantiationException, IllegalAccessException {
             //StringUtils的isBlank()方法,校验空值  返回值是true
        if (StringUtils.isBlank(windowHandle))

            //获取当前窗口的句柄
            windowHandle = this.vendor.getWindowHandle();

        //获取所有的窗口句柄
        List<String> windowHandles = this.getWindowHandles();
        for (String handle : windowHandles) {

              //略过当前窗口
            if (StringUtils.equals(this.windowHandle, handle))
                continue;

            else {
                //return this.switchToPage(handle, pageClass);
                return this.switchToPage(handle, pageClass);
            }
        }
        return null;
    }

    public UIPage switchToNextPage1(Class<? extends UIPage> pageClass) throws InstantiationException, IllegalAccessException {
        //StringUtils的isBlank()方法,校验空值  返回值是true
        if (StringUtils.isBlank(windowHandle))

            //获取当前窗口的句柄
            windowHandle = this.vendor.getWindowHandle();

        //获取所有的窗口句柄
        List<String> windowHandles = this.getWindowHandles();
        for (int i=0;i<windowHandles.size();i++) {

            //System.out.println(handle);
            String handle=windowHandles.get(2);

            return this.switchToPage(handle, pageClass);

            //略过当前窗口
            /*if (StringUtils.equals(this.windowHandle, handle))
                continue;

            else {
                //return this.switchToPage(handle, pageClass);
                return this.switchToPage(this.windowHandle, pageClass);
            }*/
        }
        return null;
    }


}
