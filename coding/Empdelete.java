import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class Empdelete  implements ActionListener
{
        JFrame frame;
        JPanel panel;

        JLabel labelempid;
        

        
        JTextField textempid;
        

        GridBagLayout gbobject;
        GridBagConstraints gbc;
     
        JButton buttonaccept; 

  public static void main(String args[])
{
         new Empdelete();
}

 
 public Empdelete()
{
         panel =new JPanel();
         frame=new JFrame("EMPLOYEE REGISTRATION");
// ResultSet r;      
         
         gbobject=new GridBagLayout();
         gbc=new GridBagConstraints();
        frame.getContentPane().add(panel);
 panel.setLayout(gbobject); 
         
         labelempid=new JLabel("Employee ID");
        
        
         textempid=new JTextField(15);
        
         buttonaccept=new JButton("SUBMIT");


         

    gbc.anchor=GridBagConstraints.NORTHWEST;  
  gbc.gridx=1;
         gbc.gridy=15;
         gbobject.setConstraints(labelempid,gbc);
         panel.add(labelempid);
         

gbc.anchor=GridBagConstraints.NORTHWEST;
         gbc.gridx=4;
         gbc.gridy=15;
         gbobject.setConstraints(textempid,gbc);            
         panel.add(textempid);

         

        
gbc.anchor=GridBagConstraints.NORTHWEST;
gbc.gridx=10;
         gbc.gridy=50;
         gbobject.setConstraints(buttonaccept,gbc);
        panel.add(buttonaccept);   
frame.setSize(450,200);
         frame.setVisible(true);

       buttonaccept.addActionListener(this);
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


          
         
           PreparedStatement stat2=conn.prepareStatement("delete from  Registration where cEmpid='textempid.getText()'");

            stat2.executeUpdate();
             
JOptionPane.showMessageDialog (frame,new String("your details have been deleted"));
textempid.setText("");



}      

   catch(Exception ex)
{
              JOptionPane.showMessageDialog (frame,new String("your details have been not registered: "+ex));
}
}
}
}
                                 


     


 




   



