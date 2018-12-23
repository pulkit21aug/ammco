 import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ser extends Object implements java.io.Serializable
{
    String empid;
    String filename; 
    File f;  

}


class ma extends Frame
 { TextField tt1;
   TextField tt2;
   public ma(String a)
{
  MenuBar mbar= new MenuBar();
  setMenuBar(mbar);
  setLayout(new FlowLayout());
  Label lab = new Label("empid");
   add(lab);
    tt1 = new TextField(20);
   add(tt1);
   Label lab2 = new Label("filename");
   add(lab2);
    tt2 = new TextField(20);
   add(tt2); 
  Button bt =  new Button("file_transfer");   

  add(bt);
  
 Handler5  handler= new Handler5(this);
  bt.addActionListener(handler);
  

  MyWindowAdapter5 adapter = new MyWindowAdapter5(this);

  this.addWindowListener(adapter);

}


  

}

  
class MyWindowAdapter5 extends WindowAdapter
{
 ma fr;

 public MyWindowAdapter5(ma fr)
 {
  
  this.fr = fr;
   }

 public void windowClosing(WindowEvent we)
 {
  fr.setVisible(false);
  }


 }

class Handler5 implements ActionListener 
{
       ma fr;
 public Handler5(ma fr)
 {
 this.fr = fr;
 }

 public void actionPerformed(ActionEvent ae)
 {
  String arg=(String)ae.getActionCommand();
   
 if(arg.equals("file_transfer"))
  


{
    
   
FileDialog fd =new FileDialog(this.fr,"open_ur_code");
            fd.setVisible(true);
            String str =fd.getDirectory()+fd.getFile();
            

     ser s = new ser();
      s.empid = fr.tt1.getText();
      s.filename = fr.tt2.getText();

s.f= new File(str);
   try
 {
  Socket toServer;
  toServer = new Socket(InetAddress.getLocalHost(),1001);
  ObjectOutputStream streamToServer = new ObjectOutputStream (toServer.getOutputStream());

  streamToServer.writeObject((ser)s);
  BufferedReader fromServer = new BufferedReader(new InputStreamReader(toServer.getInputStream()));
  String status = fromServer.readLine();
  System.out.println(status);
JOptionPane.showMessageDialog(fr,"filetransfered"+status);

fr.tt1.setText("");
fr.tt2.setText("");


}
catch(InvalidClassException e){
JOptionPane.showMessageDialog(fr,e);


}
 catch(NotSerializableException e){
JOptionPane.showMessageDialog(fr,e);


}
 catch(IOException e){
JOptionPane.showMessageDialog(fr,"error contact vendor");


}
}



   }

}
public class pul

{
  
public static void main(String a[])


{  
 ma sh = new ma("start file transfer");
  sh.setSize(800,100);
 sh.setVisible(true);
   
            
  

}
}   