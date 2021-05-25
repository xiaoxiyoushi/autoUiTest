package com.beilie.test.bole.pages.GP.GPCP;

import com.beilie.test.open.PublicClass.Public;

import java.util.HashMap;
import java.util.Map;

//GPCP03_CCL创建收款
public class GPCP03Page extends Public<GPCP03Page> {

    public GPCP03Page clickCandidateNameInput(){
        this.findByXPath("//input[@placeholder=\"请输入候选人姓名\"]").click();
        return this;
    }

    //选择一位候选人
    public GPCP03Page selectCandidate(){
        int numb=this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").size();
        int n=Public.generateNumber1(numb);

        this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(n)
                .findByClassName("ivu-radio-inner").click();//点击人选姓名前的radio

        this.findByXPath("//button[text()=\"确定\"]").click();//点击【确定】按钮
        return this;
    }

    /*
    获取候选人姓名、推荐职位、推荐企业
     */
    public Map<String,Object> getValues(){
        Map<String, Object> hash= new HashMap<String, Object>();
        String candidateName=this.findByXPath("//span[text()=\"候选人姓名：\"]/following-sibling::span")
                .getText();
        String recommendJob=this.findByXPath("//span[text()=\"推荐职位：\"]/following-sibling::span")
                .getText();
        String recommendComp=this.findByXPath("//span[text()=\"推荐企业： \"]/following-sibling::span")
                .getText();

        hash.put("1",candidateName);
        hash.put("2",recommendJob);
        hash.put("3",recommendComp);

        return hash;
    }

    //选择预计付款时间
    public GPCP03Page selectPayTime(String str){
        this.findByXPath("//input[@placeholder=\""+str+"\"]").click();
        this.findByXPath("//p[text()=\"企业付款信息\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-today").click();
        return this;
    }




}
