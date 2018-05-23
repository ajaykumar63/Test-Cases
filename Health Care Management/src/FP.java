import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class FP1 extends JFrame implements ActionListener,ItemListener
{
  JFrame f;
  JPanel p;
  JTable table;
  JScrollPane jsp;
  JLabel lb1,lb2,lb3,lb4,lb5,lb6;
 String s[][]=new String[50][10];
  JButton b1,b2,b3; 
  ButtonGroup bg1;

  int cnt;
static String type="",date="",form="";

FP1(String type,String form,String date)  
{
    
        this.type=type;
        this.date=date;
        this.form=form;

        System.out.println(type);
        System.out.println(date);

	f=new JFrame("REPORT");
	p=new JPanel();
	p.setLayout(null);
	
        p.setBackground(Color.white);
     
	
 
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);


        b1=new JButton("Print");
        b2=new JButton("Cancel");
        b3=new JButton("Search");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);	

       
     
	
        p.add(b1).setBounds(280,545,80,25);
        p.add(b2).setBounds(470,545,80,25);	
        p.add(b3).setBounds(570,90,80,25);
	
        lb1=new JLabel("TREATMENT NAME:");
	p.add(lb1).setBounds(90,40,150,25);
        
        lb2=new JLabel(type);
   	p.add(lb2).setBounds(190,40,120,25);
     

	lb3=new JLabel("REPORT IN FORM OF:");
	p.add(lb3).setBounds(430,40,130,25);

	lb4=new JLabel(form+" Wise Report");
	p.add(lb4).setBounds(550,40,100,25);
        
	 

	lb5=new JLabel("DD-MON-YYYY:");
	p.add(lb5).setBounds(120,90,90,25);

	lb6=new JLabel(date);
	p.add(lb6).setBounds(200,90,90,25);
      
        
	
        //String colheads[]={"P_NO","P_NAME","P_AGE","P_GENDER","P_PROB","T_TYPE","NA_DATE","D_NAME","PRE_DATE","PRE_TIME"};
	//table=new JTable(s,colheads);
 	//jsp=new JScrollPane(table);

        //p.add(jsp).setBounds(15,130,820,400);         
	 
        f.add(p);
	f.setVisible(true);
	f.setResizable(false);
	f.setSize(850,330);
