import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;


class dataFrame extends JFrame 

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



 public dataFrame(String a)
 {
   super(a);
   setLayout(new FlowLayout()); 
   panel = new JPanel();
   add(panel); 
   lab1 = new JLabel("testerid");
   panel.add(lab1);
  
  text1 = new JTextField(10);
  panel.add(text1);

  lab2 = new JLabel("moduleid");
  panel.add(lab2);
  text2  =new JTextField(10);    
  panel.add(text2);   
   
   lab3 = new JLabel("lines");
   panel.add(lab3);
   text3 = new JTextField(10);
   panel.add(text3);
   
   lab4  = new JLabel("comments");
   panel.add(lab4);
   text4 = new JTextField(10);
   panel.add(text4);

bt = new JButton("submit");
   
   panel.add(bt); 
  

   MyWindowAdapter adapter = new MyWindowAdapter(this);
   this.addWindowListener(adapter);
   Handler handler= new Handler(this);
   bt.addActionListener(handler);
   

  

}



}

class MyWindowAdapter extends WindowAdapter
{
 dataFrame f;

 public MyWindowAdapter(dataFrame f)
 {
  
  this.f = f;
   }

 public void windowClosing(WindowEvent we)
 {
  f.setVisible(false);
  }


 }




 


class Handler implements ActionListener 
{ 
   dataFrame f;
  public Handler(dataFrame f)
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
FileInputStream in = new FileInputStream("C:/pulkit/database.properties");
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
PreparedStatement stmt =conn.prepareStatement("insert into testreport(testerid,moduleid,lines,comments)values(?,?,?,?)");  
     stmt.setString(1,f.text1.getText());
    
  stmt.setString(1,f.text1.getText());
    

stmt.setString(2,f.text2.getText());
    

stmt.setString(3,f.text3.getText());
    

stmt.setString(4,f.text4.getText());
    



   
  
stmt.executeUpdate();
     System.out.println("data entered");
 
   JOptionPane.showMessageDialog(f,"details entered");
    conn.close();
      }catch(Exception  e){System.out.println(e);}
       


     }


  }


}

















public class teterreport
{
 public static void main(String a[])
{
 dataFrame f =new dataFrame("create report");
 f.setSize(800,150);
 f.setVisible(true);
}

}
 