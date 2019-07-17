import java.util.ArrayList;
import java.util.Iterator;

public class CharacterList {

	ArrayList<Character> characterList;
	//Iterator i = characterList.iterator();
	
	public CharacterList(SqliteDB db)
	{
		characterList = db.returnCharacters();
		
	}
	
	
	public ArrayList<Character> returnCharacterList()
	{
		return characterList;
	}
	/*public Object[][] returnData()
	{
		Object[][] tableData;
		String[] row;
		while(i.hasNext())
		{
			int position = Integer.parseInt(i);
			Character tmpCharacter = CharacterList.get(i);
			row = {characterList(i).getName()};
		}
		return null;
	}*/
}
