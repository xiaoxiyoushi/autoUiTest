package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

public class EBFA05Page extends Public<EBFA05Page> {
    //等待人选数据加载出来
    public EBFA05Page waitCandidateSearchResults(){
        this.waitFor(10,"//div[@class=\"EBFA05_rightResult_content\"]//div[@class=\"small_card mb20\"]");
        return this;
    }

    /*
    点击头像
     */
    public EBFA05Page clickAvatar(int n){
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").click();
        return this;
    }

    /*
    hover头像
     */
    public EBFA05Page hoverAvatar(int n){
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").hover();
        return this;
    }

    /*
    点击收藏按钮
     */
    public EBFA05Page clickCollection(){
        this.findByClassName("pt72").findByClassName("small_card")
        .findByClassName("addToTalents").findByTagName("img").click();
        return this;
    }

    /*
    在“确认取消收藏?”弹框里，点击【确定】按钮
     */
    public EBFA05Page clickConfirmBtn(){
        this.findByXPath("//div[@id=\"inquiryModal_modal\"]//span[text()=\"确定\"]").click();
        return this;
    }

    /*
    人选搜索结果里 人选的个数,是0
     */
    public EBFA05Page checkCandidateNumb(){
        int candidateNumb=this.findByClassName("EBFA05_rightResult_content")
                .findListByClassName("small_card").size();

       String str=candidateNumb+"";
        Assert.assertEquals("0",str);

        return this;
    }

    //校对简历卡片的 姓名、电话、邮箱、性别、年龄、居住地
    public EBFA05Page checkResumeCard(String actualPhone){
        String phone=this.findById("big_card").findByClassName("ml20").findByTagName("strong").getText();//获取卡片上的手机号
        Assert.assertEquals(phone,actualPhone);

        return this;
    }

    /*
    在“添加备注”弹框里，点击【确定】按钮
     */
    public EBFA05Page clickConfirmBtn_addRemark(){
      /*  this.findById("addRemark_modal")
                .findByClassName("click_btn_bg")
                .click();*/

        this.findByXPath("//div[@id=\"addRemark_modal\"]//span[text()=\"确定\"]").click();

        return this;
    }

    /*
   在“我的备注”弹框里，点击x按钮
    */
    public EBFA05Page remark_close(){
        this.findById("moreRemark_modal")
                .findByClassName("ivu-modal-close")
                .click();
        return this;
    }

    /*
        人选搜索结果里 人选的个数,是0
         */
    public EBFA05Page checkRemark(String remark,String remark_1){
        int candidateNumb=this.findByClassName("EBFA05_rightResult_content")
                .findListByClassName("small_card").size();

        String str=candidateNumb+"";
        Assert.assertEquals("0",str);

        return this;
    }

    public EBFA05Page clearButton_click(){
        this.findByXPath("//a[text()=\"" + "清空" + "\"]").click();
        return this;
    }

    //按钮是清空文案+可点击
    public EBFA05Page clearButton(){
        Element element=this.findByXPath("//a[text()=\"" + "清空" + "\"]");//按钮是清空文案
        element.isEnabled();//可点击
        return this;
    }

    //下拉框的文案是 我的分组（不限）
    public EBFA05Page myGroup_value(){
        String value=this.findByXPath("//div[@class=\"w220 ivu-select ivu-select-single ivu-select-default\"]//span").getText();
        Assert.assertEquals("我的分组（不限）",value);
        return this;
    }

    //搜索我的分组
    public String searchMyGroup() throws InterruptedException{
        //点击 我的分组（不限）
        this.findByXPath("//div[@class=\"w220 ivu-select ivu-select-single ivu-select-default\"]//span").click();
        this.sleepForSeconds(1);

        //分组的集合
        List<Element> elements=this.findByClassName("ivu-select-visible").findListByClassName("w220");
        int labelNumb=elements.size();//获取分组个数
        int randomNum =generateNumber1(labelNumb);

        String group=elements.get(randomNum).getText();

        //点击分组
        elements.get(randomNum).click();

        //点击搜索
        clickSearch();
        return group;
    }

