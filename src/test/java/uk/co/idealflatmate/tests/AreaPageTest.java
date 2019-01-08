package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlHomeNew;

public class AreaPageTest extends TestBase {

    @Test
    public void testAreaFirstFeaturedHomePageHeader() {

        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(0).text();
        areaPageHelper.clickArea(0);
        areaPageHelper.checkAreaName(area1);
        areaPageHelper.clickHeaderItem();
        pageUrlHomeNew();
    }

    @Test
    public void testAreaFirstFeaturedLinkArea() {
        //newDriverPage();
        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(2).text();
        areaPageHelper.clickArea(1);
        areaPageHelper.clicklinkNearbyAreas();
        areaPageHelper.checklinkNearbyAreas(area1);
        areaPageHelper.checkSortDropDownRoom();
        areaPageHelper.pagination();
        pageUrlHomeNew();
    }

    @Test
    public void testAreaFirstFeaturedLinkMap() {

        areaPageHelper.clickArea(2);
        areaPageHelper.checklinkMap();
        pageUrlHomeNew();

    }

    @Test
    public void testAreaSeeMoreRooms() {

        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(4).text();
        areaPageHelper.clickArea(2);
        areaPageHelper.clickMoreRooms();
        areaPageHelper.checkLinkSeeMoreRooms(area1);
        areaPageHelper.checkNumberOfProperties();
        areaPageHelper.checkSortDropDownRoom();
        areaPageHelper.pagination();
        pageUrlHomeNew();
    }

    @Test
    public void testAreaLinkFH() {

        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(0).text();
        areaPageHelper.clickArea(0);
        areaPageHelper.checklinkFH(area1);
        areaPageHelper.checkSortDropDownFM();
        areaPageHelper.pagination();
        pageUrlHomeNew();
    }
    @Test
    public void testExploreMoreArea() {

        areaPageHelper.clickArea(1);
        areaPageHelper.checkArrowsBrowsAll();
        areaPageHelper.checkAllAreas("Liverpool");
        //pageUrlHomeNew();
    }
}
