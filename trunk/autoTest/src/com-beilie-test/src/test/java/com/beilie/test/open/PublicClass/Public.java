package com.beilie.test.open.PublicClass;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import java.util.*;

public class Public<T extends Public> extends UIPage<T> {
    //随机生成字符串
    public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

    /*
    要产生随机数，可以使用Java api中java.lang包中的Math类.Math类以静态方法的方式提供常用的数学方法，
    其中Math.random()方法是一个可以产生[0.0,1.0]区间内的一个双精度浮点数的方法
    如：
    产生一个100以内的整数：int x=(int)(Math.random()*100);
    又如：
    产生一个1-50之间的随机数：int x=1+(int)(Math.random()*50)
     */

    public static int generateNumber() {
        Random r = new Random();
        int num = (int) (Math.random() * 4);//num产生0-3
        return num;
    }

    public static int generateNumber1(int i) {
        int num = (int) (Math.random() * i);//num产生0~i-1
        return num;
    }

    public static int generateNumber0_n_1(int i) {
        int num = (int) (Math.random() * i);//num产生0~i-1
        return num;
    }

    public static int generateNumber2(int i) {
        int num = 1 + (int) (Math.random() * i);//num产生1~i
        return num;
    }

    public static int generateNumber1_n(int i) {
        int num = 1 + (int) (Math.random() * i);//num产生1~i
        return num;
    }

    public static int generateNumber10_n(int i) {
        int num = 10 + (int) (Math.random() * i);//num产生10~i+10
        return num;
    }

    /*
    i标签
     */
    public T i_class_click() {
        this.findByClassName("ivu-icon-ios-close").click();
        return (T) this;
    }

    //根据i标签的class属性定位到该元素,并且点击
    public T i_classClick(String class_) {
        this.findByXPath("//i[@class=\"" + class_ + "\"]").click();
        return (T) this;
    }


    /**
     * 组件,组件:Component
     */
    //行业组件
    public T industryComponent() {
        //一级
        Map map = new HashMap();
        map.put("1", "IT/互联网/游戏");
        map.put("2", "计算机/通信/电子");
        map.put("3", "金融");
        map.put("4", "交通/贸易/物流");
        map.put("5", "消费品");
        map.put("6", "机械/自动化/制造");
        map.put("7", "汽车");
        map.put("8", "能源/矿产/环保");
        map.put("9", "制药/医疗/健康服务");
        map.put("10", "专业服务");
        map.put("11", "教育/培训");
        map.put("12", "广告/媒体/文化");
        map.put("13", "房地产");
        /*map.put("14", "服务业");
        map.put("15", "政府/非营利性机构");
        map.put("16", "其他行业");
        map.put("17", "不限");*/

        int n = generateNumber2(13);//1-17间的随机数
        String str = n + "";
        String industry = map.get(str) + "";

        /*int firstLevelSize = this.findByClassName("industryList")
                .findListByTagName("li").size();*/

        for (int i = 0; i < 13; i++) {
            /*String firstIndustr = this.findByClassName("industryList")
                    .findListByTagName("li").get(i).getText();*/
            String firstIndustr = this.findListByClassName("industry-catelogs-item")
            .get(i).getText();
            if (StringUtils.equals(firstIndustr, industry)) {
                this.findListByClassName("industry-catelogs-item")
                        .get(i).click();
                break;
            }
        }

        int secondLevelSize = this.findListByClassName("content-layout-item")
                .size();
        int m = generateNumber1(secondLevelSize);//0-secondLevelSize间的随机数
        this.findListByClassName("content-layout-item").get(m).click();//点击二级的行业

        //this.findByClassName("industruWrapFooter").findByClassName("ef-confirm-btn").click();//点击确定按钮
        button_classClick("ivu-btn ivu-btn-primary ivu-btn-large");//点击确定按钮

        return (T) this;
    }

