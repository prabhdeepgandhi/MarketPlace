package package1;
import java.awt.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;



public class SignIn extends JFrame implements ActionListener{
		JButton b1,b2;
		JLabel l1,l2,l3,j2;
		JTextField t1;
		JPasswordField pas;
		public SignIn()
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
			l1=new JLabel("User ID	:");
			l1.setForeground(Color.orange);
			l1.setBounds(250, 200, 200, 30);
			t1=new JTextField();
			t1.setBounds(500, 200, 150, 30);
			l1.setFont(new Font("Broadway",Font.BOLD,20));		    
			l2=new JLabel("Password	:");
			l2.setBounds(250, 300, 200, 30);
			l2.setFont(new Font("Broadway",Font.BOLD,20));
			l2.setForeground(Color.orange);
			pas=new JPasswordField();	
			pas.setBounds(500,300, 150, 30);
			
			try
			{
				 Connection con=Db.getCon();
			   	 ResultSet rs1;
				 PreparedStatement stmt2=con.prepareStatement("select * from norm where id=1 and des='Button'");
			  	 ResultSet rs3=stmt2.executeQuery();
			   	 if(rs3.next())
			   	 {
			   	 byte[] bt2=rs3.getBytes("ing");
			   	 ImageIcon img2=new ImageIcon(bt2);
			 	b1=new JButton("Sign In ");
				b1.setBounds(280, 400, 300,80);
				b1.setIcon(img2);
				j2.setVisible(true);
				add (j2);
			   	 }
		   }catch(Exception e1) {
			   System.out.println(e1);
		   }
			b1.addActionListener(this);
			l3=new JLabel("New user ?");
			l3.setFont(new Font("Broadway",Font.BOLD,20));
			l3.setBounds(300,600,150,30);
			l3.setForeground(Color.CYAN);
			b2=new JButton("Sign UP");
			b2.setBounds(450, 600, 100, 30);
			b2.addActionListener(this);
			getContentPane().setBackground(Color.DARK_GRAY);
			b2.addActionListener(this);
			b1.addActionListener(this);
			add(b1);
			add(l1);
			add(l2);
			add(t1);
			add(pas);
			add(l3);
			add(b2);	
			setSize(800, 800);
			setLayout(null);
			setVisible(true);
			setLocationRelativeTo(null);
		}		
		public void actionPerformed(ActionEvent e) {		
			if(e.getSource()==b2)
			{
				new SignUp();
				setVisible(false);
			}
			if(e.getSource()==b1)
			{
				String sp="";
				if(sp.equals(t1.getText())|| sp.equals(String.valueOf(pas.getPassword())))
				{
					JOptionPane j1=new JOptionPane();
					JOptionPane.showMessageDialog(null, "Fill all fields", "error", JOptionPane.ERROR_MESSAGE);	
					new SignIn();
				}
			else
			{
				try
				{
					Connection con=Db.getCon();	
					Statement stmt=con.createStatement();
					String b=String.valueOf(pas.getPassword());
					ResultSet rs=stmt.executeQuery("select * from user where userid='"+t1.getText()+"'");
					rs.first();
					String a=String.valueOf(rs.getString(2));
					
					System.out.println(a);
					System.out.println(b);
					if(a.equals(b))
					{
						new  Window2();
						System.out.println("sign in");
					}
					else 
					{
						JOptionPane j2=new JOptionPane();
						JOptionPane.showMessageDialog(null, "User id and password combination do not match ", "error", JOptionPane.ERROR_MESSAGE);
						new SignIn();
						System.out.println("error");
					}	
					con.close();
				}catch(Exception e1)
				{
					System.out.println("Credential do not match");
					JOptionPane j3=new JOptionPane();
					JOptionPane.showMessageDialog(null, "Credential do not match", "error", JOptionPane.ERROR_MESSAGE);		
					new SignIn();
				}
			}	
		setVisible(false);
		}
	}		
}
				