
//  Created by Ozan Bağıran
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class searchGUI extends JFrame {	
	
	
	private JLabel accountL, sDateL, eDateL;
	private JTextField accountTf, sDateTf, eDateTf;
	private JButton showB;
	
	public searchGUI() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		setTitle("asas ");
        setSize(250, 220);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		accountL = new JLabel("Account: ");
		accountTf = new JTextField(20);
		
		sDateL = new JLabel("Start Date:");
		sDateTf = new JTextField("YYYY-MM-DD",20);
		
		eDateL = new JLabel("End Date:");
		eDateTf = new JTextField("YYYY-MM-DD",20);
		
		showB = new JButton("Show");
		
		c.add(accountL);
		c.add(accountTf);
		
		c.add(sDateL);
		c.add(sDateTf);
		
		c.add(eDateL);
		c.add(eDateTf);
		
		c.add(showB);
		
		MyEventHandler meh = new MyEventHandler();
		showB.addActionListener(meh);
		
		
	}
	
	public class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String component = "";
			if (e.getSource() == showB) {
				if (!isValidDateFormat(sDateTf.getText()) || !isValidDateFormat(eDateTf.getText())) {
	                JOptionPane.showMessageDialog(searchGUI.this, "Invalid date format. Please use YYYY-MM-DD");
	                return; // Exit the method if date format is invalid
	            }
				component= "(from%3A"+accountTf.getText()+")%20until%3A"+eDateTf.getText()+"%20since%3A"+sDateTf.getText();
				
				component = "https://twitter.com/search?q="+ component+"&src=typed_query&f=top";
			OpenURLInBrowser.openURL(component);	
				
						
			}
		}
		
		private boolean isValidDateFormat(String date) {
	        // Simple validation for YY-MM-DD format
	        return date.matches("\\d{4}-\\d{2}-\\d{2}");
	    }
	}	 
		
	
	public static void main(String[] argrs) {
		searchGUI gui = new searchGUI();
		gui.setVisible(true);
		
	}
}
