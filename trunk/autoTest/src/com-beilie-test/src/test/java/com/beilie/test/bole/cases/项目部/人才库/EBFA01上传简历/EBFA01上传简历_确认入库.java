package com.beilie.test.bole.cases.项目部.人才库.EBFA01上传简历;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

/*
新增简历，校验弹窗提示
 */
public class EBFA01上传简历_确认入库  extends BoleBase {
    @Test
    public void 校验右侧展示原始简历 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA01Page eBFA01Page = (EBFA01Page) bdHomePage
                .clickMenus(" 中文简历库", "上传简历")//点击菜单栏
                .switchToNewIframe1("EBFA01", EBFA01Page.class).sleepForSeconds(1);

        String randomStr= Public.generateString(8);//8位随机字符串
        int randomNum=Public.generateNumber1(20);//0-19位随机数

        eBFA01Page.judgeWay()
                  .uploadResume("C:\\Users\\86182\\Desktop\\resume\\王先生.docx").sleepForSeconds(3)//.docx文件
                  .sleepForSeconds(3)
                  .sendInputPlaceholder("请输入姓名","王先生"+randomStr)
                  .sendInputPlaceholder("请输入联系电话","1337027"+randomStr)
                  .sendInputPlaceholder("请输入电子邮箱","28068013@qq.com"+randomStr)
                  .clickSpan("确定").sleepForSeconds(1)
                  .checkTip().sleepForSeconds(2);

    }
}
