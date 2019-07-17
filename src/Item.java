
public class Item {

	//item has a statChanger
	private String name;
	private String description;
	private StatChanger statChanger;

	//Getters
	public String getName()
	{
		return this.name;
	}
	public String getDescription()
	{
		return this.description;
	}
	public StatChanger getStatChanger()
	{
		return this.statChanger;
	}
	
	//Setters
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public void setStatChanger(StatChanger statChanger)
	{
		this.statChanger = statChanger;
	}
	
	//Constructors
	public Item(String name, StatChanger statChanger)
	{
		this.name = name;
		this.statChanger = statChanger;
	}
	
	
	
	
}
