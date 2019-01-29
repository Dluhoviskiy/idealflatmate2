package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static uk.co.idealflatmate.appmanager.HelperBase.closeAdvPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class AreaPageTest extends TestBase {

    @Test
    public void firstFeaturedHomePageHeader() {

        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(0).text();
        areaPageHelper.clickArea(0);
        areaPageHelper.checkAreaName(area1);
        areaPageHelper.clickHeaderItem("top-spots", "rooms", "flatmates");

    }

    @Test
    public void firstFeaturedLinkArea() {

        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(0).text();
        areaPageHelper.clickArea(0);
        areaPageHelper.clicklinkNearbyAreas();
        areaPageHelper.checklinkNearbyAreas(area1);
        areaPageHelper.checkSortDropDownRoom();
        areaPageHelper.pagination();

    }

    @Test
    public void firstFeaturedLinkMap() {

        areaPageHelper.clickArea(2);
        areaPageHelper.checklinkMap();

    }

    @Test
    public void seeMoreRooms() {

        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(4).text();
        areaPageHelper.clickArea(2);
        areaPageHelper.clickMoreRooms();
        closeAdvPopUp();
        areaPageHelper.checkLinkSeeMoreRooms(area1);
        areaPageHelper.checkNumberOfProperties();
        areaPageHelper.checkSortDropDownRoom();
        areaPageHelper.pagination();

    }

    @Test
    public void linkFH() {

        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(0).text();
        areaPageHelper.clickArea(0);
        areaPageHelper.checklinkFH(area1);
        areaPageHelper.checkSortDropDownFM();
        areaPageHelper.pagination();

    }
    
   @Test
    public void exploreMoreArea() {

        areaPageHelper.clickArea(1);
        areaPageHelper.checkArrowsBrowsAll();
        areaPageHelper.checkAllAreas("Liverpool");

    }
}
