package org.example.testcases;

import org.example.pages.CartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyReader;



public class Cart extends BaseTestClass {
 
    private CartPage cartPage;

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        //cartPage = header.clickOnCart();
        cartPage = new CartPage(driver);
    }

    @Test(priority = 1)
    public void comparecartAttributesAndProceedToCheckout() {
       softAssert.assertEquals(cartPage.productAddedToCartMessage(),PropertyReader.getAlertMessage("ADD.CART"));
       softAssert.assertEquals(cartPage.verifyBlueMediumSizeAdded(),PropertyReader.getAlertMessage("CART.ATTRIBUTE"));
       softAssert.assertEquals(cartPage.verifyQuantityIsTwo(), PropertyReader.getAlertMessage("CART.QUANTITY"));
       //softAssert.assertEquals(cartPage.getTotalPrice(), cartPage.getTotalExpectedprice(),0.00);
       cartPage.clickOnPlaceOrder();
    }
    
    

    @Test(priority = 2)
    public void proceedToCheckOut() throws InterruptedException 
    
    {
    	cartPage.proceedToCheckOut();
    	cartPage.clickchechoutbuttoninAddressSection();
    	softAssert.assertEquals(cartPage.verifyAddressInShippingPage(), PropertyReader.getData("ADDRESS"));
    	cartPage.agreeShippingTermAndCheckOut();
    }
    
    @Test(priority = 3)
    public void proceedToPayByBankWire() throws InterruptedException 
    {
    	softAssert.assertEquals(cartPage.validatePaymentMethodisThroughBankWire(),PropertyReader.getAlertMessage("PAYMENT.METHOD"));
    	cartPage.proceedToPaymentPage();
    	softAssert.assertEquals(cartPage.getTotalExpectedprice(), cartPage.totalOrderPrice());
    	softAssert.assertEquals(cartPage.validateCurrencySentInBankTransfer(),PropertyReader.getData("CURRENCY"));
    	cartPage.clickIConfirmMyOrder();
    	softAssert.assertEquals(cartPage.checkOrderisComplete(),PropertyReader.getData("ORDER.CONFIRM"));
    }


}
