package test;

import functions.Sidebar;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginTest extends Base {
    private LoginPage loginPage;
    private Sidebar sidebar;

    @Before
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        sidebar = new Sidebar(driver);
    }

    @Test
    public void testLogin() throws InterruptedException {

        // loginPage.enterUsername("admin");
        // loginPage.enterPassword("pointofsale");
        loginPage.clickLoginButton();
        loginPage.clickDefaultLocation();
        Thread.sleep(3000);

        String parentItem = "Inventory";
        String childItem = "Items";
        sidebar.clickItem(parentItem, childItem);
        Thread.sleep(5000);

    }


}
