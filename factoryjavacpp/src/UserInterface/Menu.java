package UserInterface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import interfaces.IInterfaces;
import thread.ThreadA;

public class Menu extends JFrame implements ActionListener, IInterfaces{
	private JButton newButton;
	private JButton openButton;
	private String dir;
	private ThreadA t;
	
	public Menu (ThreadA t) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.newButton = new JButton("New");
		this.newButton.addActionListener(this);
		this.openButton = new JButton("Open");
		this.openButton.addActionListener(this);
		this.setLocationRelativeTo(null);
		this.add(newButton);
		this.add(openButton);

		this.pack();
		this.setVisible(true);
		
		this.t=t;
	}
	
	public void actionPerformed(ActionEvent e ){
		if(e.getSource()==this.newButton) {
			this.dir = null;
			dispose();
			this.t.release();
		}
		if(e.getSource()==this.openButton) {
			JFileChooser fileChooser = new JFileChooser();
			//fileChooser.setCurrentDirectory(new File("C:\\"));
			int response = fileChooser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				this.dir = fileChooser.getSelectedFile().getAbsolutePath();
				dispose();
				this.t.release();
			}
		}

	}
	public String getAbsoluteDir(){
		
		return this.dir;
	}
}
