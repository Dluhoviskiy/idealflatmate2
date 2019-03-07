package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class SearchHomePageTests extends TestBase {

    @Test
    public void searchHomeByButton() {
        clearCache();
        searchHelper.searchPropertyHome("PO30 2DN");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("1 room matched to rent in and around PO30");
        helperBase.toHomePage();
    }

    @Test
    public void TestSearchHomeByEnter() {
        clearCache();
        searchHelper.searchPropertyByEnter("Clapham");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchOnFMPage("7 rooms matched to rent in and around Clapham");
        helperBase.toHomePage();
    }
    @Test
    public void searchHomeLocationFromList() {
        clearCache();
        searchHelper.searchPropertyBySelectfromList("Clapham", "Clapham Junction");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("1 room matched to rent in and around Clapham Junction");
        helperBase.toHomePage();
    }


    //@Test
    public void searchHomeIncorrectData() {
        clearCache();
        searchHelper.searchPropertyHome("ttttttttt");
        searchHelper.verificationSearchHomePage("Location\n" +  "not found. Please try again.\n" +  "");
        helperBase.toHomePage();
    }
    @Test
    public void searchHomePartOfLocationName() {
        searchHelper.searchPropertyHome("wellessbour we");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("0 room matched to rent in and around Wellesbourne West");
        helperBase.toHomePage();
    }
    @Test
    public void searchHomeIDProperty() {
        clearCache();
        searchHelper.searchPropertyHome("#0013119");
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchPropertyMap(" London SE6 4RU, UK");
        helperBase.toHomePage();
    }
    //@Test
    public void searchHomNeNorthLND() {
        clearCache();
        searchHelper.searchPropertyHome("North London");
        sleep(10000);
        searchHelper.closePopupSignup();
        searchHelper.verificationSearchProperty("North London");
        //helperBase.toHomePage();
    }


}
