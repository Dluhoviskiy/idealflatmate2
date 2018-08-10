package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class SearchHomePageTests extends TestBase {

    @Test(priority = 1)
    public void searchHomeByButton() {
        searchHelper.searchProperty("PO30");
        searchHelper.verificationSearchFromHomeLocation("PO30 2DN");

    }

    //@Test(priority = 1)
    public void TestSearchHomeByEnter() {
        searchHelper.searchPropertyByEnter("Clapham");
        searchHelper.verificationSearchFromHomeLocation("Clapham, London");

    }
    @Test(priority = 1)
    public void searchHomeLocationFromList() {
        searchHelper.searchPropertyBySelectfromList("Clapham");
        searchHelper.verificationSearchFromHomeLocation("Clapham, London");
    }


    @Test(priority = 1)
    public void searchHomeIncorrectData() {
        searchHelper.searchProperty("tttt");
        searchHelper.verificationSearchHomePage("Location\n" +  "not found. Please try again.\n" +  "");

    }
    @Test(priority = 1)
    public void searchHomePartOfLocationName() {
        searchHelper.searchProperty("wes");
        searchHelper.verificationSearchFromHomeLocation("Bowes Park, London");

    }
    @Test(priority = 1)
    public void searchHomeIDProperty() {
        searchHelper.searchProperty("#0012947");
        searchHelper.verificationSearchFromHomeLocationProperty("PO30 2DN");

    }
    @Test(priority = 1)
    public void searchHomeNorthLND() {
        searchHelper.searchProperty("North London");
        searchHelper.verificationSearchFromHomeLocation("North London");

    }


}
