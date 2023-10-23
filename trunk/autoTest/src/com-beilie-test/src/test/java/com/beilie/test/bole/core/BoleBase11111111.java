package com.beilie.test.bole.core;

import com.beilie.test.bole.pages.BbpiPage.BapiHomePage;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.open.hunters.pages.LoginPage;
import com.beilie.test.seleniums.core.TestCaseBase;
import com.beilie.test.seleniums.core.TestCaseBase11111;
import com.beilie.test.util.ProUtil;

public class BoleBase11111111 extends TestCaseBase11111 {
    ProUtil pro = new ProUtil("element.properties");

    protected BdHomePage cclLogin() throws IllegalAccessException, InstantiationException ,InterruptedException{
        LoginPage loginPage = (LoginPage) engine.createPage("http://47.110.140.203/#/home", LoginPage.class);
        return (BdHomePage)loginPage
                .clickAccountLogin().sleepForSeconds(1)
                .userName("66624284")
                .password("888888")
                //.captcha("1234")
                .submit()
                .transfer(BdHomePage.class);
    }

    protected BdHomePage login_ceshi(String str, String str1) throws IllegalAccessException, InstantiationException ,InterruptedException{
        String userName = pro.getPro(str);
        String password = pro.getPro(str1);
        LoginPage loginPage = (LoginPage) engine.createPage("http://192.168.5.215/#/home", LoginPage.class);
        return (BdHomePage)loginPage
                .clickAccountLogin().sleepForSeconds(1)
                .userName(userName)
                .password(password)
                .captcha("1234")
                .submit()
                .transfer(BdHomePage.class);
    }

    protected BdHomePage login(String str, String str1) throws IllegalAccessException, InstantiationException ,InterruptedException{
        String userName = pro.getPro(str);
        String password = pro.getPro(str1);
        LoginPage loginPage = (LoginPage) engine.createPage("http://192.168.5.205/#/home", LoginPage.class);
        return (BdHomePage)loginPage
                .clickAccountLogin().sleepForSeconds(1)
                .userName(userName)
                .password(password)
                .captcha("1234")
                .submit()
                .transfer(BdHomePage.class);
    }

    protected BdHomePage login_url(String str, String str1) throws IllegalAccessException, InstantiationException ,InterruptedException{
        String userName = pro.getPro(str);
        String password = pro.getPro(str1);
        LoginPage loginPage = (LoginPage) engine.createPage("http://192.168.5.205/#/home", LoginPage.class);
        return (BdHomePage)loginPage
                .transfer(BdHomePage.class);
    }

    protected BdHomePage projectLogin() throws IllegalAccessException, InstantiationException ,InterruptedException{
        LoginPage loginPage = (LoginPage) engine.createPage("http://121.43.170.17/login", LoginPage.class);
        return (BdHomePage)loginPage
                .sendInputPlaceholder("请输入用户名","17351151521")
                .sendInputPlaceholder("请输入密码","17351151521")
                .clickSpan("登录")
                .transfer(BdHomePage.class);
    }

    protected BdHomePage manageLogin(String userName, String password) throws IllegalAccessException, InstantiationException {
        LoginPage loginPage = (LoginPage) engine.createPage("http://192.168.5.223:8088/cas/login?modeType=hunterCompany&service=http%3A%2F%2F192.168.5.215%2Flogin", LoginPage.class);
        //LoginPage loginPage = (LoginPage) engine.createPage("http://192.168.5.205:8088/cas/login?modeType=hunterCompany&service=http%3A%2F%2F192.168.5.205%2Flogin#/home", LoginPage.class);
        return (BdHomePage)loginPage
                .clickAccountLogin()
                .userName(userName)
                .password(password)
                .captcha("1234")
                .submit()
                .transfer(BdHomePage.class);
    }

    protected BdHomePage autoLogin() throws IllegalAccessException, InstantiationException {
        engine.cookie1();
        LoginPage loginPage = (LoginPage) engine.createPage("http://192.168.5.222:8088/cas/login?modeType=hunterCompany&service=http%3A%2F%2F192.168.5.215%2Flogin", LoginPage.class);
        return (BdHomePage)loginPage.transfer(BdHomePage.class);
    }

    protected BapiHomePage liepinLogin() throws IllegalAccessException, InstantiationException {
        LoginPage loginPage = (LoginPage) engine.createPage("https://passport.liepin.com/account/v1/hlogin?backurl=https%3A%2F%2Fh.liepin.com%2F", LoginPage.class);

        return (BapiHomePage)loginPage.transfer(BapiHomePage.class);
    }
    protected BapiHomePage zuopinLogin() throws IllegalAccessException, InstantiationException {
        LoginPage loginPage = (LoginPage) engine.createPage("https://h.highpin.cn/?formURL=", LoginPage.class);

        return (BapiHomePage)loginPage.transfer(BapiHomePage.class);
    }
    protected BapiHomePage wuyouLogin() throws IllegalAccessException, InstantiationException {
        LoginPage loginPage = (LoginPage) engine.createPage("https://www.51jingying.com/common/login.php?loginas=spy", LoginPage.class);

        return (BapiHomePage)loginPage
                .wuyou_zhangHao_login("17664060864","zty520520")
                .transfer(BapiHomePage.class);

        /*
        return (BdHomePage)loginPage
                .clickAccountLogin()
                .userName(userName)
                .password(password)
                .captcha("1234")
                .submit()
                .transfer(BdHomePage.class);
         */
    }
}
