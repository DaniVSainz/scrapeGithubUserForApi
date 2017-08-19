package browserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author Seed
 *
 */
public class BrowserFactory {
	static WebDriver driver;
	
	public static  WebDriver GetBrowser(String browserName) {
		browserName = browserName.toLowerCase();
		
		if(browserName.equals("chrome"))
			return getChromeInstance();
		if(browserName.equals("safari"))
			return getSafariInstance();
		if(browserName.equals("htmlunit"))
			return getHtmlUnitInstance();
		if(browserName.equals("phantomjs"))
			return getPhantomJSInstance();
		else
			return getFFInstance();
	}

    public static RemoteWebDriver GetRemoteBrowser(String browserName) {
        DesiredCapabilities capabillities = null;
        RemoteWebDriver driver = null;
        
        switch (browserName) {
        	case "firefox":
        		capabillities = DesiredCapabilities.firefox();
        		break;
        	default:
        }
        
        capabillities.setJavascriptEnabled(true);
        driver = new RemoteWebDriver(capabillities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    
	private static FirefoxDriver getFFInstance() {
		return new FirefoxDriver();
	}
	
	private static  WebDriver getChromeInstance() {
		Point pointer = new Point(1920,1);
		driver = new ChromeDriver();
		driver.manage().window().setPosition(pointer);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	private static SafariDriver getSafariInstance() {
		return new SafariDriver();
	}
	
	private static HtmlUnitDriver getHtmlUnitInstance() {
		return new HtmlUnitDriver();
	}
	
	private static PhantomJSDriver getPhantomJSInstance() {
		System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "resources//phantomjs");
		return new PhantomJSDriver();
	}
}


