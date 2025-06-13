package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	
	
	//Creating an object to store the incoming driver.
	WebDriver HomePage_Driver;
	
	//constructor to initialize the HomePage_Driver with the incoming driver.
	public Homepage(WebDriver driver) {
		this.HomePage_Driver = driver;
	}
	//Locator for the search box
	By searchBox = By.name("q");
	
	//Action: Search for a keyword.
	public void searchFor(String Searchkeyword) {
		WebElement box = HomePage_Driver.findElement(searchBox);
		box.clear();
		box.sendKeys(Searchkeyword);
		box.submit();
	}
	
}


