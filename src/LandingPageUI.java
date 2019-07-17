import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LandingPageUI {
	JFrame frame;
	
	
	
	public LandingPageUI() 
	{
		
		
		SqliteDB db = new SqliteDB();
		frame = new JFrame();
		
		JButton btnCharacters = new JButton("Characters");
		btnCharacters.setBounds(15,40,350,40);
		btnCharacters.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				new CharacterListUI(db);
			}
			
		});
		frame.add(btnCharacters);
		
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		JButton btnItems= new JButton("Items");
		btnItems.setBounds(15,140,350,40);
		btnItems.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				new ItemListUI(db);
			}
			
		});
		frame.add(btnItems);
		
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		JButton btnAbilities= new JButton("Abilities");
		btnAbilities.setBounds(15,240,350,40);
		btnAbilities.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{}
			
		});
		frame.add(btnAbilities);
		
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
