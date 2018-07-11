package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void latestFlatmatesNonLogged() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickFM();
        homePageHelper.verificationFM();
    }

    @Test
    public void findOutMore() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickFind();
        homePageHelper.verificationPageLinkHowItWorks();
    }

    @Test
    public void findStartMatching() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickFindYourNewFM();
        homePageHelper.verificationMatchingStart();
    }

    @Test
    public void findStartMatchingLink() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickTakeMatching();
        homePageHelper.verificationMatchingStart();
    }

    @Test
    public void findStartListing() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickAddListing();
        homePageHelper.verificationListingStart();
    }

    @Test
    public void blogFM() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickFMBlog();
        homePageHelper.verificationFMBlog();
    }

    @Test
    public void blogLandlord() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickLandlordBlog();
        homePageHelper.verificationLandlordBlog();
    }

    @Test
    public void pressLogo() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickLogo();
        homePageHelper.verificationLogo();
    }

    @Test
    public void blogImgLink() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickBlogFMImgLink();
        homePageHelper.verificationFMBlog();
    }

    @Test
    public void blogLordImgLink() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickBlogLandlordImgLink();
        homePageHelper.verificationLandlordBlog();
    }
    @Test
    public void blogTextFMLink() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickBlogFMTextLink();
        homePageHelper.verificationFMBlog();
    }

    @Test
    public void blogTextLordLink() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickBlogLandlordTextLink();
        homePageHelper.verificationLandlordBlog();
    }



}
