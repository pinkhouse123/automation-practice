package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Utility {
    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    WebElement selectMaleRadioButton;
    @FindBy(id = "id_gender2")
    WebElement selectFemaleRadioButton;
    @FindBy(id = "customer_firstname")
    WebElement enterFirstName;
    @FindBy(id = "customer_lastname")
    WebElement enterLastName;
    @FindBy(id = "email")
    WebElement enterEmail;
    @FindBy(id = "passwd")
    WebElement enterPassword;
    @FindBy(id = "days")
    WebElement selectDays;
    @FindBy(id = "months")
    WebElement selectMonth;
    @FindBy(id = "years")
    WebElement selectYears;
    @FindBy(id = "newsletter")
    WebElement selectNewsLetter;
    @FindBy(id = "optin")
    WebElement selectSpecialOffer;
    @FindBy(id = "firstname")
    WebElement enterFirstNameAgain;
    @FindBy(id = "lastname")
    WebElement enterLastNameAgain;
    @FindBy(id = "company")
    WebElement enterCompanyName;
    @FindBy(id = "address1")
    WebElement enterAddressLine1;
    @FindBy(id = "address2")
    WebElement enterAddressLine2;
    @FindBy(id = "city")
    WebElement enterCity;
    @FindBy(id = "id_state")
    WebElement selectState;
    @FindBy(id = "postcode")
    WebElement enterPostcode;
    @FindBy(id = "id_country")
    WebElement selectCountry;
    @FindBy(id = "other")
    WebElement enterOtherDetails;
    @FindBy(id = "phone")
    WebElement enterHomePhone;
    @FindBy(id = "phone")
    WebElement enterMobilePhone;
    @FindBy(id = "phone_mobile")
    WebElement enterAddressAlias;
    @FindBy(id = "alias")
    WebElement registerButton;
    @FindBy(xpath = "//span[@class='navigation_page']")
    WebElement verifyMyAccount;

    public void fillPersonalInformationForm(String firstName, String lastName, String password) {

        // clickOnElement(selectMaleRadioButton);
        sendTextToElement(enterFirstName, firstName);
        sendTextToElement(enterLastName, lastName);
        //  sendTextToElement(enterEmail, email);
        sendTextToElement(enterPassword, password);
        //selectByVisibleTextFromDropDown(selectDays, day);
        //selectByVisibleTextFromDropDown(selectMonth, month);
        //  selectByVisibleTextFromDropDown(selectYears, year);
        //  clickOnElement(selectNewsLetter);
        //  clickOnElement(selectSpecialOffer);
    }

    public void fillYourAddressDetails(String addLn1, String city, String state, String zipCd, String country, String homeNo, String mobileNo, String addAlias) {
        // sendTextToElement(enterFirstNameAgain, firstName);
        //  sendTextToElement(enterLastNameAgain, lastName);
        // sendTextToElement(enterCompanyName, compNm);
        sendTextToElement(enterAddressLine1, addLn1);
        // sendTextToElement(enterAddressLine2, addLn2);
        sendTextToElement(enterCity, city);
        selectByVisibleTextFromDropDown(selectState, state);
        sendTextToElement(enterPostcode, zipCd);
        selectByVisibleTextFromDropDown(selectCountry, country);
        sendTextToElement(enterMobilePhone, homeNo);
        sendTextToElement(enterMobilePhone, mobileNo);
        sendTextToElement(enterAddressAlias, addAlias);
        clickOnElement(registerButton);
    }

    public String verifyMyAccountText() {
        return getTextFromElement(verifyMyAccount);
    }
}