package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import com.lemon.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By account = By.xpath("//input[@name='account']");
    private By password = By.xpath("//input[@name='pass']");
    private By login = By.xpath("//div[@class='padding-cont pt-login']//a[text()='登录']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void typeAccount(String value){
        type(account, value);
    }

    public void typePassword(String value){
        type(password, value);
    }

    public void clickLogin(){
        click(login);
    }
}
