package tests.homePageTests;


import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import testComponents.base.Base;
import utils.*;


public class HomePage extends Base {

    @Test(priority = 1)
    public void validateUserRole(){
        if(home.userRole().getText().equals(Role.Super_Admin.getText())){
            waitForWebElement(home.userRole(), Duration.ofSeconds(20));
            Assert.assertEquals(home.userRole().getText(), Role.Super_Admin.getText());
        }
        else{
            System.out.println("Undefined Role");
        }
    }

    @Test (priority = 2)
    public void validateLeftBarMenu() {
        if(home.userRole().getText().equals(Role.Super_Admin.getText())){
            waitForWebElement((home.adminTab()), Duration.ofSeconds(20));
            Assert.assertTrue(home.adminTab().isDisplayed());
            Assert.assertEquals(home.adminTab().getText(), "Admin");
            home.adminTab().click();
            // Admin's Menu
                waitForWebElement(home.cadenceTab(), Duration.ofSeconds(20));
                Assert.assertTrue(home.cadenceTab().isDisplayed());
                Assert.assertTrue(home.projectMetricsTab().isDisplayed());
                Assert.assertTrue(home.resourceTeamTab().isDisplayed());
                Assert.assertTrue(home.userTab().isDisplayed());
                Assert.assertTrue(home.billingTab().isDisplayed());

            Assert.assertEquals(home.projectManagerTab().getText(), "Project Manager");
            Assert.assertEquals(home.resourceManagerTab().getText(), "Resource Manager");

        }
        else{
            System.out.println("Undefined Role");
        }
    }

}
