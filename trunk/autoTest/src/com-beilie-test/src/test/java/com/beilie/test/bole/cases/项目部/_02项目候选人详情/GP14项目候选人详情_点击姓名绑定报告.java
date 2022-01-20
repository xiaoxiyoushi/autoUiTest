/*
package com.beilie.test.bole.cases.项目部._02项目候选人详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EB0701Page;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP14Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.junit.Test;

public class GP14项目候选人详情_点击姓名绑定报告 extends BoleBase {
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
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickMenus("\n" +
                        "          项目管理", "我的项目")//点击菜单栏
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

                    .label_followingDiv_clickimg("目前职能：")//点击目前职能的icon
                    .functionSingleComponent()//选择职能组件

                    .clickSpan("确定").sleepForSeconds(1)//点击【确定】按钮  提交简历
                    .checkTip()////校对提示 上传简历成功
                    .clickConfirmBtn().sleepForSeconds(1)////点击提示的【确定】按钮
                    .checkTip_addProject(name)//校对提示 加入项目成功
                    .clickConfirmBtn()//点击提示的【确定】按钮
                    .img_altClick("关闭")//点击X
                    .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

            gP10Page.sendInputPlaceholder("请输入...", name)
                    .clickSpan("搜索").sleepForSeconds(2);

        }

        GP14Page gP14Page = (GP14Page) gP10Page.table_td_aClick(0, 0)//点击姓名
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(2);

        gP14Page.h1Class_aClick("titlestyle")

                ;

    }

}
*/
