package com.beilie.test.open.WwwHome.core;

import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import com.beilie.test.seleniums.core.TestCaseBase;

public class WwwBase extends TestCaseBase {
    protected WwwHomePage jump() throws IllegalAccessException, InstantiationException{
       WwwHomePage wwwHomePage=(WwwHomePage) engine.createPage("http://192.168.5.150:32286",WwwHomePage.class);
        return wwwHomePage;
    }

    protected WwwHomePage jump1() throws IllegalAccessException, InstantiationException{
        WwwHomePage wwwHomePage1=(WwwHomePage) engine.createPage("https://www.tanpin.com/#/",WwwHomePage.class);
        return wwwHomePage1;
    }
}
