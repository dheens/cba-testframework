package com.au.covidgame.test;

import com.au.covidgame.pages.ChallengeHomePage;
import com.au.covidgame.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CovidTest extends BaseTest {

        HomePage newUser;
        HomePage userJourney;
        ChallengeHomePage challengeHomePage;


        @Test
        public void userCreation()  {
            test = report.createTest("To verify User Creation");
            newUser = new HomePage(driver);

            newUser.validateIsHomePageTitleDisplayed();
            boolean verifyHomePageTitle = newUser.validateIsHomePageTitleDisplayed();
            Assert.assertTrue(verifyHomePageTitle,"Homepage title is incorrect");

            newUser.validateIsHomePageImagePresent();
            boolean verifyHomePageImage = newUser.validateIsHomePageImagePresent();
            Assert.assertTrue(verifyHomePageImage,"Homepage image is missing");

            newUser.scrollToUserCreationField();
            newUser.validateIsUserCreationFieldPresentAndClick("IronMan");
            newUser.validateIsUserCreationButtonPresentAndClick();
            boolean verifyOnUserCreated = newUser.validateOnUserCreated();
            Assert.assertTrue(verifyOnUserCreated,"User creation was not successful");

        }

        @Test
        public void completeChallengeAndVerifyLeaderboard () throws InterruptedException {
                test = report.createTest("To complete a challenge and verify the score in leaderboard");
                userJourney = new HomePage(driver);
                challengeHomePage = new ChallengeHomePage(driver);

                userJourney.scrollToUserCreationField();
                userJourney.validateIsUserCreationFieldPresentAndClick("IronMan");
                userJourney.validateIsUserCreationButtonPresentAndClick();
                userJourney.startJourneyOnUserSuccess();

                challengeHomePage.validateIsChallengePageTitleDisplayed();
                boolean verifyChallengePageTitle = challengeHomePage.validateIsChallengePageTitleDisplayed();
                Assert.assertTrue(verifyChallengePageTitle, "challenge page title is incorrect");

                challengeHomePage.validateIsGameImagePresent();
                boolean verifyGameImagePresent = challengeHomePage.validateIsGameImagePresent();
                Assert.assertTrue(verifyGameImagePresent, "game image is missing");

                challengeHomePage.scrollToChallenge();
                challengeHomePage.scrollToGameStart();
                challengeHomePage.scrollToAns();
                challengeHomePage.scrollToClickContinue();
                challengeHomePage.scrollToAns();
                challengeHomePage.scrollToClickContinue();
                challengeHomePage.scrollToAns();
                challengeHomePage.scrollToClickContinue();

                challengeHomePage.validateIsLeaderBoardTitleDisplayed();

                boolean verifyLeaderBoardTitle = challengeHomePage.validateIsLeaderBoardTitleDisplayed();
                Assert.assertTrue(verifyLeaderBoardTitle,"LeaderBoard title is incorrect");

                String scoreFromUI = challengeHomePage.verifyNameAndScoreInLeaderBoard("IronMan");
                Assert.assertEquals(scoreFromUI,"300");
        }
}
