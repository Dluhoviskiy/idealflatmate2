package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class FooterTest extends TestBase {

    @Test
    public void footerHomeLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerHome();
        footerHelper.verificationFooterHome();
    }

    @Test
    public void footerAboutUsLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerAboutUs();
        footerHelper.verificationFooterAboutUs();
    }

    @Test
    public void footerContactLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerContact();
        footerHelper.verificationFooterContact();
    }

    @Test
    public void footerPressLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerPress();
        footerHelper.verificationFooterPress();
    }

    @Test
    public void footerPricingLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerPricing();
        footerHelper.verificationFooterPricing();
    }

    @Test
    public void footerMediaLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerMedia();
        footerHelper.verificationFooterMedia();
    }

    @Test
    public void footerStaySafeLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerStaySafe();
        footerHelper.verificationFooterStaySafe();
    }

    @Test
    public void footerBlogLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerBlog();
        homePageHelper.verificationFMBlog();
    }

    @Test
    public void footerBrowseFlatsharesLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerBrowseFlatshares();
        footerHelper.verificationBrowseFlatshares();
    }

    @Test
    public void footerBrowseHowItWorksLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerHowItWorks();
        footerHelper.verificationHowItWorks();
    }

    @Test
    public void footerBrowseTipsLink() {
        verificationHelper.closeAdvPopUp();
        footerHelper.footerTipsWorks();
        footerHelper.verificationTipsWorks();
    }







}
