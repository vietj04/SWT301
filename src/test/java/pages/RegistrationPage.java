package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void waitAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    public void selectGender(String gender) {
        List<WebElement> labels = driver.findElements(By.cssSelector("label[for^='gender-radio']"));
        for (WebElement label : labels) {
            if (label.getText().equalsIgnoreCase(gender)) {
                waitAndClick(label);
                break;
            }
        }
    }

    public void enterMobile(String mobile) {
        driver.findElement(By.id("userNumber")).sendKeys(mobile);
    }

    public void setDateOfBirth(String dob) {
        WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
        dobInput.click();
        dobInput.clear();
        dobInput.sendKeys(dob);
        dobInput.sendKeys("\n");
    }

    public void enterSubject(String subject) {
        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        subjectInput.sendKeys(subject);
        subjectInput.sendKeys("\n");
    }

    public void selectHobby(String hobby) {
        List<WebElement> hobbies = driver.findElements(By.cssSelector(".custom-checkbox input[type='checkbox']"));
        for (WebElement h : hobbies) {
            WebElement label = h.findElement(By.xpath("./following-sibling::label"));
            if (label.getText().equalsIgnoreCase(hobby)) {
                waitAndClick(label);
                break;
            }
        }
    }

    public void uploadPicture(String filePath) {
        driver.findElement(By.id("uploadPicture")).sendKeys(filePath);
    }

    public void enterAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    public void selectState(String state) {
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        scrollToElement(stateDropdown);
        stateDropdown.sendKeys(state);
        stateDropdown.sendKeys("\n");
    }

    public void selectCity(String city) {
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));
        scrollToElement(cityDropdown);
        cityDropdown.sendKeys(city);
        cityDropdown.sendKeys("\n");
    }

    public void submitForm() {
        WebElement submitBtn = driver.findElement(By.id("submit"));
        waitAndClick(submitBtn);
    }

    public String getModalTitle() {
        return driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
    }
} 