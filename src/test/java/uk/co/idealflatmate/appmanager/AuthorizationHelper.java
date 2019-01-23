package uk.co.idealflatmate.appmanager;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationHelper extends HelperBase {


    public void logoutFromApp() {
        $("span.user-welcome--name").waitUntil(visible, 4000).click();
        $(byXpath("//li/a[contains(text(), ' Log out')]")).waitUntil(visible, 4000).click();
    }

    public void goToPropertyPage() {
        $(byXpath("//header//nav//ul//li//a[contains(text(), 'Find a home')]")).waitUntil(appears, 10000).hover();
        sleep(1000);
        $(byXpath("//a[@href='/search' and contains(text(), 'All properties')]")).waitUntil(appears, 4000).click();
    }


    public void goToFMpage() {
         $(byXpath("//ul[starts-with(@class, 'nav navbar-nav')]//a[contains(.,'Find a flatmate')]")).waitUntil(appears, 4000).click();
     }

    public void setLoginAsUserWithoutPackage(String email) {
            fillInField(email, $("input#loginform-username"));
    }
    public void setLoginAsUserWithPremiumFlathunterPackage(String email) {
        fillInField(email, $("#loginform-username"));
    }

    public void setPassword(String password) {
        $("input#loginform-password").waitUntil(visible, 4000).setValue(password);

    }

    public void submitLogin() {
        $(byXpath("//button[contains(., 'Log in with email ')]")).click();

    }

    public void LoginFacebookWithActiveAccount(String email, String password) {
        sleep(5000);
        $("#email").setValue(email);
        sleep(5000);
        $("#pass").setValue(password);
        $(byXpath("//input[@value='Log In']")).click();

       // $(byXpath("//button[@type='submitLogin' and (contains(text(), 'Продолжить как Александр'))]")).waitUntil(visible, 4000).click();
    }

    public void LoginFacebookWithNewAccount(String email, String password) {
        sleep(3000);
        $("#email").setValue(email);
        $("#pass").setValue(password).pressEnter();
       // $(byXpath("//button[@type='submitLogin' and (contains(text(), 'Продолжить как Ronald'))]")).waitUntil(visible, 4000).click();
    }

    public void clickSignInWithFacebook() {
        $(byXpath("//*[@id='login-form']/div[1]/a")).waitUntil(visible, 4000).click();
    }
    public void clickSignUpWithFacebook() {
        $("#js-signup-facebook").waitUntil(visible, 4000).click();
    }

    public void clickSignUpWithFB_ListFlow() {
        $("#js-signup-facebook-add-listing").waitUntil(visible, 4000).click();
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

    public void clickJoinFreeButton() {
        $(".btn.btn-primary.u_m10-top.hidden-xs.hidden-sm.u_m20-right-md.u_m20-right-lg.u_ef-right").click();
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

    public void clickFormSignInContact() {
        $(byXpath("//a[@class='text-bold']")).waitUntil(visible, 4000).click();
    }
    public void clickFormSignInFMmessage() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[3]")).waitUntil(visible, 4000).click();
    }
    public void clickSignUpButtonInForm() {
        sleep(2000);
        $(byXpath("//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign up')]")).waitUntil(appears, 6000).click();
        sleep(2000);
    }

    public static void clickSignInButtonInForm() {
        $(byXpath("//a[contains(., 'Sign in')]")).hover();
        $(byXpath("//a[contains(., 'Sign in')]")).click();

    }


    public void clickSignInButtonInPopup() {
        $(byXpath("(//div[starts-with(@class, 'text-center u_m50-top')]//a[@class='text-bold' and contains(., 'Sign')])[1]")).hover();
        $(byXpath("(//div[starts-with(@class, 'text-center u_m50-top')]//a[@class='text-bold' and contains(., 'Sign')])[1]")).click();

    }

    public void clickSignInButtonInPopupPhone() {
        $(byXpath("(//div[starts-with(@class, 'text-center u_m50-top')]//a[@class='text-bold' and contains(., 'Sign')])[2]")).hover();
        $(byXpath("(//div[starts-with(@class, 'text-center u_m50-top')]//a[@class='text-bold' and contains(., 'Sign')])[2]")).click();

    }


    public void setNewLoginNameF(String nameF) {
        fillInField(nameF, $("#signup-need-firstname"));
    }

    public void setNewLoginNameL(String nameL) {
        fillInField1(nameL, $("#signup-need-lastname"),  $("#signup-need-firstname"));
    }

    public void setNewLoginMailMatching(String email) {
        fillInField1(email, $("#signup-survey-email"),  $("#signup-need-firstname"));
    }

    public void setNewLoginPasswordMatching(String password) {
        fillInField1(password, $("#signup-survey-password"),  $("#signup-need-firstname"));
    }

    public void setNewLoginNameFMatching(String nameF) {
        fillInField1(nameF, $("#signup-survey-firstname"),  $(byXpath("#signup-need-firstname")));
    }

    public void setNewLoginNameLMatching(String nameL) {
        fillInField1(nameL, $("#signup-survey-lastname"),  $(byXpath("#signup-need-firstname")));
    }

    public void clickFormSignUp() {
        $(byXpath("(//button[@class='btn btn-primary text-uppercase'])[1]")).waitUntil(appears, 4000).click();
    }



    public void clickCloseMoreAboutYouMatching() {
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[1]")).waitUntil(appears, 4000).click();
    }

    public void clickCloseMoreAboutYou() {
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[2]")).waitUntil(appears, 10000).click();
    }

    public void chooseProfileFromDropDownMenu() {
        $(byXpath("(//li/a[contains(., 'My profile')])[1]")).waitUntil(visible, 5000).click();
    }
    public void chooseProfileFromHeader() {
        sleep(5000);
        $(byXpath("//body//section[@class='page-heading container-max-940']//ul")).hover();
        $(byXpath("//body//section[@class='page-heading container-max-940']//ul")).click();
        $(byXpath("//body//section[@class='page-heading container-max-940']//li/a[contains(., 'My profile')]")).waitUntil(visible,8000).click();
    }

    public void chooseSettingsFromDashboard() {
        $(byXpath("//ul[starts-with(@class,'inner-menu')]//a[contains(text(), 'Settings')]")).click();
    }

    public void setPhoneNumber(String PhoneNumber) {
        fillInField1(PhoneNumber, $("#signup-survey-phone"),  $(byXpath("#signup-need-firstname")));
    }
    public void setPhoneNumberHomePage(String PhoneNumber) {
        fillInField1(PhoneNumber, $("#signup-need-phone"),  $(byXpath("#signup-need-firstname")));
    }


    public void clickCloseSignUp() {
        sleep(5000);
        if ($(byXpath("//div[@id='signupNeedspaceModal']//button[@class='btn btn-sm close u_m15']")).isDisplayed()){
            $(byXpath("//div[@id='signupNeedspaceModal']//button[@class='btn btn-sm close u_m15']")).click();
        }else {}
    }


    public void clickCloseSignUpFMPage() {
        $(byXpath("//button[@class='btn btn-sm close u_m15']")).waitUntil(visible, 10000).click();
    }

    public void rejectMissedPreferredLocation() {
        $(byXpath("//button[@class='cancel']")).waitUntil(appears, 10000).click();
        sleep(4000);
    }

    public void acceptMissedPreferredLocation() {
        $(byXpath("//button[@class='confirm']")).waitUntil(appears, 10000).click();
        sleep(4000);
    }
    public void acceptFBageRestriction() {
        confirm("Sorry! Ideal Flatmate is restricted for use by those under the age of 18.");
    }
    public void setNewLoginMailListing(String email) {
        fillInField1(email, $("#signupnewform-email").waitUntil(visible, 6000),  $(byXpath("#signup-need-firstname")));
    }

    public void setNewLoginPasswordListing(String password) {
        fillInField1(password, $("#signupnewform-password"),  $(byXpath("#signup-need-firstname")));
    }
    public void setNewLoginPasswordPasswordConfirm(String password) {
        fillInField1(password, $("#signupnewform-password_confirm"),  $(byXpath("#signup-need-firstname")));
    }

    public void setNewLoginNameFListing(String nameF) {
        fillInField1(nameF, $("#signupnewform-firstname"),  $(byXpath("#signup-need-firstname")));
    }

    public void setNewLoginNameLListing(String nameL) {
        fillInField1(nameL, $("#signupnewform-lastname"),  $(byXpath("#signup-need-firstname")));
    }
    public void setPhoneNumberListing(String PhoneNumber) {
        fillInField1(PhoneNumber, $("#signupnewform-phone"),  $(byXpath("#signup-need-firstname")));
    }


    public void selectAllPropertyInMenu() {
        $(byXpath("//a[@href='/search' and contains(text(), 'Find a home')]")).waitUntil(appears, 5000).hover();
        $(byXpath("//a[contains(text(), 'All properties')]")).waitUntil(appears, 5000).click();
    }

    public void FindHomeInMenu() {
        $(byXpath("//a[contains(text(), 'Find a home')]")).waitUntil(appears, 5000).click();
    }

    public void savedPropertiesMenuGo() {
        $(byXpath("(//a[contains(text(), 'My saved')])[1]")).waitUntil(appears, 5000).click();
    }

    public void clickLoginWithFacebook() {

        $(byXpath("//a[contains(., 'Login')]")).click();
        $(byXpath("//span[contains(., 'Log in with Facebook')]")).click();


    }

    public void clickLoginWithFacebook1() {
        $(byXpath("(//a[contains(., 'Log in')])[2]")).click();
        $(byXpath("//span[contains(., 'Log in with Facebook')]")).click();
    }

    public void login(String email, String password){
        clickJoinFreeButton();
        clickSignInButtonInForm();
        setLoginAsUserWithoutPackage(email);
        setPassword(password);
        submitLogin();
    }
}