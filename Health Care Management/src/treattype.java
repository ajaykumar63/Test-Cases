import java.sql.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
class treattype1 extends JFrame implements ActionListener
{
  JMenuBar menubar;
  JMenu m_file; 
  JMenuItem mi_savecon,mi_savexit,mi_clear,mi_update,mi_exit,mi_search;
  JLabel  t_type;
  JComboBox jcb;
  JButton b1,b2;
  
  
  JFrame f;
  JPanel p;
  treattype1()
  {
     f=new JFrame("selection of type of treatment");
     p=new JPanel();
     p.setLayout(null);
     t_type=new JLabel("t_type :");
     jcb=new JComboBox( );
          
      b1=new JButton("next");
      b1.addActionListener(this);
      jcb.addActionListener(this);         

	p.add(t_type).setBounds(20,60,125,30);
	p.add(jcb).setBounds(140,60,125,30);
	
	try
         {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con1=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
	
	 	Statement stmt=con1.createStatement();
	 	ResultSet rst=stmt.executeQuery("SELECT  distinct(T_TYPE) FROM  TREATMENT");
                                                jcb.removeAllItems(); jcb.addItem("<-select t_type->");
                                                 while(rst.next())
                                                {
                                                   String s=rst.getString(1);
                                                   jcb.addItem(s);
                                                  System.out.println(s);
						  
					       }
	
        }
        catch(Exception e)
	{
		System.out.println("error while searching..");
	}                
	  	
       
  p.add(b1).setBounds(220,360,100,30);
  
  f.setLocation(300,0);
  
  f.add(p);
  f.setSize(400,500);
  f.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==jcb)
    {
        String b=jcb.getSelectedItem().toString();
   System.out.println("the selected value is :"+b);
	 //new treatmentreport(t_type);
     }


  }
}
class treattype
{
  public static void main(String[] args)
  {
      new treattype1();
  }
}   		
	
