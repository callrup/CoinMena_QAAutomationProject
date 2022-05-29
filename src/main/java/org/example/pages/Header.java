package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends Page{
    public Header(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement linkCart;

    @FindBy(linkText = "Log in")
    WebElement linkLogin;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signIn;

    @FindBy(xpath ="//a[@title='Log me out']")
    WebElement linkLogout;

    @FindBy(id = "nameofuser")
    WebElement linkWelcomeUser;
    
    @FindBy(xpath =" //span[normalize-space()='Add to cart']")
    WebElement addToCart;
    
    @FindBy(xpath ="//*[@id='block_top_menu']/ul/li[2]/a")
	WebElement dresses;
    
    @FindBy(xpath ="//li[@class='sfHover']//a[@title='Summer Dresses'][normalize-space()='Summer Dresses']")
	WebElement clickSummerDresses;


    public LoginPage clickOnLogin() {
        clickElement(linkLogin);
        return new LoginPage(driver);
    }

    public SignUpPage clickOnSignUp() {
        clickElement(signIn);
        return new SignUpPage(driver);
    }

    public LoginPage clickOnLogout() {
        clickElement(linkLogout);
        return new LoginPage(driver);
    }
    
    public PurchasePage hoverondress()
	{
		
		visibilityWait(dresses);
		mouseHoveronElement(dresses); 
		moveToandClick(clickSummerDresses);
		return new PurchasePage(driver);
	}
    

    public CartPage clickOnCart() {
    	click(linkCart);
        return new CartPage(driver);
    }

    public boolean isWelcomeUserDisplayed() {
        visibilityWait(linkWelcomeUser);
        return linkWelcomeUser.isDisplayed();
    }

    public boolean isLoginDisplayed() {
        visibilityWait(linkLogin);
        return linkLogin.isDisplayed();
    }

//    public boolean isSignUpDisplayed() {
//        visibilityWait(linkSignUp);
//        return linkSignUp.isDisplayed();
//    }

    public boolean isLogoutDisplayed() {
        visibilityWait(linkLogout);
        return linkLogout.isDisplayed();
    }
    
 
}
