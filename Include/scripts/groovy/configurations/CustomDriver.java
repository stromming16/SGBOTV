package configurations;
import helper.Configurations;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.*;

import helper.*;

public class CustomDriver {
	
	private WebDriver _driver;
	private Process torProcess;

	public WebDriver getDriver(String profile) {
		
		Configurations c = new Configurations();

		// Optional. If not specified, WebDriver searches the PATH for chromedriver.       
		System.setProperty("webdriver.chrome.driver", c.CHROME_DRIVER);  
		ChromeOptions options = new ChromeOptions();
		
		List<String> arguments = new ArrayList<String>();
		arguments.add(c.PROF_CONF_USER_DATA_DIR);
		arguments.add(c.PROF_CONF_DIRECTORY+profile);
		arguments.add(c.PROF_CONF_LOAD_EXTNS);
		
		options.addArguments(arguments);
		//options.addExtensions(new File(c.ANTICATCHA_EXT));
		
		WebDriver driver = new ChromeDriver(options); 
		
		return driver;
	}
	
public WebDriver getDriver1(String profile) {
		
		Configurations c = new Configurations();

		// Optional. If not specified, WebDriver searches the PATH for chromedriver.       
		System.setProperty("webdriver.chrome.driver", c.CHROME_DRIVER);  
		ChromeOptions options = new ChromeOptions();
		
		List<String> arguments = new ArrayList<String>();
		arguments.add(c.PROF_CONF_USER_DATA_DIR);
		arguments.add(c.PROF_CONF_DIRECTORY+profile);
		arguments.add(c.PROF_CONF_LOAD_EXTNS_2);
		
		options.addArguments(arguments);
		//options.addExtensions(new File(c.ANTICATCHA_EXT));
		
		WebDriver driver = new ChromeDriver(options); 
		
		return driver;
	}
	
	public WebDriver getFfDriver(String profile) {
		
		Configurations c = new Configurations();

		// Optional. If not specified, WebDriver searches the PATH for chromedriver.       
		System.setProperty("webdriver.gecko.driver", c.FIREFOX_DRIVER);  
		FirefoxOptions options = new FirefoxOptions();
		
		//List<String> arguments = new ArrayList<String>();
		//arguments.add(c.PROF_CONF_USER_DATA_DIR);
		//arguments.add(c.PROF_CONF_DIRECTORY+profile);
		//arguments.add(c.PROF_CONF_ANTICATCHA_EXT);
		
		//options.addArguments(arguments);
		//options.addExtensions(new File(c.ANTICATCHA_EXT));
		
		WebDriver driver = new FirefoxDriver(options); 
		
		return driver;
	}
	
	public WebDriver getTorDriver() {
		
		Configurations c = new Configurations(); 
		
		System.setProperty("webdriver.gecko.driver", c.FIREFOX_DRIVER);

        File torProfileDir = new File(c.TOR_PROFILE_PATH);
        FirefoxBinary binary = new FirefoxBinary(new File(c.TOR_PATH));
        FirefoxProfile torProfile = new FirefoxProfile(torProfileDir);

        torProfile.setPreference("network.proxy.type", 1);
        torProfile.setPreference("network.proxy.socks", "127.0.0.1");
        torProfile.setPreference("network.proxy.socks_port", 9153);
        torProfile.setPreference("network.proxy.socks_remote_dns", false);
        
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(binary);
        options.setProfile(torProfile);
        options.setLogLevel(FirefoxDriverLogLevel.TRACE);
        options.setCapability(FirefoxOptions.FIREFOX_OPTIONS,options);
        
        WebDriver driver = new FirefoxDriver(options);
		
		return driver;
	}
	
	public void openTorBrowser() throws IOException {
		EnvConfig c = new EnvConfig();
		Runtime runTime = Runtime.getRuntime();
		runTime.exec("\"C:\\Users\\"+c.pcusername+"\\Desktop\\Tor Browser\\Browser\\firefox\" -n --detach https://app.stormgain.com/profile-settings/#modal_register");
	}

}