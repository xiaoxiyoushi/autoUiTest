package com.beilie.test.bole.pages.GP;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class GPPL01Page extends GPPL04Page<GPPL01Page> {


    //校对 候选人、公司名称、职位名称	、本次收款金额
    public GPPL01Page checkInform_2(Map<String,Object> hash, String b) throws InterruptedException{

        Object candidateName=hash.get("1");

        String candidateName_1=candidateName.toString();

        String td_Value=table_tdValue(0,3);
        String td_Value_1=table_tdValue(0,1);

        Assert.assertEquals(b,td_Value);//校对金额
        Assert.assertEquals(candidateName_1,td_Value_1);//校对候选人姓名
        return this;
    }

    public Map<String,Object> clickPayment_1(){
        Map<String, Object> hash= new HashMap<String, Object>();

        for (int i=0;i<table_trNumb();i++){
            String OperationPay=this.findByClassName("ivu-table-tbody")
                    .findListByTagName("tr").get(i)
                    .findListByTagName("td").get(9)
                    .findListByTagName("a").get(1).getText();

            if (OperationPay.equals("付款")){
                String candidateName=this.table_tdValue(i,1);
                String thisTimeMoney=this.table_tdValue(i,3);

                hash.put("1",candidateName);
                hash.put("2",thisTimeMoney);

                this.findByClassName("ivu-table-tbody")
                        .findListByTagName("tr").get(i)
                        .findListByTagName("td").get(9)
                        .findListByTagName("a").get(1).click();
                break;
            }

        }
        return hash;
    }

    //校对 候选人、本次收款金额
    public GPPL04Page checkInform_havenPaid_1(Map<String,Object> hash) throws InterruptedException{
        Object candidateName=hash.get("1");
        Object thisTimeMoney=hash.get("2");

        String candidateName_1=candidateName.toString();
        String thisTimeMoney_1=thisTimeMoney.toString();

        clickButton("搜索");
        this.sleepForSeconds(2);

        for (int i=0;i<table_trNumb();i++){
            String td_thisTimeMoney=this.table_tdValue(i,3);

            String td_candidateName=this.findByClassName("ivu-table-tbody")
                    .findListByTagName("tr").get(i)
                    .findListByTagName("td").get(1).getText();

            if (thisTimeMoney_1.equals(td_thisTimeMoney)&&td_candidateName.equals(candidateName_1)){
                String payStatus=this.findByClassName("ivu-table-tbody")
                        .findListByTagName("tr").get(i)
                        .findListByTagName("td").get(9)
                        .findListByTagName("a").get(1).getText();

           /*     String td_candidateName=this.findByClassName("ivu-table-tbody")
                        .findListByTagName("tr").get(i)
                        .findListByTagName("td").get(1).getText();*/

                /*Assert.assertEquals(td_candidateName,candidateName_1);*/
                Assert.assertEquals("已付款",payStatus);

                break;
            }
        }

        return this;
    }


}
