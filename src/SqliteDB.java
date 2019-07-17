import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqliteDB 
{
	Connection c = null;
	Statement stmt = null;

	SqliteDB()
	{
		initialise();
	}
	
	public void initialise()
	{
		//try connection to DB
				try
				{
					Class.forName("org.sqlite.JDBC");
					c = DriverManager.getConnection("jdbc:sqlite:CharacterSheetDB.sqlite");
					System.out.println("Connected to DB");
				}catch (Exception e)
				{
					System.out.println("Error in SqliteDB, initialize(). Error: " + e.getMessage());	
				}
	}
	
	public void closeConnection() 
	{
		try 
		{
			c.close();
			System.out.println("Connection Closed");
		}catch (Exception e)
		{
			System.out.println("Error3 " + e.getMessage());	
		}
	}
	//not sure about the below
	public void refreshConnection() {
		if (c == null) {
			initialise();
		}
	}
	
	public void executeQuery(String query)
	{
		try 
		{
			refreshConnection();
			//this line is repeated from above so sort that out
			this.stmt = c.createStatement();
			stmt.executeUpdate(query);
		}catch (Exception e)
		{
			System.out.println("Error4 " + e.getMessage());	
		}
	}
	
	public void listCharacters()
	{
		try 
		{
			refreshConnection();
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Characters");
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String basestr = rs.getString("basestr");
				String str = rs.getString("str");
				String basemaxhp = rs.getString("basemaxhp");
				String maxhp = rs.getString("maxhp");
				String basedex = rs.getString("basedex");
				String dex = rs.getString("dex");
				String baseluck = rs.getString("baseluck");
				String luck = rs.getString("luck");
				String baseiq = rs.getString("baseiq");
				String iq = rs.getString("iq");
				String baseper = rs.getString("baseper");
				String per = rs.getString("per");
				String basecha = rs.getString("basecha");
				String cha = rs.getString("cha");
				String ar = rs.getString("ar");
				String mr = rs.getString("mr");
				
				System.out.println(id + ", Name: " + name + ", \nStr: " + str + ", \nDex: "
				+ dex + ", \nIQ: " + iq + ", \nCha: " + cha);
				
			}
			
		}catch (Exception e)
		{
			System.out.println("Error2 " + e.getMessage());
		}
	}
		
		public ArrayList<Character> returnCharacters()
		{
			ArrayList<Character> characterList = new ArrayList<Character>();
			try 
			{
				ResultSet rs = returnResultSet("characters");
				
				while(rs.next())
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String basestrString = rs.getString("basestr");
					String strString = rs.getString("str");
					String basemaxhpString = rs.getString("basemaxhp");
					String maxhpString = rs.getString("maxhp");
					String basedexString = rs.getString("basedex");
					String dexString = rs.getString("dex");
					String baseluckString = rs.getString("baseluck");
					String luckString = rs.getString("luck");
					String baseiqString = rs.getString("baseiq");
					String iqString = rs.getString("iq");
					String baseperString = rs.getString("baseper");
					String perString = rs.getString("per");
					String basechaString = rs.getString("basecha");
					String chaString = rs.getString("cha");
					String basewillString = rs.getString("basewill");
					String willString = rs.getString("will");
					String arString = rs.getString("ar");
					String mrString = rs.getString("mr");
					
					int basestr = Integer.parseInt(basestrString);
					int str = Integer.parseInt(strString);
					int basemaxhp = Integer.parseInt(basemaxhpString);
					int maxhp = Integer.parseInt(maxhpString);
					int basedex = Integer.parseInt(basedexString);
					int dex = Integer.parseInt(dexString);
					int baseluck = Integer.parseInt(baseluckString);
					int luck = Integer.parseInt(luckString);
					int baseiq = Integer.parseInt(baseiqString);
					int iq = Integer.parseInt(iqString);
					int baseper = Integer.parseInt(baseperString);
					int per = Integer.parseInt(perString);
					int basecha = Integer.parseInt(basechaString);
					int cha = Integer.parseInt(chaString);
					int basewill = Integer.parseInt(basewillString);
					int will = Integer.parseInt(willString);
					int ar = Integer.parseInt(arString);
					int mr = Integer.parseInt(mrString);
					
					
					
					StatHolder tmpStatHolder = new StatHolder(basestr, str, basemaxhp, maxhp,
							basedex, dex, baseluck, luck, baseiq, iq, baseper, per,
							basecha, cha, basewill, will, ar, mr);
					Character tmpCharacter = new Character(name, tmpStatHolder);
					
					characterList.add(tmpCharacter);
					
				}
				
			}catch (Exception e)
			{
				System.out.println("Error5 " + e.getMessage());	
			}
			return characterList;
	}
		public ResultSet returnResultSet(String table)
		{
			ResultSet rs = null;
			try 
			{
				refreshConnection();
				this.stmt = c.createStatement();
				rs = stmt.executeQuery("SELECT * FROM "+ table);
			}catch (Exception e)
			{
				System.out.println("Error7 " + e.getMessage());	
			}
			return rs;
		}
		
		//pass a column name and table name in and return all its values as an arraylist of strings
		public ArrayList<String> ReturnColumn(String column, String table) 
		{
			ArrayList<String> result= new ArrayList<String>();
			String columnUpper = column.toUpperCase();
			try 
			{
				refreshConnection();
				this.stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT " + columnUpper +" FROM " + table);
				
				while(rs.next())
				{
					String name = rs.getString("name");
					//why is this inputting name instead of the column variable?
					
					result.add(name);
				}
				//result = (ArrayList<String>) stmt.executeQuery("SELECT " + columnUpper +" FROM Characters");
			}catch(Exception e)
			{
				System.out.println("Error returningColumn in SqliteDB: " + e.getMessage());
			}
			
			return result;
		}
		
		//pass a column name, table name and search parameter in and return all its values as an arraylist of strings
				public ArrayList<String> ReturnColumn(String column, String table, String otherColumn, String searchValue) 
				{
					ArrayList<String> result= new ArrayList<String>();
					String columnUpper = column.toUpperCase();
					try 
					{
						refreshConnection();
						this.stmt = c.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT " + columnUpper +" FROM " + table + " WHERE " + otherColumn + " = '" + searchValue + "'");
						
						while(rs.next())
						{
							String name = rs.getString("name");
							//why is this inputting name instead of the column variable?
							
							result.add(name);
						}
						//result = (ArrayList<String>) stmt.executeQuery("SELECT " + columnUpper +" FROM Characters");
					}catch(Exception e)
					{
						System.out.println("Error returningColumn in SqliteDB: " + e.getMessage());
					}
					
					return result;
				}
				
		
		public int ReturnLatestId(String table)
		{
			int latestId = 0;
			try 
			{
				refreshConnection();
				this.stmt = c.createStatement();
				//ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM " + table);
				
				//ResultSet rs = stmt.executeQuery("SELECT * FROM characterbasestats");
				//latestId = rs.getInt("id");
				//System.out.println(latestId);
				table = table.toLowerCase();
				
				ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM "+ table);
				
				int id2 = 0; 
				if (rs.next() )
				{
				   id2 = rs.getInt(1);  
				}
				//System.out.println(id2);
				latestId = id2;
			}catch(Exception e)
			{
				System.out.println("Error returning latest Id in SQLiteDB.java: " 
						+ e.getMessage());
			}
			if (latestId == 0) 
			{
			System.out.println("latestID = 0");
			}
			return latestId;
		}
		
		
		public ResultSet RowFromName(String name, String table)
		{
			ResultSet rs = null;
			try 
			{
				refreshConnection();
				this.stmt = c.createStatement();
				rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE name = '"+name+"'");
				System.out.println(("SELECT * FROM " + table + " WHERE name = '"+name+"'"));
			}catch(Exception e) 
			{
				System.out.println("Error in RowFromName in SqliteDB. Error: " + e.getMessage());
			}
			
			return rs;
			
		}
		public ResultSet RowFromId(int id)
		{
			ResultSet rs = null;
			try
			{
				refreshConnection();
				this.stmt = c.createStatement();
				rs = stmt.executeQuery("SELECT * FROM Characters WHERE id = "+id);
			}catch(Exception e) 
			{
				System.out.println("Error in RowFromName in SqliteDB. Error: " + e.getMessage());
			}
			
			return rs;
	
		}
		public ResultSet RowFromId(int id, String table)
		{
			ResultSet rs = null;
			try
			{
				refreshConnection();
				this.stmt = c.createStatement();
				rs = stmt.executeQuery("SELECT * FROM "+table+" WHERE id = "+id);
			}catch(Exception e) 
			{
				System.out.println("Error in RowFromName in SqliteDB. Error: " + e.getMessage());
			}
			
			return rs;
	
		}
		
		/*public int idFromName(String table, String name) 
		{
			//String query = "SELECT (id) FROM "+table+" WHERE name = '"+name+"'";
			int id;
			try
			{
				this.stmt = c.createStatement();
				id = stmt.executeQuery("SELECT (id) FROM "+table+" WHERE name = '"+name+"'");
			}catch(Exception e)
			{
				System.out.println("Error in idFromName in SqliteDB. Error: " + e.getMessage());	
			}
		}*/
		
		public void equipItem(int id, int tableNumber) 
		{
			try 
			{
				refreshConnection();
				
				String query = "UPDATE inventory"+tableNumber+" SET equipped = 1 WHERE rowid = "+id;
				this.stmt = c.createStatement();
				stmt.executeUpdate(query);
			}catch (Exception e)
			{
				System.out.println("Error in equipItem in SqliteDB. Error: " + e.getMessage());	
			}
		}
		
		public void equipItem(String name, int tableNumber) 
		{
			try 
			{
				refreshConnection();
				
				String query = "UPDATE inventory"+tableNumber+" SET equipped = 1 WHERE name = '"+name+"'";
				System.out.println(query);
				this.stmt = c.createStatement();
				stmt.executeUpdate(query);
			}catch (Exception e)
			{
				System.out.println("Error in equipItem in SqliteDB. Error: " + e.getMessage());	
			}
		}

		public void UnEquipItem(int id, int tableNumber) 
		{
			try 
			{
				refreshConnection();
				
				String query = "UPDATE inventory"+tableNumber+" SET equipped = 0 WHERE rowid = "+id;
				this.stmt = c.createStatement();
				stmt.executeUpdate(query);
			}catch (Exception e)
			{
				System.out.println("Error in equipItem in SqliteDB. Error: " + e.getMessage());	
			}
		}
		public void UnEquipItem(String name, int tableNumber) 
		{
			try 
			{
				refreshConnection();
				
				String query = "UPDATE inventory"+tableNumber+" SET equipped = 0 WHERE name = '"+name+"'";
				this.stmt = c.createStatement();
				stmt.executeUpdate(query);
			}catch (Exception e)
			{
				System.out.println("Error in equipItem in SqliteDB. Error: " + e.getMessage());	
			}
		}
		public Boolean IsEquiped(String itemName, int tableNumber) 
		{
			int equippedInt = 3;
			Boolean equippedBool = null;
			String query = "SELECT * FROM inventory"+tableNumber+ " WHERE name = '" + itemName + "'";
			System.out.println(query);
			//why does this always return 0?
			try {
				ResultSet rsInventory = stmt.executeQuery(query);
				equippedInt = rsInventory.getInt("equipped");
				//equippedBool = stmt.execute(query);
				System.out.println(equippedInt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (equippedInt == 0)
			{
				equippedBool = false;
			}else if (equippedInt == 1) 
			{
				equippedBool = true;
			}
			else 
			{
				System.out.println("Something wrong, bool not returning true or false in IsEquiped in SqliteDB");
			}
			System.out.println(equippedBool);
			return equippedBool;
			
		}

}
