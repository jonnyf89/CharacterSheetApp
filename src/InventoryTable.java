import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class InventoryTable extends JPanel {
	
	private static DecimalFormat df;
	private DataModel model;
	private JTable table;
	
	private static int characterId;
	private static SqliteDB db;
	
	private static ResultSet rsInventory;

	
	public InventoryTable(ArrayList<String> inventoryItems)
	{
		//DecimalFormat df = new DecimalFormat("#0.00");
		//model = new DataModel(inventoryItems);
		//JTable table = new JTable(model);
		Initialize(inventoryItems);
	}
	
	public InventoryTable(SqliteDB db, int characterId)
	{
		//DecimalFormat df = new DecimalFormat("#0.00");
		//model = new DataModel(inventoryItems);
		//JTable table = new JTable(model);
		
		this.characterId = characterId;
		this.db = db;
		
		rsInventory = db.returnResultSet("inventory"+characterId);
		ArrayList<String> inventoryItems = new ArrayList<String>();
		ArrayList<Boolean> inventoryEquipped = new ArrayList<Boolean>();
		try {
			while(rsInventory.next()) 
			{
				String itemName = rsInventory.getString("name");
				Boolean equipped = rsInventory.getBoolean("equipped");
				inventoryItems.add(itemName);
				}
			} catch (Exception e) {
				System.out.println("Error retrieving inventory in InVentoryTable constructor");
				e.printStackTrace();
			}
		Initialize(inventoryItems);
	}
	private void Initialize(ArrayList<String> inventoryItems) {
		DecimalFormat df = new DecimalFormat("#0.00");
		DataModel model = new DataModel(inventoryItems);
		JTable table = new JTable(model);
		
		this.setLayout(new BorderLayout());
        table.setDefaultRenderer(Value.class, new ValueRenderer());
        table.setDefaultEditor(Value.class, new ValueEditor());
        table.setAutoCreateRowSorter(true);
        table.setRowHeight(24);
        this.add(table.getTableHeader(), BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);

		
	}
	private static class Value implements Comparable<Value> {

        private Boolean selected;
        private Double valueDouble;
        private String valueString;

        public Value(Boolean selected, Double value) {
            this.selected = selected;
            this.valueDouble = value;
        }

        public Value(boolean selected, String value) {
        	this.selected = selected;
            this.valueString = value;
		}

		@Override
        public int compareTo(Value v) {
            return this.valueDouble.compareTo(v.valueDouble);
        }

        /*@Override
        public boolean equals(Object v) {
            return v instanceof Value && this.valueDouble.equals(((Value) v).valueDouble);
        }*/
		 @Override
	        public boolean equals(Object v) {
	            return v instanceof Value && this.valueString.equals(((Value) v).valueString);
	        }

        @Override
        public int hashCode() {
            return this.valueDouble.hashCode();
        }

		public String getValue() {
			return valueString;
		}
    }
	

	private static class DataModel extends AbstractTableModel {

        private static final int MAX = 2;
        private int max;
		private static final String[] names = {"Number", "Item"};
        private List<Value> values = new ArrayList<Value>();
        
        private ArrayList<Value> tickedItems = new ArrayList<Value>();

        public DataModel() {
            for (int i = 0; i < MAX; i++) {
            	
                values.add(new Value(false, (i + 1) * 1.1));
            }
        }
      //  public DataModel(ArrayList<String> itemList) {
     //   	max = itemList.size();
    //        for (int i = 0; i < itemList.size(); i++) {
   //             values.add(new Value(false, itemList.get(i)));
  //              System.out.println(itemList.get(i));
 //           }
//        }
        public DataModel(ArrayList<String> itemList) {
        	/*try {
				while(rsInventory.next())
				{
					String itemName = rsInventory.getString("name");
			    	Boolean equippedBool = rsInventory.getBoolean("equipped");
			    	values.add(new Value(equippedBool, itemName));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        	
        	max = itemList.size();
        	for (int i = 0; i < max; i++)
        	{
        		//instead of setting false by default i should be checking in the inventory.
        		//I have rsInventory which contains all the inventory data.
        		//I have itemList which contains all the names of the inventory items
        		//so I need to iterate through the rs and add the values to below
        		
        		/*try {
					while(rsInventory.next())
					{
						String itemName = rsInventory.getString("name");
				    	Boolean equippedBool = rsInventory.getBoolean("equipped");
				    	values.add(new Value(false, itemList.get(i)));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
        		Boolean equippedBool = db.IsEquiped(itemList.get(i), characterId);
        		//below not working, boxes still come out unticked
        		//bool keeps returning false
        		values.add(new Value(equippedBool, itemList.get(i)));
        	}
        }
	
        @Override
        public int getRowCount() {
            return max;
        }

        @Override
        public int getColumnCount() {
            return names.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            if (col == 0) {
            	//System.out.println("col == 0");
                return row + 1;
            } else if (col == 1) {
            	//System.out.println("col == 1");
                return values.get(row);
            } else {
            	//System.out.println("else");
                return null;
            }
        }

        @Override
        public void setValueAt(Object aValue, int row, int col) {
            if (col == 1) {
            	Boolean isTicked = (Boolean) aValue;//twice
                values.get(row).selected = (Boolean) aValue;
                this.fireTableCellUpdated(row, col);
                Value v = values.get(row);
            	String a = v.getValue();
                if(isTicked == true)
                {
                	tickedItems.add(v);
                	//what I really want it to do is just write to the DB
                	//THis is the place to do it I think, so it's time to 
                	//start actually reading the inventory from the DB
                	
                	db.equipItem(a, characterId);
                }else if (isTicked == false)
                {
                	tickedItems.remove(v);
                	db.UnEquipItem(a, characterId);
                }else
                {
                	System.out.println("Something went wrong, checkbox is neither ticket or unticked in setValueAt in InventoryTable");
                }
                //System.out.println((Boolean) aValue);
            }
        }
       /* @Override
        public void setValueAt(Object aValue, int row, int col) {
            if (col == 1) {
                for (int r = 0; r < getRowCount(); r++) {
                    super.setValueAt(false, r, 1);
                }
            }
            super.setValueAt(aValue, row, col);
            //cp.button.setEnabled(any());    //so enable the button if any of the boxes are ticked
        }
        private boolean any() {				
            boolean result = false;
            for (int r = 0; r < getRowCount(); r++) {		//so this loop checks all the checkboxes for 
                Boolean b = (Boolean) getValueAt(r, 1);		//a true 
                result |= b;
            }
            System.out.println("Result is " + result);
            return result;
        }*/
        

        @Override
        public Class<?> getColumnClass(int col) {
            if (col == 0) {
                return Integer.class;
            } else if (col == 1) {
                return Value.class;
            } else {
                return null;
            }
        }

        @Override
        public String getColumnName(int col) {
            return names[col];
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 1;
        }
    }
	
	private static class ValueRenderer extends JCheckBox
    implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int col) {
        Value v = (Value) value;
        this.setSelected(v.selected);
        //this.setText(df.format(v.valueDouble));
        this.setText(v.valueString);
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        return this;
        }
	}
    
    private class ValueEditor extends AbstractCellEditor
    implements TableCellEditor, ItemListener 
    {
    	private ValueRenderer vr = new ValueRenderer();
    	
    	public ValueEditor() 
    	{
    		vr.addItemListener(this);
    	}
    	@Override
    	public Object getCellEditorValue() 
    	{
    		return vr.isSelected();
    	}
    	@Override
    	public Component getTableCellEditorComponent(JTable table,
    			Object value, boolean isSelected, int row, int col) 
    	{
    		Value v = (Value) value;
    		vr.setSelected(v.selected);
    		//vr.setText(df.format(v.valueDouble));
    		vr.setText(v.valueString);
    		String itemStringTest = vr.getText();
    		//System.out.println(itemStringTest +", Highlighted: " +isSelected);//is selected is not whether the box is ticked, its whether the line is highlighted
    		return vr;
    	}
    
    	@Override
    	public void itemStateChanged(ItemEvent e) {
    		this.fireEditingStopped();
    	}
    }
    
    
    ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton abstractButton = (AbstractButton) e.getSource();
	        boolean selected = abstractButton.getModel().isSelected();
	        System.out.println(selected);
	        // abstractButton.setText(newLabel);
		}
       
      };
}