    //获取第二级行业组件的值
    public String getIndustryComponentValue() {
        //一级
        Map map = new HashMap();
        map.put("1", "IT/互联网/游戏");
        map.put("2", "计算机/通信/电子");
        map.put("3", "金融");
        map.put("4", "交通/贸易/物流");
        map.put("5", "消费品");
        map.put("6", "机械/自动化/制造");
        map.put("7", "汽车");
        map.put("8", "能源/矿产/环保");
        map.put("9", "制药/医疗/健康服务");
        map.put("10", "专业服务");
        map.put("11", "教育/培训");
        map.put("12", "广告/媒体/文化");
        map.put("13", "房地产");
        map.put("14", "服务业");
        map.put("15", "政府/非营利性机构");
        map.put("16", "其他行业");
        map.put("17", "不限");

        int n = generateNumber2(17);//1-17间的随机数
        String str = n + "";
        String industry = map.get(str) + "";

        //获取已选行业的个数
        int selectedIndustry = this.findListByClassName("changeInfo_industry").size();

        //如果存在已选的职能，就叉掉
        if (selectedIndustry > 0) {
            for (int i = 0; i < selectedIndustry; i++) {
                this.findListByClassName("changeInfo_industry").get(0)
                        .findByTagName("img").click();
            }
        }

        int firstLevelSize = this.findByClassName("industryList")
                .findListByTagName("li").size();

        for (int i = 0; i < firstLevelSize; i++) {
            String firstIndustr = this.findByClassName("industryList")
                    .findListByTagName("li").get(i).getText();
            if (StringUtils.equals(firstIndustr, industry)) {
                this.findByClassName("industryList")
                        .findListByTagName("li").get(i).click();
                break;
            }
        }

        //二级行业
        int secondLevelSize = this.findByClassName("ef-cp-border")
                .findListByTagName("li").size();
        int m = generateNumber1(secondLevelSize);//0-secondLevelSize间的随机数

        //获取第二级的行业名称
        String secondLevelIndustry;
        if (m == 0) {
            secondLevelIndustry = industry;
        } else {
            secondLevelIndustry = this.findByClassName("ef-cp-border")
                    .findListByTagName("li").get(m).getText();
        }

        this.findByClassName("ef-cp-border")
                .findListByTagName("li").get(m).click();//点击二级的行业
        this.findByClassName("industruWrapFooter").findByClassName("ef-confirm-btn").click();//点击确定按钮
        return secondLevelIndustry;
    }

    //点击工作地点
    public T workPlaceComponent() {
        int numb = 0;
        while (numb < 2) {
            int areaSize = this.findByClassName("tab-layout-body")
                    .findListByClassName("content-layout-item")
                    .size();//获取地区个数
            int m = generateNumber1(areaSize);//0-areaSize间的随机数
            this.findByClassName("tab-layout-body")
                    .findListByClassName("content-layout-item")
                    .get(m).click();//点击地区
            numb = this.findListByXPath("//div[@class=\"ef-selector-modal-header d-flex justify-content-between\"]//span")
                    .size();
        }
        button_classClick("ivu-btn ivu-btn-primary ivu-btn-large");//点击确定按钮
        return (T) this;
    }

    //获取工作地点值
    public String placeComponent_getValue() {
        int n = generateNumber1(2);//0-1间的随机数
        int citySize = this.findListById("stab.level").get(n)
                .findListByTagName("li").size();
        int m = generateNumber1(citySize);//0-citySize间的随机数

        String location = this.findListById("stab.level").get(n)
                .findListByTagName("li").get(m).getText();//获取第一级地区的值
        this.findListById("stab.level").get(n)
                .findListByTagName("li").get(m).click();//点击第一级地区

        this.findById("stab.level")
                .findListByTagName("li").get(0).click();//点击第二级地区
        this.findByClassName("ef-confirm-btn").click();//点击确定按钮
        return location;
    }

    //选择职能组件,可以选多个职能
    public T functionComponent() {
        int n = generateNumber1(2);//0-1间的随机数
        String str ="";
        while (!StringUtils.equals(str,"2")) {
            /*int FunctionSize = this.findListByXPath("//div[@class=\"ef-function-selector-block\"]").get(n)
                    .findListByTagName("li").size();//获取职能个数*/
            int FunctionSize = this.findListByXPath("//div[@class=\"tab-layout-body\"]//ul").get(n)
                    .findListByTagName("li").size();//获取职能个数

            int m = generateNumber1(FunctionSize);//0-firstFunctionSize间的随机数
            this.findListByXPath("//div[@class=\"tab-layout-body\"]//ul").get(n)
                    .findListByTagName("li").get(m).click();//点击职能

            n = 0;
            /*int numb = this.findByClassName("headInfo_function")
                    .findListByTagName("span").size();*/
            /*str = this.findByClassName("headInfo_function")
                    .findListByTagName("span").get(1).getAttribute("class");//获取选中的职能的class属性*/
            int i=this.findListByXPath("//span[text()=\"选择职能：\"]/parent::div/span").size();//组件头的span个数
            str=i+"";
        }

        //this.findByClassName("industruWrapFooter").findByClassName("ef-confirm-btn").click();//点击确定按钮
        this.findByXPath("//button[@class=\"ivu-btn ivu-btn-primary ivu-btn-large\"]").click();//点击确定按钮
        return (T) this;
    }

    //选择职能组件,选单个职能
    public T functionSingleComponent() {
        int n = generateNumber1(2);//0-1间的随机数
        int numb = 0;
        while (numb < 2) {

            int FunctionSize = this.findByClassName("tab-layout-body")
                    .findListByTagName("ul")
                    .get(n)
                    .findListByTagName("li").size();//获取职能个数

            int m = generateNumber1(FunctionSize);//0-firstFunctionSize间的随机数

            this.findByClassName("tab-layout-body")
                    .findListByTagName("ul").get(n)
                    .findListByTagName("li").get(m).click();//点击职能

            n = 0;
            numb = this.findListByXPath("//div[@class=\"ef-selector-modal-header d-flex justify-content-between\"]//span")
                    .size();
        }

        button_classClick("ivu-btn ivu-btn-primary ivu-btn-large");//点击确定按钮
        return (T) this;
    }

