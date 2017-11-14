import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 
Example on how to run with a jar file in your class path
>javac SalesExpress.java
>java -classpath ".;sqlite-jdbc-3.20.0.jar" SalesExpress
*/


public class SalesExpress extends JFrame{
	
	// States
	String arrStates[] = { "FL", "NC", "SC", "GA", "AL", "KY", "VA" };
	
	// Creates DB object
	SalesDB SDB = new SalesDB();
	
	// Form objects
	JLabel customerBanner = new JLabel();
	JLabel salesBanner = new JLabel();
	JLabel customerCount = new JLabel();
	JLabel salesCount = new JLabel();
	JLabel statusBar = new JLabel();
	
	JLabel customerID = new JLabel();
	JTextField customerName = new JTextField(50);
	JTextField customerAddress = new JTextField(50);
	JTextField customerCity = new JTextField(50);
	JComboBox<String> customerState = new JComboBox<String>(arrStates);
	JTextField customerZip = new JTextField(15);
		
	// so simple
	public static void main(String args[]) {
		new SalesExpress();
	}	
	

	
	// override constructor
	public SalesExpress(){
				
		// Connect to DB and create tables
		SDB.connectDB();
		SDB.createTables();
		
		// creates form
		JFrame f = new JFrame("Sales Express");
		f.setSize(700,350);
		f.setLayout(null);
		f.setResizable(false);
		//f.setLocationRelativeTo(null); 
		f.setLocation(1200, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);  
		
		// post the labels to the jframe
		// https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
		Color ltblue = new Color(191, 215, 252);
		
		customerBanner.setBounds(10, 5, 335, 40);
		customerBanner.setOpaque(true);
		customerBanner.setForeground(Color.BLACK);
		customerBanner.setBackground(ltblue);
		customerBanner.setHorizontalAlignment(JLabel.CENTER);
		customerBanner.setVerticalAlignment(JLabel.CENTER);
		customerBanner.setFont(new Font("Serif", Font.PLAIN, 16));
		customerBanner.setText("CUSTOMERS");
		f.add(customerBanner);
		
		salesBanner.setBounds(355, 5, 335, 40);
		salesBanner.setOpaque(true);
		salesBanner.setForeground(Color.BLACK);
		salesBanner.setBackground(ltblue);
		salesBanner.setHorizontalAlignment(JLabel.CENTER);
		salesBanner.setVerticalAlignment(JLabel.CENTER);
		salesBanner.setFont(new Font("Serif", Font.PLAIN, 16));
		salesBanner.setText("SALES TO CUSTOMER");
		f.add(salesBanner);
		
		customerCount.setBounds(167, 250, 40, 20);
		customerCount.setForeground(Color.black);
		customerCount.setText("(1 OF 123)");
		customerCount.setFont(new Font("Serif", Font.PLAIN, 12));
		f.add(customerCount);
		
		salesCount.setBounds(522, 250, 40, 20);
		salesCount.setForeground(Color.black);
		salesCount.setText("$1000 w/ 5 orders");
		salesCount.setFont(new Font("Serif", Font.PLAIN, 12));
		f.add(salesCount);
		
		statusBar.setBounds(10, 295, 680, 20);
		statusBar.setOpaque(true);
		statusBar.setForeground(Color.black);
		statusBar.setBackground(Color.orange);
		statusBar.setFont(new Font("Serif", Font.PLAIN, 8));
		statusBar.setText("Application Bar");
		f.add(statusBar);
		
		customerID.setText("1cvxcZXcZvzxc");
		customerID.setFont(new Font("Serif", Font.PLAIN, 12));
		customerID.setBounds(10, 200, 40, 40);
		f.add(customerID);
		
		customerName.setText("Mr. Kurt Turner");
		customerName.setBackground(Color.white);
		customerName.setEditable(false);
		// customerName.setEnabled(false);
		customerName.setBorder(BorderFactory.createCompoundBorder(customerName.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerName.setFont(new Font("Serif", Font.PLAIN, 16));
		customerName.setBounds(10, 50, 335, 40);
		f.add(customerName);
		
		customerAddress.setText("1120 Ocoee Street");
		customerAddress.setBackground(Color.white);
		customerAddress.setEditable(false);
		//customerAddress.setEnabled(false);
		customerAddress.setBorder(BorderFactory.createCompoundBorder(customerAddress.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerAddress.setFont(new Font("Serif", Font.PLAIN, 16));
		customerAddress.setBounds(10, 95, 335, 40);
		f.add(customerAddress);
		
		customerCity.setText("Cleveland");
		customerCity.setBackground(Color.white);
		customerCity.setEditable(false);
		//customerCity.setEnabled(false);
		customerCity.setBorder(BorderFactory.createCompoundBorder(customerCity.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerCity.setFont(new Font("Serif", Font.PLAIN, 16));
		customerCity.setBounds(10, 140, 180, 40);
		f.add(customerCity);
		
		customerState.setFont(new Font("Serif", Font.PLAIN, 16));
		customerState.setBackground(Color.white);
		customerState.setEditable(false);
		// customerState.setEnabled(false);
		// customerState.setBorder(BorderFactory.createCompoundBorder(customerState.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerState.setBounds(198, 140, 56, 40);
		f.add(customerState);
		
		customerZip.setText("37320");
		customerZip.setBackground(Color.white);
		customerZip.setEditable(false);
		//customerZip.setEnabled(false);
		customerZip.setBorder(BorderFactory.createCompoundBorder(customerZip.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerZip.setFont(new Font("Serif", Font.PLAIN, 16));
		customerZip.setBounds(260, 140, 85, 40);
		f.add(customerZip);
		
		
		
		
	}


}