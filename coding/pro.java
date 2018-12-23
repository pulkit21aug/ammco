import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer.*;
import java.util.*;

class designFrame extends JFrame
{ JPanel panel;
  JProgressBar  progressbar;
  JLabel lab;
  javax.swing.Timer activityMonitor;
  JTextArea textarea;
  SimulatedActivity activity;
 
public designFrame(String a)

{   super(a);
    setLayout(new FlowLayout());
    setTitle("ammco");
    panel = new JPanel();
    this.getContentPane().add(panel);
           
  
   progressbar = new JProgressBar(0,500);
     panel.add(progressbar);
       progressbar.setStringPainted(true);

     textarea =new JTextArea();
      panel.add(textarea);
      progressbar.setMaximum(500);
        activity = new SimulatedActivity(500);
        new Thread(activity).start();
         
        activityMonitor = new javax.swing.Timer(500,new ActionListener()
             {
                                               public void  actionPerformed(ActionEvent ae)
                                              {
                                                int current = activity.getCurrent();
                                                //textarea.append(current+"\n");
                                                progressbar.setStringPainted(!progressbar.isIndeterminate());
                                                 progressbar.setValue(current);
                                                if(current==activity.getTarget())
                                                {activityMonitor.stop();
                                                   System.out.println("i love u");
                                                     }
                                                 }
                                                        }  );
          
 
         activityMonitor.start();

      }

}


class SimulatedActivity implements Runnable
{
   int current;
    int target;  
         public SimulatedActivity(int t)
{ 
  current =0;
target = t;
}

public int getTarget()
{
 return target;
}

public int getCurrent()
{
 return current;
}
public void run()
{
 try
  {
 while (current < target)
{
  Thread.sleep(10);
  current=current+1;
}
}catch(InterruptedException e){System.out.println(e);}

}

}

   
public class pro
{
 public static void main(String a[])
{
 designFrame f = new designFrame("directory manager");
 f.setSize(800,300);

 f.setVisible(true);
}

}
 