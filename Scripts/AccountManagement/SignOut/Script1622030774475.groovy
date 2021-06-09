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

boolean _000USDPre = false, span_USDTPre = false, div_USDT_trianglePre = false;

_000USDPre = WebUI.verifyElementPresent(sg.span_0_00USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)
span_USDTPre = WebUI.verifyElementPresent(sg.span_USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)
div_USDT_trianglePre = WebUI.verifyElementPresent(sg.div_USDT_triangle, 1, FailureHandling.CONTINUE_ON_FAILURE)

if(_000USDPre) {
	WebUI.click(sg.span_0_00USDT, FailureHandling.STOP_ON_FAILURE);
}else if(span_USDTPre) {
	WebUI.click(sg.span_USDT, FailureHandling.STOP_ON_FAILURE);
}else if(div_USDT_trianglePre) {
	WebUI.click(sg.div_USDT_triangle, FailureHandling.STOP_ON_FAILURE);
}

WebUI.delay(2);
WebUI.click(sg.span_Logout, FailureHandling.STOP_ON_FAILURE);


