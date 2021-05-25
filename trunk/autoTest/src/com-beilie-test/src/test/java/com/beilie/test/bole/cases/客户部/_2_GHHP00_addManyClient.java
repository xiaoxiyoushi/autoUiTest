package com.beilie.test.bole.cases.客户部;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GCCM01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
/*
批量新增客户
 */
public class _2_GHHP00_addManyClient extends BoleBase {
    @Test
    public void 新增客户成功 ()throws IllegalAccessException, InstantiationException, InterruptedException{
        //BdHomePage bdHomePage = login("68658220", "1").sleepForSeconds(3);
        BdHomePage bdHomePage = login("68657224", "1").sleepForSeconds(3);

        /*GCCM01Page gCCM01Page=(GCCM01Page)bdHomePage.clickClientManger("添加客户",3)
                .switchToNewIframe1("GCCM01",GCCM01Page.class).sleepForSeconds(2);*/
        GCCM01Page gCCM01Page=(GCCM01Page)bdHomePage.clickMenus(" 客户管理","添加客户")
                .switchToNewIframe1("GCCM01",GCCM01Page.class).sleepForSeconds(2);

        gCCM01Page.clickBatchImport().sleepForSeconds(1);//点击  批量导入
          for (int i=0;i<10;i++){
              String ClientName= "北京company之"+Public.generateString(8);
              gCCM01Page.inputClient(ClientName,i)
                      .inputLandline("021-546854156",i)
                      .inputContactName("hary",i)
                      .inputPhone("133464866",i)
                      .inputEmail("cfcgsd@ww.hh",i)
                      .inputLink("www.sfss.tt",i).sleepForSeconds(1);
              }

          gCCM01Page.clickAdd().sleepForSeconds(5);
          gCCM01Page.checkTishi();
    }
}
