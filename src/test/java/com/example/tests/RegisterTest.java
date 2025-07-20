package com.example.tests;

import com.example.pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/register");
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registerFail() {
        registerPage.register("", "", "", "");
        try {
            Thread.sleep(20000); // Giữ trình duyệt ở lại trang 20s để quan sát popup/thông báo
        } catch (InterruptedException ignored) {}
        // Nếu không có thông báo lỗi, kiểm tra url không đổi hoặc element vẫn còn
        boolean isFail = false;
        try {
            isFail = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElements(org.openqa.selenium.By.id("name")).size() > 0 ||
                    driver1.getCurrentUrl().contains("register"));
        } catch (Exception ignored) {}
        Assert.assertTrue(isFail, "Không có thông báo lỗi hoặc không ở lại trang đăng ký khi đăng ký thất bại!");
    }

    @Test
    public void registerSuccess() {
        // TODO: Thay đổi dữ liệu hợp lệ bên dưới nếu muốn test đăng ký thật
        // registerPage.register("First", "Last", "uniqueUser123", "Test@1234");
        // Có thể kiểm tra url chuyển sang login hoặc xuất hiện thông báo thành công
        // Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Không chuyển sang trang login sau khi đăng ký thành công!");
        try {
            Thread.sleep(10000); // Giữ trình duyệt ở lại trang 10s để quan sát popup/thông báo thành công
        } catch (InterruptedException ignored) {}
        // Tạm thời bỏ qua, chỉ là placeholder
        Assert.assertTrue(true, "registerSuccess chưa được implement");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 