

public class Driver {
	/**
	 * This is the main class, it simply creates the model, view, and controller.
	 * @param args 
	 */
	public static void main(String[] args){
		MortgageGUI view=new MortgageGUI();
		Mortgage mortgage=new Mortgage();
		MortgageCalc myController=new MortgageCalc(view, mortgage);
	}

}
