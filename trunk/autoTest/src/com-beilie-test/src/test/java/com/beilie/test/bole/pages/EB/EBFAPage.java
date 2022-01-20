package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;

public class EBFAPage<T extends EBFAPage> extends Public<T> {
    //点击目前职能的icon
    public T workExperience_function_click(){
        this.findById("vailworkExperience")
                .findByClassName("icon-function").click();
        return (T)this;
    }
}
