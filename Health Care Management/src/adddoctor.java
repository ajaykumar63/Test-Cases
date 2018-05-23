import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class adddoctor1 extends JFrame implements ActionListener,ItemListener
{
  JFrame f;
  JPanel p;
 JLabel lb1,lb2,lb3,lb4,lb5;
  JTextField tf1,tf2,tf3;
 JTextArea ta;
 JComboBox jcb;
 JButton b1,b2; 
  ButtonGroup bg1;
adddoctor1()  
{
     
		f=new JFrame("ADD DOCTOR");
		p=new JPanel();
		p.setLayout(null);
	
          p.setBackground(Color.white);
     
	   f.add(p);
	    f.setVisible(true);
	f.setResizable(false);
	f.setSize(400,430);
 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);


        b1=new JButton("Insert");
        b2=new JButton("Exit");

        b1.addActionListener(this);
        b2.addActionListener(this);
	
	
        p.add(b1).setBounds(70,350,80,25);
       p.add(b2).setBounds(190,350,80,25);	
    
	lb1=new JLabel("d_no");
	p.add(lb1).setBounds(40,60,70,25);
	tf1=new JTextField(10);
	p.add(tf1).setBounds(130,60,90,25);


	lb2=new JLabel("d_name");
	p.add(lb2).setBounds(40,100,70,25);
	tf2=new JTextField(10);
	p.add(tf2).setBounds(130,100,120,25);


	lb3=new JLabel("d_ph no");
	p.add(lb3).setBounds(40,140,70,25);
	tf3=new JTextField(10);
	p.add(tf3).setBounds(130,140,90,25);


	lb4=new JLabel("d_add");
	p.add(lb4).setBounds(40,180,90,25);
	ta=new JTextArea(10,5);
	p.add(ta).setBounds(130,180,90,50);


	lb5=new JLabel("spec");
	p.add(lb5).setBounds(40,260,70,25);
	 jcb=new JComboBox( );
	p.add(jcb).setBounds(130,260,120,25);
	jcb.addItem("GENERAL PROBLEM");
	jcb.addItem("EYE PROBLEM ");jcb.addItem("ACCIDENT ");jcb.addItem("HEART PROBLEM");
	jcb.addItem("ENT PROBLEM ");
          
}
public void actionPerformed(ActionEvent ae)
 {


	if(ae.getSource()==b1)
	 	{
		    try
                                          {
                                                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                                 Connection con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                                                 
                                                  Statement st=con.createStatement();
                                                PreparedStatement pstmt=con.prepareStatement("Insert into doctor values(?,?,?,?,?)");
                                                     pstmt.setString(1,tf1.getText().toUpperCase());System.out.println("inserting  new existing user... ");
                                                     pstmt.setString(2,tf2.getText().toUpperCase());
                                                     pstmt.setString(3,tf3.getText());
			 pstmt.setString(4,ta.getText().toUpperCase());
			 pstmt.setString(5,jcb.getSelectedItem().toString().toUpperCase());
		             int a=pstmt.executeUpdate();
		        if(a==1)
                                             {
                                                 JOptionPane.showMessageDialog(this,"DOCTOR DETAILS ADDED SUCCESSFULLY.","CONFIRM MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                                                 f.dispose();
                                             }
                                           else
		          {
                                                      JOptionPane.showMessageDialog(this,"ERROR WHILE INSERTING DOCTOR DETAILS.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
                                            }  
                                            con.close();     
                                           }
                                         catch(Exception e)
                                          {
                                              System.out.println("Error inserting  new existing user... "+e);
                                          }
		}

              if(ae.getSource()==b2)
               {
                  f.dispose();
               }
	
}	
public void itemStateChanged(ItemEvent ie)
{

}
}

 class adddoctor
{
 public static void main(String args[])
 {

     try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   
  new adddoctor1();
 }
}