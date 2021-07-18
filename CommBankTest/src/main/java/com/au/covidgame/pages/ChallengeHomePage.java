package com.au.covidgame.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChallengeHomePage extends BasePage{

    @FindBy(xpath = "//p[contains(text(),'COVID-19 THE GAME')]")
    WebElement challengePageTitle;

    @FindBy(xpath = "//img[@id='world_img']")
    WebElement gameImage;

    @FindBy(xpath = "//a[@id='news']")
    WebElement startChallenge;

    @FindBy(xpath = "//button[@id='start']")
    WebElement gameStart;

    @FindBy(xpath = "//a[@id='answer_1']")
    WebElement challengeAns;

    @FindBy(xpath = "//button[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//p[contains(text(),'COVID-19 THE GAME - LEADERBOARD')]")
    WebElement leaderBoardTitle;

    public ChallengeHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    boolean flag, titleCheck;
    String challenge, title;

    public boolean validateIsChallengePageTitleDisplayed() {
        challenge = getText(challengePageTitle);
        flag = validateTitleIsPresent(challenge);
        return flag;
    }

    private boolean validateTitleIsPresent(String challenge) {
        return challenge.length() > 0;
    }

    public boolean validateIsGameImagePresent(){
        flag = isElementDisplayed(gameImage);
        return flag;
    }

    public void scrollToChallenge() {
        scrollIntoView("arguments[0].scrollIntoView()",startChallenge);
        click(startChallenge);
    }

    public void scrollToGameStart(){
        scrollIntoView("arguments[0].scrollIntoView()",gameStart);
        click(gameStart);
    }

    public void scrollToAns() throws InterruptedException {
        scrollIntoView("arguments[0].scrollIntoView()",challengeAns);
        Thread.sleep(2000);
        click(challengeAns);
    }

    public void scrollToClickContinue() throws InterruptedException {
        scrollIntoView("arguments[0].scrollIntoView()",continueButton);
        Thread.sleep(2000);
        click(continueButton);
    }
    public boolean validateIsLeaderBoardTitleDisplayed() {
        title = getText(leaderBoardTitle);
        titleCheck = validateLeaderBoardTitleIsPresent(title);
        return titleCheck;
    }

    private boolean validateLeaderBoardTitleIsPresent(String title) {
        return title.length() > 0;
    }

    public String verifyNameAndScoreInLeaderBoard(String userName)
    {
        String dynamicXpath = ".//td[.='"+userName+"']/following-sibling::td";
        return getText(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath))));
    }
}
