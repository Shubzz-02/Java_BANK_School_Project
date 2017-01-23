import java.io.*;
class Report extends Raw
{
    public void submit(String name,String s)
    {
        try
        {
            FileWriter FW=new FileWriter("report.txt",true);
            BufferedWriter BW=new BufferedWriter(FW);
            PrintWriter PW=new PrintWriter(BW);
            PW.println(name);
            PW.println(s);
            PW.close();
            BW.close();
            FW.close();
            System.out.println("Thanku For giving your valuable time");
            cont();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }    
    }
}   