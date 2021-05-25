package com.beilie.test.open.hunters.cases.CreatePosition;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CreatePositionPage;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.PositionManagerPage;
import org.junit.Test;

public class 创建职位 extends HunterBase {
    @Test
    public void 创建职位() throws IllegalAccessException, InstantiationException, InterruptedException{
        HomePage homePage = login("13370273782", "1");
        CreatePositionPage createPositionPage = (CreatePositionPage) homePage
                .clickHeader("创建职位")
                .transfer(CreatePositionPage.class).sleepForSeconds(1);
        PositionManagerPage createPosition=(PositionManagerPage)createPositionPage
                /*
                企业基本信息
                 */
                .clickCorporateInformation().sleepForSeconds(1)
                .selectCorporateInformation()
                .clickDepartment().sleepForSeconds(1)
                .selectDepartment()

                /*
                职位基本信息
                 */
                //职位名称
                //.writePosition1("c开发")
                //职能分类
                .clickFunction()
                .functionProfessional().functionIt().functionEngineer()
                .submitFunction()
                //汇报对象
                .writeLeader("经理")
                //招聘人数
                .writeRecruits("4")
                //工作地点
                .clickWorkPlace()
                //.location1().location2().submitlocation()
                //下属人数
                .writeSubordinates("2")
                //税前年薪
                 .writeSalary1("15").writeSalary2("30")
                //福利待遇
                 .clickWelfare1().clickWelfare2()
                /*
                职位要求
                 */
                //年龄要求
                 .writeMinage("20").writeMaxage("45")
                 //学历要求
                .selectDegree().sleepForSeconds(1).degreeBachelor()
                //工作年限
                . writeYears("5")
                //所属行业
                .clickIndustry().clickInternet().submitIndustry()
                //职位描述
                .writeJob()
                //是否通过谈聘网发布
                //.clickNo()
                //截止日期
                .clickDeadline().clickDeadline1().clickDeadline2()
                //协议.sleepForSeconds(3)
                .clickProtocol()
                //点击创建职位
                .submitPosition().sleepForSeconds(1)
                //点击提示的确定按钮
                .clickPrompt().sleepForSeconds(2)
                .transfer(PositionManagerPage.class);
    }
}
