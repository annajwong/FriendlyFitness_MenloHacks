import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class FriendlyFitnessWithGraphics extends JFrame
{
	// scanner to get user input
	private static final Scanner sc = new Scanner(System.in);
	private static final int MAX_WIDTH = 500;	// width of display screen
	private static final int MAX_HEIGHT = 700;	// height of display screen
	
	/**
	 * FriendlyFitness constructor creates and opens up the display window.
	 */
	public FriendlyFitnessWithGraphics()
	{
		setSize(MAX_WIDTH, MAX_HEIGHT);

		// Create and assemble the components for our window in one JPanel and
		// add it into our JFrame.
		JPanel windowContents = new ContentsOfWindow(this);  
		add(windowContents);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		FriendlyFitnessWithGraphics ffwg = new FriendlyFitnessWithGraphics();	
	}
		
	public static double calculateBMR(int age, double heightIn, double weightLbs, String gender)
	{
		double bmr;
		if (gender.equals("m"))
		{
				bmr = 66 + (6.23 * weightLbs) + (12.7 * heightIn) - (6.8 * age);
		}
		else // female
		{				
			bmr = 655 + (4.35 * weightLbs) + (4.7 * heightIn) - (4.7 * age);
		}

		return bmr;
	}
		
	public static double calculateTimeToBurn(int calsToBurn, double bmr, double met)
	{
		double timeHrs = calsToBurn / (bmr * met / 24);
		return timeHrs;
	}
	
	/**
	 * Paint method to draw everything.
	 */
	public void paint(Graphics g)
	{
		paintComponents(g);
		g.setColor(Color.WHITE);
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD,48));
		g.drawString("FriendlyFitness", 50, 80);
	}	
}

class ContentsOfWindow extends JPanel implements ActionListener
{
	private FriendlyFitnessWithGraphics ffwc; 
	private JButton buttonForMale;  // Buetton for male
	private JButton buttonForFemale;  // Button for female
	private JTextField calsConsumed;   // Component containing calsConsumed
	private JTextField ageText;   	// Component containing age
	private JTextField heightText;   // Component containing height
	private JTextField weightText;   // Component containing weight
	private JTextArea activitiesAndTime;

	public static final Color LIGHT_BLUE = new Color(180, 210, 255);
	/**
	 * Create the window and arrange for callbacks to actionPerformed
	 *  when the buttons are clicked.
	 * 
	 * @param bcIn  Object that will contain this JPanel. It has the
	 *      methods to call to do the actual text conversion
	 */
	public ContentsOfWindow(FriendlyFitnessWithGraphics ffwcIn)
	{
		ffwc = ffwcIn;

		// Make a panel containing buttons lined up horizontally.
		JPanel buttonPanel = createButtonPanel();

		calsConsumed = new JTextField("");
		ageText = new JTextField("");
		heightText = new JTextField("");
		weightText = new JTextField("");
		activitiesAndTime = new JTextArea("");

		// This panel is laid out vertically, with appropriate border and 
		// background color.
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createEmptyBorder(120, 120, 200, 120));  
		setBackground(LIGHT_BLUE);
  
		// Put the components into the panel with spacers.
		add(Box.createRigidArea(new Dimension(0,0)));
		add(Box.createHorizontalGlue());
		add(new JLabel("Enter Calories:"));
		add(calsConsumed);
		add(new JLabel("Enter age in years:"));
		add(ageText);

		add(new JLabel("Enter height (in):"));
		add(heightText);

		add(new JLabel("Enter weight (lbs):"));
		add(weightText);
		add(buttonPanel);
		add(new JLabel("You can try:"));
		add(activitiesAndTime);
  
		// Make sure actionPerformed is called when the buttons are clicked.
		buttonForMale.addActionListener(this);
		buttonForFemale.addActionListener(this);
	}

	/**
	 * Create a panel containing a row of buttons.
	 * 
	 * @return   the newly created panel of clickable buttons
	 */
	private JPanel createButtonPanel()
	{
		// Create the panel with horizontal layout
		JPanel buttonPanel = new JPanel();
		//buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));

		// Create buttons
		buttonForMale = new JButton("MALE");
		buttonForFemale = new JButton("FEMALE");

		// Add newly created buttons to the panel with spacers (rigid areas)
		// for spacing.
		buttonPanel.add(buttonForMale);
		buttonPanel.add(Box.createRigidArea(new Dimension(-10,0)));
		buttonPanel.add(buttonForFemale);

		buttonPanel.setBackground(LIGHT_BLUE);

		return buttonPanel;
	}

	/**
	 * Receive callbacks whenever a button is clicked. See which was clicked
	 *  and perform the appropriate action.
	 * 
	 * @param e   ActionEvent that contains the source of this action  
	 */
	public void actionPerformed(ActionEvent e)
	{
		DecimalFormat df = new DecimalFormat("0.0");
		String[] activities = {"Walking (3.0 mph)", "Jogging", "Running", 
				"Swimming", "Yoga", "Weight lifting", "Biking"};
		double[] mets = {3.5, 7.0, 10.0, 8.0, 2.5, 6.0, 8.0};
		Object sourceOfAction = e.getSource();

		String cals = calsConsumed.getText();
		int calsToBurn = (int)Double.parseDouble(cals);
		String ageStr = ageText.getText();
		int age = (int)Double.parseDouble(ageStr);
		String heightStr = heightText.getText();
		double height = Double.parseDouble(heightStr);
		String weightStr = weightText.getText();
		double weight = Double.parseDouble(weightStr);
		double bmr;
		if(sourceOfAction == buttonForMale)
		{
			bmr = ffwc.calculateBMR(age, height, weight, "m");
			String output = "";
			for (int i = 0; i < activities.length; i++)
			{
				double timeMin = ffwc.calculateTimeToBurn(calsToBurn, bmr, mets[i]) * 60;
				output += activities[i] + ": " + df.format(timeMin) + " min\n";
			}
			activitiesAndTime.setText(output);
		}
		else if(sourceOfAction == buttonForFemale)
		{
			bmr = ffwc.calculateBMR(age, height, weight, "f");
			String output = "";
			for (int i = 0; i < activities.length; i++)
			{
				double timeMin = ffwc.calculateTimeToBurn(calsToBurn, bmr, mets[i]) * 60;
				output += activities[i] + ": " + df.format(timeMin) + " min\n";
			}
			activitiesAndTime.setText(output);
		}
	}
}
