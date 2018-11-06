  package package1;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class Window3 extends JFrame implements ActionListener{
		
		JButton b1,b2,b3,b4;
		JLabel l1,l2,l3,l4 ;
		JLabel n1,n2,n3,n4;
		int pro;
		ImageIcon i1,i2,i3,i4;
		
		public Window3(int pro_type)
		{
			pro= pro_type;
			b1=new JButton("Shop now");
			b1.setBounds(100, 300, 130, 50);
			b1.setForeground(Color.black);
			b1.setBackground(Color.orange);
			b1.addActionListener(this);
			  b1.setOpaque(true);
		       b1.setBorderPainted(false);
		       b1.setFont(new Font("Broadway",Font.BOLD,12));
			       
		      
			
			b2=new JButton("Shop now");
			b2.setBounds(500, 300, 130, 50);
			b2.setForeground(Color.black);
			b2.setBackground(Color.orange);
			b2.addActionListener(this);
			  b2.setOpaque(true);
		       b2.setBorderPainted(false);
		       b2.setFont(new Font("Broadway",Font.BOLD,12));
				   
		      
			b3=new JButton("Shop now");
			b3.setBounds(100, 700, 130, 50);
			b3.setForeground(Color.black);
			b3.setBackground(Color.orange);
			b3.addActionListener(this);
			  b3.setOpaque(true);
		       b3.setBorderPainted(false);
		       b3.setFont(new Font("Broadway",Font.BOLD,12));
				
		      
			b4=new JButton("Shop now");
			b4.setBounds(500, 700, 130, 50);
			b4.setForeground(Color.black);
			b4.setBackground(Color.orange);
			b4.addActionListener(this);
			  b4.setOpaque(true);
		       b4.setBorderPainted(false);
		       b4.setFont(new Font("Broadway",Font.BOLD,12));
				
		      
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			
			n1=new JLabel();
			n1.setBounds(100,250,150,30);
			n1.setForeground(Color.cyan);
			n2=new JLabel();
			n2.setBounds(500,250,150,30);
			n2.setForeground(Color.cyan);
			n3=new JLabel();
			n3.setBounds(100,650,150,30);
			n3.setForeground(Color.cyan);
			n4=new JLabel();
			n4.setBounds(500,650,150,30);
			n4.setForeground(Color.cyan);
			
			l1=new JLabel();
			l1.setBounds(100, 50, 200, 200);
			l2=new JLabel();
			l2.setBounds(500, 50, 200, 200);
			l3=new JLabel();
			l3.setBounds(100, 450, 200, 200);
			l4=new JLabel();
			l4.setBounds(500, 450, 200, 200);
			getContentPane().setBackground(Color.DARK_GRAY);
			try
		   	 {
		   	 Connection con=Db.getCon();
		   	 ResultSet rs1;
		   	 PreparedStatement stmt=con.prepareStatement("select name from product_details where product=? and productid=?");
		   	 stmt.setInt(1,pro_type);
		   	 stmt.setInt(2,1);
		   	 rs1=stmt.executeQuery();
		   	 rs1.first();
		   	 n1.setText(rs1.getString(1));
		   	 
		   	 stmt.setInt(1,pro_type);
		   	 stmt.setInt(2,2);
		   	 rs1=stmt.executeQuery();
		   	 rs1.first();
		   	 n2.setText(rs1.getString(1));
		   	 
		   	 stmt.setInt(1,pro_type);
		   	 stmt.setInt(2,3);
		   	 rs1=stmt.executeQuery();
		   	 rs1.first();
		   	 n3.setText(rs1.getString(1));
		   	 
		     stmt.setInt(1,pro_type);
		   	 stmt.setInt(2,4);
		   	 rs1=stmt.executeQuery();
		   	 rs1.first();
		   	 n4.setText(rs1.getString(1));
		   	 
		   	 PreparedStatement stmt1=con.prepareStatement("select * from Images where product=? and productid=?");
		   	 stmt1.setInt(1,pro_type);
		   	 stmt1.setInt(2,1);
		   	 rs1=stmt1.executeQuery();
		   	 if(rs1.next())
		   	 {
		   	 byte[] bt1=rs1.getBytes("img");
		   	 i1=new ImageIcon(bt1);
		   	 l1.setIcon(i1);
		   	 }
		   	 
		   	 stmt1.setInt(1,pro_type);
		   	 stmt1.setInt(2,2);
		   	 rs1=stmt1.executeQuery();
		   	 if(rs1.next())
		   	 {
		   	 byte[] bt1=rs1.getBytes("img");
		   	  i2=new ImageIcon(bt1);
		   	 l2.setIcon(i2);
		   	 }
		   	 
		   	 stmt1.setInt(1,pro_type);
		   	 stmt1.setInt(2,3);
		   	 rs1=stmt1.executeQuery();
		   	 if(rs1.next())
		   	 {
		   	 byte[] bt1=rs1.getBytes("img");
		   	 i3=new ImageIcon(bt1);
		   	 l3.setIcon(i3);
		   	 }
		   	 
		   	 stmt1.setInt(1,pro_type);
		   	 stmt1.setInt(2,4);
		   	 rs1=stmt1.executeQuery();
		   	 if(rs1.next())
		   	 {
		   	 byte[] bt1=rs1.getBytes("img");
		   	 i4=new ImageIcon(bt1);
		   	 l4.setIcon(i4);
		   	 }
		   	 }catch(SQLException e1)
		   	 {
		   		 e1.printStackTrace();
		   	 }			
			add(n1);
			add(n2);
			add(n3);
			add(n4);
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			setSize(800,850);
			setLayout(null);
			setVisible(true);
			setLocationRelativeTo(null);	
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b1)
			{
				new Window4(pro,1,i1);
			}
			else if(e.getSource()==b2)
			{
				new Window4(pro,2,i2);
			}
			else if(e.getSource()==b3)
			{
				new Window4(pro,3,i3);
			}
			else if(e.getSource()==b4)
			{
				new Window4(pro,4,i4);
			}
			setVisible(false);
		}
	}