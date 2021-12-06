package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTestNG extends TestBase implements ITestListener {

	public void onStart(ITestContext context) {

		System.out.println("This is the Onstart method of TestNg Listener");
	}

	public void onFinish(ITestContext context) {

		System.out.println("This is the onFinish method of Testng Listener");
	}

	public void onTestStart(ITestResult result) {

		System.out.println("Testcase execution is started ==> " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase execustion passed ==> " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			System.out.println(result.getName());
			System.out.println(driver.getCurrentUrl());
			TakesScreenshot ts = (TakesScreenshot)driver;

			File source = ts.getScreenshotAs(OutputType.FILE);
			String fileName = result.getName() + ".png";
			File dest = new File("Screenshots", fileName);
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}
