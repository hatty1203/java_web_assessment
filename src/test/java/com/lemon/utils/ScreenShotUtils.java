package com.lemon.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {
    public static byte[] takeScreenShot(WebDriver webDriver){
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        byte[] arr = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return arr;
    }
}
