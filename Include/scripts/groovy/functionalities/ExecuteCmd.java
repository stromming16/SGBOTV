package functionalities;


import java.io.*;

public class ExecuteCmd {
	
	public void executeAmkScript(String AmkScriptPath) {
		
		try {
			
			ProcessBuilder builder = new ProcessBuilder(
		            "cmd.exe", "/c", AmkScriptPath);
		    
			builder.redirectErrorStream(true);
		    Process p = builder.start();
		    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    String line;
		    
		    while (true) {
		        line = r.readLine();
		        if (line == null) { break; }
		        System.out.println(line);
		    }
		    
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error al ejecutar AMK script");
		}
	}
	
	public static void main(String[] args) throws Exception {
        
    }
}