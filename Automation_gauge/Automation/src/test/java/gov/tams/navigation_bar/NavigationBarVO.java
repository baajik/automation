package gov.tams.navigation_bar;

import org.openqa.selenium.By;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Web Elements locators of Dashboard
 */
final class NavigationBarVO {

    private NavigationBarVO() {}

    static final By titleHeader = By.cssSelector(".tams-title-text");
    static final By userAvatarImage = By.cssSelector(".user-avatar");
    static final By userNameDropdownLink = By.cssSelector(".header-user-info a");
    static final By logoutLink = By.xpath("//a[contains(text(), 'Logout')]");
    /* Page links */
    static final By dashboardLink = By.xpath("//a[contains(text(), 'Dashboard')]");
    static final By nocListLink = By.xpath("//a[contains(text(), 'NOC List')]");
    static final By contractManagementLink = By.xpath("//a[contains(text(), 'Contract Management')]");
}
