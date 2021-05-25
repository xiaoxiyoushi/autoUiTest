package com.beilie.test.open.hunters.pages;

import com.beilie.core.exceptions.BusinessException;
import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.UIPage;
import com.beilie.test.seleniums.core.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatePositionPage extends Public<CreatePositionPage> {

    public  int generateNumber(int n) {
        Random r = new Random();
        int num = (int) (Math.random() * n );
        return num;
    }

    /**
     * 判定当前页面是已经加载成功的；
     */
    public Boolean isLoad() {
        return Boolean.TRUE;
    }

    /**
     * 断言是否已经完成创建职位页面的加载；
     */
    public CreatePositionPage assertLoaded() {
        if(Boolean.TRUE.equals(this.isLoad())){
            return this;
        }
        throw new BusinessException("页面加载失败。");
    }

    /*
    添加企业
     */
    public Element element(int i,int j){

        Element element=this.findByClassName("mgt15").findListByClassName("ivu-row").get(i)
                            .findListByClassName("ivu-col").get(j);

        return element;
    }

    public CreatePositionPage addCorporate1() throws InterruptedException{

        this.findByClassName("color147").click();
        this.sleepForSeconds(1);

        //客户名称
        String shieldingKeywords1=shieldingKeywords1();
        element(0,0).findByTagName("input").sendKeys(shieldingKeywords1);

        //客户对外显示名称
        //String ocn= Public.generateString(6);
        String shieldingKeywords2=shieldingKeywords2();
        element(0,1).findByTagName("input").sendKeys(shieldingKeywords2);

        //点击所属行业
        element(1,0).findByTagName("input").click();
        this.findByCssSelector("#plugin > div > div.allIndustry.clearfix.flex > div > ul > li:nth-child(2) > span").click();
        this.findByCssSelector("#plugin > div > div.industruWrapFooter > button.ef-btn.ef-confirm-btn").click();
        this.sleepForSeconds(1);

        //所在地
        element(1,1).findByTagName("input").click();
        this.selectElems(0).findListByTagName("li").get(3).click();
        this.findById("stab.level").findListByTagName("li").get(0).click();
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        this.sleepForSeconds(1);

        //企业性质
        element(2,0).findByTagName("span").click();
        this.findListByClassName("ivu-select-dropdown-list").get(0).findListByTagName("li").get(1).click();
        this.sleepForSeconds(1);

        //企业规模
        element(2,1).findByTagName("span").click();
        this.findListByClassName("ivu-select-dropdown-list").get(1).findListByTagName("li").get(1).click();
        this.sleepForSeconds(1);

        //企业介绍
        String shieldingKeywords3=shieldingKeywords3();
        element(3,0).findByTagName("textarea")
                .sendKeys(shieldingKeywords3+"+"+"创海信息是一家致力于智能建筑弱电工程的技术型公司，在弱电安防系统等方面拥有丰富的专业知识。我们以创新的技术，坚持不懈的为客户提供全方面支持！");
        this.sleepForSeconds(1);

        //点击【保存客户信息】
        this.findByClassName("saveBtn").click();
        this.sleepForSeconds(1);

        //添加所属部门
        this.findById("setInfo").findByTagName("input").sendKeys("业务部");
        //this.findByClassName("addDepartBtn").findByTagName("img").click();
        this.findByCssSelector("#setInfo > div.addDepartBtn > div > img").click();

        return this;
    }

    public CreatePositionPage addCorporate2() throws InterruptedException{

        this.findByClassName("color147").click();
        this.sleepForSeconds(1);

        //客户名称
        element(0,0).findByTagName("input").sendKeys("上海创海信息技术有限公司");

        //客户对外显示名称
        String ocn= Public.generateString(6);
        element(0,1).findByTagName("input").sendKeys("上海****有限公司"+ocn);

        //点击所属行业
        element(1,0).findByTagName("input").click();
        this.findByCssSelector("#plugin > div > div.allIndustry.clearfix.flex > div > ul > li:nth-child(2) > span").click();
        this.findByCssSelector("#plugin > div > div.industruWrapFooter > button.ef-btn.ef-confirm-btn").click();
        this.sleepForSeconds(1);

        //所在地
        element(1,1).findByTagName("input").click();
        this.selectElems(0).findListByTagName("li").get(3).click();
        this.findById("stab.level").findListByTagName("li").get(0).click();
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        this.sleepForSeconds(1);

        //企业性质
        element(2,0).findByTagName("span").click();
        this.findListByClassName("ivu-select-dropdown-list").get(0).findListByTagName("li").get(1).click();
        this.sleepForSeconds(1);

        //企业规模
        element(2,1).findByTagName("span").click();
        this.findListByClassName("ivu-select-dropdown-list").get(1).findListByTagName("li").get(1).click();
        this.sleepForSeconds(1);

        //企业介绍
        element(3,0).findByTagName("textarea")
                .sendKeys("创海信息是一家致力于智能建筑弱电工程的技术型公司，在弱电安防系统、住宅智能化系统、机房工程等方面拥有丰富的专业知识。我们以创新的技术，坚持不懈的为客户提供全方面支持，并以出众的品质，获得客户的信赖和业内的认可！");
        this.sleepForSeconds(1);

        //点击【保存客户信息】
        this.findByClassName("saveBtn").click();
        this.sleepForSeconds(1);

        //添加所属部门
        this.findById("setInfo").findByTagName("input").sendKeys("业务部");
        this.findByClassName("addDepartBtn").findByTagName("img").click();

        return this;
    }

    /*
    选择企业基本信息
     */
    public CreatePositionPage clickCorporateInformation(){
        this.findByCssSelector("#selectInput > input").click();
       return this;
    }
    public CreatePositionPage selectCorporateInformation(){
        this.findByCssSelector("#selectList > div.list.clearfix > ul > li:nth-child(1)").click();
        return this;
    }
    public CreatePositionPage clickDepartment(){
        String attribute=this.findByClassName("w400").findByTagName("input").getAttribute("type");
        if (attribute.equals("hidden")){//选部门
            this.findByCssSelector("#statusA > div.ivu-select-selection > div > span").click();
            this.findByCssSelector("#statusA > div.ivu-select-dropdown > ul.ivu-select-dropdown-list").click();
        }else {//新添部门
            this.findById("setInfo").findByTagName("input").sendKeys("业务部");
            this.findByClassName("addDepartBtn").findByTagName("img").click();
        }

        return this;
    }
    public CreatePositionPage selectDepartment(){
        this.findByCssSelector("#statusA > div.ivu-select-dropdown > ul.ivu-select-dropdown-list").click();
        return this;
    }
    /*
    填写职位基本信息
     */
    String pbiID="//*[@id=\"positionBasicInfo\"]";
    public Element elem(int i){
       Element element=this.findById("positionBasicInfo").findListByTagName("div").get(i);
        return element;
    }

    //职位名称
    public CreatePositionPage writePosition(){

        ArrayList<String> arrayList1=new ArrayList<String>();
        ArrayList<String> arrayList2=new ArrayList<String>();

        arrayList1.add("求购");
        arrayList1.add("出售");
        arrayList1.add("专卖");
        arrayList1.add("有偿提供");
        arrayList1.add("售");
        arrayList1.add("有偿捐献");
        arrayList1.add("有偿售");
        arrayList1.add("卖");
        arrayList1.add("有偿卖");
        arrayList1.add("提供");
        arrayList1.add("供应");
        arrayList1.add("收");
        arrayList1.add("有偿献");

        arrayList2.add("骨髓");
        arrayList2.add("胰腺");
        arrayList2.add("脾脏");
        arrayList2.add("眼角膜");
        arrayList2.add("肾器官");
        arrayList2.add("shen源");
        arrayList2.add("肾");
        arrayList2.add("肾源");
        arrayList2.add("肾脏");
        arrayList2.add("肝脏");
        arrayList2.add("肝源");
        arrayList2.add("心脏");

          int n1=generateNumber(13);
          int n2=generateNumber(12);
          String str=arrayList1.get(n1);
          String str1=str+arrayList2.get(n2);

        elem(1).findByTagName("input").sendKeys(str1);
        return this;
    }

    //职位名称
    public CreatePositionPage writePosition(String positionName){
        elem(1).findByTagName("input").sendKeys(positionName);
        return this;
    }

    //选择职能
    public CreatePositionPage clickFunction(){
        this.findByCssSelector("#positionBasicInfo > div:nth-child(2) > div:nth-child(2) > div > div > div > div > div > input").click();
        return this;
    }
    /*一级*/
    public Element selectElems(int i) {
        Element elements = this.findByClassName("dialog-box").findListByTagName("ul").get(i);
        return elements;
    }
    public CreatePositionPage functionProfessional() {
        //this.findByClassName("dialog-box").findListByTagName("ul").get(1).findListByTagName("li").get(0).click();
        this.selectElems(1).findListByTagName("li").get(0).click();
        return this;
    }
    /*二级*/
    public CreatePositionPage functionIt() {
        //this.findByCssSelector("#stab\\2e level > li:nth-child(2)").click();
        this.findByClassName("dialog-box").findByTagName("ul").findListByTagName("li").get(1).click();
        return this;
    }
    /*三级*/
    public CreatePositionPage functionEngineer() {
        this.findByClassName("dialog-box").findByTagName("ul").findListByTagName("li").get(2).click();
        return this;
    }
    public CreatePositionPage submitFunction() {
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        return this;
    }
    //汇报对象
    public CreatePositionPage writeLeader(String leader){
        this.findByXPath(pbiID+"/div[3]/div[1]").findByTagName("input").sendKeys(leader);
        return this;
    }
    public CreatePositionPage writeLeader(){
        String shieldingKeywords4=shieldingKeywords4();
        this.findByXPath(pbiID+"/div[3]/div[1]").findByTagName("input").sendKeys(shieldingKeywords4);
        return this;
    }
    //招聘人数
    public CreatePositionPage writeRecruits(String number){
        this.findByXPath(pbiID+"/div[3]/div[2]").findByTagName("input").sendKeys(number);
        return this;
    }
    //工作地点
    public CreatePositionPage clickWorkPlace(){
        this.findByCssSelector("#positionBasicInfo > div:nth-child(4) > div:nth-child(1) > div > div > div:nth-child(1) > div > div > input").click();
        return this;
    }
    public Element selectElems1(int i) {
        Element elements = this.findByClassName("tab-body functionName").findListByTagName("ul").get(i);
        return elements;
    }
    /*public CreatePositionPage location1() {
        this.selectElems(0).findListByTagName("li").get(7).click();
        return this;
    }*/

    /*public CreatePositionPage location2() {
        this.findById("stab.level").findListByTagName("li").get(3).click();
        return this;
    }*/

    /*public CreatePositionPage submitlocation() {
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        return this;
    }*/
    //下属人数
    public CreatePositionPage writeSubordinates(String number){
        this.findByXPath(pbiID+"/div[4]/div[2]").findByTagName("input").sendKeys(number);
        return this;
    }
    //税前年薪
    public CreatePositionPage writeSalary1(String n1){
        this.findByXPath(pbiID+"/div[5]/div/div[1]").findByTagName("input").sendKeys(n1);
        return this;
    }
    public CreatePositionPage writeSalary2(String n2){
        this.findByXPath(pbiID+"/div[5]/div/div[2]").findByTagName("input").sendKeys(n2);
        return this;
    }
    //福利待遇
    public CreatePositionPage clickWelfare1(){
        this.findByXPath(pbiID+"/div[6]/div/div/div/label[1]").findByTagName("input").click();
        return this;
    }
    public CreatePositionPage clickWelfare2(){
        this.findByXPath(pbiID+"/div[6]/div/div/div/label[2]").findByTagName("input").click();
        return this;
    }
    /*
    职位要求
     */
    //年龄要求
    String prID="//*[@id=\"positionRequire\"]";
    public CreatePositionPage writeMinage(String minAge){
        this.findByXPath(prID+"/div[2]/div[1]/div[1]").findByTagName("input").sendKeys(minAge);
        return this;
    }
    public CreatePositionPage writeMaxage(String maxAge){
        this.findByXPath(prID+"/div[2]/div[1]/div[2]").findByTagName("input").sendKeys(maxAge);
        return this;
    }
    //学历要求
    public CreatePositionPage selectDegree(){
        //this.findById("efDegreeBg").findByTagName("span").click();
        this.findByCssSelector("#positionRequire > div:nth-child(3) > div:nth-child(1) > div > div > div > div > div.ivu-select-selection > div > span").click();
        return this;
    }
    /*public Element elems() {
        Element elements = this.findByCssSelector("#efDegreeBg > form > div > div > div:nth-child(1) > div > div > div.ivu-select-dropdown > ul.ivu-select-dropdown-list");
        return elements;
    }*/
    public CreatePositionPage degreeBachelor() {
        //this.elems().findListByTagName("li").get(6).click();

        this.findByCssSelector("#positionRequire > div:nth-child(3) > div:nth-child(1) > div > div > div > div > div.ivu-select-dropdown > ul.ivu-select-dropdown-list > li:nth-child(7)").click();
        return this;
    }
    //工作年限
    public CreatePositionPage writeYears(String years){
        this.findByCssSelector("#positionRequire > div:nth-child(3) > div:nth-child(2) > div > div > div > input").sendKeys(years);
        return this;
    }
    //所属行业
    public CreatePositionPage clickIndustry(){
        this.findByCssSelector("#positionRequire > div:nth-child(4) > div:nth-child(2) > div > div > div > div > div > input").click();
        return this;
    }
    public CreatePositionPage clickInternet(){
        this.findByCssSelector("#plugin > div > div.allIndustry.clearfix.flex > div > ul > li:nth-child(2) > span").click();
        return this;
    }
    public CreatePositionPage submitIndustry(){
        this.findByCssSelector("#plugin > div > div.industruWrapFooter > button.ef-btn.ef-confirm-btn").click();
        return this;
    }
    //职位描述
    public CreatePositionPage jobDescription(){
        String context="为客户公司提供中国新经济市场和资本市场的分析与预测，包括新经济市场规模、投资银行业务、资产管理业务以及证券承销业务,包括新经济市场规模、投资银行业务、资产管理业务以及证券承销业务。";
        this.findByCssSelector("#positionRequire > div.enterprise.mb20.ivu-row > div > div > div > div > textarea").sendKeys(context);
        return this;
    }

    public CreatePositionPage writeJob(){
        String shieldingKeywords5=shieldingKeywords5();
        String context="为客户公司提供中国新经济市场和资本市场的分析与预测，包括新经济市场规模、投资银行业务、资产管理业务以及证券承销业务,包括新经济市场规模、投资银行业务、资产管理业务以及证券承销业务。";
        this.findByCssSelector("#positionRequire > div.enterprise.mb20.ivu-row > div > div > div > div > textarea").sendKeys(shieldingKeywords5+"+"+context);
        return this;
    }

    //职位描述，校验屏蔽关键词
    public CreatePositionPage writeJob1(){

        ArrayList<String> arrayList1=new ArrayList<String>();
        ArrayList<String> arrayList2=new ArrayList<String>();

        arrayList1.add("求购");
        arrayList1.add("出售");
        arrayList1.add("专卖");
        arrayList1.add("有偿提供");
        arrayList1.add("售");
        arrayList1.add("有偿捐献");
        arrayList1.add("有偿售");
        arrayList1.add("卖");
        arrayList1.add("有偿卖");
        arrayList1.add("提供");
        arrayList1.add("供应");
        arrayList1.add("收");
        arrayList1.add("有偿献");

        arrayList2.add("骨髓");
        arrayList2.add("胰腺");
        arrayList2.add("脾脏");
        arrayList2.add("眼角膜");
        arrayList2.add("肾器官");
        arrayList2.add("shen源");
        arrayList2.add("肾");
        arrayList2.add("肾源");
        arrayList2.add("肾脏");
        arrayList2.add("肝脏");
        arrayList2.add("肝源");
        arrayList2.add("心脏");


          /*StringBuffer s=new StringBuffer();

        for(int i=0;i<arrayList1.size();i++){
            int n=generateNumber(12);
            String str=arrayList1.get(i);
            String str1=str+arrayList2.get(n);

            s.append(str1);

        }*/

        //String context="为客户公司提供中国新经济市场和资本市场的分析与预测，包括新经济市场规模、投资银行业务、资产管理业务以及证券承销业务,包括新经济市场规模、投资银行业务、资产管理业务以及证券承销业务。";
        this.findByCssSelector("#positionRequire > div.enterprise.mb20.ivu-row > div > div > div > div > textarea").sendKeys("");

        return this;
    }

    //是否通过谈聘网发布
    /*public CreatePositionPage clickNo(){
        this.findByCssSelector("#createPositionBg > div > form > div:nth-child(5) > div:nth-child(2) > div > div > div > div > label:nth-child(2) > span").click();
        return this;
    }*/
    //截止日期
    public CreatePositionPage clickDeadline(){
        this.findByCssSelector("#deadlineId > div.ivu-date-picker-rel > div > input").click();
        return this;
    }
    public CreatePositionPage clickDeadline1(){
        this.findByCssSelector("#deadlineId > div.ivu-select-dropdown > div > div > div > div.ivu-date-picker-header > span.ivu-picker-panel-icon-btn.ivu-date-picker-next-btn.ivu-date-picker-next-btn-arrow > i").click();
        return this;
    }
    public CreatePositionPage clickDeadline2(){
        this.findByCssSelector("#deadlineId > div.ivu-select-dropdown > div > div > div > div:nth-child(2) > div > span:nth-child(15)").click();
        return this;
    }
    //协议
    public CreatePositionPage clickProtocol(){
        this.findByCssSelector("#createPositionBg > div > form > div:nth-child(5) > div:nth-child(4) > div > div > div > div > label > span > input").click();
        return this;
    }
    //点击创建职位
    public CreatePositionPage submitPosition(){
        this.findByCssSelector("#createPositionBg > div > form > div:nth-child(6) > div > div > button.ivu-btn.ivu-btn-default.saveBtn").click();
        return this;
    }
    //点击提示的确定按钮
    public CreatePositionPage clickPrompt(){
        this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-footer > button").click();
        return this;
    }

    /*
    编辑审核失败的职位，点击提交按钮
     */
    public CreatePositionPage submitPosition1(){
        this.findByCssSelector("#createPositionBg > div > form > div:nth-child(6) > div > div > button").click();
        return this;
    }
    /*
    编辑审核失败的职位，点击提交按钮后，点击提示框的 确定按钮
     */
    public CreatePositionPage clickQueDing(){
        this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-footer > button").click();
        return this;
    }

    //屏蔽关键词
    public String shieldingKeywords1(){

        ArrayList<String> arrayList1=new ArrayList<String>();
        ArrayList<String> arrayList2=new ArrayList<String>();

        arrayList1.add("卖");
        arrayList1.add("出售");
        arrayList1.add("供应");
        arrayList1.add("直销");
        arrayList1.add("订购");
        arrayList1.add("提供");
        arrayList1.add("批发");
        arrayList1.add("销售");
        arrayList1.add("转让");
        arrayList1.add("专卖");

        arrayList2.add("乳胶人皮面具");
        arrayList2.add("仿真硅胶面具");
        arrayList2.add("硅胶人皮");
        arrayList2.add("人皮面具");
        arrayList2.add("GFX面具");
        arrayList2.add("硅胶面具");
        arrayList2.add("高仿真人皮面具");
        arrayList2.add("易容面具");
        arrayList2.add("高仿真脸皮");

        int n1=generateNumber(10);
        int n2=generateNumber(9);
        String str=arrayList1.get(n1);
        String str1=str+arrayList2.get(n2);

        return str1;
    }

    public String shieldingKeywords2(){

        ArrayList<String> arrayList1=new ArrayList<String>();
        ArrayList<String> arrayList2=new ArrayList<String>();

        arrayList1.add("DIY");
        arrayList1.add("制作");
        arrayList1.add("自制");
        arrayList1.add("组装");
        arrayList1.add("售");

        arrayList2.add("型材吹");
        arrayList2.add("铝管吹");
        arrayList2.add("吹尘");
        arrayList2.add("快排");
        arrayList2.add("链子枪");
        arrayList2.add("灭火吹");
        arrayList2.add("火柴枪");
        arrayList2.add("打火机吹");
        arrayList2.add("减震吹");
        arrayList2.add("空气枪");
        arrayList2.add("链条枪");

        int n1=generateNumber(5);
        int n2=generateNumber(11);
        String str=arrayList1.get(n1);
        String str1=str+arrayList2.get(n2);

        return str1;
    }

    public String shieldingKeywords3(){

        ArrayList<String> arrayList1=new ArrayList<String>();
        ArrayList<String> arrayList2=new ArrayList<String>();

        arrayList1.add("提供");
        arrayList1.add("批发");
        arrayList1.add("销售");
        arrayList1.add("购买");
        arrayList1.add("货到付款");
        arrayList1.add("售");

        arrayList2.add("一字开锁工具");
        arrayList2.add("万能开锁器");
        arrayList2.add("万能开琐工具");
        arrayList2.add("万能钥匙");
        arrayList2.add("快开工具");
        arrayList2.add("万能拔锁器");
        arrayList2.add("电动开锁器");
        arrayList2.add("万能钥匙开锁器");
        arrayList2.add("一字锁强开工具");
        arrayList2.add("十字开锁工具");
        arrayList2.add("十字快开工具");
        arrayList2.add("开锁器");
        arrayList2.add("万能开锁工具");
        arrayList2.add("强开工具");
        arrayList2.add("一字强开工具");
        arrayList2.add("电子开锁器");
        arrayList2.add("锡纸快开工具");

        int n1=generateNumber(6);
        int n2=generateNumber(17);
        String str=arrayList1.get(n1);
        String str1=str+arrayList2.get(n2);

        return str1;
    }

    public String shieldingKeywords4(){

        ArrayList<String> arrayList1=new ArrayList<String>();
        ArrayList<String> arrayList2=new ArrayList<String>();

        arrayList1.add("出售");
        arrayList1.add("销售");
        arrayList1.add("提供");
        arrayList1.add("专卖");
        arrayList1.add("直销");
        arrayList1.add("供应");
        arrayList1.add("批发");
        arrayList1.add("订购");
        arrayList1.add("转让");
        arrayList1.add("求购");
        arrayList1.add("买卖");

        arrayList2.add("学生家长名录");
        arrayList2.add("车主数据");
        arrayList2.add("保健品客户资料");
        arrayList2.add("保险客户名单");
        arrayList2.add("客户资源");
        arrayList2.add("老板手机号码");
        arrayList2.add("老年人数据");
        arrayList2.add("客户数据");
        arrayList2.add("客户信息");
        arrayList2.add("老年人资料");
        arrayList2.add("联通客户资料");

        int n1=generateNumber(11);
        int n2=generateNumber(11);
        String str=arrayList1.get(n1);
        String str1=str+arrayList2.get(n2);

        return str1;
    }

    public String shieldingKeywords5(){

        ArrayList<String> arrayList1=new ArrayList<String>();
        ArrayList<String> arrayList2=new ArrayList<String>();

        arrayList1.add("销售");
        arrayList1.add("提供");
        arrayList1.add("订购");
        arrayList1.add("出售");
        arrayList1.add("专卖");
        arrayList1.add("直销");
        arrayList1.add("供应");
        arrayList1.add("批发");

        arrayList2.add("网络电视棒");
        arrayList2.add("成人版电视棒");
        arrayList2.add("USB电视棒成人版");
        arrayList2.add("成人影视棒");
        arrayList2.add("高清3d成人电视棒");
        arrayList2.add("高清成人电视棒");
        arrayList2.add("3D网络电视棒成人版");
        arrayList2.add("成人3d电视棒");
        arrayList2.add("成人3d网络电视棒");
        arrayList2.add("成人AV电视棒");
        arrayList2.add("成人电视棒");
        arrayList2.add("AV电视棒");


        int n1=generateNumber(11);
        int n2=generateNumber(11);
        String str=arrayList1.get(n1);
        String str1=str+arrayList2.get(n2);

        return str1;
    }
}
