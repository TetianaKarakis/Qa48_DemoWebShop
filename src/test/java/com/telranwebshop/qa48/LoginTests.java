package com.telranwebshop.qa48;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillRegiserLoginForm(new User().setEmail("tati123@gmail.com").setPassword("Tati123!"));
        clickOnLoginButton();
        Assert.assertTrue(isLogoutButtonDisplayed(),
                "Logout button not found, login failed!");
    }
@Test
public void loginNegativeTest() {
    clickOnLoginLink();
    fillRegiserLoginForm(new User().setPassword("Tati123!"));
    clickOnLoginButton();
    Assert.assertTrue(isLoginErrorDisplayed(),
            "Error message not displayed, login might have passed unexpectedly!");
}

}
// Assert.assertTrue(isLogoutButtonDisplayed(),