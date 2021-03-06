package com.beilie.test.bole.cases.项目部.人才库.EBFA01上传简历;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA01上传简历_个人信息模块_校验必填项 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA01Page eBFA01Page = (EBFA01Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_upResume()//点击二级菜单：上传简历
                .switchToNewIframe1("EBFA01", EBFA01Page.class).sleepForSeconds(1);

        String randomStr= Public.generateString(8);//8位随机字符串
        //int randomNum=Public.generateNumber1(20);//0-19位随机数

        eBFA01Page.judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\resume\\吕先生.docx").sleepForSeconds(3)//.docx文件
                .sleepForSeconds(4)

                .workExperience_function_click()//点击目前职能的icon
                .functionSingleComponent()//选择职能组件

                /*.workExperience_function_click()//点击所在行业的icon
                .industryComponent()//行业公共组件*/

                .input_bcakSpace("请输入姓名",3)//将吕先生 键盘删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("姓名不能为空")//根据姓名校验 获取元素
                .sendInputPlaceholder("请输入姓名","吕先生")//将姓名填值

                .input_bcakSpace("请输入年龄",2)//将年龄 键盘删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("年龄不能为空")//根据年龄校验 获取元素
                .sendInputPlaceholder("请输入年龄","34")//将年龄填值

                .peopleInfo_location_delete()//×掉地点
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("现居住地不能为空")//根据年龄校验 获取元素
                .peopleInfo_location_click()//点击现居住地的icon
                .workPlaceComponent()//地点公共组件

                .input_bcakSpace("请输入联系电话",11)//将联系电话 键盘删掉
                .input_bcakSpace("请输入电子邮箱",18)//将电子邮箱 键盘删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("手机和邮箱至少填一项")//根据联系电话校验 获取元素
                .sendInputPlaceholder("请输入联系电话","187210"+randomStr)//给联系电话填值
                .sendInputPlaceholder("请输入电子邮箱","lvxiao2008@163.com"+randomStr)//给电子邮箱填值
                .sleepForSeconds(1)
                .clickSpan("确定").sleepForSeconds(1)
                .checkTip().sleepForSeconds(2);

    }
}
