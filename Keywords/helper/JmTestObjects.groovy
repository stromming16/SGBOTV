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

import internal.GlobalVariable

public class JmTestObjects {

	//find mail objects
	public TestObject input_email = findTestObject('Object Repository/YopMailObjects/Page_YOPmail - Disposable Email Address/iframe_Inbox_ifinbox');
	public TestObject btn_email = findTestObject('Object Repository/YopMailObjects/Page_YOPmail - Disposable Email Address/input_Type the Email name of your choice_sbut');

	//link verification objects
	public TestObject a_verify = findTestObject('Object Repository/YopMailObjects/Page_YOPmail - Inbox/a_Verify email (1)');
	public TestObject a_StormGain = findTestObject('Object Repository/YopMailObjects/Page_YOPmail - Inbox/a_StormGain');
}
