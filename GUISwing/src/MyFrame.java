import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame  {
	
	JButton button;
	
	MyFrame(){
		button = new JButton();
		button.setBounds(200,100,100,50);
//		button.addActionListener(this);
		button.addActionListener(e -> System.out.println("kj"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(420,420); 
		this.setLayout(null);
		this.add(button); //used to add button on frame
		this.setVisible(true);	
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e)
//	{
//		if(e.getSource()==button) {
//			System.out.println("poo");
//		}
//	}
}
