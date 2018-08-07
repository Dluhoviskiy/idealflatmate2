package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddListingTests extends TestBase {

    @Test (priority = 1)
    public void TestSuccessfulLoginStartListing() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FHListingPaid@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        verificationHelper.closeMatchingPopup();
        //verificationHelper.verifyNoProperty();
        paymentsHelper.addPropertyHelper.pressAddListingFromHeaderWithVerificationUnfinishedlisting();
        paymentsHelper.addPropertyHelper.setPostalCode("SE1");
        getAddPropertyHelper().pressContinue1();
        authorizationHelper.logoutFromApp();
    }

    @Test (priority = 1)
    public void TestSignUpSuccessfulPropertyAdding() {

        paymentsHelper.addPropertyHelper.pressAddYourListingNotLoggedUser();
        addPropertyHelper.selectLandlord();
        addPropertyHelper.pressContinue();
        authorizationHelper.setNewLoginMailListing("cro.LandLordPayment@gmail.com");
        authorizationHelper.setNewLoginNameFListing("Ronald");
        authorizationHelper.setNewLoginNameLListing("Tramp");
        authorizationHelper.setNewLoginPasswordListing("qqqqqq");
        authorizationHelper.setNewLoginPasswordPasswordConfirm("qqqqqq");
        authorizationHelper.setPhoneNumberListing("555555555");
        verificationHelper.is_subscribedClassicSignUpListing();
        verificationHelper.ageConfirmCheckClassicSignUpListing();
        addPropertyHelper.pressContinue();
        //emailHelper.emailVerification("Ronald");
        //addPropertyHelper.pressContinue();
        paymentsHelper.addPropertyHelper.setPostalCode("SE1");
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.chooseAreaforLondon();
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.setTotalBedrooms();
        paymentsHelper.addPropertyHelper.setMonthlyRent("500");
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.ContinueListingWithoutPhoto();
        paymentsHelper.addPropertyHelper.finishPropertyCreatingWithoutPhoto();
        verificationHelper.verifyAddedProperty();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserNoNameOnHomePage("Ronald");
    }

    @Test (priority = 2)
    public void TestSuccessfulPropertyAddingWithAllFields() {

        authorizationHelper.clickSignInButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.Agency@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        //verificationHelper.verifyNoOldProperty();
       // getAddPropertyHelper().RemoveListing();
        //paymentsHelper.addPropertyHelper.pressAddListingFromHeaderWithVerificationUnfinishedlisting();
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
        addPropertyHelper.uploadProperty3Photos();
        addPropertyHelper.finishPropertyCreatingAgency();
       // getAddPropertyHelper().pressAddListingFromHello();
        getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.photoListingExist();
        verificationHelper.verifyAddedPropertyWithAllFields();
        getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().RemoveListing();
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();
    }

    @Test (priority = 1)
    public void TestSignUpWithBlankFieldsPropertyAdding() {

        paymentsHelper.addPropertyHelper.pressAddYourListingNotLoggedUser();
        addPropertyHelper.selectLandlord();
        addPropertyHelper.pressContinue();
        addPropertyHelper.pressContinue1();
        verificationHelper.verificationEmailErrorListing();
        verificationHelper.verificationNameFErrorListing();
        verificationHelper.verificationNameLErrorListing();
        verificationHelper.verificationPasswordErrorListing();
        verificationHelper.verificationPasswordConfirmErrorListing();
        verificationHelper.verificationCheckAgeError();

    }
}











