import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;
public class Addworkload  implements ActionListener 
{
        JFrame frame;
        JPanel panel;

        JLabel labelworkload;    
        JLabel labelempid;
        JLabel d; 
       

        JTextField textworkload;
       
        JTextField textempid;
       
        JTextField td;      
        JButton buttonaccept; 

  public static void main(String args[])
{
         new Addworkload();
}

 
 public Addworkload()
{
         panel =new JPanel();
         frame=new JFrame("EMPLOYEE WORKLOAD");
         frame.setSize(300,300);
         frame.setVisible(true);
         frame.getContentPane().add(panel);

         labelworkload=new JLabel("WORKLOAD");
         
         labelempid=new JLabel("Employee ID");
           
         d=new JLabel("Date dd-mm-yy"); 

         textworkload =new JTextField(60);
         
         textempid=new JTextField(15);
         
         td=new JTextField(8);
         buttonaccept=new JButton("SUBMIT");
  
         panel.add(labelworkload);
         panel.add(textworkload);

        
         panel.add(labelempid);
         panel.add(textempid);

         panel.add(d);
         panel.add(td);     
        panel.add(buttonaccept);

       buttonaccept.addActionListener(this);
     }
        public void actionPerformed(ActionEvent  e)
       {
  
        Object  source=e.getSource();
        if(source==buttonaccept)
        {
    
                
      try
      {


       Properties props =new Properties();
FileInputStream in = new FileInputStream("C:/piyush/database.properties");
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
       //PreparedStatement stmt =conn.prepareStatement("insert into coderreport(empid,moduleid,source_filename,comments,date)values(?,?,?,?,?)");      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                   //   Connection con;

//                      con=DriverManager.getConnection("jdbc:odbc:kk","","");
                      System.out.println("connected"); 
                     
                      PreparedStatement stat2=conn.prepareStatement("insert into Sreg(workload,cEmpid,cDate) values(?,?,?)");

               stat2.setString(1,textworkload.getText());
            
               stat2.setString(2,textempid.getText());
               stat2.setString(3,td.getText());            

               stat2.executeUpdate();

              JOptionPane.showMessageDialog (frame,new String("Employee  details have been registered"));

 }      

   catch(Exception ex)
{
              JOptionPane.showMessageDialog (frame,new String("your details have been not registered: "+ex));
}
}
}
}
                                 


     


 




   



