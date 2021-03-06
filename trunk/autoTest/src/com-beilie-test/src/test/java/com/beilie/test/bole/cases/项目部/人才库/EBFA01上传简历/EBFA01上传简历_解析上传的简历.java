package com.beilie.test.bole.cases.项目部.人才库.EBFA01上传简历;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import org.testng.annotations.Test;

//因为测试环境是linux系统，解析pdf简历 右侧不出原始简历，所以未有pdf
//.docx文件、.doc文件、.txt文件，各2份
public class EBFA01上传简历_解析上传的简历 extends BoleBase{
    @Test
    public void 校验右侧展示原始简历 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA01Page eBFA01Page = (EBFA01Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_upResume()//点击二级菜单：上传简历
                .switchToNewIframe1("EBFA01", EBFA01Page.class).sleepForSeconds(1);

        eBFA01Page.judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\ui自动化 测试的简历\\13717767381_高超.txt").sleepForSeconds(3)//.docx文件
                .checkRightResume("职业意向：","汤张蔚","13823238767","简历标签")
                .sleepForSeconds(1)
                .secondTask("清空").sleepForSeconds(1)
                  /*.uploadResume("C:\\Users\\86182\\Desktop\\resume\\4-汤张.docx").sleepForSeconds(3)//.docx文件
                  .checkRightResume("职业意向：","汤张蔚","13823238767","简历标签")
                  .sleepForSeconds(1)
                  .secondTask("清空").sleepForSeconds(1)*/

                  /*.judgeWay()
                  .uploadResume("C:\\Users\\86182\\Desktop\\resume\\吴震之.docx").sleepForSeconds(3)//.docx文件
                  .checkRightResume("吴震之","科力集团/海南微软创新中心有限公司","集团常务副总裁/总经理","房地产开发/建筑/建材/工程")
                  .sleepForSeconds(1)
                  .secondTask("清空").sleepForSeconds(1)*/

                  /*.judgeWay()
                  .uploadResume("C:\\Users\\86182\\Desktop\\resume\\6-51job_钱程.doc").sleepForSeconds(3)//.doc文件
                 // .checkRightResume("钱程","13391182103","湖南格尔智慧科技有限公司","8000-9999元/月")
                  .sleepForSeconds(1)
                  .secondTask("清空").sleepForSeconds(1)*/

                /*.judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\resume\\王敏.doc").sleepForSeconds(3)//.doc文件
                .checkRightResume("王敏","陕西西安","河北工程大学","上海泛太平洋房地产公司")
                .sleepForSeconds(1)
                .secondTask("清空").sleepForSeconds(1)

                .judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\resume\\刘敏.txt").sleepForSeconds(3)//.txt文件
                .getTxt("应聘职位：诚聘资深Java工程师（上海） 应聘公司：江苏高猎企业管理有限公司 投递时间：2017-06-06 更新时间")
                .sleepForSeconds(1)
                .secondTask("清空").sleepForSeconds(1)

                .judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\resume\\张召峰.txt").sleepForSeconds(3)//.txt文件
                .getTxt("个人信息 姓 ___ 名： 张召峰 _性 ___ 别： 男 出生日期： 1985 年 06 月 婚育状况： 已婚 现居住地： 南京 可接受工作地： 南京 联系电话： 18795808140 电子邮件： 2004014091@163.com")
                .sleepForSeconds(1)
                .secondTask("清空").sleepForSeconds(1)*/;

    }
}
