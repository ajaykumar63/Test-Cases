import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.System.err;
import java.lang.String;
import java.text.MessageFormat;




public final class prescription1 extends JFrame implements Printable,ActionListener,ItemListener
{
   public prescription1( String title )
   {
    super( title );
   }

   
  prescription1  frame;
  JPanel p;
  JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
  JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
  String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9="";
 JRadioButton rb1,rb2,rb3,rb4;
 JButton b1,b2,b3;

  prescription1()
  {
    new prescription1(s1,s2,s3,s4,s5,s6,s7,s8,s9);
  }

  public static void main(String args[])
   {
     try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	new prescription1();
    } 
   catch (Exception e) 
    {
      e.printStackTrace();
    }  
   }


prescription1(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9)
{
  this.s1=s1;
  this.s2=s2;
  this.s3=s3;
  this.s4=s4;
  this.s5=s5;
  this.s6=s6;
  this.s7=s7;
  this.s8=s8;
  this.s9=s9;

  l1=new JLabel(s1);
  l2=new JLabel(s2);
  l3=new JLabel(s3);
  l4=new JLabel(s4);
  l5=new JLabel(s5);
  l6=new JLabel(s6);
  l7=new JLabel(s7);
  l8=new JLabel(s8);
  l9=new JLabel(s9);

    System.out.println("S1 ::"+s1);
    System.out.println("S2 ::"+s2);
    System.out.println("S3 ::"+s3);
    System.out.println("S4 ::"+s4);
    System.out.println("S5 ::"+s5);
    System.out.println("S6 ::"+s6);
    System.out.println("S7 ::"+s7);
    System.out.println("S8 ::"+s8);
    System.out.println("S9 ::"+s9);
   

     frame=new prescription1("prescription::");
     p=new JPanel();
    	p.setLayout(null);
    	frame.add(p);
      p.setBackground(Color.white);
    	

      lb1=new JLabel("Doctor Name::");
       p.add(lb1).setBounds(20,70,100,25);
       p.add(l1).setBounds(120,70,100,25);l1.setForeground(Color.blue);


       lb2=new JLabel("Date::");
       lb3=new JLabel("");lb3.setForeground(Color.red);
       p.add(lb2).setBounds(420,30,70,25);
      
       lb4=new JLabel("TIME::");
       p.add(lb4).setBounds(420,60,70,25);

       lb5=new JLabel("");lb5.setForeground(Color.red);
        p.add(lb5).setBounds(460,60,80,25);
 
             try
               {
                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     Connection con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                     Statement st=con.createStatement();
                	ResultSet rs=st.executeQuery("select count(p_no) from prescription where pre_date='"+predate+"'");
			if(rs.next())
			{
				int cnt=rs.getInt(1);
			}

							
		     		rs=st.executeQuery("select P_no,p_name,p_age,p_gender,p_prob,t_type,na_date,d_name,pre_date,pre_time from prescription where pre_date='"+predate+"'");
                     		for(int i=0;rs.next();i++)
	             		{
                                    for(int j=1;j<=10;j++)	
                             		 s[i][j]=rs.getString(j));           
	             		}
                     rs=st.executeQuery("select to_char(sysdate,'HH:MI') from dual ");
                
                       if(rs.next())
	       {

                            lb5.setText(rs.getString(1));           
	       }
                  
              }
           catch(Exception e)
               {
                     System.out.println("Error in radio11");
                }
    p.add(lb3).setBounds(460,30,80,25);



   lb6=new JLabel("Specalization::");
 p.add(lb6).setBounds(20,100,100,25);
 p.add(l2).setBounds(120,100,100,25);l2.setForeground(Color.blue);

    lb7=new JLabel("P_name::");
    p.add(lb7).setBounds(20,200,100,25);
          p.add(l3).setBounds(100,200,100,25);l3.setForeground(Color.blue);


   lb8=new JLabel("P_id::");
    p.add(lb8).setBounds(250,200,70,25);
          p.add(l4).setBounds(300,200,100,25);l4.setForeground(Color.blue);
 
 lb9=new JLabel("P_Age::");
    p.add(lb9).setBounds(380,200,70,25);
          p.add(l5).setBounds(430,200,50,25);l5.setForeground(Color.blue);

 lb10=new JLabel("P_Gender::");
p.add(lb10).setBounds(20,300,100,25); 
      p.add(l6).setBounds(120,300,100,25);l6.setForeground(Color.blue);

lb11=new JLabel("NEXT APPOINTMENT::");
 p.add(lb11).setBounds(20,460,130,25);
 p.add(l9).setBounds(150,460,120,25);l9.setForeground(Color.blue);


 lb7=new JLabel("P_prob::");
    p.add(lb7).setBounds(240,300,150,25);
          p.add(l7).setBounds(310,300,150,25);l7.setForeground(Color.blue);
lb9=new JLabel("TREATMENT TYPE::");
 p.add(lb9).setBounds(20,370,200,25);
      p.add(l8).setBounds(150,370,100,25);l8.setForeground(Color.blue);


      b1=new JButton("PRINT");
	
       b1.addActionListener(this);
	
        p.add(b1).setBounds(230,540,80,25);
	
          


             

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
             p.remove(b1);

              try
              {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
                Connection con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
                PreparedStatement pstmt=con.prepareStatement("insert into prescription values(?,?,?,?,?,?,?,?,?,?)");
                   pstmt.setString(1,l4.getText());
                   pstmt.setString(2,l3.getText());
                   pstmt.setString(3,l5.getText());
                   pstmt.setString(4,l6.getText());
                   pstmt.setString(5,l7.getText());
                   pstmt.setString(6,l8.getText());
                   pstmt.setString(7,l9.getText());
                   pstmt.setString(8,l1.getText());
                   pstmt.setString(9,lb3.getText());
                   pstmt.setString(10,lb5.getText());

                 int h=pstmt.executeUpdate();

                if(h>=1)
                 {
                   frame.printFrame();
                  frame.dispose();  
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

public int print( Graphics gr,PageFormat pageFormat,int pageIndex )
        {
          
           if ( pageIndex > 0 )
            {
              return Printable.NO_SUCH_PAGE;
            }


           final Graphics2D g2 = ( Graphics2D ) gr;

           final AffineTransform origTransform = g2.getTransform();

            // Pixels here are tiny, used by printer so
           // transform already is scaled to make us draw many more of them.
           final AffineTransform transform = origTransform;

           // apply a border on left and top of equivalent of .5 inch.
          // Our values are scaled into printer pixels.
          transform.translate( 36.0d, 36.0d );

           g2.setTransform( transform );

          // usual Frame.paint()
          paint( gr );
          g2.setTransform( origTransform );
          return Printable.PAGE_EXISTS;
       }



    private void printFrame()
        {
          PrinterJob printerJob = PrinterJob.getPrinterJob();


          printerJob.setPrintable( this );

          if ( printerJob.printDialog() )
           {
             try
             {
                
               printerJob.print();
             }
            catch ( PrinterException e )
             {
               err.println( "Error printing: " + e );
             }
          }
        }

}
