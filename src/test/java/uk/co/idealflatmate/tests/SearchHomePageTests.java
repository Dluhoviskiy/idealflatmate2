package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class SearchHomePageTests extends TestBase {

    @Test(priority = 1)
    public void testSearchHomeByButton() {
        searchHelper.searchProperty("PO30");
        searchHelper.verificationSearchFromHomeLocation("PO30 2DN");

    }

    //@Test(priority = 1)
    public void TestSearchHomeByEnter() {
        searchHelper.searchPropertyByEnter("Clapham");
        searchHelper.verificationSearchFromHomeLocation("Clapham, London");

    }
    @Test(priority = 1)
    public void testSearchHomeLocationFromList() {
        searchHelper.searchPropertyBySelectfromList("Clapham");
        searchHelper.verificationSearchFromHomeLocation("Clapham, London");
    }


    @Test(priority = 1)
    public void testSearchHomeIncorrectData() {
        searchHelper.searchProperty("tttt");
        searchHelper.verificationSearchHomePage("Location\n" +  "not found. Please try again.\n" +  "");

    }
    @Test(priority = 1)
    public void testSearchHomePartOfLocationName() {
        searchHelper.searchProperty("wes");
        searchHelper.verificationSearchFromHomeLocation("Bowes Park, London");

    }
    @Test(priority = 1)
    public void testSearchHomeIDProperty() {
        searchHelper.searchProperty("#0012947");
        searchHelper.verificationSearchFromHomeLocationProperty("PO30 2DN");

    }
    @Test(priority = 1)
    public void testSearchHomeNorthLND() {
        searchHelper.searchProperty("North London");
        searchHelper.verificationSearchFromHomeLocation("North London");

    }


}
