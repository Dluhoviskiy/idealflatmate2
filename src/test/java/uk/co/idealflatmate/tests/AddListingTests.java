package uk.co.idealflatmate.tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddListingTests extends TestBase {

    @Test
    public void SuccessfulPropertyAddingOnlyWithRequiredFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage();
        authorizationHelper.setPassword();
        paymentsHelper.addPropertyHelper.pressAddListingFromHeader();
        paymentsHelper.addPropertyHelper.setPostalCode();
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.chooseAreaforLondon();
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.setTotalBedrooms();
        paymentsHelper.addPropertyHelper.setMonthlyRent();
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.uploadPropertyPhoto();
        paymentsHelper.addPropertyHelper.finishPropertyCreating();
        verificationHelper.verifyAddedProperty();
        getAddPropertyHelper().RemoveListing();
        verificationHelper.verifyNoAddedProperty();
    }

    @Test
    public void SuccessfulPropertyAddingWithAllFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage();
        authorizationHelper.setPassword();
        getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoAddedProperty();
        getAddPropertyHelper().pressAddListingFromBody();
        getAddPropertyHelper().setPostalCode();
        getAddPropertyHelper().pressContinueButton();
        getAddPropertyHelper().chooseRoadfor();
        getAddPropertyHelper().chooseAreaforLondon();
        getAddPropertyHelper().pressContinueButton();
        getAddPropertyHelper().setPhoneNumber();
        getAddPropertyHelper().setTotalBedrooms();
        getAddPropertyHelper().setAllAmanities();
        getAddPropertyHelper().setPropertyDescription();
        getAddPropertyHelper().setMonthlyRent();
        getAddPropertyHelper().setDeposit();
        getAddPropertyHelper().setTotalBills();
        getAddPropertyHelper().setLeasePeriodFirstRoom();
        getAddPropertyHelper().setRoomDescription();
        getAddPropertyHelper().copySecondRoom();
        getAddPropertyHelper().removeSecondRoom();
        getAddPropertyHelper().copySecondRoom();
        getAddPropertyHelper().addAnotherRoom();
        getAddPropertyHelper().setAnotherMonthlyRent();
        getAddPropertyHelper().setLeasePeriodSecondRoom();
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.uploadProperty3Photos();
        paymentsHelper.addPropertyHelper.finishPropertyCreating();
       // getAddPropertyHelper().pressAddListingFromHello();
        getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAddedPropertyWithAllFields();
        getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().RemoveListing();
        verificationHelper.verifyNoAddedProperty();
    }
}











