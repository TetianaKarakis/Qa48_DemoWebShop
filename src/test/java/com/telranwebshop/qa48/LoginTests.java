package com.telranwebshop.qa48;

import com.telranwebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegiserLoginForm((new User().setEmail("tati123@gmail.com").setPassword("Tati123!")));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogoutButtonDisplayed(),
                "Logout button not found, login failed!");
    }
    @Test
    public void loginNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegiserLoginForm((new User().setPassword("Tati123!")));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLoginErrorDisplayed(),
                "Error message not displayed, login might have passed unexpectedly!");
    }
}
