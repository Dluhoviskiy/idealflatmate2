package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class FooterTest extends TestBase {

    /*@AfterTest
    public void goHomePage(){
        //helperBase.toHomePage();
        navigator.back();
    }*/

    @Test
    public void footerHomeLink() {

        footerHelper.footerHome();
        footerHelper.verificationFooterHome();
    }

    @Test
    public void footerAboutUsLink() {
        //helperBase.toHomePage();
        footerHelper.footerAboutUs();
        footerHelper.verificationFooterAboutUs();
    }

    @Test
    public void footerContactLink() {
        //helperBase.toHomePage();
        footerHelper.footerContact();
        footerHelper.verificationFooterContact();
    }

    @Test
    public void footerPressLink() {
        //helperBase.toHomePage();
        footerHelper.footerPress();
        footerHelper.verificationFooterPress();
    }

    @Test
    public void footerPricingLink() {
        //helperBase.toHomePage();
        footerHelper.footerPricing();
        footerHelper.verificationFooterPricing();
    }

    @Test
    public void footerMediaLink() {
        //helperBase.toHomePage();
        footerHelper.footerMedia();
        footerHelper.verificationFooterMedia();
    }

    @Test
    public void footerStaySafeLink() {

        footerHelper.footerStaySafe();
        footerHelper.verificationFooterStaySafe();
    }

    @Test
    public void footerBlogLink() {
        newDriverPage();
        footerHelper.footerBlog();
        verificationHelper.FMBlog();
    }

    @Test
    public void footerBrowseFlatsharesLink() {
        helperBase.toHomePage();
        footerHelper.footerBrowseFlatshares();
        footerHelper.verificationBrowseFlatshares();

    }

    @Test
    public void footerAskLandlord() {
        helperBase.toHomePage();
        footerHelper.footerAskLandlord();
        footerHelper.verificationAskLandlord();
    }

    @Test
    public void footerModern() {
        helperBase.toHomePage();
        footerHelper.footerModern();
        footerHelper.verificationModern();
        helperBase.toHomePage();
    }

    @Test
    public void footerBrowseHowItWorksLink() {
        //helperBase.toHomePage();
        footerHelper.footerHowItWorks();
        footerHelper.verificationHowItWorks();
    }

    @Test
    public void footerBrowseTipsLink() {
        //helperBase.toHomePage();
        footerHelper.footerTipsWorks();
        footerHelper.verificationTipsWorks();

    }

    @Test
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

    @Test
    public void footerTwitterLink() {
        helperBase.toHomePage();
        footerHelper.footerTwitter();
        footerHelper.verificationTwitter();
    }

    @Test
    public void footerInstagramLink() {
        helperBase.toHomePage();
        footerHelper.footerInstagram();
        footerHelper.verificationInstagram();

    }

    @Test
    public void footerYoutubeLink() {
        helperBase.toHomePage();
        footerHelper.footerYoutube();
        clearCache();
        footerHelper.verificationYoutube();

    }



}
