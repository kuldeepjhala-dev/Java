//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.Label;
//import java.awt.TextField;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class UpdateData {
//
//	UpdateData() {
//		updateGui();
//	}
//
//	private void updateGui() {
//		JFrame f = new JFrame();
//		f.setTitle("Update");
//		f.setSize(700, 600);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//
//		Label titleLabel = new Label("Enter id to update Data");
//		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
//
//		Label titleLabel2 = new Label("update the Data");
//		titleLabel2.setFont(new Font("Arial", Font.BOLD, 16));
//
//		TextField updateBookId = new TextField("Enter id");
//		TextField bookId = new TextField("bookId");
//		TextField bookName = new TextField("bookName");
//		TextField authorName = new TextField("authorName");
//		TextField publication = new TextField("publication");
//		TextField dateOfPublication = new TextField("dateOfPublication");
//		TextField bookPrice = new TextField("bookPrice");
//		TextField totalQuantity = new TextField("totalQuantity");
//		TextField totalCost = new TextField("totalCost");
//		Button submit = new Button("Submit");
//		Button back = new Button("back");
//
//		flowPanel.add(titleLabel);
//		flowPanel.add(updateBookId);
//		flowPanel.add(titleLabel2);
//		flowPanel.add(bookId);
//		flowPanel.add(bookName);
//		flowPanel.add(authorName);
//		flowPanel.add(publication);
//		flowPanel.add(dateOfPublication);
//		flowPanel.add(bookPrice);
//		flowPanel.add(totalQuantity);
//		flowPanel.add(totalCost);
//		flowPanel.add(submit);
//		flowPanel.add(back);
//
//		submit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int id = Integer.parseInt(bookId.getText());
//				String name = bookName.getText();
//				String author = authorName.getText();
//				String pub = publication.getText();
//				String dop = dateOfPublication.getText();
//				int price = Integer.parseInt(bookPrice.getText());
//				int quantity = Integer.parseInt(totalQuantity.getText());
//				int cost = Integer.parseInt(totalCost.getText());
//				System.out.println(id + name + author + pub + dop + price + quantity + cost);
//			}
//		});
//
//		back.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				f.dispose();
//				Main m = new Main();
//			}
//		});
//
//		f.add(flowPanel);
//		f.setVisible(true);
//
//	}
//
//}

import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UpdateData {

	UpdateData() {
		updateGui();
	}

	private void updateGui() {
		JFrame f = new JFrame();
		f.setTitle("Update");
		f.setSize(700, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a JPanel with a GridLayout for vertical arrangement
		JPanel mainPanel = new JPanel(new GridLayout(0, 1));

		// Panel for the "Enter id to update Data" section
		JPanel updatePanel = new JPanel();
		updatePanel.add(new Label("Enter id to update Data"));
		TextField updateBookId = new TextField();
		updatePanel.add(updateBookId);
		mainPanel.add(updatePanel);

		// Panel for the "update the Data" section
		JPanel dataPanel = new JPanel(new GridLayout(0, 2));

		dataPanel.add(new Label("bookId"));
		TextField bookId = new TextField();
		dataPanel.add(bookId);

		dataPanel.add(new Label("bookName"));
		TextField bookName = new TextField();
		dataPanel.add(bookName);

		dataPanel.add(new Label("authorName"));
		TextField authorName = new TextField();
		dataPanel.add(authorName);

		dataPanel.add(new Label("publication"));
		TextField publication = new TextField();
		dataPanel.add(publication);

		dataPanel.add(new Label("dateOfPublication"));
		TextField dateOfPublication = new TextField();
		dataPanel.add(dateOfPublication);

		dataPanel.add(new Label("bookPrice"));
		TextField bookPrice = new TextField();
		dataPanel.add(bookPrice);

		dataPanel.add(new Label("totalQuantity"));
		TextField totalQuantity = new TextField();
		dataPanel.add(totalQuantity);

		dataPanel.add(new Label("totalCost"));
		TextField totalCost = new TextField();
		dataPanel.add(totalCost);

		mainPanel.add(dataPanel);

		// Panel for buttons
		JPanel buttonPanel = new JPanel();
		Button submit = new Button("Update");
		Button back = new Button("Back");
		buttonPanel.add(submit);
		buttonPanel.add(back);
		mainPanel.add(buttonPanel);

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int updateId = Integer.parseInt(updateBookId.getText());
				int id = Integer.parseInt(bookId.getText());
				String name = bookName.getText();
				String author = authorName.getText();
				String pub = publication.getText();
				String dop = dateOfPublication.getText();
				int price = Integer.parseInt(bookPrice.getText());
				int quantity = Integer.parseInt(totalQuantity.getText());
				int cost = Integer.parseInt(totalCost.getText());
				JDBCUpdate update = new JDBCUpdate(updateId, id, name, author, pub, dop, price, quantity, cost);
			}
		});

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Main m = new Main();
			}
		});

		f.add(mainPanel);
		f.setVisible(true);
	}

}
