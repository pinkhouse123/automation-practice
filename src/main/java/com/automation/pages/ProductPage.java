package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    public ProductPage() { PageFactory.initElements(driver,this);}
    @FindBy(xpath = "//a[@title='Women']")
    WebElement clickOnWomenLink;

    public void quantityNeeded() { PageFactory.initElements(driver,this);}
    @FindBy(id = "quantity_wanted")
    WebElement clickOnQuantity;

    public void sizeDropdown() { PageFactory.initElements(driver,this);}
    @FindBy(id = "group_1")
    WebElement clickOnSizeDropdown;

    public void colour() { PageFactory.initElements(driver,this);}
    @FindBy(id = "color_13")
    WebElement clickOnColour;

    public void addToCart() { PageFactory.initElements(driver,this);}
    @FindBy(name = "Submit")
    WebElement clickOnAddToCart;
}