package uk.co.idealflatmate.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static uk.co.idealflatmate.appmanager.AreaPageHelper.numberOfPropAreaPage;
import static uk.co.idealflatmate.appmanager.HelperBase.cardsOnThePage;
import static uk.co.idealflatmate.appmanager.HelperBase.closeAdvPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class AreaPageTest extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();

    }

    @Test
    public void firstFeaturedHomePageHeader() {
        areaPageHelper.areaScroll();
        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(0).text();
        areaPageHelper.clickArea(0);
        areaPageHelper.checkAreaName(area1);
        areaPageHelper.clickHeaderItem("top-spots", "rooms", "flatmates");

    }



    @Test
    public void firstFeaturedLinkArea() {
        areaPageHelper.areaScroll();
        String areaName = $$("#hp-areas div.card-btr-amenities.text-white div").get(0).text();
        areaPageHelper.clickArea(0);
        switchTo().window(1);
        int amountPropOnAreaPage = numberOfPropAreaPage();

        areaPageHelper.clicklinkNearbyAreas();
        Assert.assertTrue(cardsOnThePage().size() >= amountPropOnAreaPage);
        areaPageHelper.checklinkNearbyAreas(areaName, "Display map");//it is the same area

        areaPageHelper.checkSortDropDownRoom("0", "Default");
        areaPageHelper.pagination(exist);

    }

    @Test
    public void firstFeaturedLinkMap() {
        areaPageHelper.areaScroll();
        areaPageHelper.clickArea(2);
        areaPageHelper.checklinkMap();

    }

    @Test
    public void seeMoreRooms() {
        areaPageHelper.areaScroll();
        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(4).text();
        areaPageHelper.clickArea(2);
        areaPageHelper.clickMoreRooms();
        closeAdvPopUp();
        areaPageHelper.checkLinkSeeMoreRooms(area1);
        areaPageHelper.numberPropertiesUnderSearchEqualsCards();
        areaPageHelper.checkSortDropDownRoom("0", "Default");
        areaPageHelper.pagination(exist);

    }

    @Test
    public void linkFH() {
        areaPageHelper.areaScroll();
        String area1 = $$("#hp-areas div.card-btr-amenities.text-white div").get(0).text();
        areaPageHelper.clickArea(0);
        areaPageHelper.checklinkFH(area1);
        areaPageHelper.checkSortDropDownFM();
        areaPageHelper.pagination(exist);

    }
    
   @Test
    public void exploreMoreArea() {
        areaPageHelper.areaScroll();
        areaPageHelper.clickArea(1);
        areaPageHelper.checkArrowsBrowsAll();
        areaPageHelper.checkAllAreas("Liverpool");

    }
}
