package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Homepage;
import utils.BaseTest;
public class SearchTest extends BaseTest{
	/*
	 * @DataProvider(name = "appData") public Object[][] getAppData() {
	 * List<String[]> data = GoogleSheetReader.readSheet(...); Object[][] result =
	 * new Object[data.size()][2];
	 * 
	 * for (int i = 0; i < data.size(); i++) { result[i][0] = data.get(i)[0]; //
	 * search term result[i][1] = data.get(i)[1]; // expected keyword }
	 * 
	 * return result; }
	 */

	
	@Test
	public void testSearchResultsContainApp() {
		driver.get("https://f-droid.org/en/");
		

		//Creating a Homepage object and passing it the driver.
		Homepage home = new Homepage(driver);
		
		//Utilizing the searchFor method of the homepage class to search for the apps.
		home.searchFor("Vlc");
		
		// Validating the results.
		//Waiting for the products to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.package-name")));
		
		//locating the elements.	
		//Getting the first 3 displayed apps
		
		//Reading data into a list
		List<String[]> testData = GoogleSheetReader.readSheet("10_Zz7tklUA_8K2hr9rrV6tjuJTdeIir6igud8CTWQJc", "Sheet1!A2:B");
		
		
		//List<WebElement> appNames = (List<WebElement>) driver.findElements(By.cssSelector("h4.package-name"));
		
		

		
		
		//Limiting the apps list to 3
		int checkCount = Math.min(3, appNames.size());
		boolean matchfound = false;
		
		//looping through the list
		for(int i = 0; i < checkCount; i++) {
			String name = appNames.get(i).getText().toLowerCase().trim();
			//System.out.println("Result " + (i + 1) + ": " + name);
			
			if(name.equals("vlc")) {
				matchfound = true;
				break;
			}
		}
		
		if (matchfound) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		//validating
		Assert.assertTrue(matchfound, "No match found" + checkCount);
	/*	WebElement firstResult = driver.findElement(By.cssSelector(""));
		String title = firstResult.getText().toLowerCase();
		
		Assert.assertTrue(title.contains("vlc"), "Search result doesn't contain VLC");*/
	}
	
	

}
