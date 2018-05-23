import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class opnotneed1 extends JFrame implements ActionListener,ItemListener
{
  JFrame f;
  JPanel p;
 JLabel dn,pn,pid,dn1,pn1,pid1,pb,pb1,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
  JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
 JComboBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
 JButton b1; 
  ButtonGroup bg1;
String str1="",str2="",s4="",prblm="";
 opnotneed1(String str1,String str2,String s4,String prblm)  
{
  this.str1=str1;
this.str2=str2;
this.s4=s4;
this.prblm=prblm;   
String day[]={"Day","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String month[]={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        //String month[]={"Month","01","02","03","04","05","06","07","08","09","10","11","12"};
		String year[]={"Year","2011","2012","2013","2014","2015"};
		f=new JFrame("operation  not needed");
		p=new JPanel();
		p.setLayout(null);
	
          p.setBackground(Color.white);
		
		dn=new JLabel("Doctor name::");p.add(dn).setBounds(40,40,100,25);
 		  pn=new JLabel("Patient name::");p.add(pn).setBounds(40,80,100,25);
		  pid=new JLabel("Patient ID::");p.add(pid).setBounds(40,120,100,25);
		   dn1=new JLabel(str1);p.add(dn1).setBounds(140,40,100,25);
 		  pn1=new JLabel(str2);p.add(pn1).setBounds(140,80,100,25);
		  pid1=new JLabel(s4);p.add(pid1).setBounds(140,120,100,25);
		 pb=new JLabel("Patient problem::");p.add(pb).setBounds(40,270,100,25);
		  pb1=new JLabel(prblm);p.add(pb1).setBounds(150,270,100,25);
		lb1=new JLabel("Admit date::");
		p.add(lb1).setBounds(40,160,200,23);
	

      cb1=new JComboBox(day);
      p.add(cb1).setBounds(110,160,50,23);
	  
	cb2=new JComboBox(month);
	 p.add(cb2).setBounds(160,160,62,23);

	  cb3=new JComboBox(year);
	  p.add(cb3).setBounds(222,160,55,23);


                     lb5=new JLabel("Discharge date::");
		p.add(lb5).setBounds(35,360,200,23);
	

      cb4=new JComboBox(day);
      p.add(cb4).setBounds(125,360,50,23);
	  
	cb5=new JComboBox(month);
	 p.add(cb5).setBounds(175,360,62,23);

	  cb6=new JComboBox(year);
	  p.add(cb6).setBounds(237,360,55,23);

	   f.add(p);
	    f.setVisible(true);
	f.setResizable(false);
	f.setSize(380,500);
 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);


	lb1=new JLabel("Medicines");
	p.add(lb1).setBounds(40,220,70,25);
	tf1=new JTextField(10);
	p.add(tf1).setBounds(130,220,110,25);

             

	lb2=new JLabel("cost");
	p.add(lb2).setBounds(40,310,70,25);
	tf2=new JTextField(10);
	p.add(tf2).setBounds(140,310,90,25);


 b1=new JButton("NEXT");
	
       b1.addActionListener(this);
	
        p.add(b1).setBounds(140,410,80,25);
             
}
public void actionPerformed(ActionEvent ae)
 {


	if(ae.getSource()==b1)
	 	{
		String add=cb1.getSelectedItem().toString();
			String amm=cb2.getSelectedItem().toString();
			String ayy=cb3.getSelectedItem().toString();
			String ad=""+add+"-"+amm+"-"+ayy+"";
			String cost=tf2.getText();
			String med=tf1.getText();
			String ddd=cb4.getSelectedItem().toString();
			String dmm=cb5.getSelectedItem().toString();
			String dyy=cb6.getSelectedItem().toString();			
			String dd=""+ddd+"-"+dmm+"-"+dyy+"";
		
			System.out.println("admit date:"+ad);
		
			System.out.println("cost:"+cost);
			System.out.println("discharge date:"+dd);
			
			f.dispose();
			new opnnt1(str1,str2,s4,prblm,ad,cost,med,dd);
		}
	
}	
public void itemStateChanged(ItemEvent ie)
{
}
}

 class opnotneed 
{
 public static void main(String args[])
 {
     String str1="",str2="",s4="",prblm="";
     try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   
   
  new opnotneed1(str1,str2,s4,prblm);
 }
}