package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class UserServicesAgreementPage extends UIPage<UserServicesAgreementPage> {
    public UserServicesAgreementPage checkWenZi(){
        String str=this.findByCssSelector("#bg > div.all > p:nth-child(1) > span").getText();
        Assert.assertEquals("谈聘网用户服务协议",str);
        return this;
    }
}
