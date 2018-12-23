import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;





class dirFrame extends JFrame 

{  
  JLabel lab1;
  JButton bt; 
  JPanel panel;
  JTextField text1; 
 


 public dirFrame(String a)
 {
   super(a);
   setLayout(new FlowLayout()); 
   panel = new JPanel();
   add(panel); 
   lab1 = new JLabel("enter emp_id");
   panel.add(lab1);
  
  text1 = new JTextField(10);
  panel.add(text1);

bt = new JButton("create");
   
   panel.add(bt); 
  

   MyWindowAdapter4 adapter = new MyWindowAdapter4(this);
   this.addWindowListener(adapter);
   Handler4 handler= new Handler4(this);
   bt.addActionListener(handler);
   

  

}



}







class MyWindowAdapter4 extends WindowAdapter
{
  dirFrame f;

    public MyWindowAdapter4(dirFrame f)
   {
  
     this.f = f;
    }

    public void windowClosing(WindowEvent we)
 {
     f.setVisible(false);
  }
}



class Handler4 implements ActionListener 
{ 
   dirFrame f;
  public Handler4(dirFrame f)
    {
    this.f = f;
     }

 public void actionPerformed(ActionEvent ae)


  {
    if(ae.getSource()==f.bt)

      {

    String str = f.text1.getText();
   String str1 ="C:/";
    String str2 =str1+str;
    File fl = new File(str2);
    fl.mkdir();
     JOptionPane.showMessageDialog(f,"directory created");
     f.text1.setText("");
      }

    } 

}


public class createdirectory
{

 public static void main(String a[])
{
 dirFrame f = new dirFrame("directory manager");
 f.setSize(400,100);
 f.setVisible(true);
}

}