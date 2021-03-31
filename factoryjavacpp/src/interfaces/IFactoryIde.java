package interfaces;

import java.io.IOException;

import javax.swing.JFrame;

import factoryjava.SHJava;

public interface IFactoryIde {
	 public JFrame SHighlighter(String dir)throws IOException;
	 public JFrame SHighlighter() throws IOException;
	 public IBuilder Builder();
}
