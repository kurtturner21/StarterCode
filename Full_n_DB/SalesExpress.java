import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/* 
Example on how to run with a jar file in your class path
>javac SalesExpress.java
>java -classpath ".;sqlite-jdbc-3.20.0.jar" SalesExpress
*/


public class SalesExpress{
	SalesDB SDB = new SalesDB();						// Creates DB Object
	SalesGUI SGUID = new SalesGUI();					// Make GUI Object
	ButtonListener listener = new ButtonListener();		// Create BUTT Listener Object
	int currentCustomer = 0;
	ArrayList<Integer> CustomerIds = new ArrayList<Integer>();
	
	
	public static void main(String args[]) {
		new SalesExpress();
	}
	
	
	// This is the method that will be called by main
	public SalesExpress(){
		// connect to db
		SDB.connectDB();
		SDB.createTables();
		
		// make gui
		SGUID.ConstructGUI();
		SGUID.customerCount.setText(currentCustomer + "");
		
		// Listeners
		SGUID.editBut.addActionListener(listener);
		SGUID.addBut.addActionListener(listener);
		SGUID.deleteBut.addActionListener(listener);
		
		// Load some data from DB.
		currentCustomer = SDB.getCustomerCount();
		CustomerIds = SDB.getCustomerIds();
		popCustomerData(CustomerIds.get(0));
		// popCustomerData(1);
	}
	
	
	// let's get the clicks.
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == SGUID.editBut) {
				SGUID.statusBar.setText("edit");
			} else if (e.getSource() == SGUID.addBut) {
				SGUID.statusBar.setText("add");
			} else if (e.getSource() == SGUID.deleteBut) {
				SGUID.statusBar.setText("delete");
			}
		}
	}
	
	
	// this populates the customer fiels on the GUI with a given customer id
	private void popCustomerData(int neededCustomerId){
		String[] CustomerData = SDB.getCustomerRecord(neededCustomerId);
		SGUID.customerName.setText(CustomerData[0]);
		SGUID.customerAddress.setText(CustomerData[1]);
		SGUID.customerCity.setText(CustomerData[2]);
		// SGUID.customerState.setText(CustomerData[3]);
		SGUID.customerZip.setText(CustomerData[4]);
		//  SGUID.customerPhone.setText(CustomerData[0]);
	}

}