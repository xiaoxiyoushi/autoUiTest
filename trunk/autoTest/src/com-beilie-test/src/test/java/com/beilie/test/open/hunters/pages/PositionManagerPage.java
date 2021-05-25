package com.beilie.test.open.hunters.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import java.util.List;

public class PositionManagerPage extends UIPage<PositionManagerPage> {
    //判断渠道状态
    public  Element JudgingChannelStatus(String channelstatus){
        List<Element> elements = this.findByClassName("tableDiv").findListByTagName("tr");
        Element element1 = elements.parallelStream()
                .filter(element -> {
                    if (element == null) return Boolean.FALSE;
                    try {
                        Element row = element.findListByTagName("td").get(4);
                        String text = row.getText();
                        return StringUtils.equals(text, channelstatus);
                    } catch (Exception e) {
                        return Boolean.FALSE;
                    }
                })
                .findFirst().get();
        return element1;
    }
    /**
     * 打开一个在审核中的职位
     */
    public PositionDetailPage openAuditingPosition() throws Throwable {
        JudgingChannelStatus("审核中").findByClassName("mytyellow").click();
        return (PositionDetailPage) this.switchToNextPage(PositionDetailPage.class);
    }
    /*
    点击刷新
     */
    public PositionManagerPage clickRefresh(){
        this.findByCssSelector("#guanlizhiwei > div.refresh > span").click();
        return this;
    }
    public PositionManagerPage clickQueRen(){
        this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-footer > button").click();
        return this;
    }

    /**
     * 打开一个审核成功的职位
     */
    public PositionDetailPage openAuditingPosition1() throws Throwable {
        JudgingChannelStatus("审核成功").findByClassName("mytyellow").click();
        return (PositionDetailPage) this.switchToNextPage(PositionDetailPage.class);
    }
    /**
     * 打开一个审核失败的职位
     */
    public PositionDetailPage openAuditingPosition2() throws Throwable {
        JudgingChannelStatus("审核失败").findByClassName("mytyellow").click();
        return (PositionDetailPage) this.switchToNextPage(PositionDetailPage.class);
    }
    /*
    发布中的职位，编辑审核失败的职位
     */
    //定位渠道状态：审核失败,点击操作
    public Element element(String channelStatus,int n){
        Element ele=JudgingChannelStatus(channelStatus).findListByTagName("td").get(n);
        return ele;
    }
    public PositionManagerPage clickOperating()throws Throwable {
        //element("审核失败",7).click();
       element("审核失败",7).click();
        return this;
    }
    public CreatePositionPage clickEdit() throws Throwable{
        element("审核失败",7).findByTagName("dl").findListByTagName("dd").get(0).click();
        return (CreatePositionPage)this.switchToNextPage(CreatePositionPage.class);
    }
    /*
    发布中的职位，暂停审核成功的职位
     */
    public PositionManagerPage clickSucessOperating()throws Throwable {
        element("审核成功",7).click();
        return this;
    }
    public PositionManagerPage clickPause() throws Throwable{
        element("审核成功",7).findByTagName("dl").findListByTagName("dd").get(1).click();
        return this;
    }
    public PositionManagerPage checkTiShi(){
        String str=this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-header > span").getText();
        Assert.assertEquals("暂停职位成功啦！",str);
        return this;
    }
     /*
    发布中的职位，关闭审核成功的职位
     */
     public PositionManagerPage clickClose() throws Throwable{
         element("审核成功",7).findByTagName("dl").findListByTagName("dd").get(2).click();
         return this;
     }
     //选择结束原因
    public PositionManagerPage selectReason(){
         this.findByCssSelector("#positionOperating > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div.ivu-radio-group.ivu-radio-group-default.ivu-radio-default.ivu-radio-group-vertical > label:nth-child(1) > span.ivu-radio > span").click();
         this.findByCssSelector("#positionOperating > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div.t3 > button.bt2").click();
         return this;
    }
    //校验提示框
    public PositionManagerPage checkCloseTiShi(){
        String str=this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-header > span").getText();
        Assert.assertEquals("关闭职位成功啦！",str);
        return this;
    }

    /*
    已暂停的职位，恢复 审核成功的职位
     */
    public PositionManagerPage clickOperating1()throws Throwable{
        element("审核成功",7).click();
        return this;
    }
    public PositionManagerPage clickAudit1() throws Throwable{
        element("审核成功",7).findByTagName("dl").findListByTagName("dd").get(0).click();
        return this;
    }
    //校验提示框：职位已恢复招聘！
    public PositionManagerPage assertRestore(){
        String text=this.findByXPath("//*[@id=\"ef-model-confirm\"]/div[1]/span").getText();
        Assert.assertEquals("职位已恢复招聘！",text);
        return this;
    }
    //点击职位
    public PositionManagerPage clickPosition()throws Throwable {
        element("审核成功",0).findByTagName("a").click();
        return this;
    }
}
