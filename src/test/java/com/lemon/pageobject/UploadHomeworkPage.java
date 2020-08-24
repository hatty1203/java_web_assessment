package com.lemon.pageobject;

import com.lemon.commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadHomeworkPage extends BasePage {

    private By addHomework = By.xpath("//div[text()='添加作业文件']/following-sibling::div/input");
    private By submitBtn = By.xpath("//a[text()='提交']");
    private By click4Comment = By.xpath("//span[contains(text(),'作业留言')]");
    private By comment = By.id("comment");
    private By saveBtn = By.xpath("//a[text()='保存']");
    private By submitSuccessMesg = By.className("weui_dialog_bd");
    private By closeMesgBtn = By.xpath("//div[@class='weui_dialog_ft']/a"); //知道了按键
    private By statusOfHomework = By.xpath("//div[@class='status fr']/span");
    private By updateHomework = By.xpath("//div[@class='sc-tj fl']/a[1]");
    private By confirmBtn = By.xpath("//h3[text()='更新作业？']/parent::div/following-sibling::div//a[text()='确定']");
    private By updateBtn = By.xpath("//div[@class='sc-tj fl']/a[2]");
    private By commitText = By.className("s2");

    public UploadHomeworkPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void uploadFile(String filePath){
        uploadFile(addHomework,filePath);
    }

    public void clickSubmit(){
        click(submitBtn);
    }

    public void clickComment(){
        click(click4Comment);
    }

    public String getSubmitMesg(){
        return getElementText(submitSuccessMesg);
    }

    public void clickGetItBtn(){
        click(closeMesgBtn);
    }

    public String getStatusOfHomework(){
       return getElementText(statusOfHomework);
    }

    public void clickUpdate(){
        click(updateHomework);
    }

    public void clickUpdateBtn(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(updateBtn);
    }
    public void clickConfirmBtn(){
        click(confirmBtn);
    }
    public void typeComment(String comments){
        type(comment,comments);
    }

    public void clickSave(){
        click(saveBtn);
    }

    public String getCommentText(){

        return getElementText(commitText);
    }

}
