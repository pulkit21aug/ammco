
 import java.awt.*;
 import java.awt.datatransfer.*;
import java.awt.event.*;
 
 import java.io.*;
class MenuFrame extends Frame {
 TextArea tar;
 MenuFrame(String a)
 {
  super(a);

  MenuBar mbar= new MenuBar();
  setMenuBar(mbar);

  Menu file =new Menu("file");
  MenuItem item1,item2,item3,item4,item5;
  file.add(item1 = new MenuItem("new"));
  file.add(item2 =new MenuItem("open"));
  file.add(item3 =new MenuItem("save"));
  file.add(item4 = new MenuItem("saveas"));
  file.add(item5 =new MenuItem("exit"));
  mbar.add(file);


  Menu edit =new Menu("edit");
  MenuItem item6,item7,item8,item9,item10;
  edit.add(item6 =new MenuItem("copy"));
  edit.add(item7 =new MenuItem("cut"));
  edit.add(item8 =new MenuItem("paste"));
  mbar.add(edit);

  Menu help = new Menu("help");
  help.add(item9 = new MenuItem("help"));
  help.add(item10 = new MenuItem("about"));
  mbar.add(help);

      tar =new TextArea(1699,1549);
     add(tar);
  


  Handler handler= new Handler(this);
  item1.addActionListener(handler);
  item2.addActionListener(handler);

     item3.addActionListener(handler);
 
   item4.addActionListener(handler);
 
    item5.addActionListener(handler);

     item6.addActionListener(handler);
     item7.addActionListener(handler);
    
   item8.addActionListener(handler);
  
   item9.addActionListener(handler);
       item10.addActionListener(handler);
  

  MyWindowAdapter adapter = new MyWindowAdapter(this);

  this.addWindowListener(adapter);
      
 
  }




}



class MyWindowAdapter extends WindowAdapter
{
 MenuFrame f;

 public MyWindowAdapter(MenuFrame f)
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
       MenuFrame menuFrame;
static Clipboard clipboard ;
 public Handler(MenuFrame menuFrame)
 {
 this.menuFrame = menuFrame;
 }

 public void actionPerformed(ActionEvent ae)
 {
  String arg=(String)ae.getActionCommand();
  if(arg.equals("new"))
  {
    MenuFrame  f1= new MenuFrame("my codebook");
    f1.setSize(700,550);
    f1.setVisible(true);
   }

 else if(arg.equals("exit"))
 {
  
  System.exit(0);
  }

 else if(arg.equals("open"))
 {
   
         
       try
          {    
         FileDialog fd =new FileDialog(this.menuFrame,"open_ur_code");
            fd.setVisible(true);
            String str =fd.getDirectory()+fd.getFile();
            
              menuFrame.setTitle(str);
               
              
             FileReader f = new FileReader(str);
             BufferedReader br =new BufferedReader(f);
                 String s =" ";
                 StringBuffer sb = new StringBuffer();
                while((s= br.readLine())!=null)
             {                      
                 sb=  sb.append(s);
                  sb.append("\r\n"); 
               
            }
              s =sb.toString();
              menuFrame.tar.setText(s);
              f.close();
           }catch(IOException e){
                 System.out.println(e); 
                      
                  
                  }  
            
            
                        
 }



else if(arg.equals("save"))
{
    String str3 = menuFrame.getTitle();
     if(str3.equals("my codebook"))
  {
     
       try
          { 
            


              
            FileDialog fd =new FileDialog(this.menuFrame,"open_ur_code");
            fd.setVisible(true);
            String str =fd.getDirectory()+fd.getFile();
               menuFrame.setTitle(str);
               
                String str2 =  menuFrame.tar.getText();
              
             FileWriter f = new FileWriter(str);
            f.write(str2);
            f.close();
           }catch(IOException e)
           { 
                     System.out.println(e); 
                    

                  }
   
    }

  else
  {
    try
      { 
      FileWriter f = new FileWriter(str3);
     String str2 = menuFrame.tar.getText();
     f.write(str2);
      f.close();  

        }catch(IOException e)
      {
         System.out.println(e);
        }
 
      }


  }






else if(arg.equals("saveas")) 
    {
   
        try
          { 
            


              
            FileDialog fd =new FileDialog(this.menuFrame,"open_ur_code");
            fd.setVisible(true);
            String str =fd.getDirectory()+fd.getFile();
               menuFrame.setTitle(str);
               
                String str2 =  menuFrame.tar.getText();
              
             FileWriter f = new FileWriter(str);
            f.write(str2);
            f.close();
           }catch(IOException e)
           { 
                     System.out.println(e); 
                    

                  }

           }

       

else if(arg.equals("copy"))
    {
          Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
          String text = menuFrame.tar.getSelectedText();
          if(text==null) text =menuFrame.tar.getText();
          StringSelection selection = new StringSelection(text);
         clipboard.setContents(selection,null);
    } 
 

else if(arg.equals("cut"))
    {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String text = menuFrame.tar.getSelectedText();
            String s = menuFrame.tar.getText().replace(text,"");
              
            
             menuFrame.tar.setText(s);  
        if(text==null) text =menuFrame.tar.getText();
          StringSelection selection = new StringSelection(text);
         clipboard.setContents(selection,null);
    } 
 








else if(arg.equals("paste"))
    { 
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
       DataFlavor flavor = DataFlavor.stringFlavor;
       if(clipboard.isDataFlavorAvailable(flavor))
        {
           try
             {
              String text =(String)clipboard.getData(flavor);               
              menuFrame.tar.append(text);
              
             }catch(UnsupportedFlavorException e)
                    { System.out.println(e);
                    }
             
               catch(IOException e){}
           }
         }   



else if(arg.equals("help"))
{
     MenuFrame  ft= new MenuFrame("my codebook");

    
   try
   {
          String str ="C:/ammco/sha.txt";
  
             FileReader f = new FileReader(str);
             BufferedReader br =new BufferedReader(f);
                 String s =" ";
                 StringBuffer sb = new StringBuffer();
                while((s= br.readLine())!=null)
             {                      
                 sb=  sb.append(s);
                  sb.append("\r\n"); 
               
            }
              s =sb.toString();
              menuFrame.tar.setText(s);
              f.close();
           }catch(IOException e){
                 System.out.println(e); 

               }

 ft.setSize(700,550);
    ft.setVisible(true);



}




else if(arg.equals("about"))
{
     MenuFrame  ft= new MenuFrame("my codebook");

    
   try
   {
          String str ="C:/ammco/mus.txt";
  
             FileReader f = new FileReader(str);
             BufferedReader br =new BufferedReader(f);
                 String s =" ";
                 StringBuffer sb = new StringBuffer();
                while((s= br.readLine())!=null)
             {                      
                 sb=  sb.append(s);
                  sb.append("\r\n"); 
               
            }
              s =sb.toString();
              menuFrame.tar.setText(s);
              f.close();
           }catch(IOException e){
                 System.out.println(e); 

               }

 ft.setSize(700,550);
    ft.setVisible(true);



}












         }
 }



















 public class codebook
  {
  
   public static void main(String a[])
   {
   MenuFrame  f= new MenuFrame("my codebook");

     f.setSize(700,550);
    f.setVisible(true);
    }
  }





