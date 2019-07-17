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
import javax.swing.JScrollPane;

public class ItemListUI {

	private JFrame frame;
	private JScrollPane scrollPaneWeapons;
	private JScrollPane scrollPaneApparel;
	private JScrollPane scrollPaneOther;

	/**
	 * Launch the application.
	 */
	private ArrayList<String> items = new ArrayList<String>();
	private ArrayList<String> weapons = new ArrayList<String>();
	private ArrayList<String> apparel = new ArrayList<String>();
	private ArrayList<String> others = new ArrayList<String>();
	
	private String selectedWeapon;
	private String selectedApparel;
	private String selectedOther;
	
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
	public ItemListUI(SqliteDB db) {
		initialize(db);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SqliteDB db) {
		
		//repeated from TableFromDatabase, can we avoid this?
		Vector<Object> data = new Vector<Object>();
		
		try {
		///ResultSet rs = db.returnResultSet("items");
		
		//ResultSetMetaData md = rs.getMetaData();
		//int columns = md.getColumnCount();
		
		//trying to return itemnames from DB
		items = db.ReturnColumn("name", "items");
		
		//This is why my weapons arnt going to the weapons table
		//weapons = db.ReturnColumn("name", "items", "type", "weapon");
		apparel = db.ReturnColumn("name", "items", "type", "apparel");
		others = db.ReturnColumn("name", "items", "type", "other");
		
		weapons = db.ReturnColumn("name", "weapons");
		
		
		}catch(Exception e)
		{
			System.out.println("DB Error in ItemListUI: " + e.getMessage());
		}
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 902);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblItems.setBounds(195, 0, 57, 20);
		frame.getContentPane().add(lblItems);
		
		DefaultListModel<String> weaponsListModel = getListModel(weapons);
		DefaultListModel<String> apparelListModel = getListModel(apparel);
		DefaultListModel<String> othersListModel = getListModel(others);
		
		
		
		
		//Weapons List
		JLabel lblWeapons = new JLabel("Weapons");
		lblWeapons.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeapons.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeapons.setBounds(187, 28, 69, 20);
		frame.getContentPane().add(lblWeapons);
		
		scrollPaneWeapons = new JScrollPane();
		scrollPaneWeapons.setBounds(15, 54, 439, 154);
		frame.getContentPane().add(scrollPaneWeapons);
		
