package com.beilie.test.open.hunters.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import java.util.List;

public class PositionDetailPage extends UIPage<PositionDetailPage>{
    public PositionDetailPage assertHasButton(String ButtonName) {
        Element tt = this.findById("positionDetail").findByClassName("header").findByClassName("htop").findListByTagName("div").get(0);
        List<Element> list = tt.findListByTagName("em");
        boolean anyMatch = list.stream().anyMatch(element -> {
            try {
                String text = element.getText();
                return StringUtils.equals(text, ButtonName);
            } catch (Exception e) {
                return Boolean.FALSE;
            }
        });
        if(Boolean.FALSE.equals(anyMatch)){
            Assert.fail("没有找到按钮"+ButtonName);
        }
        return this;
    }
    //校验有：审核失败原因
    public PositionDetailPage assertFaileReason(){
        String failReason=this.findByClassName("hfailed").getText();
        Assert.assertEquals("审核失败原因",failReason);
        return this;
    }
    //校验 渠道状态：审核失败
    public PositionDetailPage assertChannelStatus(){
        String channelStatus=this.findByXPath("//*[@id=\"positionDetail\"]/div[2]/div[1]/div[2]/div[2]/span[2]").getText();
        Assert.assertEquals("审核失败",channelStatus);
        return this;
    }

    //获取对外显示名称
    public PositionDetailPage displayname(){
        String str=this.findByCssSelector("#bg > div > div:nth-child(1) > div.companyInfo > div:nth-child(1) > div:nth-child(2) > span").getText();
        Assert.assertTrue(str.contains("****"));
        return this;
    }
    //点击预览
    public PositionDetailPage clickPreview(){
        this.findByCssSelector("#positionDetail > div.header > div.htop > div.fe.febt > div:nth-child(2) > span:nth-child(2) > em").click();
        return this;
    }
    //职位名称
    public PositionDetailPage checkPositionName(){
        String positionName=this.findByClassName("htitle").getText();

        char[] ch = positionName.toCharArray();
        for(int i = 0 ; i < ch.length ; i++){
            char c=ch[i];
            String str=c+"";
            Assert.assertTrue(str.equals("*"));
        }
        return this;
    }
    /**
     * //调用String类的方法toCharArray()
     * 		char[] ch = str.toCharArray();
     * 		for(int i = 0 ; i < ch.length ; i++){
     * 			System.out.println(ch[i]);
     *                }
     */

}
