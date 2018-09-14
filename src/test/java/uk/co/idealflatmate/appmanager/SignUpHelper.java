package uk.co.idealflatmate.appmanager;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class SignUpHelper extends HelperBase {

    public void clickRoom() {
        $(byXpath("//h3[@class='u_m0' and contains (text(), 'A room')]")).click();
        backFromEmailToRoom();
    }

    public void backFromEmailToRoom() {
        $(byXpath("//a[contains (text(), '« back')]")).click();
        $(byXpath("//h3[@class='u_m0' and contains (text(), 'A room')]")).click();
    }

    public void clickEmailHeader() {
        $(byXpath("//span[contains (text(), 'Sign up with email')]")).click();
    }
    public void clickEmailMatching1() {
        $(byXpath("//a[contains (., 'Sign up with email')]")).click();
    }

    public void setSignUpNameF(String nameF) {
        fillInField(nameF, $(byXpath("//input[@id='yourinfosignupform-username']")), $(byXpath("//input[@id='yourinfosignupform-username']")));
    }

    public void genderFemaleSelect() {

      $(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).click();
      //$(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).selectRadio("Female");
    }
    public void genderMaleSelectAfterBlank() {

        $(byXpath("//div[@id='yourinfosignupform-gender']/label[contains(text(), 'Male')]")).click();
        //$(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).selectRadio("Female");
    }


    public void genderMaleSelect() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Male')]")).click();
    }

    public void setSignEmail(String email) {
        fillInField(email, $(byXpath("//input[@id='yourinfosignupform-email']")), $(byXpath("//input[@id='yourinfosignupform-email']")));
    }

    public void setSignPassword(String password) {
        fillInField(password, $("input#yourinfosignupform-password"), $("input#yourinfosignupform-password"));
    }

    public void clickFormSignUpContinue() {
        $(byXpath("(//button[contains(text(), 'Continue')])[1]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }
    public void clickYourInformationContinue() {
        $(byXpath("//button[contains(text(), 'Continue')]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }

    public void profilePhotoAdd() {
        $(byXpath("//input[@id='moreinfosignupform-file']")).uploadFile(new File("src/test/resources/profile1.jpeg"));
        sleep(2000);
    }

    public void profilePhotoRemove() {
        $(byXpath("//div[@onclick='removeUploadImage()']")).waitUntil(appears, 4000).click();
        sleep(3000);

    }
    public void profileDateBirthAdd(String day, String month, String year) {
        dateMonthYear(day, month, year);
    }

    public void profilephone(String phone) {
        Field2("#moreinfosignupform-phone", "#moreinfosignupform-phone", "#moreinfosignupform-phone", phone);
    }

    public void occupation(String prof) {
        $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).selectOptionByValue(prof);
    }

    public void aboutYourself(String text) {
        $(byXpath("//textarea[@id='moreinfosignupform-bio']")).setValue(text);

    }

    public void preferredLocation(String location, String text) {
        FieldEnter("input#location", "input#location", "input#location", location);
        $$(byXpath("//button[@class='btn btn-primary-outline btn-sm u_m10-bottom u_m10-right']")).get(2).click();
        $("input#location").setValue(text);
        $("#ui-id-1").click();
    }

    public void backLocation() {
        $(byXpath("//a[contains (text(), '« back')]")).click();

    }

    public void budget() {
        //$(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//div[@class='noUi-handle noUi-handle-upper']")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//div[@class='text-11 u_m35-top text-center']")));
    }


    public void verifyToMoveCheckboxDisabled() {
        //$(byXpath("//div[@class='form-group field-budgetpreferredsignupform-move_in_now has-success']//input[@type='checkbox']")).shouldBe(checked);
        $("select#budgetpreferredsignupform-move_in_day").shouldHave(disabled);
    }
    public void toMoveCheckboxEnabled() {
        //$(byXpath("//div[@class='form-group field-budgetpreferredsignupform-move_in_now has-success']//input[@type='checkbox']")).shouldBe(checked);
        $(byXpath("//label[@for='budgetpreferredsignupform-move_in_now']")).click();


    }

    public void verificationDataProfile() {
        $(byXpath("//div[@class='col-sm-5 h5 heading-spaced text-normal u_m20-top u_m30-top-md text-normal-weight']")).shouldHave(text("Preferred location: London\n" +
                "Preferred location2: South London\n" +
                "Preferred location3: Hackney Marshes\n" +
                "Budget: £2500 pm\n" +
                "Ready to move in: now"));
    }

    public void verificationDataProfileRole(String role) {
        $(byXpath("//p[@class=' text-18']")).shouldHave(text(role));

    }

    public void verificationDataProfileFotoDashboard() {
        $(byXpath("//div[@class='row u_m40-bottom-xs']//a/img[@src='/images/no-image-initial-square.jpg']")).shouldNot(exist);

    }

    public void clickFM() {
       $(byXpath("//h3[@class='u_m0' and contains (text(), 'A flatmate for my vacant room')]")).click();

    }

    public void verificationDataFBYourInf(String FirstName, String email, String password) {
        $(byXpath("//input[@id='yourinfosignupform-username']")).shouldHave(value(FirstName));
        $(byXpath("//input[@id='yourinfosignupform-email']")).shouldHave(value(email));
        $(byXpath("yourinfosignupform-password")).shouldHave(value(password));
    }

    public void quit() {
        $(byXpath("//a[@class='btn btn-primary u_ef-right u_m5-top-xs u_m10-top-sm u_m15-right']")).click();

    }

    public void selectMoveDate(String day, String month, String year) {
        dateMonthYearMove(day, month, year);
    }

    public void selectHappyReceiveNews() {
        $(byXpath("//label[@for='budgetpreferredsignupform-is_subscribed']")).click();
    }

    public void verificationDataProfileFull() {
        $(byXpath("//div[@class='col-sm-5 h5 heading-spaced text-normal u_m20-top u_m30-top-md text-normal-weight']")).shouldHave(text("Preferred location: London\n" +
                "Preferred location2: South London\n" +
                "Preferred location3: Hackney Marshes\n" +
                "Budget: £2500 pm\n" +
                "Ready to move in: 08/08/19"));
    }


    public void clickShowMeMyMatches() {
        $(byXpath("//a[contains(., 'Show me my matches! ')]")).click();
    }

    public void clickListYourRoomMatching() {
        $(byXpath("//a[contains(., 'List your room! ')]")).click();
    }
    public void clickSearchFMMatching() {
        $(byXpath("//a[contains(., 'Search for a flatmate ')]")).click();
    }

    public void clearEmail() {
        $(byXpath("//input[@id='yourinfosignupform-email']")).clear();
    }

    public void clearFirstname() {
        $(byXpath("//input[@id='yourinfosignupform-username']")).clear();
    }

    public void clearPassword() {
        $("input#yourinfosignupform-password").clear();
    }

    //a[contains(., 'Search for a flatmate ')]
}
