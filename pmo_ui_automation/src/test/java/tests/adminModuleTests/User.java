package tests.adminModuleTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

import testComponents.base.Base;
import utils.*;

public class User extends Base {

    int addUserCount = 3;
    int adminTabClickCounter = 0;
    @Test(priority = 1)
    public void addUserTest() throws InterruptedException {
        if(home.userRole().getText().equals(Role.Super_Admin.getText())){

            waitForWebElement(home.adminTab(), Duration.ofSeconds(20));
            if(adminTabClickCounter==0){
                home.adminTab().click();
                adminTabClickCounter=1;
            }
            home.userTab().click();
            waitForWebElement(user.currentUsersTab(), Duration.ofSeconds(20));
            Assert.assertTrue(user.currentUsersTab().isDisplayed());
            user.currentUsersTab().click();
            waitForWebElement(user.addNewUserBtn(), Duration.ofSeconds(20));
            Assert.assertTrue(user.addNewUserBtn().isDisplayed());
            Assert.assertEquals(user.addNewUserBtn().getText(),"Add New User");

            user.addNewUserBtn().click();
            waitForWebElement(user.addUserFormLabel(), Duration.ofSeconds(20));
            Assert.assertTrue(user.addUserFormLabel().isDisplayed());

            String str = Utils.getRandomString(6);
            String phoneNumber = Utils.generateRandomAmericanPhoneNumber(10);
            String remainingLicenses = user.remainingLicenses().getText();

            if(addUserCount==3){
                user.addUser(str, str,"Project Manager" , str+"@yopmail.com", "United States of America 1" );
            }else if (addUserCount==2){
                user.addUser(str, str,"Resource Manager" , str+"@yopmail.com", "United States of America 1" );
            }
            else{
                user.addUser(str, str,"General User" , str+"@yopmail.com", "United States of America 1" );
            }
            ///////////////////////////////////////// Verifying added user's details in the users table ////////////////////////////////////////
            Thread.sleep(5000);
            waitForWebElement(notification(), Duration.ofSeconds(30));
            Assert.assertEquals(notification().getText(), "User added successfully");

            Assert.assertEquals(user.verifyAddedUserDetails().get("Name"),str);
            Assert.assertEquals(user.verifyAddedUserDetails().get("Email"),str.toLowerCase()+"@yopmail.com");
            Assert.assertEquals(user.verifyAddedUserDetails().get("Status"),"Active");

            ///////////////////////////////////////// Asserting Remaining Licenses ////////////////////////////////////////////////////////////
            int originalValue = Integer.parseInt(remainingLicenses);
            int subtractedValue = originalValue - 1;
            String updatedText = Integer.toString(subtractedValue);
            Assert.assertEquals(user.remainingLicenses().getText(),updatedText);

            while (addUserCount>0){
                addUserCount--;
                addUserTest();
            }

        }
    }

