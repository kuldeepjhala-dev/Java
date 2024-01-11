import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	MyFrame(){
		this.setTitle("Twitter"); //sets title of this
		this.setResizable(false); //prevent this from being resized
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
		this.setSize(420,420); //set the x-dimension and y-dimension of the this
		this.setVisible(true); //Make the this visible
		ImageIcon image = new ImageIcon("twitter.png"); //create an image icon
		this.setIconImage(image.getImage()); //change icon of this
		this.getContentPane().setBackground(new Color(29, 161, 242));
	}
	
}
