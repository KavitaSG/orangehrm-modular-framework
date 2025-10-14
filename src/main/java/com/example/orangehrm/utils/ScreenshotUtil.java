package com.example.orangehrm.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String namePrefix) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destDir = Paths.get("target", "screenshots").toString();
            new File(destDir).mkdirs();
            String destPath = Paths.get(destDir, namePrefix + "_" + timestamp + ".png").toString();
            FileUtils.copyFile(src, new File(destPath));
            return destPath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
