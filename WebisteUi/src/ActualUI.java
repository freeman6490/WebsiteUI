//https://www.amctheatres.com/showtimes/all/2019-12-11/amc-woodridge-18/all?gclid=EAIaIQobChMI_6KNmayu5gIVyrzACh3nuQ3lEAAYASAAEgJriPD_BwE&gclsrc=aw.ds&utm_campaign=online-ticketing&utm_content=marketing&utm_launch=2019-10-05&utm_medium=paidsearch&utm_source=google&utm_term=keyword

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Luke Freeman
 * Creates the UI itself and adds buttons and other things as well
 * JButton has to come first, etc. 
 * The frame of the UI.
 */
class ButtonHandler implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {}
}
public class ActualUI extends JFrame implements ActionListener {
	private ArrayList<Movie> movies;
	String fileName;
	Scanner sc = new Scanner (System.in);
	/**
	 * @author Luke Freeman
	 * sets up the menu bar on the top of the UI
	 * options are file and help
	 * file closes the program, help drops down an about button which opens an informative message using JOptionPane
	 */
	public void setUpMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miOpenFile = new JMenuItem("Open File");
		miOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser();
					if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						System.out.println(jfc.getSelectedFile().getPath());
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		});
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
	/**
	 * @author Luke Freeman
	 * set up the UI, added some buttons too
	 * Buttons so far
	 * btnSaveToText
	 * btnSaveToJson
	 */
	public ActualUI() {
		/**
		 * @author Luke Freeman
		 * this is the constructor for the UI itself. it sets up buttons, border layouts, panels
		 * and eventually the UI itself, added action listeners and button handlers as well
		 */
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		ButtonHandler handlerForText = new ButtonHandler();
		ButtonHandler handlerForJson = new ButtonHandler();
		setTitle("Final Project");
		setBounds(50,100,400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTextArea showText = new JTextArea();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(showText, BorderLayout.CENTER);
		JButton btnSaveToText = new JButton("Save to text");
		JButton btnSaveToJson = new JButton("Save to JSON");
		JButton btnFile = new JButton("File");
		JButton btnHelp = new JButton("Help");
		btnSaveToText.addActionListener(handlerForText);
		btnSaveToJson.addActionListener(handlerForJson);
		panSouth.add(btnSaveToText);
		panSouth.add(btnSaveToJson);
		btnSaveToText.addActionListener(new ActionListener() {
			public void actionPerformed1(ActionEvent e) {
				System.out.println("Enter name of file: ");
				fileName = sc.nextLine();
				Writer.writeToTextFle(fileName, movies);
				System.out.println("saved");
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnSaveToJson.addActionListener(new ActionListener() {
			public void actionPerformed2(ActionEvent e) {
				System.out.println("Enter the name of file");
				fileName = sc.nextLine();
				Writer.writeToJSON(fileName, movies);
				System.out.println("saved");
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnSaveToText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveToJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			}
		});
		panSouth.add(btnSaveToText);
		panSouth.add(btnSaveToJson);
		c.add(panSouth, BorderLayout.SOUTH);
		btnHelp.addActionListener(this);
		setUpMenu();
		JLabel urlLabel = new JLabel("Enter URL");
		JTextField url1 = new JTextField(20);
		JButton btnGrabData = new JButton("fetch");
		btnGrabData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String urlText = "";
					String line;
					URL url = new URL(url1.getText());
					URLConnection connect = url.openConnection();
					BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
					while ((line = br.readLine()) != null) {
						urlText += line;
					}
					String DataToShow = "";
					DataToShow = DataToShow + urlText;
					showText.setText(DataToShow);
				} catch (Exception ex) {
					System.out.println("Something went wrong when connecting to the URL");
				}
			}
		});
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new FlowLayout());
		panNorth.add(urlLabel);
		panNorth.add(url1);
		panNorth.add(btnGrabData);
		c.add(panNorth, BorderLayout.NORTH);
		}
	@Override
	public void actionPerformed(ActionEvent e) {}
	/**
	 * main class
	 * @author Luke Freeman
	 * main class that is going to implement the UI
	 * the UI is made above but the main will be used to parse the data as well
	 * probably going to use a while loop and go from there
	 * leading more and more to only using one big class with more subclasses in it
	 */
	public static void main (String [] args) {
		ActualUI AUI = new ActualUI();
		AUI.setVisible(true);	//this shows the frame itself
	}
}
