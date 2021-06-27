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
import helper.GmailObjects as GmailObjects
import helper.Keywords as Keywords
import functionalities.*

GmailObjects gm = new GmailObjects()

ExecuteCmd ec = new ExecuteCmd()

Keywords k = new Keywords()

boolean firstMailPre = false, btn_emailPre = false, a_verifyPre = false, link_verifyPre = false;
//navegar a la pagina de yopmail
WebUI.navigateToUrl('http://www.gmail.com/');

WebUI.waitForPageLoad(20);

//buscar bandeja de correos
firstMailPre = WebUI.verifyElementPresent(gm.firtsMail, 1, FailureHandling.CONTINUE_ON_FAILURE)

if(firstMailPre) {
	WebUI.click(gm.firtsMail, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(1);
	println firstMailPre;
}

//hacer clic en enlace de verificacion
a_verifyPre = WebUI.verifyElementPresent(gm.verifyA, 1, FailureHandling.CONTINUE_ON_FAILURE)
link_verifyPre = WebUI.verifyElementPresent(gm.verifyLink, 1, FailureHandling.CONTINUE_ON_FAILURE)

if(a_verifyPre) {
	WebUI.click(gm.verifyA, FailureHandling.CONTINUE_ON_FAILURE)
}else if(link_verifyPre) {
	WebUI.click(gm.verifyLink, FailureHandling.CONTINUE_ON_FAILURE)
}else {
	ec.executeAmkScript(k.KEY_AMK_VERIFY_GMAIL);
}
