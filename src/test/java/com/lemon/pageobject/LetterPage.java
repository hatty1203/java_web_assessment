package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LetterPage extends BasePage {

    private By contacter = By.className("classp");
    private By searchContacter = By.xpath("//input[@placeholder='搜索学号、姓名']");
    private By chooseContacter = By.xpath("//span[text()='Java-Web阶段考核项目专用']/parent::dt/following-sibling::dd");
    private By letterTextWindow = By.xpath("//div[@class='m-text']/textarea");
    private By sendBtn = By.xpath("//a[text()='发送']");

    public LetterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickContacer(){
        click(contacter);
    }

    public void typeContacter(String value){
        type(searchContacter, value);
    }

    public void chooseContacter(){
        click(chooseContacter);
    }

    public void typeLetters(String value){
        type(letterTextWindow,value);
    }

    public void clickSend(){
        click(sendBtn);
    }
}
