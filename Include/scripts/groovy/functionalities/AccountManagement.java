package functionalities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import com.opencsv.CSVReader;
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
	  
	  public void editFileCSV(String filePath, String replace, int row, int col) throws IOException {
		  File inputFile = new File(filePath);
		  FileReader fr = new FileReader(inputFile);
		  
		  // Read existing file 
		  CSVReader reader = new CSVReader(fr, ',');
		  
		  List<String[]> csvBody = reader.readAll();
		  // get CSV row column  and replace with by using row and column
		  csvBody.get(row)[col] = replace;
		  reader.close();
		  
		  //Write to CSV file which is open
		  CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
		  writer.writeAll(csvBody);
		  writer.flush();
		  writer.close();
	  }
	  
	  public String generateUsername(String type) {
		  
		  String email = "";
		  String temp = RandomStringUtils.random(15, "abcdefghijklmnopqrstuvwxyz1234567890_-.");
		  email = "s"+temp.substring(0, temp.length()) + "@"+type+".com";
		  
		  return email;
	  }
	  
	  public List<String> generateGmails(String gmail) {
		  List<String> emails = new ArrayList<String>();
		  int index = gmail.indexOf('@');
		  String username = gmail.substring(0,index);
		  int cCount = username.length();
		  
		  for(int i = 0; i < cCount; i++) {
			  System.out.println(insertPeriodically(username, ".", i+1, i));
		  }
		  
		  return emails;
	  }
	  
	  public static String insertPeriodically(String text, String insert, int period, int location){
		  StringBuilder builder = new StringBuilder(text.length() + insert.length() * (text.length()/period)+1);
		  int index = 0;
		  String prefix = "";
		  while (index < text.length())
		  {
		      // Don't put the insert in the very first iteration.
		      // This is easier than appending it *after* each substring
			  if(location == index) {
				  builder.append(prefix);
			  }
		      
		      prefix = insert;
		      builder.append(text.substring(index, Math.min(index + period, text.length())));
		      index += location;
		  }
		  return builder.toString();
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