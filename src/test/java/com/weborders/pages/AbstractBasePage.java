package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// It meant to be extended
public abstract class AbstractBasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy (tagName = "h1")
    protected WebElement pageLogo;

    public String getPageLogoText(){
        return pageLogo.getText();
    }

    public AbstractBasePage(){
        // its like a method that runs automatically as soon as the object comes into existance
        // this is like a default setting of any object from this class
        // car with engine ready to drive
        // Why PageFactory? for having the FindBy annotation
        // we use it to initialize elements

        //it is VERY important! it serves to initialize the object and it finds the Elements!!
        //without it NO PAGE Object Model class will work !!!
        //finding web elements in POM : selenium has smth to improve this process : Page Factory class
        // It helps to find element easier, syntax is shorter, more organized
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void navigateTo(String component){
        String locator = "//a[text()='"+component+"']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();

    }
}
