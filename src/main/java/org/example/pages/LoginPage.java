package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement textInputUsername;

    @FindBy(id = "passwd")
    WebElement textInputPassword;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement buttonLogin;

    @FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
    WebElement authenticationFail;
    
    @FindBy(xpath = "//*[@id='center_column']/p")
    WebElement successfulLogin;		

    public void login(String username, String password) {
        sendText(textInputUsername, username);
        sendText(textInputPassword, password);
        clickElement(buttonLogin);
        
    }
    
   public void invalidLogin(String username ,String pwd)
   {
	    sendText(textInputUsername, username);
        sendText(textInputPassword, pwd);
        clickElement(buttonLogin);
   }
   
   public String getLoginSuccessMessage() {
       visibilityWait(successfulLogin);
       return successfulLogin.getText();
   }
   
   public String getUnsucessfulLogin()
   {
	   visibilityWait(authenticationFail);
       return authenticationFail.getText();
   }
}
