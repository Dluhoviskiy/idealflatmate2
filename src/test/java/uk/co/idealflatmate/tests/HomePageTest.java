package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

   // @Test
    public void latestFlatmatesNonLogged() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickFM();
        homePageHelper.verificationFM();
    }

   // @Test
    public void findOutMore() {
        verificationHelper.closeAdvPopUp();
        homePageHelper.clickFind();
        homePageHelper.verificationPageLinkHowItWorks();
    }

  //  @Test
    public void findStartMatching() {

        homePageHelper.clickFindYourNewFM();
        homePageHelper.verificationMatchingStart();
    }

   // @Test
    public void findStartMatchingLink() {

        homePageHelper.clickTakeMatching();
        homePageHelper.verificationMatchingStart();
    }

  //  @Test
    public void findStartListing() {

        homePageHelper.clickAddListing();
        homePageHelper.verificationListingStart();
    }

  //  @Test
    public void blogFM() {

        homePageHelper.clickFMBlog();
        homePageHelper.verificationFMBlog();
    }

  //  @Test
    public void blogLandlord() {

        homePageHelper.clickLandlordBlog();
        homePageHelper.verificationLandlordBlog();
    }

  //  @Test
    public void pressLogo() {

        homePageHelper.clickLogo();
        homePageHelper.verificationLogo();
    }

   // @Test
    public void blogImgLink() {

        homePageHelper.clickBlogFMImgLink();
        homePageHelper.verificationFMBlog();
    }

  //  @Test
    public void blogLordImgLink() {

        homePageHelper.clickBlogLandlordImgLink();
        homePageHelper.verificationLandlordBlog();
    }
   // @Test
    public void blogTextFMLink() {

        homePageHelper.clickBlogFMTextLink();
        homePageHelper.verificationFMBlog();
    }

   // @Test
    public void blogTextLordLink() {

        homePageHelper.clickBlogLandlordTextLink();
        homePageHelper.verificationLandlordBlog();
    }



}
