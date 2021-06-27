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
import functionalities.*
import helper.Keywords as Keywords
import java.sql.Timestamp as Timestamp
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import configurations.CustomDriver as CustomDriver
import helper.SgTestObjects as SgTestObjects
import helper.GmailObjects as GmailObjects

CustomDriver cd = new CustomDriver()
SgTestObjects sg = new SgTestObjects()


//Abrir el explorador
DriverFactory.changeWebDriver(cd.getDriver1('1'))

WebUI.maximizeWindow()
while(true) {
	try {
		boolean error_loginPre = false
		
					boolean msg_mail_sentPre = false
		
					boolean _000USDPre = false
		
					boolean span_USDTPre = false
		
					boolean div_USDT_trianglePre = false
		
					boolean emailIsPre = false
		
					boolean verified_badge_emailPre = false
		
					boolean unverified_badge_emailPre = false
		
					boolean span_Edit_emailPre = false
					_000USDPre = WebUI.verifyElementPresent(sg.span_0_00USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)
		
					span_USDTPre = WebUI.verifyElementPresent(sg.span_USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)
		
					div_USDT_trianglePre = WebUI.verifyElementPresent(sg.div_USDT_triangle, 1, FailureHandling.CONTINUE_ON_FAILURE)
		
					if ((_000USDPre || span_USDTPre) || div_USDT_trianglePre) {
						
						
						WebUI.callTestCase(findTestCase('AccountManagement/SignOut'), null, FailureHandling.STOP_ON_FAILURE)
		
						WebUI.navigateToUrl('https://app.stormgain.com/profile-settings/#modal_login')
					}
					
		WebUI.callTestCase(findTestCase('AccountManagement/Login'), [('email') : "austin.rive.r.s.nba@gmail.com", ('password') : 'Password.1*'],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.delay(3)
		
		WebUI.callTestCase(findTestCase('AccountManagement/SignOut'), null, FailureHandling.STOP_ON_FAILURE)
		
	} catch (Exception e) {
		e.printStackTrace()
	}
}