import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;

class dataFrame1 extends JFrame 

{  
  JLabel lab1;
  JButton bt; 
  JPanel panel;
  JTextField text1; 
  Container content;
  JLabel lab2;
  JLabel lab3;
  JLabel lab4;
  JTextField text2;
 JTextField text3;
 JTextField text4; 



 public dataFrame1(String a)
 {
   super(a);
   setLayout(new FlowLayout()); 
   panel = new JPanel();
   add(panel); 
   lab1 = new JLabel("empid");
   panel.add(lab1);
  
  text1 = new JTextField(10);
  panel.add(text1);

  lab2 = new JLabel("moduleid");
  panel.add(lab2);
  text2  =new JTextField(10);    
  panel.add(text2);   
   
   lab3 = new JLabel("source_filename");
   panel.add(lab3);
   text3 = new JTextField(10);
   panel.add(text3);
   
   lab4  = new JLabel("comments");
   panel.add(lab4);
   text4 = new JTextField(10);
   panel.add(text4);

bt = new JButton("submit");
   
   panel.add(bt); 
  

   MyWindowAdapter1 adapter = new MyWindowAdapter1(this);
   this.addWindowListener(adapter);
   Handler1 handler= new Handler1(this);
   bt.addActionListener(handler);
   

  

}



}

class MyWindowAdapter1 extends WindowAdapter
{
 dataFrame1 f;

 public MyWindowAdapter1(dataFrame1 f)
 {
  
  this.f = f;
   }

 public void windowClosing(WindowEvent we)
 {
  f.setVisible(false);
  }


 }




 


class Handler1 implements ActionListener 
{ 
   dataFrame1 f;
  public Handler1(dataFrame1 f)
    {
    this.f = f;
     }

 public void actionPerformed(ActionEvent ae)

 { 
//String arg =(String)ae.getActionCommand();
    if(ae.getSource()==f.bt)
    { 

   
     try
      {


       Properties props =new Properties();
FileInputStream in = new FileInputStream("C:/ammco/database.properties");
props.load(in);
in.close();

String drivers = props.getProperty("jdbc.drivers");
if(drivers!=null)
System.out.println("driver present");

Class.forName(drivers);
//System.setProperty("jdbc.drivers",drivers);
String url = props.getProperty("jdbc.url");
String username = props.getProperty("jdbc.username");
 
 String password = props.getProperty("jdbc.password");

 System.out.println("conn");

       Connection conn =DriverManager.getConnection(url,username,password);
    System.out.println("connection opened");
PreparedStatement stmt =conn.prepareStatement("insert into coderreport(empid,moduleid,source_filename,comments,date)values(?,?,?,?,?)");  
     stmt.setString(1,f.text1.getText());
    
  stmt.setString(2,f.text2.getText());
    

stmt.setString(3,f.text3.getText());
    

stmt.setString(4,f.text4.getText());
    


    
java.util.Date date =new java.util.Date();
SimpleDateFormat sdf;
sdf = new SimpleDateFormat("MM dd yyyy");
stmt.setString(5,sdf.format(date));
    




   
  
stmt.executeUpdate();
     System.out.println("data entered");
 
   JOptionPane.showMessageDialog(f,"details entered");
    
f.text1.setText("");f.text2.setText("");f.text3.setText("");f.text4.setText("");


conn.close();
      }catch(Exception  e){System.out.println(e);}
       


     }


  }


}

















public class coderreport
{
 public static void main(String a[])
{
 dataFrame1 f =new dataFrame1("create report");
 f.setSize(900,150);
 f.setVisible(true);
}

}
 