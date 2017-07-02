import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;


public class Farooq extends Frame implements ActionListener 
{
	Button b;
	Button reset;
	TextField tf;
	TextField tf1;
	Label l1;
	Label l2;
	TextArea ta1;
	TextArea ta2;
	Label l3;
	Label l4;
	Label l5;
	Label l6;
	Farooq()
{

	ta1=new TextArea();
	ta1.setBounds(40,220,150,150);
	l4=new Label("First name:");
	l4.setBounds(40,190,150,20);
	ta2=new TextArea();
	ta2.setBounds(250,220,150,150);
	l3=new Label("Last name:");
	l3.setBounds(250,190,150,20);
	l1=new Label("Enter First name:");
	l1.setBounds(10,50,150,20);
	tf=new TextField();
	tf.setBounds(150,50,150,20);
	l2=new Label("Enter Second name:");
	l2.setBounds(10,80,150,20);
	tf1=new TextField();
	tf1.setBounds(150,80,150,20);
	l5=new Label();
	l5.setBounds(150,120,150,40);
	
	b=new Button("Register");
	b.setBounds(150,150,80,30);
	b.addActionListener(this);
	reset=new Button("Reset");
	reset.setBounds(250,150,80,30);
	reset.addActionListener(this);
	
	add(b);
	add(reset);
	add(tf);
	add(tf1);
	add(l1);
	add(l2);
	add(ta1);
	add(ta2);
	add(l3);
	add(l4);
	add(l5);
	
	setSize(400,400);
	setLayout(null);
	setVisible(true);
/*	

try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/farooq","root","");  

	Statement stmt=con.createStatement();  
	
	
	stmt.executeUpdate("Insert into name values('"+tf.getText()+"', '"+tf1.getText()+"')");
	ResultSet rs=stmt.executeQuery("Select * from name");
	while(rs.next())  
	{
		//String first = rs.getString("first");
        //String last = rs.getString("last");
		//ta1.append(rs.getString(1)+"\n");
		//ta2.append(rs.getString(2)+"\n");
		//ta2.setText(last);
	}
		  
	
}
catch(Exception e)
{ 
	System.out.println(e);
}
*/	
addWindowListener(new WindowAdapter(){  
    public void windowClosing(WindowEvent e) {  
        dispose();  
    }  
});  


}

	public void actionPerformed(ActionEvent e) {
	
	
	try {
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con;
	con = DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/farooq","root","");
	
	l5.setText("Hi "+tf.getText()+" "+tf1.getText()+"! Welcome");
	 
	Statement stmt=con.createStatement();
	stmt.executeUpdate("Insert into name values('"+tf.getText()+"', '"+tf1.getText()+"')");
	
	ResultSet rs=stmt.executeQuery("Select * from name");
		while(rs.next())
			
	{
		ta1.append(rs.getString(1)+"\n");
		ta2.append(rs.getString(2)+"\n");
		
		/*

		s=s+rs.getString(1);
		s1=s1+rs.getString(2);
		
		ta1.setText(s+ "\r\n");
		ta2.setText(s1+"\r\n");
	*/
	}

	rs.close();
	
		if(e.getSource()==reset){
		tf.setText("");
		tf1.setText("");
		ta1.setText("");
		ta2.setText("");
		l5.setText("");
	}	
	}
catch (SQLException e1) {

	e1.printStackTrace();
} 
	catch (ClassNotFoundException e1) {

	e1.printStackTrace();
}
	
}


public static void main(String args[])
{
	Farooq f=new Farooq();
	
}
}
