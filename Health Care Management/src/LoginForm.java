
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



class LoginForm1 extends JFrame implements ActionListener
{
	JTextField txt_uname;
	JPasswordField txt_upass;
	JLabel lbl_uname,lbl_upass;
	JButton bt_login,bt_cancel;
	Connection con;
	Statement st;
	ResultSet rs;
	JFrame Logfrm;
	Panel panel;
	String username="",password="";
	LoginForm1()
	{
		
		
		try
		{
			Logfrm=new JFrame("USER LOGIN");
			panel=new Panel();
			
		}catch(Exception e){}
		setLayout(null);
		lbl_uname=new JLabel("ENTER USER ID:");
		lbl_upass=new JLabel("ENTER PASSWORD :");
		txt_uname=new JTextField(10);
		txt_upass=new JPasswordField(10);
		bt_login=new JButton("LOGIN");
		bt_cancel=new JButton("CANCEL");
		
		bt_login.setActionCommand("Login");
		bt_cancel.setActionCommand("Cancel");
		txt_uname.setText("");
		txt_upass.setText("");
		panel.add(lbl_uname).setBounds(25,40,130,30);
		panel.add(lbl_upass).setBounds(25,90,130,30);
		panel.add(txt_uname).setBounds(145,45,110,25);
		panel.add(txt_upass).setBounds(145,95,110,25);
		panel.add(bt_login).setBounds(50,145,80,30);
		panel.add(bt_cancel).setBounds(150,145,80,30);
		bt_login.addActionListener(this);
		bt_cancel.addActionListener(this);
		
		panel.setLayout(null);
		
		Logfrm.add(panel);
		Logfrm.setSize(300,250);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Logfrm.setLocation((screenSize.width - Logfrm.getWidth()) / 2, (screenSize.height - Logfrm.getHeight()) / 2);
		Logfrm.setUndecorated(false);
		Logfrm.setResizable(false);
		Logfrm.setVisible(true);
	}
  
	public void actionPerformed(ActionEvent ae)
   {
		//System.out.println("within action method");
		try
		{		
		if(ae.getSource()==bt_login)
		   {
		   	System.out.println(" u pressed login button");
if(txt_uname.getText().equals(""))
			   JOptionPane.showMessageDialog(this,"User ID shouldn't be blank","Error Message",JOptionPane.ERROR_MESSAGE);
else if(txt_upass.getText().equals(""))
JOptionPane.showMessageDialog(this,"Password shouldn't be blank","Error Message",JOptionPane.ERROR_MESSAGE);
else{
	 
			   
	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");			
	  con=DriverManager.getConnection("jdbc:odbc:aliet","ajay","ajay");
	   st=con.createStatement();
String username=txt_uname.getText();
                             String password=txt_upass.getText();
                                    System.out.println("username="+username);
                                   System.out.println("password="+password);
                          	
                                              	
	            rs=st.executeQuery("select * from login where ENTERUSERID='"+txt_uname.getText()+"' and ENTERPASSWORD ='"+txt_upass.getText()+"'");
	           
			   if(rs.next())
			   {
				   JOptionPane.showMessageDialog(this,"Your Authentication Successful..");
				   Logfrm.dispose();
				   new menudemo1();
			   }
			   else
			   {
			   
				   JOptionPane.showMessageDialog(this,"Please Enter the Correct UserID and Password","Error Message",JOptionPane.ERROR_MESSAGE);
			   }
	            
		   }   
		   
	   }
		if(ae.getSource()==bt_cancel)
		{
			con.close();
			System.exit(0);
		}
		
		}catch(Exception e){}
   }
	
	
}

class LoginForm 
{

	public static void main(String[] args)
 {

try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception e) {
      e.printStackTrace();
    } 
 new LoginForm1();
 }

}
