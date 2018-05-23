import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class opnnt1 extends JFrame implements ActionListener,ItemListener
{

  JFrame frame;
  JPanel p;
  JLabel dn,pn,pid,dn1,pn1,pid1,pb,pb1,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
 JButton b1;
ButtonGroup bg1;
String str1="",str2="",s4="",prblm="",ad="",cost="",med="",dd="";
opnnt1(String str1,String str2,String s4,String prblm,String ad,String cost,String med,String dd)
{
this.str1=str1;
this.str2=str2;
this.s4=s4;
this.prblm=prblm;
this.ad=ad;
this.cost=cost;
this.med=med;
this.dd=dd;
 frame=new JFrame("operation not needed::");
  p=new JPanel();
    	p.setLayout(null);

p.setBackground(Color.white);

    	frame.add(p);
           frame.setVisible(true);
	frame.setResizable(false);
	frame.setSize(400,500);

  		  dn=new JLabel("Doctor name::");p.add(dn).setBounds(40,60,100,25);
 		  pn=new JLabel("Patient name::");p.add(pn).setBounds(40,100,100,25);
		  pid=new JLabel("Patient ID    ::");p.add(pid).setBounds(40,140,100,25);
		   dn1=new JLabel(str1);p.add(dn1).setBounds(150,60,100,25);
 		  pn1=new JLabel(str2);p.add(pn1).setBounds(150,100,100,25);
		  pid1=new JLabel(s4);p.add(pid1).setBounds(150,140,100,25);
		  pb=new JLabel("Patient problem::");p.add(pb).setBounds(40,220,100,25);
		  pb1=new JLabel(prblm);p.add(pb1).setBounds(150,220,100,25);	

 lb1=new JLabel("admit date   ::");
 p.add(lb1).setBounds(40,180,100,25);

lb1=new JLabel(ad);
 p.add(lb1).setBounds(150,180,100,25);

 lb2=new JLabel("medicines    ::");
 p.add(lb2).setBounds(40,260,100,25);
lb1=new JLabel(med);
 p.add(lb1).setBounds(150,260,100,25);

 lb3=new JLabel("cost     ::");
 p.add(lb3).setBounds(40,300,100,25);
lb1=new JLabel(cost);
 p.add(lb1).setBounds(150,300,100,25);

 lb4=new JLabel("discharge date::");
 p.add(lb4).setBounds(40,340,100,25);
lb1=new JLabel(dd);
 p.add(lb1).setBounds(150,340,100,25);

 lb5=new JLabel("LONG TERM TREATMENT");
 p.add(lb5).setBounds(130,20,150,25);

 b1=new JButton("PRINT");
	
       b1.addActionListener(this);
	
        p.add(b1).setBounds(150,400,80,25);
	
          

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((screenSize.width - frame.getWidth()) / 2, (screenSize.height - frame.getHeight()) / 2); 
}   



public void actionPerformed(ActionEvent ae)
       {
          if(ae.getSource()==b1)
           {
              try
              {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
                Connection con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                PreparedStatement pstmt=con.prepareStatement("insert into OP_NOT_NEED values(?,?,?,?,?,?,?,?)");
		System.out.println("IN OPERATION VALUES:");
		System.out.println("str1:"+str1);
		System.out.println("str2:"+str2);
		System.out.println("s4:"+s4);
		System.out.println("ad:"+ad);
		System.out.println("cost:"+cost);
		System.out.println("prb:"+prblm);
		System.out.println("med:"+med);
		System.out.println("dd:"+dd);
                   pstmt.setString(3,str1);
                   pstmt.setString(2,str2);
                   pstmt.setString(1,s4);
                   pstmt.setString(4,ad);
                   pstmt.setString(7,cost);
                   pstmt.setString(5,prblm);
                   pstmt.setString(6,med);
                   pstmt.setString(8,dd);

                 int h=pstmt.executeUpdate();

                if(h>=1)
                 {
                   
                 }
               else
                {
                   System.out.println("Values not Inserted....");
                }               
             }
            catch(Exception e){System.out.println(e.toString());}

           }
       }   

public void itemStateChanged(ItemEvent ie)
{

}
}
class opnnt
{
 public static void main(String args[])
 {
String str1="",str2="",s4="",prblm="",ad="",cost="",med="",dd="";
 try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   
  new opnnt1(str1,str2,s4,prblm,ad,med,cost,dd);
 }
}

