package factoryjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import interfaces.IBuilder;

public class BuilderJava implements IBuilder{

	public void compile(File file) throws IOException, InterruptedException {
		String[] comand = {"javac", file.getAbsolutePath()};
		
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
