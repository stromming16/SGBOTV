import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.xml.internal.resolver.helpers.Debug as Debug
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import functionalities.*
import helper.Keywords as Keywords
import java.sql.Timestamp as Timestamp
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import configurations.CustomDriver as CustomDriver
import helper.SgTestObjects as SgTestObjects
import helper.JmTestObjects as JmTestObjects

Timestamp timestamp = new Timestamp(System.currentTimeMillis())

Keywords k = new Keywords()

SgTestObjects sg = new SgTestObjects()

JmTestObjects jm = new JmTestObjects()

AccountManagement am = new AccountManagement()

ExecuteCmd ec = new ExecuteCmd()

CustomDriver cd = new CustomDriver();

SystemClipboard c = new SystemClipboard();

String csvPath = (k.KEY_FOLDER_CREADAS + timestamp.getTime()) + '-CREADAS.csv';

am.createFileCSV(csvPath, 'id,email,password');

for (def row = 1; row <= 100; row++) {
	try {
		//Abrir el explorador
		cd.openTorBrowser();
		
		String email = am.substractUserName(am.generateUsername("gmail"))+"@gmail.com";
		c.copy(email);
		
		ec.executeAmkScript(k.KEY_AMK_CREATE_SG);
		
		am.addAccountToCsv(csvPath, '1,'+email+',Luzter.287*');
	} catch (Exception e) {
		e.printStackTrace()
	}
}
