package com.beilie.test.open.hunters.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class CandidatePage extends UIPage<CandidatePage> {

    public CandidatePage deleteGroup() throws InterruptedException{
        //点击下拉icon，展示分组
        this.findByClassName("iconCover").findByTagName("img").click();

        List<Element> elements=this.findById("menu").findListById("bg");

        //没有一个分组名称
        if (CollectionUtils.isEmpty(elements)){
            return this;
        }

        String str=elements.get(0).findByClassName("aa").getText();
        elements.get(0).hover();

        elements.get(0).findById("showBtn").findListByTagName("img").get(2).click();

        elements.get(0).findByClassName("bbtn2").click();

        int n=elements.size();
        /*for (int i=0;i<n;i++){
            String groupName=elements.get(i).findByClassName("aa").getText();
            if(StringUtils.equals(str,groupName)){
                Assert.assertTrue(false);
            }
        }*/
        this.sleepForSeconds(1);
        String groupName=elements.get(0).findByClassName("aa").getText();
        if(StringUtils.equals(str,groupName)){
            Assert.assertTrue(false);
        }

        return this;
    }

}
