package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;
    private final String USERNAME="#user-name";
    private final String PASSWORD = "#password";
    private final String LOGIN_BUTTON="#login-button";

    private final String TITLE_PRODUCTS="//span[contains(.,'Products')]";

    public LoginPage(Page page) {
        this.page = page;
    }

    private void setUseName(String userName){
        page.fill(USERNAME,userName);
    }
    private void setPassword(String password){
        page.fill(PASSWORD,password);
    }

    public void logInWith(String userName, String password){
        setUseName(userName);
        setPassword(password);
        page.click(LOGIN_BUTTON);
    }

    public boolean isProductTitleVisible(){
        return page.isVisible(TITLE_PRODUCTS);
    }

}
