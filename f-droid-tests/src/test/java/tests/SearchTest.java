package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.Homepage;
import utils.BaseTest;
public class SearchTest extends BaseTest{
	
	@Test
	public void testSearchResultsContainApp() {
		driver.get("https://f-droid.org/en/");
		

		//Creating a Homepage object and passing it the driver.
		Homepage home = new Homepage(driver);
		
		//Utilizing the searchFor method of the homepage class to search for the apps.
		home.searchFor("Vlc");
		
		// Validating the results.

		//locating the elements.
		WebElement firstResult = driver.findElement(By.ByCssSelector)

	/*	WebElement firstResult = driver.findElement(By.cssSelector(""));
		String title = firstResult.getText().toLowerCase();
		
		Assert.assertTrue(title.contains("vlc"), "Search result doesn't contain VLC");*/
	}
	
	

}
