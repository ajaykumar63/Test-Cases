 import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class FPF1 extends JFrame implements ActionListener,ItemListener
{
  JFrame f;
  JPanel p;
   JTable table;
   JScrollPane jsp;
 JLabel lb1,lb2,lb3,lb4,lb5;
  JTextField tf1,tf2,tf3;
 JTextArea ta;
 JComboBox cb1,cb2,cb3,cb4,cb5;
 JButton b1,b2; 
  ButtonGroup bg1;
FPF1()  
{
     
String day[]={"___","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        
		String year[]={"2012","2013","2014","2015","2016","2017"};
		

		f=new JFrame("REPORT");
		p=new JPanel();
		p.setLayout(null);
	
          p.setBackground(Color.white);
     
	   f.add(p);
	    f.setVisible(true);
	f.setResizable(false);
	f.setSize(550,300);
 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);


        b1=new JButton("Search");
        
        b1.addActionListener(this);   	

       p.add(b1).setBounds(400,130,80,25);
       

        b2=new JButton("Cancel");
        
        b2.addActionListener(this);   	

       p.add(b2).setBounds(220,200,80,25);


	
    b1.setEnabled(false);
	lb1=new JLabel("Treatment name:");
	p.add(lb1).setBounds(40,20,90,25);
	 cb1=new JComboBox( );
	p.add(cb1).setBounds(130,20,110,25);  
	 cb1.addItem("<--SELECT-->");
	cb1.addItem("Prescription");
	cb1.addItem("Operation");
	cb1.addItem("Long term treatment");

         lb2=new JLabel("Date:");
	p.add(lb2).setBounds(60,130,90,25);
	 cb2=new JComboBox( );
	p.add(cb2).setBounds(90,130,50,25);
  
for(int i=0;i<31;i++)
  {
     cb2.addItem(day[i]);
}


lb3=new JLabel("Month:");
	p.add(lb3).setBounds(160,130,90,25);
	 cb3=new JComboBox( );
	p.add(cb3).setBounds(200,130,60,25);
	String month[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
for(int j=0;j<12;j++)
{	
	cb3.addItem(month[j]);
}


lb4=new JLabel("Year:");
	p.add(lb4).setBounds(270,130,90,25);
	 cb4=new JComboBox( );
	p.add(cb4).setBounds(310,130,60,25);
		
for(int i=0;i<6;i++)
{
 cb4.addItem(year[i]);
}

lb5=new JLabel("Report in form of:");
	p.add(lb5).setBounds(270,20,90,25);
	 cb5=new JComboBox( );
	p.add(cb5).setBounds(360,20,90,25);
                cb5.addItem("<-SELECT->");
               cb5.addItem("day");
              cb5.addItem("month");
              cb5.addItem("year");

        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        cb4.addItemListener(this);
        cb5.addItemListener(this);   
 
    cb2.setEnabled(false);
                   cb3.setEnabled(false);
                   cb4.setEnabled(false);       
cb5.setEnabled(false);

   


}
public void actionPerformed(ActionEvent ae)
 {

    /* if(ae.getSource()==cb5)
        {
           if(cb5.getSelectedItem().toString().equals(" . . . ."))
           {
                  //cb2.setEditable(false);
                  cb2.setEnabled(false);
                   cb3.setEnabled(false);
                   cb4.setEnabled(false);
         }
      }*/
  	if(ae.getSource()==b1)
	 	{
                  String type=cb1.getSelectedItem().toString();
                  String date="";
                  String form=cb5.getSelectedItem().toString();
                  if(cb5.getSelectedItem().toString().equals("<-SELECT->"))
                   {
                       JOptionPane.showMessageDialog(this,"SELECT THE TYPE OF REPORT.","Confirmation Message",JOptionPane.INFORMATION_MESSAGE);
                   }
                  else if(cb5.getSelectedItem().toString().equals("day"))
                   {
                       date=cb2.getSelectedItem().toString()+"-"+cb3.getSelectedItem().toString()+"-"+cb4.getSelectedItem().toString();
                       f.dispose();
	      	       new FP1(type,form,date);
                   }
                  else if(cb5.getSelectedItem().toString().equals("month"))
                   {

                       date="%-"+cb3.getSelectedItem().toString()+"-"+cb4.getSelectedItem().toString();
                       f.dispose();
	      	       new FP1(type,form,date);

                   }
                  else if(cb5.getSelectedItem().toString().equals("year"))
                   {

                       date="%-%-"+cb4.getSelectedItem().toString();
                       f.dispose();
	      	       new FP1(type,form,date);
                   }
                  
                    System.out.println(type+"::"+date);
                   
		}

     if(ae.getSource()==b2)
	 	{
		 f.dispose();   
		}

              
	
}	
public void itemStateChanged(ItemEvent ie)
{
      if(ie.getSource()==cb1)
	  
           {	
		if(cb1.getSelectedItem().toString().equals("<--SELECT-->"))
           		 { 
			 String sel="<-SELECT->";     
	         		cb5.setSelectedItem(sel);  
		 	cb5.setEnabled(false);b1.setEnabled(false);

              		 }
		if(cb1.getSelectedItem().toString().equals("Prescription"))
           		 {    
   			cb5.setEnabled(true);
	       	 }
               		
              		if(cb1.getSelectedItem().toString().equals("Operation"))
           		{       
			 cb5.setEnabled(true);
                  		}
              		if(cb1.getSelectedItem().toString().equals("Long term treatment"))
           		{     
			  cb5.setEnabled(true);
		 }
                              
             }                    




        if(ie.getSource()==cb5)
        {
           if(cb5.getSelectedItem().toString().equals("<-SELECT->"))
           {
                  //cb2.setEditable(false);
                  cb2.setEnabled(false);
                   cb3.setEnabled(false);
                   cb4.setEnabled(false);b1.setEnabled(false);
           }
          if(cb5.getSelectedItem().toString().equals("day"))
           {
                  //cb2.setEditable(false);
                  cb2.setEnabled(true);
                   cb3.setEnabled(true);
                   cb4.setEnabled(true);b1.setEnabled(true);
           }
          if(cb5.getSelectedItem().toString().equals("month"))
           {
                  //cb2.setEditable(false);
                  cb2.setEnabled(false);
                   cb3.setEnabled(true);
                   cb4.setEnabled(true);b1.setEnabled(true);
           }
         if(cb5.getSelectedItem().toString().equals("year"))
           {
                  //cb2.setEditable(false);
                  cb2.setEnabled(false);
                   cb3.setEnabled(false);
                   cb4.setEnabled(true);b1.setEnabled(true);
           }

      }

}
}

 class FPF
{
 public static void main(String args[])
 {

     try {

      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   
  new FPF1();
 }
}