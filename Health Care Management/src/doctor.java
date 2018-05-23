import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class doctor1 extends JFrame implements ActionListener,ItemListener
{
  JFrame frame;
  JPanel p;
  JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
  JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
 JRadioButton rb1,rb2,rb3,rb4;
 JButton b1,b2,b3,b4,b5;
ButtonGroup bg1,bg2;
 String s1,s2,s3,s4,s5,s6,s7,s8,s9;
static String str1="",str2="",str3="" ;
doctor1(String str1,String str2,String str3)
{
 this.str1=str1;
this.str2=str2;
this.str3=str3;
 System.out.println(str1+":"+str2+":"+str3);
  bg1=new ButtonGroup();
  bg2=new ButtonGroup();

  frame=new JFrame("DOCTOR::");
  p=new JPanel();
    	p.setLayout(null);
    	frame.add(p);
p.setBackground(Color.white);
    	

 lb1=new JLabel("Doctor Name::");
 p.add(lb1).setBounds(20,50,100,25);
tf1=new JTextField(10);
	p.add(tf1).setBounds(130,50,100,25);
 

 lb2=new JLabel("Specalization::");
 p.add(lb2).setBounds(280,50,100,25);
tf2=new JTextField(10);
	p.add(tf2).setBounds(380,50,100,25);


    lb3=new JLabel("P_name::");
    p.add(lb3).setBounds(20,90,100,25);
tf3=new JTextField(10);
	p.add(tf3).setBounds(130,90,100,25);


   lb4=new JLabel("P_id");
    p.add(lb4).setBounds(20,130,100,25);
tf4=new JTextField(10);
	p.add(tf4).setBounds(130,130,100,25);
 
 lb5=new JLabel("P_Age::");
    p.add(lb5).setBounds(20,180,100,25);
tf5=new JTextField(10);
	p.add(tf5).setBounds(130,180,100,25);



 lb6=new JLabel("P_Gender");
p.add(lb6).setBounds(20,250,100,25); 

 rb1=new JRadioButton("Male",true);
p.add(rb1).setBounds(140,250,100,25);
	rb1.setBackground(Color.white);
 rb2=new JRadioButton("Female",false);
p.add(rb2).setBounds(250,250,100,25);
	rb2.setBackground(Color.white);


 lb7=new JLabel("P_prob::");
    p.add(lb7).setBounds(20,320,100,25);
tf6=new JTextField(10);
	p.add(tf6).setBounds(130,320,150,25);


 

  lb8=new JLabel("Status");
p.add(lb8).setBounds(20,370,100,25);

 rb3=new JRadioButton("Serious"); rb3.addItemListener(this);
p.add(rb3).setBounds(140,370,80,25);
	rb3.setBackground(Color.white);

 rb4=new JRadioButton("Normal");rb4.addItemListener(this);
p.add(rb4).setBounds(250,370,80,25);
	rb4.setBackground(Color.white);





 lb9=new JLabel("Next appointment::");
p.add(lb9).setBounds(280,430,120,25);
 
tf7=new JTextField(10);
	p.add(tf7).setBounds(400,430,100,25);



      b1=new JButton("INSERT");
	b2=new JButton("CLEAR");
        b3=new JButton("EXIT");

        b4=new JButton("OPERATION NEEDED");
	b5=new JButton("OPERATION NOT NEEDED");

          b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
            b4.addActionListener(this);
          b5.addActionListener(this);
  
        p.add(b1).setBounds(90,540,80,25);
	p.add(b2).setBounds(220,540,80,25);
	p.add(b3).setBounds(350,540,80,25);
p.add(b4).setBounds(50,480,160,25);
p.add(b5).setBounds(230,480,180,25);

                bg1.add(rb1);
	bg1.add(rb2);
	bg2.add(rb3);
	bg2.add(rb4);


          try
               {
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     Connection con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                     Statement st=con.createStatement();
                     ResultSet rs=st.executeQuery("select  SPEC from doctor where  D_NAME='"+str1+"' ");
                        if(rs.next())
	       {
                        tf1.setText(str1);
	        tf2.setText(rs.getString(1));
	      }
                   rs=st.executeQuery("select  P_NO,P_AGE,P_GENDER from Patient  where  P_NAME='"+str2+"' ");
                        if(rs.next())
	        {
                         tf3.setText(str2);
	         tf4.setText(rs.getString(1));
                         tf5.setText(rs.getString(2));
                          if(rs.getString(3).equals("MALE"))                             
                               rb1.setSelected(true);                             
                          else  
                              rb2.setSelected(true);    
                        tf6.setText(str3);                         
	      }
              }
           catch(Exception e)
               {
                     System.out.println("Error in radio11");
                }
             

                frame.setVisible(true);
	frame.setResizable(false);
	frame.setSize(550,650);
 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((screenSize.width - frame.getWidth()) / 2, (screenSize.height - frame.getHeight()) / 2); 
}

public void actionPerformed(ActionEvent ae)
 {


	 if(ae.getSource()==b1)
	 	{
                                    s1=tf1.getText();System.out.println("s1 value :"+s1);
s2=tf2.getText();System.out.println("s2 value :"+s2);
s3=tf3.getText();System.out.println("s3 value :"+s3);
s4=tf4.getText();System.out.println("s4 value :"+s4);
s5=tf5.getText();System.out.println("s5 value :"+s5);
s7=tf6.getText();System.out.println("s7 value :"+s7);
s9=tf7.getText();System.out.println("s9 value :"+s9);
if(rb3.isSelected()) 
{
  s8="OPERATION"; System.out.println("s8 value :"+s8);
}
else if(rb4.isSelected()) 
{
s8="MEDICINES"; System.out.println("s8 value :"+s8);
}
if(rb1.isSelected()) 
{
  s6=rb1.getLabel(); System.out.println("s6 value :"+s6);
}
else if(rb2.isSelected()) 
{
s6=rb2.getLabel(); System.out.println("s6 value :"+s6);
}
//s9=rb2.getLabel();  System.out.println("s9 value :"+s9);
		    new prescription1(s1,s2,s3,s4,s5,s6,s7,s8,s9); frame.dispose();
		}
	 if(ae.getSource()==b2)
	 	{
		}
	 if(ae.getSource()==b3)
	 	{
		frame.dispose();
		}
	 if(ae.getSource()==b4)
	 	{String prblm1=tf6.getText();
		System.out.println("OPERATION NEED");
		System.out.println("Doctor:"+str1);
		System.out.println("Patient:"+str2);
		s4=tf4.getText();
		System.out.println("Patient id:"+s4);
		System.out.println("Patient problem:"+prblm1);

		new opneed1(str1,str2,s4,prblm1);
		frame.dispose();
		} 
	if(ae.getSource()==b5)
	 	{
		String prblm1=tf6.getText();
		System.out.println("OPERATION NOT NEED");
		System.out.println("Doctor:"+str1);
		System.out.println("Patient:"+str2);
		s4=tf4.getText();
		System.out.println("Patient id:"+s4);
		System.out.println("Problem:"+prblm1);
		new opnotneed1(str1,str2,s4,prblm1);
		frame.dispose();
		}
}
public void itemStateChanged(ItemEvent ie)
{       	
	if(ie.getSource()==rb3)
    	 {
	      if(tf6.getText().equals("GENERAL PROBLEM"))	
	      {
                	  tf7.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(true);
  	      }
	      else
	      {
		  tf7.setEnabled(false);
		b4.setEnabled(true);
		b5.setEnabled(true);
	      }
	}
        if(ie.getSource()==rb4)
    	{
 	 tf7.setEnabled(true);
	 b4.setEnabled(false);
	b5.setEnabled(false);
  	 }
      
 }
}
public class doctor 
{
public static void main(String args[])
 { 

	try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }  
  String str1="",str2="",str3="" ;
 new doctor1(str1,str2,str3);
}
} 