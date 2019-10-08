

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;

/*
 * @author Julien
 */

public class MortgageGUI extends JFrame{
	/**
	 * These variables are used to set the values of whatever they apply to
	 */
	private double periodicBlendedPayment;
	private double totalInterest;
	private double totalWithPrincipal;
	private double ipRatio;
	private double avgInterestPerYear;
	private double avgInterestPerMonth;
	private double amortizationYears;
	
	/**
	 * These are the different text boxes on the window
	 */
	private JTextField amortization;
	private JTextField principal;
	private JTextField interestRate;
	private JTextField periodicBlended;
	private JTextField totalInt;
	private JTextField totalWPrinc;
	private JTextField ipRat;
	private JTextField avgIntYear;
	private JTextField avgIntMonth;
	private JTextField amortYears;
	/**
	 * This is the button on the window that can be clicked by the user
	 */
	private JButton calculateButton;
	
	/**
	 * These are all the labels for the different text boxes on the window
	 */
	private JLabel amort;
	private JLabel princ;
	private JLabel intRate;
	private JLabel periodicBlendedLabel;
	private JLabel totalIntLabel;
	private JLabel totalWPrincLabel;
	private JLabel ipRatioLabel;
	private JLabel avgIntYearLabel;
	private JLabel avgIntMonthLabel;
	private JLabel amortYearsLabel;
	/**
	 * This is the panel that hold all the text boxes, labels, and buttons
	 */
	private JPanel panel;
	
	/**
	 * This method returns the integer value of the text entered into the amortization text box
	 * @return It returns the integer value of the text
	 */
	public int getAmortization(){
		return Integer.parseInt(amortization.getText());
	}
	/**
	 * This method returns the integer value of the text entered into the principal text box
	 * @return It returns the integer value of the text
	 */
	public int getPrincipal(){
		return Integer.parseInt(principal.getText());
	}
	/**
	 * This method returns the integer value of the text entered into the interest rate text box
	 * @return It returns the integer value of the text
	 */
	public double getInterestRate(){
		return Double.parseDouble(interestRate.getText());
	}
	/**
	 * This method creates an event listener for the calculate button
	 * @param listener This parameter is the name of the listener added
	 */
	public void setEventListener(ActionListener listener){
		calculateButton.addActionListener(listener);
	}
	/**
	 * This method creates a window listener for when the user tries to exit the window
	 * @param listener This parameter is the name of the listener added
	 */
	public void setWindowListener(WindowListener listener){
		this.addWindowListener(listener);
	}
	/**
	 * This method sets the value of the periodic blended payment as  string and displays it on the window
	 * @param periodicBlended Takes the periodic blended payment as a parameter in order to make it a string
	 */
	public void setPeriodicBlendedPayment(double periodicBlended) {
		String perBlend=String.valueOf(periodicBlended);
		this.periodicBlended.setText(perBlend);
	}
	
	/**
	 * This method sets the value of the total interest as  string and displays it on the window
	 * @param totalInt Takes the total interest as a parameter in order to make it a string
	 */
	public void setTotalInterest(double totalInt) {
		String totInt=String.valueOf(totalInt);
		this.totalInt.setText(totInt);
	}
	
	/**
	 * This method sets the value of the total interest and the principal as  string and displays it on the window
	 * @param totalWPrinc Takes the total interest and principal as a parameter in order to make it a string
	 */
	public void setTotalWithPrincipal(double totalWPrinc) {
		String totPrinc=String.valueOf(totalWPrinc);
		this.totalWPrinc.setText(totPrinc);
	}
	
	/**
	 * This method sets the value of the interest to principal ratio as  string and displays it on the window
	 * @param ipRat Takes the interest to principal as a parameter in order to make it a string
	 */
	public void setIpRatio(double ipRat) {
		String iRat=String.valueOf(ipRat);
		this.ipRat.setText(iRat);
	}
	
	/**
	 * This method sets the value of the average interest per year as  string and displays it on the window
	 * @param avgIntYear Takes the average interest per year as a parameter in order to make it a string
	 */
	public void setAvgInterestPerYear(double avgIntYear) {
		String avgIntYr=String.valueOf(avgIntYear);
		this.avgIntYear.setText(avgIntYr);
	}
	
	/**
	 * This method sets the value of the average interest per month as  string and displays it on the window
	 * @param avgIntMonth Takes the average interest per month as a parameter in order to make it a string
	 */ 
	public void setAvgInterestPerMonth(double avgIntMonth) {
		String avgIntMn=String.valueOf(avgIntMonth);
		this.avgIntMonth.setText(avgIntMn);
	}
	
	/**
	 * This method sets the value of the amortization in years as  string and displays it on the window
	 * @param amortYears Takes the amortization in years as a parameter in order to make it a string
	 */
	public void setAmortizationYears(double amortYears) {
		String amortYrs=String.valueOf(amortYears);
		this.amortYears.setText(amortYrs);
	}
	
	/**
	 * This is the constructor used to create the window containing all the elements declared earlier
	 */
	public MortgageGUI()
	{
		/**
		 * Sets the name of the window
		 */
		super("Mortgage Calculator Application");
		/**
		 * Allows the window to be closed
		 */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/**
		 * Sets the size of the window
		 */
		setSize(800, 200);
		/**
		 * These create all the text fields on the panel
		 */
		amortization=new JTextField(10);
		principal=new JTextField(10);
		interestRate=new JTextField(10);
		periodicBlended=new JTextField(10);
		totalInt=new JTextField(10);
		totalWPrinc=new JTextField(10);
		ipRat=new JTextField(10);
		avgIntYear=new JTextField(10);
		avgIntMonth=new JTextField(10);
		amortYears=new JTextField(10);
		
		/**
		 * These create all the labels for the text fields 
		 */
		calculateButton=new JButton("Calculate");
		amort=new JLabel("Amortization:");
		princ=new JLabel("Principal:");
		intRate=new JLabel("Interest Rate:");
		periodicBlendedLabel=new JLabel("Periodic Blended Payment:");
		totalIntLabel=new JLabel("Total Interest:");
		totalWPrincLabel=new JLabel("Total With Principal:");
		ipRatioLabel=new JLabel("Interest Principal Ratio:");
		avgIntYearLabel=new JLabel("Average Interest per Year:");
		avgIntMonthLabel=new JLabel("Average interest per Month:");
		amortYearsLabel=new JLabel("Amortization in Years:");
		
		
		/**
		 * This creates the panel and sets the layout for it
		 */
		panel=new JPanel();
		add(panel);
		/**
		 * These add all the different elements in the correct order on the panel 
		 */
		panel.add(amort);
		panel.add(amortization);
		panel.add(princ);
		panel.add(principal);
		panel.add(intRate);
		panel.add(interestRate);
		panel.add(calculateButton);
		panel.add(periodicBlendedLabel);
		panel.add(periodicBlended);
		panel.add(totalIntLabel);
		panel.add(totalInt);
		panel.add(totalWPrincLabel);
		panel.add(totalWPrinc);
		panel.add(ipRatioLabel);
		panel.add(ipRat);
		panel.add(avgIntYearLabel);
		panel.add(avgIntYear);
		panel.add(avgIntMonthLabel);
		panel.add(avgIntMonth);
		panel.add(amortYearsLabel);
		panel.add(amortYears);
		/**
		 * This lets the panel be viewed by the user
		 */
		setVisible(true);
	}

}