package com.soucedemo.tests;

import static com.saucedemo.driver.DriverFactory.createDriver;
import static com.saucedemo.driver.DriverFactory.getPage;
import static com.saucedemo.driver.DriverFactory.closeDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.microsoft.playwright.Page;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.*;

import java.nio.file.Paths;

public class LoginTest {

    LoginPage loginPage;

    @BeforeTest
    @Parameters({"url","browser","headless"})
    public void setUp(@Optional("https://www.saucedemo.com/")  String url, @Optional("chrome")String browser, @Optional("false") String headless){
        createDriver(browser,Boolean.getBoolean(headless));
        getPage().navigate(url);
    }
     @Test
     public void loginTest(){
        loginPage=  new LoginPage(getPage());
         getPage().screenshot(new Page.ScreenshotOptions()
                 .setPath(Paths.get(getPage().title()+".png")));
        loginPage.logInWith("standard_user","secret_sauce");
        assertEquals(getPage().title(),"Swag Labs");
         getPage().screenshot(new Page.ScreenshotOptions()
                 .setPath(Paths.get(getPage().title()+".png")));
         assertTrue(loginPage.isProductTitleVisible());

     }


    @AfterTest
    public void tearDown(){
        closeDriver();
    }
}
