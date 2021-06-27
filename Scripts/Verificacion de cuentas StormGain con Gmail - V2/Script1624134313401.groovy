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
import helper.GmailObjects as GmailObjects

/*
 *
 * 
 * 	Este bucle for recorre los datos del Test Data llamado "emails". Se debe considerar la inciacion y finalizacion del mismo, 
 *  segun la lista de corres disponibles del Test Data.
 * 
 * 
*/
Timestamp timestamp = new Timestamp(System.currentTimeMillis())

Keywords k = new Keywords()

SgTestObjects sg = new SgTestObjects()

GmailObjects gm = new GmailObjects()

AccountManagement am = new AccountManagement()

ExecuteCmd ec = new ExecuteCmd()

CustomDriver cd = new CustomDriver()

String csvPath = (k.KEY_FOLDER_VERI + timestamp.getTime()) + '-VERIFICADAS.csv'

String csvPath1 = (k.KEY_FOLDER_VERI_ND + timestamp.getTime()) + '-PARA_VERIFICAR_PROXIMO_DIA.csv'

am.createFileCSV(csvPath1, 'id,email,password')

am.createFileCSV(csvPath, 'id,email,password')

String dataTest = 'cuentas_a_verificar'

//Abrir el explorador
DriverFactory.changeWebDriver(cd.getDriver('1'))

WebUI.maximizeWindow()

//Ejecuta script para agregar llave de Anti Recaptcha
//ec.executeAmkScript(k.KEY_AMK_ACTIVATE_ANTICAPTCHA);
for (def row = 1; row <= findTestData(dataTest).getRowNumbers(); row++) {
    boolean passed = false

    String email

    String sessionEmail

    String password

    email = findTestData(dataTest).getValue('email', row)

    password = findTestData(dataTest).getValue('password', row)

    while (!(passed)) {
        try {
            //Inicio de sesion
            boolean error_loginPre = false

            boolean msg_mail_sentPre = false

            boolean _000USDPre = false

            boolean span_USDTPre = false

            boolean div_USDT_trianglePre = false

            boolean emailIsPre = false

            boolean verified_badge_emailPre = false

            boolean unverified_badge_emailPre = false

            boolean span_Edit_emailPre = false

            //navegar a la pantalla de perfil
            WebUI.navigateToUrl('https://app.stormgain.com/profile-settings/#modal_login')

            WebUI.waitForPageLoad(20)

            //Si hay un usuario en sesion se debe verificar que sea el correspondiente y si no, cerrar sesion
            _000USDPre = WebUI.verifyElementPresent(sg.span_0_00USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)

            span_USDTPre = WebUI.verifyElementPresent(sg.span_USDT, 1, FailureHandling.CONTINUE_ON_FAILURE)

            div_USDT_trianglePre = WebUI.verifyElementPresent(sg.div_USDT_triangle, 1, FailureHandling.CONTINUE_ON_FAILURE)

            if ((_000USDPre || span_USDTPre) || div_USDT_trianglePre) {
                emailIsPre = WebUI.verifyElementPresent(sg.div_email_session, 1, FailureHandling.CONTINUE_ON_FAILURE)

                if (emailIsPre) {
                    sessionEmail = WebUI.getText(sg.div_email_session, FailureHandling.CONTINUE_ON_FAILURE)
                }
                
                WebUI.callTestCase(findTestCase('AccountManagement/SignOut'), null, FailureHandling.STOP_ON_FAILURE)

                WebUI.navigateToUrl('https://app.stormgain.com/profile-settings/#modal_login')
            }
            
            WebUI.callTestCase(findTestCase('AccountManagement/Login'), [('email') : email, ('password') : 'Password.1*'], 
                FailureHandling.STOP_ON_FAILURE)

            //verificar si la cuenta fue bloqueada
            error_loginPre = WebUI.verifyElementPresent(sg.error_login, 1, FailureHandling.CONTINUE_ON_FAILURE)

            if (!(error_loginPre)) {
                //Identificar si el email esta verificado 
                verified_badge_emailPre = WebUI.verifyElementAttributeValue(sg.verified_badge_email, 'class', 'verified-badge tooltip-info', 
                    1, FailureHandling.CONTINUE_ON_FAILURE)

                span_Edit_emailPre = WebUI.verifyElementPresent(sg.span_Edit_email, 1, FailureHandling.CONTINUE_ON_FAILURE)

                unverified_badge_emailPre = WebUI.verifyElementAttributeValue(sg.unverified_badge_email, 'class', 'not-verified-badge tooltip-info', 
                    1, FailureHandling.CONTINUE_ON_FAILURE)

                if (!(verified_badge_emailPre) && unverified_badge_emailPre) {
                    //Si el correo no esta verificado, entonses se envia un mail a yopmail.
                    //WebUI.click(sg.span_Edit_email)

                    //WebUI.setText(sg.input_Email_email, email)

					boolean span_verify_emailPre = WebUI.verifyElementPresent(sg.span_verify_email, 1, FailureHandling.CONTINUE_ON_FAILURE);
					
                    while (span_verify_emailPre) {
                        WebUI.click(sg.span_verify_email)
                        WebUI.delay(1);
						span_verify_emailPre = WebUI.verifyElementPresent(sg.span_verify_email, 1, FailureHandling.CONTINUE_ON_FAILURE);
                    }
                    
                    //WebUI.callTestCase(findTestCase('VerifyGmail'), [:], FailureHandling.STOP_ON_FAILURE)
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

                    WebUI.delay(10)

                    WebUI.navigateToUrl('https://app.stormgain.com/profile-settings/#modal_login')

                    //Identificar si el email esta verificado
                    verified_badge_emailPre = WebUI.verifyElementAttributeValue(sg.verified_badge_email, 'class', 'verified-badge tooltip-info', 
                        1, FailureHandling.CONTINUE_ON_FAILURE)

                    unverified_badge_emailPre = WebUI.verifyElementAttributeValue(sg.unverified_badge_email, 'class', 'not-verified-badge tooltip-info', 
                        1, FailureHandling.CONTINUE_ON_FAILURE)

                    if (!(verified_badge_emailPre) && unverified_badge_emailPre) {
                        passed = false //agregar cuenta al csv
                    } else {
                        am.addAccountToCsv(csvPath, (('1,' + email) + ',') + password)

                        passed = true
                    }
                    //si la cuenta ya esta verificada agregarla al csv
                } else {
                    am.addAccountToCsv(csvPath, (('1,' + email) + ',') + password)

                    passed = true
                }
                
                //cierre de sesion
                WebUI.callTestCase(findTestCase('AccountManagement/SignOut'), null, FailureHandling.STOP_ON_FAILURE)

                WebUI.navigateToUrl('https://app.stormgain.com/profile-settings/#modal_login')
            } else {
                passed = true
            }
        }
        catch (Exception e) {
            e.printStackTrace()
        } 
    }
}

