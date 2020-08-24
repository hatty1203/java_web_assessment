package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassDetailPage extends BasePage {
    private By classTitle = By.tagName("h1");
    private By homeworkTab = By.xpath("//a[text()='作业']");
    private By moreFunctionBtn = By.xpath("//div[@class='nav nav-clear clearfix course-nav']/ul/li[1]/a");
    private By leftNavLetter = By.className("leftnavletter");

    public ClassDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getClassText(){
        return getElementText(classTitle);
    }

    public void clickHomeworkTab(){
        click(homeworkTab);
    }

    public void clickUpLoad(String homeworkName){
        By upLoadBtn =
                By.xpath("//a[text()='" + homeworkName + "']/parent::h3/parent::div/following-sibling::div/a");
        click(upLoadBtn);
    }

    public void clickMoreFunction(){
        click(moreFunctionBtn);
    }

    public void clickLeaveNavLetter(){
        click(leftNavLetter);
    }
}
