package com.telranwebshop.qa48;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        fillRegisterForm();
        registerSelectGender();
        enterFirstName();
        enterLastName();
        registrationPageEnterEmail();
        registrationPagaEnterPassword();
        clickOnRegistrationButton();
        Assert.assertTrue(isLogoutLinkDisplayed(), "Registration failed!");
    }


}