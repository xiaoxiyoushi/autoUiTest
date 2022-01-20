package com.beilie.test.bole.cases.项目部.管理员;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBLK03Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBLK03升级锁额度管理_新增升级锁 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = manageLogin("13312312323", "1").sleepForSeconds(3);

        EBLK03Page eBLK03Page=(EBLK03Page)bdHomePage
                .clickMenus("\n" +
                        "          人才库管理","升级锁额度管理")//点击菜单栏
                .switchToNewIframe1("EBLK03", EBLK03Page.class).sleepForSeconds(1);

        int lockNumb=Public.generateNumber2(100);
        String lockNumbStr=lockNumb+"";

        int numb=eBLK03Page.clickDepartm()
                            .searchDepartm().sleepForSeconds(1)
                            .clickBtn1(0).sleepForSeconds(2)//点击搜索按钮
                            .getTrSize();

        if(numb>0){
            eBLK03Page.clickBtn2(0)//勾选项目组
                    .clickDeleteBtn().sleepForSeconds(1)//点击删除按钮
                    .clickOK().sleepForSeconds(1)
                    .clickBtn3(0).sleepForSeconds(1)//点击新增按钮
                    .inputLockNumb(lockNumbStr)
                    .inputDepartmNumb("CG").sleepForSeconds(1)
                    .clickBtn1(2).sleepForSeconds(1)
                    .clickAdd()
                    .clickBtn3(2).sleepForSeconds(1)
                    .clickAddOk().sleepForSeconds(2);
        }else {
            eBLK03Page.clickBtn3(0).sleepForSeconds(1)//点击新增按钮
                    .inputLockNumb(lockNumbStr)
                    .inputDepartmNumb("CG").sleepForSeconds(1)
                    .clickBtn1(2).sleepForSeconds(1)
                    .clickAdd()
                    .clickBtn3(2).sleepForSeconds(1)
                    .clickAddOk().sleepForSeconds(2);
        }

        eBLK03Page.checkDepartm()
                  .checkLockNumb(lockNumbStr).sleepForSeconds(1);

    }
}
