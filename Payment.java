package package1;
import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;


public class Payment  extends JFrame implements ActionListener
{ 	
		JButton b1;
		JLabel l1,l2,l3,l4 ;
		JTextField t1,t2,t3;
		int a,b,c;
		
		public Payment(int product,int productid,int sop)
		{

			a=product;
			b=productid;
			c=sop;
			
			l1=new JLabel("Enter Name   :");
			l1.setBounds(50, 100, 200, 30);
			l1.setFont(new Font("Broadway", Font.BOLD, 15));
			l1.setForeground(Color.CYAN);
			t1=new JTextField();
			t1.setBounds(360, 100, 200, 30);
			
			l2=new JLabel("Enter mobile no.   :");
			l2.setBounds(50, 200, 200, 30);
			l2.setFont(new Font("Broadway", Font.BOLD, 15));
			l2.setForeground(Color.CYAN);
			t2=new JTextField();
			t2.setBounds(360, 200, 200, 30);
			
			l3=new JLabel("Enter Credit/Debit Card no.	:");
			l3.setBounds(50, 300, 400, 30);
			l3.setFont(new Font("Broadway", Font.BOLD, 15));
			l3.setForeground(Color.CYAN);
			t3=new JTextField();
			t3.setBounds(360, 300, 200, 30);
			
			
			b1=new JButton("Buy Now ->>");
			b1.setBounds(300, 450, 150, 40);
			b1.addActionListener(this);
			b1.setOpaque(true);
			b1.setBorderPainted(false);

			b1.setForeground(Color.black);
			b1.setBackground(Color.orange);
		    b1.setFont(new Font("Broadway",Font.BOLD,12));
		    b1.setOpaque(true);
		     b1.setBorderPainted(false);
		   
			add(b1);
			l4=new JLabel("l4");
			
			add(t1);
			add(t2);
			add(t3);
			
			
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			
			getContentPane().setBackground(Color.DARK_GRAY);
			setSize(800, 800);
			setLayout(null);
			setVisible(true);
			setLocationRelativeTo(null);
			
		}
		
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == b1)
			{
				if(e.getSource()==b1)
					
				{
					String sp="";
					if(sp.equals(t1.getText())|| sp.equals(t2)||sp.equals(t2))
					{
						JOptionPane j1=new JOptionPane();
						JOptionPane.showMessageDialog(null, "Fill all fields", "error", JOptionPane.ERROR_MESSAGE);
						
						new Payment(a,b,c);
					}
					else
				{
				try
				{
				Connection con=Db.getCon();
				PreparedStatement ps=con.prepareStatement("insert into product_out value(?,?,?,?,?,?)");
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				ps.setInt(3,a);
				ps.setInt(4,b);
				ps.setInt(6,c);
				ps.setString(5,"2018-11-01");
				ps.executeUpdate();
				

				PreparedStatement p2=con.prepareStatement("update product_in set count=count-1 where product=? and productid=?");
				p2.setInt(1,a);
				p2.setInt(2,b);
				p2.executeUpdate();

				
				
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				new Final();
					}
				
			}
			setVisible(false);
				
		}
		
		}
	}


