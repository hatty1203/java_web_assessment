package com.lemon.testcases;

import com.lemon.commons.BaseTest;
import com.lemon.pageobject.ClassDetailPage;
import com.lemon.pageobject.MainPage;
import com.lemon.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.*;

public class ClassTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        getWebDriver(Constants.WEBDRIVERTYPE);
        getMaxWindow();
        getUrl(Constants.URL_LOGIN);
        Login();
    }

    @Test(priority = 1)
    public void AddClassSuccess(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickAddClass();
        mainPage.typeClassVerifyCode(Constants.ADDCLASSCODE);
        mainPage.clickAdd();
        Assert.assertEquals(mainPage.getMesg(),"加入课堂成功");
    }

    @Test(priority = 2)
    public void enterClass(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.enterClass();
        ClassDetailPage classDetailPage = new ClassDetailPage(webDriver);
        Assert.assertEquals(classDetailPage.getClassText(),Constants.CLASSNAME);
    }

    @Test(dataProvider = "getCheckOutClassDatas",priority = 3)
    public void checkOutClassSuccess(String pwd, String errMsg){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickMore();
        mainPage.clickCheckOut();
        mainPage.typePWD2Verify(pwd);
        mainPage.clickConfirmCheckOut();
        Assert.assertEquals(mainPage.getMesg(),errMsg);
    }

    @Test(priority = 4)
    public void AddClassFail(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickAddClass();
        mainPage.typeClassVerifyCode("000000");
        mainPage.clickAdd();
        Assert.assertEquals(mainPage.getMesg(),"该加课码不存在或者已经失效");
    }

    @Test(priority = 5)
    public void AddClassDuplicate() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        for(int i=0;i<2;i++) {
            mainPage.clickAddClass();
            mainPage.typeClassVerifyCode(Constants.ADDCLASSCODE);
            mainPage.clickAdd();
            Thread.sleep(1000);
        }
        Assert.assertEquals(mainPage.getMesg(),"你已经选过此课程");
    }

    @DataProvider
    public Object[][] getCheckOutClassDatas(){
        Object[][] datas = {
                {"123","密码错误"},
                {Constants.PWD,"课程退课成功"}
        };
        return datas;
    }
    @AfterMethod
    public void tearDown(){
        browserQuit();
    }

}
