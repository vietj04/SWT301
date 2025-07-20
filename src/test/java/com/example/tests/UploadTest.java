package com.example.tests;

import com.example.pages.UploadPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class UploadTest {
    private WebDriver driver;
    private UploadPage uploadPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");
        uploadPage = new UploadPage(driver);
    }

    @Test
    public void testUploadFile() {
        // Đường dẫn tuyệt đối tới file test-image.jpg
        File file = new File("src/test/resources/test-image.jpg");
        String absolutePath = file.getAbsolutePath();
        uploadPage.uploadFile(absolutePath);
        // Kiểm tra tên file hiển thị đúng sau khi upload
        String uploadedFileName = uploadPage.getUploadedFileName();
        Assert.assertEquals(uploadedFileName, "test-image.jpg", "Tên file upload không đúng!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 