package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class CommonProblemPage extends UIPage<CommonProblemPage> {
    public CommonProblemPage checkWenZi(){
         String str=this.findByCssSelector("#efCommonProblemsBox > header").getText();
        Assert.assertEquals("常见问题",str);
        return this;
    }
}
