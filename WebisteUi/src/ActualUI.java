import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Luke Freeman
 * Creates the UI itself and adds buttons and other things as well
 * JButton has to come first, etc. 
 * The frame of the UI.
 */
public class ActualUI extends JFrame implements ActionListener {
	public void setUpMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JMenu mnuFile2 = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("About");
		miHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"My name is Luke Freeman. "
						+ "I am currently a sophmore at Lewis University. This is "
						+ "a program that takes data from a wesbite and saves it to either"
						+ "a text or a json file. This is my first UI as well.");

			}
		});
		mnuFile.add(miExit);
		bar.add(mnuFile);
		setJMenuBar(bar);
		mnuFile2.add(miHelp);
		bar.add(mnuFile2);
		setJMenuBar(bar);
	}
	public ActualUI() {
		//sets up the look inside this constructor
		setTitle("Final Project");
		setBounds(100,200,400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JButton btnSaveToText = new JButton("Save to text");
		JButton btnSaveToJson = new JButton("Save to JSON");
		JButton btnFile = new JButton("File");
		JButton btnHelp = new JButton("Help");
		c.add(btnSaveToText,BorderLayout.SOUTH);
		c.add(btnSaveToJson,BorderLayout.SOUTH);
		btnHelp.addActionListener(this);
		setUpMenu();
	}
	public static void main (String [] args) {
		ActualUI AUI = new ActualUI();
		AUI.setVisible(true);	//this shows the frame itself
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
