package uk.co.idealflatmate.appmanager;

import org.testng.Assert;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SignUpHelper extends HelperBase {

    public static void clickRoom1() {
        $(byXpath("//h3[@class='u_m0' and contains (text(), 'A room')]")).click();
        navigator.forward();
    }

    public void clickRoom() {
        $(byXpath("//h3[@class='u_m0' and contains (text(), 'A room')]")).click();
        backFromEmailToRoom();
    }

    public void backFromEmailToRoom() {
        $(byXpath("//a[contains (., 'back')]")).click();
        $(byXpath("//h3[@class='u_m0' and contains (text(), 'A room')]")).click();
    }

    public void clickEmailPopup() {
        $(byXpath("//div[@id='signupRevealModal']//a[span[contains (text(), 'Sign up with email')]]")).click();
    }
    public void clickEmail() { $(byXpath("//span[contains (text(), 'Sign up with email')]")).click();

    }
    public void clickEmailMatching1() {
        $(byXpath("//a[contains (., 'Sign up with email')]")).click();
    }

    public void setSignUpNameF(String nameF) {
        fillInField(nameF, $(byXpath("//input[@id='yourinfosignupform-username']")), $(byXpath("//input[@id='yourinfosignupform-username']")));
    }

    public void setSignUpNameFMessage(String nameF) {
        fillInField(nameF, $(byXpath("//input[@id='yourinfoadditionalsignupform-username']")), $(byXpath("//input[@id='yourinfoadditionalsignupform-username']")));
    }

    public void genderFemaleSelect() {

      $(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).click();
      //$(byXpath("//div[@class='form-group field-yourinfosignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).selectRadio("Female");
    }

    public void genderFemaleSelectMessageError() {
        $(byXpath("//div[@class='form-group field-yourinfoadditionalsignupform-gender required has-error']/div[1]/label[contains(text(), 'Female')]")).click();
    }

    public void genderFemaleSelectMessage() {
        $(byXpath("//div[@class='form-group field-yourinfoadditionalsignupform-gender required']/div[1]/label[contains(text(), 'Female')]")).click();
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

    public void setSignEmailMessage(String email) {
        fillInField(email, $(byXpath("//input[@id='yourinfoadditionalsignupform-email']")), $(byXpath("//input[@id='yourinfoadditionalsignupform-email']")));
    }

    public void setSignPassword(String password) {
        fillInField(password, $("input#yourinfosignupform-password"), $("input#yourinfosignupform-password"));
    }

    public void setSignPasswordMessage(String password) {
        fillInField(password, $("input#yourinfoadditionalsignupform-password"), $("input#yourinfoadditionalsignupform-password"));
    }

    public void clickFormSignUpContinue() {
        $(byXpath("(//button[contains(text(), 'Continue')])[1]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }
    public void clickYourInformationContinue() {
        $(byXpath("//button[contains(text(), 'Continue')]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }

    public void clickCompleteSearchPref() {

        $(byXpath("//button[@class='btn btn-block btn-primary ws-normal u_m20-bottom']")).waitUntil(appears, 8000).click();
        sleep(2000);
    }

    public void profilePhotoAddJpeg() {
        $(byXpath("//input[@id='moreinfosignupform-file']")).uploadFile(new File("src/test/resources/profile1.jpeg"));
        sleep(2000);
    }
    public void profilePhotoAddPng() {
        $(byXpath("//input[@id='moreinfosignupform-file']")).uploadFile(new File("src/test/resources/Profile.png"));
        sleep(2000);
    }
    public void profilePhotoAddJpg() {
        $(byXpath("//input[@id='moreinfosignupform-file']")).uploadFile(new File("src/test/resources/Property1.jpg"));
        sleep(2000);
    }

    public void profilePhotoAddJpeg10Mb() {
        $(byXpath("//input[@id='moreinfosignupform-file']")).uploadFile(new File("src/test/resources/8mb-artwork.jpg"));
        sleep(2000);
    }

    public void profilePhotoAddPdf() {
        $(byXpath("//input[@id='moreinfosignupform-file']")).uploadFile(new File("src/test/resources/IF-pdf.pdf"));
        sleep(2000);
    }

    public void profilePhotoRemove() {
        $(byXpath("//div[@onclick='Auth.removeUploadImage()']")).waitUntil(appears, 4000).click();
        sleep(3000);

    }
    public void profileDateBirthAdd(String day, String month, String year) {
        dateMonthYear(day, month, year);
    }

    public void profileDateBirthAddMessage(String day, String month, String year) {
        dateMonthYearMessage(day, month, year);
    }

    public void profilePhone(String phone) {
        Field2("#moreinfosignupform-phone",
                "#moreinfosignupform-phone",
                "#moreinfosignupform-phone",
                 phone);
    }

    public void profilePhoneMessage(String phone) {
        Field2("#messagewritesignupform-phone",
                "#messagewritesignupform-phone",
                "#messagewritesignupform-phone",
                phone);
    }

    public void occupation(String prof) {
        $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).selectOptionByValue(prof);
    }

    public void aboutYourself(String text) {
        $(byXpath("//textarea[@id='moreinfosignupform-bio']")).setValue(text);

    }

    public void preferredLocation(String location, String area1) {
        FieldEnter(location, area1);

    }

    public void preferredLocationButton(String area2) {
        $(byXpath("//a[starts-with(@class,'btn btn-primary-outline') and contains(.,'" + area2 + "')]")).click();
    }

    public void backLocation() {
        $(byXpath("//a[contains (., 'back')]")).click();

    }

    public static void budgetMin() {
        //$(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//div[@class='noUi-handle noUi-handle-upper']")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//div[@class='text-11 u_m35-top text-center']")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//div/span[@class='text-14']")));
    }

    public static void budgetMax() {
        //$(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//div[@class='noUi-handle noUi-handle-upper']")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-upper']")).dragAndDropTo($(byXpath("//div[@class='text-11 u_m35-top text-center']")));
        //$(byXpath("//div[@class='noUi-handle noUi-handle-upper']")).dragAndDropTo($(byXpath("//div[@class='text-11 u_m35-top text-center']")));
    }


    public void verifyToMoveCheckboxDisabled() {
        //$(byXpath("//div[@class='form-group field-budgetpreferredsignupform-move_in_now has-success']//input[@type='checkbox']")).shouldBe(checked);
        $("select#budgetpreferredsignupform-move_in_day").shouldHave(disabled);
    }
    public void toMoveCheckboxEnabled() {
        //$(byXpath("//div[@class='form-group field-budgetpreferredsignupform-move_in_now has-success']//input[@type='checkbox']")).shouldBe(checked);
        $(byXpath("//label[@for='budgetpreferredsignupform-move_in_now']")).click();
    }

    public void verificationDataProfileFullAgent() {
        $(byXpath("//div[@class='col-sm-5 h5 heading-spaced text-normal u_m20-top u_m30-top-md text-normal-weight']")).shouldNot(exist);
    }

    public void verificationDataProfileNameUser(String name, String age) {
        $(byXpath("//h2/strong")).shouldHave(text(name));
        $(byXpath("//h2/span")).shouldHave(text(age));
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
        $(byXpath("//a[starts-with(@class,'btn btn--type-2')]")).click();
    }

    public void selectMoveDate(String day, String month, String year) {
        dateMonthYearMove(day, month, year);
    }

    public void selectHappyReceiveNews() {
        $(byXpath("//label[@for='budgetpreferredsignupform-is_subscribed']")).click();
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

    public void clearEmailMessage() {
        $(byXpath("//input[@id='yourinfoadditionalsignupform-email']")).clear();
    }

    public void clearFirstname() {
        $(byXpath("//input[@id='yourinfosignupform-username']")).clear();
    }

    public void clearFirstnameMessage() {
        $(byXpath("//input[@id='yourinfoadditionalsignupform-username']")).clear();
    }

    public void clearPassword() {
        $("input#yourinfosignupform-password").clear();
    }

    public void clearPasswordMessage() {
        $("input#yourinfoadditionalsignupform-password").clear();
    }

    public void click1PropertyCardMessage() {
        $(byXpath("(//div[@class='card-infos-flex-row']/a[2][@href])[3]")).click();

    }

    public void photoOfOwner(String photo1) {
        if (photo1.endsWith("no-image-initial.jpg")) {
            String photo2 = photo1.substring(0, 77);
            String messagePhoto = $("div.col-xs-12 img").getAttribute("src").substring(0, 77);
            Assert.assertEquals(photo2, messagePhoto);
        } else {
            String photo2 = photo1.substring(0, 73);
            String messagePhoto = $("div.col-xs-12 img").getAttribute("src").substring(0, 73);
            Assert.assertEquals(photo2, messagePhoto);

        }

    }

    public void verificationAutoMessageProperty(String name1) {

        String messagePlaceholder = $("textarea#messagewritesignupform-message").text();
        String name2 = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String name4 = "Hi " + name3 + ", your room looks great! Are you holding viewings?";
        Assert.assertEquals(name4, messagePlaceholder);
    }

    public void verificationAutoMessageFM(String name1) {

        String messagePlaceholder = $("textarea#messagewritesignupform-message").text();
        String name2 = (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String name4 = "Hi " + name3 + ", looks like we are well matched. When are you looking to move?";
        Assert.assertEquals(name4, messagePlaceholder);
    }

    public void nameOfOwner(String name1) {
        //String name2 = "Message " + (name1.substring(0, 1).toUpperCase() + name1.substring(1)).replaceAll("[^a-zA-z]",  "");
        String name2 = "Message " + (name1.substring(0, 1).toUpperCase() + name1.substring(1));
        String name3 =(name2.split(","))[0].replaceAll("/,",  "");
        String nameInMessage = $("h1").getText();
        Assert.assertEquals(name3, nameInMessage);
    }


    public void clickBackToSearch() {
        $(byXpath("//button[@value='back_to_search']")).waitUntil(visible, 10000).click();
    }

    public void titleOfSearchPage(String title1) {
        String title2 = $(byXpath("//head/title")).getText();
        Assert.assertEquals(title1, title2);

    }

    public void clickSubmit() {
        $(byXpath("//button[@type='submitLogin']")).click();
    }

    public void clickPropertyCard1() {
        $$(byXpath("//div[@class='card-img']")).get(1).click();

    }

    public void clickMessageProperty(String buttonText) {
        $(byXpath("//section//a[contains(.,'" + buttonText + "')]")).click();

    }

    public void clickLikePropertyCard() {
        $$(byXpath("//a[starts-with(@class,'buddy')]")).get(3).click();

    }

    public void backToSearch() {
        $(byXpath("//button[starts-with(@class,'btn-link')]")).click();

    }

    public void clickLikePropertyCardHomePage(int propertyPage) {

        $(byXpath("(//button[starts-with(@class,'owl-next')])[2]")).hover();

        $(byXpath("(//button[starts-with(@class,'owl-next')])[2]")).click();

        $(byXpath("(//button[starts-with(@class,'owl-prev')])[2]")).hover().click();

        $$(byXpath("//a[starts-with(@class,'buddy-star')]")).get(propertyPage).click();
        sleep(4000);
    }

    public void removeLike() {
        $(byXpath("//span[starts-with(@class,'saved-property')]")).click();
        sleep(4000);
        $(byXpath("//button[@class='confirm']")).waitUntil(appear, 6000).click();
        sleep(4000);

    }

    public void yourInformation(String password, String firstName, String email) {
        setSignUpNameF(firstName);
        genderFemaleSelect();
        setSignEmail(email);
        setSignPassword(password);
        clickYourInformationContinue();
    }

    public void yourInformationWithPhone (String password, String firstName, String email) {
        setSignUpNameF(firstName);
        genderFemaleSelect();
        setSignEmail(email);
        setSignPassword(password);
        clickYourInformationContinue();
    }

    public void priceMove(String day, String month, String year) {
        verifyToMoveCheckboxDisabled();
        toMoveCheckboxEnabled();
        selectMoveDate(day, month, year);
        selectHappyReceiveNews();
        clickYourInformationContinue();
    }

    public void whereWouldLikeLive(String location, String area1) {
        preferredLocation(location, area1);
        clickYourInformationContinue();
    }

    public void MoreAboutYou(String day, String month, String year, String phone, String prof, String text) {
        profilePhotoAddJpeg();
        profileDateBirthAdd(day, month, year);
        profilePhone(phone);
        occupation(prof);
        aboutYourself(text);
        clickYourInformationContinue();
    }

}
