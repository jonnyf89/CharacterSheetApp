import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CharacterCreationUI2 {

	private JFrame frame;
	private JTextField nameField;
	private JTextField raceField;
	private JTextField genderField;
	private JTextField classField;
	private JTextField strField;
	private JTextField dexField;
	private JTextField iQField;
	private JTextField chaField;
	private JTextField descField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharacterCreationUI2 window = new CharacterCreationUI2(db);
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
	public CharacterCreationUI2(SqliteDB db) {
		initialize(db);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SqliteDB db) {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 743);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCreateANew = new JLabel("Create a New Character");
		lblCreateANew.setBounds(140, 5, 185, 22);
		lblCreateANew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblCreateANew);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(15, 50, 69, 20);
		panel.add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(150, 50, 300, 26);
		panel.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblRace = new JLabel("Race*");
		lblRace.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRace.setBounds(15, 100, 120, 20);
		panel.add(lblRace);
		
		raceField = new JTextField();
		raceField.setColumns(10);
		raceField.setBounds(150, 100, 300, 26);
		panel.add(raceField);
		
		JLabel lblGender = new JLabel("Gender*");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGender.setBounds(15, 150, 120, 20);
		panel.add(lblGender);
		
		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(150, 150, 300, 26);
		panel.add(genderField);
		
		JLabel lblClass = new JLabel("Class*");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblClass.setBounds(15, 200, 120, 20);
		panel.add(lblClass);
		
		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(150, 200, 300, 26);
		panel.add(classField);
		
		JLabel lblStr = new JLabel("Strength/HP");
		lblStr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStr.setBounds(15, 250, 120, 20);
		panel.add(lblStr);
		
		strField = new JTextField();
		strField.setColumns(10);
		strField.setBounds(150, 250, 300, 26);
		panel.add(strField);
		
		JLabel lblDex = new JLabel("Dexterity/Luck");
		lblDex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDex.setBounds(15, 300, 120, 20);
		panel.add(lblDex);
		
		dexField = new JTextField();
		dexField.setColumns(10);
		dexField.setBounds(150, 300, 300, 26);
		panel.add(dexField);
		
		JLabel lblIQ = new JLabel("IQ/Perception");
		lblIQ.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIQ.setBounds(15, 350, 120, 20);
		panel.add(lblIQ);
		
		iQField = new JTextField();
		iQField.setColumns(10);
		iQField.setBounds(150, 350, 300, 26);
		panel.add(iQField);
		
		JLabel lblCha = new JLabel("Charisma/Will");
		lblCha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCha.setBounds(15, 400, 120, 20);
		panel.add(lblCha);
		
		chaField = new JTextField();
		chaField.setColumns(10);
		chaField.setBounds(150, 400, 300, 26);
		panel.add(chaField);
		
		JLabel lblDesc = new JLabel("Description*");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDesc.setBounds(15, 450, 120, 20);
		panel.add(lblDesc);
		
		descField = new JTextField();
		descField.setBounds(15, 477, 435, 108);
		panel.add(descField);
		descField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(15, 625, 198, 46);
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				String name = nameField.getText().toLowerCase();
				String race = raceField.getText().toLowerCase();
				String gender = genderField.getText().toLowerCase();
				String charClass = classField.getText().toLowerCase();
				String strString = strField.getText().toLowerCase();
				String dexString = dexField.getText().toLowerCase();
				String iQString = iQField.getText().toLowerCase();
				String chaString = chaField.getText().toLowerCase();
				String description = descField.getText().toLowerCase();
				
				int str = Integer.parseInt(strString);
				int dex = Integer.parseInt(dexString);
				int iQ = Integer.parseInt(iQString);
				int cha = Integer.parseInt(chaString);
				
				
				
				StatHolder statHolder = new StatHolder(str, dex, iQ, cha);
				
				Character character = new Character(name, race, gender, charClass, description, statHolder);
				
				
				//Each character has an entry in the character table, and an entry in the baseStats table.
				//Each character also has 2 unique tables for their inventory and ability list
				
				//the character table contains a reference to the characters entry on the base stats table, so each characters details needs
				//to be added to the base stats table first

				//populate the base stats table
				String queryStats = "INSERT INTO characterbasestats(str, hp, dex, luck, iq, per, cha, will) VALUES  ('"
						+ character.getStatHolder().getBaseStr()+"', '"
						+ character.getStatHolder().getBaseMaxHP()+"', '"
						+ character.getStatHolder().getBaseDex()+"', '"
						+ character.getStatHolder().getBaseLuck()+"', '"
						+ character.getStatHolder().getBaseIQ()+"', '"
						+ character.getStatHolder().getBasePer()+"', '"
						+ character.getStatHolder().getBaseCha()+"', '"
						+ character.getStatHolder().getBaseWill()+"')";
				
				db.executeQuery(queryStats);
				
				//return the id from the stats table
				int statsId = db.ReturnLatestId("characterbasestats");
				
				//add the character to the character table, including the base stats ID we just returned
				
				String queryAddCharacter = "INSERT INTO characters (name, race, gender, class, description, basestatsid) VALUES ('"
						+ character.getName()+"', '"
						+ character.getRace()+"', '"
						+ character.getGender()+"', '"
						+ character.getCharClass()+"', '"
						+ character.getDescription()+"', '"
						+ statsId+"')";
				
				db.executeQuery(queryAddCharacter);
				
				//return the id from the character table for naming the inventory and ability tables
				int characterId = db.ReturnLatestId("characters");
				
				//create this characters inventory table
				
				String stmtCreateInventory = "CREATE TABLE inventory"+characterId +"(name varchar, type varchar,"
						+ "equipped bool, itemid int)";
				db.executeQuery(stmtCreateInventory);
				
				//create this characters abilities table
				
				String stmtCreateAbilities = "CREATE TABLE abilities"+characterId +"(name varchar, type varchar,"
						+ "abilityid int)";
				db.executeQuery(stmtCreateAbilities);
				
				
			}
		});
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(252, 625, 198, 46);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{	
				frame.setVisible(false);
				frame.dispose();
			}
		});
		panel.add(btnCancel);
		
		JLabel lblFieldsMarkedWith = new JLabel("Fields marked with * are optional");
		lblFieldsMarkedWith.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFieldsMarkedWith.setBounds(15, 589, 320, 20);
		panel.add(lblFieldsMarkedWith);
		
		frame.setVisible(true);
	}
	
}
