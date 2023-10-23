package com.beilie.test.bole.pages.ESUP;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class ESUP65Page extends Public<ESUP65Page> {

    //在左侧的 请输入合伙人姓名 输入框，输入姓名
    public ESUP65Page copartner_input(String str, String str1) throws InterruptedException {
        //在左侧的 请输入合伙人姓名 输入框，输入姓名
        inputPlaceholder_send(str, str1);

        //删掉一个
        input_bcakSpace("请输入合伙人姓名", 1);
        this.sleepForSeconds(1);

        sendInputPlaceholder("请输入合伙人姓名", "1");
        this.sleepForSeconds(1);

        //点击下显的合伙人姓名
        divClass("search-list");
        return this;
    }

    //在右侧的 点击新增一级合伙人
    public ESUP65Page addLevelOneCopartner(String str, String str1) throws InterruptedException {

        //点击新增一级合伙人
        clickSpan("新增一级合伙人");
        this.sleepForSeconds(1);

        Element element = this.findListByXPath("//input[@placeholder=\"请输入合伙人姓名\"]").get(2);

        //在请输入合伙人姓名 输入框，输入姓名
        element.sendKeys(str);
        this.sleepForSeconds(1);

        //删掉一个
        element.sendKeys(Keys.BACK_SPACE);
        this.sleepForSeconds(1);

        element.sendKeys(str1);
        this.sleepForSeconds(1);

        //点击下显的合伙人姓名
        divClass("search-item");
        this.sleepForSeconds(1);

        //点击确定按钮
        clickSpan("确定");
        return this;
    }

    /*
    一、二、三级合伙人的  合伙人姓名输入框
    */
    public Element element2() {
        Element element = this.findListByXPath("//input[@placeholder=\"请输入合伙人姓名\"]").get(1);
        return element;
    }

    /*
    一、二、三级合伙人的  合伙人姓名输入框，输入姓名，并且选中
    */
    public ESUP65Page copartnerInput_selected(String name, String str) throws InterruptedException {
        //在请输入合伙人姓名 输入框，输入姓名
        element2().sendKeys(name);
        this.sleepForSeconds(1);

        //删掉一个
        element2().sendKeys(Keys.BACK_SPACE);
        this.sleepForSeconds(1);

        element2().sendKeys(str);
        this.sleepForSeconds(1);

        //点击下显的合伙人姓名
        divClass("search-item");
        this.sleepForSeconds(1);
        return this;
    }

    /*
   获取table列的数据
   */
    public String td() {

        String td_Value = this.findByClassName("ivu-table-fixed-body")
                .findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(0)
                .findListByTagName("td").get(0)
                .findByTagName("span")
                .getText();
        return td_Value;
    }

    /*
   获取table备注列的数据
   */
    public String td_remark() {

        String td_Value = this.findByClassName("ivu-table-fixed-body")
                .findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(0)
                .findListByTagName("td").get(4)
                .findListByClassName("text-truncate").get(1)
                //.getText();
                .getAttribute("title");
        return td_Value;
    }

    //一级合伙人tab，删除一级合伙人
    public ESUP65Page deleteLevelOneCopartner() throws InterruptedException {

        try {
            //点击删除按钮
            clickSpan("删除");
            this.sleepForSeconds(1);

            //点击确定按钮
            clickSpan("确定");
        } catch (Exception e) {
        }

        return this;
    }

    //核对新增成功
    public ESUP65Page assertAdd() throws InterruptedException {
        String str = divClass_value("ef-page-header__input success-color");
        Assert.assertEquals("新增一级合伙人成功", str);
        return this;
    }

    //一级合伙人tab，搜索一级合伙人
    public ESUP65Page searchLevelOneCopartner(String str) throws InterruptedException {

        copartnerInput_selected("朱颜3012", "2");

        String copartnerName = td();

        Assert.assertEquals(str, copartnerName);

        return this;
    }

    //点击二级合伙人tab
    public ESUP65Page levelTwoTab_click(String str) {
        a_click(str);
        return this;
    }

    //二级合伙人tab
    public ESUP65Page levelTwoCopartnerTab_click() throws InterruptedException {

        levelTwoTab_click("二级合伙人");
        this.sleepForSeconds(2);

        return this;
    }

    //合伙人tab，验证搜索合伙人
    public ESUP65Page assertLevelTwoCopartner(String str) throws InterruptedException {

        String copartnerName = td();

        Assert.assertEquals(str, copartnerName);

        return this;
    }

    //三级合伙人tab，搜索三级合伙人
    public ESUP65Page levelThreeCopartnerTab_click() throws InterruptedException {

        levelTwoTab_click("三级合伙人");
        this.sleepForSeconds(2);

        return this;
    }

    //滚动左侧的滚动条
    public ESUP65Page leftScroll() throws InterruptedException {
        String setscroll = "document.querySelector('.overflow-auto').scrollTop=10000";
        execute_script2(setscroll);
        return this;
    }

    //点击左侧合伙人
    public ESUP65Page leftCopartner_click(String str) throws InterruptedException {
        clickSpan(str);
        return this;
    }

    //在一、二、三级合伙人，点击添加备注的icon
    public ESUP65Page remarkIocn_click() throws InterruptedException {
        divClass_iClick("text-truncate d-flex align-items-center");
        return this;
    }

    //在一、二、三级合伙人，在备注的输入框，输入数据
    public ESUP65Page remark_send(String str) throws InterruptedException {
        clearTextarea("请输入备注");
        textarea_sendkeys("请输入备注", str);
        //this.findByXPath("//div[@class=\"ivu-modal-footer\"]/button[1]").click();

        this.findListByClassName("ivu-modal-footer").get(0)
                .findListByTagName("button").get(1).click();

        return this;
    }

    //在一、二、三级合伙人，验证备注
    public ESUP65Page assertRemark(String str) throws InterruptedException {
        String ramark = td_remark();
        Assert.assertEquals(str, ramark);
        return this;
    }
}
