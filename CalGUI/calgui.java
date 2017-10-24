import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://www.javatpoint.com/notepad
//http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
//https://stackoverflow.com/questions/20204437/im-trying-to-create-a-numeric-keypad-that-has-a-clear-button-and-a-piece-on-top


public class calgui extends JFrame{
	
	// class attributes
	String numberString = "";
	int but_x_base = 40;
	int but_y_pos = 40;
	int but_width = 60;
	int but_height = 40;
	JTextField txtf = new JTextField();
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton bEq = new JButton("=");

	// override constructor
	public calgui(){
		
		// This defines the JFrame
		JFrame f = new JFrame("Button Example");
		f.setSize(400,400);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// defines objects on the JFrame
		txtf.setBounds(10, 10, 100, 20);
		b1.setBounds(but_x_base + 0,but_y_pos + 80,but_width,but_height);
		b2.setBounds(but_x_base + 60,but_y_pos + 80,but_width,but_height);
		b3.setBounds(but_x_base + 120,but_y_pos + 80,but_width,but_height);
		b4.setBounds(but_x_base + 180,but_y_pos + 80,but_width,but_height);
		bEq.setBounds(but_x_base + 240,but_y_pos + 80,but_width,but_height);
		ButtonListener listener = new ButtonListener();

		// adds listeners to the buttons
		b1.addActionListener(listener);
		b2.addActionListener(listener);

		// adds the objects to the JFrame
		f.add(txtf);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(bEq);
		
		// makes it visible
		f.setVisible(true);  
	}

	public static void main(String args[]) {
		// Creates the JFrame by calling the override constructor
		new calgui();
	}

	// this is a class method that is called each time a button
	// with a listener is pressed
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				numberString += "1";
				txtf.setText(numberString);
			} else if (e.getSource() == b2) {
				numberString += "2";
				txtf.setText(numberString);
			}
		}
	}
}
