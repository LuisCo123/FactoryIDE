package factoryjava;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;


public class SHJava extends JFrame {
	private JPanel jp = new JPanel(new BorderLayout());
    private RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
	
    public SHJava(String dir) throws IOException{
    	this.SHCreator();
    	this.SHLoad(dir);   
    }
    
	public SHJava() throws IOException{
		this.SHCreator();
	}
	
	private void SHCreator() {
		
	    this.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
	    this.textArea.setCodeFoldingEnabled(true);
	    RTextScrollPane sp = new RTextScrollPane(textArea);
	    this.jp.add(sp);
	    setContentPane(this.jp);
	    setTitle("Java Editor");
	    setLocationRelativeTo(null);
	    pack();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void SHLoad(String dir) throws IOException {
		 if (dir != null) {
		    	FileReader fr = new FileReader(dir);
		    	BufferedReader br = new BufferedReader(fr);
		    	textArea.read(br, null);
		    	
		    }
	}
	

}
