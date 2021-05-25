package com.beilie.test.bole.pages.BbpiPage;

import com.beilie.test.seleniums.core.UIPage;

import java.util.HashMap;
import java.util.Map;

public class BapiHomePage extends UIPage<BapiHomePage> {
    //猎聘
    public int id_numb(){
        int id_numb=this.findListById("root").size();
        return id_numb;
    }

    /*
    无忧
     */
    public BapiHomePage wuyou_clickForce(){
        this.findByXPath("//a[text()=\"强制下线\"]").click();
        return this;
    }

    //无忧
    public int wuyou_id_numb(){
        int id_numb=this.findListById("workdesk_cmnav").size();
        return id_numb;
    }

    //无忧
    public BapiHomePage wuyou_clickSearchPeople_menu(){
        this.findByXPath("//a[text()=\"找精英\"]").click();
        return this;
    }

    //无忧，点击居住地
    public BapiHomePage wuyou_clickLocation(String str){
        this.findByXPath("//input[@placeholder=\""+str+"\"]").click();
        return this;
    }

    //无忧，点击城市
    public BapiHomePage wuyou_clickCity(int n) throws InterruptedException{
        this.findById("childCity").findByTagName("input").click();

        this.findByXPath("//a[text()=\"确定\"]").click();
        return this;
    }

    //无忧
    public BapiHomePage wuyou_clickArea(String area){
        int n=this.findByClassName("selCity").findListByTagName("li").size();

        if (n>0){
            for (int i=0;i<n;i++){
                this.findByClassName("selCity").findListByTagName("li").get(0).hover();

                this.findByClassName("selCity").findListByTagName("li").get(0)
                        .findByTagName("i").click();
            }
        }

        this.findByXPath("//td[text()=\""+area+"\"]").click();
        return this;
    }

    //无忧
    public BapiHomePage wuyou_clickSearch(){
        this.findByXPath("//div[text()=\"搜索\"]").click();
        return this;
    }

    //无忧
    public int wuyou_numb(){
        int numb=this.findById("SH_share_managerlist")
                .findListByTagName("li").size();
        return numb;
    }

    //无忧
    public BapiHomePage wuyou_clickCandidate(int n){
        this.findById("SH_share_managerlist").findListByTagName("li").get(n)
                .findByClassName("yiyi_imgFl").click();
        return this;
    }
    //无忧
    public BapiHomePage wuyou_clickNext(){
        this.findByClassName("next").click();
        return this;
    }
    //无忧
    public String wuyou_pages(){
        String str=this.findListByClassName("pageJump").get(1)
                .findByTagName("input").getAttribute("value")
               ;
        return str;
    }

    //无忧
    public Map wuyou_areas(){

        Map map=new HashMap();
        map.put("1","北京");
        map.put("2","上海");
        map.put("3","广州");
        map.put("4","深圳");
        map.put("5","天津");
        map.put("6","重庆");
        map.put("7","南京");
        map.put("8","武汉");
        map.put("9","西安");
        map.put("10","杭州");

        map.put("11","成都");
        map.put("12","苏州");
        map.put("13","宁波");
        map.put("14","青岛");
        map.put("15","沈阳");
        map.put("16","大连");
        map.put("17","东莞");
        map.put("18","福州");
        map.put("19","济南");
        map.put("20","合肥");

        map.put("21","郑州");
        map.put("22","长沙");
        map.put("23","哈尔滨");
        map.put("24","长春");
        map.put("25","昆明");
        map.put("26","无锡");
        map.put("27","常州");
        map.put("28","珠海");
        map.put("29","佛山");
        map.put("30","南昌");

        map.put("31","安徽省");
        map.put("32","福建省");
        map.put("33","甘肃省");
        map.put("34","广东省(除深圳)");
        map.put("35","广西");
        map.put("36","贵州省");
        map.put("37","海南省");
        map.put("38","河北省");
        map.put("39","河南省");
        map.put("40","黑龙江省");

        map.put("41","湖北省");
        map.put("42","湖南省");
        map.put("43","吉林省");
        map.put("44","江苏省");
        map.put("45","江西省");
        map.put("46","辽宁省");
        map.put("47","内蒙古");
        map.put("48","宁夏");
        map.put("49","青海省");
        map.put("50","山东省");

        map.put("51","山西省");
        map.put("52","陕西省");
        map.put("53","四川省");
        map.put("54","西藏");
        map.put("55","新疆");
        map.put("56","云南省");
        map.put("57","浙江省");

        //map.put("32","澳门");
        //map.put("59","");
        //map.put("60","");

        return map;
    }

    public int numb(){
        int numb=this.findByClassName("table-box").findListByTagName("tr").size();
        return numb;
    }

    public BapiHomePage clickSearchPeople_menu(){
        this.findByXPath("//a[text()=\"找人\"]").click();
        return this;
    }

    public BapiHomePage clickCurrentCity(){
        this.findListByXPath("//span[text()=\"目前城市：\"]/following-sibling::div//label")
                .get(0)
                .click();
        return this;
    }

    public BapiHomePage clickCandidateImage(int n){
        this.findListByClassName("card-portrait").get(n)
                .findByTagName("a")
                .click();
        return this;
    }
}
