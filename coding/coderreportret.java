
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;
public class coderreportret  implements ActionListener
{
        JFrame frame;
        JPanel panel;

   
 JLabel labelempid;

       JLabel labeldate;   
      
JTextField textdate;

          
JLabel labelmoduleid;
JLabel labelsource_filename;
JLabel labelcomments;
JTextArea textareamodule;
JTextArea textareafilename;
JTextArea textareacomments;       
      JTextField textempid;
       
     
        JButton buttonaccept; 



 
   public coderreportret()
   {
         panel =new JPanel();
         frame=new JFrame("CODER REPORT RETREIVAL");
         
         frame.getContentPane().add(panel);
         panel.setLayout(new FlowLayout());
         
         
         labelempid=new JLabel("Employee ID");
         labelmoduleid=new JLabel("Module_id");
          labelsource_filename=new JLabel("Source_filename");
          labelcomments=new JLabel("Comments");   
         labeldate=new JLabel("date mm dd yyyy"); 
         textdate =new JTextField(15);
         textareamodule=new JTextArea(2,25);
         textareafilename=new JTextArea(2,25);
         textareacomments=new JTextArea(2,25);        
         textempid=new JTextField(15);
         
         buttonaccept=new JButton("SUBMIT");
  
         panel.add(labelempid);         
         panel.add(textempid);
panel.add(labeldate);
panel.add(textdate);
        
         panel.add(labelmoduleid);
         panel.add(textareamodule);
panel.add(labelsource_filename);
panel.add(textareafilename);

panel.add(labelcomments);
panel.add(textareacomments);



        panel.add(buttonaccept);

       buttonaccept.addActionListener(this);
     

frame.setSize(700,350);
         frame.setVisible(true);
}
  
  public static void main(String args[])
{
         new coderreportret();

 
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
//PreparedStatement stmt =conn.prepareStatement("insert into coderreport(empid,moduleid,source_filename,comments,date)values(?,?,?,?,?)");  
                      //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      //Connection con;

//                      con=DriverManager.getConnection("jdbc:odbc:k","","");
                     
                      Statement stat=conn.createStatement();
                      r=stat.executeQuery("Select * from creport");
  
                     

                     
                     while(r.next())

                       {
    
                     if((r.getString(1)).equals(textempid.getText())  ) 
                     {               
/*                      if((r.getString(5)).equals(textdate.getText()))             
                       {
 
                              textareamodule.setText(r.getString(2));
                              textareafilename.setText(r.getString(3));
                              textareacomments.setText(r.getString(4));
                      
                       }*/
                 // else 
                 // JOptionPane.showMessageDialog (frame,new String("wrong date: "));
  
   textareamodule.setText(r.getString(2));
                              textareafilename.setText(r.getString(3));
                              textareacomments.setText(r.getString(4));
                                             
} 
                     

               //  else  
              //   JOptionPane.showMessageDialog (frame,new String("wrong empid : "));
                    
                    
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






                                 


     


 




   



