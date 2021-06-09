package helper

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import helper.*
import internal.GlobalVariable

public class Configurations {
	EnvConfig c = new EnvConfig();

	public String CHROME_DRIVER = "C:\\Users\\" + c.pcusername + "\\Downloads\\Katalon_Studio\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe";
	public String FIREFOX_DRIVER = "C:\\Users\\" + c.pcusername + "\\Downloads\\Katalon_Studio\\configuration\\resources\\drivers\\firefox_win64\\geckodriver.exe";
	public String ANTICATCHA_EXT = c.disco +":\\anticaptcha-plugin_v0.54.crx";
	public String PROF_CONF_USER_DATA_DIR = "--user-data-dir=C:\\Users\\" + c.pcusername + "\\AppData\\Local\\Google\\Chrome\\User Data\\";
	public String PROF_CONF_DIRECTORY = "--profile-directory=Profile ";
	public String PROF_CONF_APPID = "--app-id=epiocimfnhgleklijmjmglgphfkcdbip";
	public String PROF_CONF_ANTICATCHA_EXT = "--load-extension=" + c.disco + ":\\anticaptcha-plugin_v0.54";

	public String TOR_PATH = "C:\\Users\\" + c.pcusername + "\\Desktop\\Tor Browser\\Browser\\firefox.exe";
	public String TOR_PROFILE_PATH = "C:\\Users\\" + c.pcusername + "\\Desktop\\Tor Browser\\Browser\\TorBrowser\\Data\\Browser\\profile.default";
}
