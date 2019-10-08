import org.junit.Test;
import static org.junit.Assert.*;

//All tests assume that the input values are 1, 1, 1 for the sake of simplicity in testing

public class MortgageTest {
	
	Mortgage testMortgage = new Mortgage();
	
	int inputAmortization = 1;
	int inputInterestRate = 1;
	int inputPrincipal = 1;
	
	//Initiated values based on the original codebase
	double expPeriodicBlended = 2.25;
	double expTotalInterest = 0.0833333;
	double expTotalWithPrincipal = 1.0833333;
	double expInterestPrincipalRatio = 1.0;
	double expAvgInterestPerYear = 12.0;
	double expAvgInterestPerMonth = 1.0;
	double expAmortizationYears = 0.0;
	
	//Values to be received from the Mortgage class
	double actualPeriodicBlended;
	double actualTotalInterest;
	double actualTotalWithPrincipal;
	double actualInterestPrincipalRatio;
	double actualAvgInterestPerYear;
	double actualAvgInterestPerMonth;
	double actualAmortizationYears;
	
	//Now modified to fit the second refactoring I did
	//Still uses the same assertions as they cover all the variables we need to check
	@Test
	public void testVariables(){
		
		//Initialize the variables within the Mortgage class
		testMortgage.calculatePeriodicBlendedPayment(inputAmortization, inputPrincipal, inputInterestRate);
		testMortgage.calculateTotalInterest(inputAmortization, inputInterestRate);
		testMortgage.calculateTotalWithPrincipal(inputPrincipal);
		testMortgage.calculateIpRatio(inputPrincipal, inputInterestRate);
		testMortgage.calculateaAvgInterestPerYear(inputInterestRate, inputAmortization, inputPrincipal);
		testMortgage.calculateAvgInterestPerMonth();
		testMortgage.calculateAmortizationYears(inputAmortization);
		
		//Get the values of the Mortgage's class variables and place them in the appropriate local variables
		actualPeriodicBlended = testMortgage.getPeriodicBlendedPayment();
		actualTotalInterest = testMortgage.getTotalInterest();
		actualTotalWithPrincipal = testMortgage.getTotalWithPrincipal();
		actualInterestPrincipalRatio = testMortgage.getIpRatio();
		actualAvgInterestPerYear = testMortgage.getAvgInterestPerYear();
		actualAvgInterestPerMonth = testMortgage.getAvgInterestPerMonth();
		actualAmortizationYears = testMortgage.getAmortizationYears();
		
		//Checking the expected value with the actual result
		//Requires the third double value as margin of error
		assertEquals(expPeriodicBlended, actualPeriodicBlended, 0.00001);
		assertEquals(expTotalInterest, actualTotalInterest, 0.00001);
		assertEquals(expTotalWithPrincipal, actualTotalWithPrincipal, 0.00001);
		assertEquals(expInterestPrincipalRatio, actualInterestPrincipalRatio, 0.00001);
		assertEquals(expAvgInterestPerYear, actualAvgInterestPerYear, 0.00001);
		assertEquals(expAvgInterestPerMonth, actualAvgInterestPerMonth, 0.00001);
		assertEquals(expAmortizationYears, actualAmortizationYears, 0.00001);
	}
	
	

}
