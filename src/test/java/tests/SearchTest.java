package tests;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import pages.Homepage;
import utils.BaseTest;
import utils.ExcelReader;
import utils.ScreenShotUtil;
public class SearchTest extends BaseTest{
	
	public String searchTerm;
	
	@Test()
	public void testSearchResultsContainApp() {

		
		//Reading data into a list
		List<String[]> testData = ExcelReader.readExcel("src/test/java/PositiveTestSearchList.xlsx", "Sheet1");	
		
		for(String[] row : testData) {
			searchTerm = row[0].toLowerCase();
			String expected = row[1].toLowerCase();
			
			//Setting up report
			test = extent.createTest("Search Test for: " + searchTerm);
			
			//Opening the site.
			driver.get("https://f-droid.org/en/");
			
			//Test logging in the report
			test.log(Status.INFO, "Opened F-Dorid");

			//Creating a Homepage object and passing it the driver.
			Homepage home = new Homepage(driver);
			
			//Utilizing the searchFor method of the homepage class to search for the apps.
			home.searchFor(searchTerm);
			test.log(Status.INFO, "Searched for: " + searchTerm);
			
			//Waiting for the products to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.package-name")));
			
			//locating the elements.	
			List<WebElement> appNames = (List<WebElement>) driver.findElements(By.cssSelector("h4.package-name"));
			
			//Getting the first 3 displayed apps
			int checkCount = Math.min(3, appNames.size());
			
			//Limiting the apps list to 3
			boolean matchfound = false;
			
			//looping through the list
			for(int i = 0; i < checkCount; i++) {
				
				String name = appNames.get(i).getText().toLowerCase().trim();
							
				// Validating the results.
				if(name.contains(expected)) {
					matchfound = true;
					break;
				}
			}
			
			if (matchfound) {
				System.out.println("Passed");
				test.pass("Match found for: " + expected);
			} else {
				test.fail("No match found in top 3 for: " + expected);
				System.out.println("Failed");
			}
			//validating
			Assert.assertTrue(matchfound, "No match found" + checkCount);
			
		}
		
	}
	
	@Test
	public void testSearchResultsDoNotContainApp() {
	    // 1. Create a SoftAssert instance
	    SoftAssert softAssert = new SoftAssert();

	    // 2. Read data
	    List<String[]> testData = ExcelReader.readExcel("src/test/java/NegativeSearchTest.xlsx", "Sheet1");

	    // 3. Loop through each search term
	    for (String[] row : testData) {
	        String negativeSearchTerm = row[0].toLowerCase();

	        test = extent.createTest("Negative Search Test for: " + negativeSearchTerm);
	        driver.get("https://f-droid.org/en/");
	        test.log(Status.INFO, "Opened F-Droid");

	        Homepage home = new Homepage(driver);
	        home.searchFor(negativeSearchTerm);
	        test.log(Status.INFO, "Searched for: " + negativeSearchTerm);

	        // Wait for result or timeout
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            wait.until(ExpectedConditions.or(
	                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.package-name")),
	                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("h4.package-name"))
	            ));
	        } catch (Exception e) {
	            // Ignore timeout — means nothing was found
	        }

	        List<WebElement> appNames = driver.findElements(By.cssSelector("h4.package-name"));

	        // 4. Soft assertion
	        if (appNames.size() == 0) {
	            System.out.println("✅ Passed: No results found for '" + negativeSearchTerm + "'");
	            test.pass("No results found for: '" + negativeSearchTerm + "'");
	        } else {
	            System.out.println("❌ Failed: Unexpected results found for '" + negativeSearchTerm + "'");
	            test.fail("Unexpected results found for: '" + negativeSearchTerm + "'");
	            softAssert.fail("Unexpected result for: '" + negativeSearchTerm + "'");
	            
	            // 📸 Take screenshot and attach to extent report
	            String screenshotPath = ScreenShotUtil.takeScreenshot(driver, negativeSearchTerm);
	            test.addScreenCaptureFromPath(screenshotPath);
	        }
	    }

	    // 5. Evaluate all soft asserts
	    softAssert.assertAll();
	}

	
}

