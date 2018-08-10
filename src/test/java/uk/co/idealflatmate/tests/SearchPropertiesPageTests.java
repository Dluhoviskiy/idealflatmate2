package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class SearchPropertiesPageTests extends TestBase{

    @Test(priority = 1)
    public void searchHomeCards() {

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.amountPropertyCards(12);
       searchHelper.firstCard();

    }



}
