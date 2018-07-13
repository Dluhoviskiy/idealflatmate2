package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class FooterTest extends TestBase {

   // @Test
    public void footerHomeLink() {

        footerHelper.footerHome();
        footerHelper.verificationFooterHome();
    }

   // @Test
    public void footerAboutUsLink() {

        footerHelper.footerAboutUs();
        footerHelper.verificationFooterAboutUs();
    }

  //  @Test
    public void footerContactLink() {

        footerHelper.footerContact();
        footerHelper.verificationFooterContact();
    }

  //  @Test
    public void footerPressLink() {

        footerHelper.footerPress();
        footerHelper.verificationFooterPress();
    }

  //  @Test
    public void footerPricingLink() {

        footerHelper.footerPricing();
        footerHelper.verificationFooterPricing();
    }

  //  @Test
    public void footerMediaLink() {

        footerHelper.footerMedia();
        footerHelper.verificationFooterMedia();
    }

  //  @Test
    public void footerStaySafeLink() {

        footerHelper.footerStaySafe();
        footerHelper.verificationFooterStaySafe();
    }

  //  @Test
    public void footerBlogLink() {

        footerHelper.footerBlog();
        homePageHelper.verificationFMBlog();
    }

 //   @Test
    public void footerBrowseFlatsharesLink() {

        footerHelper.footerBrowseFlatshares();
        footerHelper.verificationBrowseFlatshares();
    }

  //  @Test
    public void footerBrowseHowItWorksLink() {

        footerHelper.footerHowItWorks();
        footerHelper.verificationHowItWorks();
    }

  //  @Test
    public void footerBrowseTipsLink() {

        footerHelper.footerTipsWorks();
        footerHelper.verificationTipsWorks();
    }

    //@Test
    public void footerNLALink() {

        footerHelper.footerNLAWorks();
        footerHelper.verificationNLAWorks();
    }

    //@Test
    public void footerFBLink() {

        footerHelper.footerFB();
        footerHelper.verificationFB();
    }

    //@Test
    public void footerTwitterLink() {

        footerHelper.footerTwitter();
        footerHelper.verificationTwitter();
    }

  //  @Test
    public void footerInstagramLink() {

        footerHelper.footerInstagram();
        footerHelper.verificationInstagram();
    }

    @Test
    public void footerYoutubeLink() {

        footerHelper.footerYoutube();
        footerHelper.verificationYoutube();
    }



}
