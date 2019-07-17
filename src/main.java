import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new GUI();
		
		new LandingPageUI();
		
	//	SqliteDB db = new SqliteDB();
	
		/*Scanner reader = new Scanner(System.in);
		System.out.println("Enter Character Name:");
		String name = reader.next();
		
		System.out.println("Enter Character Strength:");
		int str = reader.nextInt();
		System.out.println("Enter Character Dexterity:");
		int dex = reader.nextInt();
		System.out.println("Enter Character Intelligence:");
		int iQ = reader.nextInt();
		System.out.println("Enter Character Charisma:");
		int cha = reader.nextInt();
		
		StatHolder statHolder = new StatHolder(str, dex, iQ, cha);
		Character character = new Character(name, statHolder);
		
		System.out.println("Enter "+ character.GetName() +"'s Weapon:");
		String itemName = reader.next();
		System.out.println("Enter "+ itemName +"'s Strength Modifier:");
		int itemStr = reader.nextInt();
		
		StatChanger statChanger = new StatChanger(itemStr);
		Item weapon = new Item(itemName, statChanger);
		
		int TotalStr = character.GetStatHolder().GetStr() + weapon.GetStatChanger().getStr();
		
		character.GetStatHolder().SetStr(TotalStr); 
		
		System.out.println("Name: " + character.GetName() + "\n"
				+ "Base Str: " + character.GetStatHolder().GetStr() + "\n"
				+ "Base Dex: " + character.GetStatHolder().GetDex() + "\n"
				+ "Base IQ: " + character.GetStatHolder().GetIQ() + "\n"
				+ "Base Cha: " + character.GetStatHolder().GetCha() + "\n"
				+ "Total Str: " + TotalStr
				);
		
		/*
		System.out.println("Enter Character Race:");
		String race = reader.next();
		
		System.out.println("Enter Character Gender:");
		String gender = reader.next();
		
		System.out.println("Enter Character Gender:");
		String gender = reader.next();
		*/
		
		/*
		Character character = new Character(name, race, gender);
		System.out.println("Character Name: " + character.name + "\n" 
				+ "Character Race: " + character.race + "\n"
				+ "Character Gender: " + character.gender);
		*/
		

	}

}
