package package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;


public class Window2  extends JFrame implements ActionListener{
	

	
		JButton b1,b2,b3,b4;
		JLabel j,j2;
		
		public Window2() 
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
			b1=new JButton("Mobiles");
			b1.setBounds(250,300,180,50);
			b1.setForeground(Color.black);
			b1.setBackground(Color.orange);
			b1.addActionListener(this);
			b1.setVisible(true);
			  b1.setOpaque(true);
		       b1.setBorderPainted(false);
		       b1.setFont(new Font("Broadway",Font.BOLD,12));
				
		      add(b1);
			
			b2=new JButton("Laptop");
			b2.setBounds(250,400,180,50);
			b2.setForeground(Color.black);
			b2.setBackground(Color.orange);
			b2.addActionListener(this);
			b2.setVisible(true);
			  b2.setOpaque(true);
		       b2.setBorderPainted(false);
		       b2.setFont(new Font("Broadway",Font.BOLD,12));
				
		      
			add(b2);
			
			b3=new JButton("HeadPhones");
			b3.setBounds(250,500,180,50);
			b3.setForeground(Color.black);
			b3.setBackground(Color.orange);
			b3.addActionListener(this);
			b3.setVisible(true);
			  b3.setOpaque(true);
		       b3.setBorderPainted(false);
		       b3.setFont(new Font("Broadway",Font.BOLD,12));
				
		      
			add(b3);
			 
			j= new JLabel("Shop By Category :");
			j.setBounds(200, 150, 300, 100);
			j.setFont(new Font("Broadway",Font.BOLD,20));
			j.setForeground(Color.magenta);
			add(j);
			
			setSize(800,800);
			setLayout(null);
			setVisible(true);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.DARK_GRAY);
			
			
			
		}

		public void actionPerformed(ActionEvent e) 
		{
			
			if(e.getSource() == b1)
				new Window3(1);
			
			else if(e.getSource() == b2)
				new Window3(2);
			
			else if(e.getSource() == b3)
				new Window3(3);
		
			setVisible(false);
		}
		
/*
		public static void main(String args[])
		{
			new Window2();
		}
		*/
}
