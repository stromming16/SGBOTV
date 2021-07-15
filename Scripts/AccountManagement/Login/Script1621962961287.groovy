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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import helper.*
import functionalities.*;

SgTestObjects sg = new SgTestObjects();
ExecuteCmd ec = new ExecuteCmd();
Keywords k = new Keywords();

boolean wellcomePre = false, password_input = false, password_inputPre = false;

wellcomePre = WebUI.verifyElementPresent(sg.h1_Welcome, 1, FailureHandling.CONTINUE_ON_FAILURE)
password_input = WebUI.verifyElementPresent(sg.email_input, 1, FailureHandling.CONTINUE_ON_FAILURE)
password_inputPre = WebUI.verifyElementPresent(sg.password_input, 1, FailureHandling.CONTINUE_ON_FAILURE)

if(!wellcomePre || !password_input || !password_inputPre) {
	WebUI.navigateToUrl('https://app.stormgain.com/profile-settings/#modal_login');
	WebUI.waitForPageLoad(20);
}

WebUI.setText(sg.email_input, "${email}", FailureHandling.STOP_ON_FAILURE);
WebUI.setText(sg.password_input, "${password}", FailureHandling.STOP_ON_FAILURE);

WebUI.sendKeys(sg.password_input, Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

//WebUI.click(sg.btn_login, FailureHandling.STOP_ON_FAILURE);
WebUI.delay(3);

ec.executeAmkScript(k.KEY_AMK_RECAPTCHA_SGLOGIN);