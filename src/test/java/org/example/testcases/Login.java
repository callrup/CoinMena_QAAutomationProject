package org.example.testcases;

import org.example.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.PropertyReader;

public class Login extends BaseTestClass {
    private LoginPage loginPage;

    @Override
    @BeforeClass
    void beforeClass() {
        super.beforeClass();
        loginPage= header.clickOnLogout();
     
    }
    
    @Test(priority = 1)
    public void validateinvalidLogin() {
        loginPage.invalidLogin(PropertyReader.getData("USERNAME"), PropertyReader.getData("PWD"));
        softAssert.assertEquals(loginPage.getUnsucessfulLogin(), PropertyReader.getAlertMessage("INVALID.LOGIN"));
    }
   
    
    // SignUp test should be executed
    @Test(priority = 2)
    public void validLogin() {
        loginPage.login(PropertyReader.getData("USERNAME"), PropertyReader.getData("PASSWORD"));
        softAssert.assertEquals(loginPage.getLoginSuccessMessage(), PropertyReader.getAlertMessage("VALID.LOGIN"));
        softAssert.assertEquals(driver.getTitle(), PropertyReader.getAlertMessage("LOGIN.PAGE"));
        softAssert.assertAll();
    }
  
  
}
