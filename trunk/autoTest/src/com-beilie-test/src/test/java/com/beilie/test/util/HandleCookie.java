/*
package com.beilie.test.util;

import com.beilie.test.seleniums.core.sealed.WebDriverVendor;
//import com.mushishi.selenium.base.DriverBase;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class HandleCookie {
	public WebDriverVendor driver;
	public ProUtil pro;
	public HandleCookie(WebDriverVendor driver){
		this.driver = driver;
		pro = new ProUtil("cookie.properties");
	}
	public void setCookie(){
		String value = pro.getPro("apsid");
		Cookie cookie = new Cookie("apsid",value,"imooc.com","/",null);
		driver.setCookie(cookie);
	}
	*/
/**
	 * 获取cookie
	 * *//*

	public void writeCookie(){
		Set<Cookie> cookies = driver.getCookie();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("apsid")){
				pro.writePro(cookie.getName(), cookie.getValue());
			}
		}
	}
}
*/
