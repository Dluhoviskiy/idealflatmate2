package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.HelperBase;

import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class HomePageTest extends TestBase {



    @Test
    public void amountOfBlocsAndTextOfAreas() {
        pageUrlVerifLiveGoStage();
        homePageHelper.amountOfFeedbackBlocks(4);
        homePageHelper.amountOfBlogBlocks(2);
        //homePageHelper.amountOfLatestFMblocks(4);
        homePageHelper.amountOfFeaturedRoom(6);
        homePageHelper.amountOfAreasBlocks(7);
        homePageHelper.TextInAreas();
        homePageHelper.amountOfMatchListRoom(2);
    }

    @Test
    public void findOutMore() {
        pageUrlVerifLiveGoStage();
        HelperBase.closeAdvPopUp();
        homePageHelper.scrollToBlockProperty();
        homePageHelper.clickFindRooms();
        homePageHelper.verificationPageLinkHowItWorksRooms();
        helperBase.toHomePage();
        homePageHelper.scrollToBlockProperty();
        homePageHelper.clickFindFM();
        homePageHelper.verificationPageLinkHowItWorksFM();
        helperBase.toHomePage();
    }

    @Test
    public void findStartMatchingLink() {
        pageUrlVerifLiveGoStage();
        matchingHelper.clickHomePageMatching();
        homePageHelper.verificationMatchingStart();
        matchingHelper.quitQuiz();
    }

    @Test
    public void findStartListing() {
        pageUrlVerifLiveGoStage();
        homePageHelper.scrollToBlockSelect();
        homePageHelper.clickAddListingFromHow();
        verificationHelper.ListingStart();
        homePageHelper.clickLogo();
    }

    @Test
    public void blogFM() {
        pageUrlVerifLiveGoStage();
        homePageHelper.hoverCommunity();
        homePageHelper.clickFMBlog();
        verificationHelper.FMBlogPage();

    }

    @Test
    public void blogLandlord() {
        pageUrlVerifLiveGoStage();
        homePageHelper.hoverCommunity();
        homePageHelper.clickLandlordBlog();
        verificationHelper.landlordBlogPage();

    }

    @Test
    public void pressLogo() {
        pageUrlVerifLiveGoStage();
        homePageHelper.clickLogo();
        verificationHelper.isHomePage1();
    }





    /*@Test (priority = 1)
    public void latestFlatmatesNonLogged() {
        verificationHelper.closeAdvPopUp();
        signUpHelper.scrollToBlockProperty();
        homePageHelper.clickFM();
        homePageHelper.verificationFM();
    }*/

}
