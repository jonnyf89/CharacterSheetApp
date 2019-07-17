import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class CharacterCreationUI {
	JFrame frame;
	
	//ctor
	public CharacterCreationUI()
	{
		SqliteDB db = new SqliteDB();
		
		frame = new JFrame();
		ArrayList<Character> characterList = new ArrayList<Character>();

		//Name label
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(20,60,150,40);
		frame.add(nameLabel);
		
		//Name field
		JTextField nameField = new JTextField();
		nameField.setBounds(160,60,100,40);
		frame.add(nameField);

			
		
		//str label
		JLabel strLabel = new JLabel("Strength");
		strLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		strLabel.setBounds(20,100,150,40);
		frame.add(strLabel);
		
		//str field
		JTextField strField = new JTextField();
		strField.setBounds(160,100,100,40);
		frame.add(strField);

		JLabel dexLabel = new JLabel("Dexterity");
		dexLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dexLabel.setBounds(20,140,150,40);
		frame.add(dexLabel);
		
		JTextField dexField = new JTextField();
		dexField.setBounds(160,140,100,40);
		frame.add(dexField);
		
		JLabel iQLabel = new JLabel("Intelligence");
		iQLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		iQLabel.setBounds(20,180,150,40);
		frame.add(iQLabel);
		
		JTextField iQField = new JTextField();
		iQField.setBounds(160,180,100,40);
		frame.add(iQField);
		
		JLabel chaLabel = new JLabel("Charisma");
		chaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chaLabel.setBounds(20,220,150,40);
		frame.add(chaLabel);
		
		JTextField chaField = new JTextField();
		chaField.setBounds(160,220,100,40);
		frame.add(chaField);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(20,260,150,40);
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				String name = nameField.getText();
				String strString = strField.getText();
				String dexString = dexField.getText();
				String iQString = iQField.getText();
				String chaString = chaField.getText();
				
				int str = Integer.parseInt(strString);
				int dex = Integer.parseInt(dexString);
				int iQ = Integer.parseInt(iQString);
				int cha = Integer.parseInt(chaString);
				
				
				
				StatHolder statHolder = new StatHolder(str, dex, iQ, cha);
				
				Character character = new Character(name, statHolder);
				characterList.add(character);
				
				/*System.out.println("Character Name is :" + character.getName());
				System.out.println("Character Strength is :" + character.getStatHolder().getStr());
				System.out.println("Character Dexterity is :" + character.getStatHolder().getDex());
				System.out.println("Character Intelligence is :" + character.getStatHolder().getIQ());
				System.out.println("Character Charisma is :" + character.getStatHolder().getCha());
				*/
				String query = "INSERT INTO Characters (name, basestr, str, basemaxhp, maxhp, "
						+ "basedex, dex, baseluck, luck, baseiq, iq, baseper, per, basecha, "
						+ "cha, basewill, will, ar, mr) VALUES ('" + character.getName()+"', '"
						 + character.getStatHolder().getBaseStr()+"', '"
						 + character.getStatHolder().getStr()+"', '"
						 + character.getStatHolder().getBaseMaxHP()+"', '"
						 + character.getStatHolder().getMaxHP()+"', '"
						 + character.getStatHolder().getBaseDex()+"', '"
						 + character.getStatHolder().getDex()+"', '"
						 + character.getStatHolder().getBaseLuck()+"', '"
						 + character.getStatHolder().getLuck()+"', '"
						 + character.getStatHolder().getBaseIQ()+"', '"
						 + character.getStatHolder().getIQ()+"', '"
						 + character.getStatHolder().getBasePer()+"', '"
						 + character.getStatHolder().getPer()+"', '"
						 + character.getStatHolder().getBaseCha()+"', '"
						 + character.getStatHolder().getCha()+"', '"
						 + character.getStatHolder().getBaseWill()+"', '"
						 + character.getStatHolder().getWill()+"', '"
						 + character.getStatHolder().getAr()+"', '"
						 + character.getStatHolder().getMR()+"')";
				
				
				//create row in characterstats table and populate,
				//return the id from this row for the next table.
				//create the charactertable row and populate, include id from stats table
				
				String query2 = "INSERT INTO characterbasestats (str, hp, dex, luck "
						+ "iq, per, cha, will) VALUES ('" + character.getStatHolder().getBaseStr()+"', '"
								+ character.getStatHolder().getBaseMaxHP()+"', '"
								+ character.getStatHolder().getBaseDex()+"', '"
								+ character.getStatHolder().getBaseLuck()+"', '"
								+ character.getStatHolder().getBaseIQ()+"', '"
								+ character.getStatHolder().getBasePer()+"', '"
								+ character.getStatHolder().getBaseCha()+"', '"
								+ character.getStatHolder().getBaseWill()+"')";
										
				db.executeQuery(query2);
				db.listCharacters();
				db.closeConnection();
				
				int id = db.ReturnLatestId("characterbasestats");
			}
		});
		frame.add(btnSubmit);
		
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(200,260,150,40);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				new LandingPageUI();
				frame.setVisible(false);
				frame.dispose();
				
			}
		});
		frame.add(btnBack);
		
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	
	
}
