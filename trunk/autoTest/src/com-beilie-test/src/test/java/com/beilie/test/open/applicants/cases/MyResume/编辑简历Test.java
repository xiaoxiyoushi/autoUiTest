package com.beilie.test.open.applicants.cases.MyResume;

import com.beilie.test.open.applicants.core.ApplicantBase;
import com.beilie.test.open.applicants.pages.AplHomePage;
import com.beilie.test.open.applicants.pages.EditMyResume;
import org.junit.Test;

public class 编辑简历Test extends ApplicantBase {
    @Test
    public void 编辑我的简历() throws Throwable{
        AplHomePage aplHomePage = login("13370273780", "1");
        EditMyResume myResume=(EditMyResume)aplHomePage.clickMyResume()
                .transfer(EditMyResume.class).sleepForSeconds(1);
              myResume.editMingpian().sleepForSeconds(1);


    }
}
