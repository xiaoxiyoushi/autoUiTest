package com.beilie.test.bole.cases.项目部._01项目详情.团队人选;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

public class GP10项目详情_新增简历_加入项目Test extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue().sleepForSeconds(1);//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject().sleepForSeconds(1)//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String name = "汪文亮" + randomStr;
        String phone ="1"+ Public.GenerateNumber(10);
        String mailbox = "270232487@qq.com" + randomStr;

        GP10Page gP10Page = (GP10Page) gPPM10Page.table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        EBFA01Page eBFA01Page = (EBFA01Page) gP10Page
                .clickSpan("新增一份简历")
                .switchToNewIframe(1, EBFA01Page.class).sleepForSeconds(3);

        GP10Page gP10Page_1 = (GP10Page) eBFA01Page.judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\resume\\汪文亮.txt")
                .sleepForSeconds(10)

                .clearInput("请输入姓名")//清掉原来姓名的值
                .sendInputPlaceholder("请输入姓名", name)//输入姓名

                .clearInput("请输入联系电话")//清掉原来手机
                .sendInputPlaceholder("请输入联系电话", phone)//输入手机值

                .clearInput("请输入电子邮箱")//清掉原来邮箱
                .sendInputPlaceholder("请输入电子邮箱", mailbox)//输入邮箱值

                .peopleInfo_location_click().sleepForSeconds(1)//点击现居住地的icon
                .workPlaceComponent()//地点公共组件

                .workExperience_function_click()//点击目前职能的icon
                .functionSingleComponent()//选择职能组件

                .workExperience_industry_click()//点击所在行业的icon
                .industryComponent()//行业公共组件

                .clickSpan("请选择学历")//点击学历框
                .Li_click("不限")//选择不限

                .clickSpan("确定").sleepForSeconds(1)//点击【确定】按钮  提交简历
                .checkTip()////校对提示 上传简历成功
                .clickConfirmBtn().sleepForSeconds(2)////点击提示的【确定】按钮

                .listSpan_Click("确定",2).sleepForSeconds(1)
                .listSpan_Click("确定",5).sleepForSeconds(1)

                .checkTip_addProject(name)//校对提示 加入项目成功
                .clickConfirmBtn()//点击提示的【确定】按钮
                .i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        gP10Page_1.sendInputPlaceholder("请输入...", name)//输入姓名
                .clickSpan("搜索").sleepForSeconds(2)//点击“搜索”
                .getValue(name).sleepForSeconds(2);//根据值获取到该元素 则验证成功

    }
}
