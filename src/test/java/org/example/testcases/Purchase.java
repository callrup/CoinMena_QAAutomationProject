package org.example.testcases;

import org.example.pages.PurchasePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;import utilities.PropertyReader;

public class Purchase extends BaseTestClass {

	private PurchasePage purchasepg;
	
	 @Override
	    @BeforeClass
	    void beforeClass() {
	        super.beforeClass();
	        purchasepg = header.hoverondress();
	    }
	    
	    // SignUp test should be executed
	    @Test(priority = 1)
	    public void purchasePrintedSummerDress() {
	    	purchasepg.hoveronSummarDress();
	    	softAssert.assertEquals(purchasepg.validatedressisprintedSummer() , PropertyReader.getData("DRESS"));
	    	
	    }
	    @Test(priority = 2)
	    public void selectSizeandQuantityforSummaerDress()
	    {
	    	purchasepg.addTwoPrintedSummaryDress();
	    	purchasepg.selectsize(PropertyReader.getData("SIZE"));
	    	purchasepg.selectColor();
	    	purchasepg.clickaddTocart();
	    	
	    }
	    	
}