    @Test(priority = 2)
    public void editUserTest() throws InterruptedException {
        Thread.sleep(5000);

        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.adminTab().click();
            home.userTab().click();
            waitForWebElement(user.currentUsersTab(), Duration.ofSeconds(30));
            Assert.assertTrue(user.currentUsersTab().isDisplayed());
            user.currentUsersTab().click();

            user.actionsBtn().click();
            waitForWebElement(user.editOption(), Duration.ofSeconds(20));
            user.editOption().click();

            waitForWebElement(user.editUserFormLabel(), Duration.ofSeconds(20));
            Assert.assertTrue(user.editUserFormLabel().isDisplayed());

            String phoneNumber = Utils.generateRandomAmericanPhoneNumber(10);
            String remainingLicenses = user.remainingLicenses().getText();

            user.editUser("Test", "User", "General User", phoneNumber);

            ///////////////////////////////////////// Verifying updated user's details in the users table ////////////////////////////////////////
            Thread.sleep(5000);
            waitForWebElement(notification(), Duration.ofSeconds(20));
            Assert.assertEquals(notification().getText(), "User updated successfully");

            Assert.assertEquals(user.verifyUpdatedUserDetails().get("Name"),"Test");
            ///////////////////////////////////////// Formatting the actual & expected phone numbers //////////////////////////////////////////
//            String actualPhoneNumber = (String) user.verifyUpdatedUserDetails().get("Phone");
//            actualPhoneNumber = actualPhoneNumber.replaceAll("[\\s-]+", "");
//            String expectedPhoneNumber = phoneNumber.replaceAll("[\\s-]+", "");
//
//            Assert.assertEquals(actualPhoneNumber,expectedPhoneNumber);
            Assert.assertEquals(user.verifyUpdatedUserDetails().get("Status"),"Active");

        }

    }

    @Test(priority = 3)
    public void revokeUserTest() throws InterruptedException {

        Thread.sleep(5000);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.adminTab().click();
            home.userTab().click();
            waitForWebElement(user.currentUsersTab(), Duration.ofSeconds(30));
            Assert.assertTrue(user.currentUsersTab().isDisplayed());
            user.currentUsersTab().click();
            user.activeUsersColumnLabel().click();
            waitForWebElement(user.actionsBtn(), Duration.ofSeconds(20));
            user.actionsBtn().click();
            waitForWebElement(user.revokeOption(), Duration.ofSeconds(20));
            user.revokeOption().click();
            waitForWebElement(user.editUserFormLabel(), Duration.ofSeconds(20));
            Assert.assertTrue(user.editUserFormLabel().isDisplayed());
            user.revokeLicenceBtn().click();
            String revokeMessage = "User revoked successfully";
            waitForWebElement(notification(), Duration.ofSeconds(20));
            Assert.assertEquals(notification().getText(), revokeMessage);
        }
    }

    @Test(priority = 4)
    public void grantAccessTest() throws InterruptedException {
        Thread.sleep(5000);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(30));

            // If you want to run the atomic/single test then uncomment the following line else keep it commented

            //home.adminTab().click();
            home.userTab().click();
            waitForWebElement(user.currentUsersTab(), Duration.ofSeconds(30));
            Assert.assertTrue(user.currentUsersTab().isDisplayed());
            user.currentUsersTab().click();

            user.revokedUsersColumnLabel().click();

            Thread.sleep(2000);
            waitForWebElement(user.actionsBtn(), Duration.ofSeconds(20));
            user.actionsBtn().click();
            waitForWebElement(user.grantAccessOption(), Duration.ofSeconds(10));
            user.grantAccessOption().click();
            waitForWebElement(user.grantAccessBtn(), Duration.ofSeconds(20));
            user.grantAccessBtn().click();

            // verification
            String grantMessage = "User reactivated successfully";
            waitForWebElement(notification(), Duration.ofSeconds(20));
            Assert.assertEquals(notification().getText(), grantMessage);
        }

    }

    @Test(priority = 5)
    public void UsergrantAccessTest() throws InterruptedException {
        Thread.sleep(5000);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(20));
            home.adminTab().click();
            home.userTab().click();
            waitForWebElement(user.pendingUsersTab(), Duration.ofSeconds(20));
            Assert.assertTrue(user.pendingUsersTab().isDisplayed());
            user.pendingUsersTab().click();

            user.pendingOption().click();

            waitForWebElement(user.pendingOption(), Duration.ofSeconds(10));
            user.grantaccessUser().click();

            // verification
            String grantMessage = "Invite Sent successfully";
            waitForWebElement(notification(), Duration.ofSeconds(20));
            Assert.assertEquals(notification().getText(), grantMessage);
        }

    }
    @Test(priority = 6)
    public void UserRevokeAccessTest() throws InterruptedException {
        Thread.sleep(5000);
        if (home.userRole().getText().equals(Role.Super_Admin.getText())) {
            waitForWebElement(home.adminTab(), Duration.ofSeconds(20));
            home.adminTab().click();
            home.userTab().click();
            waitForWebElement(user.pendingUsersTab(), Duration.ofSeconds(20));
            Assert.assertTrue(user.pendingUsersTab().isDisplayed());
            user.pendingUsersTab().click();

            user.pendingOption().click();

            waitForWebElement(user.pendingOption(), Duration.ofSeconds(10));
            user.revokeaccessUser().click();

            // verification
            String grantMessage = "User rejected successfully";
            waitForWebElement(notification(), Duration.ofSeconds(20));
            Assert.assertEquals(notification().getText(), grantMessage);
        }

    }
}