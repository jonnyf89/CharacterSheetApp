import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CharacterLandingUI {

	JFrame frame;
	
	public CharacterLandingUI()
	{
		frame = new JFrame();
		
		JButton btnNewCharacter = new JButton("Create New Character");
		btnNewCharacter.setBounds(15,40,350,40);
		btnNewCharacter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
			//	new CharacterCreationUI2(db);
				frame.setVisible(false);
				frame.dispose();
			}
			
		});
		frame.add(btnNewCharacter);
		
		JButton btnViewCharacters = new JButton("View Characters");
		btnViewCharacters.setBounds(15,140,350,40);
		btnViewCharacters.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				new CharacterDetailsUI();
			}
			
		});
		frame.add(btnViewCharacters);
		
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