//table=new JTable(s,colheads);
 //   jsp=new JScrollPane(table);
   


}
public void actionPerformed(ActionEvent ae)
 {

 
  	if(ae.getSource()==b1)
	 	{
		    
		}

              if(ae.getSource()==b2)
               {
                  f.dispose();
               }
             	if(ae.getSource()==b3)
	         {
                    System.out.println("b3 is clicked");
		     try
                     {
                    	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     	 Connection con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                     	 Statement st=con.createStatement();
			 System.out.println("Connecting....");
			 if(type.equals("Prescription"))
			 {
				if(form.equals("day"))
				{
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_no) from prescription where to_char(pre_date,'DD-MON-YYYY')='"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                    	 System.out.println("count ::"+cnt);
				    	rs=st.executeQuery("select P_no,p_name,p_age,p_gender,p_prob,t_type,to_char(na_date,'DD-MON-YYYY'),d_name,to_char(pre_date,'DD-MON-YYYY'),pre_time from prescription where to_char(pre_date,'DD-MON-YYYY')='"+date+"'");         
                       			String s[][]=new String[cnt][11];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<10;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_NO","P_NAME","P_AGE","P_GENDER","P_PROB","T_TYPE","NA_DATE","D_NAME","PRE_DATE","PRE_TIME"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }
		
	



				if(form.equals("month"))
				{
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_no) from prescription where to_char(pre_date,'DD-MON-YYYY') LIKE '"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                   	  System.out.println("count ::"+cnt);
				   	 rs=st.executeQuery("select P_no,p_name,p_age,p_gender,p_prob,t_type,to_char(na_date,'DD-MON-YYYY'),d_name,to_char(pre_date,'DD-MON-YYYY'),pre_time from prescription where to_char(pre_date,'DD-MON-YYYY') LIKE '"+date+"'");         
                       			String s[][]=new String[cnt][11];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<10;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_NO","P_NAME","P_AGE","P_GENDER","P_PROB","T_TYPE","NA_DATE","D_NAME","PRE_DATE","PRE_TIME"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }



				if(form.equals("year"))
				{
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_no) from prescription where to_char(pre_date,'DD-MON-YYYY') LIKE '"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                     System.out.println("count ::"+cnt);
				    rs=st.executeQuery("select P_no,p_name,p_age,p_gender,p_prob,t_type,to_char(na_date,'DD-MON-YYYY'),d_name,to_char(pre_date,'DD-MON-YYYY'),pre_time from prescription where to_char(pre_date,'DD-MON-YYYY') LIKE '"+date+"'");         
                       		String s[][]=new String[cnt][11];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<10;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_NO","P_NAME","P_AGE","P_GENDER","P_PROB","T_TYPE","NA_DATE","D_NAME","PRE_DATE","PRE_TIME"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }

			   }

                           if(type.equals("Operation"))
			   {
				if(form.equals("day"))
				{
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_id) from Operation where to_char(ad_date,'DD-MON-YYYY')='"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                    	 System.out.println("count ::"+cnt);
				    	rs=st.executeQuery("select  P_ID,P_NAME,D_NAME,to_char(AD_date,'DD-MON-YYYY'),OPTIME,COST,OP_DONE,MEDICINES,to_char(DS_date,'DD-MON-YYYY') from Operation  where to_char(ad_date,'DD-MON-YYYY')='"+date+"'");         
                       			String s[][]=new String[cnt][10];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<9;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_ID","P_NAME","D_NAME","AD_DATE","OPTIME","COST","OP_DONE","MEDICINES","DS_DATE"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }
		
	



				if(form.equals("month"))
				{
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_id) from operation where to_char(ad_date,'DD-MON-YYYY') LIKE '"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                   	  System.out.println("count ::"+cnt);
				   	 rs=st.executeQuery("select P_ID,P_NAME,D_NAME,to_char(AD_date,'DD-MON-YYYY'),OPTIME,COST,OP_DONE,MEDICINES,to_char(DS_date,'DD-MON-YYYY') from Operation where to_char(ad_date,'DD-MON-YYYY') LIKE '"+date+"'");         
                       			String s[][]=new String[cnt][10];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<9;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_ID","P_NAME","D_NAME","AD_DATE","OPTIME","COST","OP_DONE","MEDICINES","DS_DATE"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }



				if(form.equals("year"))
				{
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_id) from operation where to_char(ad_date,'DD-MON-YYYY') LIKE '"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                     System.out.println("count ::"+cnt);
				    rs=st.executeQuery("select P_ID,P_NAME,D_NAME,to_char(AD_date,'DD-MON-YYYY'),OPTIME,COST,OP_DONE,MEDICINES,to_char(DS_date,'DD-MON-YYYY') from Operation where to_char(ad_date,'DD-MON-YYYY') LIKE '"+date+"'");         
                       		String s[][]=new String[cnt][10];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<9;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_ID","P_NAME","D_NAME","AD_DATE","OPTIME","COST","OP_DONE","MEDICINES","DS_DATE"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }

				}

				if(type.equals("Long term treatment"))
			 	{
				if(form.equals("day"))
				   {
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_id) from op_not_need where to_char(ad_date,'DD-MON-YYYY')='"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                    	 System.out.println("count ::"+cnt);
				    	rs=st.executeQuery("select  P_ID,P_NAME,D_NAME,to_char(AD_date,'DD-MON-YYYY'),P_PROB,MEDICINES,COST,to_char(DS_date,'DD-MON-YYYY') from op_not_need where to_char(ad_date,'DD-MON-YYYY')='"+date+"'");         
                       			String s[][]=new String[cnt][9];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<8;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_ID","P_NAME","D_NAME","AD_DATE","P_PROB","MEDICINES","COST","DS_DATE"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }
		
	



				if(form.equals("month"))
				{
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_id) from op_not_need where to_char(ad_date,'DD-MON-YYYY') LIKE '"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                   	  System.out.println("count ::"+cnt);
				   	 rs=st.executeQuery("select P_ID,P_NAME,D_NAME,to_char(AD_date,'DD-MON-YYYY'),P_PROB,MEDICINES,COST,to_char(DS_date,'DD-MON-YYYY') from op_not_need where to_char(ad_date,'DD-MON-YYYY') LIKE '"+date+"'");         
                       			String s[][]=new String[cnt][9];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<8;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_ID","P_NAME","D_NAME","AD_DATE","P_PROB","MEDICINES","COST","DS_DATE"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }



				if(form.equals("year"))
				{
				     System.out.println("Connected");
                		     ResultSet rs=st.executeQuery("select count(p_id) from op_not_need where to_char(ad_date,'DD-MON-YYYY') LIKE '"+date+"'");
				     if(rs.next())
				     {
					 cnt=rs.getInt(1);
				     }
	                           
                                     System.out.println("count ::"+cnt);
				    rs=st.executeQuery("select P_ID,P_NAME,D_NAME,to_char(AD_date,'DD-MON-YYYY'),P_PROB,MEDICINES,COST,to_char(DS_date,'DD-MON-YYYY') from op_not_need where to_char(ad_date,'DD-MON-YYYY') LIKE '"+date+"'");         
                       		String s[][]=new String[cnt][9];	
	             		    for(int n=0;rs.next();n++)
	             		     {
                                    	for(int j=0;j<8;j++)	
                                        {
                             		 s[n][j]=""+rs.getString(j+1);
                                         System.out.println(s[n][j]);           
                                        }
	             		     }
					
					String colheads[]={"P_ID","P_NAME","D_NAME","AD_DATE","P_PROB","MEDICINES","COST","DS_DATE"};
					table=new JTable(s,colheads);
 					jsp=new JScrollPane(table);

				 	p.add(jsp).setBounds(15,130,820,400);
				 	f.setSize(850,630);	
				 }			  
                             }
                       }
           	catch(Exception e)
               		{
                          System.out.println("Error in radio"+e);
                	}   
		 
	        }
	
}	
public void itemStateChanged(ItemEvent ie)
{
      
}
}

 class FP
{

 static String type="",date="",form="";

 public static void main(String args[])
 {

     try {

      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   
  new FP1(type,form,date);
 }
}