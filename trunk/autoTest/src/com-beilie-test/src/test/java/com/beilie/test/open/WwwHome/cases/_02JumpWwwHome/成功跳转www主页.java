package com.beilie.test.open.WwwHome.cases._02JumpWwwHome;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 成功跳转www主页 extends WwwBase {
    @Test
    public void 成功跳转www主页() throws IllegalAccessException, InstantiationException, InterruptedException{
        WwwHomePage wwwHomePage=jump().sleepForSeconds(3);
    }
}
