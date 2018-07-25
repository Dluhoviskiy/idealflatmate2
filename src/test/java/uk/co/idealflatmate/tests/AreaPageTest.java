package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class AreaPageTest extends TestBase {

    @Test
    public void testAreaFirstFeaturedHomePageHeader() {
        areaPageHelper.clickArea();
        areaPageHelper.clickHeaderItem();

    }
    @Test
    public void testAreaFirstFeaturedLinkMap() {
        areaPageHelper.clickArea();
        areaPageHelper.checklinkMap();

    }
    @Test
    public void testAreaFirstFeaturedLinkArea() {
        areaPageHelper.clickArea();
        areaPageHelper.checklinkNearbyAreas();
    }
    @Test
    public void testAreaFirstFeaturedLinkArea1() {
        areaPageHelper.clickArea();
        areaPageHelper.checklinkSeeMoreRooms();
    }

    @Test
    public void testAreaFirstFeaturedLinkFH() {
        areaPageHelper.clickArea();
        areaPageHelper.checklinkFH();
    }
    @Test
    public void testNextAreaFirstFeaturedLinkFooter() {
        areaPageHelper.clickArea();
        areaPageHelper.checklinkFH();
    }
}
