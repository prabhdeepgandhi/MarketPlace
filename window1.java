package package1;

import java.awt.Graphics;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class window1 extends JFrame implements ActionListener{
	
	
		JButton b1,b2;
		JLabel j1,j2,j3;
		public window1() 
		{
	   try
	   {
			 Connection con=Db.getCon();
		   	 ResultSet rs1;
		   	 PreparedStatement stmt1=con.prepareStatement("select * from norm where id=3 and des='Starting'");
		  	 ResultSet rs2=stmt1.executeQuery();
		   	 if(rs2.next())
		   	 {
		   	 byte[] bt1=rs2.getBytes("ing");
		   	 ImageIcon img1=new ImageIcon(bt1);
		   	 j2=new JLabel();
		   	 j2.setIcon(img1);
		   	 j2.setBounds(200, 170, 400, 400);
		      
		   	 j2.setVisible(true);
				add (j2);
		   	 }
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
	       j1 = new JLabel("WELCOME ");
	      
	       j1.setBounds(280, 40,800,200);
	       j1.setVisible(true);
	        
	       b1 = new JButton("Sign In");
	       b1.setBackground(Color.orange);
	       b1.setBounds(570, 600, 120, 100);
	       b1.setFont(new Font("Broadway",Font.BOLD,14));
	       b1.addActionListener(this);
	       b1.setOpaque(true);
	       b1.setBorderPainted(false);
	       
	       b2 = new JButton("Sign Up");
	      // b2.setForeground(Color.blue);
	       b2.setBackground(Color.orange);
	       b2.setBounds(80, 600, 120, 100);
	       b2.setFont(new Font("Broadway",Font.BOLD,14));
	       b2.setVisible(true);
	       b2.addActionListener(this);

	       b2.setOpaque(true);
	       b2.setBorderPainted(false);
	       
	      
	    
	       j1.setFont(new Font("Broadway", Font.ITALIC, 30));
	       
	       j1.setForeground(Color.MAGENTA);
	       
	      // ImageIcon img=new ImageIcon("src\111.jpg");
	      // j2 = new JLabel(img);
	       //j2.setIcon(new ImageIcon("E:\\aish.jpg"));
	      // j2.setIcon(img);
	      // j2.setBounds(200, 200, 400, 400);
	      // j2.setVisible(true);
	    
			setSize(800,800);    
			setLayout(null);    
			setVisible(true); 
			
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.DARK_GRAY);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
			
			add(j1);
		//	add(j2);
			
			add(b1);
			add(b2);
			
			
		} 
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==b1)
			{
				new SignIn();
			}
			else if (e.getSource()==b2)
			{
				new SignUp();
				
			}
			setVisible(false);		
		}
	
		public static void main(String[] args) {
			  new window1();
			
			}
		
		}	