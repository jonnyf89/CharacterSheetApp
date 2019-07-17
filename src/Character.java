
public class Character {

	
	//Character has a stat holder object
	private String name;
	private String race;
	private String gender;
	private String charClass;
	private String description;
	private StatHolder statHolder;
	
	//Getters
	public String getName() 
	{
		return name;
	}
	public String getRace() 
	{
		return race;
	}
	public String getGender() 
	{
		return gender;
	}
	public String getCharClass()
	{
		return charClass;
	}
	public String getDescription() 
	{
		return description;
	}
	public StatHolder getStatHolder() 
	{
		return statHolder;
	}
	
	//constructors
	public Character(String name, String race, String gender)
	{
		this.name = name;
		this.race = race;
		this.gender = gender;
	}
	public Character(String name, StatHolder statHolder)
	{
		this.name = name;
		this.statHolder = statHolder;
	}
	public Character(String name, String race, String gender, String charClass, String description, StatHolder statHolder)
	{
		this.name = name;
		this.race = race;
		this.gender = gender;
		this.charClass = charClass;
		this.description = description;		
		this.statHolder = statHolder;
	}
}
