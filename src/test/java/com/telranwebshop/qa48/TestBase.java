package com.telranwebshop.qa48;

import com.telranwebshop.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected  ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    //@BeforeSuite
    public void setUp() {
        app.init();
    }
     @AfterMethod
   // @AfterSuite
    public void tearDown() {

        app.stop();
    }
}




