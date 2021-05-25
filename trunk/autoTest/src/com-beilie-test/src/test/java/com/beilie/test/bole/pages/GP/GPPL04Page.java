package com.beilie.test.bole.pages.GP;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

//GPPL04收款计划，CCL角色的页面
public class GPPL04Page<T extends GPPL04Page> extends Public<T> {
    /*public GPPL04Page clickPay(String collectionType){
        this.findByXPath("//button[text()=\""+collectionType+"\"]").click();
        return this;
    }*/

    String searchButton="\n" +
            "        搜索\n" +
            "      ";

    public GPPL04Page clickCandidateNameInput(){
        this.findByXPath("//input[@placeholder=\"请输入候选人姓名\"]").click();
        return this;
    }

    //校对 候选人、公司名称、职位名称	、本次收款金额
    public GPPL04Page checkInform(Map<String,Object> hash, String b) throws InterruptedException{

        Object candidateName=hash.get("1");
        Object recommendJob=hash.get("2");
        Object recommendComp=hash.get("3");

        String candidateName_1=candidateName.toString();
        String recommendJob_1=recommendJob.toString();
        String recommendComp_1=recommendComp.toString();

        sendInputPlaceholder("请输入候选人姓名",candidateName_1);
        sendInputPlaceholder("请输入公司名称",recommendComp_1);
        sendInputPlaceholder("请输入职位名称",recommendJob_1);

        clickButton(searchButton);
        this.sleepForSeconds(2);

        String td_Value=table_tdValue(0,5);
        Assert.assertEquals(b,td_Value);
        return this;
    }

    public Map<String,Object> clickPayment(){
        Map<String, Object> hash= new HashMap<String, Object>();

        for (int i=0;i<table_trNumb();i++){
            String actualPayTime=this.findByClassName("ivu-table-tbody")
                    .findListByTagName("tr").get(i)
                    .findListByTagName("td").get(8)
                    .findByTagName("span")
                    .getText();

            if (actualPayTime.equals("--")){
                String candidateName=this.table_tdValue(i,1);
                String company=this.table_tdValue(i,2);
                String job=this.table_tdValue(i,3);
                String thisTimeMoney=this.table_tdValue(i,5);

                hash.put("1",candidateName);
                hash.put("2",company);
                hash.put("3",job);
                hash.put("4",thisTimeMoney);

                this.table_td_aClick(1,i,0,1);
                break;
            }

        }
        return hash;
    }

    //校对 候选人、公司名称、职位名称	、本次收款金额
    public GPPL04Page checkInform_havenPaid(Map<String,Object> hash) throws InterruptedException{
        Object candidateName=hash.get("1");
        Object company=hash.get("2");
        Object job=hash.get("3");
        Object thisTimeMoney=hash.get("4");

        String candidateName_1=candidateName.toString();
        String company_1=company.toString();
        String job_1=job.toString();
        String thisTimeMoney_1=thisTimeMoney.toString();

        sendInputPlaceholder("请输入候选人姓名",candidateName_1);
        sendInputPlaceholder("请输入公司名称",company_1);
        sendInputPlaceholder("请输入职位名称",job_1);

        clickButton(searchButton);
        this.sleepForSeconds(2);

        for (int i=0;i<table_trNumb();i++){
            String td_thisTimeMoney=this.table_tdValue(i,5);
            if (thisTimeMoney_1.equals(td_thisTimeMoney)){
                String payStatus=this.table_td_spanValue(1,i,0,1);
                Assert.assertEquals("已付款",payStatus);
                break;
            }
        }

        return this;
    }

    //校对 候选人、公司名称、职位名称	、本次收款金额
    public GPPL04Page checkInform_1(Map<String,Object> hash, String b) throws InterruptedException{

        Object candidateName=hash.get("1");
        Object recommendJob=hash.get("2");

        String candidateName_1=candidateName.toString();
        String recommendJob_1=recommendJob.toString();

        sendInputPlaceholder("请输入候选人姓名",candidateName_1);
        sendInputPlaceholder("请输入职位名称",recommendJob_1);

        clickButton(searchButton);
        this.sleepForSeconds(2);

        String td_Value=table_tdValue(0,5);
        Assert.assertEquals(b,td_Value);
        return this;
    }


}
