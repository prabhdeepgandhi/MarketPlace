package package1 ;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Window4 extends JFrame implements ActionListener
{
	JLabel f1,f2,f3,f4,f5;
	JTextField t1,t2,t4,t5;
	JTextArea t3;
	JLabel p1,p2;
	JButton b1;
	JLabel err1;
	JLabel imgL;
	int sop1,a1,b2;
    Window4(int a,int b,ImageIcon img)
	{
    	a1=a;
    	b2=b;
		System.out.println(a + "  "+b);
		f1= new JLabel("Product Name");
		f1.setBounds(200, 350, 130, 30);
		t1= new JTextField();
		t1.setBounds(360,350,130,30);
		f1.setForeground(Color.cyan);

		f2 = new JLabel("Product ID");
		f2.setBounds(200, 400, 130, 30);
		t2= new JTextField();
		t2.setBounds(360,400,130, 30);
		f2.setForeground(Color.cyan);
		
		f3 = new JLabel("Descrption");
		f3.setBounds(200,450,130,40);
		t3= new JTextArea();
		t3.setBounds(360,450, 230, 120);

		f3.setForeground(Color.cyan);
		
		f4= new JLabel("MRP");
		f4.setBounds(200,600,50,30);
		p1=new JLabel();
		p1.setBounds(360,600, 50, 30);
		f4.setForeground(Color.cyan);
		p1.setForeground(Color.MAGENTA);
		
		
		f5 = new JLabel("Special Price");
		f5.setBounds(200,650, 100, 30);
		p2=new JLabel();
		p2.setBounds(360,650,50,30);
		f5.setForeground(Color.cyan);
		p2.setForeground(Color.MAGENTA);
		
		b1=new JButton("Buy Now");
		b1.setBounds(550, 600, 150, 50);
		b1.setBackground(Color.orange);
		b1.addActionListener(this);
		  b1.setOpaque(true);
		  b1.setFont(new Font("Broadway",Font.BOLD,12));
		    
	       b1.setBorderPainted(false);
	    
		
		err1=new JLabel();
		err1.setBounds(400,700,100,30);
		
		imgL=new JLabel(img);
		imgL.setBounds(300,100,200,200);
		imgL.setVisible(true);
		
		getContentPane().setBackground(Color.DARK_GRAY);
		
		setSize(800,800);
		setLayout(null);
		setVisible(true);
		add(f1);
		add(f2);
		add(f3);
		add(f4);
		add(f5);
		add(t1);
		add(t2);
		add(t3);
		add(p1);
		add(p2);
		add(b1);
		add(imgL);
		
		setLocationRelativeTo(null);
	
		try
	   	 {
	   	 Connection con=Db.getCon();
	   	 ResultSet rs1;
	   	 
	   	 PreparedStatement stmt=con.prepareStatement("select * from product_details where product=? and productid=?");
	   	 stmt.setInt(1,a);
	   	 stmt.setInt(2,b);
	   	 rs1=stmt.executeQuery();
	   	 rs1.first();
	   	 t1.setText(rs1.getString(3));
	   	 t2.setText(rs1.getString(2));
	   	 t3.setText("3GB RAM \n 6.1 inch Screen \n Android Nougat \n  2.45 Hz Octa core Processor \n Qualcomm Snapdragon 835");
	   	 t1.disable();
	   	 t2.disable();
	   	 t3.disable();
	   	 
	   	 CallableStatement cst=con.prepareCall("{call check6(?,?)}");
	   	 cst.setInt(1,a);
	   	 cst.setInt(2,b);
	   	 cst.execute();
	   	 
	   	 stmt=con.prepareStatement("select mrp,sop from product_in where product=? and productid=?" );
	   	 stmt.setInt(1,a);
	   	 stmt.setInt(2,b);
	   	 rs1=stmt.executeQuery();
	   	 rs1.first();
	   	 sop1=rs1.getInt(2);
	   	 p1.setText(Integer.toString(rs1.getInt(1)));
	   	 p2.setText(Integer.toString(rs1.getInt(2)));
	   	 
	   	 PreparedStatement stmt1=con.prepareStatement("select * from images where product="+a+" and productid="+b);
//	   	 stmt1.setInt(1,a);
//	   	 stmt1.setInt(2,b);
	   	 ResultSet rs2=stmt1.executeQuery();
	   	 //System.out.println(rs2.next());
	   	 if(rs2.next())
	   	 {
	   	 byte[] bt1=rs2.getBytes("img");
	   	 ImageIcon img1=new ImageIcon(bt1);
	   	 imgL=new JLabel();
	   	 imgL.setIcon(img1);
			imgL.setBounds(300,100,200,200);
			imgL.setVisible(true);
			add (imgL);
	   	 }
	   	 
	   	 }catch(SQLException e1)
	   	 {
	   		 err1.setText(e1.getMessage());
	   	 }
	   	 
	    }
  
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==b1)
    	{
    		new Payment(a1,b2,sop1);
    		setVisible(false);
    		
    	}
    	
    }
 /*   public static void main(String[] args) 
    {
		new Window4(1,1);
	}*/
}