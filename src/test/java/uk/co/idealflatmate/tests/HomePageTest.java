package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.HelperBase;

public class HomePageTest extends TestBase {



    @Test (priority = 1)
    public void amountOfBlocsAndTextOfAreas() {

        homePageHelper.amountOfFeedbackBlocks(4);
        homePageHelper.amountOfBlogBlocks(2);
        //homePageHelper.amountOfLatestFMblocks(4);
        homePageHelper.amountOfFeaturedRoom(6);
        homePageHelper.amountOfAreasBlocks(7);
        homePageHelper.TextInAreas();
        homePageHelper.amountOfMatchListRoom(2);
    }

    @Test (priority = 2)
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

    @Test (priority = 4)
    public void findStartMatchingLink() {

        matchingHelper.clickHomePageMatching();
        homePageHelper.verificationMatchingStart();
        matchingHelper.quitQuiz();
    }

    @Test (priority = 5)
    public void findStartListing() {
        homePageHelper.scrollToBlockSelect();
        homePageHelper.clickAddListingFromHow();
        verificationHelper.ListingStart();
        homePageHelper.clickLogo();
    }

    @Test (priority = 6)
    public void blogFM() {
        homePageHelper.hoverCommunity();
        homePageHelper.clickFMBlog();
        verificationHelper.FMBlog();
        helperBase.toHomePage();
    }

    @Test (priority = 7)
    public void blogLandlord() {

        homePageHelper.hoverCommunity();
        homePageHelper.clickLandlordBlog();
        verificationHelper.LandlordBlog();
        helperBase.toHomePage();
    }

    @Test (priority = 8)
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
