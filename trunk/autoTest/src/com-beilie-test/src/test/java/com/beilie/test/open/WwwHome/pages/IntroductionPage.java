package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.Engine;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class IntroductionPage extends UIPage<IntroductionPage> {
     public IntroductionPage checkCurrentUrl(){
         String url= Engine.getCurrentPageUrl();
         String url1="https://www.tanpin.com/#/introduction";
         Boolean b=url.equals(url1);
         Assert.assertTrue(b);
         return this;
     }
}
