package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class SystemUsersTestCases extends TestBase{

	@Test(groups = {"smoke"})
	public void verifySystemUsersPage() {
		
		dp.clickusersMenu();
		
		log.info("User is on System Users page");
		
		Assert.assertTrue(sp.verifySystemUsersTitle(), "System Users page not loaded..!");
	}
}
