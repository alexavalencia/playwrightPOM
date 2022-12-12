package com.saucedemo.driver;

import com.microsoft.playwright.*;

public class DriverFactory {
    private static Playwright playwright;
    private static Page page;
    private static Browser browser;
    private static BrowserContext browserContext;

    public static void createDriver(String browserName, boolean headless){
        playwright=Playwright.create();
        switch (browserName){
            case "chrome":{
                browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));

            }
            case "firefox":{
                browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(headless));

            }
            case "safari":{
                browser= playwright.webkit().launch(new BrowserType.LaunchOptions().setChannel("webkit").setHeadless(headless));

            }

        }
        browserContext= browser.newContext(new Browser.NewContextOptions());
        page= browserContext.newPage();

    }

    public static Page getPage() {
        return page;
    }

    public static void closeDriver(){
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
