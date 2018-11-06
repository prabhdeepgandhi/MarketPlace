package package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Final extends JFrame {
 JLabel j1,j2,j3;
 
 public Final() {
	 j1 = new JLabel("Thanks For Shopping");
	 j1.setBounds(200, 50,800,80);
	 j1.setForeground(Color.orange);
	j1.setFont(new Font("Broadway", Font.BOLD, 25));
	
	j3 = new JLabel("Your Order has been received Succesfully !");
	 j3.setBounds(130, 100,800,100);
	 j3.setForeground(Color.cyan);
	j3.setFont(new Font("Broadway", Font.BOLD, 17));
	
	
	try
	{
		 Connection con=Db.getCon();
	   	 ResultSet rs1;
		 PreparedStatement stmt2=con.prepareStatement("select * from norm where id=4 and des='Starting'");
	  	 ResultSet rs3=stmt2.executeQuery();
	   	 if(rs3.next())
	   	 {
	   	 byte[] bt2=rs3.getBytes("ing");
	   	 ImageIcon img2=new ImageIcon(bt2);
	   	 j2=new JLabel();
	   	 j2.setIcon(img2);
	   	 j2.setBounds(150,250, 800, 400);
	      
	   	 j2.setVisible(true);
			add (j2);
	   	 }
	   	 
	   	 
   }catch(Exception e1) {
	   System.out.println(e1);
   }
	
	 
	 getContentPane().setBackground(Color.DARK_GRAY);
	 
		add(j1);
		add(j2);
		add(j3);
		setSize(800, 800);
		setLayout(null);
	 setVisible(true);   
	 setLocationRelativeTo(null);
    	
    	//getContentPane().setBackground(Color.DARK_GRAY);
    	
    	
    }
}
