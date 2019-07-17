
public class StatChanger {

	//Attributes
	//the changer doesnt need base and current values
	//public int baseStr;
	public int str;
	//public int baseMaxHP;
	public int maxHP;
	//public int baseDex;
	public int dex;
	//public int baseLuck;
	public int luck;
	//public int baseIQ;
	public int iQ;
	//public int basePer;
	public int per;
	//public int baseCha;
	public int cha;
	//public int baseWill;
	public int will;
	//public int baseAr;
	public int ar;
	//public int baseMR;
	public int mR;
	//public int baseAgility;
	public int agility;
	//public int baseIntimidation;
	public int intimidation;
	//public int baseLeadership;
	public int leadership;

	
	//Getters
/*	public int getBaseStr() 
	{
		return this.baseStr;
	}
	public int getBaseMaxMP() 
	{
		return this.baseMaxHP;
	}
	public int getBaseDex() 
	{
		return this.baseDex;
	}
	public int getBaseLuck() 
	{
		return this.baseLuck;
	}
	public int getBaseIQ() 
	{
		return this.baseIQ;
	}
	public int getBasePer() 
	{
		return this.basePer;
	}
	public int getBaseCha() 
	{
		return this.baseCha;
	}
	public int getBaseWill() 
	{
		return this.baseWill;
	}
	public int getBaseAr() 
	{
		return this.baseAr;
	}
	public int getBaseMR() 
	{
		return this.baseMR;
	}
	public int getBaseIntimidation() 
	{
		return this.baseIntimidation;
	}
	public int getBaseLeadership() 
	{
		return this.baseLeadership;
	}*/
	public int getStr() 
	{
		return this.str;
	}
	public int getMaxMP() 
	{
		return this.maxHP;
	}
	public int getDex() 
	{
		return this.dex;
	}
	public int getLuck() 
	{
		return this.luck;
	}
	public int getIQ() 
	{
		return this.iQ;
	}
	public int getPer() 
	{
		return this.per;
	}
	public int getCha() 
	{
		return this.cha;
	}
	public int getWill() 
	{
		return this.will;
	}
	public int getAr() 
	{
		return this.ar;
	}
	public int getMR() 
	{
		return this.mR;
	}
	public int getIntimidation() 
	{
		return this.intimidation;
	}
	public int getLeadership() 
	{
		return this.leadership;
	}
	
	//Setters
	/*public void setBaseStr(int baseStr)
	{
		this.baseStr = baseStr;
	}
	public void setBaseMaxHP(int baseMaxHP )
	{
		this.baseMaxHP = baseMaxHP ;
	}
	public void setBaseDex(int baseDex)
	{
		this.baseDex = baseDex;
	}
	public void setBaseLuck(int baseLuck)
	{
		this.baseLuck = baseLuck;
	}
	public void setBaseIQ(int baseIQ)
	{
		this.baseIQ = baseIQ;
	}
	public void setBasePer(int basePer)
	{
		this.basePer = basePer;
	}
	public void setBaseCha(int baseCha)
	{
		this.baseCha = baseCha;
	}
	public void setBaseWill(int baseWill)
	{
		this.baseWill = baseWill;
	}
	public void setBaseAr(int baseAr)
	{
		this.baseAr = baseAr;
	}
	public void setBaseMR(int baseMR)
	{
		this.baseMR = baseMR;
	}
	public void setBaseIntimidation(int baseIntimidation)
	{
		this.baseIntimidation = baseIntimidation;
	}
	public void setBaseLeadership(int baseLeadership)
	{
		this.baseLeadership = baseLeadership;
	}*/
	public void setStr(int str)
	{
		this.str = str;
	}
	public void setMaxHP(int maxHP )
	{
		this.maxHP = maxHP ;
	}
	public void setDex(int dex)
	{
		this.dex = dex;
	}
	public void setLuck(int luck)
	{
		this.luck = luck;
	}
	public void setIQ(int iQ)
	{
		this.iQ = iQ;
	}
	public void setPer(int per)
	{
		this.per = per;
	}
	public void setCha(int cha)
	{
		this.cha = cha;
	}
	public void setWill(int will)
	{
		this.will = will;
	}
	public void setAr(int ar)
	{
		this.ar = ar;
	}
	public void setMR(int mR)
	{
		this.mR = mR;
	}
	public void setAgility(int agility)
	{
		this.agility = agility;
	}
	public void setIntimidation(int intimidation)
	{
		this.intimidation = intimidation;
	}
	public void setLeadership(int leadership)
	{
		this.leadership = leadership;
	}
	
	//Constructors
	public StatChanger(int str)
	{
		this.str = str;
	}
	
	public StatChanger(int str, int hp, int dex, int luck, int iq, int per, int cha, 
			int will, int ar, int mr, int agility, int intimidation, int leadership)
	{
		this.str = str;
		this.maxHP = hp;
		this.dex = dex;
		this.luck = luck;
		this.iQ = iq;
		this.per = per;
		this.cha = cha;
		this.will = will;
		this.ar = ar;
		this.mR = mr;
		this.agility = agility;
		this.intimidation = intimidation;
		this.leadership = leadership;
		
	}
	
}
