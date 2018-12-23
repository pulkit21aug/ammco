
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;
public class Workloadret  implements ActionListener
{
        JFrame frame;
        JPanel panel;

   
 JLabel labelempid;

       JLabel labeldate;   
//       JPasswordField password;       
JTextField textdate;
          
JLabel labelworkload;
JTextArea textarea;
       
      JTextField textempid;
       
     
        JButton buttonaccept; 



 
   public Workloadret()
   {
         panel =new JPanel();
         frame=new JFrame("EMPLOYEE WORKLOAD");
         
         frame.getContentPane().add(panel);
         panel.setLayout(new FlowLayout());
         
         
         labelempid=new JLabel("Employee ID");
         labelworkload=new JLabel("Workload of Coder");   
         labeldate=new JLabel("date dd/mm/yy"); 
         textdate =new JTextField(15);
         textarea=new JTextArea(2,15);
       
         textempid=new JTextField(15);
         
         buttonaccept=new JButton("SUBMIT");
  
         panel.add(labelempid);         panel.add(textempid);
panel.add(labeldate);
panel.add(textdate);
        
         panel.add(labelworkload);
         panel.add(textarea);


        panel.add(buttonaccept);

       buttonaccept.addActionListener(this);
     

frame.setSize(700,250);
         frame.setVisible(true);
}
  
  public static void main(String args[])
{
         new Workloadret();

 
}




   


public void actionPerformed(ActionEvent  e)
{

        ResultSet r;  
        Object  source=e.getSource();
        if(source==buttonaccept)
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
PreparedStatement stmt =conn.prepareStatement("insert into coderreport(empid,moduleid,source_filename,comments,date)values(?,?,?,?,?)");  
                      //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      //Connection con;

//                      con=DriverManager.getConnection("jdbc:odbc:k","","");
                     
                      Statement stat=conn.createStatement();
                      r=stat.executeQuery("Select * from Authentic3");
  
                     

                     
                     while(r.next())

                       {
    
                     if((r.getString(1)).equals(textempid.getText())) 
                     {               
                       if((r.getString(3)).equals(textdate.getText()))             
                       {
 
                              textarea.setText(r.getString(4));
                 
                       }
                  else 
                  JOptionPane.showMessageDialog (frame,new String("wrong date: ")); 
                   } 
                     

                 else  
                 JOptionPane.showMessageDialog (frame,new String("wrong empid : "));
                    
                    
              }
   
}
            catch(Exception ex){JOptionPane.showMessageDialog (frame,new String("your details have been not registered: "+ex));}
                    
                
             
}
}
}

  

   
   //catch(Exception ex)
//{
  //            JOptionPane.showMessageDialog (frame,new String("your details have been not registered: "+ex));
//}






                                 


     


 




   



