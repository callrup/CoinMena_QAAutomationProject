package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends Page{
	
	public PurchasePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCart;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")
	WebElement selectPrintedSummerDress;
	
	@FindBy(xpath ="//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[2]/span")
	WebElement clickonMoreButton;
	
    @FindBy(xpath = "//*[@id='quantity_wanted_p']/a[2]/span/i")
    WebElement addQuantity;
    
    @FindBy(xpath ="//*[@id='quantity_wanted']")
    WebElement quantityValue;
    
    @FindBy(xpath ="//*[@id='group_1']")
    WebElement SelectSize;
    
    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]")
    WebElement hoveronSummerDresses;
   
    @FindBy(xpath = "//ul[@id='color_to_pick_list']/li[3]")
    WebElement selectbluecolor;
    
    
    
	public void clickaddTocart()
	{
		
		clickElement(addToCart);
	}
	
	public void hoveronSummarDress()
	{
		visibilityWait(hoveronSummerDresses);
		mouseHoveronElement(hoveronSummerDresses);
	}
	
	public String validatedressisprintedSummer()
	{
		return selectPrintedSummerDress.getText();
	}
	
	public void addTwoPrintedSummaryDress()
	{
		clickElement(clickonMoreButton);
		
			clickElement(addQuantity);
		}
		
	
	
	public void selectsize(String Size)
	{
		selectfromdropdown(SelectSize ,Size);
	}
	
	
	public void selectColor()
	{
		clickElement(selectbluecolor);
	}
	

}
