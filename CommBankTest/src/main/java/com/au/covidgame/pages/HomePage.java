package com.au.covidgame.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(css = ".anime p.option-label")
    WebElement homePageTitle;

    @FindBy(css = "img.centered.responsive")
    WebElement homePageImage;

    @FindBy(xpath = "//input[@id='worrior_username']")
    WebElement userNameField;

    @FindBy(xpath = "//a[@id='warrior']")
    WebElement createUser;

    @FindBy(xpath = "//a[@id='start']")
    WebElement userSuccess;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    boolean flag;
    String content;

    public boolean validateIsHomePageTitleDisplayed() {
        content = getText(homePageTitle);
        flag = validateTitleIsPresent(content);
        return flag;
    }

    private boolean validateTitleIsPresent(String content) {
        return content.length() > 0;
    }

    public boolean validateIsHomePageImagePresent(){
        flag = isElementDisplayed(homePageImage);
        return flag;
    }

    public void scrollToUserCreationField() {
        scrollIntoView("arguments[0].scrollIntoView()",userNameField);
    }

    public boolean validateIsUserCreationFieldPresentAndClick(String userName) {
        flag = isElementDisplayed(userNameField);
        click(userNameField);
        userNameField.sendKeys(userName);
        return flag;
    }

    public boolean validateIsUserCreationButtonPresentAndClick() {
        flag = isElementDisplayed(createUser);
        click(createUser);
        return flag;
    }

    public boolean validateOnUserCreated() {
        flag = isElementDisplayed(userSuccess);
        return flag;
    }

    public boolean startJourneyOnUserSuccess() {
        flag = isElementDisplayed(userSuccess);
        click(userSuccess);
        return flag;
    }
}
