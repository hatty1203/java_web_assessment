package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By addClassBtn = By.xpath("//div[text()='+ 加入课程']");
    private By classVerifyCode = By.xpath("//input[@placeholder='请输入课程加课验证码']");
    private By addBtn = By.xpath("//li[@class='cjli2']/a");
    private By Meg = By.xpath("//div[@class='gTips']/span");
    private By moreBtn = By.xpath("//a[text()='Java-Web阶段考核项目专用']//parent::strong/following-sibling::a");
    private By checkOutClass = By.xpath("//a[text()='退课']");
    private By pwdVerify = By.xpath("//input[@type='password']");
    private By confirmCheckOut = By.xpath("//input[@type='password']/parent::div/following-sibling::div//a[text()='退课']");
    private By class_Name = By.xpath("//a[text()='Java-Web阶段考核项目专用']");


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickAddClass(){
        click(addClassBtn);
    }

    public void typeClassVerifyCode(String value){
        type(classVerifyCode, value);
    }

    public void clickAdd(){
        click(addBtn);
    }
    public String getMesg(){
        return getElementText(Meg);
    }

    public void clickMore(){
        click(moreBtn);
    }

    public void clickCheckOut(){
        click(checkOutClass);
    }

    public void typePWD2Verify(String value){
        type(pwdVerify,value);
    }

    public void clickConfirmCheckOut(){
        click(confirmCheckOut);
    }

    public void enterClass(){
        click(class_Name);
    }


}
