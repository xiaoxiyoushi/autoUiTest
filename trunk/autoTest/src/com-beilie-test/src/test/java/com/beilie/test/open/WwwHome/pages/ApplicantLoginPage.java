package com.beilie.test.open.WwwHome.pages;

import com.beilie.core.exceptions.BusinessException;
import com.beilie.test.seleniums.core.Engine;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class ApplicantLoginPage extends UIPage<ApplicantLoginPage> {
    /**
     * 判定当前页面是已经加载成功的；
     */
    public Boolean isLoad() {
        return Boolean.TRUE;
    }
    /**
     * 断言是否已经完成客户管理页面的加载；
     */
    public ApplicantLoginPage assertLoaded() {
        if(Boolean.TRUE.equals(this.isLoad())){
            return this;
        }
        throw new BusinessException("页面加载失败。");
    }
    public ApplicantLoginPage checkCurrentUrl(){
        String url= Engine.getCurrentPageUrl();
        String url1="https://password.tanpin.com/cas/login?modeType=applicant";
        Boolean b=url.startsWith(url1);
        Assert.assertTrue(b);
        return this;
    }

    public ApplicantLoginPage checkCurrentUrl1(){
        String url= Engine.getCurrentPageUrl();
        String url1="https://passport.tanpin.com/cas/login?modeType=applicant";
        Boolean b=url.startsWith(url1);
        Assert.assertTrue(b);
        return this;
    }

    public ApplicantLoginPage backCurrentPage(){
        this.back();
        return this;
    }

    public void closeApplicantLoginPage(){
        /*
        无效
         */
        //Engine.closeCurrentPage();
        //return this;
    }
}
