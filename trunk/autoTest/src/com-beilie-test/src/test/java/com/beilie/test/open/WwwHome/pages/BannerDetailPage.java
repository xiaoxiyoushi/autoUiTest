package com.beilie.test.open.WwwHome.pages;

import com.beilie.core.exceptions.BusinessException;
import com.beilie.test.seleniums.core.Engine;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class BannerDetailPage extends UIPage<BannerDetailPage> {
    /**
     * 判定当前页面是已经加载成功的；
     */
    public Boolean isLoad() {
        return Boolean.TRUE;
    }
    /**
     * 断言是否已经完成客户管理页面的加载；
     */
    public BannerDetailPage assertLoaded() {
        if(Boolean.TRUE.equals(this.isLoad())){
            return this;
        }
        throw new BusinessException("页面加载失败。");
    }
    public BannerDetailPage checkCurrentUrl(){
        String url= Engine.getCurrentPageUrl();
        Boolean b=url.contains("tanpin.com");
        Assert.assertTrue(b);
        return this;
    }
}


