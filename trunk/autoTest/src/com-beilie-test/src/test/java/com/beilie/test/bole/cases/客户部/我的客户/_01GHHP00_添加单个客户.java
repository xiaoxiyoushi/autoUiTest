package com.beilie.test.bole.cases.客户部.我的客户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GCCM01Page;
import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.util.TestReport;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

/*
新增单个客户
 */
@Listeners({TestReport.class})
public class _01GHHP00_添加单个客户 extends BoleBase {
    @Test(description="测试添加单个客户")
    public void 新增客户成功 ()throws IllegalAccessException, InstantiationException, InterruptedException{
        BdHomePage bdHomePage = login("bd_userName", "bd_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GCCM01Page gCCM01Page=(GCCM01Page)bdHomePage
                .clickFirstMenu_clientManage()
                .clickSecondMenu_addClient()
                .switchToNewIframe1("GCCM01",GCCM01Page.class).sleepForSeconds(3);

        String clientName="上海友善公司"+Public.generateString(8);

        gCCM01Page.inputClientName(clientName) //输入公司名称

                  .selectClient()  //选择客户来源
                  .selectIndustry() //选择所属行业
                  .industryComponent()//行业公共组件
                  .selectCity()  //选择城市
                  .workPlaceComponent()//地点公共组件
                  .clickAddClient().sleepForSeconds(4)
                  .checkTips().sleepForSeconds(1)
        ;
    }
}