    //获取职能组件值;选择单个职能组件
    public String getfunction_SingleComponentValue() {
        //获取已选行业的个数
        int selectedFunction = this.findListByClassName("changeInfo_function").size();//获取已选职能的个数
        //如果存在已选的职能，就叉掉
        if (selectedFunction > 0) {
            for (int i = 0; i < selectedFunction; i++) {
                this.findListByClassName("changeInfo_function").get(0)
                        .findByTagName("img").click();
            }
        }
        int n = generateNumber1(2);//0-1间的随机数
        int numb = 0;
        String str = "";
        String function = "";
        while (numb < 2) {
            int FunctionSize = this.findListById("stab.level").get(n)
                    .findListByTagName("li").size();//获取职能个数

            int m = generateNumber1(FunctionSize);//0-firstFunctionSize间的随机数
            if (m == 0) {
                m = m + 1;
            }
            //获取职能组件的值
            function = this.findListById("stab.level").get(n)
                    .findListByTagName("li").get(m).getText();

            this.findListById("stab.level").get(n)
                    .findListByTagName("li").get(m).click();//点击职能

            n = 0;
            numb = this.findByClassName("headInfo_function")
                    .findListByTagName("span").size();
        }

        this.findByClassName("industruWrapFooter").findByClassName("ef-confirm-btn").click();//点击确定按钮

        return function;
    }


    //获取职能组件值;选择职能组件,可以选多个职能
    public String getfunctionComponentValue() {
        //获取已选行业的个数
        int selectedFunction = this.findListByClassName("changeInfo_function").size();//获取已选职能的个数
        //如果存在已选的职能，就叉掉
        if (selectedFunction > 0) {
            for (int i = 0; i < selectedFunction; i++) {
                this.findListByClassName("changeInfo_function").get(0)
                        .findByTagName("img").click();
            }
        }

        int n = generateNumber1(2);//0-1间的随机数
        String str = "";
        String function = "";
        while (!StringUtils.equals(str, "changeInfo_function ef-primary-color")) {
            int FunctionSize = this.findListById("stab.level").get(n)
                    .findListByTagName("li").size();//获取职能个数

            int m = generateNumber1(FunctionSize);//0-firstFunctionSize间的随机数
            if (m == 0) {
                m = m + 1;
            }
            //获取职能组件的值
            function = this.findListById("stab.level").get(n)
                    .findListByTagName("li").get(m).getText();

            //点击职能
            this.findListById("stab.level").get(n)
                    .findListByTagName("li").get(m).click();

            n = 0;
            str = this.findByClassName("headInfo_function")
                    .findListByTagName("span").get(1).getAttribute("class");//获取选中的职能的class属性
        }

        this.findByClassName("industruWrapFooter").findByClassName("ef-confirm-btn").click();//点击确定按钮
        return function;
    }

    public Element selectElems(int i) {
        Element elements = this.findByClassName("dialog-box").findListByTagName("ul").get(i);
        return elements;
    }

    public T location1(int i) {
        this.selectElems(0).findListByTagName("li").get(i).click();
        return (T) this;
    }

    public T location2(int j) {
        this.findById("stab.level").findListByTagName("li").get(j).click();
        return (T) this;
    }

    public T submitlocation() {
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        return (T) this;
    }

    //工作地点
    public T workPlace(int i, int j) {
        this.selectElems(0).findListByTagName("li").get(i).click();
        this.findById("stab.level").findListByTagName("li").get(j).click();
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        return (T) this;
    }
    //工作地点1
    /*public T workPlace1(int i,int j,int k){
        this.selectElems(0).findListByTagName("li").get(i).click();
        this.findById("stab.level").findListByTagName("li").get(j).click();
        this.findById("stab.level").findListByTagName("li").get(k).click();
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        return (T) this;
    }*/
    //日历
    /*public T calendar() {
        this.findByCssSelector("#EFMonthSelector > div > div.ivu-select-dropdown > div > div > div > div:nth-child(2) > div > span:nth-child(1) > em")
                .click();
        return (T) this;
    }*/

    /*
    a标签
     */
    //根据a标签的内容定位到该元素，再获取它后面的兄弟
    public T firstTask(String str) {
        this.findByXPath("//a[text()=\"" + str + "\"]/following-sibling::span").click();
        return (T) this;
    }

    //根据a标签的内容定位到该元素,并且点击
    public T secondTask(String str) {
        this.findByXPath("//a[text()=\"" + str + "\"]").click();
        return (T) this;
    }

    //根据a标签的内容定位到该元素,获取该元素的值
    public T getValue(String str) {
        String value = this.findByXPath("//a[text()=\"" + str + "\"]").getText();
        return (T) this;
    }

    public T clickA(String str, int i) {
        this.findListByXPath("//a[text()=\"" + str + "\"]").get(i).click();
        return (T) this;
    }

    public T a_click(String str) {
        this.findByXPath("//a[text()=\"" + str + "\"]").click();
        return (T) this;
    }

    //根据a标签的class属性定位到该元素,并且点击
    public T a_classClick(String str) {
        this.findByXPath("//a[@class=\"" + str + "\"]").click();
        return (T) this;
    }

