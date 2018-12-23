import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class Emprecord  implements ActionListener
{
        JFrame frame;
        JPanel panel;

        JLabel labelfname;
        JLabel labellname;
        JLabel labelempid;
        JLabel labelphone;
        JLabel labelpassword;

        JTextField textfname;
        JTextField textlname;
        JTextField textempid;
        JTextField textphone;
        JPasswordField textpassword;

        GridBagLayout gbobject;
        GridBagConstraints gbc;
     
        JButton buttonaccept; 

  public static void main(String args[])
{
         new Emprecord();
}

 
 public Emprecord()
{
         panel =new JPanel();
         frame=new JFrame("EMPLOYEE REGISTRATION");
       
         
         gbobject=new GridBagLayout();
         gbc=new GridBagConstraints();
        frame.getContentPane().add(panel);
 panel.setLayout(gbobject); 
         labelfname=new JLabel("First Name");
         labellname=new JLabel("Last Name");
         labelempid=new JLabel("Employee ID");
         labelphone=new JLabel("Phone");
         labelpassword =new JLabel("Password");
         textfname =new JTextField(15);
         textlname=new JTextField(15);
         textempid=new JTextField(15);
         textphone=new JTextField(15);
         textpassword=new JPasswordField(15);
         buttonaccept=new JButton("SUBMIT");

        gbc.anchor=GridBagConstraints.NORTHWEST;
         gbc.gridx=1;
         gbc.gridy=5;
         gbobject.setConstraints(labelfname,gbc);  
         panel.add(labelfname);

         gbc.anchor=GridBagConstraints.NORTHWEST;
         gbc.gridx=4;
         gbc.gridy=5;
         gbobject.setConstraints(textfname,gbc);  
         panel.add(textfname);

         gbc.anchor=GridBagConstraints.NORTHWEST;
         gbc.gridx=1;
         gbc.gridy=10;
         gbobject.setConstraints(labellname,gbc);    
         panel.add(labellname);  

gbc.anchor=GridBagConstraints.NORTHWEST;  
         gbc.gridx=4;
         gbc.gridy=10;
         gbobject.setConstraints(textlname,gbc);     
          panel.add(textlname);

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
gbc.gridx=1;
         gbc.gridy=20;
         gbobject.setConstraints(labelphone,gbc);
         panel.add(labelphone);

        
gbc.anchor=GridBagConstraints.NORTHWEST;
gbc.gridx=4;
         gbc.gridy=20;
         gbobject.setConstraints(textphone,gbc);
         panel.add(textphone);

gbc.anchor=GridBagConstraints.NORTHWEST;
         gbc.gridx=1;
         gbc.gridy=25;
         gbobject.setConstraints(labelpassword,gbc);
panel.add(labelpassword);
gbc.anchor=GridBagConstraints.NORTHWEST;
gbc.gridx=4;
         gbc.gridy=25;
         gbobject.setConstraints(textpassword,gbc);
panel.add(textpassword);
        
gbc.anchor=GridBagConstraints.NORTHWEST;
gbc.gridx=10;
         gbc.gridy=50;
         gbobject.setConstraints(buttonaccept,gbc);
        panel.add(buttonaccept);   
frame.setSize(700,700);
         frame.setVisible(true);

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
//PreparedStatement stmt =conn.prepareStatement("insert into coderreport(empid,moduleid,source_filename,comments,date)values(?,?,?,?,?)");     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               //       Connection con;

//                      con=DriverManager.getConnection("jdbc:odbc:kk","","");
                     
                      PreparedStatement stat2=conn.prepareStatement("insert into Registration(cFirst_name,cLast_name,cEmpid,cPhone,cPassword) values(?,?,?,?,?)");

               stat2.setString(1,textfname.getText());
               stat2.setString(2,textlname.getText());
               stat2.setString(3,textempid.getText());
               stat2.setString(4,textphone.getText());
               stat2.setString(5,textpassword.getText()); 
               stat2.executeUpdate();

              JOptionPane.showMessageDialog (frame,new String("your details have been registered"));

              textfname.setText("");textlname.setText("");
              textphone.setText("");
              textpassword.setText("");
              textempid.setText("");



}      

   catch(Exception ex)
{
              JOptionPane.showMessageDialog (frame,new String("your details have been not registered: "+ex));
}
}
}
}
                                 


     


 




   



