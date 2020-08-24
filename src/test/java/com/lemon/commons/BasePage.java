package com.lemon.commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private Logger logger = Logger.getLogger(BasePage.class);
    public WebDriver webDriver;

    public BasePage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public WebElement isVisible(By by){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,15);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement isClickable(By by){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void click(By by){
        isClickable(by).click();
        logger.info("点击了元素【"+by+"】");

    }

    public void type(By by, String value){
        isVisible(by).clear();
        isVisible(by).sendKeys(value);
        logger.info("在元素【"+by+"】输入了数据【"+value+"】");
    }

    public void uploadFile(By by, String filePath){
        isVisible(by).sendKeys(filePath);
        logger.info("在元素【"+by+"】上传了文件【"+filePath+"】");
    }


    public String getElementText(By by){
        String elementText = isVisible(by).getText();
        logger.info("获取元素【"+by+"】文本值【"+elementText+"】");
        return elementText;
    }
}