    //验证搜索的分组人选
    public EBFA05Page AssertMyGroup(String group) throws InterruptedException{

        try {
            waitCandidateSearchResults();

            //点击分组按钮
            this.findByXPath("//div[@class=\"body_down\"]//span[text()=\"分组\"]").click();
            this.sleepForSeconds(1);

            List<Element> elements=this.findListByXPath("//div[@class=\"joinGroup_content relative font14 color80 weight400\"]//label");
            for (int i=0;i<elements.size();i++){
                //获取分组值
                String labelValue=elements.get(i).getText();
                if (labelValue.equals(group)){//校验分组
                    break;
                }
                if (i==(elements.size()-1)){
                    Assert.assertTrue(false);
                }
            }
            }catch (Exception e){}

        return this;
    }

    //标签
    public String labelButton() throws InterruptedException{
        clickSpan("标签");//点击标签icon
        this.sleepForSeconds(1);

        //获取第一个标签的值
        String label=this.findByXPath("//button[@class=\"" + "tagBtn_size singleLine font12 weight400 ml10 mb10 ivu-btn ivu-btn-default notAtiveTag" + "\"]//span").getText();
        //选中第一个标签
        button_classClick("tagBtn_size singleLine font12 weight400 ml10 mb10 ivu-btn ivu-btn-default notAtiveTag");
        button_classClick("ml20 ivu-btn ivu-btn-primary");//点击确定
        return label;
    }

    //验证标签搜索结果
    public EBFA05Page assertLabel(String label) throws InterruptedException{
        hoverAvatar(0);//hover头像
        this.sleepForSeconds(1);

        List<Element> elements=this.findListByXPath("//span[@class=\"singleLine inblock talentTagsBtn font14 weight400 mr20 mb10\"]");

        int labelNumb=elements.size();

        for (int i=0;i<3;i++){
            String labelValue=elements.get(i).getText();
            if (labelValue.equals(label)){//校验卡片里的标签
                break;
            }
            if (i==labelNumb-1){
                Assert.assertFalse(true);
            }
        }
        return this;
    }

    //添加标签
    public String addTag() throws InterruptedException{
        //点击添加标签
        this.findByXPath("//div[@class=\"body_down\"]//span").click();
        this.sleepForSeconds(1);

        String tagValue=this.findByXPath("//div[@id=\"efAddTags_content\"]//button[@class=\"tagBtn_size singleLine font12 weight400 ml10 mb10 ivu-btn ivu-btn-default notAtiveTag\"]").getText();
        this.findByXPath("//div[@id=\"efAddTags_content\"]//button[@class=\"tagBtn_size singleLine font12 weight400 ml10 mb10 ivu-btn ivu-btn-default notAtiveTag\"]").click();

        this.findByXPath("//div[@id=\"efAddTags_footer\"]//button[@class=\"ml20 ivu-btn ivu-btn-primary\"]").click();

        return tagValue;
    }

    //点击搜索
    public EBFA05Page clickSearch(){
        clickSpan("搜索");
        return this;
    }

    //鼠标hover姓名，显示人选基本信息card
    public EBFA05Page hoverNameAndAssert() throws InterruptedException{
        //获取姓名
        String name=this.findByXPath("//div[@class=\"ml10 font14 weight400 flex singleLine\"]/div[1]/div[1]/div[1]").getText();

        //hover姓名
        this.findByXPath("//div[@class=\"ml10 font14 weight400 flex singleLine\"]/div[1]").hover();
        this.sleepForSeconds(1);

        //获取卡片的姓名
        String cardName=this.findListById("big_card").get(1)
                .findByTagName("span")
                .getText();
        Assert.assertEquals(name,cardName);
        return this;
    }

