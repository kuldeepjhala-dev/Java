import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {

	public static void main(String[] args) {
		
//		MyFrame myFrame = new MyFrame();
		ImageIcon image = new ImageIcon("hacker.png");
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY,5); //sets border to label.
		JLabel label = new JLabel();//create a label
		label.setText("F### Society"); //set text of label
		label.setIcon(image); //Set image to label
		label.setHorizontalTextPosition(JLabel.CENTER);//sets text LEFT, RIGHT, CENTER of ImageIcon.
		label.setVerticalTextPosition(JLabel.TOP); //sets text TOP,BOTTOM, CENTER of the ImageIcon.
		label.setForeground(Color.gray); //change the font color
		label.setFont(new Font("MV Boli", Font.PLAIN, 20)); //Change font style
		label.setIconTextGap(10); //set gap of text to image
		label.setBackground(Color.BLACK); //set background color
		label.setOpaque(true);  //display background color
		label.setBorder(border); //display border to label
		label.setVerticalAlignment(JLabel.CENTER); //set Vertical position of icon + text within label
		label.setHorizontalAlignment(JLabel.CENTER);//set Horizontal position of icon + text within label
//		label.setBounds(100, 100, 250, 250); //defines size and coordinates of label within frame (int x, int y, int width, int height)
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//		frame.setSize(500,500);
//		frame.setLayout(null); // by default it is border layout but now it is null
		frame.setVisible(true);
		frame.add(label); //Add label to frame
		frame.pack(); //This will resize the frame to accomadate size of components. Add all the components before adding pack method
	}
}
