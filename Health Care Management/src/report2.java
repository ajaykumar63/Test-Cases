import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 class  defaulters1 extends JFrame  
 {
   JFrame frm;
   JPanel p;
   JTable table;
   JScrollPane jsp;
   Connection con;
   defaulters1()
   {
    String s[][]=new String[50][5]; 
    String colheads[]={"performdate","performtime","patientno","treatmentno","doctorno"}; 
    frm=new JFrame("patient health care system");
    frm.setLayout(new FlowLayout());
   JPanel p=new JPanel();
    try
      {         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         	con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
         	Statement stmt=con.createStatement();
         	ResultSet rst=stmt.executeQuery("select * from perform"); 
            	for(int i=0;rst.next();i++)
             	{
              		for(int j=0;j<5;j++)
                  	{  
                        	s[i][j]= rst.getString(j+1);
                   	} 
               	}
        } 
        catch(Exception e)
     {  
System.out.println(e);        
//JOptionPane.showMessageDialog(this,"ERROR OCCURED IN DATABASE CONNECTION","Error Message",JOptionPane.ERROR_MESSAGE);
    }
    table=new JTable(s,colheads);
    jsp=new JScrollPane(table);
    p.add(jsp);
    frm.add(p);
    frm.setSize(500,500);
   frm.setVisible(true);
  }
}
public class report2
{
 public static void main(String args[])
 {
    new defaulters1();
}
}