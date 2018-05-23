import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class finalreport1 extends JFrame implements ActionListener,ItemListener
{
  JFrame f;
  JPanel p;
   JTable table;
   JScrollPane jsp;
 JLabel lb1,lb2,lb3,lb4,lb5;
  JTextField tf1,tf2,tf3;
 JTextArea ta;
 JComboBox cb1,cb2,cb3,cb4,cb5;
 JButton b1,b2,b3; 
  ButtonGroup bg1;
finalreport1()  
{
     
String day[]={"___","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        
		String year[]={"2012","2013","2014","2015","2016","2017"};
		
//String s[][]=new String[50][5]; 
//    String colheads[]={"Name","gender","address","telno","city"}; 
		f=new JFrame("REPORT");
		p=new JPanel();
		p.setLayout(null);
	
          p.setBackground(Color.white);
     
	   f.add(p);
	    f.setVisible(true);
	f.setResizable(false);
	f.setSize(850,230);
 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);


        b1=new JButton("Print");
        b2=new JButton("Cancel");
       b3=new JButton("Search");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);	

       
     
	
        p.add(b1).setBounds(280,440,80,25);
       p.add(b2).setBounds(470,440,80,25);	
       p.add(b3).setBounds(570,90,80,25);
	
b3.setEnabled(false);
	lb1=new JLabel("Treatment name:");
	p.add(lb1).setBounds(100,20,90,25);
	 cb1=new JComboBox( );
	p.add(cb1).setBounds(200,20,120,25);  
	 cb1.addItem("<--SELECT-->");
	cb1.addItem("Prescription");
	cb1.addItem("Operation");
	cb1.addItem("Long term treatment");

                    lb2=new JLabel("Date:");
	p.add(lb2).setBounds(250,90,90,25);
	 cb2=new JComboBox( );
	p.add(cb2).setBounds(280,90,50,25);
  
for(int i=1;i<32;i++)
  {
     cb2.addItem(i);
}


lb3=new JLabel("Month:");
	p.add(lb3).setBounds(340,90,90,25);
	 cb3=new JComboBox( );
	p.add(cb3).setBounds(380,90,60,25);
	String month[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
for(int j=0;j<12;j++)
{	
	cb3.addItem(month[j]);
}


lb4=new JLabel("Year:");
	p.add(lb4).setBounds(450,90,90,25);
	 cb4=new JComboBox( );
	p.add(cb4).setBounds(480,90,60,25);
		
for(int i=0;i<6;i++)
{
 cb4.addItem(year[i]);
}

lb5=new JLabel("Report in form of:");
	p.add(lb5).setBounds(400,20,90,25);
	 cb5=new JComboBox( );
	p.add(cb5).setBounds(500,20,70,25);
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
//table=new JTable(s,colheads);
 //   jsp=new JScrollPane(table);
   


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
		    
		}

              if(ae.getSource()==b2)
               {
                  f.dispose();
               }
             	if(ae.getSource()==b3)
	 {
		    
                     new FP1(String Treatment name,String 
		   // f.setSize(850,530);
		 //p.add(jsp).setBounds(50,140,700,280);
   		 
		if((cb1.getSelectedItem().equals("Prescription")))
		{
			if((cb5.getSelectedItem().equals("day")))
			{	
				
				String pd=""+cb2.getSelectedItem().toString()+"";
				String pm=""+cb3.getSelectedItem().toString()+"";
				String py=""+cb4.getSelectedItem().toString()+"";
                                                                              System.out.println("date="+pd);
                                                               
				String predate=""+pd+"-"+pm+"-"+py+"";
				//Select p_no,p_name,p_age,p_gender,p_prob,t_type,na_date,d_name from precription where pre_date LIKE ""+predate+"";
				
			}
			
			if((cb5.getSelectedItem().equals("month")))
			{	
				
				String pm=""+cb3.getSelectedItem().toString()+"";
				String py=""+cb4.getSelectedItem().toString()+"";
				String predate="%-"+pm+"-"+py+"";
				//Select p_no,p_name,p_age,p_gender,p_prob,t_type,na_date,d_name from precription where pre_date LIKE ""+predate+"";
				
			}
			
			if((cb5.getSelectedItem().equals("year")))
			{	
				
				
				String py=""+cb4.getSelectedItem().toString()+"";
				String predate="%-%-"+py+"";
				//Select p_no,p_name,p_age,p_gender,p_prob,t_type,na_date,d_name from precription where pre_date LIKE ""+predate+"";
				
			}
			String s[][]=new String[50][5];
			String colheads[]={"P_NO","P_NAME","P_AGE","P_GENDER","P_PROB","T_TYPE","NA_DATE","D_NAME","PRE_DATE","PRE_TIME"};
			table=new JTable(s,colheads);
    			jsp=new JScrollPane(table);
			p.add(jsp).setBounds(50,140,700,280);f.setSize(850,530);
                                                         f.add(p);
		}
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
		 	cb5.setEnabled(false);b3.setEnabled(false);f.setSize(850,230);p.remove(jsp);

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
                   cb4.setEnabled(false);b3.setEnabled(false);
           }
          if(cb5.getSelectedItem().toString().equals("day"))
           {
                  //cb2.setEditable(false);
                  cb2.setEnabled(true);
                   cb3.setEnabled(true);
                   cb4.setEnabled(true);b3.setEnabled(true);
           }
          if(cb5.getSelectedItem().toString().equals("month"))
           {
                  //cb2.setEditable(false);
                  cb2.setEnabled(false);
                   cb3.setEnabled(true);
                   cb4.setEnabled(true);b3.setEnabled(true);
           }
         if(cb5.getSelectedItem().toString().equals("year"))
           {
                  //cb2.setEditable(false);
                  cb2.setEnabled(false);
                   cb3.setEnabled(false);
                   cb4.setEnabled(true);b3.setEnabled(true);
           }

      }

}
}

 class finalreport
{
 public static void main(String args[])
 {

     try {

      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   
  new finalreport1();
 }
}