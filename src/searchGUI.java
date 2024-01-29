
//  Created by Ozan Bağıran
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
public class searchGUI extends JFrame {	
	
	
	private JLabel accountL, sDateL, eDateL, wordL, langL;
	private JTextField accountTf, sDateTf, eDateTf, wordTf, langTf;
	private JButton showB;
	
	public searchGUI()  {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		setTitle("Tweet Searcher");
        setSize(250, 320);
        setResizable(false);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		accountL = new JLabel("Account: ");
		accountTf = new JTextField(20);
		
		wordL = new JLabel("Word: ");
		wordTf = new JTextField(20);
		
		sDateL = new JLabel("Start Date:");
		sDateTf = new JTextField("YYYY-MM-DD",20);
		
		eDateL = new JLabel("End Date:");
		eDateTf = new JTextField("YYYY-MM-DD",20);
		
		langL = new JLabel("Lang Code: ");
		langTf = new JTextField(16);
		
		
		
 
		showB = new JButton("Show");
		
		c.add(accountL);
		c.add(accountTf);
		
		c.add(wordL);
		c.add(wordTf);
		
		
		c.add(sDateL);
		c.add(sDateTf);
		
		c.add(eDateL);
		c.add(eDateTf);
		
		c.add(langL);
		c.add(langTf);
		
		
		 String photoPath = "info.png";
	        try {
	            BufferedImage img = ImageIO.read(new File(photoPath));
	            ImageIcon icon = new ImageIcon(img.getScaledInstance(20, 20, Image.SCALE_SMOOTH));

	            JLabel label = new JLabel(icon);

	            label.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                    JOptionPane.showMessageDialog(label, ""
	                    		+ "English: en\n"
	                    		+ "Turkish: tr\n"
	                    		+ "German: de\n...\n"
	                    		+ "Not Required to fill");
	                }
	            });
	            c.add(label);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
		
		c.add(showB);
		
		MyEventHandler meh = new MyEventHandler();
		showB.addActionListener(meh);
		
		
		
		
		
	}
	
	public class MyEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String component = "";
			if (e.getSource() == showB){
				if (!isValidDateFormat(sDateTf.getText()) || !isValidDateFormat(eDateTf.getText())) {
	                JOptionPane.showMessageDialog(searchGUI.this, "Invalid date format. Please use YYYY-MM-DD");
	                return; // Exit the method if date format is invalid
	            }
				if(!langTf.getText().isEmpty())
					component= "(from%3A"+accountTf.getText()+")%20until%3A"+eDateTf.getText()+"%20since%3A"+sDateTf.getText()+"%20"+wordTf.getText()+"%20lang%3A"+langTf.getText();
				else
					component= "(from%3A"+accountTf.getText()+")%20until%3A"+eDateTf.getText()+"%20since%3A"+sDateTf.getText()+"%20"+wordTf.getText();
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
