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


 public final class opn1 extends JFrame implements Printable,ActionListener,ItemListener
{
 public opn1( String title )
   {
    super( title );
   }


  opn1 frame;
  JPanel p;
  JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;
 JButton b1;
ButtonGroup bg1;
String ad="",opt="",cost="",prb="",med="",dd="";

opn1()
{
 new opn1(ad,opt,cost,prb,med,dd);
 }


 public static void main(String args[])
 {
 try 
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        new opn1();
   } 
catch (Exception e)
  {
      e.printStackTrace();
    }   
}


opn1(String add,String opt,String cost,String prb,String med,String ddd)
{
 frame=new opn1("operation needed::");
  p=new JPanel();
    	p.setLayout(null);
this.ad=ad;
this.opt=opt;
this.cost=cost;
this.prb=prb;
this.med=med;
this.dd=dd;

p.setBackground(Color.white);

    	frame.add(p);
           frame.setVisible(true);
	frame.setResizable(false);
	frame.setSize(400,430);

    	 lb7=new JLabel("OPERATION PAY SLIP");
 p.add(lb7).setBounds(140,15,150,25);


 lb1=new JLabel("Admit date::");       
 p.add(lb1).setBounds(20,50,100,25);

lb2=new JLabel(add);
 p.add(lb2).setBounds(170,50,100,25);



 lb3=new JLabel("Optime::");
 p.add(lb3).setBounds(20,100,100,25);

 lb4=new JLabel(opt);
 p.add(lb4).setBounds(170,100,100,25);

 lb5=new JLabel("Cost::");
 p.add(lb5).setBounds(20,150,100,25);

 lb6=new JLabel(cost);
 p.add(lb6).setBounds(170,150,100,25);

 lb7=new JLabel("Operation done on::");
 p.add(lb7).setBounds(20,200,150,25);

 lb8=new JLabel(prb);
 p.add(lb8).setBounds(170,200,150,25);

 lb9=new JLabel("Medicines::");
 p.add(lb9).setBounds(20,250,100,25);

 lb10=new JLabel(med);
 p.add(lb10).setBounds(170,250,100,25);

 lb11=new JLabel("Discharge date::");
 p.add(lb11).setBounds(20,300,100,25);
 lb12=new JLabel(ddd);
 p.add(lb12).setBounds(170,300,100,25);

 b1=new JButton("PRINT");
	
       b1.addActionListener(this);
	
        p.add(b1).setBounds(150,350,80,25);
	
          

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((screenSize.width - frame.getWidth()) / 2, (screenSize.height - frame.getHeight()) / 2); 
}   



public void actionPerformed(ActionEvent ae)
       {
          if(ae.getSource()==b1)
           {
             p.remove(b1);
            frame.printFrame();
            frame.dispose();
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