    /*
    input标签，根据placeholder属性的值
     */
    //输入input框
    public T sendInputPlaceholder(String str, String value) {
        this.findByXPath("//input[@placeholder=\"" + str + "\"]").sendKeys(value);
        return (T) this;
    }

    //点击input框
    public T clickInputPlaceholder(String str) {
        this.findByXPath("//input[@placeholder=\"" + str + "\"]").click();
        return (T) this;
    }

    public T inputPlaceholder_parentDiv_parentDiv_iClick(String str) {
        this.findByXPath("//input[@placeholder=\"" + str + "\"]/parent::div/parent::div/following-sibling::i").click();
        return (T) this;
    }



    /*public T clickInputPlaceholder_(String str) {
        this.findByXPath("//input[@placeholder=\"" + str + "\"]").sendKeys();
        return (T) this;
    }*/

    public T input_bcakSpace(String str, int n) {
        for (int i = 0; i < n; i++) {
            this.findByXPath("//input[@placeholder=\"" + str + "\"]").sendKeys(Keys.BACK_SPACE);
            //this.findByXPath("//input[@placeholder=\""+str+"\"]").sendKeys(Keys.END);
        }

        return (T) this;
    }

    //清除input框
    public T clearInput(String str) {
        this.findByXPath("//input[@placeholder=\"" + str + "\"]").clear();
        return (T) this;
    }

