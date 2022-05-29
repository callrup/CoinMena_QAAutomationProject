package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 45);
    }

    protected void visibilityWait(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void alertWait() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
    
    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    
    protected void sendText(WebElement element, String text) {
        visibilityWait(element);
        element.clear();
        element.sendKeys(text);
    }
    
    public void selectfromdropdown(WebElement element , String state)
    {
    	Select sel = new Select(element);
    	sel.selectByVisibleText(state);
    }
    
    public void scrollToElement(WebElement element)
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void scrollDownToBottom()
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    
    public void click(WebElement element)
    {
    	element.click();
    }

    public String getAlertMessage() {
        alertWait();
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        alertWait();
        driver.switchTo().alert().accept();
    }
    
    public void mouseHoveronElement(WebElement ele)
    {
    	Actions ac = new Actions(driver);
    	ac.moveToElement(ele).perform();
    }
    
    public void moveToandClick(WebElement ele)
    {
    	Actions ac = new Actions(driver);
    	ac.moveToElement(ele).click().perform();
    }

}
