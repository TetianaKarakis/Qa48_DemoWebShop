package com.telranwebshop.qa48;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        app.getUser().fillRegisterForm();
        app.getUser().registerSelectGender();
        app.getUser().enterFirstName();
        app.getUser().enterLastName();
        app.getUser().registrationPageEnterEmail();
        app.getUser().registrationPagaEnterPassword();
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLogoutLinkDisplayed(), "Registration failed!");
    }


}