    /*
    span标签
     */
    //根据span标签的内容定位到该元素，并且点击该元素
    public T clickSpan(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]").click();
        return (T) this;
    }

    //根据span标签的内容定位到该元素，并且获取该元素的值
    public String getSpanValue(String str) {
        String value = this.findByXPath("//span[text()=\"" + str + "\"]").getText();
        return value;
    }

    //根据span标签的内容定位到该元素，并且获取该元素的值
    public T Span_Value(String str) {
        String value = this.findByXPath("//span[text()=\"" + str + "\"]").getText();
        return (T) this;
    }

    //根据span标签的内容定位到该元素，并且获取所有元素的个数
    public int listSpan_Value(String str) {
        int numb = this.findListByXPath("//span[text()=\"" + str + "\"]").size();
        return numb;
    }

    //根据span标签的内容定位到该元素，再定位前一个兄弟元素label,再点击
    public T span_precedingLabel_Click(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]/preceding-sibling::label").click();
        return (T) this;
    }

    //根据span标签的内容定位到该元素，再定位它后面的兄弟，获取input框
    public T span_followingDiv_input(String str, String value) {
        this.findByXPath("//span[text()=\"" + str + "\"]/following-sibling::div//input").sendKeys(value);
        return (T) this;
    }

    //根据span标签的内容定位到该元素，再定位它后面的兄弟i标签,并且点击
    public T span_followingI(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]/following-sibling::i").click();
        return (T) this;
    }

    //根据span标签的内容定位到该元素，再定位它后面的兄弟a标签,并且点击
    public T span_followingA(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]/following-sibling::a").click();
        return (T) this;
    }

    //根据span标签的内容定位到该元素，再定位它后面的兄弟span标签,并且点击
    public T span_followingSpan(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]/following-sibling::span").click();
        return (T) this;
    }

    //根据span标签的内容定位到该元素，再定位它后面的兄弟span标签,获取值
    public String span_followingGetSpan(String str) {
        String value = this.findByXPath("//span[text()=\"" + str + "\"]/following-sibling::span").getText();
        return value;
    }

    public T span_followingSpan_i_click(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]/following-sibling::span/i").click();
        return (T) this;
    }

    //根据span标签的内容定位到该元素，再定位它父元素，父元素的后面兄弟
    public T span_parent_followingGetSpan(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]/parent::li/following-sibling::li/img").click();
        return (T) this;
    }

    //根据span标签的内容定位到该元素，再定位它父元素，父元素的后面兄弟
    public String span_parentDiv_followingGetDiv(String str) {
        String value = this.findByXPath("//span[text()=\"" + str + "\"]/parent::div/following-sibling::div").getText();
        return value;
    }

    //学历，点击第二个
    //根据span标签的内容定位到该元素，再定位它父元素，再定位它父元素的父元素，父元素的后面兄弟
    public T span_parentDiv_parentDiv_followingGetDiv(String str, String str_1) {
        this.findByXPath("//span[text()=\"" + str + "\"]/parent::div/parent::div/following-sibling::div//li[text()=\"" + str_1 + "\"]").click();
        return (T) this;
    }

    public T spanTitle_followingDiv_input(String str, String value) {
        this.findByXPath("//span[@title=\"" + str + "\"]/following-sibling::div//input").sendKeys(value);
        return (T) this;
    }

    //span标签 class
    public String span_class(String str) {
        String value = this.findByXPath("//span[@class=\"" + str + "\"]/span").getText();
        return value;
    }

    public String spanClass(String str) {
        String value = this.findByXPath("//span[@class=\"" + str + "\"]").getText();
        return value;
    }

    public T spanClass_click(String str) {
        this.findByXPath("//span[@class=\"" + str + "\"]").click();
        return (T) this;
    }

    /*
    button标签
     */
    //根据button标签的内容定位到该元素，并且点击该元素
    public T clickButton(String str) {
        this.findByXPath("//button[text()=\"" + str + "\"]").click();
        return (T) this;
    }

    //根据button标签的title定位到该元素，并且获取他下一级span元素的值
    public String button_spanValue(String str) {
        String button_spanValue = this.findByXPath("//button[@title=\"" + str + "\"]/span").getText();
        return button_spanValue;
    }

    //根据button标签的title定位到该元素，并且点击他下一级span元素
    public T button_spanClick(String str) {
        this.findByXPath("//button[@title=\"" + str + "\"]/span").click();
        return (T) this;
    }

    //根据button标签的class定位到该元素，并且点击
    public T button_classClick(String str) {
        this.findByXPath("//button[@class=\"" + str + "\"]").click();
        return (T) this;
    }

    public T buttonClass_spanClick(String str1, String str2) {
        this.findByXPath("//button[@class=\"" + str1 + "\"]/span[text()=\"" + str2 + "\"]").click();
        return (T) this;
    }

    public String button_followingBtn_Class(String str) {
        String button_class = this.findByXPath("//button[@class=\"" + str + "\"]/following-sibling::button").getAttribute("class");
        return button_class;
    }

    /*
    ul标签
     */
    //根据ul标签的class定位到该元素，随机获取其子标签li,并且点击
    public T ul_clickLi(int n) {
        this.findByClassName("ivu-select-dropdown-list")
                .findListByTagName("li").get(n).click();
        return (T) this;
    }

    public T ulClass_li(String str1, int n) {
        this.findByXPath("//ul[@class=\"" + str1 + "\"]")
                .findListByTagName("li").get(n)
                .click();
        return (T) this;
    }

    /*
    li标签
     */
    //根据li标签的内容定位到该元素，并且点击该元素
    public T Li_click(String str) {
        this.findByXPath("//li[text()=\"" + str + "\"]").click();
        return (T) this;
    }

    //根据li标签的内容定位到该元素，并且点击该元素
    public T manyLi_click(String str) {
        this.findListByXPath("//li[text()=\"" + str + "\"]")
                .get(1).click();
        return (T) this;
    }

    /*
   div标签
    */
    //根据div标签的data-placeholder属性 定位到该元素，输入内容
    public T div_dataplaceholder_send(String str, String value) {
        this.findByXPath("//div[@data-placeholder=\"" + str + "\"]").sendKeys(value);
        return (T) this;
    }

    //根据div标签的data-placeholder属性 定位到该元素，清除内容
    public T div_dataplaceholder_clear(String str) {
        this.findByXPath("//div[@data-placeholder=\"" + str + "\"]").clear();
        return (T) this;
    }

    //根据div标签的内容 定位到该元素，hover该元素
    public T div_hover(String str) {
        this.findByXPath("//div[text()=\"" + str + "\"]").hover();
        return (T) this;
    }

    //根据div标签的内容 定位到该元素，click该元素
    public T div_click(String str) {
        this.findByXPath("//div[text()=\"" + str + "\"]").click();
        return (T) this;
    }
    /*public T divParent_click(String str){
        this.findByXPath("//div[text()=\""+str+"\"]/parent::div/parent::div//div[text()=\"确定\"]").click();
        return (T) this;
    }*/

    //根据div标签的内容 定位到该元素，获取该元素的值
    public T div_getValue(String str) {
        this.findByXPath("//div[text()=\"" + str + "\"]").getText();
        return (T) this;
    }

    public String div_Value(String str) {
        String message = this.findByXPath("//div[text()=\"" + str + "\"]").getText();
        return message;
    }

    public T divTitle(String str) {
        this.findByXPath("//div[@title=\"" + str + "\"]").click();
        return (T) this;
    }

    //根据div标签的class，并且点击
    public T divClass(String str) {
        this.findByXPath("//div[@class=\"" + str + "\"]").click();
        return (T) this;
    }

    //根据div标签的class 定位到下级a元素，并且点击
    public T div_class_(String str) {
        this.findByXPath("//div[@class=\"" + str + "\"]//a").click();
        return (T) this;
    }

    public T div_class_button(String str) {
        this.findByXPath("//div[@class=\"" + str + "\"]/button").click();
        return (T) this;
    }

    public T divClass_spanClick(String str) {
        this.findByXPath("//div[@class=\"" + str + "\"]/span").click();
        return (T) this;
    }

    public String divClass_value(String str) {
        String value = this.findByXPath("//div[@class=\"" + str + "\"]").getText();
        return value;
    }

    public String divClass_span(String str) {
        String value = this.findByXPath("//div[@class=\"" + str + "\"]/span").getText();
        return value;
    }

    public String divClass_b(String str) {
        String value = this.findByXPath("//div[@class=\"" + str + "\"]/b").getText();
        return value;
    }

    public T divClass_input_send(String str, String str1) {
        this.findByXPath("//div[@class=\"" + str + "\"]/input").sendKeys(str1);
        return (T) this;
    }

    public T divClass_textarea_send(String str, String str1) {
        this.findByXPath("//div[@class=\"" + str + "\"]/textarea").sendKeys(str1);
        return (T) this;
    }

    public T div_followingDiv_input_click(String str) {
        this.findByXPath("//div[text()=\"" + str + "\"]/following-sibling::div//input").click();
        return (T) this;
    }

    public T div_followingDiv_span_click(String str) {
        this.findByXPath("//div[text()=\"" + str + "\"]/following-sibling::div//span").click();
        return (T) this;
    }

    public T div_followingDiv_li_click(String str, String str1) {
        this.findByXPath("//div[text()=\"" + str + "\"]/following-sibling::div//li[text()=\"" + str1 + "\"]").click();
        return (T) this;
    }

    public T div_parentDiv_precedingA_click(String str) {
        this.findByXPath("//div[text()=\"" + str + "\"]/parent::div/preceding-sibling::a").click();
        return (T) this;
    }

    public T div_parentDiv_followingDiv_spanClick(String str, String str1) {
        this.findByXPath("//div[text()=\"" + str + "\"]/parent::div/following-sibling::div//span[text()=\"" + str1 + "\"]").click();
        return (T) this;
    }

    /*
    label标签
     */
    public T labelClass_Click(String class_) {
        this.findByXPath("//label[@class=\"" + class_ + "\"]").click();
        return (T) this;
    }

    //根据label标签的内容定位到该元素，再定位它后面的兄弟，获取input框
    public T labelClick(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]").click();
        return (T) this;
    }

    public String label_followingDiv_spanValue(String str) {
        String value=this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//span").getText();
        return value;
    }

    public T label_followingDiv_input(String str, String value) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//input").sendKeys(value);
        return (T) this;
    }

    //根据label标签的内容定位到该元素，再定位它后面的兄弟，点击input框
    public T label_followingDiv_clickInput(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//input").click();
        return (T) this;
    }

    public T label_followingDiv_clickI(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//i").click();
        return (T) this;
    }

    public T label_followingDiv_Input_down(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//input").sendKeys(Keys.DOWN);
        return (T) this;
    }

    public T label_followingDiv_Input_enrter(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//input").sendKeys(Keys.ENTER);
        return (T) this;
    }

    public T label_followingDiv_Input_space(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//input").sendKeys(Keys.SPACE);
        return (T) this;
    }

    //根据label标签的内容定位到该元素，再定位它后面的兄弟，点击img标签
    public T label_followingDiv_clickimg(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//img").click();
        return (T) this;
    }

    //根据label标签的内容定位到该元素，再定位它后面的兄弟，点击img标签
    public T label_followingDiv_clickLabel(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div//label").click();
        return (T) this;
    }

    /*
    strong标签
     */
    public String strong_style(String str) {
        String styleValue = this.findByXPath("//strong[text()=\"" + str + "\"]")
                .getAttribute("style");
        return styleValue;
    }

    /*
    img标签
     */
    //根据label标签的alt内容定位到该元素，再点击该元素
    public T img_altClick(String str) {
        this.findByXPath("//img[@alt=\"" + str + "\"]").click();
        return (T) this;
    }

    /*
    h2标签
     */
    //根据label标签的alt内容定位到该元素，再点击该元素
    public T h2_inputClick(String str) {
        this.findByXPath("//h2[text()=\"" + str + "\"]/following-sibling::div//input").click();
        return (T) this;
    }

    /*
    textarea标签
     */
    //清除textarea的内容
    public T clearTextarea(String str) {
        this.findByXPath("//textarea[@placeholder=\"" + str + "\"]").clear();
        return (T) this;
    }

    public T textarea_sendkeys(String str, String str1) {
        this.findByXPath("//textarea[@placeholder=\"" + str + "\"]").sendKeys(str1);
        return (T) this;
    }

    public T textarea_bcakSpace(String str, int n) {
        for (int i = 0; i < n; i++) {
            this.findByXPath("//textarea[@placeholder=\"" + str + "\"]").sendKeys(Keys.BACK_SPACE);
            //this.findByXPath("//textarea[@placeholder=\""+str+"\"]").sendKeys(Keys.ENTER);
        }

        return (T) this;
    }

    /*
    h1标签
     */
    public T h1Class_aClick(String str) {
        this.findByXPath("//h1[@class=\"" + str + "\"]//a").click();
        return (T) this;
    }


    /*
    选择日期
     */
    //有确定按钮
    public T selectTime(String str) {
        this.findByXPath("//input[@placeholder=\"" + str + "\"]").click();
        this.findByClassName("ivu-date-picker-cells-cell-today").click();//选择当天

        this.findByXPath("//span[text()=\"确定\"]").click();//点击【确定】按钮
        return (T) this;
    }

    //无确定按钮
    public T selectTimeNoComfir(String str) {
        this.findByXPath("//input[@placeholder=\"" + str + "\"]").click();
        this.findByClassName("ivu-date-picker-cells-cell-today").click();//选择当天
        return (T) this;
    }

    //当一个页面有多个日历
    public T selectTime_Many(String str, String str_1) {
        this.findByXPath("//input[@placeholder=\"" + str + "\"]").click();
        this.findByXPath("//p[text()=\"" + str_1 + "\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-today").click();
        return (T) this;
    }

    /*
    月份日历
     */
    public T calendar_month() {
        this.findByClassName("ivu-date-picker-cells-cell").click();

        return (T) this;
    }

    //点击当前月份
    public T calendar_currentMonth() {
        this.findByClassName("ivu-date-picker-cells-cell-focused").click();

        return (T) this;
    }

    /*
    先找label
    当一个页面有多个 日历
     */
    //月份
    public T calendar_months_label(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell").click();
        return (T) this;
    }

    /*public T calendar_currentMonths_label(String str){
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-focused").click();
        return (T) this;
    }*/

    //当日
    public T label_calendar_today(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-today").click();
        return (T) this;
    }

    //有确定按钮
    public T label_calendar_today_queding(String str) {
        this.findByXPath("//label[text()=\"" + str + "\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-today").click();

        this.findByXPath("//span[text()=\"确定\"]").click();//点击【确定】按钮
        return (T) this;
    }


    //先找span
    // 根据月份框前的文字，点击当前月份
    public T calendar_currentMonths_span(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-focused").click();
        return (T) this;
    }

    /*
    table  表格
     */
    //获取td元素的值
    public String table_tdValue(int tr_numb, int td_numb) {
        String td_Value = this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb).getText();
        return td_Value;
    }

    //点击td元素
    public T table_tdClick(int tr_numb, int td_numb) {
        this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb).click();
        return (T) this;
    }

    //点击td元素下的a标签
    public T table_td_aClick(int tr_numb, int td_numb) {
        this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findByTagName("a")
                .click();
        return (T) this;
    }

    //点击td元素下的a标签
    public T table_td_list_aClick(int tr_numb, int td_numb, int n) {
        this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findListByTagName("a").get(n)
                .click();
        return (T) this;
    }

    //获取td元素下的a标签的值
    public String table_td_aValue(int tr_numb, int td_numb) {
        String td_Value = this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findByTagName("a")
                .getText();
        return td_Value;
    }

    //获取td元素下的a标签的值
    public String table_td_list_aValue(int tr_numb, int td_numb, int n) {
        String td_Value = this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findListByTagName("a").get(n)
                .getText();
        return td_Value;
    }

    //获取td元素下的span标签的值
    public String table_td_spanValue(int tr_numb, int td_numb) {
        String td_Value = this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findByTagName("span").getText();
        return td_Value;
    }

    //点击td元素下的span标签
    public T table_td_spanClick(int tr_numb, int td_numb) {
        this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findByTagName("span").click();
        return (T) this;
    }

    //获取tr的个数
    public int table_trNumb() {
        int tr_Numb = this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").size();
        return tr_Numb;
    }

    //有多个表格，获取div的值
    public String table_td_divValue(int n, int tr_numb, int td_numb) {
        String td_Value = this.findListByClassName("ivu-table-tbody").get(n)
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findByCssSelector("div > div").getText();
        return td_Value;
    }

    //有多个表格，获取a值
    public String table_td_aValue(int n, int tr_numb, int td_numb, int m) {
        String td_Value = this.findListByClassName("ivu-table-tbody").get(n)
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findListByTagName("a").get(m).getText();
        return td_Value;
    }

    //有多个表格，获取span值
    public String table_td_spanValue(int n, int tr_numb, int td_numb) {
        String td_Value = this.findListByClassName("ivu-table-tbody").get(n)
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findByTagName("span").getText();
        return td_Value;
    }

    //有多个表格，点击a
    public T table_td_aClick(int n, int tr_numb, int td_numb, int m) {
        this.findListByClassName("ivu-table-tbody").get(n)
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findListByTagName("a").get(m).click();
        return (T) this;
    }

    //有多个表格，点击span
    public T table_td_spanClick_many(int n, int tr_numb, int td_numb) {
        this.findListByClassName("ivu-table-tbody").get(n)
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findByTagName("span").click();
        return (T) this;
    }

    //有多个表格，悬浮a
    public T table_td_aHover(int n, int tr_numb, int td_numb, int m) {
        this.findListByClassName("ivu-table-tbody").get(n)
                .findListByTagName("tr").get(tr_numb)
                .findListByTagName("td").get(td_numb)
                .findListByTagName("a").get(m).hover();
        return (T) this;
    }

    //选择一位候选人
    public T selectCandidate() {
        int numb = this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").size();
        int n = Public.generateNumber1(numb);

        this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").get(n)
                .findByClassName("ivu-radio-inner").click();//点击人选姓名前的radio

        this.findByXPath("//button[text()=\"确定\"]").click();//点击【确定】按钮
        return (T) this;
    }

    /*
    获取候选人姓名、推荐职位、推荐企业
     */
    public Map<String, Object> getCandidateValues() {
        String a;
        Map<String, Object> hash = new HashMap<String, Object>();
        String candidateName = this.findByXPath("//span[text()=\"候选人姓名：\"]/following-sibling::span")
                .getText();
        String recommendJob = this.findByXPath("//span[text()=\"推荐职位：\"]/following-sibling::span")
                .getText();
        String recommendComp = this.findByXPath("//span[text()=\"推荐企业： \"]/following-sibling::span")
                .getText();

        hash.put("1", candidateName);
        hash.put("2", recommendJob);
        hash.put("3", recommendComp);

        return hash;
    }

    public T checkInform_Card(List<String> list, int n) throws InterruptedException {
        List<String> list_1 = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String styleValue = this.findListByXPath("//strong[text()=\"" + str + "\"]")
                    .get(n)
                    .getAttribute("style");
            Assert.assertEquals(styleValue, "color: rgb(251, 117, 117);");//红色
        }

        return (T) this;
    }

    public T checkInform_yellow(List<String> list, int n) throws InterruptedException {
        List<String> list_1 = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String styleValue = this.findListByXPath("//strong[text()=\"" + str + "\"]")
                    .get(n)
                    .getAttribute("style");
            Assert.assertEquals(styleValue, "background: rgb(255, 255, 0);");
        }

        return (T) this;
    }

    //校验大小卡片上的性别、年龄、现居住地
    public T checkCard_Inform(List<String> list) throws InterruptedException {
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            int numb = this.listSpan_Value(str);
            Assert.assertEquals(numb, 3);
        }

        return (T) this;
    }

    //点击人选的头像
    public T clickAvatar(int n) {
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").click();
        return (T) this;
    }

    /*
    上传简历
     */
    public T uploadResume(String path) {
        //this.findByXPath("//input[@type=\"file\"]").sendKeys("C:\\Users\\86182\\Desktop\\resume\\4-汤张.docx");
        this.findByClassName("ivu-upload-drag")
                .findByTagName("input").sendKeys(path);
        return (T) this;
    }

    public T displayWait() {
        //Element element=this.findByClassName("ef-modal-ef-model-confirm-b-span");
        ExpectedCondition<Boolean> e = ExpectedConditions.textToBePresentInElement((WebElement) this.findByClassName("ef-modal-ef-model-confirm-b-span"), "添加到我的收藏夹成功，请前往查看。");
        this.waitFor(20, e);
        //WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver,20);
        //等待直到符合元素文本内容出现
        //wait.until(ExpectedConditions.textToBePresentInElement((WebElement)this.findByClassName("ef-modal-ef-model-confirm-b-span"), "添加到我的收藏夹成功，请前往查看。"));

        return (T) this;
    }

    /*
    后退方法
     */
    public T backCurrentPage() {
        this.back();
        return (T) this;
    }

    //将滚动条拉至页面底部
    public T scrollBar() {
        this.execute_script();
        return (T) this;
    }


    String uuid = UUID.randomUUID().toString();

  /*  public Element elements(int i){
        Element element=this.findListByXPath("//*[@id=\"home_menus_menuId\"]/child::li").get(i);
        return element;
    }
*/

    /**
     * 加入项目表
     *
     */
   /* public ArrayList<String> addProjectTable(ArrayList<String> arrayList, int n){
        //获取表的行数
        List<Element> elements=this.findListById("selectTable_box").get(n).findByClassName("table_bg").findListByClassName("ivu-table-row");
        int num=elements.size();

        for(int i=0;i<num;i++){
            elements.get(i).findByClassName("cursorP").click();
            try {
                this.sleepForSeconds(2);
            } catch (InterruptedException e) {
            }
            String joinStatus =  this.findListById("selectTable_box").get(n).findByClassName("table_bg").findListByClassName("ivu-table-row").get(i).findByClassName("weight400").getText();
            //String joinStatus =  elements.get(i).findByClassName("weight400").getText();
            if (joinStatus.equals("已加入")) {
                String clientName1 =  elements.get(i).findListByTagName("span").get(0).getText();//获取第i行的客户名称
                String projectName1 =  elements.get(i).findListByTagName("span").get(1).getText();//获取第i行的项目名称
                String clientName1 =  this.findListById("selectTable_box").get(n).findByClassName("table_bg").findListByClassName("ivu-table-row").get(i).findListByTagName("span").get(0).getText();//获取第i行的客户名称
                String projectName1 =  this.findListById("selectTable_box").get(n).findByClassName("table_bg").findListByClassName("ivu-table-row").get(i).findListByTagName("span").get(1).getText();//获取第i行的项目名称
                arrayList.add(clientName1);
                arrayList.add(projectName1);
                break;
            } else {
                //关闭提示框
                this.findByCssSelector("#ef-modal-ef-model-confirm > div.ef-modal-ef-model-confirm-footer > button").click();
            }
        }
        return arrayList;
    }
*/

//关闭页面
    public T closePage() {
        this.findByXPath("//i[@class=\"icon-btn ivu-icon bole icon-close2\"]").click();
        return (T) this;
    }

}
