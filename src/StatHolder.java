
public class StatHolder {
	//Attributes
	//The holder needs base and current values
	public int baseStr;
	public int str;
	public int baseMaxHP;
	public int maxHP;
	public int baseDex;
	public int dex;
	public int baseLuck;
	public int luck;
	public int baseIQ;
	public int iQ;
	public int basePer;
	public int per;
	public int baseCha;
	public int cha;
	public int baseWill;
	public int will;
	public int baseAr;
	public int ar;
	public int baseMR;
	public int mR;
	public int baseAgility;
	public int agility;
	public int baseIntimidation;
	public int intimidation;
	public int baseLeadership;
	public int leadership;

	
	//Getters
	public int getBaseStr() 
	{
		return this.baseStr;
	}
	public int getBaseMaxHP() 
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
	}
	public int getStr() 
	{
		return this.str;
	}
	public int getMaxHP() 
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
	public void setBaseStr(int baseStr)
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
	}
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
	public void setIntimidation(int intimidation)
	{
		this.intimidation = intimidation;
	}
	public void setLeadership(int leadership)
	{
		this.leadership = leadership;
	}	
	/*private int str;
		private int maxHP;
		private int dex;
		private int luck;
		private int iQ;
		private int per;
		private int cha;
		private int will;
		private int ar;
		private int mR;
		private int agility;
		private int intimidation;
		private int leadership;
		
		//Getters
		public int GetStr() 
		{
			return this.str;
		}
		public int GetMaxMP() 
		{
			return this.maxHP;
		}
		public int GetDex() 
		{
			return this.dex;
		}
		public int GetLuck() 
		{
			return this.luck;
		}
		public int GetIQ() 
		{
			return this.iQ;
		}
		public int GetPer() 
		{
			return this.per;
		}
		public int GetCha() 
		{
			return this.cha;
		}
		public int GetWill() 
		{
			return this.will;
		}
		public int GetAr() 
		{
			return this.ar;
		}
		public int GetMR() 
		{
			return this.mR;
		}
		public int GetIntimidation() 
		{
			return this.intimidation;
		}
		public int GetLeadership() 
		{
			return this.leadership;
		}
		
		//Setters
		public void SetStr(int str)
		{
			this.str = str;
		}
		public void SetMaxHP(int maxHP )
		{
			this.maxHP = maxHP ;
		}
		public void SetDex(int dex)
		{
			this.dex = dex;
		}
		public void SetLuck(int luck)
		{
			this.luck = luck;
		}
		public void SetIQ(int iQ)
		{
			this.iQ = iQ;
		}
		public void SetPer(int per)
		{
			this.per = per;
		}
		public void SetCha(int cha)
		{
			this.cha = cha;
		}
		public void SetWill(int will)
		{
			this.will = will;
		}
		public void SetAr(int ar)
		{
			this.ar = ar;
		}
		public void SetMR(int mR)
		{
			this.mR = mR;
		}
		public void SetIntimidation(int intimidation)
		{
			this.intimidation = intimidation;
		}
		public void SetLeadership(int leadership)
		{
			this.leadership = leadership;
		}*/

		//Constructors
	public StatHolder(int baseStr, int baseDex, int baseIQ, int baseCha)
	{
		this.baseStr = baseStr;
		this.baseDex = baseDex;
		this.baseIQ = baseIQ;
		this.baseCha = baseCha;
		
		this.baseMaxHP = baseStr;
		this.baseLuck = baseDex;
		this.basePer = baseIQ;
		this.baseWill = baseCha;
		
		/*this.str = this.baseStr;
		this.dex = this.baseDex;
		this.iQ = this.baseIQ;
		this.cha = this.baseCha;*/
	}	
	
	public StatHolder(int baseStr, int str, int baseMaxHP, int maxHP, int baseDex, int dex,
			int baseLuck, int luck, int baseIQ, int iQ, int basePer, int per, 
			int baseCha, int baseWill, int will, int cha, int ar, int mr)
	{
		this.baseStr = baseStr;
		this.str = str;
		this.baseMaxHP = baseMaxHP;
		this.maxHP = maxHP;
		this.baseDex = baseDex;
		this.dex = dex;
		this.baseLuck = baseLuck;
		this.luck = luck;
		this.baseIQ = baseIQ;
		this.iQ = iQ;
		this.basePer = basePer;
		this.per = per;
		this.baseCha = baseCha;
		this.cha = cha;
		this.baseWill = baseWill;
		this.will = will;
		this.ar = ar;
		this.mR = mr;
		
		
		this.str = this.baseStr;
		this.dex = this.baseDex;
		this.iQ = this.baseIQ;
		this.cha = this.baseCha;
	}	
	/*public StatHolder(int str, int dex, int iQ, int cha)
		{
			this.str = str;
			this.dex = dex;
			this.iQ = iQ;
			this.cha = cha;
		}*/

}
