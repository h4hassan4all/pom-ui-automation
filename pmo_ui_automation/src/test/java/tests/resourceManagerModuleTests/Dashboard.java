package tests.resourceManagerModuleTests;
import freemarker.ext.servlet.FreemarkerServlet;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.base.Base;
import utils.Role;
import utils.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Dashboard extends Base{
    @Test(priority = 1)
    public void addResourceTeam() throws InterruptedException {
        Thread.sleep(4000);
        String teamName = Utils.getRandomString(6);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {

            waitForWebElement(home.resourceManagerTab(), Duration.ofSeconds(30));
            home.resourceManagerTab().click();
            waitForWebElement(home.rmDashboardTab(), Duration.ofSeconds(30));
            home.rmDashboardTab().click();
            waitForWebElement(resourceManagerDashboard.addResourceTeamBtn(), Duration.ofSeconds(20));
            resourceTeam.addNewResourceTeamBtn().click();
            waitForWebElement(resourceManagerDashboard.resourceTeamTitle(), Duration.ofSeconds(20));
//          Assertion on Title of Form
            Assert.assertEquals(resourceManagerDashboard.resourceTeamTitle().getText(),"New Resource Team");
            resourceTeam.addNewTeam(teamName, Utils.getRandomString(16));
            String successMessage = "Resource team added successfully";
            waitForWebElement(resourceManagerDashboard.addResourceSuccessMessage(), Duration.ofSeconds(20));
//          Assertion on Success Message
            Assert.assertEquals(resourceManagerDashboard.addResourceSuccessMessage().getText(), successMessage);
//          Assertion on Newly Created Team
            Assert.assertEquals(resourceManagerDashboard.teamName().getText(), teamName);
            Thread.sleep(4000);
        }
    }
    @Test(priority = 2)
    public void updateResourceTeam() throws InterruptedException {
        String updatedTeamName = Utils.getRandomString(6);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.resourceManagerTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.resourceManagerTab().click();
            waitForWebElement(home.rmDashboardTab(), Duration.ofSeconds(30));
            home.rmDashboardTab().click();
            waitForWebElement(resourceManagerDashboard.updateResourceTeamBtn(), Duration.ofSeconds(20));
            resourceManagerDashboard.updateResourceTeamBtn().click();
            waitForWebElement(resourceManagerDashboard.resourceTeamEditTitle(), Duration.ofSeconds(20));
//          Assertion on Title of Form
            Assert.assertEquals(resourceManagerDashboard.resourceTeamEditTitle().getText(),"Edit Resource Team");
            waitForWebElement(resourceManagerDashboard.teamLeadField(), Duration.ofSeconds(20));
            resourceManagerDashboard.updateTeam(updatedTeamName, Utils.getRandomString(16));
            String successMessage = "Resource team updated successfully";
            waitForWebElement(resourceManagerDashboard.addResourceSuccessMessage(), Duration.ofSeconds(20));
//          Assertion on Newly Created Team
            Assert.assertEquals(resourceManagerDashboard.teamName().getText(), updatedTeamName);
//          Assertion on Success Message
            Assert.assertEquals(resourceManagerDashboard.addResourceSuccessMessage().getText(), successMessage);
            Thread.sleep(4000);
        }
    }
    @Test(priority = 3)
    public void addExistingResourceToTeam() throws InterruptedException {
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.resourceManagerTab(), Duration.ofSeconds(20));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.resourceManagerTab().click();
            waitForWebElement(home.rmDashboardTab(), Duration.ofSeconds(30));
            home.rmDashboardTab().click();
            waitForWebElement(resourceManagerDashboard.teamIcon(), Duration.ofSeconds(20));
            resourceManagerDashboard.teamIcon().click();
            waitForWebElement(resourceManagerDashboard.adResourceBtn(), Duration.ofSeconds(20));
            Thread.sleep(3000);
            resourceManagerDashboard.adResourceBtn().click();
            waitForWebElement(resourceManagerDashboard.addResourceFormLabel(), Duration.ofSeconds(30));
            //Assertion on Title of Form
            Assert.assertEquals(resourceManagerDashboard.addResourceFormLabel().getText(),"Add Resource");
            waitForWebElement(resourceManagerDashboard.resourceNameField(), Duration.ofSeconds(20));
            resourceManagerDashboard.resourceNameField().click();
            String selectedResource = resourceManagerDashboard.selectExistingResource().getText();
            resourceManagerDashboard.addResource();
            String successMessage = "Resource has been added successfully";
            waitForWebElement(resourceManagerDashboard.addResourceSuccessMessage(), Duration.ofSeconds(20));
            //Assertion on Success Message
            Assert.assertEquals(resourceManagerDashboard.addResourceSuccessMessage().getText(), successMessage);
            //Assertion on resource name
            Assert.assertTrue(selectedResource.contains(resourceManagerDashboard.resourceNameAssertion().getText()),"Value not matched" );
            Thread.sleep(4000);
        }
    }
    @Test(priority = 4)
    public void deleteExistingResourceFromTeam() throws InterruptedException {
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.resourceManagerTab(), Duration.ofSeconds(30));

            //If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.resourceManagerTab().click();
            waitForWebElement(home.rmDashboardTab(), Duration.ofSeconds(30));
            home.rmDashboardTab().click();
            Thread.sleep(400);
            waitForWebElement(resourceManagerDashboard.teamName(), Duration.ofSeconds(30));
            resourceManagerDashboard.teamName().click();
            Thread.sleep(400);
            waitForWebElement(resourceManagerDashboard.topRowResource(), Duration.ofSeconds(20));
            String deletedResourceName = resourceManagerDashboard.topRowResource().getText();
            waitForWebElement(resourceManagerDashboard.deleteActionBtn(), Duration.ofSeconds(20));
            resourceManagerDashboard.deleteActionBtn().click();
            waitForWebElement(resourceManagerDashboard.confirmDeletion(), Duration.ofSeconds(20));
            resourceManagerDashboard.confirmDeletion().click();
            String successMessage = "Resource has been removed successfully";
            waitForWebElement(resourceManagerDashboard.addResourceSuccessMessage(), Duration.ofSeconds(20));
            //Assertion on Success Message
            Assert.assertEquals(resourceManagerDashboard.addResourceSuccessMessage().getText(), successMessage);
            //Assertion on Deleted Resource name
            Assert.assertFalse(deletedResourceName.contains(resourceManagerDashboard.topRowResource().getText()),"Value matched" );
            Thread.sleep(4000);
        }
    }
    @Test(priority = 5)
    public void addNewResourceInTeam() throws InterruptedException {
        String randomString = Utils.getRandomString(6);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.resourceManagerTab(), Duration.ofSeconds(30));

            //If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.resourceManagerTab().click();
            waitForWebElement(home.rmDashboardTab(), Duration.ofSeconds(20));
            home.rmDashboardTab().click();
            Thread.sleep(400);
            waitForWebElement(resourceManagerDashboard.teamName(), Duration.ofSeconds(20));
            resourceManagerDashboard.teamName().click();
            Thread.sleep(400);
            waitForWebElement(resourceManagerDashboard.adResourceBtn(), Duration.ofSeconds(20));
            resourceManagerDashboard.adResourceBtn().click();
            //Assertion on Title of Form
            waitForWebElement(resourceManagerDashboard.addResourceFormLabel(), Duration.ofSeconds(20));
            Assert.assertEquals(resourceManagerDashboard.addResourceFormLabel().getText(),"Add Resource");
            waitForWebElement(resourceManagerDashboard.radioButtonForNewTab(), Duration.ofSeconds(30));
            resourceManagerDashboard.radioButtonForNewTab().click();
            waitForWebElement(resourceManagerDashboard.emailTitle(), Duration.ofSeconds(20));
            resourceManagerDashboard.addNewResourceInTeam(randomString,randomString, randomString);
            String successMessage = "User added successfully";
            waitForWebElement(resourceManagerDashboard.addResourceSuccessMessage(), Duration.ofSeconds(20));
            String resourceEmailToMatch = randomString.toLowerCase() + "@yopmail.com";
            List<WebElement> list = resourceManagerDashboard.teamResourcesList();
            //Assertion on Resource is added and visible in resource team table
            for(int i=1; i<list.size(); i++){
                if(list.get(i).getText().contains(resourceEmailToMatch)){
                    break;
                }
                else{
                    throw new InterruptedException();
                }
            }
            //Assertion on Success Message
            Assert.assertEquals(resourceManagerDashboard.addResourceSuccessMessage().getText(), successMessage);
            Thread.sleep(4000);
        }
    }
}
