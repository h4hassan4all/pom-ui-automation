package tests.ProjectAdminModuleTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.base.Base;
import utils.*;

import java.time.Duration;


public class ProjectConflicts extends Base {

    @Test(priority = 1)
    public void AddProjectConflict() throws InterruptedException {
        if(home.userRole().getText().equals(Role.Super_Admin.getText())){
            waitForWebElement((home.adminTab()), Duration.ofSeconds(20));
            projectConflicts.confProjectManagerTab().click();
            waitForWebElement(projectConflicts.confConflictTab(),Duration.ofSeconds(20));
            projectConflicts.confConflictTab().click();
            waitForWebElement(projectConflicts.confCreateConflictButton(),Duration.ofSeconds(20));
            projectConflicts.confCreateConflictButton().click();
            waitForWebElement(projectConflicts.confProjectName(),Duration.ofSeconds(20));
            projectConflicts.confProjectName().click();
            waitForWebElement(projectConflicts.confProjectNameField(),Duration.ofSeconds(20));
            projectConflicts.confProjectNameField().click();
            waitForWebElement(projectConflicts.confProjectNameDropdownValue(),Duration.ofSeconds(20));
            projectConflicts.confProjectNameDropdownValue().click();
            waitForWebElement(projectConflicts.confConflictName(),Duration.ofSeconds(20));
            projectConflicts.conflictNameFn();
            waitForWebElement(projectConflicts.confConflictDescription(),Duration.ofSeconds(20));
            projectConflicts.confDescriptionFn();
            waitForWebElement(projectConflicts.confSuggestedResolution(),Duration.ofSeconds(20));
            projectConflicts.confSuggestedResolutionFn();
            waitForWebElement(projectConflicts.confImpactedTeam(),Duration.ofSeconds(20));
            projectConflicts.confImpactedTeam().click();
            waitForWebElement(projectConflicts.confImpactedTeamValue(),Duration.ofSeconds(20));
            projectConflicts.confImpactedTeamValue().click();
            waitForWebElement(projectConflicts.confImpactedMember(),Duration.ofSeconds(20));
            projectConflicts.confImpactedMember().click();
            projectConflicts.confImpactedMemberValue().click();
            projectConflicts.confSeverity().click();
            projectConflicts.confSeverityValue().click();
            projectConflicts.confCreateConflict().click();

            String email = Utils.getElementFromPropertiesFile("email", "global");
            System.out.println(email);
            Assert.assertEquals(projectConflicts.confCreatedUser1().getText(),email);

        }
    }

}

