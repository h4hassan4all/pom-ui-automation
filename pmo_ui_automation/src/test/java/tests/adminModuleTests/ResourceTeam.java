package tests.adminModuleTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.base.Base;
import utils.Role;
import utils.Utils;
import java.time.Duration;

public class ResourceTeam extends Base {
    @Test(priority = 1)
    public void addResourceTeam() throws InterruptedException {
        Thread.sleep(5000);
        String teamName = Utils.getRandomString(6);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            // home.adminTab().click();
            waitForWebElement(home.resourceTeamTab(), Duration.ofSeconds(30));
            home.resourceTeamTab().click();
            waitForWebElement(resourceTeam.addNewResourceTeamBtn(), Duration.ofSeconds(20));
            resourceTeam.addNewResourceTeamBtn().click();
            resourceTeam.addNewTeam(teamName, Utils.getRandomString(16));
            String successMessage = "Resource team added successfully";
            waitForWebElement(resourceTeam.addResourceSuccessMessage(), Duration.ofSeconds(20));
            // Assertion on Newly Created Team
            Assert.assertEquals(resourceTeam.createdTeamName().getText(), teamName);
            // Assertion on Success Message
            Assert.assertEquals(resourceTeam.addResourceSuccessMessage().getText(), successMessage);
            Thread.sleep(4000);
        }
    }

    @Test(priority = 2)
    public void updateResourceTeam() throws InterruptedException {
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {

            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.adminTab().click();
            waitForWebElement(home.resourceTeamTab(), Duration.ofSeconds(30));
            home.resourceTeamTab().click();
            waitForWebElement(resourceTeam.updateResourceTeamBtn(), Duration.ofSeconds(20));
            resourceTeam.updateResourceTeamBtn().click();
            waitForWebElement(resourceTeam.teamLeadField(), Duration.ofSeconds(20));
            resourceTeam.updateTeam(Utils.getRandomString(6), Utils.getRandomString(16));
            String successMessage = "Resource team updated successfully";
            waitForWebElement(resourceTeam.addResourceSuccessMessage(), Duration.ofSeconds(20));
            //Assertion on Success Message
            Assert.assertEquals(resourceTeam.addResourceSuccessMessage().getText(), successMessage);
            Thread.sleep(4000);
        }
    }

    @Test(priority = 3)
    public void addExistingPMOResourceToTeam() throws InterruptedException {
        Thread.sleep(5000);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.adminTab().click();
            waitForWebElement(home.resourceTeamTab(), Duration.ofSeconds(30));
            home.resourceTeamTab().click();
            waitForWebElement(resourceTeam.updateResourceTeamBtn(), Duration.ofSeconds(20));
            resourceTeam.goToTeamSetup().click();
            waitForWebElement(resourceTeam.addResourceBtn(), Duration.ofSeconds(20));
            driver.navigate().refresh();
            resourceTeam.addResourceBtn().click();
            waitForWebElement(resourceTeam.resourceNameField(), Duration.ofSeconds(20));
            resourceTeam.addResource();
            String successMessage = "Resource has been added successfully";
            waitForWebElement(resourceTeam.addResourceSuccessMessage(), Duration.ofSeconds(20));
            //Assertion on Success Message
            Assert.assertEquals(resourceTeam.addResourceSuccessMessage().getText(), successMessage);
            Thread.sleep(4000);
        }
    }

    @Test(priority = 4)
    public void addNewPMOResourceToTeam() throws InterruptedException {
        Thread.sleep(5000);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));
            home.adminTab().click();
            waitForWebElement(home.resourceTeamTab(), Duration.ofSeconds(30));
            home.resourceTeamTab().click();
            waitForWebElement(resourceTeam.updateResourceTeamBtn(), Duration.ofSeconds(20));
            resourceTeam.goToTeamSetup().click();
            waitForWebElement(resourceTeam.addResourceBtn(), Duration.ofSeconds(20));
            resourceTeam.addResourceBtn().click();
            waitForWebElement(resourceTeam.resourceNameField(), Duration.ofSeconds(20));
            resourceTeam.addResourceWithNewTab(Utils.getRandomString(6), Utils.getRandomString(6), Utils.getRandomString(6));
            String successMessage = "Resource has been added successfully";
            waitForWebElement(resourceTeam.addResourceSuccessMessage(), Duration.ofSeconds(20));
            //Assertion on Success Message
            Assert.assertEquals(resourceTeam.addResourceWithNewTabSuccessMessage().getText(), successMessage);
            Thread.sleep(4000);
        }
    }

    @Test(priority = 5)
    public void updateTeamResource() throws InterruptedException{
        Thread.sleep(5000);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.adminTab().click();
            waitForWebElement(home.resourceTeamTab(), Duration.ofSeconds(30));
            home.resourceTeamTab().click();
            waitForWebElement(resourceTeam.updateResourceTeamBtn(), Duration.ofSeconds(20));
            resourceTeam.goToTeamSetup().click();
            waitForWebElement(resourceTeam.addResourceBtn(), Duration.ofSeconds(20));
            resourceTeam.updateResourceBtn().click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(resourceTeam.dailyCapacityArrow()));
            resourceTeam.updateTeamResource();
            String successMessage = "Resource has been updated successfully";
            waitForWebElement(resourceTeam.addResourceSuccessMessage(), Duration.ofSeconds(20));
            //Assertion on Success Message
            Assert.assertEquals(resourceTeam.addResourceSuccessMessage().getText(), successMessage);
            Thread.sleep(4000);
        }
    }

    @Test(priority = 6)
    public void deleteTeamResource() throws InterruptedException{
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.adminTab().click();
            waitForWebElement(home.resourceTeamTab(), Duration.ofSeconds(30));
            home.resourceTeamTab().click();
            waitForWebElement(resourceTeam.updateResourceTeamBtn(), Duration.ofSeconds(20));
            resourceTeam.goToTeamSetup().click();
            waitForWebElement(resourceTeam.addResourceBtn(), Duration.ofSeconds(20));
            try {
                if (resourceTeam.phoneNoTableField().isDisplayed()) {
                    resourceTeam.deleteResourceBtn();
                    waitForWebElement(resourceTeam.deleteConfirmationText(), Duration.ofSeconds(20));
                    String confirmationText = "Are you sure you want to remove this resource?";
                    //Assertion on Asking for Confirmation on Deleting the resource
                    Assert.assertEquals(resourceTeam.deleteConfirmationText().getText(), confirmationText);
                    resourceTeam.confirmDelete();
                    String successMessage = "Resource has been removed successfully";
                    waitForWebElement(resourceTeam.addResourceSuccessMessage(), Duration.ofSeconds(20));
                    //Assertion on Success Message
                    Assert.assertEquals(resourceTeam.addResourceSuccessMessage().getText(), successMessage);
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                System.out.println("No Resource Available");
            }

        }
    }
}