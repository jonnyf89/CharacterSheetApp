import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTextField;


import javax.swing.JTextArea;
import javax.swing.JButton;

public class WeaponCreationUI {
	
	private ResultSet rsWeapon;
	private ResultSet rsStatEffects;
	private JLabel lblCreateANew;
	private JLabel lblStr;
	private JLabel lblMaxHp;
	private JLabel lblDex;
	private JLabel lblLuck;
	private JLabel lblIq;
	private JLabel lblPer;
	private JLabel lblCha;
	private JLabel lblWill;
	private JLabel lblAr;
	private JLabel lblMr;
	private JTextField textFieldStr;
	private JTextField textFieldMaxHp;
	private JTextField textFieldDex;
	private JTextField textFieldLuck;
	private JTextField textFieldIq;
	private JTextField textFieldPer;
	private JTextField textFieldCha;
	private JTextField textFieldWill;
	private JTextField textFieldAr;
	private JTextField textFieldMr;
	
	private JButton btnCancel;
	private JButton btnSubmit;
	
	private JComboBox typeComboBox; 
	
	private String[] types = {"Type", "Blunt", "Conduit", "Thrust", "Heavy Blade", "Light Blade", "Ranged"};
	
	private ArrayList<String> characterList;

	private JFrame frame;
	private JTextField textFieldName;
	private JLabel lblFlatDamage;
	private JLabel lblScalingDamage;
	private JTextField textFieldFlatDamage;
	private JTextField textFieldScalingDamage;
	private JLabel lblWeaponArt;
	private JTextField textFieldWeaponArtName;
	private JTextField textFieldWeaponArtDamage;
	private JTextField textFieldTurnUsage;
	private JTextArea textAreaWeaponArtDescription;
	private JTextArea textAreaDescription;
	
	//private String weaponName;
	private String type;
	private int str;
	private int hp;
	private int dex;
	private int luck;
	private int iq;
	private int per;
	private int cha;
	private int will;
	private int ar;
	private int mr;
	private int statEffectId;
	private int itemId;
	
	private String itemName;
	private String flatDmg;
	private String scalingDmg;
	private String turnUsage;
	private String weaponArtName;
	private String weaponArtDmg;
	private String weaponArtDesc;
	private String weaponDesc;
	private String characterName; 
	private String description;
	
	private String strString;
	private String maxHPString;
	private String dexString;
	private String luckString;
	private String iqString;
	private String perString;
	private String chaString;
	private String willString;
	private String arString;
	private String mRString;
	
	
	
	private JLabel lblAddToInventory;
	private JComboBox<String> comboBoxCharacters;
	
	
	

