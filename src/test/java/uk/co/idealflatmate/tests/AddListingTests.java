package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddListingTests extends TestBase {

    @Test
    public void TestSuccessfulPropertyAddingOnlyWithRequiredFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        //verificationHelper.verifyNoProperty();
        paymentsHelper.addPropertyHelper.pressAddListingFromHeader();
        paymentsHelper.addPropertyHelper.setPostalCode("SE1");
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.chooseAreaforLondon();
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.setTotalBedrooms();
        paymentsHelper.addPropertyHelper.setMonthlyRent("500");
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.uploadPropertyPhoto();
        paymentsHelper.addPropertyHelper.finishPropertyCreating();
        verificationHelper.verifyAddedProperty();
        getAddPropertyHelper().RemoveListing();
        verificationHelper.verifyNoProperty();
    }

    @Test
    public void TestSuccessfulPropertyAddingWithAllFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen44@gmail.com");
        authorizationHelper.setPassword("123456");
        getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        //verificationHelper.verifyNoOldProperty();
       // getAddPropertyHelper().RemoveListing();
        getAddPropertyHelper().pressAddListingFromBody();
        getAddPropertyHelper().setPostalCode("SE1");
        getAddPropertyHelper().pressContinueButton();
        getAddPropertyHelper().chooseRoadFor("Idealstreet");
        getAddPropertyHelper().chooseAreaforLondon();
        getAddPropertyHelper().pressContinueButton();
        getAddPropertyHelper().setPhoneNumber("+44 20 7234 3456");
        getAddPropertyHelper().setTotalBedrooms();
        getAddPropertyHelper().setAllAmanities();
        getAddPropertyHelper().setPropertyDescription();
        getAddPropertyHelper().setMonthlyRent("500");
        getAddPropertyHelper().setDeposit("1000");
        getAddPropertyHelper().setTotalBills("400");
        getAddPropertyHelper().setLeasePeriodFirstRoom();
        getAddPropertyHelper().setRoomDescription();
        getAddPropertyHelper().copySecondRoom();
        getAddPropertyHelper().removeSecondRoom();
        getAddPropertyHelper().copySecondRoom();
        getAddPropertyHelper().addAnotherRoom();
        getAddPropertyHelper().setAnotherMonthlyRent("800");
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
        verificationHelper.verifyNoProperty();
    }
}











