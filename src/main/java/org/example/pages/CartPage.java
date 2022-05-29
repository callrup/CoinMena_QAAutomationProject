package org.example.pages;


import java.util.List;
import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends Page {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    Random random = new Random();
    int numOfProducts;
    int totalPrice = 0;
    
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2/i")  
    WebElement productAddedToCart;
    
    @FindBy(xpath = "//*[@id='layer_cart_product_attributes']")
    WebElement verifySizeisMediumandColorisBlue;
    
    @FindBy(xpath ="//*[@id='layer_cart_product_quantity']")
    WebElement verifyQuantityisTwo;

    @FindBy(linkText = "Delete")
    List<WebElement> linkDelete;

    @FindBy(xpath = "//tr[@class='success']/td[3]")
    List<WebElement> textPrice;

    @FindBy(xpath ="//*[@id='layer_cart']/div[1]/div[2]/div[3]/span")
    WebElement textTotalPrice;
    
    @FindBy(xpath ="//span[@class='ajax_block_products_total']")
    WebElement totalProductsPrice;
    
    @FindBy(xpath = "//span[@class='ajax_cart_shipping_cost']")
    WebElement shippingPrice;
    
    @FindBy(xpath ="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOut;
    
    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement proceedToCheckOutFromCart;
    
    @FindBy(xpath ="//table[@id='cart_summary']/tbody/tr/td[2]/p/a")  
    WebElement validateproductinchartSummary;
    
    @FindBy(xpath ="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckout;		 
    
    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement chechoutButtonInAddresssection;
    
    @FindBy(xpath = "//input[@id='cgv']")
    WebElement acceptTermsOfService;
    
    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement checkOutfromShipmnetPage;
    
    @FindBy(xpath ="//a[@title='Pay by bank wire']")
    WebElement clickonPayByBankWire;
    
    @FindBy(xpath ="//span[@id='amount']")
    WebElement totalOrderAmount;
    
    @FindBy(xpath = "//*[@id='center_column']/form/div/p[3]/b")
    WebElement currencyinBankWireTransfer;
    
    @FindBy(xpath ="//span[normalize-space()='I confirm my order']")
    WebElement iConfirmMyOrder;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement buttonPlaceOrder;
    
    @FindBy(xpath = "//strong[normalize-space()='Your order on My Store is complete.']")
    WebElement orderisComplete;


    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement buttonPurchase;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement textSuccessfulPurchase;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement buttonOk;
    
    @FindBy(xpath = "//*[@id='form']/div/div[2]/p")
    WebElement AddressInShippingPage;
    
    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
    WebElement payByBankWire;

   
    public String productAddedToCartMessage()
    {
    	return  productAddedToCart.getText();
    }
    
    public String verifyBlueMediumSizeAdded()
    {
    	return verifySizeisMediumandColorisBlue.getText();
    }
    
    public String verifyQuantityIsTwo()
    {
    	return verifyQuantityisTwo.getText();
    }
    
    public String getTotalExpectedprice() 
    {
    	return textTotalPrice.getText();
    	
    }
   

    public int getActualPrice() {
        visibilityWait(textTotalPrice);
        return Integer.parseInt(textTotalPrice.getText());
    }


    public void clickOnPlaceOrder() {
        clickElement(proceedToCheckOutFromCart);
    }

   

    public void clickOnPurchase() {
        clickElement(buttonPurchase);
    }

    public String getSuccessMessage() {
        visibilityWait(textSuccessfulPurchase);
        return textSuccessfulPurchase.getText();
    }
    
    public String summaryChartContainsSummerDress()
    {
    	return validateproductinchartSummary.getText();
    }
    
    
    public void proceedToCheckOut()
    {
    	
    	scrollDownToBottom();
    	moveToandClick(proceedToCheckout);
    }
    
    public void clickchechoutbuttoninAddressSection()
    {
    	
    	scrollDownToBottom();
    	moveToandClick(chechoutButtonInAddresssection);
    }

    
    public void agreeShippingTermAndCheckOut()
    
    {
    	moveToandClick(acceptTermsOfService);
    	scrollDownToBottom();
    	moveToandClick(checkOutfromShipmnetPage);
    }
    
    public String verifyAddressInShippingPage()
    {
    	String addr = AddressInShippingPage.getText();
    	String[] address = addr.split(":");
    	return address[1].trim();
    }
    
    public String validatePaymentMethodisThroughBankWire()
    {
    	return payByBankWire.getAttribute("title");
    }
    
    public void proceedToPaymentPage()
    {
    	
    	scrollDownToBottom();
    	moveToandClick(clickonPayByBankWire);
    }
    
    public String totalOrderPrice()
    {
    	return totalOrderAmount.getText();
    	
    }
    
    public String validateCurrencySentInBankTransfer()
    {
    	return  currencyinBankWireTransfer.getText();
    }
    
    public void clickIConfirmMyOrder()
    {
    	scrollDownToBottom();
    	moveToandClick(iConfirmMyOrder);
    }
    
    public String checkOrderisComplete()
    {
    	return orderisComplete.getText();
    }

    }

