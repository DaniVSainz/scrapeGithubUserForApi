package scrapeGithub;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browserFactory.BrowserFactory;
import github.GithubHome;

public class ScrapeGithub {
	WebDriver driver;
	WebDriverWait wait;
	
	GithubHome githubHome;
	String user = "danivsainz";
	
	@BeforeTest
	public void setUp() {
		driver = BrowserFactory.GetBrowser("chrome");
		driver.get("https://github.com/");

		wait = new WebDriverWait(driver,10);
		githubHome = new GithubHome(driver,wait);
	}
	@AfterTest
	public void coolDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void searchGithub() {
		githubHome.searchUser(user);
	}
	
}
