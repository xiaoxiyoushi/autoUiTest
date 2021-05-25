package com.beilie.test.open.WwwHome.cases._01Banner;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.BannerDetailPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 校验点击广告跳转到正确的页面 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException{
        WwwHomePage wwwHomePage=jump1().sleepForSeconds(1);
        BannerDetailPage bannerDetailPage=(BannerDetailPage)wwwHomePage
                .clickFirstBanner().sleepForSeconds(1)
                .clickBanner()
                .sleepForSeconds(3)
                .transfer(BannerDetailPage.class);
        bannerDetailPage.checkCurrentUrl().sleepForSeconds(3);
  }
}
