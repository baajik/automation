package gov.tams.login;

import org.openqa.selenium.By;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Web Elements locators of Log In page
 */
final class LoginVO {

    private LoginVO() {}

    static final By signInUserNameTextBox = By.id("okta-signin-username");
    static final By signInPasswordTextBox = By.id("okta-signin-password");
    static final By signInButton = By.id("okta-signin-submit");
}
