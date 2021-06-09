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


public class Keywords {

	EnvConfig c = new EnvConfig();

	public String KEY_ACCOUNTS_CSV_PATH = "C:\\Users\\" + c.pcusername + "\\Desktop\\Cuentas\\cuentas.csv";

	public String KEY_FOLDER_CREADAS = c.disco +":\\creadas\\";

	public String KEY_FOLDER_DEPU = c.disco +":\\depuradas\\";

	public String KEY_FOLDER_VERI = c.disco +":\\verificadas\\";

	public String KEY_FOLDER_VERI_ND = c.disco +":\\verificar_proximo_dia\\";

	public String KEY_AMK_INICAR_SESION_CMD = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\ClicIniciarSesion.amk\"";

	public String KEY_AMK_VERIFY_YOPMAIL_CMD = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\ClicVerificarYopmail.amk\"";

	public String KEY_AMK_CONFIRM_CMD = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\ClicConfirmarCorreo.amk\"";

	public String KEY_AMK_ACTIVATE_ANTICAPTCHA = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\ActivateAntiCaptcha.amk\"";

	public String KEY_AMK_RECAPTCHA_YOPMAIL = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\IfRecaptchaFoundonYopmail.amk\"";

	public String KEY_AMK_RECAPTCHA_SGLOGIN = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\IfRecaptchaFoundonStormGLogin.amk\"";

	public String KEY_AMK_RECAPTCHA_SGSEND_MAIL = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\IfRecaptchaFoundonStormGSendMail.amk\"";

	public String KEY_AMK_LOGOUTSG = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\LogOutSG.amk\"";
	
	public String KEY_AMK_CREATE_SG = "\"C:\\Users\\" + c.pcusername + "\\Desktop\\AMC\\CreateSGAccount.amk\"";
}
