/**
 * 
 */
package github;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

/**
 * @author daniel
 *https://github.com/DaniVSainz
 */
public class GithubHome {
	WebDriver driver;
	WebDriverWait wait;
	String user;
	JavascriptExecutor jsExecutor;
	Object firstCommit;
	
	@FindBy(xpath="//a[@href=\"/login\"]")WebElement login;
	@FindBy(xpath="//input[@aria-label=\"Search GitHub\"]")WebElement searchGithub;
	@FindBy(xpath="//a[contains(text(),('Users'))]")WebElement users;
	
	public GithubHome(WebDriver driver,WebDriverWait wait,String user) {
		this.driver = driver;
		this.wait = wait;
		this.user = user;
		PageFactory.initElements(driver, this);
	}
	
	public void searchUser(String user) {
		By thisUser = By.xpath("//a[@href=" + "'/"+ user +"']");
		wait.until(ExpectedConditions.elementToBeClickable(searchGithub)).sendKeys(user);
		wait.until(ExpectedConditions.elementToBeClickable(searchGithub)).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(users)).click();
		wait.until(ExpectedConditions.elementToBeClickable(thisUser)).click();
	}
	
	public void getFirstCommitDate() throws InterruptedException {
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String typeKeywordJS = 
				  "return document.querySelector('rect[data-count]').getAttribute('data-count')";
		Thread.sleep(2000);
		System.out.println(		js.executeScript(typeKeywordJS).toString());
	}
}
