package com.beilie.test.bole.cases.扒皮简历;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BbpiPage.BapiHomePage;
import com.beilie.test.bole.pages.BbpiPage.ResumeDetailPage;
import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Engine;
import org.junit.Test;

public class 卓聘 extends BoleBase {
   // @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException{
        BapiHomePage bapiHomePage = zuopinLogin().sleepForSeconds(3);

        int id_numb=0;
        while (id_numb==0){
            id_numb=bapiHomePage.id_numb();
            bapiHomePage.sleepForSeconds(1);
        }

        bapiHomePage.clickSearchPeople_menu().sleepForSeconds(1)
                    .clickCurrentCity().sleepForSeconds(2);

        int numb=bapiHomePage.numb();
        int randomNum= Public.generateNumber10_n(11);//10-20位随机数
        for (int i=0;i<numb;i++){
            ResumeDetailPage resumeDetailPage=(ResumeDetailPage)bapiHomePage
                    .clickCandidateImage(i).switchToNextPage(ResumeDetailPage.class);

            bapiHomePage.sleepForSeconds(randomNum);

            Engine.close();
            bapiHomePage.activeSelf();

        }



    }
}
