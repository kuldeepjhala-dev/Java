import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setTitle("BookStore");
		f.setSize(700, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel Panel = new JPanel();
		Panel.setLayout(null);

		JButton insertButton = new JButton("Insert");
		insertButton.setBounds(50, 50, 100, 30);

		JButton updateButton = new JButton("Update");
		updateButton.setBounds(200, 50, 100, 30);

		JButton showButton = new JButton("Show");
		showButton.setBounds(350, 50, 100, 30);

		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(500, 50, 100, 30);

		Label titleLabel = new Label("BookClass");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

		Panel.add(titleLabel);
		Panel.add(insertButton);
		Panel.add(updateButton);
		Panel.add(showButton);
		Panel.add(deleteButton);
		
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("insert clicked!");
				InsertData i1 = new InsertData();
			}
		});

		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("update clicked!");
				UpdateData i1 = new UpdateData();
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("delete clicked!");
				DeleteData i1 = new DeleteData();
			}
		});

		showButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("show clicked!");
				ShowData i1 = new ShowData();
			}
		});

		f.add(Panel);
		f.setVisible(true);
		
	}

}
