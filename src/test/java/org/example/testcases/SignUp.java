package org.example.testcases;

import org.example.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyReader;

public class SignUp extends BaseTestClass {
    private SignUpPage signUpPage;


    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        signUpPage = header.clickOnSignUp();
     
    }

    @Test(priority = 1)
    public void validSignUp() {
        //signUpPage.signUp(fakeDataGenerator.getValidUsername(), fakeDataGenerator.getValidPassword());
    	signUpPage.clickSignIn();
    	signUpPage.signUp(PropertyReader.getData("USERNAME"));
    	signUpPage.createAccount(PropertyReader.getData("NAME"), PropertyReader.getData("LNAME"), PropertyReader.getData("PASSWORD"), 
    			PropertyReader.getData("ADDRESS"), PropertyReader.getData("CITY"), PropertyReader.getData("STATE"), 
    			PropertyReader.getData("POSTCODE"), PropertyReader.getData("MOBILE"), PropertyReader.getData("ALIASADDR"));
        //signUpPage.acceptAlert();
    }



}
