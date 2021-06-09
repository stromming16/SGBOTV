package functionalities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;

import com.kms.katalon.core.testdata.reader.CSVReader;
import com.opencsv.CSVWriter;

public class WriteFile {
	

	public void createFile(String name) {
		try {
		      File myObj = new File("C:\\Users\\administrador\\Desktop\\data\\"+name+".txt");
		      
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
  public void writeAccount(String name) {
	  try {
	      FileWriter myWriter = new FileWriter("C:\\Users\\administrador\\Desktop\\data\\usersBlocked.txt");
	      myWriter.write("\n"+name);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	   } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	   }
  }
  
  public void writeFile() {
	  
	  try{
          String verify, putData;
          File file = new File("C:\\Users\\administrador\\Desktop\\data\\usersBlocked.txt");
          
          FileWriter fw = new FileWriter("C:\\Users\\administrador\\Desktop\\data\\usersBlocked.txt");

          fw.write("something");
          
          fw.close();

      }catch(IOException e){
    	  e.printStackTrace();
      }
  }
  
  public void addLine() {
	  try {
		  
		  String csv = "C:\\Users\\administrador\\Desktop\\Cuentas\\cuentas.csv";
	      CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

	      for(int i = 0; i < 2; i++) {
	    	  String [] record = "1,daniel_1234@hotmail.es,Password.01*".split(",");

		      writer.writeNext(record);
	      }
	      

	      writer.close();
	      
	  }catch(IOException e) {
		  e.printStackTrace();
	  }
  }
  
  public static void main(String[] args) {
    
  }
}