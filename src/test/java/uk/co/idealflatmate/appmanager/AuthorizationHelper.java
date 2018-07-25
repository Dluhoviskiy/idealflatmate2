package uk.co.idealflatmate.appmanager;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationHelper extends HelperBase {


    public void logoutFromApp() {
        $(".nav.navbar-right.nav-ihm-profile").waitUntil(visible, 4000).click();
        $(byXpath("//li/a[contains(text(), ' Log out')]")).waitUntil(visible, 4000).click();
    }

    public void goToPropertyPage() {
        $(byXpath("(//a[@href='/search' and contains(text(), 'Find a room')])[2]")).waitUntil(appears, 4000).click();
    }

    public void goToFMpage() {
         $(byXpath("(//a[@href='/search/flatmate' and contains(text(), 'Find a flatmate')])[2]")).waitUntil(appears, 4000).click();
     }

    public void setLoginAsUserWithoutPackage(String email) {
        fillInField(email, $("#loginform-username"), "#loginform-username");
    }
    public void setLoginAsUserWithPremiumFlathunterPackage(String email) {
        fillInField(email, $("#loginform-username"), "#loginform-username");
    }

    public void setPassword(String password) {
        $("#loginform-password").waitUntil(visible, 4000).setValue(password);
        $(byXpath("//button[@name='login-button']")).waitUntil(visible, 4000).click();
        sleep(2000);
    }

    public void LoginFacebookWithActiveAccount(String email, String password) {
        $("#email").waitUntil(visible, 4000).setValue(email);
        $("#pass").waitUntil(visible, 4000).setValue(password).pressEnter();
       // $(byXpath("//button[@type='submit' and (contains(text(), 'Продолжить как Александр'))]")).waitUntil(visible, 4000).click();
    }

    public void LoginFacebookWithNewAccount(String email, String password) {
        $("#email").waitUntil(visible, 4000).setValue(email);
        $("#pass").waitUntil(visible, 4000).setValue(password).pressEnter();
       // $(byXpath("//button[@type='submit' and (contains(text(), 'Продолжить как Ronald'))]")).waitUntil(visible, 4000).click();
    }

    public void clickSignInWithFacebook() {
        $(byXpath("//*[@id='login-form']/div[1]/a")).waitUntil(visible, 4000).click();
    }
    public void clickSignUpWithFacebook() {
        $(byXpath("(//a[@class='btn btn-block btn-social btn-facebook u_m10-bottom auth-link facebook js-facebook-url'])[3]")).waitUntil(visible, 4000).click();
    }

    public void clickSignInWithFacebookMatching() {
        $(byXpath("(//a[@class=\"btn btn-block btn-social btn-facebook u_m10-bottom auth-link facebook js-facebook-url\"])[1]")).waitUntil(visible, 4000).click();
    }

    public void setLoginAsUserWithoutPackage2(AuthorizationHelper authorizationHelper) {
        sleep(2000);
        setLoginAsUserWithPremiumFlathunterPackage("cro.gen49@gmail.com");
    }

    public void clickSignUpButton() {
        $(".signup-modal-test").click();
    }

    public void clickSignInButton() {
        $(byXpath("//li/a[contains(text(), 'Log in')]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }

    public void clickLoginSubmitButton() {
        $(byXpath("//button[@name='login-button']")).click();
        sleep(2000);
    }

    public void removeAccount() {
        $(byXpath("//button[@type='submit' and contains(text(), 'Delete!')]")).waitUntil(appears, 4000).click();
        confirm("Are you sure you wish to delete your account?");
        sleep(2000);
    }

    public void alertAccept() {
       //Assert.assertTrue($(By.tagName("p")).isDisplayed());

       confirm("ok");
    }

    public void clickFormSignInPropertyContact() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[2]")).waitUntil(visible, 4000).click();
    }

    public void clickFormSignInContact() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[2]")).waitUntil(visible, 4000).click();
    }
    public void clickFormSignInFMmessage() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[3]")).waitUntil(visible, 4000).click();
    }
    public void clickSignUpButtonInForm() {
        sleep(2000);
        $(byXpath("//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign up')]")).waitUntil(appears, 6000).click();
        sleep(2000);
    }

    public void clickSignInButtonInForm() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[1]")).waitUntil(visible, 6000).click();
    }

    public void setNewLoginMail(String email) {
        fillInField(email, $("#signup-need-email").waitUntil(visible, 6000), "#signup-need-email");
    }

    public void setNewLoginPassword(String password) {
        fillInField(password, $("#signup-need-password"), "#signup-need-password");
    }

    public void setNewLoginNameF(String nameF) {
        fillInField(nameF, $("#signup-need-firstname"), "#signup-need-firstname");
    }

    public void setNewLoginNameL(String nameL) {
        fillInField(nameL, $("#signup-need-lastname"), "#signup-need-lastname");
    }

    public void setNewLoginMailMatching(String email) {
        fillInField(email, $("#signup-survey-email"), "#signup-survey-email");
    }

    public void setNewLoginPasswordMatching(String password) {
        fillInField(password, $("#signup-survey-password"), "#signup-survey-password");
    }

    public void setNewLoginNameFMatching(String nameF) {
        fillInField(nameF, $("#signup-survey-firstname"), "#signup-survey-firstname");
    }

    public void setNewLoginNameLMatching(String nameL) {
        fillInField(nameL, $("#signup-survey-lastname"), "#signup-survey-lastname");
    }

    public void clickFormSignUp() {
        $(byXpath("(//button[@class='btn btn-primary text-uppercase'])[1]")).waitUntil(appears, 4000).click();
    }

    public void clickFormSignUpSave() {
        $(byXpath("(//button[contains(text(), 'Save & Continue')])[1]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }

    public void clickCloseMoreAboutYouMatching() {
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[1]")).waitUntil(appears, 4000).click();
    }

    public void clickCloseMoreAboutYou() {
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[2]")).waitUntil(appears, 4000).click();
    }

    public void chooseAccountFromDropDownMenu() {
        $(byXpath("//span[@class='pull-left' and contains(text(), ' Account')]")).click();
    }

    public void chooseSettingsFromDashboard() {
        $(byXpath("//a[@class='btn btn-tabs ' and contains(text(), 'Settings')]")).click();
    }

    public void setPhoneNumber(String PhoneNumber) {
        fillInField(PhoneNumber, $("#signup-survey-phone"), "#signup-survey-phone");
    }
    public void setPhoneNumberHomePage(String PhoneNumber) {
        fillInField(PhoneNumber, $("#signup-need-phone"), "#signup-need-phone");
    }


    public void clickCloseSignUp() {
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[4]")).waitUntil(appears, 4000).click();
    }

    public void clickCloseSignUpFMPage() {
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[3]")).waitUntil(visible, 4000).click();
    }

    public void rejectMissedPreferredLocation() {
        $(byXpath("//button[@class='cancel']")).waitUntil(appears, 4000).click();
        sleep(4000);
    }

    public void acceptMissedPreferredLocation() {
        $(byXpath("//button[@class='confirm']")).waitUntil(appears, 4000).click();
        sleep(4000);
    }
    public void acceptFBageRestriction() {
        confirm("Sorry! Ideal Flatmate is restricted for use by those under the age of 18.");
    }
    public void setNewLoginMailListing(String email) {
        fillInField(email, $("#signupnewform-email").waitUntil(visible, 6000), "#signupnewform-email");
    }

    public void setNewLoginPasswordListing(String password) {
        fillInField(password, $("#signupnewform-password"), "#signupnewform-password");
    }
    public void setNewLoginPasswordPasswordConfirm(String password) {
        fillInField(password, $("#signupnewform-password_confirm"), "#signupnewform-password_confirm");
    }

    public void setNewLoginNameFListing(String nameF) {
        fillInField(nameF, $("#signupnewform-firstname"), "#signupnewform-firstname");
    }

    public void setNewLoginNameLListing(String nameL) {
        fillInField(nameL, $("#signupnewform-lastname"), "#signupnewform-lastname");
    }
    public void setPhoneNumberListing(String PhoneNumber) {
        fillInField(PhoneNumber, $("#signupnewform-phone"), "#signupnewform-phone");
    }


}