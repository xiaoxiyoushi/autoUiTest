package com.beilie.test.bole.pages.GP;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

public class GPRV01Page<T extends GPRV01Page> extends Public<T> {

    String searchButton = "\n" +
            "        搜索\n" +
            "      ";

    public GPRV01Page paymentPlan_click() {
        this.findByClassName("GPPL04_newlyAddedBtn").click();
        return this;
    }

    //校对 候选人、公司名称、职位名称	、本次收款金额
    public GPRV01Page checkInform(Map<String, Object> hash, String b) throws InterruptedException {

        Object candidateName = hash.get("1");
        Object recommendJob = hash.get("2");
        Object recommendComp = hash.get("3");

        String candidateName_1 = candidateName.toString();
        String recommendJob_1 = recommendJob.toString();
        String recommendComp_1 = recommendComp.toString();

        sendInputPlaceholder("请输入候选人姓名", candidateName_1);
        sendInputPlaceholder("请输入公司名称", recommendComp_1);
        sendInputPlaceholder("请输入职位名称", recommendJob_1);

        clickButton(searchButton);
        this.sleepForSeconds(2);

        String td_Value = table_tdValue(0, 7);//本次收款金额
        Assert.assertEquals(b, td_Value);
        return this;
    }

    public Map<String,Object> confirmPayment_click() throws InterruptedException {
        Map<String, Object> hash= new HashMap<String, Object>();

        for (int i = 0; i < table_trNumb(); i++) {
            String actualPaymentTime = table_tdValue(i, 9);//实际付款时间
            if (actualPaymentTime.equals("--")) {
                String candidateName=this.table_tdValue(i,2);
                String company=this.table_tdValue(i,3);
                String job=this.table_tdValue(i,4);
                String thisTimeMoney=this.table_tdValue(i,7);

                hash.put("1",candidateName);
                hash.put("2",company);
                hash.put("3",job);
                hash.put("4",thisTimeMoney);

                table_td_aHover(1, i, 0, 0).sleepForSeconds(1);//hover操作
                this.findListByClassName("ivu-table-tbody").get(1)
                        .findListByTagName("tr").get(i)
                        .findListByTagName("td").get(0)
                        .findListByTagName("li").get(1).click();//点击 付款
                break;
            }
        }
        return hash;
    }

    //校对 候选人、公司名称、职位名称	、本次收款金额
    public GPRV01Page checkInform_havenPaid(Map<String,Object> hash,String b) throws InterruptedException{
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
            String td_thisTimeMoney=this.table_tdValue(i,7);
            if (thisTimeMoney_1.equals(td_thisTimeMoney)){
                this.findListByClassName("ivu-table-cell-expand").get(i).click();//点击箭头

                String paymenType=this.findListByClassName("ivu-table-tbody").get(1)
                        .findListByTagName("tr").get(0)
                        .findListByTagName("td").get(5)
                        .findByTagName("span").getText();

                if (paymenType.equals("确认收款")) {
                    String actualPayment=this.findListByClassName("ivu-table-tbody").get(1)
                            .findListByTagName("tr").get(0)
                            .findListByTagName("td").get(6)
                            .findByTagName("span").getText();

                    Assert.assertEquals(b,actualPayment);

                }else {
                    Assert.assertFalse(false);
                }

                break;
            }
        }

        return this;
    }

}
