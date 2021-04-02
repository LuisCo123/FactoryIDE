package app;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import UserInterface.Menu;
import UserInterface.PluginsFrame;
import interfaces.IFactoryIde;
import interfaces.IInterfaces;
//import jdk.tools.jlink.resources.plugins;
import thread.ThreadA;

public class App {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
		menu();
	}
	
	public static void createFactory(IFactoryIde factory, String dir) throws IOException, InterruptedException {
		if(dir!=null) {
			factory.SHighlighter(dir).setVisible(true);
			factory.Builder().compile(new File(dir));
		}
		else{factory.SHighlighter().setVisible(true);
		}
	}
	public static void run (String dir, String extension) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
			boolean sucess = false;
			File currentDir = new File ("./src/plugins");
			String[] pluginsF = currentDir.list();
			URL[] jars = new URL [pluginsF.length]; 
			
			for(int i = 0 ; i < pluginsF.length; i++) {
				jars[i] = (new File("./src/plugins/" + pluginsF[i])).toURL();
			}
			
		    URLClassLoader urlc = new URLClassLoader(jars);
		    for(int i = 0; i < pluginsF.length; i++) {
		    	if (pluginsF[i].toLowerCase().contains(extension.toLowerCase())) {
		    		String factoryName = pluginsF[i].split("\\.")[0];
			    	IFactoryIde factory = (IFactoryIde) Class.forName(factoryName.toLowerCase() + "." + "Concret"+ factoryName, true, urlc).newInstance();
					createFactory(factory, dir);
					sucess = true;
		    	}
		    }
		    if(!sucess) {
		    	System.out.println("Não existe plugin que suporte este arquivo");
		    }
	}
	public static void run() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
		String factoryName;
		do {
			ThreadA tA = new ThreadA();
			File currentDir = new File ("./src/plugins");
			String[] pluginsF = currentDir.list();
			PluginsFrame pluginMenu = new PluginsFrame(pluginsF, tA);
			synchronized (tA) {
				try{
					System.out.println("Aguardando escolha da Factory");
					tA.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			factoryName = pluginMenu.getFactoryName();
			URL[] jars = new URL [pluginsF.length];
			for(int i = 0 ; i < pluginsF.length; i++) {
				jars[i] = (new File("./src/plugins/" + pluginsF[i])).toURL();
			}
		    URLClassLoader urlc = new URLClassLoader(jars);
		    if (factoryName != "Refresh" ) {
		    	factoryName = factoryName.split("\\.")[0];
		    	IFactoryIde factory = (IFactoryIde) Class.forName(factoryName.toLowerCase() + "." + "Concret"+ factoryName, true, urlc).newInstance();
				createFactory(factory,null);
		    }
	    }while(factoryName == "Refresh");
	}
	
	public static void menu() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ThreadA tA = new ThreadA();
		IInterfaces menu = new Menu(tA);
		String dir;
		String extension;
		synchronized (tA) {
			try{
				System.out.println("Aguardando escolha...");
				tA.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		dir = menu.getAbsoluteDir();
		if(dir!=null) {
			extension = dir.split("\\.")[1];
			run(dir,extension);
		
		}else run();
	}
	
	
}