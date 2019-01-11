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
        helperBase.pageUrlHomeNew();
        footerHelper.footerHome();
        footerHelper.verificationFooterHome();
    }

    @Test
    public void footerAboutUsLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerAboutUs();
        footerHelper.verificationFooterAboutUs();
    }

    @Test
    public void footerContactLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerContact();
        footerHelper.verificationFooterContact();
    }

    @Test
    public void footerPressLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerPress();
        footerHelper.verificationFooterPress();
    }

    @Test
    public void footerPricingLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerPricing();
        footerHelper.verificationFooterPricing();
    }

    @Test
    public void footerMediaLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerMedia();
        footerHelper.verificationFooterMedia();
    }

    @Test
    public void footerStaySafeLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerStaySafe();
        footerHelper.verificationFooterStaySafe();
    }

    @Test
    public void footerBlogLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerBlog();
        verificationHelper.FMBlogPage();
    }

    @Test
    public void footerBrowseFlatsharesLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerBrowseFlatshares();
        footerHelper.verificationBrowseFlatshares("North London");

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
        helperBase.pageUrlHomeNew();
        footerHelper.footerHowItWorks();
        footerHelper.verificationHowItWorks();
    }

    @Test
    public void footerBrowseTipsLink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerTipsWorks();
        footerHelper.verificationTipsWorks();

    }

    @Test
    public void footerNLALink() {
        helperBase.pageUrlHomeNew();
        footerHelper.footerNLAWorks();
        footerHelper.verificationNLAWorks();
        helperBase.toHomePage();
    }

    @Test(enabled = false)
    public void footerFBLink() {
        helperBase.pageUrlHomeNew();;
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
        helperBase.pageUrlHomeNew();
    }



}
