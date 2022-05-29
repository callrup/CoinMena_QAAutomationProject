package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends Page{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement inputEmailforsignUp;

    @FindBy(id = "sign-password")
    WebElement inputTextPassword;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signIn;
    
    @FindBy(xpath = "//*[@id='create_account_error']/ol/li/text()")
    WebElement accountAlreadyExist;

    @FindBy(xpath = "//*[@id='create_account_error']/ol/li/text()")
    WebElement invalidEmailmessage;
    
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAnAccount;
    
    @FindBy(xpath = "//*[@id='uniform-id_gender1']")
    WebElement clickTitleRadioButton;
    
    @FindBy(xpath = "//*[@id='customer_firstname']")
    WebElement firstName;
    
    @FindBy(xpath = "//*[@id='customer_lastname']")
    WebElement lastName;
    
    @FindBy(xpath = "//*[@id='email']")
    WebElement email;
    
    @FindBy(xpath = "//*[@id='passwd']")
    WebElement password;
    
    @FindBy(xpath = "//*[@id='address1']")
    WebElement address;
    
    @FindBy(xpath = "//*[@id='city']")
    WebElement city;
    
    @FindBy(xpath = "//*[@id='postcode']")
    WebElement postcode;
    
    @FindBy(xpath = "//*[@id='id_state']")
    WebElement selectState;
    
    @FindBy(xpath = "//*[@id='phone_mobile']")
    WebElement mobilePhone;
    
    @FindBy(xpath = "//input[@id='alias']")
    WebElement aliasAddress;
    
    @FindBy(xpath = "//span[normalize-space()='Register']")
    WebElement clickRegister;

   public void clickSignIn()
   {
	   clickElement(signIn);
   }
    
    public void signUp(String username) {
        sendText(inputEmailforsignUp, username);
        clickElement(createAnAccount);
    }
    
    public void validateInvalidEmailAddress()
    {
    	invalidEmailmessage.getText();
    }
    
    public void validateEmailaddressAlreadyExist()
    {
    	accountAlreadyExist.getText();
    }
    
    public void createAccount(String firstnm , String lastnm,String pwd ,String addr,String citynm,String state, String po , String mobile , String aliasaddr)
    {
    	clickElement(clickTitleRadioButton);
    	sendText(firstName ,firstnm);
    	sendText(lastName,lastnm);
    	sendText(password,pwd);
    	scrollToElement(address);
    	sendText(address,addr);
    	sendText(city,citynm );
    	selectfromdropdown(selectState, state);
    	sendText(postcode,po);
    	sendText(mobilePhone, mobile);
    	aliasAddress.clear();
    	sendText(aliasAddress,aliasaddr);
    	clickElement(clickRegister);
    }


}
