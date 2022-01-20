package com.beilie.test.bole.cases.项目部.人才库.EBFA01上传简历;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA01上传简历_教育信息_校验必填项  extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA01Page eBFA01Page = (EBFA01Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_upResume()//点击二级菜单：上传简历
                .switchToNewIframe1("EBFA01", EBFA01Page.class).sleepForSeconds(1);

        String randomStr= Public.generateString(8);//8位随机字符串
        int randomNum=Public.generateNumber1(20);//0-19位随机数

        eBFA01Page.judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\resume\\吕先生.docx").sleepForSeconds(3)//.docx文件
                .sleepForSeconds(4)

                .workExperience_function_click()//点击目前职能的icon
                .functionSingleComponent()//选择职能组件

                .input_bcakSpace("请输入学校名称",4)//将学校名称 键盘删掉
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("学校名称不能为空")//根据学校名称校验 获取元素
                .sendInputPlaceholder("请输入学校名称","东北大学")//将学校名称填值

                .educations_time_delete(0)//×掉已选的开始就读时间
                .educations_endTime_delete()//×掉已选的结束就读时间
                .clickSpan("确定").sleepForSeconds(2)
                .div_getValue("开始时间或结束时间不能为空")//获取时间校验的值
                .education_calendar_months("开始时间")//选开始时间 并且选中至今
                .clickSpan("确定").sleepForSeconds(1)
                .checkTip().sleepForSeconds(2);//简历入库后 校验提示；
                ;

    }
}