		JList<String> listWeapons = new JList<String>();
		scrollPaneWeapons.setViewportView(listWeapons);
		listWeapons.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listWeapons.addListSelectionListener(new ListSelectionListener()
		{	
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				if (e.getValueIsAdjusting()) 
				{
					return;
				}else
				{
					selectedWeapon = (String) listWeapons.getSelectedValue();
					//new ApparelDetailsUI(db, value);
					WeaponCreationUI weaponScreen = new WeaponCreationUI(db);
					weaponScreen.Populate(db, selectedWeapon);
					weaponScreen.lockFields();
				}
			}
				
		});
		listWeapons.setModel(weaponsListModel);
		listWeapons.setBounds(15, 54, 398, 192);
		
		JButton btnDetailsWeapon = new JButton("Details");
		btnDetailsWeapon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDetailsWeapon.setBounds(15, 216, 138, 29);
		btnDetailsWeapon.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				selectedWeapon = (String) listWeapons.getSelectedValue();
				if(selectedWeapon == "") 
				{
					return;
				}else 
				{
					//new ApparelDetailsUI(db, value);
					selectedWeapon = (String) listWeapons.getSelectedValue();
					//new ApparelDetailsUI(db, value);
					WeaponCreationUI weaponScreen = new WeaponCreationUI(db);
					weaponScreen.Populate(db, selectedWeapon);
					weaponScreen.lockFields();
				}
			}
		});
		frame.getContentPane().add(btnDetailsWeapon);
		
		
		//Apparel List
		JLabel lblApparel = new JLabel("Apparel");
		lblApparel.setHorizontalAlignment(SwingConstants.CENTER);
		lblApparel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblApparel.setBounds(187, 270, 69, 20);
		frame.getContentPane().add(lblApparel);
		
		JList<String> listApparel = new JList<String>();
		frame.getContentPane().add(listApparel);
		listApparel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listApparel.addListSelectionListener(new ListSelectionListener()
		{	
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				if (e.getValueIsAdjusting()) 
				{
					return;
				}else
				{
					String value = (String) listWeapons.getSelectedValue();
					new ApparelDetailsUI(db, value);
				}
			}
				
		});
		listApparel.setModel(apparelListModel);
		listApparel.setBounds(17, 306, 437, 154);
		
		scrollPaneApparel = new JScrollPane();
		scrollPaneApparel.setBounds(15, 306, 398, 154);
		frame.getContentPane().add(scrollPaneApparel);
		//frame.getContentPane().add(listApparel);
		
		
		
		//Others List
		JLabel lblOther = new JLabel("Other");
		lblOther.setHorizontalAlignment(SwingConstants.CENTER);
		lblOther.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOther.setBounds(187, 525, 69, 20);
		frame.getContentPane().add(lblOther);
		
		JList<String> listOther = new JList<String>();
		frame.getContentPane().add(listOther);
		listOther.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listOther.addListSelectionListener(new ListSelectionListener()
		{	
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				if (e.getValueIsAdjusting()) 
				{
					return;
				}else
				{
					String value = (String) listWeapons.getSelectedValue();
					new ApparelDetailsUI(db, value);
				}
			}
				
		});
		listOther.setModel(othersListModel);
		listOther.setBounds(17, 561, 437, 154);

		scrollPaneOther = new JScrollPane();
		scrollPaneOther.setBounds(15, 561, 398, 154);
		frame.getContentPane().add(scrollPaneOther);
		
		JButton btnCreateNewWeapon = new JButton("Create New Weapon");
		btnCreateNewWeapon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCreateNewWeapon.setBounds(163, 215, 138, 29);
		btnCreateNewWeapon.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				new WeaponCreationUI(db);
			}
		});
		frame.getContentPane().add(btnCreateNewWeapon);
		
		JButton btnGoBack = new JButton("Close");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGoBack.setBounds(247, 783, 189, 47);
		btnGoBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				//new LandingPageUI();	
				frame.setVisible(false);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnGoBack);
		
		JButton btnMaximizeWeapons = new JButton("Maximize");
		btnMaximizeWeapons.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMaximizeWeapons.setBounds(316, 215, 138, 29);
		btnMaximizeWeapons.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new ItemTableUI(db, "weapons");
			}
		});
		frame.getContentPane().add(btnMaximizeWeapons);
		
		JButton btnDetailsApparel = new JButton("Details");
		btnDetailsApparel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDetailsApparel.setBounds(15, 471, 138, 29);
		btnDetailsApparel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				String value = (String) listApparel.getSelectedValue();
				if(value == "") 
				{
					return;
				}else 
				{
					new ApparelDetailsUI(db, value);
				}
			}
		});
		frame.getContentPane().add(btnDetailsApparel);
		
		JButton btnCreateNewApparel = new JButton("Create New Weapon");
		btnCreateNewApparel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCreateNewApparel.setBounds(163, 470, 138, 29);
		frame.getContentPane().add(btnCreateNewApparel);
		
		JButton btnMaximizeWeaponsApparel = new JButton("Maximize");
		btnMaximizeWeaponsApparel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMaximizeWeaponsApparel.setBounds(316, 470, 138, 29);
		frame.getContentPane().add(btnMaximizeWeaponsApparel);
		
		JButton btnDetailsOther = new JButton("Details");
		btnDetailsOther.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDetailsOther.setBounds(15, 724, 138, 29);
		frame.getContentPane().add(btnDetailsOther);
		
		JButton btnCreateNewOther = new JButton("Create New Weapon");
		btnCreateNewOther.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCreateNewOther.setBounds(163, 723, 138, 29);
		frame.getContentPane().add(btnCreateNewOther);
		
		JButton btnMaximizeOther = new JButton("Maximize");
		btnMaximizeOther.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMaximizeOther.setBounds(316, 723, 138, 29);
		frame.getContentPane().add(btnMaximizeOther);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Refresh(db);
			}

		});
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRefresh.setBounds(35, 783, 189, 47);
		frame.getContentPane().add(btnRefresh);
		
		frame.setVisible(true);		
		
		
	}
	
	public DefaultListModel<String> getListModel(ArrayList<String> arrayList)
	{
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		for(int i = 0; i < arrayList.size(); i++)
		{
			dlm.addElement(arrayList.get(i));
		}
		return dlm;
	}
	
	private void Refresh(SqliteDB db) {
		db.closeConnection();
		SqliteDB db2 = new SqliteDB();
		frame.setVisible(false);
		frame.dispose();
		initialize(db2);
	}
}



