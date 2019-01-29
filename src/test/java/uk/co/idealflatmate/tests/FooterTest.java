package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;
import uk.co.idealflatmate.appmanager.FooterHelper;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static uk.co.idealflatmate.appmanager.HelperBase.closeAdvPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class FooterTest extends TestBase {

    /*@AfterTest
    public void goHomePage(){
        //helperBase.toHomePage();
        navigator.back();
    }*/
   // FooterHelper test1 = new FooterHelper();

    @Test
    public void footerHomeLink() {

        footerHelper.footerClick("Home");
        footerHelper.verificationFooterHome();
        helperBase.toHomePage();
    }

    @Test
    public void footerAboutUsLink() {

        footerHelper.footerClick("About us");
        footerHelper.verificationFooter("About us");
        helperBase.toHomePage();
    }

    @Test
    public void footerContactLink() {

        footerHelper.footerClick("Contact");
        footerHelper.verificationFooter("Contact");
        helperBase.toHomePage();
    }

    @Test
    public void footerPressLink() {

        footerHelper.footerClick("Press");
        footerHelper.verificationFooter("Press");
        helperBase.toHomePage();
    }

    @Test
    public void footerPricingLink() {

        footerHelper.footerClick("Pricing");
        footerHelper.verificationFooter("Pricing");
        helperBase.toHomePage();
    }

    @Test
    public void footerMediaLink() {

        footerHelper.footerClick("Media");
        footerHelper.verificationFooter("Media");

    }

    @Test
    public void footerStaySafeLink() {

        footerHelper.footerClick("Stay safe");
        footerHelper.verificationFooter("Security warning");

    }

    @Test
    public void footerBlogLink() {

        footerHelper.footerClick("Blog");
        verificationHelper.FMBlogPage();

    }

    @Test
    public void footerBrowseFlatsharesLink() {

        System.out.println("Browse Flatshares - Click");
        footerHelper.footerClick("Browse Flatshares");
        System.out.println("verif - North London, Brent Park");
        footerHelper.verificationBrowseFlatshares("North London", "Brent Park");
            }

    @Test
    public void footerAskLandlord() {

        helperBase.toHomePage();
        footerHelper.footerClick("#AskTheLandlord");
        footerHelper.verificationAskLandlord();
        helperBase.toHomePage();
    }

    @Test
    public void footerModern() {

        helperBase.toHomePage();
        footerHelper.footerClick("Modern Living Index");
        footerHelper.verificationModern();

    }

    @Test
    public void footerBrowseHowItWorksLink() {

        footerHelper.footerClick("How it works");
        footerHelper.verificationHowItWorks();
        helperBase.toHomePage();
    }

    @Test
    public void footerBrowseTipsLink() {

        footerHelper.footerClick("Tips");
        footerHelper.verificationFooter("Tips");
        helperBase.toHomePage();
    }

    @Test
    public void footerNLALink() {

        footerHelper.footerNLAWorks();
        footerHelper.verificationNLAWorks();
        //helperBase.toHomePage();
    }

    //@Test
    public void footerFBLink() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerFB();
        footerHelper.verificationFB();

    }

    @Test
    public void footerTwitterLink() {

        footerHelper.footerTwitter();
        footerHelper.verificationTwitter();
    }

   @Test
    public void footerInstagramLink() {

        footerHelper.footerInstagram();
        footerHelper.verificationInstagram();

    }

    @Test
    public void footerYoutubeLink() {

        footerHelper.footerYoutube();
        refresh();
        footerHelper.verificationYoutube();
    }



}
