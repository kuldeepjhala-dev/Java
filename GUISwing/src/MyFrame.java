import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	MyFrame(){
		JButton button = new JButton();
		button.setBounds(200,100,100,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(420,420); 
		this.setLayout(null);
		this.add(button);
		this.setVisible(true);	
	}
}
