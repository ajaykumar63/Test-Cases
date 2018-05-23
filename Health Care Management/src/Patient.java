import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Patient extends JFrame implements ActionListener,ItemListener,KeyListener
{
  
    JFrame frm;
    JPanel p;
    JLabel  cus_for,cus_name,cu_id,cus_address,cus_tel,ser_no,con_ty,name,address,tel,date,date1,gend,treat;
    JComboBox cb1,cb2,cb3;
    JRadioButton   rb1,rb2,gd1,gd2;
    String s1="",s2="";
   JButton next,cancel;
   ButtonGroup bg,bg1;
   JTextField tf1,tf2,tf3,tf4;
   JTextArea ta;

  Connection con;
  Statement st;
  ResultSet rs;
  PreparedStatement pstmt;

  
  static String dat,id,gen="";
  Patient()
    {
             frm=new JFrame("PATIENT");
             p=new   JPanel();
	p.setLayout(null);
	p.setBackground(Color.gray);
             cus_for=new JLabel("ADMISSION FORM For");
             cus_name=new JLabel("PATIENT NAME::");
             cu_id=new JLabel("PATIENT ID::");
             cus_address=new JLabel("PATIENT ADDRESS::");
             cus_tel=new JLabel("PATIENT Telphone No::");
             ser_no=new JLabel("PATIENT AGE::");
             con_ty=new JLabel("ASSIGNED DOCTOR::");
             name=new JLabel();
             address=new JLabel();
             tel=new JLabel();
             date=new JLabel("DATE::");
             date1=new JLabel();
             gend=new JLabel("GENDER::");
             treat=new JLabel("PATIENT PROBLEM::");

             cb1=new JComboBox();cb1.addItem("SELECT");
             cb2=new JComboBox();cb2.addItem("SELECT");
             cb3=new JComboBox();cb3.addItem("SELECT");
             cb3.addItem("GENERAL PROBLEM");cb3.addItem("EYE PROBLEM");cb3.addItem("ENT PROBLEM");
             cb3.addItem("HEART PROBLEM");cb3.addItem("ACCIDENT");
             

             try
               {
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                     st=con.createStatement();
                      rs=st.executeQuery("SELECT TO_CHAR(SYSDATE,'DD-MON-YYYY')  FROM DUAL");
                            while(rs.next())
                              {
                                     dat=rs.getString(1).toString();
                                     date1.setText(dat);
                                     date1.setForeground(Color.white);
                              }
		
		 String sel="",cond="";
         sel=cb3.getSelectedItem().toString();
           
            if(sel.equals("GENERAL PROBLEM"))
              cond="GENERAL PROBLEM";
            else if(sel.equals("EYE PROBLEM"))
              cond="EYE PROBLEM";
            else if(sel.equals("ENT PROBLEM"))
              cond="ENT PROBLEM";
            else if(sel.equals("HEART PROBLEM"))
              cond="HEART";
            else
             cond="ACCIDENT"; 
         
         try
               {
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                     st=con.createStatement();
                     cb2.removeAllItems();cb2.addItem("SELECT");
                      rs=st.executeQuery("select D_NAME from doctor where spec like '%"+cond+"%' ");
                   while(rs.next())  
		   {
			System.out.println(rs.getString(1));
	           }
		      rs=st.executeQuery("select D_NAME from doctor where spec like '%"+cond+"%' ");
                
                            while(rs.next())
                              {
                                     cb2.addItem(rs.getString(1));
                              }  
                      
                                                                                             
                }
               catch(Exception e)
               {
                     System.out.println("Error in date"+e);
                }                  
        



 
                  /*rs=st.executeQuery("select distinct(D_NAME) from doctor where SPEC='");
                            while(rs.next())
                              {
                                     cb2.addItem(rs.getString(1));
                              } */ 
                                                                                             
                }
               catch(Exception e)
               {
                     System.out.println("Error in date"+e);
                }            
 
              rb1=new  JRadioButton("New PATIENT");                                    rb1.addItemListener(this);    rb1.setBackground(Color.gray);  
              rb2=new  JRadioButton("Already Existing PATIENT");                       rb2.addItemListener(this);    rb2.setBackground(Color.gray);

              gd1=new  JRadioButton("MALE");                                            gd1.addItemListener(this);   gd1.setBackground(Color.gray);
              gd2=new  JRadioButton("FEMALE");                                          gd2.addItemListener(this);   gd2.setBackground(Color.gray);

              bg=new ButtonGroup();
              bg.add(rb1);
              bg.add(rb2);

              bg1=new ButtonGroup();
              bg1.add(gd1);
              bg1.add(gd2);
               tf1=new JTextField(25);
               tf2=new JTextField(25);tf2.addKeyListener(this);
               tf3=new JTextField(25);
              tf4=new JTextField(25);
               ta=new  JTextArea(40,40);
              next=new JButton("Next");next.addActionListener(this);
              cancel=new JButton("Cancel");cancel.addActionListener(this);   

             p.add(date).setBounds(350,5,40,25);p.add(date1).setBounds(390,5,90,25);
             p.add(cus_for).setBounds(15,30,150,25);
             p.add(rb1).setBounds(150,30,110,20);
             p.add(rb2).setBounds(260,30,180,20);
             p.add(cus_name).setBounds(50,80,100,25);p.add(cb1).setBounds(220,80,130,25);
             p.add(cu_id).setBounds(50,120,100,25);p.add(tf1).setBounds(220,120,130,25);
             p.add(gend).setBounds(50,155,100,25);p.add(gd1).setBounds(220,155,60,25);p.add(gd2).setBounds(290,155,80,25);
             p.add(cus_address).setBounds(50,190,130,25);
             p.add(cus_tel).setBounds(50,250,150,25);
             p.add(ser_no).setBounds(50,290,100,25);p.add(tf3).setBounds(220,290,130,25);
             p.add(treat).setBounds(50,330,130,25);p.add(cb3).setBounds(220,330,160,25);
             p.add(con_ty).setBounds(50,370,130,25);p.add(cb2).setBounds(220,370,160,25);             
             p.add(next).setBounds(120,420,80,25);p.add(cancel).setBounds(240,420,80,25);
             frm.add(p);
             frm.setSize(480,490);
             Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
             frm.setLocation((screenSize.width - frm.getWidth()) / 2, (screenSize.height - frm.getHeight()) / 2);             
             frm.setUndecorated(false);
             frm.setResizable(false);
             frm.setVisible(true);              
             //frm.setDefaultLookAndFeelDecorated(true);
                      
  }



public void itemStateChanged(ItemEvent ie)
{
    if(ie.getSource()==rb1)
     {
            
                p.remove(cb1);                
                tf3.setText("");   
                p.remove(name);    
                p.remove(address);             
                p.remove(tel);   
                p.add(tf4).setBounds(220,80,130,25);                        
                p.add(tf1).setBounds(220,120,130,25);                
                p.add(ta).setBounds(220,190,130,50); 
                p.add(tf2).setBounds(220,250,130,25); 
                p.repaint();
                cb1.removeActionListener(this);
                gd1.setSelected(false);
                gd2.setSelected(false);
		



     }
     
      if(ie.getSource()==rb2)
        {
              p.remove(tf4);
              p.remove(tf1);  
              p.remove(ta);
              p.remove(tf2);
             
              p.add(cb1).setBounds(220,80,130,25);
              p.repaint();
              
               try
               {
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                     st=con.createStatement();
                     cb1.removeAllItems();cb1.setEnabled(true);
                     cb1.addItem("SELECT");
                      rs=st.executeQuery("select distinct(P_NAME) from patient");
                            while(rs.next())
                              {
                                     cb1.addItem(rs.getString(1));
                              }
                   cb1.addActionListener(this);
                }
               catch(Exception e)
               {
                     System.out.println("Error in radio11");
                }
         }
       if(ie.getSource()==gd1)
             gen=gd1.getLabel().toString();
       if(ie.getSource()==gd2)
             gen=gd2.getLabel().toString();          
} 


public  void actionPerformed(ActionEvent ae)
{
      if(ae.getSource()==cb1)
        {
           String d_id="";   
               try
                {
                         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                         con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                         st=con.createStatement();                         
                         rs=st.executeQuery("SELECT  P_NO,P_AGE,P_GENDER,P_TELNO,P_ADDRESS FROM PATIENT WHERE P_NAME='"+cb1.getSelectedItem()+"' ");
                               while(rs.next())
                                 {         
                                       cb1.setEnabled(false);                             
                                       id=rs.getString(1).toString();
                                       tf3.setText(rs.getString(2));

                                       String gen=rs.getString(3).toString();
                                            if(gen.equals("MALE"))
                                               gd1.setSelected(true);
                                            else
                                                gd2.setSelected(true);
                                       tel.setText(rs.getString(4).toString());tel.setForeground(Color.white);
                                       address.setText(rs.getString(5).toString());address.setForeground(Color.white);
                                       name.setText(id);name.setForeground(Color.white);
                                       p.add(name).setBounds(220,120,130,25);
                                       p.add(address).setBounds(220,190,130,50);
                                       p.add(tel).setBounds(220,250,130,25);                                        
                                       p.repaint();
                               }
                           rs=st.executeQuery("select d_no from presc where p_no='"+id+"' ");
                               while(rs.next())
                                 {
                                   d_id=rs.getString(1);
                                 }
                           rs=st.executeQuery("select d_name from doctor where d_no='"+d_id+"' ");
                               while(rs.next())
                                 {
                                    d_id=rs.getString(1);
                                    cb2.setEditable(false);                                    
                                    cb2.setSelectedItem(d_id);
                                 }
		cb3.addActionListener(this);
                }
               catch(Exception e)
                {
                   System.out.println("Error in action of Combobox1::"+e);     
                }
         }
	
 	
       if(ae.getSource()==cb3)
       {
         String sel="",cond="";
         sel=cb3.getSelectedItem().toString();
           
            if(sel.equals("GENERAL PROBLEM"))
              cond="GENERAL";
            else if(sel.equals("EYE PROBLEM"))
              cond="EYE";
            else if(sel.equals("ENT PROBLEM"))
              cond="ENT";
            else if(sel.equals("HEART PROBLEM"))
              cond="HEART";
            else
             cond="ACCIDENT"; 
         
         try
               {
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                     st=con.createStatement();
                     cb2.removeAllItems();cb2.addItem("SELECT");
                      rs=st.executeQuery("select D_NAME from doctor where spec like '%"+cond+"%' ");
                   while(rs.next())  
	{
		System.out.println(rs.getString(1));
	}
		      rs=st.executeQuery("select D_NAME from doctor where spec like '%"+cond+"%' ");
                
                            while(rs.next())
                              {
                                     cb2.addItem(rs.getString(1));
                              }  
                      
                                                                                             
                }
               catch(Exception e)
               {
                     System.out.println("Error in date"+e);
                }                  
        
       }

       if(ae.getSource()==next)
       {
           
            if(rb1.isSelected())
             {  
   
                                     if(tf4.getText().equals(""))
                                     {
                                            JOptionPane.showMessageDialog(this,"NAME FEILD SHOULD'NT BLANK","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                            tf4.requestFocus();
                                     }    
                                     else  if(tf1.getText().equals(""))
                                     {
                                            JOptionPane.showMessageDialog(this,"PATIENT ID FEILD SHOULD'NT BLANK","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                            tf1.requestFocus();
                                     }  
                                     else if(ta.getText().equals(""))
                                     {
                                            JOptionPane.showMessageDialog(this,"ADDRESS  FEILD SHOULD'NT BLANK","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                            ta.requestFocus();
                                     }
                                     else if(tf2.getText().equals(""))
                                     {
                                            JOptionPane.showMessageDialog(this,"PHONE NUMBER  FEILD SHOULD'NT BLANK","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                            tf2.requestFocus();
                                     }       
                                  else   if(tf3.getText().equals(""))
                                     {
                                            JOptionPane.showMessageDialog(this,"AGE FEILD SHOULD'NT BLANK","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                            tf3.requestFocus();
                                     }   
                                  else   if(cb3.getSelectedItem().equals("SELECT"))
                                     {
                                            JOptionPane.showMessageDialog(this,"SELECT  PATIENT PROBLEUM.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                     }        
                                  else   if(cb2.getSelectedItem().equals("SELECT"))
                                     {
                                            JOptionPane.showMessageDialog(this,"SELECT THE DOCTOR.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                     }
                                  else   if(gen.equals(""))
                                     {
                                            JOptionPane.showMessageDialog(this,"SELECT THE GENDER.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                     }
                                 else
                                     {
                                         String uk="",doc_id="",time="";
                                         try
                                          {
                                                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                                 con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                                                 //System.out.println("inserting  new existing user... ");
                                                 st=con.createStatement();
                                                 pstmt=con.prepareStatement("Insert into Patient values(?,?,?,?,?,?,?)");
                                                     pstmt.setString(1,tf1.getText());
                                                     pstmt.setString(2,tf4.getText());
                                                     pstmt.setString(3,tf3.getText());
                                                        if(gd1.isSelected())
                                                            uk=gd1.getLabel().toString();
                                                        else
                                                            uk=gd2.getLabel().toString();
                                                     pstmt.setString(4,gen);
                                                     pstmt.setString(5,tf2.getText());
                                                     pstmt.setString(6,ta.getText());
		          pstmt.setString(7,cb3.getSelectedItem().toString());
                                                      int k=pstmt.executeUpdate();
                                                  
                                                 rs=st.executeQuery("SELECT D_NO FROM DOCTOR WHERE D_NAME='"+cb2.getSelectedItem().toString()+"' ");
                                                      if(rs.next())
                                                        {
                                                          doc_id=rs.getString(1);
                                                        }
                                                 rs=st.executeQuery(" select to_char(sysdate,'HH12:MI:SS') from dual ");
                                                      if(rs.next())
                                                        {
                                                          time=rs.getString(1);
                                                        }

                                                  PreparedStatement pstmt1=con.prepareStatement("Insert into presc values(?,?,?,?)");
                                                        pstmt1.setString(1,doc_id);
                                                        pstmt1.setString(2,tf1.getText());
                                                        pstmt1.setString(3,date1.getText());
                                                        pstmt1.setString(4,time);
                                                     int f=pstmt1.executeUpdate();
                                           
                                                 if(k==1&&f==1)
                                                  {
                                                      JOptionPane.showMessageDialog(this,"PATIENT DETAILS ADDED SUCCESSFULLY.","CONFIRM MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                                                      frm.dispose();
                                                      s1=cb2.getSelectedItem().toString();
                                                      s2=tf4.getText();
                                                      new doctor1(s1,s2,cb3.getSelectedItem().toString());
                                                  }
                                                 else
                                                  {
                                                      JOptionPane.showMessageDialog(this,"ERROR WHILE INSERTING PATIENT DETAILS.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                                  }
                                                        
                                                  
                                                 
                                           }
                                         catch(Exception e)
                                          {
                                              System.out.println("Error inserting  new existing user... "+e);
                                          }
                                     }                                                                                   
             }
          else
             {
                           if(cb1.getSelectedItem().toString()=="SELECT")
                             {
                                    JOptionPane.showMessageDialog(this,"SELECT PATIENT NAME.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                             }
                         else  if(tf3.getText().equals(""))
                             {
                                    JOptionPane.showMessageDialog(this,"PATIENT NUMBER FEILD SHOULD'NT BLANK.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                             }
                                          
                         else   if(cb2.getSelectedItem().equals("SELECT"))
                           {
                                    JOptionPane.showMessageDialog(this,"SELECT THE DOCTOR.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                           }
                       else   if(cb3.getSelectedItem().equals("SELECT"))
                           {
                                    JOptionPane.showMessageDialog(this,"SELECT THE PROBLEUM.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                           }
                        else
                           { 
                                String str1="",str2="";  
                                String uk="",doc_id="",time="";                                      
                                       try
                                          {
                                               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                               con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                                               System.out.println("Inserting Already existing user... ");
                                               st=con.createStatement();
                                                 rs=st.executeQuery("SELECT P_NO FROM PATIENT WHERE P_NAME='"+cb1.getSelectedItem().toString()+"' ");
                                                  if(rs.next())
                                                   {
                                                     str1=rs.getString(1);
                                                   }
                                                 rs=st.executeQuery("SELECT D_NO FROM DOCTOR WHERE D_NAME='"+cb2.getSelectedItem().toString()+"' ");
                                                  if(rs.next())
                                                   {
                                                     str2=rs.getString(1);
                                                   }

                                                  rs=st.executeQuery(" select to_char(sysdate,'HH12:MI:SS') from dual ");
                                                      if(rs.next())
                                                        {
                                                          time=rs.getString(1);
                                                        }

                                                  PreparedStatement pstmt1=con.prepareStatement("Insert into presc values(?,?,?,?)");
                                                        pstmt1.setString(1,str2);
                                                        pstmt1.setString(2,str1);
                                                        pstmt1.setString(3,date1.getText());
                                                        pstmt1.setString(4,time);
                                                     int f=pstmt1.executeUpdate();
                                           
                                                 if(f==1)
                                                  {
                                                      JOptionPane.showMessageDialog(this,"PATIENT DETAILS ADDED SUCCESSFULLY.","CONFIRM MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                                                      frm.dispose();
     
                                                       s1=cb2.getSelectedItem().toString();
                                                      s2=cb1.getSelectedItem().toString();
                                                      System.out.println(s1+":"+s2+":"+cb3.getSelectedItem().toString());
                                                      new doctor1(s1,s2,cb3.getSelectedItem().toString());
                                                  }
                                                 else
                                                  {
                                                      JOptionPane.showMessageDialog(this,"ERROR WHILE INSERTING PATIENT DETAILS.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                                  }
 
                                          }
                                         catch(Exception e)
                                          {
                                               System.out.println("Error inserting Already existing user... "+e);
                                          }                                         
                           }
              }
       }
       
       if(ae.getSource()==cancel)
       {
            frm.dispose();
       } 
}


public  void keyPressed(KeyEvent ke)
 {
  if(ke.getKeyCode()>=65&&ke.getKeyCode()<=90)
  {
  JOptionPane.showMessageDialog(this,"please give numerics","Error Message",JOptionPane.ERROR_MESSAGE);
  tf2.setText("");
  }  
} 
public void keyReleased(KeyEvent ke)
{
}
public void keyTyped(KeyEvent ke)
{
}

public static void main(String args[])
    {
            // JFrame.setDefaultLookAndFeelDecorated(true);
              new  Patient();
    }

}