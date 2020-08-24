package com.lemon.commons;

import com.lemon.pageobject.ClassDetailPage;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.pageobject.MainPage;
import com.lemon.utils.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

public class BaseTest {
    private Logger logger = Logger.getLogger(BaseTest.class);
    public WebDriver webDriver;

    public void getWebDriver(String webType){
        if("chrome".equalsIgnoreCase(webType)){
            System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            ChromeDriver chromeDriver = new ChromeDriver();
            webDriver = chromeDriver;
            logger.info("======================chrome浏览器=================================");
        }else if("firefox".equalsIgnoreCase(webType)){
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            System.setProperty("webdriver.firefox.bin","D:/sofware/firefox/firefox.exe");
            FirefoxDriver fd = new FirefoxDriver();
            webDriver = fd;
            logger.info("======================firefox浏览器=================================");
        }
    }

    public void getUrl(String url){
        logger.info("打开url");
        webDriver.get(url);

    }

    public void getMaxWindow(){
        logger.info("浏览器最大化");
        webDriver.manage().window().maximize();
    }

    public String getTitleText(){
        logger.info("获取页面标题");
        return webDriver.getTitle();
    }

    public void browserQuit(){
        logger.info("浏览器关闭");
        webDriver.quit();
    }

    public void Login(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.typeAccount(Constants.ACCOUNT);
        loginPage.typePassword(Constants.PWD);
        loginPage.clickLogin();
        logger.info("登录课堂派");
    }

    public void enterClass(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.enterClass();
        logger.info("进入对应课程");
    }

    public void enterUpPage() {
        ClassDetailPage classDetailPage = new ClassDetailPage(webDriver);
        classDetailPage.clickHomeworkTab();
        classDetailPage.clickUpLoad(Constants.HOMEWORKNAME);
        logger.info("进入上传作业页面");
    }

    public void addClass(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickAddClass();
        mainPage.typeClassVerifyCode(Constants.ADDCLASSCODE);
        mainPage.clickAdd();
    }

    public void switchHandle(String targetTitle) {
        Set<String> handles = webDriver.getWindowHandles();
        for (String handle : handles) {
            if(!getTitleText().contains(targetTitle)){
                webDriver.switchTo().window(handle);
                logger.info("切换句柄到目标句柄");
            }
        }
    }

    public String getPageSourceText(){
        logger.info("获取页面源文件");
        return webDriver.getPageSource();
    }
}
