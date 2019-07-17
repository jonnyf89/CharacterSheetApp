import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ItemTableUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SqliteDB db = new SqliteDB();
					ItemTableUI window = new ItemTableUI(db, "weapons");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ItemTableUI(SqliteDB db, String tableName) 
	{
		initialize(db, tableName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SqliteDB db, String tableName) {

		frame = new JFrame();
		frame.setBounds(100, 100, 901, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBounds(0, 0, 879, 25);
		frame.getContentPane().add(panelHeader);
		
		JLabel lblItems = new JLabel("Items");
		panelHeader.add(lblItems);
		lblItems.setText(tableName);
		lblItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblItems.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panelFooter = new JPanel();
		panelFooter.setBounds(0, 520, 879, 70);
		frame.getContentPane().add(panelFooter);
		panelFooter.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(404, 16, 71, 29);
		btnClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				frame.dispose();
			}
		});
		panelFooter.add(btnClose);
		
		TableFromDatabase panelMid = new TableFromDatabase(db, "weapons");
		panelMid.setBounds(0, 27, 879, 477);
		frame.getContentPane().add(panelMid);
		//frame.pack();
		frame.setVisible(true);
		

		
	}
}
