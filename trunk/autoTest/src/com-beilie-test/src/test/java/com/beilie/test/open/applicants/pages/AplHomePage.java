package com.beilie.test.open.applicants.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import java.util.List;

/*
求职者首页
 */
public class AplHomePage extends UIPage<AplHomePage>{
     public AplHomePage clickHeader(String text) throws IllegalAccessException, InstantiationException{
         /*this.waitFor(10, d -> {
             //this.findByClassName("headerName fl").findByLinkText(text).click();
             //this.findByCssSelector("#bg > div.header > div.headerCenter > div > div.headerName.fl").findByLinkText(text).click();
             this.findByClassName("headerCenter").findByLinkText(text).click();
             return Boolean.TRUE;
         });*/
         return this;
     }
     public AplHomePage assertLoginSuccess(){
         Assert.assertTrue("登录失败，没有找到页面上有推荐职位字样",this.hasLinkText("首页"));
         return this;
     }
     /*public AplHomePage clickMenuItem(String headerName, String menuName,String str,int i) throws InterruptedException {
         String className = null;
         if (StringUtils.equals(headerName, str))
             className = "positionLi";
         Element linkText = this.findListByClassName(className).get(i);
         linkText.hover();
         this.sleepForSeconds(2);
         linkText.findListByTagName("a").parallelStream().filter(a -> StringUtils.equals(a.getText(), menuName))
                 .findFirst().get().click();
         return this;
     }*/
     public AplHomePage clickMenuItem(String menuName,int i) throws InterruptedException {
         String className = null;
         //String headerName=this.findListByClassName("decorationNone").get(i).getText();
         //if (StringUtils.equals(headerName, str))
             className = "positionLi";
         Element linkText = this.findListByClassName(className).get(i);
         linkText.hover();
         this.sleepForSeconds(1);
         linkText.findListByTagName("a").parallelStream().filter(a -> StringUtils.equals(a.getText(), menuName))
                 .findFirst().get().click();
         return this;
     }

     //点击 我的简历
    public AplHomePage clickMyResume(){
         this.findByCssSelector("#bg > div.header > div.headerTop > div > div > ul > li.fr.fg > a").click();
         return this;
    }

    /*
    首页 点击“推荐猎头”
     */
    public AplHomePage clickRecommendHunter(){
        this.findByCssSelector("#wrap > div.wrapContent > div.mainBody > div.bodyMiddle > div > ul > li.beforeclass").click();
        return this;
    }
    //校验运营行业
    public AplHomePage checkOperatingIndustry(){
        String str=this.findByCssSelector("#recommendHunterbg > div:nth-child(1) > div > div > div.hunterInfo > p:nth-child(2) > span.wellipsis.w140").getText();
        Assert.assertEquals("IT/互联网/游戏",str);
        return this;
    }
    //hover猎头头像
    public AplHomePage hoverHunter(){
        this.findByCssSelector("#recommendHunterbg > div:nth-child(1) > div > div > div.hunterInfo > p:nth-child(1) > span.infoName").hover();
        return this;
    }
    //点击和他聊聊
    public AplHomePage clickChat(){
        this.findByCssSelector("#showBtn > button").click();
        return this;
    }
    //发送聊天信息
    public AplHomePage sendMessage(String message){
        this.findByCssSelector("#dope").sendKeys(message);
        this.findByCssSelector("#EFtalkbox > div.EFChatTalkbox_header_footer > div:nth-child(2) > button").click();
        return this;
    }

    /*
    猎头名片
     */
    //点击编辑、头像、姓名
    public AplHomePage clickTouXiang(int i){
        List<Element> elements=this.findListByXPath("//*[@id=\"wrap\"]/div[2]/div[2]/div[2]/div[1]/div[1]/child::div");
          switch (i){
              case 0:
                 elements.get(0).click();
                 break;
              case 1:
                 elements.get(1).findByTagName("img").click();
                 break;
              case 2:
                  elements.get(1).findByTagName("p").click();
                  break;
              default:
                  System.out.println("没有该链接");
          }
        return this;
    }

    //点击icon 刷新简历、预览简历、我的委托
    public Element element(int i){
        Element element=this.findListByXPath("//*[@id=\"wrap\"]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]/child::div").get(i);
        return element;
    }
    public AplHomePage clickIcons(int i){
        element(i).findByClassName("pd10").click();
        return this;
    }
    //校验刷新简历
    public AplHomePage CheckRefresh(){
        String str=this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-header > span").getText();
        Assert.assertEquals("刷新简历成功。",str);
        return this;
    }