	/**
	 * Create the application.
	 */
	public WeaponCreationUI(SqliteDB db) {
		initialize(db);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SqliteDB db) {
		
//*****************************************************************************************************************
		//need to add a dropdown for adding the weapon to a characters inventory.
		//I can rip this straight from another class, dont remember which one
//*****************************************************************************************************************
		
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 940);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 563, 884);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(15, 57, 69, 20);
		panel.add(lblName);
		
		lblCreateANew = new JLabel("Create a New Item");
		lblCreateANew.setBounds(128, 0, 148, 22);
		lblCreateANew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblCreateANew);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblType.setBounds(15, 103, 69, 20);
		panel.add(lblType);
		
		typeComboBox = new JComboBox(types);
		typeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		typeComboBox.setBounds(162, 101, 146, 26);
		panel.add(typeComboBox);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(162, 55, 146, 26);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setBounds(15, 660, 537, 160);
		panel.add(textAreaDescription);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDescription.setBounds(15, 634, 105, 20);
		panel.add(lblDescription);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//String type = (String)typeComboBox.getSelectedItem();
				type = (String)typeComboBox.getSelectedItem();
				
				if(type != "Type") 
				{
					type = type.toLowerCase();
				}else
				{
					type = "";
				}
				
				itemName = textFieldName.getText();
				strString = textFieldStr.getText();
				maxHPString = textFieldMaxHp.getText();
				dexString = textFieldDex.getText();
				luckString = textFieldLuck.getText();
				iqString = textFieldIq.getText();
				perString = textFieldPer.getText();
				chaString = textFieldCha.getText();
				willString = textFieldWill.getText();
				arString = textFieldAr.getText();
				mRString = textFieldMr.getText();
				description = textAreaDescription.getText().toLowerCase();
				flatDmg = textFieldFlatDamage.getText();
				scalingDmg = textFieldScalingDamage.getText();
				weaponArtName = textFieldWeaponArtName.getText();
				weaponArtDmg = textFieldWeaponArtDamage.getText();
				weaponArtDesc = textAreaWeaponArtDescription.getText();
				turnUsage = textFieldTurnUsage.getText();
				characterName = (String)comboBoxCharacters.getSelectedItem();
				
				String statsQuery = "INSERT INTO itemStatEffects (str, hp, dex, luck, iq, per, cha, will"
						+ ", ar, mr) VALUES ('"+strString+"', '"+maxHPString+"', '"+dexString+"', '"+
						luckString+"', '"+iqString+"', '"+perString+"', '"+chaString+"', '"+
						willString+"', '"+arString+"', '"+mRString+"')";
				System.out.println(statsQuery);
				db.executeQuery(statsQuery);
				
				statEffectId = db.ReturnLatestId("itemstateffects");
				
				String weaponsQuery = "INSERT INTO weapons (stateffectid, name, type, description, "
						+ "flatdamage, scalingdamage, turnusage, weaponartname, weaponartdamage,"
						+ "weaponartdescription) VALUES ('"+statEffectId+"', '"+itemName+"', '"+type+"', '"+
						description+"', '"+flatDmg+"', '"+scalingDmg+"', '"+turnUsage+"', '"+
						weaponArtName+"', '"+weaponArtDmg+"', '"+weaponArtDesc+"')";
				db.executeQuery(weaponsQuery);
				
				itemId = db.ReturnLatestId("weapons");
				
				
				if(characterName != "") 
				{ 
					AddToInventory(db, characterName);
				}
			
			
			}
		});
		
		btnSubmit.setBounds(87, 839, 177, 29);
		panel.add(btnSubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(308, 839, 177, 29);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{	
				frame.setVisible(false);
				frame.dispose();
			}
		});
		panel.add(btnCancel);
		
		
		lblStr = new JLabel("Str");
		lblStr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStr.setBounds(15, 143, 42, 20);
		panel.add(lblStr);
		
		lblMaxHp = new JLabel("HP");
		lblMaxHp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaxHp.setBounds(70, 143, 42, 20);
		panel.add(lblMaxHp);
		
		lblDex = new JLabel("Dex");
		lblDex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDex.setBounds(125, 143, 42, 20);
		panel.add(lblDex);
		
		lblLuck = new JLabel("Luck");
		lblLuck.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLuck.setBounds(180, 143, 42, 20);
		panel.add(lblLuck);
		
		lblIq = new JLabel("IQ");
		lblIq.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIq.setBounds(235, 143, 42, 20);
		panel.add(lblIq);
		
		lblPer = new JLabel("Per");
		lblPer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPer.setBounds(290, 143, 42, 20);
		panel.add(lblPer);
		
		lblCha = new JLabel("Cha");
		lblCha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCha.setBounds(345, 143, 42, 20);
		panel.add(lblCha);
		
		lblWill = new JLabel("Will");
		lblWill.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWill.setBounds(400, 143, 42, 20);
		panel.add(lblWill);
		
		lblAr = new JLabel("Ar");
		lblAr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAr.setBounds(455, 143, 42, 20);
		panel.add(lblAr);
		
		lblMr = new JLabel("MR");
		lblMr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMr.setBounds(510, 143, 42, 20);
		panel.add(lblMr);
		
		textFieldStr = new JTextField();
		textFieldStr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldStr.setBounds(15, 179, 42, 20);
		panel.add(textFieldStr);
		
		textFieldMaxHp = new JTextField();
		textFieldMaxHp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldMaxHp.setBounds(70, 179, 42, 20);
		panel.add(textFieldMaxHp);
		
		textFieldDex = new JTextField();
		textFieldDex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldDex.setBounds(125, 179, 42, 20);
		panel.add(textFieldDex);
		
		textFieldLuck = new JTextField();
		textFieldLuck.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldLuck.setBounds(180, 179, 42, 20);
		panel.add(textFieldLuck);
		
		textFieldIq = new JTextField();
		textFieldIq.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldIq.setBounds(235, 179, 42, 20);
		panel.add(textFieldIq);
		
		textFieldPer = new JTextField();
		textFieldPer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldPer.setBounds(290, 179, 42, 20);
		panel.add(textFieldPer);
		
		textFieldCha = new JTextField();
		textFieldCha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldCha.setBounds(345, 180, 42, 20);
		panel.add(textFieldCha);
		
		textFieldWill = new JTextField();
		textFieldWill.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldWill.setBounds(400, 180, 42, 20);
		panel.add(textFieldWill);
		
		textFieldAr = new JTextField();
		textFieldAr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldAr.setBounds(455, 180, 42, 20);
		panel.add(textFieldAr);
		
		textFieldMr = new JTextField();
		textFieldMr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldMr.setBounds(510, 179, 42, 20);
		panel.add(textFieldMr);
		
		lblFlatDamage = new JLabel("Flat Damage");
		lblFlatDamage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlatDamage.setBounds(125, 229, 105, 20);
		panel.add(lblFlatDamage);
		
		lblScalingDamage = new JLabel("Scaling Damage");
		lblScalingDamage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblScalingDamage.setBounds(289, 230, 124, 20);
		panel.add(lblScalingDamage);
		
		textFieldFlatDamage = new JTextField();
		textFieldFlatDamage.setBounds(98, 256, 146, 26);
		panel.add(textFieldFlatDamage);
		textFieldFlatDamage.setColumns(10);
		
		textFieldScalingDamage = new JTextField();
		textFieldScalingDamage.setBounds(275, 256, 146, 26);
		panel.add(textFieldScalingDamage);
		textFieldScalingDamage.setColumns(10);
		
		lblWeaponArt = new JLabel("Weapon Art");
		lblWeaponArt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeaponArt.setBounds(15, 347, 93, 20);
		panel.add(lblWeaponArt);
		
		textFieldWeaponArtName = new JTextField();
		textFieldWeaponArtName.setBounds(108, 375, 423, 26);
		panel.add(textFieldWeaponArtName);
		textFieldWeaponArtName.setColumns(10);
		
		textAreaWeaponArtDescription = new JTextArea();
		textAreaWeaponArtDescription.setText("Weapon Art Description");
		textAreaWeaponArtDescription.setBounds(15, 453, 533, 165);
		panel.add(textAreaWeaponArtDescription);
		
		JLabel lblWeaponArtName = new JLabel("Name");
		lblWeaponArtName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeaponArtName.setBounds(15, 378, 69, 20);
		panel.add(lblWeaponArtName);
		
		JLabel lblWeaponArtDamage = new JLabel("Damage");
		lblWeaponArtDamage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeaponArtDamage.setBounds(15, 414, 69, 20);
		panel.add(lblWeaponArtDamage);
		
		textFieldWeaponArtDamage = new JTextField();
		textFieldWeaponArtDamage.setColumns(10);
		textFieldWeaponArtDamage.setBounds(108, 411, 114, 26);
		panel.add(textFieldWeaponArtDamage);
		
		JLabel lblTurnUsage = new JLabel("Turn Usage");
		lblTurnUsage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTurnUsage.setBounds(15, 311, 85, 20);
		panel.add(lblTurnUsage);
		
		textFieldTurnUsage = new JTextField();
		textFieldTurnUsage.setBounds(108, 309, 146, 26);
		panel.add(textFieldTurnUsage);
		textFieldTurnUsage.setColumns(10);
		
		lblAddToInventory = new JLabel("Add to Inventory:");
		lblAddToInventory.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddToInventory.setBounds(323, 58, 135, 20);
		panel.add(lblAddToInventory);
		
		
		//this needs to be updated to give character inventory data when creating a new item
		comboBoxCharacters = new JComboBox(new Object[]{});
		comboBoxCharacters.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxCharacters.setBounds(323, 101, 146, 26);
		characterList = db.ReturnColumn("name", "characters");
		comboBoxCharacters.addItem("");
		for(int i = 0; i < characterList.size(); i++) 
		{
			comboBoxCharacters.addItem(characterList.get(i));
		}
		panel.add(comboBoxCharacters);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(474, 103, 78, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				characterName = (String)comboBoxCharacters.getSelectedItem();
				if(characterName != "") 
				{ 
					AddToInventory(db, characterName);
				}
			}
		});
		panel.add(btnAdd);
		frame.setVisible(true);
	}
	
	public void Populate(SqliteDB db, String name) 
	{
		//gather the data from DB
		try //1
		{
			rsWeapon = db.RowFromName(name, "weapons");
			//weaponName = rsWeapon.getString("name");
			itemName = rsWeapon.getString("name");
			type = rsWeapon.getString("type");
			statEffectId = rsWeapon.getInt("stateffectid");
			System.out.println("statEffectId = "+statEffectId);
			
			itemId = rsWeapon.getInt("id");
			rsStatEffects = db.RowFromId(statEffectId, "itemstateffects");		
			str = rsStatEffects.getInt("str");
			hp = rsStatEffects.getInt("hp");
			dex = rsStatEffects.getInt("dex");
			luck = rsStatEffects.getInt("luck");
			iq = rsStatEffects.getInt("iq");
			per = rsStatEffects.getInt("per");
			cha = rsStatEffects.getInt("cha");
			will = rsStatEffects.getInt("will");
			ar = rsStatEffects.getInt("ar");
			mr = rsStatEffects.getInt("mr");
			flatDmg = rsWeapon.getString("flatdamage");
			scalingDmg = rsWeapon.getString("scalingdamage");
			turnUsage = rsWeapon.getString("turnusage");
			weaponArtName = rsWeapon.getString("weaponartname");
			weaponArtDmg = rsWeapon.getString("weaponartdamage");
			weaponArtDesc = rsWeapon.getString("weaponartdescription");
			weaponDesc = rsWeapon.getString("description");
			
			btnSubmit.setEnabled(false);
		}catch(Exception e) 
		{
			System.out.println("Error in Populate() in WeaponCreationUI. Error: " + e.getMessage());
		}
		
		
		
		
		//populate the fields
		lblCreateANew.setText(itemName);
		
		//textFieldName.setText(weaponName);
		textFieldName.setText(itemName);
		textFieldFlatDamage.setText(flatDmg);
		textFieldScalingDamage.setText(scalingDmg);
		textFieldWeaponArtName.setText(weaponArtName);
		textFieldWeaponArtDamage.setText(weaponArtDmg);
		textFieldTurnUsage.setText(turnUsage);
		textAreaWeaponArtDescription.setText(weaponArtDesc);
		textAreaDescription.setText(weaponDesc);
		//doesnt work when the type has multiple words
		String typeCap = Capitalize(type);
		typeComboBox.setSelectedItem(typeCap); 
		
		textFieldStr.setText(Integer.toString(str));
		textFieldMaxHp.setText(Integer.toString(hp));
		textFieldDex.setText(Integer.toString(dex));
		textFieldLuck.setText(Integer.toString(luck));
		textFieldIq.setText(Integer.toString(iq));
		textFieldPer.setText(Integer.toString(per));
		textFieldCha.setText(Integer.toString(cha));
		textFieldWill.setText(Integer.toString(will));
		textFieldAr.setText(Integer.toString(ar));
		textFieldMr.setText(Integer.toString(mr));
	}
	
	public void lockFields()
	{
		textFieldName.setEditable(false);
		textFieldFlatDamage.setEditable(false);
		textFieldScalingDamage.setEditable(false);
		textFieldWeaponArtName.setEditable(false);
		textFieldWeaponArtDamage.setEditable(false);
		textFieldTurnUsage.setEditable(false);
		textAreaWeaponArtDescription.setEditable(false);
		textAreaDescription.setEditable(false);
		typeComboBox.setEditable(false); 
		
		textFieldStr.setEditable(false);
		textFieldMaxHp.setEditable(false);
		textFieldDex.setEditable(false);
		textFieldLuck.setEditable(false);
		textFieldIq.setEditable(false);
		textFieldPer.setEditable(false);
		textFieldCha.setEditable(false);
		textFieldWill.setEditable(false);
		textFieldAr.setEditable(false);
		textFieldMr.setEditable(false);
	}
	
	public void AddToInventory(SqliteDB db, String characterName)
	{
		try 
		{
			ResultSet rs = db.RowFromName(characterName, "characters");
			int inventoryId = rs.getInt("id");
			String query = "INSERT INTO inventory"+inventoryId+" VALUES ('"+itemName+"', '" 
					+type+"', "+0+", "+itemId+")";
			System.out.println(query);
			db.executeQuery(query);
		}catch(Exception e) 
		{
			System.out.println("Error in AddtoInventory() in WeaponCreationUI. Error: " + e.getMessage());
		}
	}
	//a method to capitalize the first letter of each word in a string
	public static String Capitalize(String text){
	    String c = (text != null)? text.trim() : "";
	    String[] words = c.split(" ");
	    String result = "";
	    for(String w : words){
	        result += (w.length() > 1? w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1, w.length()).toLowerCase(Locale.US) : w) + " ";
	    }
	    return result.trim();
	}
	
	private void Refresh(SqliteDB db) {
		db.closeConnection();
		SqliteDB db2 = new SqliteDB();
		frame.setVisible(false);
		frame.dispose();
		initialize(db2);
	}
}
