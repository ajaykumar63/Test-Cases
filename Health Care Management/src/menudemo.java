import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class menudemo
{
	public static void main(String args[])
	{
 

	try {
       
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    }                          
                                //JFrame.setDefaultLookAndFeelDecorated(true);
		new menudemo1();
	}
}
class menudemo1 extends JFrame implements ActionListener
{
	JFrame frame;
	JMenuBar  MenuBar;
	JMenu Menu1,Menu2,Menu3,Menu4;
	JMenuItem MenuItem11,MenuItem12,MenuItem13,MenuItem21,MenuItem22,MenuItem23,MenuItem31,MenuItem32,MenuItem41;		
	JLabel l1;
	JPanel p;
	menudemo1( )
	{
		frame=new JFrame("patient health care system");
                
		MenuBar=new JMenuBar();
		Menu1=new JMenu("master");
		Menu2=new JMenu("transaction");
		Menu3=new JMenu("report");
		Menu4=new JMenu("exit");
                  MenuItem11=new JMenuItem("Patient");		
		MenuItem12=new JMenuItem("doctor");
		MenuItem13=new JMenuItem("treatment");
		p=new JPanel();
		   MenuItem21=new JMenuItem("prescribe");
		MenuItem22=new JMenuItem("perform");
                MenuItem23=new JMenuItem("add doctor");
		
		
                                        MenuItem31=new JMenuItem("report1");
					MenuItem32=new JMenuItem("report2");
                     
                   
				
                                        MenuItem41=new JMenuItem("quit");

		
                                        Menu1.add(MenuItem11);
		  Menu1.addSeparator();
		  Menu1.add(MenuItem12);
		  Menu1.addSeparator();
		  Menu1.add(MenuItem13);
		
                                         Menu2.add(MenuItem21);
		Menu2.addSeparator();
		  Menu2.add(MenuItem22);
		Menu2.addSeparator();
		Menu2.add(MenuItem23);
		Menu2.addSeparator();
		
                Menu3.add(MenuItem31);
		Menu3.addSeparator();
		 Menu3.add(MenuItem32);
		
		 Menu4.add(MenuItem41);

		
                                     MenuBar.add(Menu1);
		MenuBar.add(Menu2);
		MenuBar.add(Menu3);

		MenuBar.add(Menu4);
		
                                     MenuItem11.addActionListener(this);
		MenuItem12.addActionListener(this);
		MenuItem13.addActionListener(this);
		
                                      MenuItem21.addActionListener(this);
		MenuItem22.addActionListener(this);
		MenuItem23.addActionListener(this);
		
                                     MenuItem31.addActionListener(this);	



					MenuItem32.addActionListener(this);
MenuItem41.addActionListener(this);
		
                                      frame.setJMenuBar(MenuBar);
		
l1=new JLabel("PATIENT HEALTH CARE SYSTEM ");
Font f1=new Font("Snap ITC",Font.ITALIC,20);
l1.setFont(f1);
l1.setForeground(Color.BLUE);
p.add(l1).setBounds(125,150,650,100);
frame.setSize(700,500);
//frame.setDefaultLookAndFeelDecorated(true);

		frame.setVisible(true);
 p.setLayout(null);
                 frame.add(p);

	}
	
	public void  actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==MenuItem11)
		{
			JOptionPane.showMessageDialog(this,"you clicked on patient");
                                              // frame.setDefaultLookAndFeelDecorated(true);
		                   new Patient();     
                }
	
		else if(ae.getSource()==MenuItem12)
		{
			JOptionPane.showMessageDialog(this,"you clicked on doctor");
                                                String str1="ajit",str2="vijju",str3="ACCIDENT" ;
                                                 new doctor1(str1,str2,str3);
			
		}
		else if(ae.getSource()==MenuItem13)
		{
			JOptionPane.showMessageDialog(this,"you clicked on treatment");
		                    //treatment1 t=new treatment1();	
		}
		
                                   
else if(ae.getSource()==MenuItem21)
		{
			JOptionPane.showMessageDialog(this,"you clicked on prescribe");
			//presc1 p=new presc1();
		}
		else if(ae.getSource()==MenuItem22)
		{
			JOptionPane.showMessageDialog(this,"you clicked on perform");
			//perform1 p=new perform1();
		}
               else if(ae.getSource()==MenuItem23)
                 {
                      JOptionPane.showMessageDialog(this,"you clicked on add doctor");
			adddoctor1 a =new adddoctor1();
                  }   
		

 else if(ae.getSource()==MenuItem31)
		{
			JOptionPane.showMessageDialog(this,"you clicked on report1");
			new defaulters();
		}
else if(ae.getSource()==MenuItem32)
		{
			JOptionPane.showMessageDialog(this,"you clicked on report2");
			new defaulters1();
		}
else if(ae.getSource()==MenuItem41)
		{
			JOptionPane.showMessageDialog(this,"you clicked on quit");
			frame.dispose( );
		}		
}
}	
           