    //鼠标点击姓名
    public EBFA05Page clickName() throws InterruptedException{
        //点击姓名
        this.findByXPath("//div[@class=\"ml10 font14 weight400 flex singleLine\"]/div[1]").click();
        return this;
    }

    //点击加入项目
    public EBFA05Page clickJoinProject() throws InterruptedException{
        this.findByXPath("//div[@class=\"body_down\"]//a[text()=\"加入项目\"]").click();
        return this;
    }

    //在加入项目框，点击加入项目
    public EBFA05Page clickJoinProjectBtn() throws InterruptedException{
        //获取第二行的客户名称、项目名称
        String client=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"][2]//span").getText();
        String project=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"][2]//div[@class=\"font14 pr20\"]//span").getText();

        //在输入框输入客户名称、项目名称
        this.findByXPath("//input[@placeholder=\"请输入客户名称\"]").sendKeys(client);
        this.findByXPath("//input[@placeholder=\"请输入项目名称\"]").sendKeys(project);

        //点击搜索
        this.findByXPath("//div[@class=\"ef-search-bar-btns\"]//span").click();
        this.sleepForSeconds(2);

        //点击加入项目
        this.findByXPath("//div[@class=\"ivu-table ivu-table-default ivu-table-border ivu-table-stripe\"]//div[@class=\"ivu-table-fixed-right\"]//span[text()=\"加入项目\"]").click();
        return this;
    }

    //在请选择人选简历页面，点击确定
    public EBFA05Page clickConfirm() throws InterruptedException{
        try {
            //被淘汰，是否继续添加,点击确定
            this.findByXPath("//div[@class=\"ef-modal v-transfer-dom\"]//span[text()=\"确定\"]").click();
        }catch (Exception e){}
        this.sleepForSeconds(2);

        //等待确定按钮加载出来
        this.waitFor(30,"//div[@class=\"addProjectSelectResume v-transfer-dom\"][7]//span[text()=\"确定\"]");
        //在请选择人选简历页面，点击确定
        this.findByXPath("//div[@class=\"addProjectSelectResume v-transfer-dom\"][7]//span[text()=\"确定\"]").click();
        return this;
    }

    //在人选加入项目的时候，姓名、联系电话，校验必填项
    public EBFA05Page checkNamePhone() throws InterruptedException{
        //清除姓名
        for (int i = 0; i < 12; i++) {
            this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请填写姓名\"]").sendKeys(Keys.BACK_SPACE);
        }

        //清除联系电话
        for (int i = 0; i < 14; i++) {
            this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请输入联系电话\"]").sendKeys(Keys.BACK_SPACE);
        }

        //点击确定
        this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//span[text()=\"确定\"]").click();
        this.sleepForSeconds(2);

        //获取姓名、联系电话的必填提示
        String nameTip=this.findByXPath("//div[@class=\"ivu-form-item-error-tip\"]").getText();
        String phoneTip=this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请输入联系电话\"]/parent::div/following-sibling::div").getText();

        //校对
        Assert.assertEquals("姓名不能为空",nameTip);
        Assert.assertEquals("联系电话不能为空",phoneTip);
        return this;
    }

    //获取加入项目框的客户名称、项目名称，搜索并且校对
    public EBFA05Page checkClientProject() throws InterruptedException{
        //获取第二行的客户名称、项目名称
        String client=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"][2]//span").getText();
        String project=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"][2]//div[@class=\"font14 pr20\"]//span").getText();

        //在输入框输入客户名称、项目名称
        this.findByXPath("//input[@placeholder=\"请输入客户名称\"]").sendKeys(client);
        this.findByXPath("//input[@placeholder=\"请输入项目名称\"]").sendKeys(project);

        //点击搜索
        this.findByXPath("//div[@class=\"ef-search-bar-btns\"]//span").click();
        this.sleepForSeconds(2);

        //校对
        String searchProject=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"]//div[@class=\"font14 pr20\"]//span").getText();
        Assert.assertEquals(project,searchProject);
        return this;
    }

}
