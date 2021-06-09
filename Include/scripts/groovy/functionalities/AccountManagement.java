package functionalities;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.lang.RandomStringUtils;

import com.opencsv.CSVWriter;

public class AccountManagement {

	  public boolean addAccountToCsv(String filePath, String _record ) {
		  try {
			  
		      CSVWriter writer = new CSVWriter(new FileWriter(filePath, true));
  
		      String [] record = _record.split(",");

			  writer.writeNext(record);

		      writer.close();
		      
		      return true;
		      
		  }catch(IOException e) {
			  e.printStackTrace();
			  System.out.println(e);
			  return false;
		  }
	  }
	  
	  public void createFileCSV(String filePath, String header) {
			final String NEXT_LINE = "\n";
			try {
				FileWriter fw = new FileWriter(filePath);

				fw.append(header).append(NEXT_LINE);

				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			}
	  }
	  
	  public String generateUsername(String type) {
		  
		  String email = "";
		  String temp = RandomStringUtils.random(15, "abcdefghijklmnopqrstuvwxyz1234567890_-.");
		  email = "s"+temp.substring(0, temp.length()) + "@"+type+".com";
		  
		  return email;
	  }
	  
	  public String substractUserName(String email) {
		  try {
			  
			int index = email.indexOf('@');
			String username = email.substring(0,index);
			String unLastCharacter = "";
			username = username.replace('+', '_');
			username = username.length() > 24 ? username.substring(0, 24) : username;
			
			unLastCharacter = username.substring(username.length() - 1);
			 
			if(!isNumeric(unLastCharacter)) {
				username = username+"1";
			}
			
			return username;
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	  }
	  
	  public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	  }
	  
	  public static void main(String[] args) {
		    
	  }
}