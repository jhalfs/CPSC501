

public class MortgageCalc{
	/**
	 * Creating instances of the model and view classes for the controller to use 
	 */
	private MortgageGUI view;
	private Mortgage mortgage;
	
	/**
	 * This constructor creates the instances of the model and view and also creates and event listener
	 * @param view This parameter is necessary to set the view
	 * @param mortgage This parameter is necessary to set the model
	 */
	public MortgageCalc(MortgageGUI view, Mortgage mortgage){
		this.view=view;
		this.mortgage=mortgage;
		EventHandler listener=new EventHandler(this);
		view.setEventListener(listener);
	}
	
	/**
	 * This method is called when an the calculate button is clicked. 
	 * It first gets the values entered into the first three text fields, then calculates and displays 
	 * all the desired values 
	 */
	public void buttonAction(){
		int amortization=view.getAmortization();
		int principal=view.getPrincipal();
		double interestRate=view.getInterestRate();
		
		mortgage.calculatePeriodicBlendedPayment(amortization, principal, interestRate);
		mortgage.calculateTotalInterest(amortization, interestRate);
		mortgage.calculateTotalWithPrincipal(principal);
		mortgage.calculateIpRatio(principal, interestRate);
		mortgage.calculateaAvgInterestPerYear(interestRate, amortization, principal);
		mortgage.calculateAvgInterestPerMonth();
		mortgage.calculateAmortizationYears(amortization);
		
		view.setPeriodicBlendedPayment(mortgage.getPeriodicBlendedPayment());
		view.setTotalInterest(mortgage.getTotalInterest());
		view.setTotalWithPrincipal(mortgage.getTotalWithPrincipal());
		view.setIpRatio(mortgage.getIpRatio());
		view.setAvgInterestPerYear(mortgage.getAvgInterestPerYear());
		view.setAvgInterestPerMonth(mortgage.getAvgInterestPerMonth());
		view.setAmortizationYears(mortgage.getAmortizationYears());
		
		
		
	}

}
