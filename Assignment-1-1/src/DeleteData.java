import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DeleteData {

	DeleteData() {
		deleteGui();
	}

	private void deleteGui() {
		JFrame f = new JFrame();
		f.setTitle("Delete");
		f.setSize(700, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel flowPanel = new JPanel(new FlowLayout());

		TextField bookId = new TextField("bookId");
		
		Label titleLabel = new Label("Enter id to delete Data");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
		Button submit = new Button("Delete");
		Button back = new Button("back");

		flowPanel.add(titleLabel);
		flowPanel.add(bookId);
		flowPanel.add(submit);
		flowPanel.add(back);

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(bookId.getText());
				JDBCDelete delete = new JDBCDelete(id);
			}
		});

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Main m = new Main();
			}
		});

		f.add(flowPanel, BorderLayout.NORTH);
		f.setVisible(true);
	}
}
