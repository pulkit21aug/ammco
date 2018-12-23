import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;

class ser implements Serializable{
    String filename;
    String empid;
    File f;  
}

public class AppServer extends Thread 

{
 ServerSocket sr;
 public AppServer()
 {
  try
   {
     sr = new ServerSocket(1001);
    }
catch(IOException e)
{
 System.out.println(e);
 }
this.start();
}

public void run()
{
 try
  {
   while(true)
    {
      Socket client = sr.accept();
      Connect con = new Connect(client);
     }
  }catch(IOException e)
   {
  System.out.println(e);
  }
}
 public static void main(String a[])
 {
  new AppServer();
}
}

class Connect extends Thread
 {
   protected Socket netclient;
   protected ObjectInputStream fromclient;
   protected PrintStream toclient;
  
public Connect(Socket client)
{
 netclient = client;
  try
 {
  fromclient = new ObjectInputStream(netclient.getInputStream());
 toclient = new PrintStream(netclient.getOutputStream());
}catch(IOException e)

 {
 try
 {
  netclient.close();
  }
catch(IOException e1)
 {
 System.out.println(e1);
 return;
}
}
this.start();
}

public void run()
{
 ser cl;
 try
  {
   for(;;)
 {
  cl =(ser)fromclient.readObject();
   String str1 = "c:/";
   String dirname = str1+cl.empid;    
    File fs = new File(dirname);
    
      FileWriter ft = new FileWriter(dirname+File.separator+cl.filename);
           
  
    FileReader f1 = new FileReader(cl.f);
             BufferedReader br =new BufferedReader(f1);
                 String s =" ";
                 StringBuffer sb = new StringBuffer();
                while((s= br.readLine())!=null)
             {                        
                 sb=  sb.append(s);
                 sb.append("\r\n"); 
               
            }
              s =sb.toString();
           ft.write(s);
           ft.close();
           f1.close();
    
      
if(cl==null)
  break;
  toclient.println("recieved from client");
  }

}
catch(Exception e)
 {}
finally
{

 try
{
  netclient.close();
}catch(IOException e){}

}
}
} 

  
