package com.example.orangehrm.tests;

import com.example.orangehrm.models.UserData;
import com.example.orangehrm.pages.DashboardPage;
import com.example.orangehrm.pages.LoginPage;
import com.example.orangehrm.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.List;

public class LoginTest extends BaseTest {
    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @DataProvider(name = "jsonUsers")
    public Object[][] jsonUsers() throws Exception {
        String path = Paths.get("test-data", "users.json").toString();
        List<UserData> users = JsonUtils.readUsers(path);
        Object[][] data = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++) data[i][0] = users.get(i);
        return data;
    }

    @Test(dataProvider = "jsonUsers")
    public void loginTest(UserData userData) {
        LoginPage login = new LoginPage(driver);
        login.login(BASE_URL, userData.getUsername(), userData.getPassword());

        boolean actual = login.isLoggedIn();
        testLogger.info("User: " + userData.getUsername() + " expected:" + userData.isExpectedSuccess() + " actual:" + actual);
        if (userData.isExpectedSuccess()) {
            DashboardPage dash = new DashboardPage(driver);
            Assert.assertTrue(dash.isDisplayed(), "Dashboard should be displayed for valid user");
        } else {
            Assert.assertFalse(actual, "Login should fail for invalid user");
        }
    }
}
