/**
 * 
 */
package github;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author daniel
 *https://github.com/DaniVSainz
 */
public class GithubHome {
	WebDriver driver;
	WebDriverWait wait;
	String user;
	
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
	

}
