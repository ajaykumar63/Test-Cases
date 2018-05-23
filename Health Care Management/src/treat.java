import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class treat1 extends JFrame implements ActionListener,ItemListener
{
  JFrame f;
  JPanel p;
 JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
  JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
 JComboBox cb1,cb2,cb3;
 JButton b1,b2,b3; 
  ButtonGroup bg1;
treat1()  
{
     
String day[]={"Day","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        //String month[]={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String month[]={"Month","01","02","03","04","05","06","07","08","09","10","11","12"};
		String year[]={"Year","2011","2012","2013","2014","2015"};
		f=new JFrame("TREATMENT");
		p=new JPanel();
		p.setLayout(null);
	
          p.setBackground(Color.white);
		
		lb1=new JLabel("Date::");
		p.add(lb1).setBounds(40,125,200,23);
	

      cb1=new JComboBox(day);
      p.add(cb1).setBounds(110,125,50,23);
	  
	cb2=new JComboBox(month);
	 p.add(cb2).setBounds(160,125,62,23);

	  cb3=new JComboBox(year);
	  p.add(cb3).setBounds(222,125,55,23);

	   f.add(p);
	    f.setVisible(true);
	f.setResizable(false);
	f.setSize(380,680);
 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);


        b1=new JButton("OPERATION NEED");
	b2=new JButton("OPERATION NOT NEED");
         b3=new JButton("EXIT");

        b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
  
        p.add(b1).setBounds(85,30,200,25);
	p.add(b2).setBounds(85,70,200,25);
	p.add(b3).setBounds(130,605,80,25);

    


  


	lb1=new JLabel("OP_Time");
	p.add(lb1).setBounds(40,175,70,25);
	tf1=new JTextField(10);
	p.add(tf1).setBounds(130,175,90,25);


	lb2=new JLabel("Cost");
	p.add(lb2).setBounds(40,215,70,25);
	tf2=new JTextField(10);
	p.add(tf2).setBounds(130,215,90,25);


	lb3=new JLabel("Admit date");
	p.add(lb3).setBounds(40,255,70,25);
	tf3=new JTextField(10);
	p.add(tf3).setBounds(130,255,90,25);


	lb4=new JLabel("Discharge date");
	p.add(lb4).setBounds(40,295,90,25);
	tf4=new JTextField(10);
	p.add(tf4).setBounds(130,295,90,25);


	lb5=new JLabel("Medicines");
	p.add(lb5).setBounds(40,335,70,25);
	tf5=new JTextField(10);
	p.add(tf5).setBounds(130,335,90,25);


	lb6=new JLabel("Treatment cost");
	p.add(lb6).setBounds(40,375,90,25);
	tf6=new JTextField(10);
	p.add(tf6).setBounds(130,375,90,25); 

  lb7=new JLabel("-----------------------------------------------------------------------------------------------");
  p.add(lb7).setBounds(00,410,680,25);


	lb8=new JLabel("MEDICINE MAKING TIMES");
	p.add(lb8).setBounds(130,430,150,25);
	

	lb9=new JLabel(" Morning");
	p.add(lb9).setBounds(40,470,100,25);
	tf8=new JTextField(10);
	p.add(tf8).setBounds(130,470,90,25);


       lb10=new JLabel("After noon");
	p.add(lb10).setBounds(40,510,100,25);
	tf9=new JTextField(10);
	p.add(tf9).setBounds(130,510,90,25);

       lb11=new JLabel("Evening");
	p.add(lb11).setBounds(40,550,100,25);
	tf10=new JTextField(10);
	p.add(tf10).setBounds(130,550,90,25);




             
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
		f.dispose();
		}
}	
public void itemStateChanged(ItemEvent ie)
{

}
}

 class treat 
{
 public static void main(String args[])
 {

     try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   

  new treat1();
 }
}