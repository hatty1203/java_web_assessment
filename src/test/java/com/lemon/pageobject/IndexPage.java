package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {

    private By login_btn = By.cssSelector(".login");

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void clickLogin(){
        click(login_btn);
    }

}
