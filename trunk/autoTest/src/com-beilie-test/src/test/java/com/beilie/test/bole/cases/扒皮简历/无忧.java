package com.beilie.test.bole.cases.扒皮简历;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BbpiPage.BapiHomePage;
import com.beilie.test.bole.pages.BbpiPage.ResumeDetailPage;
import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Engine;
import org.junit.Test;
import java.util.Map;

public class 无忧 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException{
        BapiHomePage bapiHomePage = wuyouLogin().sleepForSeconds(3);

        int id_numb=0;
        id_numb=bapiHomePage.wuyou_id_numb();
        if (id_numb ==0){
            bapiHomePage.wuyou_clickForce().sleepForSeconds(3);
        }

        bapiHomePage.wuyou_clickSearchPeople_menu().sleepForSeconds(1);

        for (int i=1;i<=58;i++){
            Map map=bapiHomePage.wuyou_areas();
            String str=i+"";
            String area=map.get(str)+"";

            bapiHomePage.wuyou_clickLocation("居住地").sleepForSeconds(2)
                        .wuyou_clickArea(area).sleepForSeconds(1);

                bapiHomePage.wuyou_clickCity(0).sleepForSeconds(1)
                            .wuyou_clickSearch().sleepForSeconds(3);

            int numb=bapiHomePage.wuyou_numb()+1;

            //int randomNum= 1;//10-20位随机数
            for (int j=0;j<numb;j++){
                if (j==10){
                    String page_str=bapiHomePage.wuyou_pages();
                    if (page_str.equals("500")){
                        break;}

                    bapiHomePage.wuyou_clickNext().sleepForSeconds(2);
                    j=-1;
                   }else {
                    int randomNum= Public.generateNumber10_n(11);//10-20位随机数
                    ResumeDetailPage resumeDetailPage=(ResumeDetailPage)bapiHomePage
                            .wuyou_clickCandidate(j).switchToNextPage(ResumeDetailPage.class);

                    bapiHomePage.sleepForSeconds(randomNum);

                    Engine.close();
                    bapiHomePage.activeSelf();}
               }

           }


    }
}
