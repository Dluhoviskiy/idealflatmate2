package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class FooterTest extends TestBase {

    /*@AfterTest
    public void goHomePage(){
        //helperBase.toHomePage();
        navigator.back();
    }*/

    @Test(priority = 1)
    public void footerHomeLink() {

        footerHelper.footerHome();
        footerHelper.verificationFooterHome();
    }

    @Test(priority = 1)
    public void footerAboutUsLink() {
        //helperBase.toHomePage();
        footerHelper.footerAboutUs();
        footerHelper.verificationFooterAboutUs();
    }

    @Test(priority = 1)
    public void footerContactLink() {
        //helperBase.toHomePage();
        footerHelper.footerContact();
        footerHelper.verificationFooterContact();
    }

    @Test(priority = 1)
    public void footerPressLink() {
        //helperBase.toHomePage();
        footerHelper.footerPress();
        footerHelper.verificationFooterPress();
    }

    @Test(priority = 1)
    public void footerPricingLink() {
        //helperBase.toHomePage();
        footerHelper.footerPricing();
        footerHelper.verificationFooterPricing();
    }

    @Test(priority = 1)
    public void footerMediaLink() {
        //helperBase.toHomePage();
        footerHelper.footerMedia();
        footerHelper.verificationFooterMedia();
    }

    @Test(priority = 1)
    public void footerStaySafeLink() {

        footerHelper.footerStaySafe();
        footerHelper.verificationFooterStaySafe();
    }

    @Test(priority = 9)
    public void footerBlogLink() {
        newDriverPage();
        footerHelper.footerBlog();
        verificationHelper.FMBlog();
    }

    @Test(priority = 8)
    public void footerBrowseFlatsharesLink() {
        helperBase.toHomePage();
        footerHelper.footerBrowseFlatshares();
        footerHelper.verificationBrowseFlatshares();

    }

    @Test(priority = 8)
    public void footerAskLandlord() {
        helperBase.toHomePage();
        footerHelper.footerAskLandlord();
        footerHelper.verificationAskLandlord();
    }

    @Test(priority = 1)
    public void footerModern() {
        helperBase.toHomePage();
        footerHelper.footerModern();
        footerHelper.verificationModern();
        helperBase.toHomePage();
    }

    @Test(priority = 1)
    public void footerBrowseHowItWorksLink() {
        //helperBase.toHomePage();
        footerHelper.footerHowItWorks();
        footerHelper.verificationHowItWorks();
    }

    @Test(priority = 2)
    public void footerBrowseTipsLink() {
        //helperBase.toHomePage();
        footerHelper.footerTipsWorks();
        footerHelper.verificationTipsWorks();

    }

    @Test(priority = 1)
    public void footerNLALink() {
        newDriverPage();
        footerHelper.footerNLAWorks();
        footerHelper.verificationNLAWorks();
        helperBase.toHomePage();
    }

    @Test(enabled = false)
    public void footerFBLink() {
        newDriverPage();
        helperBase.toHomePage();
        footerHelper.footerFB();
        footerHelper.verificationFB();

    }

    @Test(priority = 5)
    public void footerTwitterLink() {
        helperBase.toHomePage();
        footerHelper.footerTwitter();
        footerHelper.verificationTwitter();
    }

    @Test(priority = 6)
    public void footerInstagramLink() {
        helperBase.toHomePage();
        footerHelper.footerInstagram();
        footerHelper.verificationInstagram();

    }

    @Test(priority = 7)
    public void footerYoutubeLink() {
        helperBase.toHomePage();
        footerHelper.footerYoutube();
        clearCache();
        footerHelper.verificationYoutube();

    }



}
