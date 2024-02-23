
package tests.adminModuleTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.base.Base;
import utils.Role;
import java.time.Duration;

public class Cadence extends Base {


    @Test(priority = 1)
    public void agileCadenceTest() {

        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(20));
            home.adminTab().click();
            waitForWebElement(cadence.agileCadenceLabel(), Duration.ofSeconds(10));

            try {
                if (cadence.activateBtnAgile().isDisplayed()) {
                    cadence.addAgileCadence("2023-08-31", "10", "1");
                    cadence.activateBtnAgile().click();
                    //assertion
                    String agileMessage = "Agile details saved successfully";
                    waitForWebElement(notification(), Duration.ofSeconds(5));
                    Assert.assertEquals(notification().getText(), agileMessage);
                }

                if (cadence.sdlcActivateBtn().isDisplayed()) {
                    Thread.sleep(5000);
                    waitForWebElement(cadence.sdlcActivateBtn(), Duration.ofSeconds(10));
                    cadence.addSdlcCadence("2023-08-31", "Rehan");
                    cadence.sdlcActivateBtn().click();
                    //assertion
                    String sdlcMessage = "SDLC details saved successfully";
                    waitForWebElement(notification(), Duration.ofSeconds(5));
                    Assert.assertEquals(notification().getText(), sdlcMessage);
                }
            } catch (Exception exception) {
                System.out.println("Not found");
            }

        }
    }


}
