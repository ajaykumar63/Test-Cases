import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class patientreport extends JFrame implements ActionListener
{

  JFrame frame;
  JPanel pan;
  JLabel lb1,lb2;
  JTable table;
  JScrollPane jsp;
  JButton bt1,bt2;
  JComboBox cb1;

  patientreport()
  {
      frame=new JFrame("Table Format For Report");
      pan=new JPanel(); pan.setLayout(null);
      lb1=new JLabel("Patient name::");
     

        cb1=new JComboBox();      
      pan.add(cb1).setBounds(130,25,120,23); 

      String colHeads[]={"patient_id","patient_name","address","phno","problem",};
      String tab[][]=new String[100][6];
      table=new JTable(tab,colHeads);
      jsp=new JScrollPane(table);
      bt1=new JButton("exit"); bt1.addActionListener(this);

      pan.add(lb1).setBounds(35,25,130,25);
      pan.add(jsp).setBounds(5,60,740,250);
      pan.add(bt1).setBounds(280,320,90,25);

      frame.add(pan);
    
      frame.setVisible(true);
      frame.setSize(750,400);
  }

 public void actionPerformed(ActionEvent ae)
 {
   if(ae.getSource()==bt1)
    {
      frame.dispose();
    }
 }

  public static void main(String args[])
  { 
    new patientreport();
  }
} 