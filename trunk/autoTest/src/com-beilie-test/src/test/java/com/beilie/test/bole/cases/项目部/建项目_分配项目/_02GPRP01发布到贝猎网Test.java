package com.beilie.test.bole.cases.项目部.建项目_分配项目;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP06Page;
import com.beilie.test.bole.pages.GP.GPCT01Page;
import com.beilie.test.bole.pages.GP.GPRP01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class _02GPRP01发布到贝猎网Test extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);
        //BdHomePage bdHomePage = login("68657207", "1").sleepForSeconds(3);

        String randomStr= Public.generateString(8);//8位随机字符串
        GPCT01Page gPCT01Page=(GPCT01Page)bdHomePage
                .clickClientManger("任务中心",6)
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);

        GPRP01Page gPRP01Page=(GPRP01Page)gPCT01Page.firstTask("创建项目集合-${customerName}").sleepForSeconds(1)//点击第一级任务名称的下拉icon
                  .secondTask("发布到贝猎网").sleepForSeconds(1)//点击第二级任务名称
                  .clickCarry()
                  .switchToNewIframe(0, GPRP01Page.class).sleepForSeconds(2);

        GP06Page gP06Page=(GP06Page)gPRP01Page.clickCompanyInp()//选公司名称
                  .clickDepartment("事业部"+randomStr)//选择部门
                  .submit().sleepForSeconds(1)//提交
                  .switchToNewIframe(0, GP06Page.class).sleepForSeconds(3);

        gP06Page.checkInform().sleepForSeconds(1);//校对跳到下一页，抓取里面数据 校对；
       }
    }
