package com.beilie.test.bole.cases.项目部._02项目候选人详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EB0701Page;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.*;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.testng.annotations.Test;

public class GP10项目详情_点击预览绑定报告 extends BoleBase {
    @Test
    public void run() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage1 = login();
        process(bdHomePage1);
    }

    public BdHomePage login() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);
        return bdHomePage;
    }

    public void process(BdHomePage bdHomePage) throws IllegalAccessException, InstantiationException, InterruptedException {
        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject()//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String name = "高超" + randomStr;
        String phone = "13717767381" + randomStr;
        String mailbox = "158324803@qq.com" + randomStr;
        String projectName = "卖麦芽糖的";

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .inputClientName("请输入项目名称", projectName)//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        gP10Page.span_followingSpan_i_click("人选进程").sleepForSeconds(1)//点击正序
                .clickSpan("搜索").sleepForSeconds(2);

        String porjectProcess = gP10Page.clickProcess("寻访中", 1).sleepForSeconds(3)
                .table_td_spanValue(0, 3);//项目进程的值

        if (!porjectProcess.equals("正在联络")) {

            EBFA01Page eBFA01Page = (EBFA01Page) gP10Page
                    .clickSpan("新增一份简历")
                    .switchToNewIframe(1, EBFA01Page.class).sleepForSeconds(3);

            gP10Page = (GP10Page) eBFA01Page.judgeWay()
                    .uploadResume("C:\\Users\\86182\\Desktop\\ui自动化 测试的简历\\13717767381_高超.txt")
                    .sleepForSeconds(5)

                    .clearInput("请输入姓名")//清掉原来姓名的值
                    .sendInputPlaceholder("请输入姓名", name)//输入姓名

                    .clearInput("请输入联系电话")//清掉原来手机
                    .sendInputPlaceholder("请输入联系电话", phone)//输入手机值

                    .clearInput("请输入电子邮箱")//清掉原来邮箱
                    .sendInputPlaceholder("请输入电子邮箱", mailbox)//输入邮箱值

                    /*.label_followingDiv_clickimg("目前职能：")//点击目前职能的icon
                    .functionSingleComponent()//选择职能组件*/

                    .peopleInfo_location_click()//点击现居住地的icon
                    .workPlaceComponent()//地点公共组件

                    .workExperience_function_click()//点击目前职能的icon
                    .functionSingleComponent()//选择职能组件

                    .workExperience_industry_click()//点击所在行业的icon
                    .industryComponent()//行业公共组件


                    .clickSpan("确定").sleepForSeconds(1)//点击【确定】按钮  提交简历
                    .checkTip()////校对提示 上传简历成功
                    .clickConfirmBtn().sleepForSeconds(1)////点击提示的【确定】按钮
                    .checkTip_addProject(name)//校对提示 加入项目成功
                    .clickConfirmBtn()//点击提示的【确定】按钮
                    .i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                    .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

            gP10Page.sendInputPlaceholder("请输入...", name)
                    .clickSpan("搜索").sleepForSeconds(2);

        }
        EBFA08Page eBFA08Page = (EBFA08Page) gP10Page.secondTask("预览")
                .switchToNewIframe(1, EBFA08Page.class).sleepForSeconds(3);

        String message = eBFA08Page.clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告
                .div_Value(" 添加推荐报告成功 ");

        Assert.assertEquals("添加推荐报告成功", message);

        EB0701Page eB0701Page = (EB0701Page) eBFA08Page
                .switchToNewIframe(2, EB0701Page.class).sleepForSeconds(3);

        eBFA08Page = (EBFA08Page) eB0701Page.i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .switchToNewIframe(1, EBFA08Page.class).sleepForSeconds(3);

        GP10Page gP10Page_1 = (GP10Page) eBFA08Page.Li_click("推荐报告").sleepForSeconds(1)
                .checkBindBtn()
                .checkRecommendJob()
                .i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        GP14Page gP14Page = (GP14Page) gP10Page_1.table_td_aClick(0, 0)//点击姓名
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(2);

        gP14Page.spanClass_click("uploads fr error-color")//点击 删除 按钮
                .deleteButton_click().sleepForSeconds(1)
                .getSpanValue("立即生成");
    }

}

