package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddListingTests extends TestBase {

    @Test
    public void SuccessfulPropertyAddingOnlyWithRequiredFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage();
        authorizationHelper.setPassword();
        paymentsHelper.addPropertyHelper.pressAddListingFromHeader();
        paymentsHelper.addPropertyHelper.setPostalCode();
        paymentsHelper.addPropertyHelper.chooseAreaforLondon();
        getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.setTotalBedrooms();
        paymentsHelper.addPropertyHelper.setMonthlyRent();
        paymentsHelper.addPropertyHelper.uploadPropertyPhoto();
        paymentsHelper.addPropertyHelper.finishPropertyCreating();
        verificationHelper.verifyAddedProperty();
        $(byXpath("//*[@id=\"listing-14501\"]/div[1]/button")).click();
    }

    //@Test
    public void SuccessfulPropertyAddingWithAllFields() {
        authorizationHelper.clickSignInButton();
        authorizationHelper.setLoginAsUserWithoutPackage();
        authorizationHelper.setPassword();
        openDropDownMenu();
        chooseListingsFromDropDownMenu();
        pressAddListingFromBody();
        getAddPropertyHelper().setPostalCode();
        getAddPropertyHelper().chooseAreaforLondon();
        getAddPropertyHelper().pressContinueButton();
        setPhoneNumber();
        getAddPropertyHelper().setTotalBedrooms();
        //setAllAmanities();
        //setPropertyDescription();
        getAddPropertyHelper().setMonthlyRent();
        setDeposit();
        //setTotalBills();

        //setLeasePeriod();
        //setRoomDescription();
        //getAddPropertyHelper().pressContinueButton();
        paymentsHelper.addPropertyHelper.uploadProperty3Photos();
        paymentsHelper.addPropertyHelper.finishPropertyCreating();
        $(byXpath("//*[@id=\"listing-14501\"]/div[1]/button")).click();

    }


    private void setRoomDescription() {
        $("#room-1-description").click();
        $("#room-1-description").setValue("Very comfortable room");
        $("#room-1-description").shouldHave(text("Very comfortable room"));
    }

    private void setLeasePeriod() {
        $("#room-1-min_stay").click();
        $(byXpath("//*[@id=\"room-1-min_stay\"]/option[2]")).click();
        $("#room-1-max_stay").click();
        $(byXpath("#room-1-max_stay > option:nth-child(13)")).click();

    }

    private void setTotalBills() {
        $("#room-1-bills").scrollIntoView(true).setValue("400");
        $("#room-1-bills").shouldHave(value("400"));

    }

    private void setDeposit() {
        $("#room-1-deposit").click();
        $("#room-1-deposit").setValue("1000");
        $("#room-1-deposit").shouldHave(value("1000"));
    }

    private void setPropertyDescription() {
        $(".form-group.field-property-description").scrollIntoView(true).click();
        $(".form-group.field-property-description").setValue("Very good flat");
        $(".form-group.field-property-description").shouldHave(text("Very good flat"));
    }

    private void setAllAmanities() {
        $(byXpath("//*[@id=\"property-property_amenities\"]/div[1]")).click();
        $("#property-pets_accepted").click();
        $("#property-pets_accepted").shouldBe(selected);
        $(byXpath("")).click();
        $(byXpath("")).click();
        $(byXpath("")).click();


    }

    private void setPhoneNumber() {
        $("#property-phone_number").setValue("+44 20 7234 3456");
    }

    public void pressAddListingFromBody() {
        $(byXpath("/html/body/section/section/div/div/a")).click();
    }

    public void chooseListingsFromDropDownMenu() {
        $(byXpath("/html/body/header/div/ul[1]/li/ul/li[10]/a/span")).click();
    }

    public void openDropDownMenu() {
        $(".dropdown.nav-ihm-profile-bars").click();
    }


}
