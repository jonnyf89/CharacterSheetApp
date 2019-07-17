import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;

//public class TableFromDatabase extends JFrame 
public class TableFromDatabase extends JPanel 
{
	//JFrame frame;
	/*public static void main(String[] args)
    {
		SqliteDB db = new SqliteDB();
        TableFromDatabase table = new TableFromDatabase(db, "weapons");
        JFrame frame = new JFrame();
        frame.add(table);
        frame.pack();
        frame.setVisible(true);
        //JFrame frame = new JFrame();
        //frame.getContentPane().add(table);
        //frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //frame.pack();
        //frame.setVisible(true);
    }*/
	
	public TableFromDatabase(SqliteDB db, String tableName) 
	{
		
		Vector<Object> columnNames = new Vector<Object>();
		Vector<Object> data = new Vector<Object>();
	
		try 
		{
			// read the database
		
			ResultSet rs = db.returnResultSet(tableName);
		
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
		
		
			// Get column names
		
			for(int i = 1; i <= columns; i++)
			{
				columnNames.addElement(md.getColumnName(i));
			}
			//get row data
			while (rs.next())
			{
				Vector<Object> row = new Vector<Object>(columns);
				
				for (int i = 1; i <= columns; i++)
				{
					row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
			db.closeConnection();
		} catch (Exception e) 
		{
			System.out.println("Error8 " + e.getMessage());	
		}
		//Create table with database data
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames)
		{
			//@Override
			public Class getColumnNames(int column)
			{
				for (int row = 0; row < getRowCount(); row ++)
				{
					Object o = getValueAt(row, column);
					
					if(o!= null)
					{
						return o.getClass();
					}
				}
				return Object.class;
			}
			
		};
		
		this.setLayout(new BorderLayout());
		JTable table = new JTable(model) {
			public boolean getScrollableTracksViewportWidth() {
				return getPreferredSize().width < getParent().getWidth();
			 }
			};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); 
		JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVisible(true);
		add(scrollPane);
		//getContentPane().add(scrollPane);
		//getRootPane().add(scrollPane);//replaces above line
		
		//JPanel buttonPanel = new JPanel();
		//getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		//more to do, check the webpage
		//http://www.camick.com/java/source/TableFromDatabase.java
	}
	
	
}
