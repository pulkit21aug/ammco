
 import java.awt.*;
 import java.awt.datatransfer.*;
 import java.awt.event.*;
 import java.util.*;
 import java.io.*;
  class TestFrame extends Frame
{  TextArea tar;
   public static int words = 0;
   public static int lines = 0;
   public static int chars = 0;
    



 public TestFrame(String a)
  {
   super(a);
      MenuBar mbar=new MenuBar();
     setMenuBar(mbar);
     Menu file =new Menu("file");
  MenuItem item1,item2,item3,item4,item5,item6,item7;
  file.add(item1 = new MenuItem("new"));
  file.add(item2 =new MenuItem("test"));
  file.add(item3 =new MenuItem("report"));
  file.add(item4 =new MenuItem("exit"));
  mbar.add(file);
  
  Menu help = new Menu("help");
  
  help.add(item5 = new MenuItem("help"));
  help.add(item6 = new MenuItem("about"));
  mbar.add(help);
  
    tar = new TextArea(500,500);
    add(tar);

   Handler2 handler= new Handler2(this);
   item1.addActionListener(handler);
  item2.addActionListener(handler);

    item3.addActionListener(handler);
 
   item4.addActionListener(handler);
 
    item5.addActionListener(handler);

    item6.addActionListener(handler);







  MyWindowAdapter2 adapter = new MyWindowAdapter2(this);

  this.addWindowListener(adapter);
      

}
 public void wc(FileReader fr)throws IOException 
{
  StreamTokenizer tok = new StreamTokenizer(fr);
  tok.resetSyntax();
  tok.wordChars(33,255);
  tok.whitespaceChars(0,' ');
  tok.eolIsSignificant(true);     
 while(tok.nextToken() != tok.TT_EOF) 
 {
   switch (tok.ttype)
   {
    case StreamTokenizer.TT_EOL:
        lines++;
        chars++;
        break;
    case StreamTokenizer.TT_WORD:
    
         words++;
    default:
     chars +=tok.sval.length();
   break;

  }

}

 String sh =" ";
String str2 ="no. of lines are"+lines;
String str3 = "no . of words are"+words;
String str4 = "no. of chars are"+chars;
StringBuffer sb = new StringBuffer();

                 sb=  sb.append(str2);
                  sb.append("\r\n"); 
                sb = sb.append(str3);
            sb.append("\r\n"); 
           
        sb = sb.append(str4);

  sb.append("\r\n");
 sh = sb.toString();
tar.setText(sh); 

}

}

class Handler2 implements ActionListener
  {

   TestFrame f;
   
  public Handler2(TestFrame f)
   {
    this.f = f;
  }
   public void actionPerformed(ActionEvent ae)
  
{
  String arg = (String)ae.getActionCommand();
  if(arg.equals("new"))
 
    { 
  
  TestFrame f =new TestFrame("robotest");
 f.setSize(400,400);
 f.setVisible(true);
  }
 
else if(arg.equals("exit"))
{
  System.exit(0);
}
 

else if(arg.equals("report")){
try
{
dataFrame2 f =new dataFrame2("create report");
 f.setSize(800,150);
 f.setVisible(true);
}catch(Exception e)
{
 System.out.println(e);
}


}

else if(arg.equals("help"))
{
     TestFrame  f= new TestFrame("help from robotester");

     
   try
   {
          String str ="C:/ammco/sha.txt";
  
             FileReader fr = new FileReader(str);
             BufferedReader br =new BufferedReader(fr);
                 String s =" ";
                 StringBuffer sb = new StringBuffer();
                while((s= br.readLine())!=null)
             {                      
                 sb=  sb.append(s);
                  sb.append("\r\n"); 
               
            }
              s =sb.toString();
              f.tar.setText(s);
              fr.close();
           }catch(IOException e){
                 System.out.println(e); 

               }

 f.setSize(700,550);
    f.setVisible(true);



}

else if(arg.equals("test"))
 {
   
         
       try
          {    
         FileDialog fd =new FileDialog(this.f,"open_ur_code");
            fd.setVisible(true);
            String str =fd.getDirectory()+fd.getFile();
            
            f.setTitle(str);  
            FileReader fr = new FileReader(str);
                                    
           f.wc(fr);
           }catch(IOException e)
           { System.out.println(e);
          }
         





















}
else if(arg.equals("about"))
{
     TestFrame  f= new TestFrame("about robotester");
   
    
   try
   {
          String str ="C:/ammco/mus.txt";
  
             FileReader fr = new FileReader(str);
             BufferedReader br =new BufferedReader(fr);
                 String s =" ";
                 StringBuffer sb = new StringBuffer();
                while((s= br.readLine())!=null)
             {                      
                 sb=  sb.append(s);
                  sb.append("\r\n"); 
               
            }
              s =sb.toString();
              f.tar.setText(s);
              fr.close();
           }catch(IOException e){
                 System.out.println(e); 

               }

 f.setSize(700,550);
    f.setVisible(true);



}
































}

}



class MyWindowAdapter2 extends WindowAdapter
{
 TestFrame f;

 public MyWindowAdapter2(TestFrame f)
 {
  
  this.f = f;
   }

 public void windowClosing(WindowEvent we)
 {
  f.setVisible(false);
  }


 }
public class tester 
{
 public static void main(String a[])
 {
 TestFrame f =new TestFrame("robotest");
 f.setSize(400,400);
 f.setVisible(true);
}
} 
     
  
   