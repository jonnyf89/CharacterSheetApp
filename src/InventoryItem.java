import java.util.ArrayList;

public class InventoryItem {
	private String name;
	private boolean equipped;
	private ArrayList<String> effectedStats;
	private ArrayList<Integer> statEffects;
	private String weaponArt;
	private String description;

	
	//ctor
	public InventoryItem(String name, boolean equipped, ArrayList<String> effectedStats, ArrayList<Integer> statEffects,
			String weaponArt, String description)
	{
		this.name = name;
		this.equipped = equipped;
		this.effectedStats = effectedStats;
		this.statEffects = statEffects;
		this.weaponArt = weaponArt;
		this.description = description;
	}

	//getters
	public String getName() 
	{
		return name;
	}
	public boolean getEquipped() 
	{
		return equipped;
	}
	public ArrayList<String> getEffectedStats() 
	{
		return effectedStats;
	}
	public ArrayList<Integer> getStatEffects() 
	{
		return statEffects;
	}
	public String getWeaponArt()
	{
		return weaponArt;
	}
	public String getDescription() 
	{
		return description;
	}
	
	//setters
	//not sure if we need these here
/*	public void setName(String name) 
	{
		this.name = name;
	}
	public void setEquipped(boolean equipped) 
	{
		this.equipped = equipped;
	}
	public void setEffectedStats(ArrayList<String> effectedStats)
	{
		this.effectedStats = effectedStats;
	}
	public void setStatEffects(ArrayList<Integer> statEffects) 
	{
		this.statEffects = statEffects;
	}*/
}
