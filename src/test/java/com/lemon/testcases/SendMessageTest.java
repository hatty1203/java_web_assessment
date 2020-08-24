package com.lemon.testcases;

import com.lemon.commons.BaseTest;
import com.lemon.pageobject.ClassDetailPage;
import com.lemon.pageobject.LetterPage;
import com.lemon.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SendMessageTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        getWebDriver(Constants.WEBDRIVERTYPE);
        getMaxWindow();
        getUrl(Constants.URL_LOGIN);
        Login();
        enterClass();
    }


    @Test
    public void sendMessageSuccess(){
        ClassDetailPage classDetailPage = new ClassDetailPage(webDriver);
        classDetailPage.clickMoreFunction();
        classDetailPage.clickLeaveNavLetter();
        switchHandle("私信");
        LetterPage letterPage = new LetterPage(webDriver);
        letterPage.clickContacer();
        letterPage.typeContacter("歪歪");
        letterPage.chooseContacter();
        String letters = "这是一个web自动化的私信-Jenkins";
        letterPage.typeLetters(letters);
        letterPage.clickSend();
        String pageSource = getPageSourceText();
        boolean flag = false;
        if(pageSource.contains(letters)){
            flag = true;
        }
        Assert.assertTrue(flag);
    }


    @AfterMethod
    public void tearDown(){
        browserQuit();
    }
}
