package com.beilie.test.open.hunters.cases.positons;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CustomerManagement;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.PositionManagerPage;
import org.junit.Test;

public class 职位管理_4_客户管理 extends HunterBase {
    @Test
    public void test() throws Throwable{
        HomePage homePage = (HomePage) login("13370273781", "1");
        CustomerManagement customerManagementPage = (CustomerManagement) homePage
                .clickMenuItem("职位管理", "客户管理")
                .sleepForSeconds(1)
                .transfer(CustomerManagement.class);
        customerManagementPage.clickIncrease().sleepForSeconds(1)
                //输入客户名称
                //.writeClientName("上海扶苏实业有限公司")
                //输入对外显示名称
                //.writeOutsideClientName("上海","有限公司")
                //选择所属行业
                //.clickIndustry().clickInternet()
                //所在地
               .clickLocation().sleepForSeconds(3)

                .submitIndustry()
                .sleepForSeconds(3);
    }
}

//#stab\.level > li:nth-child(1)
//#stab\.level > li:nth-child(1)
