import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class apps extends JFrame implements ActionListener,ItemListener
{
  JFrame frame;
  JPanel p;
  JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10;
  JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
 JRadioButton rb1,rb2,rb3,rb4;
 JButton b1,b2,b3;
ButtonGroup bg1;

apps()
{
  bg1=new ButtonGroup();

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
tf7=new JTextField(10);
	p.add(tf7).setBounds(130,320,100,25);


 

  lb8=new JLabel("Status");
p.add(lb8).setBounds(20,370,100,25);

 rb3=new JRadioButton("Serious",true);
p.add(rb3).setBounds(140,370,80,25);
	rb3.setBackground(Color.white);

 rb4=new JRadioButton("Normal",false);
p.add(rb4).setBounds(250,370,80,25);
	rb4.setBackground(Color.white);



 lb9=new JLabel("Give medicines::");
 p.add(lb9).setBounds(20,430,100,25);
tf9=new JTextField(10);
	p.add(tf9).setBounds(130,430,100,25);

 lb10=new JLabel("Next appointment::");
 p.add(lb10).setBounds(280,430,120,25);
tf10=new JTextField(10);
	p.add(tf10).setBounds(400,430,100,25);

 


      b1=new JButton("INSERT");
	b2=new JButton("CLEAR");
        b3=new JButton("EXIT");

       b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
  
        p.add(b1).setBounds(90,540,80,25);
	p.add(b2).setBounds(220,540,80,25);
	p.add(b3).setBounds(350,540,80,25);

        bg1.add(rb1);
	bg1.add(rb2);
	bg1.add(rb3);
	bg1.add(rb4);



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
		
		}
	 if(ae.getSource()==b2)
	 	{
		}
	 if(ae.getSource()==b3)
	 	{
		frame.dispose();
		}
}
public void itemStateChanged(ItemEvent ie)
{
	
       if(ie.getSource()==rb1)
    	{
         }
       else
   	if(ie.getSource()==rb2)
    	{
	}
	if(ie.getSource()==rb3)
    	{
  	  }
        if(ie.getSource()==rb4)
    	{
  	  }
 }
}
public class app 
{
public static void main(String args[])
 { 

	try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   
 new apps();
}
} 