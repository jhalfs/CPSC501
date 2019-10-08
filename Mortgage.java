
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
	/**
	 * These variables are used in calculating the periodic blended payment.
	 */
	public double i;
	public double l;


	/**
	 * This method calculates the periodic blended payment.
	 * @param amortization The number of payments used to calculate the blended payment
	 * @param principal The total amount loaned used to calculate the blended payment
	 * @param interestRate The rate of interest used to calculate the blended payment
	 */
	public void calculateMortgageValues(int amortization, int principal, double interestRate){
		i= java.lang.Math.pow(((interestRate/2)+1),(2/amortization))-1;
		l=java.lang.Math.pow((i+1), (-amortization));
		periodicBlendedPayment=((principal*i)/(1-l));
		totalInterest=(interestRate/12)*amortization;
		totalWithPrincipal=totalInterest+principal;
		interestPrincipalRatio=interestRate/principal;
		avgInterestPerYear=((interestRate*principal)/amortization)*12;
		avgInterestPerMonth=avgInterestPerYear/12;
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
}
