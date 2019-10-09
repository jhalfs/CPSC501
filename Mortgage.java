

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

/**
 * @author Julien
 * @version 3.2
 */

public class Mortgage {
	/**
	 * These are the variables used when other methods are trying to access data from this class
	 */
	private double periodicBlendedPayment;
	private double totalInterest;
	private double totalWithPrincipal;
	private double interestPrincipalRatio;
	private double avgInterestPerYear;
	private double avgInterestPerMonth;
	private double amortizationYears;
	private double tempVariableA;
	private double tempVariableB;

	/**
	 * This method calculates the periodic blended payment.
	 * @param amortization The number of payments used to calculate the blended payment
	 * @param principal The total amount loaned used to calculate the blended payment
	 * @param interestRate The rate of interest used to calculate the blended payment
	 */
	public void calculatePeriodicBlendedPayment(int amortization, int principal, double interestRate){
		tempVariableA = tempVariableCalculationA(interestRate, amortization);
		tempVariableB = tempVariableCalculationB(tempVariableA, amortization);
		periodicBlendedPayment=((principal*tempVariableA)/(1-tempVariableB));
	}
	public double tempVariableCalculationA(double interestRate, int amortization){
		return java.lang.Math.pow(((interestRate/2)+1),(2/amortization))-1;
	}
	public double tempVariableCalculationB(double tempVariableA, int amortization){
		return java.lang.Math.pow((tempVariableA + 1), (-amortization));
	}
	/**
	 * This method calculates the total interest paid 
	 * @param amortization The number of payments used to calculate the total amount of interest paid
	 * @param interestRate The rate of interest used to calculate the total amount of interest paid
	 */
	public void calculateTotalInterest(int amortization, double interestRate){
		totalInterest=(interestRate/12)*amortization;
	}
	/**
	 * This method calculates the total interest and the principal
	 * @param principal The to amount loaned is used to calculate the total interest with the principal
	 */
	public void calculateTotalWithPrincipal(int principal){
		totalWithPrincipal=totalInterest+principal;
	}
	/**
	 * This method calculates the Interest to Principal ratio
	 * @param principal The total amount loaned is used to calculates the ratio
	 * @param interestRate The amount of interest is used to calculate the ratio
	 */
	public void calculateIpRatio(int principal, double interestRate){
		interestPrincipalRatio=interestRate/principal;
	}
	/**
	 * This method calculates the average interest per year
	 * @param interestRate The amount of interest used to calculate the average interest per year
	 * @param amortization The number of payments made is used to calculate the average interest per year
	 * @param principal The total amount loaned is used to calculate the average interest per year
	 */
	public void calculateaAvgInterestPerYear(double interestRate, int amortization, int principal){
		avgInterestPerYear=((interestRate*principal)/amortization)*12;
	}
	/**
	 * This method is used to calculate the average interest per month
	 */
	public void calculateAvgInterestPerMonth(){
		avgInterestPerMonth=avgInterestPerYear/12;
	}
	/**
	 * This method is used to calculate the number of payments made in years rather than months
	 * @param amortization The number of payments in months is used to calculate the number of payments made per year
	 */
	public void calculateAmortizationYears(int amortization){
		amortizationYears=amortization/12;
	}
	/**
	 * This method returns the previously calculated value of the periodic blended payment
	 * @return It returns the periodic blended payment
	 */
	public double getPeriodicBlendedPayment() {
		return periodicBlendedPayment;
	}
	/**
	 * This method returns the previously calculated value of the total interest
	 * @return It returns the total interest
	 */
	public double getTotalInterest() {
		return totalInterest;
	}
	/**
	 * This method returns the total interest combined with the principal
	 * @return It returns the total interest with the principal
	 */
	public double getTotalWithPrincipal() {
		return totalWithPrincipal;
	}
	/**
	 * This method returns the interest to principal ratio
	 * @return It returns the interest to principal ratio
	 */
	public double getIpRatio() {
		return interestPrincipalRatio;
	}
	/**
	 * This method returns the average interest per year
	 * @return It returns the average interest per year
	 */
	public double getAvgInterestPerYear() {
		return avgInterestPerYear;
	}
	/**
	 * This method returns the average interest per month
	 * @return It returns the average interest per month
	 */
	public double getAvgInterestPerMonth() {
		return avgInterestPerMonth;
	}
	/**
	 * This method returns the number of payments in years rather than months
	 * @return It returns the number of payments in years rather than months 
	 */
	public double getAmortizationYears() {
		return amortizationYears;
	}
	//Added methods so I can test the Temp as Query refactoring
	public double getTempVariableA(){
		return tempVariableA;
	}
	
	public double getTempVariableB(){
		return tempVariableB;
	}
	
	public static void main(String[] args){
		MortgageGUI view=new MortgageGUI();
		Mortgage mortgage=new Mortgage();
		MortgageCalc myController=new MortgageCalc(view, mortgage);
	}

}
