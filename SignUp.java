package package1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener{
	
		JButton b1 ;

		JLabel l1,l2,l3,l4,j2;
		JTextField t1,t2,t3;

		JPasswordField pas,cpas;
		
		public SignUp()
		{

			try
			{
				 Connection con=Db.getCon();
			   	 ResultSet rs1;
				 PreparedStatement stmt2=con.prepareStatement("select * from norm where id=2 and des='Heading'");
			  	 ResultSet rs3=stmt2.executeQuery();
			   	 if(rs3.next())
			   	 {
			   	 byte[] bt2=rs3.getBytes("ing");
			   	 ImageIcon img2=new ImageIcon(bt2);
			   	 j2=new JLabel();
			   	 j2.setIcon(img2);
			   	 j2.setBounds(0,0, 800, 100);
			      
			   	 j2.setVisible(true);
					add (j2);
			   	 }
			   	 
			   	 
		   }catch(Exception e1) {
			   System.out.println(e1);
		   }
			l1=new JLabel("Enter name ");
			l1.setForeground(Color.orange);
			l1.setBounds(100, 100, 110, 30);
			t1=new JTextField();
			
			t1.setBounds(300, 100, 100, 30);
			
			l2=new JLabel("Enter user id:");
			l2.setForeground(Color.orange);
			l2.setBounds(100, 200, 110, 30);
			
			t2=new JTextField();
			t2.setBounds(300, 200, 100, 30);
			
			pas=new JPasswordField();
			l3=new JLabel("Enter password");
			
			l3.setForeground(Color.orange);
			l3.setBounds(100, 300, 110, 30);

			pas.setBounds(300, 300, 100, 30);
			
			l4=new JLabel("Confirm password ");
			l4.setForeground(Color.orange);
			l4.setBounds(100, 400, 150, 30);
			cpas=new JPasswordField();
			cpas.setBounds(300, 400, 100, 30);
			
			b1=new JButton("Save");
			b1.setForeground(Color.black);
			b1.setBackground(Color.orange);
			b1.setBounds(300, 600, 80, 30);
			b1.addActionListener(this);
			getContentPane().setBackground(Color.DARK_GRAY);
			
			
			
			add(b1);
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			add(t1);
			add(t2);
		//	add(t3);
		//	add(t4);
			add(pas);
			add(cpas);
			setSize(800, 800);
			setLayout(null);
			setLocationRelativeTo(null);
			setVisible(true);
		}
	

		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==b1)
			{
				String sp="";
				if(sp.equals(t1.getText())||sp.equalsIgnoreCase(t2.getText())||sp.equals(String.valueOf(pas.getPassword()))||sp.equals(String.valueOf(cpas.getPassword())))
				{
					JOptionPane j1=new JOptionPane();
					j1.showMessageDialog(null, "Fill all fields", "error", JOptionPane.ERROR_MESSAGE);
					new SignUp();
				}
				else
				{
					String c=String.valueOf(pas.getPassword());
					String d=String.valueOf(cpas.getPassword());
					if(!c.equals(d))
					{
						//System.out.println("wrong");
						JOptionPane j=new JOptionPane();
						j.showMessageDialog(null, "Passwords Do not match", "error",JOptionPane.ERROR_MESSAGE);
						new SignUp();
					}
					else 
					{
						System.out.println("same");
						try
						{
							Connection con=Db.getCon();	
							Statement stmt=con.createStatement();
							PreparedStatement stmt1=con.prepareStatement("insert into user values(?,?,?)");
							stmt1.setString(1, t1.getText());
							stmt1.setString(2, t2.getText());
							stmt1.setString(3, pas.getText());
							
							int i=stmt1.executeUpdate()	;
							
						
							ResultSet rs=stmt.executeQuery("Select * from user ");
							while(rs.next())
							{
								System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
							}
						
							con.close();
							
						}catch(Exception e1)
						{
							JOptionPane j=new JOptionPane();
							j.showMessageDialog(null, "User id already exists", "Error",JOptionPane.ERROR_MESSAGE);
							new SignUp()	;
							
						}
						new SignIn();
						
					}
				}
				}
			setVisible(false);
		}
	}



