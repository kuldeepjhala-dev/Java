import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowData {

	ShowData() {
		showGui();
	}

	private void showGui() {
		JFrame f = new JFrame();
		f.setTitle("Show");
		f.setSize(700, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String query;
		ResultSet rs;
		ResultSetMetaData rsmd;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("Driver Activated");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?characterEncoding=latin1&useConfigs=maxPerformance","root","");
			System.out.println("Connection Established");
			Statement st = con.createStatement();
			query = "select id, name, author, pub, dop, price, quantity, cost from bookstore";
            rs = st.executeQuery(query);	
            rsmd = rs.getMetaData();
            
            String[] columnNames = { "Book Id", "Book Name", "Author Name", "Publication", "Date", "Price",
    				"Total Quantity", "Total Cost" };
    		
    		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    		
    		while(rs.next())
    		{
    		    String id = rs.getString("id");
    		    String name = rs.getString("name");
    		    String author = rs.getString("author");
    		    String pub  = rs.getString("pub");
    		    String dop = rs.getString("dop");
    		    String price = rs.getString("price");
    		    String quantity = rs.getString("quantity");
    		    String cost = rs.getString("cost");
    		    model.addRow(new Object[]{id, name, author, pub, dop, price, quantity, cost});
    		}
    		
    		JTable table = new JTable(model);
    		
    		JScrollPane scrollPane = new JScrollPane(table);
    		
    		JButton back = new JButton("Back");

    		JPanel p = new JPanel();
    		
    		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
    		
    		p.add(scrollPane);
    		
    		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    		
    		buttonPanel.add(back);
    		
    		p.add(buttonPanel);
    		
    		back.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				f.dispose();
    				
    				Main m = new Main();
    				
    			}
    		});
    		
    		f.getContentPane().add(p);
    		
    		f.setVisible(true);
		}	
		catch(Exception e)
		{
			System.out.println("ShowData.java => " + e.getMessage());
		}
	}
}
