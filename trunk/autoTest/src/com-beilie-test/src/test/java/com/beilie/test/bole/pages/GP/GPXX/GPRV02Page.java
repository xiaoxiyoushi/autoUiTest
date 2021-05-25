package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

public class GPRV02Page<T extends GPRV02Page> extends Public<T> {

    public GPRV02Page checkPrepayment(String b) {
        for (int i = 0; i < table_trNumb(); i++) {
            String td_prePayment = this.table_tdValue(i, 3);

            if (td_prePayment.equals(b)) {
                Assert.assertTrue(true);
                break;
            }
            Assert.assertTrue(false);
        }

        return this;
    }

    public String paymentClick() {
        String td_prePayment=null;
        wai:for (int i = 0; i < table_trNumb(); i++) {
            int n = this.findListByClassName("ivu-table-tbody").get(1)
                    .findListByTagName("tr").get(i)
                    .findListByTagName("a").size();
            li:for (int j = 0; j < n; j++) {
                String pay = this.findListByClassName("ivu-table-tbody").get(1)
                        .findListByTagName("tr").get(i)
                        .findListByTagName("a").get(j).getText();
                if (pay.equals("付款")) {
                    td_prePayment = this.table_tdValue(i, 3);

                    this.findListByClassName("ivu-table-tbody").get(1)
                            .findListByTagName("tr").get(i)
                            .findListByTagName("a").get(j).click();
                    break wai;
                }
            }
        }
        return td_prePayment;
    }

    public GPRV02Page checkConfirmPrepayment(String prePayment,String actualReceiveMony) {
        for (int i=0;i<table_trNumb();i++){
            String td_prePayment=this.table_tdValue(i,3);
            if (prePayment.equals(td_prePayment)){
                this.findListByClassName("ivu-table-cell-expand").get(i).click();//点击箭头

                String paymenType=this.findListByClassName("ivu-table-tbody").get(1)
                        .findListByTagName("tr").get(0)
                        .findListByTagName("td").get(2)
                        .findByTagName("span").getText();

                if (paymenType.equals("确认收款")) {
                    String actualReceiveMony_1=this.findListByClassName("ivu-table-tbody").get(1)
                            .findListByTagName("tr").get(0)
                            .findListByTagName("td").get(3)
                            .findByTagName("span").getText();

                    Assert.assertEquals(actualReceiveMony,actualReceiveMony_1);

                }else {
                    Assert.assertFalse(false);
                }

                break;
            }
        }

        return this;
    }
}
