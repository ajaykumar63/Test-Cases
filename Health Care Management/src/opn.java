import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.sql.*;
 class opn1 extends JFrame implements ActionListener,ItemListener
{

  JFrame frame;
  JPanel p;
  JLabel  dn,pn,pid,dn1,pn1,pid1,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;
 JButton b1;
ButtonGroup bg1;
String str1="",str2="",s4="",add="",opt="",cost="",prb="",med="",ddd="";
opn1(String str1,String str2,String s4,String add,String opt,String cost,String prb,String med,String ddd)
{
 frame=new JFrame("operation needed::");
  p=new JPanel();
    	p.setLayout(null);
this.str1=str1;
this.str2=str2;
this.s4=s4;
this.add=add;
this.opt=opt;
this.cost=cost;
this.prb=prb;
this.med=med;
this.ddd=ddd;

p.setBackground(Color.white);

    	frame.add(p);
           frame.setVisible(true);
	frame.setResizable(false);
	frame.setSize(400,500);



    	 lb7=new JLabel("operation pay slip");
 p.add(lb7).setBounds(140,5,100,25);

		dn=new JLabel("Doctor name::");p.add(dn).setBounds(20,40,100,25);
 		  pn=new JLabel("Patient name::");p.add(pn).setBounds(20,80,100,25);
		  pid=new JLabel("Patient ID::");p.add(pid).setBounds(20,120,100,25);
		   dn1=new JLabel(str1);p.add(dn1).setBounds(150,40,100,25);
 		  pn1=new JLabel(str2);p.add(pn1).setBounds(150,80,100,25);
		  pid1=new JLabel(s4);p.add(pid1).setBounds(150,120,100,25);

 lb1=new JLabel("admit date::");       
 p.add(lb1).setBounds(20,160,100,25);

lb2=new JLabel(add);
 p.add(lb2).setBounds(150,160,100,25);



 lb3=new JLabel("optime::");
 p.add(lb3).setBounds(20,200,100,25);

 lb4=new JLabel(opt);
 p.add(lb4).setBounds(150,200,100,25);

 lb5=new JLabel("cost::");
 p.add(lb5).setBounds(20,240,100,25);

 lb6=new JLabel(cost);
 p.add(lb6).setBounds(150,240,100,25);

 lb7=new JLabel("operation done on::");
 p.add(lb7).setBounds(20,280,120,25);

 lb8=new JLabel(prb);
 p.add(lb8).setBounds(150,280,100,25);

 lb9=new JLabel("medicines::");
 p.add(lb9).setBounds(20,320,100,25);

 lb10=new JLabel(med);
 p.add(lb10).setBounds(150,320,100,25);

 lb11=new JLabel("discharge date::");
 p.add(lb11).setBounds(20,360,100,25);
 lb12=new JLabel(ddd);
 p.add(lb12).setBounds(150,360,100,25);

 b1=new JButton("PRINT");
	
       b1.addActionListener(this);
	
        p.add(b1).setBounds(150,410,80,25);
	
          

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
                PreparedStatement pstmt=con.prepareStatement("insert into operation values(?,?,?,?,?,?,?,?,?)");
	System.out.println("IN OPERATION NOT NEED VALUES:");
	System.out.println("str1:"+str1);
	System.out.println("str2:"+str2);
	System.out.println("s4:"+s4);
	System.out.println("add:"+add);
	System.out.println("opt:"+opt);
	System.out.println("cost:"+cost);
	System.out.println("prb:"+prb);
	System.out.println("med:"+med);
	System.out.println("ddd:"+ddd);
                   pstmt.setString(3,str1);
                   pstmt.setString(2,str2);
                   pstmt.setString(1,s4);
                   pstmt.setString(4,lb2.getText());
                   pstmt.setString(5,opt);
                   pstmt.setString(6,cost);
                   pstmt.setString(7,prb);
                   pstmt.setString(8,med);
                   pstmt.setString(9,lb12.getText());

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
class opn
{
 public static void main(String args[])
 {
String str1="",str2="",s4="",prblm2="",add="",opt="",cost="",prb="",med="",ddd="";
 try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }   
  new opn1(str1,str2,s4,add,opt,cost,prb,med,ddd);
 }
}

