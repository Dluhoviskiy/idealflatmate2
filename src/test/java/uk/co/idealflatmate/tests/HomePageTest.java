package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.HelperBase;

import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class HomePageTest extends TestBase {



    @Test
    public void amountOfBlocsAndTextOfAreas() {
        areaPageHelper.areaScroll();
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

        matchingHelper.clickHomePageMatching();
        homePageHelper.verificationMatchingStart();
        matchingHelper.quitQuiz();
    }

    @Test
    public void findStartListing() {

        homePageHelper.scrollToBlockSelect();
        homePageHelper.clickAddListingFromHow();
        verificationHelper.ListingStart();
        homePageHelper.clickLogo();
    }

    @Test
    public void blogFM() {

        homePageHelper.hoverCommunity();
        homePageHelper.clickFMBlog();
        verificationHelper.FMBlogPage();

    }

    @Test
    public void blogLandlord() {

        homePageHelper.hoverCommunity();
        homePageHelper.clickLandlordBlog();
        verificationHelper.landlordBlogPage();

    }

    @Test
    public void pressLogo() {

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
