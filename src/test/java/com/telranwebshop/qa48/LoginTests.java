package com.telranwebshop.qa48;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillRegiserLoginForm("tati123@gmail.com", "Tati123!");
        clickOnLoginButton();
        Assert.assertTrue(isLogoutButtonDisplayed(),
                "Logout button not found, login failed!");
    }


}
