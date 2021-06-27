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

public class GmailObjects {

	public TestObject firtsMail = findTestObject('Object Repository/GmailInboxObjects/tr_seleccionada, StormGain, Please');
	public TestObject firtsMail_1 = findTestObject('Object Repository/GmailInboxObjects/span_Verifica tu direccin de correo');
	public TestObject recibidosBtn = findTestObject('Object Repository/GmailInboxObjects/a_Recibidos');
	public TestObject verifyLink = findTestObject('Object Repository/GmailInboxObjects/a_link');
	public TestObject verifyA = findTestObject('Object Repository/GmailInboxObjects/a_Verify email');
}
