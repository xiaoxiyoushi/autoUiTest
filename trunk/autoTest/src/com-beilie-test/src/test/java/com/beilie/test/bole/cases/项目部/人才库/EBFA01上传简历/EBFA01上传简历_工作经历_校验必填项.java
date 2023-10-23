package com.beilie.test.bole.cases.项目部.人才库.EBFA01上传简历;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

public class EBFA01上传简历_工作经历_校验必填项 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA01Page eBFA01Page = (EBFA01Page) bdHomePage.sleepForSeconds(1)
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_upResume().sleepForSeconds(1)//点击二级菜单：上传简历
                .switchToNewIframe1("EBFA01", EBFA01Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        int randomNum = Public.generateNumber1(20);//0-19位随机数

        eBFA01Page.judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\resume\\吕先生.docx")//.docx文件

                .waitResume("吕先生")
                .peopleInfo_location_click()//点击现居住地的icon
                .workPlaceComponent()//地点公共组件

                .workExperience_function_click()//点击目前职能的icon
                .functionSingleComponent()//选择职能组件

                .clickSpan("请选择学历")//点击学历框
                .Li_click("不限")//选择不限

                .education_calendar_months()//选开始时间 并且选中至今

                //公司名称 校验必填项
                .input_bcakSpace("请输入公司名称", 16)//将公司名称 键盘删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("公司名称不能为空")//根据姓名校验 获取元素
                .sendInputPlaceholder("请输入公司名称", "上海微创医疗器械(集团)有限公司")//将公司名称填值

                //任职时间
                .workExperience_time_delete()//×掉已选的任职时间
                .workExperience_currentTime_click()//取消至今的勾选
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("开始时间或结束时间不能为空")//获取时间校验的值
                .calendar_months("开始时间")//选开始时间 并且选中至今

                //职位
                .input_bcakSpace("请输入职位名称", 7)//将职位名称 键盘删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("职位名称不能为空")//根据职位校验 获取元素
                .sendInputPlaceholder("请输入职位名称", "技术/研发经理")//将职位填值

                //目前职能
                .label_followingDiv_clickI("目前职能：")//将已选的目前职能 删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("目前职能不能为空")//根据目前职能 获取元素
                .workExperience_function_click()//点击目前职能的icon
                .functionSingleComponent()//选择职能组件

                //所在行业
                //.label_followingDiv_clickI("所在行业：")//将已选的所在行业 删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("行业不能为空")//根据所在行业 获取元素
                .workExperience_industry_click()//点击所在行业的icon
                .industryComponent()//行业公共组件

                //工作内容
                .clearTextarea("请输入工作内容")//清除工作内容的文本
                .textarea_sendkeys("请输入工作内容", "a")//给工作内容输入 a
                .textarea_bcakSpace("请输入工作内容", 1)//将工作内容 键盘删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("工作内容不能为空")//根据工作内容非必填项校验 获取元素
                .textarea_sendkeys("请输入工作内容", "产品市场调研、客户需求分析、沟通和协调，追踪国内外先进人工心脏技术与资讯")//输入值
                .clickSpan("确定").sleepForSeconds(1)
                .checkTip().sleepForSeconds(2);//简历入库后 校验提示；


    }
}
