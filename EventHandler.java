

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class EventHandler implements ActionListener{
	/**
	 * This variable creates a controller 
	 */
	private MortgageCalc myController;
	
	/**
	 * This method creates an instance of the controller class
	 * @param myController The controller is used to create an instance
	 */
	public EventHandler(MortgageCalc myController)
	{
		this.myController=myController;
	}
	/**
	 * This method is called when the button is clicked and tells the controller to set the new text values
	 */
	public void actionPerformed(ActionEvent e) {
		myController.buttonAction();
		
	}

}

