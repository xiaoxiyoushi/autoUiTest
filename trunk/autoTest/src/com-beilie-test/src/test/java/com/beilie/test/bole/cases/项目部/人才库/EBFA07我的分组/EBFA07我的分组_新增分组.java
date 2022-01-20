package com.beilie.test.bole.cases.项目部.人才库.EBFA07我的分组;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA07Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA07我的分组_新增分组 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA07Page eBFA07Page = (EBFA07Page) bdHomePage
                .clickMenus("\n" +
                        "          中文简历库", "我的分组")//点击菜单栏
                .switchToNewIframe1("EBFA07", EBFA07Page.class).sleepForSeconds(1);

        String randomStr="分组"+Public.generateString(8);//10位随机字符串
        String pageNumb=eBFA07Page.getPageValue();
        if (pageNumb.equals("共 10 条")){
            eBFA07Page.span_precedingLabel_Click("全选")
                      .clickButton("删除")
                      .confirmBtnDelete_click("确定");
            }

        eBFA07Page.clickButton("新增").sleepForSeconds(3)//点击新增的按钮
                  .sendInputPlaceholder("请输入分组名称",randomStr)//输入分组名称
                  .addConfirmBtn_click("新增分组").sleepForSeconds(3)//新增分组弹窗里 点击【确定】按钮
                  .Span_Value(randomStr);//新增分组后  获取分组值，来验证是否新增成功

    }
}
