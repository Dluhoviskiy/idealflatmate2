package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class AreaPageTest extends TestBase {

    @Test
    public void testAreaFirstFeaturedHomePageHeader() {
        areaPageHelper.clickArea();
        areaPageHelper.clickHeaderItem();

    }
    @Test
    public void testAreaFirstFeaturedLinkMap() {
        newDriverPage();
        areaPageHelper.clickArea();
        areaPageHelper.checklinkMap();


    }
    @Test
    public void testAreaFirstFeaturedLinkArea() {
        newDriverPage();
        areaPageHelper.clickArea();
        areaPageHelper.checklinkNearbyAreas();

    }
    @Test
    public void testAreaFirstFeaturedLinkArea1() {
        newDriverPage();
        areaPageHelper.clickArea();
        areaPageHelper.checklinkSeeMoreRooms();

    }

    @Test
    public void testAreaFirstFeaturedLinkFH() {
        newDriverPage();
        areaPageHelper.clickArea();
        areaPageHelper.checklinkFH();

    }
    @Test
    public void testNextAreaFirstFeaturedLinkFooter() {
        newDriverPage();
        areaPageHelper.clickArea();
        areaPageHelper.checklinkFH();

    }
}