    //隐私设置privacy setting
    public AplHomePage clickPrivacySetting(){
        String str=this.findByCssSelector("#selectHeight40 > div > div.ivu-select-selection > div > span").getText();
        this.findByCssSelector("#selectHeight40 > div > div.ivu-select-selection > div > span").click();
        List<Element> elements=this.findByCssSelector("#selectHeight40 > div > div.ivu-select-dropdown > ul.ivu-select-dropdown-list")
                                   .findListByClassName("ivu-select-item");
        /*for(int i=0;i<4;i++){
            String str1=elements.get(i).getText();
            if (str.equals(str1)){
                continue;
            }
              if(i==3)
               {
                elements.get(0).click();
               }else {
                  elements.get(i + 1).click();
               }
        }*/
        String str1=elements.get(0).getText();
        if (str.equals(str1)){
            elements.get(1).click();
        }else {
            elements.get(0).click();
        }

        return this;
    }
    //未填写数据  点击搜索
    public AplHomePage clickSearch(){
        this.findByCssSelector("#mainSearch > div > div > button").click();
        return this;
    }

    /*
    职聊
     */
    //点击职聊
    public AplHomePage clickChat1(){
        this.findByCssSelector("#bg > div.header > div.headerTop > div > div > ul > li:nth-child(2) > a").click();
        return this;
    }
    //点击第二个猎头
    public AplHomePage clickSecondHunter(){
        this.findById("chatInformation")
            .findListByClassName("chatInformation_body").get(1)
            .findByClassName("chatInformation_flex")
            .click();
        return this;
    }
    //点击委托简历
    public AplHomePage clickCommission() throws InterruptedException{
        this.findByClassName("EFChatTalkbox_header_footer_top_bottom").click();//点击委托简历
        this.sleepForSeconds(1);
        this.findByClassName("weituoOk").click();//点击确定

        List<Element> elements=this.findListByClassName("vdialog");
        int n=elements.size();

        this.sleepForSeconds(1);

        /*String str=elements.get(n-1).findByClassName("mydeg").getText();
        Assert.assertEquals("查看委托简历",str);*/

        String str1=this.findListByClassName("sysmsg-tips").get(n-1).getText();
        Assert.assertEquals("您的简历已成功发送",str1);
        return this;
    }
    //查看委托简历
    public AplHomePage reviewCommission() throws InterruptedException{
        List<Element> elements=this.findListByClassName("vdialog");
        int n=elements.size();

        this.findListByClassName("mydeg").get(n-1).click();
        this.sleepForSeconds(1);

        String str=this.findByClassName("borderNba").findByTagName("span").getText();
        Assert.assertTrue(str.contains("最后更新简历"));
        return this;
    }
    //取消委托简历
    public AplHomePage cancelCommission() throws InterruptedException{
        this.findByClassName("EFChatTalkbox_header_footer_top_bottom").click();//点击委托简历
        this.sleepForSeconds(1);
        this.findByClassName("closeweituo").click();//点击取消

        List<Element> elements=this.findListByClassName("sysmsg-tips");
        int n=elements.size();

        String str=elements.get(n-1).getText();
        Assert.assertEquals("您的简历已取消",str);

        return this;
    }
    //查看我的简历
    public AplHomePage reviewMyResume() throws InterruptedException{
        this.findByClassName("EFChatTalkbox_header_footer_top_bottom").click();
        List<Element> elements=this.findListByClassName("vdialog");
        int n=elements.size();

        elements.get(n-1).findByClassName("word").findByTagName("a").click();
        this.sleepForSeconds(1);

        String str=this.findByClassName("borderNba").findByTagName("span").getText();
        Assert.assertTrue(str.contains("最后更新简历"));
        return this;
    }
    public AplHomePage clickHunter() throws InterruptedException{
        this.findByClassName("bg2").click();
        this.sleepForSeconds(1);
        this.findListByClassName("showStyle").get(1).click();
        this.sleepForSeconds(1);

        int n=this.findListByClassName("listClass").size();

       for (int i=0;i<n;i++){
            Element element=this.findListByClassName("listClass").get(i);
            String str=element.getText();
            if (str.equals("CCLshixiu")){
                element.click();
                break;
            }

            /*element.findListByTagName("div").parallelStream().filter(div -> StringUtils.equals(div.getText(), "CCLshixiu"))
                    .findFirst().get().click();*/

       }

        //this.findByClassName("listClass").click();
        this.sleepForSeconds(1);
        this.findByClassName("EFChatTalkbox_header_name").click();
        return this;
    }
    //点击头像
    public AplHomePage clickAvatar() throws InterruptedException{
        this.findByClassName("link-img").click();
        return this;
    }

    //隐私设置
    public AplHomePage clickPrivacy() throws InterruptedException{

        this.findById("ulli").hover();
        this.sleepForSeconds(1);

        this.findById("ulli").findListByTagName("a").get(1).click();
        this.sleepForSeconds(1);

        return this;
    }



}



