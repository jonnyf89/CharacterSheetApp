import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CharacterSheetUI2 {

	private JFrame frame;
	private JLabel nameLabel;
	private JLabel statLabel;
	private JLabel statLabel1;
	private JLabel statLabel2;
	private JLabel statLabel3;
	private JLabel statLabel4;
	private JLabel statLabel5;
	private JLabel statLabel6;
	private JLabel statLabel7;
	private JLabel statLabel8;
	private JLabel statLabel9;
	private JTextField baseStrField;
	private JTextField baseHPField;
	private JTextField baseDexField;
	private JTextField baseLuckField;
	private JTextField baseIQField;
	private JTextField basePerField;
	private JTextField baseChaField;
	private JTextField baseWillField;
	private JLabel currentStrField;
	private JLabel currentHPField;
	private JLabel currentDexField;
	private JLabel currentLuckField;
	private JLabel currentIQField;
	private JLabel currentPerField;
	private JLabel currentChaField;
	private JLabel currentWillField;
	private JLabel currentArField;
	private JLabel currentMrField;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnReset;
	
	private JScrollPane scrollPane;
	
	private ResultSet rsCharacter;
	private ResultSet rsBaseStats;
	private int baseStatsId;
	private int characterId;
	
	private List equippedItems;
	
	private ArrayList<String> inventoryNames;
	
	//base values
	private String str;
	private String maxHp;
	private String dex;
	private String luck;
	private String iq;
	private String per;
	private String cha;
	private String will;
	
	//current values
	private String currentStrString;
	private String currentMaxHpString;
	private String currentDexString;
	private String currentLuckString;
	private String currentIqString;
	private String currentPerString;
	private String currentChaString;
	private String currentWillString;
	private String currentArString;
	private String currentMrString;
	
	//base values
	private int strInt;
	private int maxHpInt;
	private int dexInt;
	private int luckInt;
	private int iqInt;
	private int perInt;
	private int chaInt;
	private int willInt;
	private int arInt;
	private int mrInt;
	
	//current values
	private int currentStr;
	private int currentMaxHp;
	private int currentDex;
	private int currentLuck;
	private int currentIq;
	private int currentPer;
	private int currentCha;
	private int currentWill;
	private int currentAr;
	private int currentMr;
	private InventoryTable table;

	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharacterSheetUI2 window = new CharacterSheetUI2();
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
//	public CharacterSheetUI2() {
	//	initialize();
//	}
	public CharacterSheetUI2(SqliteDB db, String name) {
		initialize(db, name);
		//could do seperate classes for creating + adding the fields and buttons
		//then I can create + add the button listeners in it's own class 
		Populate(db, name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SqliteDB db, String name) {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 1106);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STAT");
		lblNewLabel.setBounds(15, 48, 85, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BASE");
		lblNewLabel_1.setBounds(155, 48, 61, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(168, 12, 69, 20);
		frame.getContentPane().add(nameLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CURRENT");
		lblNewLabel_2.setBounds(231, 48, 85, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		statLabel = new JLabel();
		statLabel.setBounds(15, 75, 118, 26);
		frame.getContentPane().add(statLabel);
		
		
		statLabel1 = new JLabel();
		statLabel1.setBounds(15, 105, 118, 26);
		frame.getContentPane().add(statLabel1);
		
		statLabel2 = new JLabel();
		statLabel2.setBounds(15, 135, 118, 26);
		frame.getContentPane().add(statLabel2);
		
		statLabel3 = new JLabel();
		statLabel3.setBounds(15, 165, 118, 26);
		frame.getContentPane().add(statLabel3);
		
		statLabel4 = new JLabel();
		statLabel4.setBounds(15, 195, 118, 26);
		frame.getContentPane().add(statLabel4);
		
		statLabel5 = new JLabel();
		statLabel5.setBounds(15, 225, 118, 26);
		frame.getContentPane().add(statLabel5);
		
		statLabel6 = new JLabel();
		statLabel6.setBounds(15, 255, 118, 26);
		frame.getContentPane().add(statLabel6);
		
		statLabel7 = new JLabel();
		statLabel7.setBounds(15, 285, 118, 26);
		frame.getContentPane().add(statLabel7);
		
		statLabel8 = new JLabel();
		statLabel8.setBounds(15, 315, 118, 26);
		frame.getContentPane().add(statLabel8);
		
		statLabel9 = new JLabel();
		statLabel9.setBounds(15, 345, 118, 26);
		frame.getContentPane().add(statLabel9);
		
		baseStrField = new JTextField();
		baseStrField.setBounds(155, 75, 61, 26);
		frame.getContentPane().add(baseStrField);
		baseStrField.setColumns(10);
		
		baseHPField = new JTextField();
		baseHPField.setBounds(155, 105, 61, 26);
		frame.getContentPane().add(baseHPField);
		baseHPField.setColumns(10);
		
		baseDexField = new JTextField();
		baseDexField.setBounds(155, 135, 61, 26);
		frame.getContentPane().add(baseDexField);
		baseDexField.setColumns(10);
		
		baseLuckField = new JTextField();
		baseLuckField.setBounds(155, 165, 61, 26);
		frame.getContentPane().add(baseLuckField);
		baseLuckField.setColumns(10);
		
		baseIQField = new JTextField();
		baseIQField.setBounds(155, 195, 61, 26);
		frame.getContentPane().add(baseIQField);
		baseIQField.setColumns(10);
		
		basePerField = new JTextField();
		basePerField.setBounds(155, 225, 61, 26);
		frame.getContentPane().add(basePerField);
		basePerField.setColumns(10);
		
		baseChaField = new JTextField();
		baseChaField.setBounds(155, 255, 61, 26);
		frame.getContentPane().add(baseChaField);
		baseChaField.setColumns(10);
		
		baseWillField = new JTextField();
		baseWillField.setBounds(155, 285, 61, 26);
		frame.getContentPane().add(baseWillField);
		baseWillField.setColumns(10);
		
		currentStrField = new JLabel();
		currentStrField.setBounds(231, 75, 61, 26);
		frame.getContentPane().add(currentStrField);
		
		currentHPField = new JLabel();
		currentHPField.setBounds(231, 105, 61, 26);
		frame.getContentPane().add(currentHPField);
		
		currentDexField = new JLabel();
		currentDexField.setBounds(231, 135, 61, 26);
		frame.getContentPane().add(currentDexField);
		
		currentLuckField = new JLabel();
		currentLuckField.setBounds(231, 165, 61, 26);
		frame.getContentPane().add(currentLuckField);
		
		currentIQField = new JLabel();
		currentIQField.setBounds(231, 195, 61, 26);
		frame.getContentPane().add(currentIQField);
		
		currentPerField = new JLabel();
		currentPerField.setBounds(231, 225, 61, 26);
		frame.getContentPane().add(currentPerField);
		
		currentChaField = new JLabel();
		currentChaField.setBounds(231, 255, 61, 26);
		frame.getContentPane().add(currentChaField);
		
		currentWillField = new JLabel();
		currentWillField.setBounds(231, 285, 61, 26);
		frame.getContentPane().add(currentWillField);
		
		currentArField = new JLabel();
		currentArField.setBounds(231, 315, 61, 26);
		frame.getContentPane().add(currentArField);
		
		currentMrField = new JLabel();
		currentMrField.setBounds(231, 345, 61, 26);
		frame.getContentPane().add(currentMrField);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				 str = baseStrField.getText();
				 maxHp = baseHPField.getText();
				 dex = baseDexField.getText();
				 luck = baseLuckField.getText();
				 iq = baseIQField.getText();
				 per = basePerField.getText();
				 cha = baseChaField.getText();
				 will = baseWillField.getText();
				 
				 strInt = Integer.parseInt(str);
				 maxHpInt = Integer.parseInt(maxHp);
				 dexInt = Integer.parseInt(dex);
				 luckInt = Integer.parseInt(luck);
				 iqInt = Integer.parseInt(iq);
				 perInt = Integer.parseInt(per);
				 chaInt = Integer.parseInt(cha);
				 willInt = Integer.parseInt(will);
				 
				 String updateQuery = "UPDATE characterbasestats SET str = "+strInt+
						 ", hp = "+maxHpInt+", dex = "+dexInt+", luck = "+luck+
						 ", iq = "+iqInt+", per = "+perInt+", cha = "+chaInt+
						 ", will = "+willInt+" WHERE id = "+ baseStatsId;
				 
				 try
				 {
					 db.executeQuery(updateQuery);
				 }catch(Exception e)
				 {
					 System.out.println("Error updating characterbasestats in CharacterSheetUI2, Error: "+ e.getMessage());
				 }
				 
			}
		});
		btnUpdate.setBounds(15, 399, 115, 29);
		frame.getContentPane().add(btnUpdate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnCancel.setBounds(298, 399, 115, 29);
		frame.getContentPane().add(btnCancel);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Populate(db, name);
			}
		});
		btnReset.setBounds(155, 399, 115, 29);
		frame.getContentPane().add(btnReset);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInventory.setBounds(178, 444, 75, 20);
		frame.getContentPane().add(lblInventory);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 467, 398, 209);
		frame.getContentPane().add(scrollPane);
		
		//JFrame f = new JFrame();
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
       
		frame.setVisible(true);	


		
	}
	private void Populate(SqliteDB db, String name)
	{		
		try 
		{
			rsCharacter = db.RowFromName(name, "characters");
			baseStatsId = rsCharacter.getInt("basestatsid");
			rsBaseStats = db.RowFromId(baseStatsId, "characterbasestats");
			characterId = rsCharacter.getInt("id");
			str = rsBaseStats.getString("str"); 
			maxHp = rsBaseStats.getString("hp");
			dex = rsBaseStats.getString("dex");
			luck = rsBaseStats.getString("luck");
			iq = rsBaseStats.getString("iq"); 
			per = rsBaseStats.getString("per"); 
			cha = rsBaseStats.getString("cha"); 
			will = rsBaseStats.getString("will"); 

			strInt = Integer.parseInt(str);
			maxHpInt = Integer.parseInt(maxHp);
			dexInt = Integer.parseInt(dex);
			luckInt = Integer.parseInt(luck);
			iqInt = Integer.parseInt(iq);
			perInt = Integer.parseInt(per);
			chaInt = Integer.parseInt(cha);
			willInt = Integer.parseInt(will);
			arInt = 0;
			mrInt = 0;
			
			//the below are not taking equipped items into account
			//this isnt working, i need to initially check for equipped items and add 
			//all equipped values to base values
			currentStr = strInt;
			currentMaxHp = maxHpInt;
			currentDex = dexInt;
			currentLuck = luckInt;
			currentIq = iqInt;
			currentPer = perInt;
			currentCha = chaInt;
			currentWill = willInt;
			currentAr = arInt;
			currentMr = mrInt;
			
			currentStrString = Integer.toString(currentStr);
			currentMaxHpString = Integer.toString(currentMaxHp);
			currentDexString = Integer.toString(currentDex);
			currentLuckString = Integer.toString(currentLuck);
			currentIqString = Integer.toString(currentIq);
			currentPerString = Integer.toString(currentPer);
			currentChaString = Integer.toString(currentCha);
			currentWillString = Integer.toString(currentWill);
			currentArString = Integer.toString(currentAr);
			currentMrString = Integer.toString(currentMr);
			
			
			nameLabel.setText(name);
			
			statLabel.setText("Strength");
			baseStrField.setText(str);
			currentStrField.setText(currentStrString);
			
			statLabel1.setText("Max HP");
			baseHPField.setText(maxHp);
			currentHPField.setText(currentMaxHpString);
			
			statLabel2.setText("Dexterity");
			baseDexField.setText(dex);
			currentDexField.setText(currentDexString);
			
			statLabel3.setText("Luck");
			baseLuckField.setText(luck);
			currentLuckField.setText(currentLuckString);
			
			statLabel4.setText("Intelligence");
			baseIQField.setText(iq);
			currentIQField.setText(currentIqString);
			
			statLabel5.setText("Perception");
			basePerField.setText(per);
			currentPerField.setText(currentPerString);
			
			statLabel6.setText("Charisma");
			baseChaField.setText(cha);
			currentChaField.setText(currentChaString);
			
			statLabel7.setText("Will");
			baseWillField.setText(will);
			currentWillField.setText(currentWillString);
			
			statLabel8.setText("Armor");
			currentArField.setText(currentArString);
			
			statLabel9.setText("Magic Res");
			currentMrField.setText(currentMrString);
			
			CheckBoxList cbList = new CheckBoxList();
			cbList.addListSelectionListener(new ListSelectionListener()
			{	
				@Override
				public void valueChanged(ListSelectionEvent e) 
				{
					if (e.getValueIsAdjusting()) 
					{
						return;
					}else
					{
						//String value = (String) cbList.getSelectedValue();
						List<String> values = 	cbList.getSelectedValuesList();
						System.out.println(values.size());
						
						/*for(int i = 0; i < values.size(); i++)
						{
							System.out.println(values.get(i));
						}*/
						
						
						//Dont have the above doing anything yet
						
						/*//new ApparelDetailsUI(db, value);
						WeaponCreationUI weaponScreen = new WeaponCreationUI(db);
						weaponScreen.Populate(db, value);
						weaponScreen.lockFields();*/
					}
				}
				
			});
		   /* JCheckBox check1 = new JCheckBox("one");
		    JCheckBox check2 = new JCheckBox("two");
		    JCheckBox check3 = new JCheckBox("three");
		    JCheckBox check4 = new JCheckBox("four");
		    JCheckBox check5 = new JCheckBox("five");
		    JCheckBox check6 = new JCheckBox("six");
		    JCheckBox check7 = new JCheckBox("seven");
		    JCheckBox check8 = new JCheckBox("eight");
		    JCheckBox[] myList = { check1, check2, check3, check4, check5, check6, check7, check8 };
		    cbList.setListData(myList);
		    scrollPane.setViewportView(cbList);*/

		    ResultSet rsInventory = db.returnResultSet("inventory"+characterId);
		    inventoryNames = new ArrayList<String>();
		    ArrayList<Boolean> inventoryEquipped = new ArrayList<Boolean>();
		    while(rsInventory.next()) 
		    {
		    	String itemName = rsInventory.getString("name");
		    	Boolean equipped = rsInventory.getBoolean("equipped");
		    	inventoryNames.add(itemName);
		    	inventoryEquipped.add(equipped);
		    }
		    int length = inventoryNames.size();
		    JCheckBox[] inventoryBoxes = new JCheckBox[length];
		    for(int i = 0; i < length; i++)
		    {
		    	if (inventoryEquipped.get(i) == false) 
		    	{
		    		inventoryBoxes[i] = new JCheckBox(inventoryNames.get(i), false);
		    	}else
		    	{
		    		inventoryBoxes[i] = new JCheckBox(inventoryNames.get(i), true);
		    	}
		    }
		    cbList.setListData(inventoryBoxes);
		    scrollPane.setViewportView(cbList);
		    
		    //ArrayList<JCheckBox> equippedItems = cbList.getCheckedItems();
		    equippedItems = cbList.getCheckedItems();
		    //System.out.println("Number of equipped items is: " + equippedItems.size());
		    
		    cbList.addListSelectionListener(new ListSelectionListener() {
		    	public void valueChanged(ListSelectionEvent e) 
		    	{
		    		if(cbList.isEnabled()) {
		    			System.out.println("Enabled");
		    		}
		    		else if(!cbList.isEnabled()) {
		    			System.out.println("Not Enabled");
		    		}
		    		
		    		
		    		//All of the below code should happen in populate, above this line should just 
		    		//write the new equip to the DB, the below should happen in response
		    		//to reading the DB
		    		
		    		
		    		//this is working but on the selection of the list item, not the ticking of the box which isnt the same 
		    		equippedItems = cbList.getCheckedItems();	//equipped items is a list of checkboxes, so i need to get its labels
		    		String[] equippedItemNames = new String[equippedItems.size()];
		    		for (int i = 0; i < equippedItems.size(); i++)
		    		{
		    			JCheckBox checkBox = (JCheckBox) equippedItems.get(i);
		    			String name = checkBox.getText();
		    			equippedItemNames[i] = name;
		    			
		    			//for the below we need the characterid and the rowid from the inventory
		    			db.equipItem(name, characterId);
		    		}
		    		System.out.println("Number of equipped items is: " + equippedItems.size());
		    		System.out.println("The equipped items are: ");
		    		for (int i = 0; i < equippedItemNames.length; i++)//this is just for testing, whole loop an be removed
		    		{
		    			System.out.println(equippedItemNames[i]);
		    		}
		    		ArrayList<String> effectedStats = new ArrayList<String>();
		    		ArrayList<Integer> statEffects = new ArrayList<Integer>();
		    		for (int i = 0; i < equippedItemNames.length; i++)
		    		{
		    			try {
		    				ResultSet rsWeapon = db.RowFromName(equippedItemNames[i], "weapons");
		    				String statEffectIdString = rsWeapon.getString("stateffectid");
		    				int statEffectIdInt = Integer.parseInt(statEffectIdString);
		    				ResultSet rsEffects = db.RowFromId(statEffectIdInt, "itemstateffects");
			    			ResultSetMetaData md = rsEffects.getMetaData();
			    			//iterate through the RS and any instance where the value is not 0, grab it and its column header
			    			//OR maybe just grab everything, the 0s wont do any harm.
			    			int columnCount = md.getColumnCount();
			    			for(int i2 = 1; i2 < columnCount+1; i2++ )
			    			{
			    				String columnName = md.getColumnName(i2);
			    				if(!columnName.equals("id")&&!columnName.equals("rowid"))
			    				{
			    					int effectAmount = rsEffects.getInt(columnName);
			    					if(effectAmount != 0)
			    					{
			    						System.out.println("Adding: " + columnName + ": " + effectAmount);
			    						effectedStats.add(columnName);
			    						statEffects.add(effectAmount);
			    					}
			    				}
			    			}
			    			
			    			for(int i3 = 0; i3 < effectedStats.size(); i3++)
			    			{
			    				if(effectedStats.get(i3) == "str")
			    				{
			    					currentStr += statEffects.get(i3); 
			    				}
			    				else if(effectedStats.get(i3) == "hp")
			    				{
			    					currentMaxHp += statEffects.get(i3);
			    				}
			    				else if(effectedStats.get(i3) == "dex")
			    				{
			    					currentDex += statEffects.get(i3);
			    				}
			    				else if(effectedStats.get(i3) == "luck")
			    				{
			    					currentLuck += statEffects.get(i3);
			    				}
			    				else if(effectedStats.get(i3) == "iq")
			    				{
			    					currentIq += statEffects.get(i3);
			    				}
			    				else if(effectedStats.get(i3) == "per")
			    				{
			    					currentPer += statEffects.get(i3);
			    				}
			    				else if(effectedStats.get(i3) == "cha")
			    				{
			    					currentCha += statEffects.get(i3);
			    				}
			    				else if(effectedStats.get(i3) == "will")
			    				{
			    					currentWill += statEffects.get(i3);
			    				}
			    				else if(effectedStats.get(i3) == "ar")
			    				{
			    					currentAr += statEffects.get(i3);
			    				}
			    				else if(effectedStats.get(i3) == "mr")
			    				{
			    					currentMr += statEffects.get(i3);
			    				}
			    			}
			    	//		Refresh(db, name);
			    			//The refresh works but the ticks arnt being retained after refresh, so we need to write the ticks
			    			//to the DB before we refresh
		    				
						} catch (Exception e1) {
							System.out.println("Error iterating through rsEffects in CharacterSheetUI. Error: "+ e1.getMessage());
							e1.printStackTrace();
						}
		    		}
		    	}
		    }
		    		);
		} catch (Exception e) 
		{
			System.out.println("Error in Populate() in CharacterSheetUI2. Error: " + e.getMessage());
		}
		
		 //table = new InventoryTable(inventoryNames);
		table = new InventoryTable(db, characterId);
		table.setBounds(15, 738, 398, 296);
		frame.getContentPane().add(table);
	    //frame.add(new InventoryTable());
	    // f.pack();
	    //frame.pack();
	    //f.setLocationRelativeTo(null);
		frame.setLocationRelativeTo(null);
	    //f.setVisible(true);
	        
			
	}
	
	private void Refresh(SqliteDB db, String name) {
		db.closeConnection();
		SqliteDB db2 = new SqliteDB();
		frame.setVisible(false);
		frame.dispose();
		initialize(db2, name);
		Populate(db2, name);
	}
}
