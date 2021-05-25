package com.beilie.test.open.hunters.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class CandidateResultPage extends UIPage<CandidateResultPage> {
    /**
     * 断言有存在搜索结果，如果结果为空，则断言为失败；
     *
     * @return
     */
    public CandidateResultPage assertHasResults() {
        Assert.assertTrue("没有搜索结果", this.hasClassName("itemBorder"));
        return this;
    }

    public CandidateResultPage expendConditionPanel() {
        this.findByLinkText("展开搜索条件").click();
        return this;
    }

    public CandidateResultPage keywords(String keywords) {
        this.findByCssSelector("input.ivu-input.ivu-input-default").sendKeys(keywords);
        return this;
    }

    public CandidateResultPage assertNoResults() {
        Assert.assertFalse("没有搜索结果", this.hasClassName("itemBorder"));
        return this;
    }

    public CandidateResultPage clickSearch() {
        this.findByCssSelector("button.searchBtn").click();
        return this;
    }

    /**
     * 判定搜索条件是否已经展开；
     *
     * @return
     */
    public CandidateResultPage assertConditionPanelDisplayed() {
        Assert.assertTrue("未发现筛选条件面板已打开。", this.findById("listSearchCriteriaBg").hasLinkText("关闭搜索条件"));
        return this;
    }

    public CandidateResultPage openResume() throws IllegalAccessException, InstantiationException, InterruptedException {
        List<Element> elements = this.findByClassName("tableList").findListByClassName("itemBorder");
        if (CollectionUtils.isEmpty(elements)){
            //说明没有搜索到人选，直接跳过
        }
        elements.get(1).findListByTagName("span").get(0).findByTagName("a").findByTagName("span").click().sleepForSeconds(2);
        return (CandidateResultPage) this.switchToNextPage(CandidateResultPage.class);
    }

    public CandidateResultPage openNoConnectResume() throws IllegalAccessException, InstantiationException, InterruptedException {
        List<Element> elements = this.findByClassName("tableList").findListByClassName("itemBorder");
        if (CollectionUtils.isEmpty(elements)){
            //说明没有搜索到人选，直接跳过
        }
        elements.get(4).findListByTagName("span").get(0).findByTagName("a").findByTagName("span").click().sleepForSeconds(2);
        return (CandidateResultPage) this.switchToNextPage(CandidateResultPage.class);
    }

    /*
    * 校验 搜索的职位名称是否正确*/
    public CandidateResultPage checkConditions(String by,String position) throws IllegalAccessException, InstantiationException, InterruptedException {
        List<Element> elements = this.findByClassName("tableList").findListByClassName("itemBorder");
        if (CollectionUtils.isEmpty(elements)){
            //说明没有搜索到人选，直接跳过
            return this;
        }

        for(int i=0;i<elements.size();i++){
            String str=elements.get(i).findByClassName(by).getText();
            if(str.contains(position)){
                continue;
            }
            else {
                Assert.assertTrue(false);
            }
        }
        return this;
    }

    /*
    点击人选姓名
     */
    public CandidateResultPage clickName(int i){
        List<Element> elements = this.findByClassName("tableList").findListByClassName("itemBorder");
        if (CollectionUtils.isEmpty(elements)){
            //说明没有搜索到人选，直接跳过
            return this;
        }

        /*for(int i=0;i<elements.size();i++){
            elements.get(i).findByTagName("a").click();

        }*/

        elements.get(i).findByTagName("a").click();

        return this;
    }

}
