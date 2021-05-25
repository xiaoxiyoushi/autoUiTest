package com.beilie.test.seleniums.core;

import com.beilie.test.seleniums.core.sealed.WebDriverVendor;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.plugin.javascript.navig.Window;

public class Engine {
    private volatile static Engine engine;
    private static WebDriver driver;

    public static Engine getInstance() {
        if (engine == null) {
            synchronized (Engine.class) {
                if (engine == null) {
                    engine = new Engine();
                }
            }
        }
        return engine;
    }

    private Engine() {
        //System.setProperty("webdriver.chrome.driver", "D://workspace//TEST//trunk//autoTest//tools//seleniums//3.141.59//chromedriver.exe");
        //System.setProperty("webdriver.ie.driver", "D://workspace//TEST//trunk//autoTest//tools//seleniums//3.141.59//IEDriverServer.64.exe");
        System.setProperty("webdriver.chrome.driver", "D://workPlace//trunk//autoTest//tools//seleniums//3.141.59//chromedriver.exe");
        //System.setProperty("webdriver.ie.driver", "D://workspace//TEST//trunk//autoTest//tools//seleniums//3.141.59//IEDriverServer.64.exe");
        //WebDriver driver=new InternetExplorerDriver(); //ie
        //WebDriver driver=new FireFoxDriver(); //firefox
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //options.;
        //options.addArguments("–incognito");
        //options.addArguments("disable-infobars");
        //options.addArguments("headless");

        driver = new ChromeDriver(options); //chrome
    }

    public static String getCurrentPageUrl() {
        String current_url = driver.getCurrentUrl();
        return current_url;
    }

    /*public static void closeCurrentPage() {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("w").keyUp(Keys.CONTROL).sendKeys(Keys.NULL).perform();
    }*/

    public UIPage createPage(String url, Class<? extends UIPage> pageClass) throws IllegalAccessException, InstantiationException {
        driver.get(url);
        //driver.switchTo()

        return createPage(pageClass);
    }
    public UIPage cookie1() throws IllegalAccessException, InstantiationException {
        Cookie c1 = new Cookie("JSESSIONID", "1E2EB39E0621E0AC5B80297B925D2CAA");
        Cookie c2 = new Cookie("SESSION", "50eb13cb-5886-4b7e-ac24-241fed0f9a1b");
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);
        driver.navigate().refresh();

        return null;
    }


    protected UIPage createPage(Class<? extends UIPage> pageClass) throws InstantiationException, IllegalAccessException {
        UIPage page = pageClass.newInstance();
        WebDriverVendor vendor = new WebDriverVendor();
        vendor.setDriver(driver);
        vendor.setEngine(driver);
        page.setVendor(vendor);
        return page;
    }

    /*public UIPage createIfream(String id,Class<? extends UIPage> pageClass){
        driver.switchTo().frame(id);
        return createIfream(pageClass);
    }*/

    public static void quit() {
        driver.quit();
        Engine.clear();
    }

    public static void close() {
        driver.close();
    }



    private static void clear() {
        if (engine != null) {
            synchronized (Engine.class) {
                if (engine != null) {
                    engine = null;
                }
            }
        }
    }
}
