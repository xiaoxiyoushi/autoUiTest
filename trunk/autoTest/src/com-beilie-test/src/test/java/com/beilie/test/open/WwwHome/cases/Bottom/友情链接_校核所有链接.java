package com.beilie.test.open.WwwHome.cases.Bottom;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.AllLinksPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import com.beilie.test.seleniums.core.Engine;
import org.junit.Test;

public class 友情链接_校核所有链接 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException {
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);

        for (int i=0;i<8;i++){
            AllLinksPage allLinksPage=(AllLinksPage)wwwHomePage.clickLink(i)
                    .switchToNextPage(AllLinksPage.class).sleepForSeconds(3);

            switch (i){
                case 0:
                    allLinksPage.checkEducation().sleepForSeconds(1);
                    Engine.close();
                    wwwHomePage.activeSelf().sleepForSeconds(1);
                    break;
                case 1:
                    allLinksPage.checkInstitution().sleepForSeconds(1);
                    Engine.close();
                    wwwHomePage.activeSelf().sleepForSeconds(1);
                    break;
                case 2:
                    allLinksPage.checkCorporateCredit().sleepForSeconds(3);
                    Engine.close();
                    wwwHomePage.activeSelf().sleepForSeconds(1);
                    break;
                case 3:
                    allLinksPage.checkBank().sleepForSeconds(2);
                    Engine.close();
                    wwwHomePage.activeSelf().sleepForSeconds(1);
                    break;
                case 4:
                    allLinksPage.checkPostgraduate().sleepForSeconds(1);
                    Engine.close();
                    wwwHomePage.activeSelf().sleepForSeconds(1);
                    break;
                case 5:
                    allLinksPage.checkNationalCivil().sleepForSeconds(1);
                    Engine.close();
                    wwwHomePage.activeSelf().sleepForSeconds(1);
                    break;
                case 6:
                    allLinksPage.checkHumanResources().sleepForSeconds(1);
                    Engine.close();
                    wwwHomePage.activeSelf().sleepForSeconds(1);
                    break;
                case 7:
                    allLinksPage.checkHumanResources1().sleepForSeconds(1);
                    Engine.close();
                    wwwHomePage.activeSelf().sleepForSeconds(1);
                    break;
                default:
                    System.out.println("无该链接");
                    break;
            }
        }

    }
}
