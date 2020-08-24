package com.lemon.testcases;

import com.lemon.commons.BaseTest;
import com.lemon.pageobject.ClassDetailPage;
import com.lemon.pageobject.MainPage;
import com.lemon.pageobject.UploadHomeworkPage;
import com.lemon.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        getWebDriver(Constants.WEBDRIVERTYPE);
        getMaxWindow();
        getUrl(Constants.URL_LOGIN);
        Login();
        enterClass();
        enterUpPage();
    }

    @Test(priority = 1)
    public void checkStatusOfHomeWork(){
        UploadHomeworkPage uhp = new UploadHomeworkPage(webDriver);
        String status = uhp.getStatusOfHomework();
        Assert.assertEquals(status,"未完成");
    }

    @Test(priority = 2)
    public void leaveComments(){
        UploadHomeworkPage uhp = new UploadHomeworkPage(webDriver);
        uhp.clickComment();
        String comments = "这是一个作业留言";
        uhp.typeComment(comments);
        uhp.clickSave();
        String commentText = uhp.getCommentText();
        Assert.assertEquals(commentText,comments);
    }

    @Test(priority = 3)
    public void uploadHomeWorkSuccess(){
        UploadHomeworkPage uhp = new UploadHomeworkPage(webDriver);
        uhp.uploadFile(Constants.BASEDIR+"/src/test/resources/Image 1.png");
        uhp.clickSubmit();
        String submitMesg = uhp.getSubmitMesg();
        uhp.clickGetItBtn();
        String status = uhp.getStatusOfHomework();
        Assert.assertEquals(submitMesg,"作业提交成功");
        Assert.assertEquals(status,"已完成");
    }

    @Test(priority = 4)
    public void updateLeaveComments(){
        UploadHomeworkPage uhp = new UploadHomeworkPage(webDriver);
        uhp.clickUpdate();
        uhp.clickConfirmBtn();
        uhp.clickComment();
        String comments = "这是一个更新作业留言";
        uhp.typeComment(comments);
        uhp.clickSave();
        String commentText = uhp.getCommentText();
        Assert.assertEquals(commentText,comments);
    }


    @Test(priority = 5)
    public void updateHomeWorkSuccess(){
        UploadHomeworkPage uhp = new UploadHomeworkPage(webDriver);
        uhp.clickUpdate();
        uhp.clickConfirmBtn();
        uhp.uploadFile(Constants.BASEDIR+"/src/test/resources/Image 2.png");
        uhp.clickUpdateBtn();
        String submitMesg = uhp.getSubmitMesg();
        uhp.clickGetItBtn();
        String status = uhp.getStatusOfHomework();
        Assert.assertEquals(submitMesg,"作业提交成功");
        Assert.assertEquals(status,"已完成");
    }

    @AfterMethod
    public void tearDown(){
        browserQuit();
    }
}
