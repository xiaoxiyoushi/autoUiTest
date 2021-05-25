package com.beilie.test.bole.cases.扒皮简历;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA02Page;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class 职位点关闭 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = projectLogin().sleepForSeconds(3);
        bdHomePage.clickSpan("简历池")
                .clickSpan("职位训练")

                ;
    }
}
