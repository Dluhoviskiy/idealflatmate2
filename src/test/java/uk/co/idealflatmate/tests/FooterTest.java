package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class FooterTest extends TestBase {

    /*@AfterTest
    public void goHomePage(){
        //helperBase.toHomePage();
        navigator.back();
    }*/

  //  @Test
    public void footerHomeLink() {

        pageUrlVerifLiveGoStage();
        footerHelper.footerHome();
        footerHelper.verificationFooterHome();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerAboutUsLink() {

        pageUrlVerifLiveGoStage();
        footerHelper.footerAboutUs();
        footerHelper.verificationFooterAboutUs();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerContactLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerContact();
        footerHelper.verificationFooterContact();
        helperBase.toHomePage();
    }

   // @Test
    public void footerPressLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerPress();
        footerHelper.verificationFooterPress();
        helperBase.toHomePage();
    }

   // @Test
    public void footerPricingLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerPricing();
        footerHelper.verificationFooterPricing();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerMediaLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerMedia();
        footerHelper.verificationFooterMedia();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerStaySafeLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerStaySafe();
        footerHelper.verificationFooterStaySafe();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerBlogLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerBlog();
        verificationHelper.FMBlogPage();
        helperBase.toHomePage();
    }

   // @Test
    public void footerBrowseFlatsharesLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerBrowseFlatshares();
        footerHelper.verificationBrowseFlatshares("North London");
        helperBase.toHomePage();
    }

   // @Test
    public void footerAskLandlord() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerAskLandlord();
        footerHelper.verificationAskLandlord();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerModern() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerModern();
        footerHelper.verificationModern();
        helperBase.toHomePage();
        helperBase.toHomePage();
    }

 //   @Test
    public void footerBrowseHowItWorksLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerHowItWorks();
        footerHelper.verificationHowItWorks();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerBrowseTipsLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerTipsWorks();
        footerHelper.verificationTipsWorks();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerNLALink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerNLAWorks();
        footerHelper.verificationNLAWorks();
        helperBase.toHomePage();
    }

  //  @Test(enabled = false)
    public void footerFBLink() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerFB();
        footerHelper.verificationFB();

    }

   // @Test
    public void footerTwitterLink() {
        pageUrlVerifLiveGoStage();

        footerHelper.footerTwitter();
        footerHelper.verificationTwitter();
    }

  //  @Test
    public void footerInstagramLink() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerInstagram();
        footerHelper.verificationInstagram();

    }

  //  @Test
    public void footerYoutubeLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerYoutube();
        clearCache();
        footerHelper.verificationYoutube();
    }



}
