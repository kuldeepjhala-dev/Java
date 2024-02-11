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
//public class InsertData {
//
//	InsertData() {
//		insertGui();
//	}
//
//	private void insertGui() {
//		JFrame f = new JFrame();
//		f.setTitle("Insert");
//		f.setSize(700, 600);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		JPanel flowPanel = new JPanel(new FlowLayout());
//		
//		Label titleLabel = new Label("Insert Data");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
//
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
//		f.add(flowPanel, BorderLayout.NORTH);
//		f.setVisible(true);
//
//	}
//
//}

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertData {

	InsertData() {
		insertGui();
	}

	private void insertGui() {
		JFrame f = new JFrame();
		f.setTitle("Insert");
		f.setSize(700, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a JPanel with a GridLayout for vertical arrangement
		JPanel gridPanel = new JPanel(new GridLayout(0, 1));

		// Add labels and text fields
		JLabel titleLabel = new JLabel("Insert Data");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel bookIdLabel = new JLabel("Book ID:");
		JTextField bookId = new JTextField();

		JLabel bookNameLabel = new JLabel("Book Name:");
		JTextField bookName = new JTextField();

		JLabel authorNameLabel = new JLabel("Author Name:");
		JTextField authorName = new JTextField();

		JLabel publicationLabel = new JLabel("Publication:");
		JTextField publication = new JTextField();

		JLabel dateOfPublicationLabel = new JLabel("Date of Publication:");
		JTextField dateOfPublication = new JTextField();

		JLabel bookPriceLabel = new JLabel("Book Price:");
		JTextField bookPrice = new JTextField();

		JLabel totalQuantityLabel = new JLabel("Total Quantity:");
		JTextField totalQuantity = new JTextField();

		JLabel totalCostLabel = new JLabel("Total Cost:");
		JTextField totalCost = new JTextField();

		Button submit = new Button("Submit");
		Button back = new Button("Back");

		// Add components to the gridPanel
		gridPanel.add(titleLabel);
		gridPanel.add(bookIdLabel);
		gridPanel.add(bookId);
		gridPanel.add(bookNameLabel);
		gridPanel.add(bookName);
		gridPanel.add(authorNameLabel);
		gridPanel.add(authorName);
		gridPanel.add(publicationLabel);
		gridPanel.add(publication);
		gridPanel.add(dateOfPublicationLabel);
		gridPanel.add(dateOfPublication);
		gridPanel.add(bookPriceLabel);
		gridPanel.add(bookPrice);
		gridPanel.add(totalQuantityLabel);
		gridPanel.add(totalQuantity);
		gridPanel.add(totalCostLabel);
		gridPanel.add(totalCost);
		gridPanel.add(submit);
		gridPanel.add(back);

		f.add(gridPanel, BorderLayout.CENTER);

		submit.addActionListener(e -> {
			int id = Integer.parseInt(bookId.getText());
			String name = bookName.getText();
			String author = authorName.getText();
			String pub = publication.getText();
			String dop = dateOfPublication.getText();
			int price = Integer.parseInt(bookPrice.getText());
			int quantity = Integer.parseInt(totalQuantity.getText());
			int cost = Integer.parseInt(totalCost.getText());
			JDBCInsert sendDataToDatabase = new JDBCInsert(id, name, author, pub, dop, price, quantity, cost);
			FileInsert sendDataToFile = new FileInsert(id, name, author, pub, dop, price, quantity, cost);
		});

		back.addActionListener(e -> {
			f.dispose();
			Main m = new Main();
		});

		f.setVisible(true);
	}
}
