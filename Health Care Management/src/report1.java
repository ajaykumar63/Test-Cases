import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 class  defaulters extends JFrame  
 {
   JFrame frm;
   JPanel p;
   JTable table;
   JScrollPane jsp;
   Connection con;

   static int count=0;
   defaulters()
   {
    String s[][]=new String[50][5]; 
    String colheads[]={"P_date","p_time","patient name","treatment type","doctor name"}; 
    frm=new JFrame("patient health care system");
    frm.setLayout(new FlowLayout());
   JPanel p=new JPanel();
    try
      {         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         	con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
         	Statement stmt=con.createStatement();
         	ResultSet rst=stmt.executeQuery("select count(P_NO) from presc"); 
            	if(rst.next())
           	{
                   count=rst.getInt(1);
               	}

                rst=stmt.executeQuery("select TO_CHAR(P_DATE,'DD-MON-YYYY'),P_TIME,P_NO,T_NO,D_NO from presc"); 
            	for(int i=0;rst.next();i++)
             	{
              		for(int j=0;j<5;j++)
                  	{  
                        	s[i][j]= rst.getString(j+1);
                   	} 
               	}
           
             for(int i=0;i<count;i++)
              {
                 rst=stmt.executeQuery("select P_NAME from PATIENT WHERE P_NO='"+s[i][2]+"' "); 
            	   if(rst.next())
                     {
                       s[i][2]=rst.getString(1);
                     }
              }
             for(int i=0;i<count;i++)
              {
                 rst=stmt.executeQuery("select T_TYPE from TREATMENT WHERE T_NO='"+s[i][3]+"' "); 
            	   if(rst.next())
                     {
                       s[i][3]=rst.getString(1);
                     }
              }
for(int i=0;i<count;i++)
              {
                 rst=stmt.executeQuery("select D_NAME from DOCTOR WHERE D_NO='"+s[i][4]+"' "); 
            	   if(rst.next())
                     {
                       s[i][4]=rst.getString(1);
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
public class report1
{
 public static void main(String args[])
 {
    new defaulters();
}
}