import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CheckBoxList extends JList
{
   protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

   public CheckBoxList()
   {
      setCellRenderer(new CellRenderer());

      addMouseListener(new MouseAdapter()
      {         
    	  public void mousePressed(MouseEvent e)
    	  {
               int index = locationToIndex(e.getPoint());

               if (index != -1) {
                  JCheckBox checkbox = (JCheckBox)
                              getModel().getElementAt(index);
                  checkbox.setSelected(
                                     !checkbox.isSelected());
                  repaint();
               }
            }
         }
      );

      //setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
   }

   protected class CellRenderer implements ListCellRenderer
   {
      public Component getListCellRendererComponent(
                    JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus)
      {
         JCheckBox checkbox = (JCheckBox) value;
         checkbox.setBackground(isSelected ?
                 getSelectionBackground() : getBackground());
         checkbox.setForeground(isSelected ?
                 getSelectionForeground() : getForeground());
         checkbox.setEnabled(isEnabled());
         checkbox.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
         checkbox.setFocusPainted(false);
         checkbox.setBorderPainted(true);
         checkbox.setBorder(isSelected ?
          UIManager.getBorder(
           "List.focusCellHighlightBorder") : noFocusBorder);
         return checkbox;
      }
   }
   //@SuppressWarnings("unchecked") //not sure that this does
   
   //so I can call this method whenever a value gets changed in the list as well as when we initialize
   //then I have a list of JCheckboxes....is that useful? Does that tell the the values in them?
   
  /* public ArrayList<JCheckBox> getCheckedItems() 
   {
     ArrayList<JCheckBox> list = new ArrayList<JCheckBox>();
     DefaultListModel dlm = (DefaultListModel) getModel();
     for (int i = 0; i < dlm.size(); ++i) 
     {
    	 Object obj = getModel().getElementAt(i);
    	 if (obj instanceof JCheckBox) 
    	 {
    		 JCheckBox checkbox = (JCheckBox) obj;
    		 if (checkbox.isSelected()) 
    		 {
    			 list.add(checkbox);
    			 }
    		 }
    	 }
     return list;
     }*/
   
  // @SuppressWarnings("unchecked")
   //this seems to be working now
   //now i need to call this whenever an inventory item gets ticked
   //actually i dont think that is whats happening but it calls twice and doesnt always call
   public java.util.List getCheckedItems() 
   {
	   java.util.List list = new java.util.ArrayList();
	   //DefaultListModel dlm = (DefaultListModel) getModel();
	   ListModel lm = getModel();
	   for (int i = 0; i < lm.getSize(); ++i) 
	   {
		   Object obj = getModel().getElementAt(i);
		   if (obj instanceof JCheckBox) 
		   {
			   JCheckBox checkbox = (JCheckBox) obj;
			   if (checkbox.isSelected())
			   {
				   list.add(checkbox);
			   }
		   }
	   }
	   return list;
   }
}
