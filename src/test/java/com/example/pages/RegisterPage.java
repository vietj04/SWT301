package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    private final By firstNameInput = By.id("firstname");
    private final By lastNameInput = By.id("lastname");
    private final By userNameInput = By.id("userName");
    private final By passwordInput = By.id("password");
    private final By registerButton = By.id("register");
    private final By errorMessage = By.id("name");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void register(String firstName, String lastName, String username, String password) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(userNameInput, username);
        type(passwordInput, password);
        click(registerButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
} 