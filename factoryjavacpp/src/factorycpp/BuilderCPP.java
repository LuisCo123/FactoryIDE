package factorycpp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import interfaces.IBuilder;

public class BuilderCPP implements IBuilder{

	@Override
	public void compile(File file) throws IOException, InterruptedException{
		String[] comand = {"g++", "-o", file.getAbsolutePath().split("\\.")[0], file.getAbsolutePath()};

		
		Process procCompile =new ProcessBuilder(comand).start();
		procCompile.waitFor();
		
		BufferedReader reader =  
	              new BufferedReader(new InputStreamReader(procCompile.getInputStream()));

	        String line = "";
	        while((line = reader.readLine()) != null) {
	            System.out.print(line + "\n");
	        }
	        if(procCompile.exitValue()==0) {
	        	System.out.println("Success");
	        }
	        
		
	}

}
