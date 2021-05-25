package com.beilie.test.open.hunters.pages;
import com.beilie.test.seleniums.core.UIPage;
public class LoginPage extends UIPage<LoginPage> {
    public LoginPage() {
    }

    public LoginPage userName(String value) {
        this.findById("username").sendKeys(value);
        return this;
    }

    public LoginPage password(String password) {
        this.findById("password").sendKeys(password);
        return this;
    }

    public LoginPage clickAccountLogin(){
        this.findById("accountLogin").click();
        return this;
    }

    public LoginPage captcha(String code) {
        this.findById("captcha").sendKeys(code);
        return this;
    }

    public LoginPage submit() throws IllegalAccessException, InstantiationException {
        this.findByClassName("loginBtn").submit();
        return this;
    }

    public LoginPage submit1() throws IllegalAccessException, InstantiationException {
        this.findByXPath("//input[@value=\"立即登录\"]").click();
        return this;
    }

    public LoginPage wuyou_zhangHao_login(String username,String password) throws IllegalAccessException, InstantiationException {
        this.findByXPath("//input[@placeholder=\"邮箱/手机/用户名\"]")
                .sendKeys(username);
        this.findByXPath("//input[@placeholder=\"密码\"]")
                .sendKeys(password);
        this.findByXPath("//a[text()=\"登录\"]").click();
        return this;

    }

    public LoginPage sendInputPlaceholder(String str,String value){
        this.findByXPath("//input[@placeholder=\""+str+"\"]").sendKeys(value);
        return this;
    }
    public LoginPage clickSpan(String str){
        this.findByXPath("//span[text()=\""+str+"\"]").click();
        return this;
    }
}
