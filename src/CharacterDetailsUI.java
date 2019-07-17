import java.util.ArrayList;

import javax.swing.JFrame;

public class CharacterDetailsUI {
	JFrame frame;
	public CharacterDetailsUI() 
	{
		SqliteDB db = new SqliteDB();
		
		/*CharacterList characterList = new CharacterList(db);
		ArrayList<Character> characterListArray;
		characterListArray = characterList.returnCharacterList();*/
		
		TableFromDatabase frame = new TableFromDatabase(db, "characters");
        //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
		
	}
}
