package factoryjava;


import java.io.IOException;

import javax.swing.JFrame;

import interfaces.IBuilder;
import interfaces.IFactoryIde;

public class ConcretFactoryJava implements IFactoryIde{
	public JFrame SHighlighter(String dir) throws IOException{ 
		return new SHJava(dir);
	}
	public JFrame SHighlighter() throws IOException{ 
		return new SHJava();
	}
    public IBuilder Builder(){
        return new BuilderJava();
    }

}
