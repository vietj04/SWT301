package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends BasePage {
    private final By uploadInput = By.id("uploadFile");
    private final By uploadedFilePath = By.id("uploadedFilePath");

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String absoluteFilePath) {
        driver.findElement(uploadInput).sendKeys(absoluteFilePath);
    }

    public String getUploadedFileName() {
        String fullPath = getText(uploadedFilePath);
        // Trả về tên file cuối cùng
        if (fullPath == null || fullPath.isEmpty()) return "";
        return fullPath.substring(fullPath.lastIndexOf('\\') + 1);
    }
} 