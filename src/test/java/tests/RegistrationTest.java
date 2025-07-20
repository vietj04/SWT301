package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Registration Tests using Page Object Model")
public class RegistrationTest extends BaseTest {
    static RegistrationPage regPage;

    @BeforeAll
    static void initPage() {
        regPage = new RegistrationPage(driver);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registration-data.csv", numLinesToSkip = 1)
    @Order(1)
    @DisplayName("Should register successfully with valid data from CSV")
    void testSuccessfulRegistration(String firstName, String lastName, String email, String gender, String mobile, String dob, String subject, String hobby, String address, String state, String city) {
        driver.get("https://demoqa.com/automation-practice-form");
        regPage.enterFirstName(firstName);
        regPage.enterLastName(lastName);
        regPage.enterEmail(email);
        regPage.selectGender(gender);
        regPage.enterMobile(mobile);
        regPage.setDateOfBirth(dob);
        regPage.enterSubject(subject);
        regPage.selectHobby(hobby);
        regPage.enterAddress(address);
        regPage.selectState(state);
        regPage.selectCity(city);
        regPage.submitForm();
        // Kiểm tra popup xác nhận
        String modalTitle = regPage.getModalTitle();
        assertEquals("Thanks for submitting the form", modalTitle);
    }
} 