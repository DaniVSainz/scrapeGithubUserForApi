/**
 * 
 */
package github;

import java.util.ArrayList;
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
	JavascriptExecutor js;
	Object firstCommit;
	
	@FindBy(xpath="//a[@href=\"/login\"]")WebElement login;
	@FindBy(xpath="//input[@aria-label=\"Search GitHub\"]")WebElement searchGithub;
	@FindBy(xpath="//a[contains(text(),('Users'))]")WebElement users;
	
	public GithubHome(WebDriver driver,WebDriverWait wait,String user) {
		this.driver = driver;
		this.wait = wait;
		this.user = user;
		PageFactory.initElements(driver, this);
		this.js = (JavascriptExecutor) driver;
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	}
	
	public void searchUser(String user) {
		By thisUser = By.xpath("//a[@href=" + "'/"+ user +"']");
		wait.until(ExpectedConditions.elementToBeClickable(searchGithub)).sendKeys(user);
		wait.until(ExpectedConditions.elementToBeClickable(searchGithub)).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(users)).click();
		wait.until(ExpectedConditions.elementToBeClickable(thisUser)).click();
	}
	
	public ArrayList getDates() throws InterruptedException {
		String getDate=
				"var elem=document.querySelectorAll('rect[data-count]');var date=[];"
				   + "  for (i=0;i<elem.length;i++) { date[i]=elem[i].dataset.date;}"+
				   "return date";
		ArrayList dates=(ArrayList) js.executeScript(getDate);
		return dates;

	}
	
	public ArrayList getCounts() {
		String getCount=
				   "var elem=document.querySelectorAll('rect[data-count]');var count=[];"
				   + "  for (i=0;i<elem.length;i++) { count[i]=elem[i].dataset.count;}"+
						   "return count";
	
		ArrayList count=(ArrayList) js.executeScript(getCount);
		return count;
	}
	
}
