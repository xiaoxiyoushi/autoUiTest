package com.beilie.test.bole.cases.客户部.客户管理_新增客户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GCCM01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
/*
新增单个客户
 */
public class _01GHHP00_添加单个客户 extends BoleBase {
    @Test
    public void 新增客户成功 ()throws IllegalAccessException, InstantiationException, InterruptedException{
        BdHomePage bdHomePage = login("68657224", "1").sleepForSeconds(3);

        GCCM01Page gCCM01Page=(GCCM01Page)bdHomePage.clickMenus(" 客户管理","添加客户")
                .switchToNewIframe1("GCCM01",GCCM01Page.class).sleepForSeconds(3);

        String clientName="上海友善公司"+Public.generateString(8);

        gCCM01Page.inputClientName(clientName) //输入公司名称

                  .selectClient()  //选择客户来源
                  .selectIndustry() //选择所属行业
                  .industryComponent()//行业公共组件
                  .selectCity()  //选择城市
                  .workPlaceComponent()//地点公共组件
                  .clickAddClient().sleepForSeconds(3)
                  .checkTips().sleepForSeconds(1)
        ;
    }
}
