package UserInterface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import thread.ThreadA;

public class PluginsFrame extends JFrame implements ActionListener{
	private JButton[] buttonList;
	private String factorychoose;
	private ThreadA t;


	public PluginsFrame(String[] pluginsf, ThreadA t) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.pack();
		this.setSize(600, 100);
		this.buttonList = new JButton[pluginsf.length + 1];
		for(int i = 0; i < pluginsf.length; i++) {
			this.buttonList[i] = new JButton(pluginsf[i]);
			this.add(buttonList[i]);
			this.buttonList[i].addActionListener(this);
		}
		
		this.buttonList[pluginsf.length] = new JButton("Refresh");
		this.add(this.buttonList[pluginsf.length]);
		this.buttonList[pluginsf.length].addActionListener(this);
		
		this.setVisible(true);
		this.t=t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < buttonList.length; i++) {
			if(e.getSource()==this.buttonList[i]) {
				this.factorychoose = this.buttonList[i].getText();
				dispose();
				this.t.release();
			}
			else if(e.getSource()==this.buttonList[this.buttonList.length - 1]){
				this.factorychoose = this.buttonList[this.buttonList.length - 1].getText();
				dispose();
				this.t.release();
			}
				
		}
	}
	public String getFactoryName() {
		return this.factorychoose;
	}

}
