import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ApparelDetailsUI {

	private JFrame frame;
	
	private JPanel panel;
	private JLabel lblItemName;
	private JLabel lblTypeLabel;
	private JLabel lblTypeValue;
	private JLabel lblEffects;
	private JLabel lblStr;
	private JLabel lblHp;
	private JLabel lblDex;
	private JLabel lblLuck;
	private JLabel lblPer;
	private JLabel lblIq;
	private JLabel lblCha;
	private JLabel lblWill;
	private JLabel lblAr;
	private JLabel lblMr;
	private JLabel lblStrEffect;
	private JLabel lblHPEffect;
	private JLabel lblDexEffect;
	private JLabel lblLuckEffect;
	private JLabel lblIQEffect;
	private JLabel lblPerEffect;
	private JLabel lblChaEffect;
	private JLabel lblWillEffect;
	private JLabel lblArEffect;
	private JLabel lblMREffect; 
	private JLabel lblDescriptionLabel;
	private JTextArea textAreaDescription;
	private JLabel lblAddToInventory;
	private JComboBox<String> comboBoxCharacters;
	private JButton btnAdd;	
	private JButton btnClose;

	
	
	private ResultSet rsStatEffects;
	private ResultSet rsItem;
	private ArrayList<String> characterList;
	
	private String itemName;
	private String type; 
	private String description;
	
	private int statEffectId;
	private int itemId;
	private int str;
	private int hp;
	private int dex;
	private int luck;
	private int iq;
	private int per;
	private int cha;
	private int will;
	
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SqliteDB db = new SqliteDB();
					ItemDetailsUI window = new ItemDetailsUI(db, "sword");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public ApparelDetailsUI(SqliteDB db, String name) {
		initialize(db);
		Populate(db, name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SqliteDB db) {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 571, 574);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblItemName = new JLabel("Item Name");
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblItemName.setBounds(15, 0, 533, 20);
		panel.add(lblItemName);
		
		lblTypeLabel = new JLabel("Type");
		lblTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTypeLabel.setBounds(15, 52, 69, 20);
		panel.add(lblTypeLabel);
		
		lblTypeValue = new JLabel("type");
		lblTypeValue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTypeValue.setBounds(99, 53, 268, 19);
		panel.add(lblTypeValue);
		
		lblEffects = new JLabel("Effects");
		lblEffects.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEffects.setBounds(15, 92, 69, 20);
		panel.add(lblEffects);
		
		lblStr = new JLabel("Str");
		lblStr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStr.setBounds(15, 125, 42, 20);
		panel.add(lblStr);
		
		lblHp = new JLabel("HP");
		lblHp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHp.setBounds(70, 125, 42, 20);
		panel.add(lblHp);
		
		lblDex = new JLabel("Dex");
		lblDex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDex.setBounds(125, 125, 42, 20);
		panel.add(lblDex);
		
		lblLuck = new JLabel("Luck");
		lblLuck.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLuck.setBounds(180, 125, 42, 20);
		panel.add(lblLuck);
		
		lblPer = new JLabel("IQ");
		lblPer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPer.setBounds(235, 125, 42, 20);
		panel.add(lblPer);
		
		lblIq = new JLabel("Per");
		lblIq.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIq.setBounds(290, 125, 42, 20);
		panel.add(lblIq);
		
		lblCha = new JLabel("Cha");
		lblCha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCha.setBounds(345, 125, 42, 20);
		panel.add(lblCha);
		
		lblWill = new JLabel("Will");
		lblWill.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWill.setBounds(400, 125, 42, 20);
		panel.add(lblWill);
		
		lblAr = new JLabel("Ar");
		lblAr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAr.setBounds(455, 125, 42, 20);
		panel.add(lblAr);
		
		lblMr = new JLabel("MR");
		lblMr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMr.setBounds(510, 125, 42, 20);
		panel.add(lblMr);
		
		lblStrEffect = new JLabel("0");
		lblStrEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStrEffect.setBounds(15, 161, 42, 20);
		panel.add(lblStrEffect);
		
		lblHPEffect = new JLabel("0");
		lblHPEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHPEffect.setBounds(70, 161, 42, 20);
		panel.add(lblHPEffect);
		
		lblDexEffect = new JLabel("0");
		lblDexEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDexEffect.setBounds(125, 161, 42, 20);
		panel.add(lblDexEffect);
		
		lblLuckEffect = new JLabel("0");
		lblLuckEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLuckEffect.setBounds(180, 161, 42, 20);
		panel.add(lblLuckEffect);
		
		lblIQEffect = new JLabel("0");
		lblIQEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIQEffect.setBounds(235, 161, 42, 20);
		panel.add(lblIQEffect);
		
		lblPerEffect = new JLabel("0");
		lblPerEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPerEffect.setBounds(290, 161, 42, 20);
		panel.add(lblPerEffect);
		
		lblChaEffect = new JLabel("0");
		lblChaEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblChaEffect.setBounds(345, 162, 42, 20);
		panel.add(lblChaEffect);
		
		lblWillEffect = new JLabel("0");
		lblWillEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWillEffect.setBounds(400, 162, 42, 20);
		panel.add(lblWillEffect);
		
		lblArEffect = new JLabel("0");
		lblArEffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArEffect.setBounds(455, 162, 42, 20);
		panel.add(lblArEffect);
		
		lblMREffect = new JLabel("0");
		lblMREffect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMREffect.setBounds(510, 161, 42, 20);
		panel.add(lblMREffect);
		
		lblDescriptionLabel = new JLabel("Description");
		lblDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescriptionLabel.setBounds(15, 197, 97, 20);
		panel.add(lblDescriptionLabel);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setBounds(15, 226, 541, 203);
		textAreaDescription.setEditable(false);
		panel.add(textAreaDescription);
		
		lblAddToInventory = new JLabel("Add to inventory");
		lblAddToInventory.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddToInventory.setBounds(25, 448, 126, 20);
		panel.add(lblAddToInventory);
		
		comboBoxCharacters = new JComboBox();
		comboBoxCharacters.setBounds(159, 445, 208, 26);
		panel.add(comboBoxCharacters);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(382, 445, 115, 29);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				//Why is the below adding the sword every time? Even when we try to add other items to the inventory, the Item details are not being reset
				try 
				{
					String characterName = (String)comboBoxCharacters.getSelectedItem();
					ResultSet rs = db.RowFromName(characterName, "characters");
					int inventoryId = rs.getInt("id");
					String query = "INSERT INTO inventory"+inventoryId+" VALUES ('"+itemName+"', '" 
							+type+"', "+0+", "+itemId+")";
					System.out.println(query);
					db.executeQuery(query);
				}catch(Exception e)
				{
					System.out.println("Error in btnAdd.addActionListener. Error: " + e.getMessage());
				}
			}
		});
		panel.add(btnAdd);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(207, 518, 170, 40);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				frame.dispose();
			}
		});
		panel.add(btnClose);
		
		frame.setVisible(true);
	}
	
	public void Populate(SqliteDB db, String name)
	{
		//to populate the page I: 
		//have: 'name' which is the name of the item, taken from the dropdown label
		
		
		//need:
		//name, type, description, effects, character list
		
		//from: items: name, description, type, (statEffectId, to get effects)
		//from: effects: effects (using statEffectsId)
		//from: Characters: all names
		try 
		{
			//gather the data
			rsItem = db.RowFromName(name, "items");
			itemName = rsItem.getString("name");
			type = rsItem.getString("type"); 
			description = rsItem.getString("description");
			statEffectId = rsItem.getInt("stateffectid");
			itemId = rsItem.getInt("id");
			
			
			rsStatEffects = db.RowFromId(statEffectId, "itemstateffects");
			str = rsStatEffects.getInt("str");
			hp = rsStatEffects.getInt("hp");
			dex = rsStatEffects.getInt("dex");
			luck = rsStatEffects.getInt("luck");
			iq = rsStatEffects.getInt("iq");
			per = rsStatEffects.getInt("per");
			cha = rsStatEffects.getInt("cha");
			will = rsStatEffects.getInt("will");
			
			characterList = db.ReturnColumn("name", "characters");
			
			//input the data into the fields
			lblItemName.setText(itemName);
			lblTypeValue.setText(type);
			textAreaDescription.setText(description);
			
			lblStrEffect.setText(Integer.toString(str));
			lblHPEffect.setText(Integer.toString(hp));
			lblDexEffect.setText(Integer.toString(dex));
			lblLuckEffect.setText(Integer.toString(luck));
			lblIQEffect.setText(Integer.toString(iq));
			lblPerEffect.setText(Integer.toString(per));
			lblChaEffect.setText(Integer.toString(cha));
			lblWillEffect.setText(Integer.toString(will));
			
			for(int i = 0; i < characterList.size(); i++) 
			{
				comboBoxCharacters.addItem(characterList.get(i));
			}
		}catch(Exception e)
		{
			System.out.println("Error in Populate() in ApparelDetailsUI. Error: " + e.getMessage());
		}
		
		
	}
}
