import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;

public class CharacterListUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	ArrayList<String> characters = new ArrayList<String>();
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SqliteDB db = new SqliteDB();
					CharacterListUI window = new CharacterListUI();
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
	public CharacterListUI(SqliteDB db) 
	{
		initialize(db);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SqliteDB db) {
		
		//repeated from TableFromDatabase, can we avoid this?
		Vector<Object> data = new Vector<Object>();
		
		try {
		//ResultSet rs = db.returnResultSet("characters");
		
	//	ResultSetMetaData md = rs.getMetaData();
		//int columns = md.getColumnCount();
		
		//trying to return characternames from DB
		characters = db.ReturnColumn("name", "characters");
	
		
		}catch(Exception e)
		{
			System.out.println("DB Error in CharacterListUI: " + e.getMessage());
		}
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCharacters = new JLabel("Characters");
		lblCharacters.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCharacters.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharacters.setBounds(163, 0, 96, 20);
		frame.getContentPane().add(lblCharacters);
		
		

		JList<String> list = new JList<String>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.addListSelectionListener(new ListSelectionListener()
		{	
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				if (e.getValueIsAdjusting()) 
				{
					return;
				}else
				{
					String value = (String) list.getSelectedValue();
					new CharacterSheetUI2(db, value);
				}
			}
				
		});
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		for(int i = 0; i < characters.size(); i++)
		{
			dlm.addElement(characters.get(i));
		}
		
		//dlm.addElement("One");
		//dlm.addElement("Two");
		//dlm.addElement("Three");
		list.setModel(dlm);
		
		list.setBounds(15, 36, 398, 192);
		frame.getContentPane().add(list);
		
		JButton btnCreateNew = new JButton("Create New");
		btnCreateNew.setBounds(15, 274, 181, 42);
		btnCreateNew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				new CharacterCreationUI2(db);
			}
			
		});
		frame.getContentPane().add(btnCreateNew);
		
		JButton btnGoBack = new JButton("Close");
		btnGoBack.setBounds(232, 274, 181, 42);
		btnGoBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				//new LandingPageUI();	
				frame.setVisible(false);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnGoBack);
		
		frame.setVisible(true);
		
	/*	JButton btnLoadList = new JButton("Load List");
		btnLoadList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				DefaultListModel<String> dlm = new DefaultListModel<String>();
				dlm.addElement("One");
				dlm.addElement("Two");
				dlm.addElement("Three");
				list.setModel(dlm);
				
			}
		});
		
		btnLoadList.setBounds(15, 57, 115, 29);
		frame.getContentPane().add(btnLoadList);*/
		
		
		
	}
}
