package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import java.util.List;
//GP58项目客户
public class GP58Page extends Public<GP58Page> {
    public List<Element> elements(){
        List<Element> elements=this.findByClassName("detailsTable")
                                   .findByTagName("tbody")
                                   .findListByTagName("tr");
        return elements;
    }

    public GP58Page clickClientName(){
        //elements().get(0).findListByTagName("td").get(0).findByTagName("a").click();
        this.findByClassName("ivu-table-cell-ellipsis")
                .findByTagName("a").click();
        return this;
    }
}
