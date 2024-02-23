package tests.adminModuleTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.base.Base;
import utils.Role;
import utils.Utils;

import java.time.Duration;

public class Billing extends Base {

    @Test
    public void upgradePackageTest() throws InterruptedException {
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(20));
            home.adminTab().click();
            home.billingTab().click();
            waitForWebElement(billing.billingPageTitle(), Duration.ofSeconds(20));
            Assert.assertEquals(billing.billingPageTitle().getText(),"Billing Profile");


            String totalLicenses = billing.totalLicenses().getText();

            Thread.sleep(3000);
            String packageName = billing.packageName().getText();
            String currentPackage = billing.currentPackage(packageName);
            billing.upgradePackageBtn().click();
            waitForWebElement(billing.packagesPageLabel(),Duration.ofSeconds(20));
            Thread.sleep(2000);
            Assert.assertEquals(billing.packagesPageLabel().getText(),"How many users are on your team?");
            int originalValue = Integer.parseInt(totalLicenses);
            int updatedValue = originalValue + Utils.getRandomNumber(1,5);
            String updatedText = Integer.toString(updatedValue);
            billing.upgradePackage(currentPackage,updatedText);

        }
    }
}
