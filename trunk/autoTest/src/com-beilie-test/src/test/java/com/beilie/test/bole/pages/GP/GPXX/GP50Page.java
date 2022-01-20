package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;
import java.util.HashMap;
import java.util.Map;

//GP50待回访列表页面，客服角色
public class GP50Page extends Public<GP50Page> {

    public String selectCheckList() {
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("0", "待查");
        hash.put("1", "确认逃单");
        hash.put("2", "重点嫌疑");
        hash.put("3", "联系中");
        hash.put("4", "确认OK");

        int randomNumb = generateNumber1(5);
        String status = (hash.get(randomNumb + "")).toString();

        div_followingDiv_li_click("查单状态：", status);
        return status;
    }


}
