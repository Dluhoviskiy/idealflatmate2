package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.FooterHelper;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static uk.co.idealflatmate.appmanager.HelperBase.closeAdvPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class FooterTest extends TestBase {

    /*@AfterTest
    public void goHomePage(){
        //helperBase.toHomePage();
        navigator.back();
    }*/
   // FooterHelper test1 = new FooterHelper();

    //@Test
    public void footerHomeLink() {
        //test1.verificationHowItWorks1("How Ideal Flatmate Works");
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Home");
        footerHelper.verificationFooterHome();
        helperBase.toHomePage();
    }

    //@Test
    public void footerAboutUsLink() {

        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("About us");
        footerHelper.verificationFooter("About us");
        helperBase.toHomePage();
    }

   // @Test
    public void footerContactLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Contact");
        footerHelper.verificationFooter("Contact");
        helperBase.toHomePage();
    }

    //@Test
    public void footerPressLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Press");
        footerHelper.verificationFooter("Press");
        helperBase.toHomePage();
    }

    //@Test
    public void footerPricingLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Pricing");
        footerHelper.verificationFooter("Pricing");
        helperBase.toHomePage();
    }

   // @Test
    public void footerMediaLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Media");
        footerHelper.verificationFooter("Media");

    }

   // @Test
    public void footerStaySafeLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Stay safe");
        footerHelper.verificationFooter("Security warning");

    }

   // @Test
    public void footerBlogLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Blog");
        verificationHelper.FMBlogPage();

    }

   // @Test
    public void footerBrowseFlatsharesLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Browse Flatshares");
        footerHelper.verificationBrowseFlatshares("North London", "Brent Park");
            }

   // @Test
    public void footerAskLandlord() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerClick("#AskTheLandlord");
        footerHelper.verificationAskLandlord();
        helperBase.toHomePage();
    }

  // @Test
    public void footerModern() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerClick("Modern Living Index");
        footerHelper.verificationModern();

    }

  // @Test
    public void footerBrowseHowItWorksLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("How it works");
        footerHelper.verificationHowItWorks();
        helperBase.toHomePage();
    }

  //  @Test
    public void footerBrowseTipsLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerClick("Tips");
        footerHelper.verificationFooter("Tips");
        helperBase.toHomePage();
    }

   // @Test
    public void footerNLALink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerNLAWorks();
        footerHelper.verificationNLAWorks();
        helperBase.toHomePage();
    }

   // @Test
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

   @Test
    public void footerInstagramLink() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerInstagram();
        footerHelper.verificationInstagram();

    }

    @Test
    public void footerYoutubeLink() {
        pageUrlVerifLiveGoStage();
        footerHelper.footerYoutube();
        refresh();
        footerHelper.verificationYoutube();
    }



}
