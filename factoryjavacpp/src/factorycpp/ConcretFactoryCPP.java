package factorycpp;

import java.io.IOException;

import javax.swing.JFrame;

import interfaces.IBuilder;
import interfaces.IFactoryIde;
public class ConcretFactoryCPP implements IFactoryIde{

	public JFrame SHighlighter(String dir)throws IOException {
		return new SHCPP(dir);
	}
	public JFrame SHighlighter()throws IOException {
		return new SHCPP();
	}

	@Override
	public IBuilder Builder() {
		return new BuilderCPP();
	}

}
