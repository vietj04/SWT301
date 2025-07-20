package com.example.tests;

import com.example.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginFail() {
        loginPage.login("invalidUser", "invalidPass");
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Invalid username or password!"), "Thông báo lỗi không đúng!");
    }

    @Test
    public void loginSuccess() {
        // Thay đổi thông tin tài khoản hợp lệ bên dưới nếu cần
        String username = "testuser";
        String password = "Test@1234";
        loginPage.login(username, password);
        // Kiểm tra url chuyển sang /profile hoặc sự xuất hiện của element userName-value
        boolean isSuccess = false;
        try {
            isSuccess = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(driver1 -> driver1.getCurrentUrl().contains("profile") ||
                    driver1.findElements(org.openqa.selenium.By.id("userName-value")).size() > 0);
        } catch (Exception ignored) {}
        Assert.assertTrue(isSuccess, "Không chuyển sang trang profile hoặc không xuất hiện userName-value sau khi đăng nhập thành công!");
    }

    // Có thể bổ sung test case login thành công nếu có tài khoản hợp lệ

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 